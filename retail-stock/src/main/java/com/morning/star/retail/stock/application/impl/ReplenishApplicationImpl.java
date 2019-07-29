package com.morning.star.retail.stock.application.impl;

import com.alibaba.fastjson.JSON;
import com.morning.star.retail.facade.dto.replenish.ReplenishAuditDTO;
import com.morning.star.retail.facade.dto.replenish.ReplenishItemSubmitDTO;
import com.morning.star.retail.facade.dto.replenish.ReplenishSubmitDTO;
import com.morning.star.retail.facade.dto.replenish.ReplenishUpdateDTO;
import com.morning.star.retail.stock.application.ReplenishApplication;
import com.morning.star.retail.stock.entity.ReplenishEntity;
import com.morning.star.retail.stock.entity.ReplenishItemEntity;
import com.morning.star.retail.stock.entity.ReplenishWaterEntity;
import com.morning.star.retail.stock.entity.repository.ReplenishItemRepository;
import com.morning.star.retail.stock.entity.repository.ReplenishRepository;
import com.morning.star.retail.stock.entity.repository.WaterRepository;
import com.morning.star.retail.stock.enums.ReplenishStatus;
import com.morning.star.retail.stock.enums.ReplenishType;
import com.morning.star.retail.stock.helper.StockGoodsHelper;
import com.morning.star.retail.stock.helper.StoreService;
import com.morning.star.retail.stock.helper.WarehouseService;
import com.morning.star.retail.stock.helper.vo.GoodsInfo;
import com.morning.star.retail.stock.helper.vo.StoreInfo;
import com.morning.star.retail.stock.helper.vo.WarehouseInfo;
import com.morning.star.retail.user.UserPermission;
import com.morning.star.retail.user.UserUtils;
import com.morning.star.retail.util.UniqueNoUtils;
import com.morning.star.retail.util.UniqueNoUtils.UniqueNoType;
import com.morning.star.retail.utils.WeightUtil;
import com.morning.star.retail.utils.entity.BeanUtils;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
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
public class ReplenishApplicationImpl implements ReplenishApplication {
	private static final Logger LOGGER = LoggerFactory.getLogger(ReplenishApplicationImpl.class);

	@Autowired
	private WaterRepository waterRepository;
	@Autowired
	private ReplenishRepository replenishRepository;
	@Autowired
	private ReplenishItemRepository replenishItemRepository;
	@Autowired
	private StockGoodsHelper goodsService;
	@Autowired
	private StoreService storeService;
	@Autowired
	private WarehouseService warehouseService;

	private void saveWater(ReplenishEntity entity, String remark) {
		waterRepository.save(entity, ReplenishWaterEntity.class, remark);
	}

	@Transactional
	@Override
	public String submitReplenish(ReplenishSubmitDTO replenishDTO) {
		return createReplenish(replenishDTO, ReplenishType.STORE_APPLY);
	}

	@Transactional
	@Override
	public void addReplenish(ReplenishSubmitDTO replenishDTO) {
		String replenishCode = createReplenish(replenishDTO, ReplenishType.GROUP_LAUNCH);
		ReplenishAuditDTO replenishAuditDTO = new ReplenishAuditDTO();
		replenishAuditDTO.setReplenishCode(replenishCode);
		//自动审核
		confirm(Collections.singletonList(replenishAuditDTO));
	}


