package com.morning.star.retail.stock.facade.impl;

import com.github.pagehelper.Page;
import com.morning.star.retail.facade.PurchaseInFacade;
import com.morning.star.retail.facade.dto.purchasein.*;
import com.morning.star.retail.stock.application.PurchaseInApplication;
import com.morning.star.retail.stock.dao.PurchaseInOrderDAO;
import com.morning.star.retail.stock.entity.PurchaseInOrderDetailEntity;
import com.morning.star.retail.stock.entity.PurchaseInOrderEntity;
import com.morning.star.retail.stock.entity.repository.PurchaseInOrderDetailRepository;
import com.morning.star.retail.stock.entity.repository.PurchaseInOrderRepository;
import com.morning.star.retail.stock.enums.PurchaseInStatusEnum;
import com.morning.star.retail.utils.page.PageBean;
import com.morning.star.retail.utils.page.PageBeanAssembler;
import com.morning.star.retail.utils.page.RowBoundsBuilder;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PurchaseInFacadeImpl implements PurchaseInFacade {

	@Autowired
	private PurchaseInOrderDAO purchaseInOrderDAO;

	@Autowired
	private PurchaseInOrderRepository purchaseInOrderRepository;

	@Autowired
	private PurchaseInOrderDetailRepository purchaseInOrderDetailRepository;

	@Autowired
	private PurchaseInApplication purchaseInApplication;

	@Override
	public PageBean<PurchaseInOrderSimpleDTO> queryOrder(PurchaseInQueryDTO searchDTO) {
		RowBounds rowBounds = RowBoundsBuilder.build(searchDTO.getPageNo(), searchDTO.getPageSize());
		Page<PurchaseInOrderSimpleDTO> replenishDTOS = purchaseInOrderDAO.queryPage(searchDTO, rowBounds);
		return new PageBeanAssembler().toBean(replenishDTOS);
	}

	@Override
	@Transactional
	public PurchaseInOrderDTO getByCode(PurchaseInGetDTO purchaseInGetDTO) {
		PurchaseInOrderDTO purchaseInOrderDTO;
		PurchaseInOrderEntity entity = purchaseInOrderRepository.findByPurchaseInCode(purchaseInGetDTO.getPurchaseInCode());
		if (entity != null) {
			Validate.isTrue(entity.getGroupCode().equals(purchaseInGetDTO.getGroupCode()), "采购入库单信息错误：" + purchaseInGetDTO.getPurchaseInCode());
			if (StringUtils.isNotBlank(purchaseInGetDTO.getStoreCode())) {
				Validate.isTrue(entity.getStoreCode().equals(purchaseInGetDTO.getStoreCode()), "采购入库单信息错误：" + purchaseInGetDTO.getPurchaseInCode());
			}
			purchaseInOrderDTO = PurchaseInOrderEntity.toDTO(entity);
		} else {
			purchaseInOrderDTO = null;
		}
		return purchaseInOrderDTO;
	}

	@Override
	public void updatePreReceiptTime(PurchaseInUpdateDTO purchaseInUpdateDTO) {
		purchaseInApplication.updatePreReceiptTime(purchaseInUpdateDTO);
	}

	@Override
	public void updateReceiptQty(PurchaseInUpdateDTO purchaseInUpdateDTO) {
		purchaseInApplication.updateReceiptQty(purchaseInUpdateDTO);
	}

	@Override
	public void auditClose(PurchaseInAuditDTO purchaseInAuditDTO) {
		purchaseInApplication.audit(purchaseInAuditDTO, PurchaseInStatusEnum.CLOSE);
	}

	@Override
	public void pushThird(String code) {
		purchaseInApplication.pushThird(code);
	}

	@Override
	public PurchaseInOrderDetailDTO getDetail(String purchaseInCode, String productCode) {
		PurchaseInOrderDetailEntity entity = purchaseInOrderDetailRepository.findByPurchaseInCodeAndProductCode(purchaseInCode, productCode);
		return PurchaseInOrderDetailEntity.toDTO(entity);
	}
}
