package com.morning.star.retail.stock.application;

import com.morning.star.retail.facade.dto.purchase.*;

import java.util.List;

public interface PurchaseApplication {

	/**
	 * 提交采购单
	 */
	String submitOrder(PurchaseSubmitDTO purchaseSubmitDTO);


	/**
	 * 更新采购单
	 */
	String updateOrder(PurchaseUpdateDTO purchaseUpdateDTO);

	void batchImport(List<PurchaseImportDTO> purchaseImportDTOS);

	List<PurchaseOrderDetailDTO> importDetail(PurchaseImportUpdateDTO dto);

	/**
	 * 审核订单
	 */
	PurchaseOrderDTO auditPurchase(PurchaseAuditDTO dto);

	/**
	 * 禁用订单
	 */
	Integer deletePurchase(PurchaseDeleteDTO dto);

	List<String> checkSupplierRelationship(PurchaseOrderDTO purchaseOrderDTO);
}
