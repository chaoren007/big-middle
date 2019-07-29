package com.morning.star.retail.stock.application;

import com.morning.star.retail.facade.dto.out.OutStockAuditDTO;
import com.morning.star.retail.facade.dto.out.OutStockDTO;
import com.morning.star.retail.facade.dto.out.OutStockOutDTO;
import com.morning.star.retail.facade.dto.out.OutStockSubmitDTO;

/**
 * 出库
 */
public interface OutStockApplication {

	/**
	 * 保存出库单
	 */
	void save(OutStockSubmitDTO formDTO);

	/**
	 * 审核出库单
	 */
	void audit(OutStockAuditDTO auditDTO);

	/**
	 * 出库
	 */
	void auditOut(OutStockOutDTO outStockOutDTO);

	void delete(String outStockCode);

	void updateReceiptCode(String purchaseCode, String receiptCode);

	/**
	 * 推送出库单
	 * @param code
	 */
	void pushThird(String code);

	/**
	 * WMS出库
	 */
	void wmsOutStock(OutStockDTO dto);

}
