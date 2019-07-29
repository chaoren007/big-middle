package com.morning.star.retail.facade;

import com.morning.star.retail.facade.dto.purchasein.*;
import com.morning.star.retail.utils.page.PageBean;

/**
 * 采购入库单
 */
public interface PurchaseInFacade {

	PageBean<PurchaseInOrderSimpleDTO> queryOrder(PurchaseInQueryDTO searchDTO);

	PurchaseInOrderDTO getByCode(PurchaseInGetDTO purchaseInGetDTO);

	/**
	 * 更新采购入库单预计入库时间
	 */
	void updatePreReceiptTime(PurchaseInUpdateDTO purchaseInUpdateDTO);

	/**
	 * 根据入库单信息更新采购入库单中的入库数据
	 */
	void updateReceiptQty(PurchaseInUpdateDTO purchaseInUpdateDTO);

	/**
	 * 关闭采购入库单
	 */
	void auditClose(PurchaseInAuditDTO purchaseInAuditDTO);

	/**
	 * 把采购入库单推送给WMS
	 * @param code 采购订单
	 */
	void pushThird(String code);

	/**
	 * 获取采购入库单采购货品信息
	 */
	PurchaseInOrderDetailDTO getDetail(String purchaseInCode, String productCode);

}
