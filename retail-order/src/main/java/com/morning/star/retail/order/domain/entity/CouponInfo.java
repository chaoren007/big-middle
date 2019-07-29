package com.morning.star.retail.order.domain.entity;

import java.math.BigDecimal;

/**
 * 订单的优惠券
 * @author Administrator
 *
 */
public class CouponInfo {

    private String couponCode;				//优惠券码
    private BigDecimal couponAmount = BigDecimal.ZERO;		//优惠券优惠金额  
	
    
    
    public CouponInfo() {
	}
	public CouponInfo(String couponCode) {
		this.couponCode = couponCode;
	}
	public String getCouponCode() {
		return couponCode;
	}
	public BigDecimal getCouponAmount() {
		return couponAmount;
	}
	public void setCouponAmount(BigDecimal couponAmount) {
		this.couponAmount = couponAmount;
	}
	public void setCouponCode(String couponCode) {
		this.couponCode = couponCode;
	}
	
	
	
}
