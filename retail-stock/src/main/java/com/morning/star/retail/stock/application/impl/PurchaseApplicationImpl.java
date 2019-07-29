package com.morning.star.retail.stock.application.impl;

import com.morning.star.retail.base.enums.SupplierStatusEnum;
import com.morning.star.retail.consts.RetailDefaultConst;
import com.morning.star.retail.facade.dto.purchase.*;
import com.morning.star.retail.stock.application.PurchaseApplication;
import com.morning.star.retail.stock.entity.PurchaseInOrderEntity;
import com.morning.star.retail.stock.entity.PurchaseOrderDetailEntity;
import com.morning.star.retail.stock.entity.PurchaseOrderEntity;
import com.morning.star.retail.stock.entity.PurchaseWaterEntity;
import com.morning.star.retail.stock.entity.repository.PurchaseInOrderRepository;
import com.morning.star.retail.stock.entity.repository.PurchaseOrderDetailRepository;
import com.morning.star.retail.stock.entity.repository.PurchaseOrderRepository;
import com.morning.star.retail.stock.entity.repository.WaterRepository;
import com.morning.star.retail.stock.enums.PurchaseStatusEnum;
import com.morning.star.retail.stock.enums.PurchaseSubmitEnum;
import com.morning.star.retail.stock.helper.*;
import com.morning.star.retail.stock.helper.vo.*;
import com.morning.star.retail.user.UserInfo;
import com.morning.star.retail.user.UserPermission;
import com.morning.star.retail.user.UserUtils;
import com.morning.star.retail.util.UniqueNoUtils;
import com.morning.star.retail.util.UniqueNoUtils.UniqueNoType;
import com.morning.star.retail.utils.entity.BeanUtils;
import com.morning.star.retail.utils.entity.DeleteFlagEnum;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang3.Validate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class PurchaseApplicationImpl implements PurchaseApplication {
	private Logger log = LoggerFactory.getLogger(PurchaseApplicationImpl.class);

	@Autowired
	private WaterRepository waterRepository;

	@Autowired
	private PurchaseOrderRepository purchaseOrderRepository;

	@Autowired
	private PurchaseOrderDetailRepository purchaseOrderDetailRepository;

	@Autowired
	private PurchaseInOrderRepository purchaseInOrderRepository;

	@Autowired
	private SupplierService supplierService;

	@Autowired
	private StockGoodsHelper goodsService;
	@Autowired
	private ProductService productService;
	@Autowired
	private StoreService storeService;
	@Autowired
	private WarehouseService warehouseService;


	private void saveWater(PurchaseOrderEntity entity, String remark) {
		waterRepository.save(entity, PurchaseWaterEntity.class, remark);
	}

	@Override
	@Transactional
	public String submitOrder(PurchaseSubmitDTO purchaseSubmitDTO) {
		List<PurchaseDetailSubmitDTO> orderDetailList = purchaseSubmitDTO.getOrderDetail();
		Validate.notEmpty(purchaseSubmitDTO.getOrderDetail(), "采购订单请添加商品明细");
		checkDetailSubmit(orderDetailList);

		PurchaseOrderEntity purchaseOrder = new PurchaseOrderEntity();
		String purchaseCode;
		// 草稿和审核失败的采购单重新提交
		if (StringUtils.isNotBlank(purchaseSubmitDTO.getPurchaseCode())) {
			purchaseOrder = purchaseOrderRepository.getByPurchaseCode(purchaseSubmitDTO.getPurchaseCode());
			Validate.notNull(purchaseOrder, "采购单不存在");

			// 判断重新提交的采购单是否是草稿或审核失败的单
			Validate.isTrue(PurchaseStatusEnum.PREPARE_DRAFT.equals(purchaseOrder.getStatus()) ||
					PurchaseStatusEnum.AUDIT_REJECT.equals(purchaseOrder.getStatus()),
				"该采购单不允许操作");
			purchaseCode = purchaseOrder.getPurchaseCode();

			// 总部和门店只能重新提交各自的采购单
			if (PurchaseSubmitEnum.GROUP.equals(purchaseOrder.getSubmitType())) {
				new UserPermission(UserUtils.currentUser())
					.tag("groupCode", purchaseOrder.getGroupCode())
					.msg("无权限编辑该采购单").pass();
			} else {
				new UserPermission(UserUtils.currentUser())
					.tag("storeCode", purchaseOrder.getStoreCode())
					.msg("无权限编辑该采购单").pass();
			}
		} else {
			purchaseCode = UniqueNoUtils.nextInc(UniqueNoType.PR, 5);
			purchaseOrder.setPurchaseCode(purchaseCode);
		}
		checkSupplier(purchaseSubmitDTO.getGroupCode(), purchaseSubmitDTO.getSupplierCode());

		// 采购供应商信息校验
		SupplierInfo supplierInfo = supplierService.getSupplierInfo(purchaseSubmitDTO.getGroupCode(), purchaseSubmitDTO.getSupplierCode());
		Validate.isTrue(supplierInfo != null, "供应商信息不存在：" + purchaseSubmitDTO.getSupplierCode());
		purchaseOrder.formSubmit(purchaseSubmitDTO, supplierInfo);

		// 门店提交  设置城市信息
		if (purchaseOrder.getSubmitType().equals(PurchaseSubmitEnum.STORE)) {
			StoreInfo storeInfo = storeService.getStore(purchaseSubmitDTO.getStoreCode());
			Validate.isTrue(storeInfo != null, "分城市信息不存在：" + purchaseSubmitDTO.getStoreCode());
			purchaseOrder.setCityId(storeInfo.getCityId());
			purchaseOrder.setCityName(storeInfo.getCityName());
			purchaseOrder.setStoreCode(storeInfo.getStoreCode());
			purchaseOrder.setStoreName(storeInfo.getStoreName());
		} else {
			purchaseOrder.setCityId(RetailDefaultConst.DEFAULT_CITY_ID);
			purchaseOrder.setCityName(RetailDefaultConst.DEFAULT_CITY_NAME);
		}

		// 采购详情信息校验提取
		List<PurchaseOrderDetailEntity> purchaseOrderDetailEntities = orderDetailList.stream()
			.map(e -> getPurchaseDetail(e, purchaseCode, purchaseSubmitDTO.getGroupCode(), purchaseSubmitDTO.getStoreCode()))
			.collect(Collectors.toList());

		// 设置采购订单信息
		BigDecimal amount = BigDecimal.ZERO;
		BigDecimal rateAmount = BigDecimal.ZERO;
		for (PurchaseOrderDetailEntity detail : purchaseOrderDetailEntities) {
			amount = amount.add(detail.getAmount());
			rateAmount = rateAmount.add(detail.getRateAmount());
		}

		purchaseOrder.setAmount(amount);
		purchaseOrder.setRateAmount(rateAmount);

		UserInfo userInfo = UserUtils.currentUser();
		if (userInfo != null) {
			purchaseOrder.setCreatorId(userInfo.getId().toString());
			purchaseOrder.setCreatorName(userInfo.getName());
		}

		purchaseOrder.setTransStatus(0);
		purchaseOrder.setLocalSend(purchaseSubmitDTO.getLocalSend());
		purchaseOrder.setPurchaseCode(purchaseCode);
		if (StringUtils.isNotBlank(purchaseSubmitDTO.getPurchaseCode())) {
			purchaseOrder.getDetailEntityList().clear();
			purchaseOrder.getDetailEntityList().addAll(purchaseOrderDetailEntities);
		} else {
			purchaseOrder.setDetailEntityList(purchaseOrderDetailEntities);
		}
		purchaseOrderRepository.save(purchaseOrder);
		if (purchaseSubmitDTO.getIsDraft() != 1) {
			saveWater(purchaseOrder, "新增采购单");
		}

		return purchaseCode;
	}

	/**
	 * 校验提交采购单详情数据是否存在重复数据
	 */
	private void checkDetailSubmit(List<PurchaseDetailSubmitDTO> detailSubmitDTOList) {
		Set<String> repeatSet = new HashSet<>();
		detailSubmitDTOList.forEach(e -> {
			String key = e.getProductCode() + "_" + e.getWarehouseCode();
			Validate.isTrue(!repeatSet.contains(key), "重复详情提交:%s", key);
			repeatSet.add(key);
		});
	}

	/**
	 * 根据采购提交详情获取校验采购详情信息
	 *
	 * @param detail       采购提交信息
	 * @param purchaseCode 采购单号
	 * @param groupCode    集团编码
	 * @param storeCode    门店编码
	 * @return 返回采购详情
	 */
	private PurchaseOrderDetailEntity getPurchaseDetail(PurchaseDetailSubmitDTO detail, String purchaseCode, String groupCode, String storeCode) {
		String productCode = detail.getProductCode();
		Validate.notEmpty(productCode, "货品编码不能为空");

		PurchaseOrderDetailEntity detailEntity;
		StoreInfo storeInfo;
		WarehouseInfo warehouseInfo;
		GoodsInfo goodsInfo;

		// 仓库信息
		warehouseInfo = warehouseService.get(detail.getWarehouseCode());
		Validate.notNull(warehouseInfo, "仓库信息不存在：" + detail.getWarehouseCode());

		// 采购门店信息
		if (StringUtils.isBlank(storeCode)) {
			storeInfo = storeService.getStoreByCity(groupCode, warehouseInfo.getCityId());
		} else {
			storeInfo = storeService.getStore(storeCode);
		}
		Validate.isTrue(storeInfo != null, "门店信息不存在：" + warehouseInfo.getCityId());

		// 校验采购商品门店城市信息和仓库城市信息一致
		Validate.isTrue(warehouseInfo.getCityId().equals(storeInfo.getCityId()),
			"城市信息不匹配：（%s/%s）", warehouseInfo.getCityId(), storeInfo.getCityId());

		// 采购商品信息
		goodsInfo = goodsService.getGoods(storeInfo.getStoreCode(), productCode);
		Validate.isTrue(goodsInfo != null, "门店【%s】未引入该货品【%s】", storeInfo.getStoreCode(), productCode);

		detailEntity = PurchaseOrderDetailEntity.formSubmit(detail);
		detailEntity.setPurchaseCode(purchaseCode);
		detailEntity.fillGoodsInfo(goodsInfo);
		detailEntity.fillStoreInfo(storeInfo);
		detailEntity.fillWarehouseInfo(warehouseInfo);

		return detailEntity;
	}

	@Override
	public List<String> checkSupplierRelationship(PurchaseOrderDTO purchaseOrderDTO) {
		List<PurchaseOrderDetailDTO> orderDetailList = purchaseOrderDTO.getOrderDetail();
		List<String> detail = new ArrayList<>();
		for (PurchaseOrderDetailDTO orderDetail : orderDetailList) {
			Boolean checkSupplier = checkSupplier(orderDetail.getProductCode(), purchaseOrderDTO.getSupplierCode(), purchaseOrderDTO.getGroupCode());
			if (!checkSupplier) {
				detail.add(orderDetail.getUpcCode() + '/' + orderDetail.getProductName());
			}
		}
		return detail;
	}

	@Override
	@Transactional
	public String updateOrder(PurchaseUpdateDTO purchaseUpdateDTO) {
		List<PurchaseDetailSubmitDTO> orderDetailList = purchaseUpdateDTO.getOrderDetail();
		Validate.notEmpty(orderDetailList, "采购订单请添加商品明细");

		String groupCode = purchaseUpdateDTO.getGroupCode();
		String purchaseCode = purchaseUpdateDTO.getPurchaseCode();

		PurchaseOrderEntity purchaseOrder = purchaseOrderRepository.getByPurchaseCode(purchaseCode);

		Validate.notNull(purchaseOrder, "采购单不存在");
		if (purchaseOrder.getSubmitType().equals(PurchaseSubmitEnum.GROUP)) {
			new UserPermission(UserUtils.currentUser())
				.tag("groupCode", purchaseOrder.getGroupCode())
				.msg("不允许更新该采购单：" + purchaseCode).pass();
		} else {
			new UserPermission(UserUtils.currentUser())
				.tag("storeCode", purchaseOrder.getStoreCode())
				.msg("不允许更新该采购单：" + purchaseCode).pass();
		}


		Validate.isTrue(PurchaseStatusEnum.PREPARE_DRAFT.equals(purchaseOrder.getStatus()),
			"该采购单不允许操作");

		checkSupplier(purchaseUpdateDTO.getGroupCode(), purchaseUpdateDTO.getSupplierCode());

		BeanUtils.copy(purchaseUpdateDTO, purchaseOrder);

		checkDetailSubmit(orderDetailList);
		List<PurchaseOrderDetailEntity> purchaseOrderDetailEntities = orderDetailList.stream()
			.map(e -> getPurchaseDetail(e, purchaseCode, groupCode, purchaseUpdateDTO.getStoreCode()))
			.collect(Collectors.toList());
		BigDecimal amount = BigDecimal.ZERO;
		BigDecimal rateAmount = BigDecimal.ZERO;
		for (PurchaseOrderDetailEntity detail : purchaseOrderDetailEntities) {
			amount = amount.add(detail.getAmount());
			rateAmount = rateAmount.add(detail.getRateAmount());
		}

		purchaseOrder.setAmount(amount);
		purchaseOrder.setRateAmount(rateAmount);

		purchaseOrder.getDetailEntityList().clear();
		purchaseOrder.getDetailEntityList().addAll(purchaseOrderDetailEntities);
		purchaseOrderRepository.save(purchaseOrder);

		return purchaseCode;
	}

	@Override
	public void batchImport(List<PurchaseImportDTO> purchaseImportDTOS) {
		Validate.notEmpty(purchaseImportDTOS, "无导入信息");
		Map<String, List<PurchaseImportDTO>> importDataMap = purchaseImportDTOS.stream()
			.collect(Collectors.groupingBy(PurchaseImportDTO::getSupplierCode));

		for (Map.Entry<String, List<PurchaseImportDTO>> entry : importDataMap.entrySet()) {
			PurchaseSubmitDTO purchaseSubmitDTO = new PurchaseSubmitDTO();

			PurchaseImportDTO purchaseImportDTO = entry.getValue().get(0);
			purchaseSubmitDTO.setIsDraft(1);
			purchaseSubmitDTO.setGroupCode(purchaseImportDTO.getGroupCode());
			purchaseSubmitDTO.setPayments(0);
			purchaseSubmitDTO.setSupplierCode(entry.getKey());
			purchaseSubmitDTO.setSupplierName(entry.getValue().get(0).getSupplierName());

			List<PurchaseDetailSubmitDTO> orderDetail = new ArrayList<>(entry.getValue().size());
			entry.getValue().forEach(e -> {
				PurchaseDetailSubmitDTO purchaseDetailSubmitDTO = new PurchaseDetailSubmitDTO();
				BeanUtils.copy(e, purchaseDetailSubmitDTO);
				orderDetail.add(purchaseDetailSubmitDTO);
			});

			purchaseSubmitDTO.setOrderDetail(orderDetail);
			submitOrder(purchaseSubmitDTO);
		}
	}

	@Override
	public List<PurchaseOrderDetailDTO> importDetail(PurchaseImportUpdateDTO dto) {
		Validate.notEmpty(dto.getPurchaseDetailImportDTOS(), "采购详情不存在");

		return dto.getPurchaseDetailImportDTOS().stream()
			.map(e -> {
				PurchaseOrderDetailDTO purchaseOrderDetailDTO = new PurchaseOrderDetailDTO();
				PurchaseDetailSubmitDTO purchaseDetailSubmitDTO = new PurchaseDetailSubmitDTO();
				BeanUtils.copy(e, purchaseDetailSubmitDTO);
				PurchaseOrderDetailEntity purchaseDetail = getPurchaseDetail(purchaseDetailSubmitDTO, null, dto.getGroupCode(), dto.getStoreCode());
				BeanUtils.copy(purchaseDetail, purchaseOrderDetailDTO);
				return purchaseOrderDetailDTO;
			})
			.collect(Collectors.toList());
	}

	@Override
	@Transactional
	public PurchaseOrderDTO auditPurchase(PurchaseAuditDTO dto) {
		PurchaseOrderEntity purchaseOrderEntity = purchaseOrderRepository.getByPurchaseCode(dto.getPurchaseCode());
		Validate.notNull(purchaseOrderEntity, "采购单信息不存在：" + dto.getPurchaseCode());

		if (purchaseOrderEntity.getSubmitType().equals(PurchaseSubmitEnum.GROUP)) {
			new UserPermission(UserUtils.currentUser())
				.tag("groupCode", purchaseOrderEntity.getGroupCode())
				.msg("该采购单不允许审核：" + purchaseOrderEntity.getPurchaseCode()).pass();
		} else {
			new UserPermission(UserUtils.currentUser())
				.tag("storeCode", purchaseOrderEntity.getStoreCode())
				.msg("该采购单不允许审核：" + purchaseOrderEntity.getPurchaseCode()).pass();
		}

		UserInfo user = UserUtils.currentUser();
		if (user != null) {
			purchaseOrderEntity.setApproveId(String.valueOf(user.getId()));
			purchaseOrderEntity.setApproveName(user.getName());
		}
		purchaseOrderEntity.setApproveDate(new Date());

		Validate.isTrue(PurchaseStatusEnum.WAIT_AUDIT.equals(purchaseOrderEntity.getStatus()),
			"订单不在待审核状态");
		if (PurchaseStatusEnum.AUDIT_REJECT.getCode().equals(dto.getStatus())) {
			purchaseOrderEntity.setStatus(PurchaseStatusEnum.AUDIT_REJECT);
			purchaseOrderRepository.save(purchaseOrderEntity);
		} else {
			//负责人审批
			purchaseOrderEntity.setStatus(PurchaseStatusEnum.AUDIT_SUCCESS);
			purchaseOrderEntity.setTransStatus(1);
			purchaseOrderRepository.save(purchaseOrderEntity);

			// 采购订单审核成功后生产采购入库单
			transformIn(purchaseOrderEntity);
		}
		saveWater(purchaseOrderEntity, "采购单" + purchaseOrderEntity.getStatus().getDesc());
		return PurchaseOrderEntity.toDTO(purchaseOrderEntity);
	}

	/**
	 * 采购单审核通过生成采购入库单
	 */
	private void transformIn(PurchaseOrderEntity purchaseOrder) {
		purchaseOrder.getDetailEntityList()
			.stream()
			.collect(Collectors.groupingBy(item -> item.getStoreCode() + item.getWarehouseCode()))
			.forEach((key, detailList) -> {
				String purchaseInCode = UniqueNoUtils.nextInc(UniqueNoType.PRIN, 5);

				PurchaseInOrderEntity entity = PurchaseOrderEntity.formIn(purchaseOrder, detailList, purchaseInCode);
				purchaseInOrderRepository.save(entity);
			});
	}

	@Override
	@Transactional
	public Integer deletePurchase(PurchaseDeleteDTO dto) {
		PurchaseOrderEntity purchaseOrderEntity = purchaseOrderRepository.getByPurchaseCode(dto.getPurchaseCode());
		Validate.notNull(purchaseOrderEntity, "采购单信息不存在");

		if (purchaseOrderEntity.getSubmitType().equals(PurchaseSubmitEnum.GROUP)) {
			new UserPermission(UserUtils.currentUser())
				.tag("groupCode", purchaseOrderEntity.getGroupCode())
				.msg("该采购单不允许删除：" + purchaseOrderEntity.getPurchaseCode()).pass();
		} else {
			new UserPermission(UserUtils.currentUser())
				.tag("storeCode", purchaseOrderEntity.getStoreCode())
				.msg("该采购单不允许删除：" + purchaseOrderEntity.getPurchaseCode()).pass();
		}

		Validate.isTrue(PurchaseStatusEnum.PREPARE_DRAFT.equals(purchaseOrderEntity.getStatus()) ||
				PurchaseStatusEnum.AUDIT_REJECT.equals(purchaseOrderEntity.getStatus()),
			"采购单不是草稿或审核失败状态，不允许操作");

		purchaseOrderEntity.setDeleteFlag(DeleteFlagEnum.DELETE.getCode());
		purchaseOrderDetailRepository.deleteByPurchaseCode(purchaseOrderEntity.getPurchaseCode());
		purchaseOrderRepository.save(purchaseOrderEntity);
		return 1;
	}

	/**
	 * 检查供应商是否可用
	 */
	private void checkSupplier(String groupCode, String supplierCode) {
		SupplierInfo supplierInfo = supplierService.getSupplierInfo(groupCode, supplierCode);
		Validate.notNull(supplierInfo, "供应商信息不存在：" + supplierCode);
		Validate.isTrue(supplierInfo.getStatus().equals(SupplierStatusEnum.ENABLE.getCode()), "供应商未启用：" + supplierCode);
	}

	private Boolean checkSupplier(String productCode, String supplierCode, String groupCode) {
		SupplierItemInfo supplierItemInfo = supplierService.getSupplierItemInfo(productCode, supplierCode, groupCode);
		return supplierItemInfo != null;
	}

}
