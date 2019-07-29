package com.morning.star.retail.task.helper;

import com.morning.star.retail.order.facade.dto.SalesOrderDTO;

/**
 * 活动服务.
 * @author lujinwu
 *
 */
public interface CheckOrderHelper {

 
	/**
	 * 检车订单是否能取消
	 * @param order
	 * @return
	 */
	public boolean checkCanCancelPay(SalesOrderDTO order);
	
}
