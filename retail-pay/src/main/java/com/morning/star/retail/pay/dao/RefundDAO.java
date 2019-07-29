package com.morning.star.retail.pay.dao;

import org.apache.ibatis.annotations.Param;

import com.morning.star.retail.pay.entity.ScanRefund;

/**
 * 退款
 * @author Administrator
 *
 */
public interface RefundDAO {

	/**
	 * 获取退款单
	 * @param refundCode
	 * @return
	 */
	ScanRefund getRefund(@Param("code")String refundCode);

	/**
	 * 更新退款单
	 * @param refund
	 * @param code
	 * @return
	 */
	int updateRefund(@Param("refund")ScanRefund refund, @Param("code")String code);

	/**
	 * 保存退款信息
	 * @param refund
	 * @return
	 */
	int saveRefund(ScanRefund refund);
	
}
