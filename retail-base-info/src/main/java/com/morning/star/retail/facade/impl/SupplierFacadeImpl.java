package com.morning.star.retail.facade.impl;

import com.github.pagehelper.PageHelper;
import com.morning.star.retail.RabbitConfig;
import com.morning.star.retail.admin.facade.SupplierAccountFacade;
import com.morning.star.retail.base.enums.SupplierApplyStatusEnum;
import com.morning.star.retail.base.enums.SupplierStatusEnum;
import com.morning.star.retail.base.enums.SupplierTypeEnum;
import com.morning.star.retail.base.page.PageBeans;
import com.morning.star.retail.base.sms.CaptchaDTO;
import com.morning.star.retail.base.sms.SmsRemoteService;
import com.morning.star.retail.consts.RetailDefaultConst;
import com.morning.star.retail.dao.SupplierDAO;
import com.morning.star.retail.dto.*;
import com.morning.star.retail.dto.group.GroupInfoDTO;
import com.morning.star.retail.dto.store.StoreDTO;
import com.morning.star.retail.entity.SupplierApplyEntity;
import com.morning.star.retail.entity.SupplierEntity;
import com.morning.star.retail.entity.SupplierItemEntity;
import com.morning.star.retail.entity.SupplierStoreEntity;
import com.morning.star.retail.entity.repository.SupplierApplyRespository;
import com.morning.star.retail.entity.repository.SupplierItemRespository;
import com.morning.star.retail.entity.repository.SupplierRespository;
import com.morning.star.retail.entity.repository.SupplierStoreRespository;
import com.morning.star.retail.facade.GroupFacade;
import com.morning.star.retail.facade.SupplierFacade;
import com.morning.star.retail.facade.dto.ProductDTO;
import com.morning.star.retail.facade.dto.SupplierWmsDTO;
import com.morning.star.retail.helper.MqHelperService;
import com.morning.star.retail.helper.StoreService;
import com.morning.star.retail.helperservice.ProductHelpService;
import com.morning.star.retail.objectcopier.ObjectCopier;
import com.morning.star.retail.util.StringUtil;
import com.morning.star.retail.utils.entity.BeanUtils;
import com.morning.star.retail.utils.entity.DeleteFlagEnum;
import org.apache.commons.lang3.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class SupplierFacadeImpl implements SupplierFacade {

	private static String ENTERING_CAPTCHA = "SUPPLIER_ENTERING";

	@Autowired
	private SupplierDAO supplierDAO;
	@Autowired
	private SupplierRespository supplierRespository;
	@Autowired
	private SupplierApplyRespository supplierApplyRespository;
	@Autowired
	private SupplierStoreRespository supplierStoreRespository;
	@Autowired
	private SupplierItemRespository supplierItemRespository;
	@Autowired
	private ProductHelpService productHelpService;
	@Autowired
	private SmsRemoteService smsRemoteService;
	@Autowired
	private StoreService storeService;
	@Autowired
	private GroupFacade groupFacade;

	@Autowired
	private SupplierAccountFacade supplierAccountFacade;

	@Autowired
	private MqHelperService mqHelperService;
	@Autowired
	private RabbitConfig rabbitConfig;

	@Value("${supplier-apply-success-sms}")
	private String supplierApplySuccessSms;

	@Override
	public void captcha(String mobile) {
		smsRemoteService.sendCaptcha(mobile, ENTERING_CAPTCHA);
	}

	@Override
	public SupplierApplyDTO checkCaptcha(CaptchaDTO dto) {
		smsRemoteService.checkCaptcha(dto.getMobile(), dto.getCaptcha(), ENTERING_CAPTCHA);
		// 检查手机号是否已经注册
		SupplierApplyDTO applyDTO = supplierDAO.getSupplierApplyByMobile(dto.getMobile());
		if (applyDTO == null) {
			applyDTO = new SupplierApplyDTO();
			applyDTO.setStatus(100);
		}
		return applyDTO;
	}

	@Override
	public void submit(SupplierSubmitDTO dto) {
		// 检查供应商名称是否已申请
		checkApplyByName(dto.getSupplierName());

		checkSupplierExist(dto.getSupplierName());
		checkMobile(dto.getMobile());

		SupplierApplyEntity entity = ObjectCopier.copyObject(SupplierApplyEntity.class, dto);
		entity.setStatus(SupplierApplyStatusEnum.SUBMIT.getCode());

		GroupInfoDTO defaultGroup = groupFacade.getDefault();
		Validate.isTrue(defaultGroup != null, "默认集团不存在");
		entity.setGroupCode(defaultGroup.getGroupCode());

		if (dto.getPermanentCityId() == RetailDefaultConst.DEFAULT_CITY_ID) {
			entity.setPermanentCityName(RetailDefaultConst.DEFAULT_CITY_NAME);
			entity.setType(SupplierTypeEnum.HEAD.getCode());
		} else {
			StoreDTO storeDTO = storeService.getStoreByCityId(dto.getPermanentCityId(), defaultGroup.getGroupCode());
			Validate.notNull(storeDTO, "未找到该入驻城市的相关分公司信息");
			entity.setStoreCode(storeDTO.getStoreCode());
			entity.setType(SupplierTypeEnum.BRANCH.getCode());
		}
		supplierApplyRespository.save(entity);
	}

	@Override
	public PageBeans<SupplierApplyDTO> listApply(SupplierQueryDTO queryDTO) {
		PageHelper.startPage(queryDTO.getPageNo(), queryDTO.getPageSize());
		List<SupplierApplyDTO> list = supplierDAO.querySupplierApplyByPage(queryDTO);
		return new PageBeans<>(list);
	}

	@Override
	public SupplierApplyDTO getApply(Long id) {
		SupplierApplyEntity entity = checkGetApplyById(id);
		return ObjectCopier.copyObject(SupplierApplyDTO.class, entity);
	}

	@Override
	public void create(SupplierCreateDTO dto) {
		// 检查供应商手机号和名称是否已申请
		checkApplyByMobile(dto.getMobile());
		checkApplyByName(dto.getSupplierName());

		checkSupplierExist(dto.getSupplierName());
		checkMobile(dto.getMobile());

		SupplierEntity entity = ObjectCopier.copyObject(SupplierEntity.class, dto);
		entity.setStatus(SupplierStatusEnum.ENABLE.getCode());
		GroupInfoDTO defaultGroup = groupFacade.getDefault();
		Validate.isTrue(defaultGroup != null, "默认集团不存在");
		entity.setGroupCode(defaultGroup.getGroupCode());

		if (dto.getPermanentCityId() == RetailDefaultConst.DEFAULT_CITY_ID) {
			entity.setPermanentCityName(RetailDefaultConst.DEFAULT_CITY_NAME);
			entity.setType(SupplierTypeEnum.HEAD.getCode());
		} else {
			StoreDTO storeDTO = storeService.getStoreByCityId(dto.getPermanentCityId(), defaultGroup.getGroupCode());
			Validate.notNull(storeDTO, "未找到该入驻城市的相关分公司信息");
			entity.setStoreCode(storeDTO.getStoreCode());
			entity.setType(SupplierTypeEnum.BRANCH.getCode());
		}

		String supplierCode = code(dto.getCategoryId(), dto.getCityCode(), dto.getContractYear());
		checkSupplierCode(supplierCode);
		entity.setSupplierCode(supplierCode);
		supplierRespository.save(entity);

		// 同步供应商到 WMS
		SupplierWmsDTO wms = SupplierEntity.toWmsDTO(entity);
		mqHelperService.send(rabbitConfig.getExchange(), rabbitConfig.getCreateSupplierQueue(), wms);

		// 添加供应商账号
		supplierAccountFacade.addAccount(SupplierEntity.toAccountDTO(entity));
		smsRemoteService.sendMessage(entity.getMobile(), supplierApplySuccessSms);
	}

	/**
	 * 检查供应商手机号是否已申请
	 *
	 * @param mobile
	 */
	private void checkApplyByMobile(String mobile) {
		SupplierApplyDTO applyDTO = supplierDAO.getSupplierApplyByMobile(mobile);
		if (applyDTO != null) {
			Validate.isTrue(!SupplierApplyStatusEnum.SUBMIT.getCode().equals(applyDTO.getStatus()), "该手机号正在审核中");
			Validate.isTrue(!SupplierApplyStatusEnum.AUTH_PASS.getCode().equals(applyDTO.getStatus()), "该手机号系统中已存在");
		}
	}

	/**
	 * 检查供应商名称是否已申请
	 *
	 * @param supplierName
	 */
	private void checkApplyByName(String supplierName) {
		SupplierApplyDTO applyDTO = supplierDAO.getSupplierApplyByName(supplierName);
		if (applyDTO != null) {
			Validate.isTrue(!SupplierApplyStatusEnum.SUBMIT.getCode().equals(applyDTO.getStatus()), "该供应商名称正在审核中");
			Validate.isTrue(!SupplierApplyStatusEnum.AUTH_PASS.getCode().equals(applyDTO.getStatus()), "该供应商名称系统中已存在");
		}
	}

	/**
	 * 检查手机号是否可用
	 *
	 * @param mobile
	 */
	private void checkMobile(String mobile) {
		int count = supplierRespository.countByMobile(mobile);
		Validate.isTrue(count == 0, "该手机号已被其他供应商使用");
	}

	/**
	 * 生成供应商编码
	 *
	 * @param categoryId
	 * @param cityCode
	 * @param contractYear
	 * @return
	 */
	private String code(Long categoryId, String cityCode, Integer contractYear) {
		Long count = supplierDAO.getSupplierMaxId();
		return categoryId + cityCode + String.valueOf(contractYear).substring(2) + String.format("%04d", count + 1);
	}

	/**
	 * 检查供应商编码是否被使用
	 *
	 * @param supplierCode
	 */
	private void checkSupplierCode(String supplierCode) {
		SupplierEntity entity = supplierRespository.getBySupplierCode(supplierCode);
		Validate.isTrue(entity == null, "该供应商编码已被使用");
	}

	/**
	 * 检查集团供应商信息
	 *
	 * @param supplierCode
	 * @return
	 */
	private SupplierEntity checkGetSupplier(String supplierCode) {
		SupplierEntity entity = supplierRespository.getBySupplierCode(supplierCode);
		Validate.isTrue(entity != null, String.format("未找到该供应商【编码：%s】信息", supplierCode));
		return entity;
	}

	/**
	 * 检查供应商是否已存在
	 *
	 * @param supplierName
	 */
	private void checkSupplierExist(String supplierName) {
		SupplierEntity entity = supplierRespository.getBySupplierName(supplierName);
		Validate.isTrue(entity == null, "该供应商名称已被使用");
	}

	@Override
	public void modify(SupplierDTO dto) {
	}

	@Override
	public void modifyStatus(SupplierModifyDTO dto) {
		SupplierEntity entity = checkGetSupplier(dto.getSupplierCode());
		entity.setStatus(dto.getStatus());
		supplierRespository.save(entity);
	}

	@Override
	public void delete(String supplierCode, String groupCode) {
		SupplierEntity entity = checkGetSupplier(supplierCode);
		entity.setDeleteFlag(DeleteFlagEnum.DELETE.getCode());
		supplierRespository.save(entity);
	}

	@Override
	public PageBeans<SupplierDTO> list(SupplierQueryDTO queryDTO) {
		PageHelper.startPage(queryDTO.getPageNo(), queryDTO.getPageSize());
		List<SupplierDTO> list = supplierDAO.querySupplierByPage(queryDTO);
		return new PageBeans<>(list);
	}

	@Override
	public SupplierDTO get(Long id) {
		SupplierEntity entity = checkGetById(id);
		return ObjectCopier.copyObject(SupplierDTO.class, entity);
	}

	@Override
	public SupplierDTO get(String supplierCode) {
		SupplierEntity entity = checkGetSupplier(supplierCode);
		return ObjectCopier.copyObject(SupplierDTO.class, entity);
	}

	@Override
	@Transactional
	public void authPass(SupplierAuthPassDTO dto) {
		checkSupplierExist(dto.getSupplierName());

		SupplierApplyEntity applyEntity = checkGetApplyById(dto.getId());
		Validate.isTrue(SupplierApplyStatusEnum.SUBMIT.getCode().equals(applyEntity.getStatus()), "该供应商已被审核，不能再次执行审核操作");

		applyEntity.setStatus(SupplierApplyStatusEnum.AUTH_PASS.getCode());
		applyEntity.setRemark(dto.getRemark());
		supplierApplyRespository.save(applyEntity);

		String supplierCode = code(dto.getCategoryId(), dto.getCityCode(), dto.getContractYear());
		checkSupplierCode(supplierCode);

		SupplierEntity entity = ObjectCopier.copyObject(SupplierEntity.class, dto);
		entity.setSupplierCode(supplierCode);
		entity.setMobile(applyEntity.getMobile());
		entity.setGroupCode(applyEntity.getGroupCode());
		entity.setStoreCode(applyEntity.getStoreCode());
		entity.setType(applyEntity.getType());
		entity.setStatus(SupplierStatusEnum.ENABLE.getCode());
		entity.setRemark(dto.getRemark());
		supplierRespository.save(entity);

		// 同步供应商到WMS
		SupplierWmsDTO wms = SupplierEntity.toWmsDTO(entity);
		mqHelperService.send(rabbitConfig.getExchange(), rabbitConfig.getCreateSupplierQueue(), wms);

		// 添加供应商账号
		supplierAccountFacade.addAccount(SupplierEntity.toAccountDTO(entity));
		smsRemoteService.sendMessage(entity.getMobile(), supplierApplySuccessSms);
	}

	@Override
	public void authFail(SupplierAuthFailDTO dto) {
		SupplierApplyEntity entity = checkGetApplyById(dto.getId());
		Validate.isTrue(SupplierApplyStatusEnum.SUBMIT.getCode().equals(entity.getStatus()), "该供应商已被审核，不能再次执行审核操作");

		entity.setStatus(SupplierApplyStatusEnum.AUTH_FAIL.getCode());
		entity.setReason(dto.getReason());
		entity.setRemark(dto.getRemark());
		supplierApplyRespository.save(entity);

		smsRemoteService.sendMessage(entity.getMobile(), String.format("您申请的供应商资质审核未通过！拒绝理由：%s，感谢您申请，有问题请与采购联系", dto.getReason()));
	}

	/**
	 * 检查供应商信息
	 *
	 * @param id
	 * @return
	 */
	private SupplierEntity checkGetById(long id) {
		SupplierEntity entity = supplierRespository.getById(id);
		Validate.notNull(entity, "未找到该供应商信息");
		return entity;
	}

	/**
	 * 检查供应商申请信息
	 *
	 * @param id
	 * @return
	 */
	private SupplierApplyEntity checkGetApplyById(long id) {
		SupplierApplyEntity entity = supplierApplyRespository.getById(id);
		Validate.notNull(entity, "未找到该供应商申请信息");
		return entity;
	}

	@Override
	public List<SupplierDTO> queryByUpc(SupplierQueryDTO queryDTO) {
		return supplierDAO.querySupplierByUpc(queryDTO);
	}

	@Override
	public SupplierDTO get(String supplierCode, String groupCode) {
		SupplierEntity entity = supplierRespository.getBySupplierCode(supplierCode);
		if (entity != null) {
			SupplierDTO dto = new SupplierDTO();
			BeanUtils.copy(entity, dto);
			return dto;
		}
		return new SupplierDTO();
	}

	@Override
	public void createStore(SupplierStoreDTO dto) {
		SupplierStoreEntity entity = supplierStoreRespository.getBySupplierCodeAndStoreCode(dto.getSupplierCode(), dto.getStoreCode());
		Validate.isTrue(entity == null, "该供应商门店已存在");
		entity = new SupplierStoreEntity();
		BeanUtils.copy(dto, entity);
		supplierStoreRespository.save(entity);
	}

	@Override
	public void deleteStore(SupplierStoreDTO dto) {
		SupplierStoreEntity entity = supplierStoreRespository.getBySupplierCodeAndStoreCode(dto.getSupplierCode(), dto.getStoreCode());
		Validate.isTrue(entity != null, "未找到该供应商门店信息");
		entity.setDeleteFlag(DeleteFlagEnum.DELETE.getCode());
		supplierStoreRespository.save(entity);
	}

	@Override
	public PageBeans<SupplierStoreDTO> listStore(SupplierQueryDTO queryDTO) {
		PageHelper.startPage(queryDTO.getPageNo(), queryDTO.getPageSize());
		List<SupplierStoreDTO> list = supplierDAO.querySupplierStoreByPage(queryDTO);
		return new PageBeans<>(list);
	}

	@Override
	public void createItem(SupplierItemFormDTO formDTO) {
		checkRepeatData(formDTO.getCreateItems());
		checkGetSupplier(formDTO.getSupplierCode());

		formDTO.getCreateItems().forEach(item -> {
			SupplierItemEntity entity = supplierItemRespository.getBySupplierCodeAndSapProductCode(formDTO.getSupplierCode(), item.getSapProductCode());
			Validate.isTrue(entity == null, String.format("该供应货品【SAP编码：%s】已存在", item.getSapProductCode()));
			supplierItemRespository.save(toSupplierItemEntity(formDTO, item));
		});
	}

	/**
	 * 检查重复提交数据
	 *
	 * @param list
	 */
	private void checkRepeatData(List<SupplierItemSaveDTO> list) {
		Map<String, Long> map = list.stream().collect(Collectors.groupingBy(SupplierItemSaveDTO::getSapProductCode, Collectors.counting()));
		StringBuilder goodsCodes = new StringBuilder();
		map.forEach((k, v) -> {
			if (v > 1) {
				goodsCodes.append(k).append("，");
			}
		});

		org.apache.commons.lang.Validate.isTrue(org.apache.commons.lang.StringUtils.isBlank(goodsCodes.toString()), String.format("提交货品【SAP编码：%s】存在重复，请检查", StringUtil.removeLastSpliter(goodsCodes.toString(), "，")));
	}

	/**
	 * 数据转换
	 *
	 * @param formDTO
	 * @return
	 */
	private SupplierItemEntity toSupplierItemEntity(SupplierItemFormDTO formDTO, SupplierItemSaveDTO itemSaveDTO) {
		ProductDTO productDTO = productHelpService.checkGetBySAP(itemSaveDTO.getSapProductCode(), formDTO.getGroupCode());
		SupplierItemEntity entity = new SupplierItemEntity();
		BeanUtils.copy(productDTO, entity);

		entity.setSupplierCode(formDTO.getSupplierCode());
		entity.setTaxRate(itemSaveDTO.getTaxRate());
		entity.setPrice(itemSaveDTO.getPrice());

		entity.setProductCode(productDTO.getProductCode());
		entity.setProductName(productDTO.getProductName());
		entity.setUnits(productDTO.getUnitsName());
		return entity;
	}

	@Override
	public void modifyItem(SupplierItemFormDTO formDTO) {
		SupplierItemSaveDTO itemSaveDTO = formDTO.getModifyItem();
		SupplierItemEntity entity = checkGetItem(formDTO.getSupplierCode(), itemSaveDTO.getSapProductCode());
		entity.setTaxRate(itemSaveDTO.getTaxRate());
		entity.setPrice(itemSaveDTO.getPrice());
		supplierItemRespository.save(entity);
	}

	/**
	 * 检查供应货品
	 *
	 * @param supplierCode
	 * @param sapProductCode
	 * @return
	 */
	private SupplierItemEntity checkGetItem(String supplierCode, String sapProductCode) {
		SupplierItemEntity entity = supplierItemRespository.getBySupplierCodeAndSapProductCode(supplierCode, sapProductCode);
		Validate.isTrue(entity != null, String.format("该供应货品【SAP编码：%s】不存在", sapProductCode));
		return entity;
	}

	@Override
	public void deleteItem(SupplierItemDeleteDTO dto) {
		SupplierItemEntity entity = checkGetItem(dto.getSupplierCode(), dto.getSapProductCode());
		entity.setDeleteFlag(DeleteFlagEnum.DELETE.getCode());
		supplierItemRespository.save(entity);
	}

	@Override
	public PageBeans<SupplierItemDTO> listItem(SupplierQueryDTO queryDTO) {
		PageHelper.startPage(queryDTO.getPageNo(), queryDTO.getPageSize());
		List<SupplierItemDTO> list = supplierDAO.querySupplierItemByPage(queryDTO);
		return new PageBeans<>(list);
	}

	@Override
	public SupplierItemDTO getItem(SupplierQueryDTO queryDTO) {
		return null;
	}

	@Override
	public List<SupplierItemDTO> queryItem(SupplierQueryDTO queryDTO) {
		return null;
	}

	@Override
	public List<ExportSuppilerItemDTO> queryExportItem(String supplierCode) {
		List<SupplierItemEntity> list = supplierItemRespository.getBySupplierCode(supplierCode);
		List<ExportSuppilerItemDTO> items = new ArrayList<>(list.size());
		list.forEach(entity -> {
			ExportSuppilerItemDTO item = new ExportSuppilerItemDTO();
			BeanUtils.copy(entity, item);
			items.add(item);
		});
		return items;
	}

}