	@Override
	@Transactional
	public Integer modify(ReplenishUpdateDTO replenishDTO) {
		String replenishCode = replenishDTO.getReplenishCode();

		ReplenishEntity replenishEntity = replenishRepository.getByReplenishCodeAndStatus(replenishCode, ReplenishStatus.WAIT_AUDIT);
		Validate.notNull(replenishEntity, "符合相关条件的补货单不存在：" + replenishCode);
		new UserPermission(UserUtils.currentUser())
			.tag("storeCode", replenishEntity.getStoreCode())
			.tag("groupCode", replenishEntity.getGroupCode())
			.msg("不允许修改该补货单：" + replenishCode)
			.pass();

		List<ReplenishItemSubmitDTO> replenishItemDTOS = replenishDTO.getReplenishItemDTOS();
		Map<String, GoodsInfo> goodsInfoMap = checkItems(replenishItemDTOS);

		List<ReplenishItemEntity> replenishItemEntityList = new ArrayList<>(replenishItemDTOS.size());
		for (ReplenishItemSubmitDTO replenishItemSubmitDTO : replenishItemDTOS) {
			String goodsCode = replenishItemSubmitDTO.getGoodsCode();
			BigDecimal replenishNum = replenishItemSubmitDTO.getReplenishNum();

			GoodsInfo goodsInfo = goodsInfoMap.get(goodsCode);

			Integer packageSpecNumber = goodsInfo.getPackSpecNum();
			if (packageSpecNumber != null && packageSpecNumber != 0) {
				replenishNum = replenishNum.multiply(new BigDecimal(goodsInfo.getPackSpecNum()));
			}
			// 新增补货记录
			ReplenishItemEntity replenishItemEntity = new ReplenishItemEntity();
			BeanUtils.copy(goodsInfo, replenishItemEntity);
			replenishItemEntity.setId(null);
			replenishItemEntity.setReplenishCode(replenishEntity.getReplenishCode());
			replenishItemEntity.setReplenishNum(replenishNum);

			replenishItemEntityList.add(replenishItemEntity);
		}
		if (replenishEntity.getDetailEntityList() != null) {
			replenishEntity.getDetailEntityList().clear();
			replenishEntity.getDetailEntityList().addAll(replenishItemEntityList);
		} else {
			replenishEntity.setDetailEntityList(replenishItemEntityList);
		}
		// 统计补货详情中的所有仓库
		Set<String> warehouseCodeSet = replenishEntity.getDetailEntityList().stream()
			.map(ReplenishItemEntity::getWarehouseCode).collect(Collectors.toSet());
		Set<String> warehouseNameSet = replenishEntity.getDetailEntityList().stream()
			.map(ReplenishItemEntity::getWarehouseName).collect(Collectors.toSet());
		replenishEntity.setWarehouseCodes(String.join(",", warehouseCodeSet));
		replenishEntity.setWarehouseNames(String.join(",", warehouseNameSet));

		replenishRepository.save(replenishEntity);
		return 1;
	}


	@Transactional
	@Override
	public Integer confirm(List<ReplenishAuditDTO> replenishAuditDTOS) {
		Integer count = 0;
		Validate.notEmpty(replenishAuditDTOS, "没有提交补货单信息");
		for (ReplenishAuditDTO replenishAuditDTO : replenishAuditDTOS) {
			ReplenishEntity replenishEntity = checkGet(replenishAuditDTO.getReplenishCode());
			replenishEntity.setAuthTime(new Date());
			replenishEntity.setStatus(ReplenishStatus.AUDIT_SUCCESS);
			replenishRepository.save(replenishEntity);

			if (CollectionUtils.isNotEmpty(replenishAuditDTO.getItems())) {
				for (ReplenishItemSubmitDTO item : replenishAuditDTO.getItems()) {
					ReplenishItemEntity itemEntity = replenishItemRepository.getByReplenishCodeAndGoodsCode(replenishAuditDTO.getReplenishCode(), item.getGoodsCode());
					Validate.notNull(itemEntity, String.format("该补货单中未找到补货商品【编号：%s】信息", item.getGoodsCode()));
					Validate.isTrue(item.getReplenishNum().compareTo(BigDecimal.ZERO) > 0, String.format("补货商品【编号：%s】数量须大于0", item.getGoodsCode()));
					itemEntity.setReplenishNum(item.getReplenishNum());
					replenishItemRepository.save(itemEntity);
				}
			}
			saveWater(replenishEntity, null);

			count += 1;
		}

		return count;
	}

