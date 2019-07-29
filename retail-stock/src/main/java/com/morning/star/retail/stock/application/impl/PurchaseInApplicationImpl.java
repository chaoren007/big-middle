package com.morning.star.retail.stock.application.impl;

import com.morning.star.retail.facade.dto.purchasein.PurchaseInAuditDTO;
import com.morning.star.retail.facade.dto.purchasein.PurchaseInDetailUpdateDTO;
import com.morning.star.retail.facade.dto.purchasein.PurchaseInOrderDTO;
import com.morning.star.retail.facade.dto.purchasein.PurchaseInUpdateDTO;
import com.morning.star.retail.stock.application.PurchaseInApplication;
import com.morning.star.retail.stock.entity.PurchaseInOrderEntity;
import com.morning.star.retail.stock.entity.repository.PurchaseInOrderRepository;
import com.morning.star.retail.stock.enums.PurchaseInStatusEnum;
import com.morning.star.retail.stock.enums.PurchaseSubmitEnum;
import com.morning.star.retail.stock.helper.PurchaseWmsService;
import com.morning.star.retail.user.UserPermission;
import com.morning.star.retail.user.UserUtils;
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

/**
 * @author ethan
 */
@Service
public class PurchaseInApplicationImpl implements PurchaseInApplication {
	private static final Logger LOG = LoggerFactory.getLogger(PurchaseInApplicationImpl.class);

	@Autowired
	private PurchaseInOrderRepository purchaseInOrderRepository;

	@Autowired
	private PurchaseWmsService purchaseWmsService;

	@Override
	public void updatePreReceiptTime(PurchaseInUpdateDTO purchaseInUpdateDTO) {
		Validate.isTrue(purchaseInUpdateDTO.getPreReceiptTime() != null, "预计入库时间不能为空");
		PurchaseInOrderEntity entity = purchaseInOrderRepository.findByPurchaseInCode(purchaseInUpdateDTO.getPurchaseInCode());
		Validate.isTrue(entity != null, "采购入库单不存在");
		if (entity.getSubmitType().equals(PurchaseSubmitEnum.GROUP)) {
			new UserPermission(UserUtils.currentUser())
				.tag("groupCode", entity.getGroupCode())
				.msg("不允许设置预计入库时间").pass();
		} else {
			new UserPermission(UserUtils.currentUser())
				.tag("storeCode", entity.getStoreCode())
				.msg("不允许设置预计入库时间").pass();
		}
		entity.setPreReceiptDate(purchaseInUpdateDTO.getPreReceiptTime());
		purchaseInOrderRepository.save(entity);
	}

	@Override
	public void updateReceiptQty(PurchaseInUpdateDTO purchaseInUpdateDTO) {
		Validate.notEmpty(purchaseInUpdateDTO.getDetailList(), "入库数据不存在");
		PurchaseInOrderEntity entity = purchaseInOrderRepository.findByPurchaseInCode(purchaseInUpdateDTO.getPurchaseInCode());
		Validate.isTrue(entity != null, "采购入库单不存在");

		entity.getDetailEntityList().forEach(detail -> {
			Optional<PurchaseInDetailUpdateDTO> first = purchaseInUpdateDTO.getDetailList()
				.stream().filter(item -> item.getProductCode().equals(detail.getProductCode()))
				.findFirst();

			if (first.isPresent()) {
				Set<String> receiptCodeSet = new HashSet<>();

				String receiptCode = first.get().getReceiptCode();
				BigDecimal receiptQty = first.get().getReceiptQty();

				if (StringUtils.isNotBlank(detail.getReceiptCode())) {
					receiptCodeSet = Arrays.stream(detail.getReceiptCode().split(",")).collect(Collectors.toSet());
				}
				if (detail.getReceiptQty() == null) {
					detail.setReceiptQty(BigDecimal.ZERO);
				}
				if (!receiptCodeSet.contains(receiptCode)) {
					receiptCodeSet.add(receiptCode);

					detail.setReceiptCode(String.join(",", receiptCodeSet));
					detail.setReceiptQty(detail.getReceiptQty().add(receiptQty));
				}

			}
		});
		// 判断是否所有采购商品都已入库
		if (entity.getDetailEntityList().stream()
			.anyMatch(item -> item.getQty().compareTo(item.getReceiptQty()) > 0)) {

			if (!entity.getStatus().equals(PurchaseInStatusEnum.PART_RECEIPT)) {
				entity.setStatus(PurchaseInStatusEnum.PART_RECEIPT);
			}
		} else {
			entity.setStatus(PurchaseInStatusEnum.ALL_RECEIPT);
		}

		purchaseInOrderRepository.save(entity);
	}

	@Override
	public void audit(PurchaseInAuditDTO purchaseInAuditDTO, PurchaseInStatusEnum status) {
		PurchaseInOrderEntity entity = purchaseInOrderRepository.findByPurchaseInCode(purchaseInAuditDTO.getPurchaseInCode());
		Validate.isTrue(entity != null, "采购入库单不存在：" + purchaseInAuditDTO.getPurchaseInCode());
		if (PurchaseSubmitEnum.GROUP.equals(entity.getSubmitType())) {
			new UserPermission(UserUtils.currentUser())
				.tag("groupCode", entity.getGroupCode())
				.msg("无权限审核采购入库单：" + purchaseInAuditDTO.getPurchaseInCode())
				.pass();
		} else {
			new UserPermission(UserUtils.currentUser())
				.tag("storeCode", entity.getStoreCode())
				.msg("无权限审核采购入库单：" + purchaseInAuditDTO.getPurchaseInCode())
				.pass();
		}
		if (!entity.getStatus().equals(status)) {
			switch (status) {
				case CLOSE: {
					if (PurchaseInStatusEnum.PART_RECEIPT.equals(entity.getStatus())) {
						entity.setStatus(PurchaseInStatusEnum.PART_CLOSE);
					} else {
						entity.setStatus(PurchaseInStatusEnum.CLOSE);
					}
					break;
				}
				default: {
					entity.setStatus(status);
					break;
				}

			}
			if (PurchaseInStatusEnum.CLOSE.equals(status)) {
				Validate.isTrue(purchaseWmsService.closePurchaseIn(PurchaseInOrderEntity.toDTO(entity)) > 0,
					"WMS关闭失败");
			}
			purchaseInOrderRepository.save(entity);
		}

	}

	@Override
	@Transactional
	public void pushThird(String code) {
		// 获取采购订单下面所有的采购入库单
		List<PurchaseInOrderEntity> entityList = purchaseInOrderRepository.getByPurchaseCode(code);
		if (entityList == null || entityList.size() <= 0) {
			LOG.info("采购入库单不存在：" + code);
			return;
		}
		for (PurchaseInOrderEntity entity : entityList) {
			if (PurchaseInStatusEnum.SUCCESS.equals(entity.getStatus())) {
				PurchaseInOrderDTO purchaseInOrderDTO = PurchaseInOrderEntity.toDTO(entity);

				// 把采购入库单推送给WMS  成功则修改采购入库单状态
				Integer result = purchaseWmsService.addByPurchaseIn(purchaseInOrderDTO);
				if (result > 0) {
					entity.setStatus(PurchaseInStatusEnum.PUSH);
					purchaseInOrderRepository.save(entity);
				}
			}
		}
	}
}
