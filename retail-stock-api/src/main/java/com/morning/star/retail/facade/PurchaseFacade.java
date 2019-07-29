package com.morning.star.retail.facade;

import com.morning.star.retail.facade.dto.purchase.*;
import com.morning.star.retail.facade.dto.purchase.PurchaseOrderRptDTO;
import com.morning.star.retail.facade.dto.purchase.PurchaseOrderDTO;
import com.morning.star.retail.facade.dto.purchase.PurchaseOrderSimpleDTO;
import com.morning.star.retail.utils.page.PageBean;

import java.util.List;

public interface PurchaseFacade {

	/**
	 * 提交采购单
	 */
	String submitOrder(PurchaseSubmitDTO purchaseSubmitDTO);

	/**
	 * 提交采购单
	 */
	String updateOrder(PurchaseUpdateDTO purchaseUpdateDTO);

	/**
	 * 审核订单
	 */
	Integer auditPurchase(PurchaseAuditDTO dto);

	/**
	 * 禁用订单
	 */
	Integer deletePurchase(PurchaseDeleteDTO dto);

	/**
	 * 查询采购单列表
	 */
	PageBean<PurchaseOrderSimpleDTO> queryOrder(PurchaseQueryDTO searchDTO);

	PurchaseOrderDTO getPurchaseByCode(PurchaseGetDTO purchaseGetDTO);

	void batchImport(List<PurchaseImportDTO> dtos);

	List<PurchaseOrderDetailDTO> importDetail(PurchaseImportUpdateDTO dto);

	PageBean<PurchaseOrderDetailDTO> queryPurchaseDetail(PurchaseQueryDTO searchDTO);

	PageBean<PurchaseOrderRptDTO> queryPurchaseDetailRpt(PurchaseQueryDTO searchDTO);

	List<String> checkSupplierRelationship(PurchaseOrderDTO purchaseOrderDTO);
}
