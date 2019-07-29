package com.morning.star.retail.stock.application.impl;

import com.alibaba.fastjson.JSON;
import com.morning.star.retail.facade.dto.out.*;
import com.morning.star.retail.stock.application.OutStockApplication;
import com.morning.star.retail.stock.application.StockApplication;
import com.morning.star.retail.stock.dto.ItemDTO;
import com.morning.star.retail.stock.dto.StockDTO;
import com.morning.star.retail.stock.dto.StockOrderDTO;
import com.morning.star.retail.stock.dto.StockQueryDTO;
import com.morning.star.retail.stock.entity.OutStockDetailEntity;
import com.morning.star.retail.stock.entity.OutStockEntity;
import com.morning.star.retail.stock.entity.repository.OutStockRepository;
import com.morning.star.retail.stock.enums.OutStockStatusEnum;
import com.morning.star.retail.stock.enums.OutStockType;
import com.morning.star.retail.stock.helper.StockGoodsHelper;
import com.morning.star.retail.stock.helper.WarehouseService;
import com.morning.star.retail.stock.helper.vo.GoodsInfo;
import com.morning.star.retail.stock.helper.vo.WarehouseInfo;
import com.morning.star.retail.stock.listener.event.OutStockSuccessEvent;
import com.morning.star.retail.stock.logicservice.StockLogicService;
import com.morning.star.retail.user.UserInfo;
import com.morning.star.retail.user.UserPermission;
import com.morning.star.retail.user.UserUtils;
import com.morning.star.retail.util.Context;
import org.apache.commons.lang3.Validate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OutStockApplicationImpl implements OutStockApplication {

	public static final Logger log = LoggerFactory.getLogger(OutStockApplicationImpl.class);

	@Autowired
	private OutStockRepository outStockRepository;
	@Autowired
	private StockApplication stockApplication;
	@Autowired
	private StockGoodsHelper stockGoodsHelper;

	@Autowired
	private WarehouseService warehouseService;

	@Autowired
	private StockLogicService stockLogicService;


	@Transactional
	@Override
	public void save(OutStockSubmitDTO outStockSubmitDTO) {
		OutStockEntity newEntity = new OutStockEntity();
		OutStockEntity entity = outStockRepository.findOne(outStockSubmitDTO.getOutStockCode());

		if (entity != null) {
			new UserPermission(UserUtils.currentUser())
				.tag("storeCode", entity.getOutStoreCode())
				.msg("无权限编辑该出库单").pass();
			Validate.isTrue(OutStockStatusEnum.PREPARE_DRAFT.equals(entity.getStatus()) ||
					OutStockStatusEnum.AUDIT_REJECT.equals(entity.getStatus()),
				"只能编辑草稿状态的数据");
			newEntity = entity;
			newEntity.getDetailList().clear();
		} else {
			newEntity.setOutStockCode(outStockSubmitDTO.getOutStockCode());
		}
		if (outStockSubmitDTO.getIsDraft() == 0) {
//			checkStock(outStockSubmitDTO); // 检查库存
		}

		WarehouseInfo outWarehouseInfo = warehouseService.get(outStockSubmitDTO.getOutWarehouseCode());
		Validate.notNull(outWarehouseInfo, "出库仓库不存在：" + outStockSubmitDTO.getOutWarehouseCode());
		WarehouseInfo inWarehouseInfo = warehouseService.get(outStockSubmitDTO.getInWarehouseCode());

		newEntity.formSubmit(outStockSubmitDTO, outWarehouseInfo, inWarehouseInfo);

		List<OutStockDetailEntity> detailEntityList = outStockSubmitDTO.getDetailList().stream().map(detail -> {
			GoodsInfo goodsInfo = stockGoodsHelper.getGoods(outStockSubmitDTO.getOutStoreCode(), detail.getProductCode());
			Validate.notNull(goodsInfo, "门店商品信息不存在：" + detail.getProductCode());

			return OutStockDetailEntity.formSubmit(outStockSubmitDTO.getOutStockCode(), detail, goodsInfo);

		}).collect(Collectors.toList());

		UserInfo userInfo = UserUtils.currentUser();
		if (userInfo != null) {
			newEntity.setCreatorId(userInfo.getId() == null ? "" : String.valueOf(userInfo.getId()));
			newEntity.setCreatorName(userInfo.getName());
		}

		if (newEntity.getDetailList() != null) {
			newEntity.getDetailList().addAll(detailEntityList);
		} else {
			newEntity.setDetailList(detailEntityList);
		}
		outStockRepository.save(newEntity);
	}

	/**
	 * 检查库存
	 */
	private void checkStock(OutStockSubmitDTO outStockSubmitDTO) {
		for (OutStockDetailSubmitDTO detail : outStockSubmitDTO.getDetailList()) {
			StockDTO stockDTO = stockApplication.get(StockQueryDTO.byProductCode(detail.getProductCode(), outStockSubmitDTO.getOutWarehouseCode()));
			Validate.notNull(stockDTO, detail.getProductCode() + "库存不存在");

			Boolean checkInitial = stockDTO.getDoneInStockNum().intValue() >= detail.getInitialOutNum().intValue();
			Boolean checkReal = stockDTO.getDoneInStockNum().intValue() >= detail.getRealOutNum().intValue();

			Validate.isTrue(checkInitial && checkReal, detail.getProductCode() + "库存不足");
		}
	}

	@Override
	@Transactional
	public void audit(OutStockAuditDTO auditDTO) {
		OutStockEntity entity = outStockRepository.findOne(auditDTO.getOutStockCode());
		Validate.notNull(entity, "出库单不存在：" + auditDTO.getOutStockCode());
		Validate.isTrue(OutStockStatusEnum.WAIT_AUDIT.equals(entity.getStatus()),
			"该出库单状态错误");
		new UserPermission(UserUtils.currentUser())
			.tag("storeCode", entity.getOutStoreCode())
			.msg("不允许审核该出库单").pass();

		if (OutStockStatusEnum.AUDIT_SUCCESS.getCode().equals(auditDTO.getStatus())) {
			entity.setStatus(OutStockStatusEnum.AUDIT_SUCCESS);

			UserInfo userInfo = UserUtils.currentUser();
			if (userInfo != null) {
				entity.setApproveId(userInfo.getId() == null ? "" : String.valueOf(userInfo.getId()));
				entity.setApproveName(userInfo.getName());
				entity.setApproveDate(new Date());
			}
		}
		if (OutStockStatusEnum.AUDIT_REJECT.getCode().equals(auditDTO.getStatus())) {
			entity.setStatus(OutStockStatusEnum.AUDIT_REJECT);
		}
		outStockRepository.save(entity);

		if (OutStockStatusEnum.AUDIT_SUCCESS.equals(entity.getStatus())) {
			new OutStockSuccessEvent(OutStockEntity.toDTO(entity)).publish();
		}
	}

	@Override
	@Transactional
	public void auditOut(OutStockOutDTO outStockOutDTO) {
		OutStockEntity entity = outStockRepository.findOne(outStockOutDTO.getOutStockCode());
		Validate.notNull(entity, "出库单不存在：" + outStockOutDTO.getOutStockCode());
		Validate.isTrue(OutStockStatusEnum.AUDIT_SUCCESS.equals(entity.getStatus()),
			"该出库单未审核成功");
		new UserPermission(UserUtils.currentUser())
			.tag("storeCode", entity.getOutStoreCode())
			.msg("不允许审核该出库单").pass();

		for (OutStockOutDetailDTO detailDTO : outStockOutDTO.getDetailDTOList()) {
			/*
			// 检验当前库存是否能够出库
			StockDTO stockDTO = stockApplication.get(StockQueryDTO.byProductCode(detailDTO.getProductCode(), entity.getOutWarehouseCode()));
			Validate.notNull(stockDTO, detailDTO.getProductCode() + "库存不存在");
			Boolean checkReal = stockDTO.getDoneInStockNum().intValue() >= detailDTO.getRealOutNum().intValue();

			log.info("当前库存为==============" + stockDTO.getDoneInStockNum());
			Validate.isTrue(checkReal, detailDTO.getProductCode() + "库存不足,当前库存为:" + stockDTO.getDoneInStockNum());
*/
			Optional<OutStockDetailEntity> firstOpt = entity.getDetailList()
				.stream()
				.filter(item -> detailDTO.getProductCode().equals(item.getProductCode()))
				.findFirst();
			Validate.isTrue(firstOpt.isPresent(), "出库单中不存在该货品数据：" + detailDTO.getProductCode());
			OutStockDetailEntity detailEntity = firstOpt.get();
			detailEntity.fillOutData(detailDTO);

		}
		reduceStock(entity);

		entity.setStatus(OutStockStatusEnum.AUDIT_OUT);
		outStockRepository.save(entity);
	}


	/**
	 * 根据出库单扣减实际库存
	 */
	private void reduceStock(OutStockEntity entity) {
		StockOrderDTO stockOrderDTO = new StockOrderDTO();
		stockOrderDTO.setGroupCode(entity.getGroupCode());
		stockOrderDTO.setStoreCode(entity.getOutStoreCode());
		stockOrderDTO.setOrderCode(entity.getOutStockCode());

		List<ItemDTO> itemList = entity.getDetailList().stream()
			.map(item -> {
				ItemDTO stockItem = new ItemDTO();
				stockItem.setGoodsCode(item.getGoodsCode());
				stockItem.setRealNum(item.getRealOutNum());
				return stockItem;
			})
			.filter(item -> BigDecimal.ZERO.compareTo(item.getRealNum()) < 0)
			.collect(Collectors.toList());

		stockOrderDTO.setItems(itemList);
		log.info("扣减库存调用:" + JSON.toJSONString(stockOrderDTO));
//		stockLogicService.transferOutStock(stockOrderDTO);
	}

	@Override
	public void delete(String outStockCode) {
		OutStockEntity entity = outStockRepository.findOne(outStockCode);
		Validate.notNull(entity, "出库单不存在：" + outStockCode);
		Validate.isTrue(OutStockStatusEnum.PREPARE_DRAFT.equals(entity.getStatus()), "出库单状态不允许删除");
		new UserPermission(UserUtils.currentUser())
			.tag("storeCode", entity.getOutStoreCode())
			.msg("出库单不允许删除").pass();
		outStockRepository.delete(outStockCode);
	}

	@Override
	public void updateReceiptCode(String purchaseCode, String receiptCode) {
		// TODO
	}

	@Override
	public void pushThird(String code) {
		OutStockEntity entity = outStockRepository.findOne(code);
		OutStockDTO outStockDTO = OutStockEntity.toDTO(entity);
	}

	@Override
	@Transactional
	public void wmsOutStock(OutStockDTO dto) {
		WarehouseInfo outWarehouseInfo = warehouseService.get(dto.getOutWarehouseCode());
		Validate.notNull(outWarehouseInfo, "仓库信息不存在！仓库编码为：" + dto.getOutWarehouseCode());

		OutStockEntity entity = new OutStockEntity();
		entity.setOutStockCode(dto.getOutStockCode());
		entity.setGroupCode(outWarehouseInfo.getGroupCode());
//		entity.setGroupName(outWarehouseInfo.getGroupName());
		entity.setOutStoreCode(outWarehouseInfo.getStoreCode());
		entity.setOutStoreName(outWarehouseInfo.getStoreName());
		entity.setOutWarehouseCode(outWarehouseInfo.getWarehouseCode());
		entity.setOutWarehouseName(outWarehouseInfo.getWarehouseName());

		entity.setType(OutStockType.from(dto.getType()));
		entity.setStatus(OutStockStatusEnum.AUDIT_OUT);

		List<OutStockDetailEntity> detailEntityList = dto.getDetailList().stream().map(detail -> {
			GoodsInfo goodsInfo = stockGoodsHelper.getGoods(outWarehouseInfo.getStoreCode(), detail.getProductCode());
			Validate.notNull(goodsInfo, "门店商品信息不存在：" + detail.getProductCode());

			return OutStockDetailEntity.formOther(dto.getOutStockCode(), detail, goodsInfo);

		}).collect(Collectors.toList());

		entity.setDetailList(detailEntityList);

		reduceStock(entity);

		outStockRepository.save(entity);
	}

}