	@Transactional
	@Override
	public Integer reject(List<ReplenishAuditDTO> replenishAuditDTOS) {
		Integer count = 0;
		Validate.notEmpty(replenishAuditDTOS, "没有提交补货单信息");
		for (ReplenishAuditDTO replenishAuditDTO : replenishAuditDTOS) {
			ReplenishEntity replenishEntity = checkGet(replenishAuditDTO.getReplenishCode());
			replenishEntity.setAuthTime(new Date());
			replenishEntity.setStatus(ReplenishStatus.AUDIT_FAIL);
			replenishEntity.setRemark(replenishAuditDTO.getRemark());
			replenishRepository.save(replenishEntity);

			saveWater(replenishEntity, null);
			count += 1;
		}

		return count;
	}

	/**
	 * 检查补货单
	 */
	private ReplenishEntity checkGet(String replenishCode) {
		ReplenishEntity replenishEntity = replenishRepository.getByReplenishCode(replenishCode);
		Validate.notNull(replenishEntity, " 符合相关条件的补货单不存在：" + replenishCode);
		new UserPermission(UserUtils.currentUser())
			.tag("groupCode", replenishEntity.getGroupCode())
			.msg("不允许审核该补货单：" + replenishCode)
			.pass();
		Validate.isTrue(ReplenishStatus.WAIT_AUDIT.equals(replenishEntity.getStatus()), "该补货单当前非待审核状态，不能执行该操作");
		return replenishEntity;
	}

	@Transactional
	@Override
	public Integer prepareReplenish(ReplenishAuditDTO replenishAuditDTO) {
		String replenishCode = replenishAuditDTO.getReplenishCode();
		// 校验该补货编号有效性
		ReplenishEntity replenishEntity = replenishRepository.getByReplenishCodeAndStatus(replenishCode, ReplenishStatus.AUDIT_SUCCESS);
		Validate.notNull(replenishEntity, "符合相关条件的补货单不存在：" + replenishCode);
		new UserPermission(UserUtils.currentUser())
			.tag("groupCode", replenishEntity.getGroupCode())
			.msg("不允许审核该补货单：" + replenishCode)
			.pass();

		String deliveryCode = replenishEntity.getDeliveryCode();
		// 修改补货单状态
		replenishEntity.setDeliveryCode(deliveryCode);
		replenishRepository.save(replenishEntity);

		saveWater(replenishEntity, null);

		return 1;
	}

	@Transactional
	@Override
	public Integer deliveryReplenish(ReplenishAuditDTO replenishAuditDTO) {
		return prepareReplenish(replenishAuditDTO);
	}

	/**
	 * 检查补货商品信息
	 */
	private Map<String, GoodsInfo> checkItems(List<ReplenishItemSubmitDTO> itemList) {
		Validate.notEmpty(itemList, "提交补货清单数据或格式有误");

		// 商品重复校验
		Set<String> keySet = new HashSet<>();
		Map<String, GoodsInfo> map = new HashMap<>();
		for (ReplenishItemSubmitDTO dto : itemList) {
			String key = dto.getGoodsCode() + ";" + dto.getWarehouseCode();
			Validate.isTrue(StringUtils.isNotBlank(dto.getGoodsCode()) && dto.getReplenishNum() != null
				&& dto.getReplenishNum().compareTo(BigDecimal.ZERO) > 0, "商品信息为空");

			// 检查是否有重复商品
			Validate.isTrue(!keySet.contains(key),
				"补货单中存在重复【商品/仓库：%s/%s】", dto.getGoodsCode(), dto.getWarehouseCode());

			GoodsInfo goodsInfo = goodsService.getGoods(dto.getGoodsCode());

			Validate.notNull(goodsInfo, String.format("未找到补货单中该商品【编码：%s】信息", dto.getGoodsCode()));
			keySet.add(key);
			map.put(dto.getGoodsCode(), goodsInfo);
		}
		return map;
	}


