package com.morning.star.retail.stock.facade.impl;

import com.github.pagehelper.Page;
import com.morning.star.retail.facade.PurchaseFacade;
import com.morning.star.retail.facade.dto.purchase.*;
import com.morning.star.retail.stock.application.PurchaseApplication;
import com.morning.star.retail.stock.dao.PurchaseOrderDAO;
import com.morning.star.retail.stock.entity.PurchaseOrderEntity;
import com.morning.star.retail.stock.entity.repository.PurchaseOrderRepository;
import com.morning.star.retail.stock.listener.event.PurchaseAuditEvent;
import com.morning.star.retail.util.Context;
import com.morning.star.retail.utils.page.PageBean;
import com.morning.star.retail.utils.page.PageBeanAssembler;
import com.morning.star.retail.utils.page.RowBoundsBuilder;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by lenovo on 2017/10/25.
 */
@Service
public class PurchaseFacadeImpl implements PurchaseFacade {

	@Autowired
	private PurchaseOrderDAO purchaseOrderDAO;

	@Autowired
	private PurchaseOrderRepository purchaseOrderRepository;

	@Autowired
	private PurchaseApplication purchaseApplication;

	@Override
	public String submitOrder(PurchaseSubmitDTO purchaseSubmitDTO) {
		return purchaseApplication.submitOrder(purchaseSubmitDTO);
	}

	@Override
	public String updateOrder(PurchaseUpdateDTO purchaseUpdateDTO) {
		return purchaseApplication.updateOrder(purchaseUpdateDTO);
	}

	@Override
	public Integer auditPurchase(PurchaseAuditDTO dto) {
		PurchaseOrderDTO purchaseOrderDTO = purchaseApplication.auditPurchase(dto);
		if(purchaseOrderDTO != null) {
			new PurchaseAuditEvent(purchaseOrderDTO).publish();
			return 1;
		} else {
			return 0;
		}
	}

	@Override
	public Integer deletePurchase(PurchaseDeleteDTO dto) {
		return purchaseApplication.deletePurchase(dto);
	}

	@Override
	public PageBean<PurchaseOrderSimpleDTO> queryOrder(PurchaseQueryDTO searchDTO) {
		RowBounds rowBounds = RowBoundsBuilder.build(searchDTO.getPageNo(), searchDTO.getPageSize());
		Page<PurchaseOrderSimpleDTO> replenishDTOS = purchaseOrderDAO.queryPage(searchDTO, rowBounds);
		return new PageBeanAssembler().toBean(replenishDTOS);
	}

	@Override
	@Transactional
	public PurchaseOrderDTO getPurchaseByCode(PurchaseGetDTO purchaseGetDTO) {
		PurchaseOrderDTO purchaseOrderDTO;
		PurchaseOrderEntity purchaseOrderEntity = purchaseOrderRepository.getByPurchaseCode(purchaseGetDTO.getPurchaseCode());
		if (purchaseOrderEntity != null) {
			Validate.isTrue(purchaseOrderEntity.getGroupCode().equals(purchaseGetDTO.getGroupCode()), "采购单信息错误：" + purchaseGetDTO.getPurchaseCode());
			if (StringUtils.isNotBlank(purchaseGetDTO.getStoreCode())) {
				Validate.isTrue(purchaseOrderEntity.getStoreCode().equals(purchaseGetDTO.getStoreCode()), "采购单信息错误：" + purchaseGetDTO.getPurchaseCode());
			}
			purchaseOrderDTO = PurchaseOrderEntity.toDTO(purchaseOrderEntity);
		} else {
			purchaseOrderDTO = null;
		}
		return purchaseOrderDTO;
	}

	/**
	 * 从导入文件中批量添加采购单
	 */
	@Override
	public void batchImport(List<PurchaseImportDTO> dtos) {
		purchaseApplication.batchImport(dtos);
	}

	/**
	 * 从导入文件中给指定采购单增加采购信息
	 */
	@Override
	public List<PurchaseOrderDetailDTO> importDetail(PurchaseImportUpdateDTO dto) {
		return purchaseApplication.importDetail(dto);
	}

	@Override
	public PageBean<PurchaseOrderDetailDTO> queryPurchaseDetail(PurchaseQueryDTO searchDTO) {
		RowBounds rowBounds = RowBoundsBuilder.build(searchDTO.getPageNo(), searchDTO.getPageSize());
		Page<PurchaseOrderDetailDTO> dataList = purchaseOrderDAO.queryPurchaseDetail(searchDTO, rowBounds);
		return new PageBeanAssembler().toBean(dataList);
	}

	@Override
	public PageBean<PurchaseOrderRptDTO> queryPurchaseDetailRpt(PurchaseQueryDTO searchDTO) {
		RowBounds rowBounds = RowBoundsBuilder.build(searchDTO.getPageNo(), searchDTO.getPageSize());
		Page<PurchaseOrderRptDTO> orderVOList = purchaseOrderDAO.queryPurchaseDetailRpt(searchDTO, rowBounds);
		return new PageBeanAssembler().toBean(orderVOList);
	}

	@Override
	public List<String> checkSupplierRelationship(PurchaseOrderDTO purchaseOrderDTO) {
		return purchaseApplication.checkSupplierRelationship(purchaseOrderDTO);
	}
}
