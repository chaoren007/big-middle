package com.morning.star.retail.facade;

import com.morning.star.retail.facade.dto.OutStockSubmitWmsDTO;
import com.morning.star.retail.facade.dto.OutStockWmsDTO;
import com.morning.star.retail.facade.dto.PurchaseWmsDTO;

/**
 * 出入库订单业务数据(S-销售出库单，P-调拨出库单，SR-销售入库单，PR-调拨入库单）
 * @author kimhuhg
 */
public interface OutStockWmsFacade {
	/**
	 *
	 * @param dto
	 * @return 返回1为成功，0为失败
	 */
	Integer add(OutStockWmsDTO dto);

	/**
	 * 销售出库
	 */
	Integer sellOutSubmit(OutStockSubmitWmsDTO dto);

	/**
	 * 调拨出库
	 */
	Integer transferOutSubmit(OutStockSubmitWmsDTO dto);

	/**
	 * 销售退货入库
	 */
	Integer sellInSubmit(OutStockSubmitWmsDTO dto);

	/**
	 * 调拨入库
	 */
	Integer transferInSubmit(OutStockSubmitWmsDTO dto);
}
