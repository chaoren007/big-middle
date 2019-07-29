package com.morning.star.retail.facade;

import com.morning.star.retail.facade.dto.PurchaseSubmitWmsDTO;
import com.morning.star.retail.facade.dto.PurchaseWmsDTO;

/**
 * 采购订单业务数据
 *
 * @author kimhuhg
 */
public interface PurchaseWmsFacade {
	/**
	 * @param dto
	 * @return 返回1为成功，0为失败
	 */
	Integer add(PurchaseWmsDTO dto);

	/**
	 * 提交采购单
	 */
	Integer submit(PurchaseSubmitWmsDTO dto);

	/**
	 * 关闭采购单
	 */
	Integer close(PurchaseSubmitWmsDTO dto);

	/**
	 * 采购退单出库
	 */
	Integer out(PurchaseSubmitWmsDTO dto);
}