	/**
	 * 添加补货单信息
	 */
	@Transactional
	public String createReplenish(ReplenishSubmitDTO replenishDTO, ReplenishType replenishType) {
		String replenishCode = UniqueNoUtils.next(UniqueNoType.REP);
		LOGGER.info("start ------------------ createReplenish ------------------ dto:{}, type:{}", JSON.toJSON(replenishDTO), replenishType.getCode());

		StoreInfo storeInfo = storeService.getStore(replenishDTO.getStoreCode());
		Validate.notNull(storeInfo, "门店信息不存在");

		ReplenishEntity replenishEntity = new ReplenishEntity();
		replenishEntity.setReplenishCode(replenishCode);
		replenishEntity.setStatus(ReplenishStatus.WAIT_AUDIT);
		replenishEntity.setGroupCode(replenishDTO.getGroupCode());
		replenishEntity.setGroupName(replenishDTO.getGroupName());
		replenishEntity.setStoreCode(replenishDTO.getStoreCode());
		replenishEntity.setStoreName(replenishDTO.getStoreName());
		replenishEntity.setCityId(storeInfo.getCityId());
		replenishEntity.setCityName(storeInfo.getCityName());
		replenishEntity.setType(replenishType);
		replenishRepository.save(replenishEntity);

		replenishEntity.setDetailEntityList(toItems(replenishCode, replenishDTO.getItems()));
		// 统计补货详情中的所有仓库
		Set<String> warehouseCodeSet = replenishEntity.getDetailEntityList().stream()
			.map(ReplenishItemEntity::getWarehouseCode).collect(Collectors.toSet());
		Set<String> warehouseNameSet = replenishEntity.getDetailEntityList().stream()
			.map(ReplenishItemEntity::getWarehouseName).collect(Collectors.toSet());
		replenishEntity.setWarehouseCodes(String.join(",", warehouseCodeSet));
		replenishEntity.setWarehouseNames(String.join(",", warehouseNameSet));

		StringBuilder remark = new StringBuilder("商品编码/补货数量");
		for (ReplenishItemSubmitDTO replenishItemSubmitDTO : replenishDTO.getItems()) {
			String goodsCode = replenishItemSubmitDTO.getGoodsCode();
			BigDecimal replenishNum = replenishItemSubmitDTO.getReplenishNum();
			remark.append(";").append(goodsCode).append("/").append(replenishNum.toString());
		}

		saveWater(replenishEntity, remark.toString());

		LOGGER.info("end ------------------ createReplenish ------------------ ");
		return replenishCode;
	}

	/**
	 * 明细数据
	 */
	private List<ReplenishItemEntity> toItems(String replenishCode, List<ReplenishItemSubmitDTO> itemList) {
		Map<String, GoodsInfo> goodsInfoMap = checkItems(itemList);
		List<ReplenishItemEntity> itemEntities = new ArrayList<>(itemList.size());
		for (ReplenishItemSubmitDTO item : itemList) {
			BigDecimal replenishNum = item.getReplenishNum();

			GoodsInfo goodsInfo = goodsInfoMap.get(item.getGoodsCode());
			String originalUnits = goodsInfo.getUnitsName();

//            Integer packageSpecNumber = goodsInfo.getPackSpecNum();
//            if (packageSpecNumber != null && packageSpecNumber != 0) {
//                replenishNum = replenishNum.multiply(new BigDecimal(goodsInfo.getPackSpecNum()));
//            }
			// 新增补货记录
			ReplenishItemEntity itemEntity = new ReplenishItemEntity();
			BeanUtils.copy(goodsInfo, itemEntity);
			itemEntity.setGoodsName(goodsInfo.getProductName());

			WarehouseInfo warehouseInfo = warehouseService.checkGet(item.getWarehouseCode());
			itemEntity.setWarehouseCode(item.getWarehouseCode());
			itemEntity.setWarehouseName(warehouseInfo.getWarehouseName());

			// 称重商品
			if (goodsInfo.getStandardType() == 1) {
				if (StringUtils.isBlank(originalUnits)) {
					originalUnits = "克";
				}
				itemEntity.setReplenishNum(WeightUtil.get(replenishNum, originalUnits));
			} else {
				itemEntity.setReplenishNum(replenishNum);
			}
			itemEntity.setId(null);
			itemEntity.setReplenishCode(replenishCode);

			itemEntities.add(itemEntity);
		}
		return itemEntities;
	}

}
