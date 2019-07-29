package com.morning.star.retail.order.facade.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 销售订单（对账单用）
 *
 */
public class DealSaleOrderDTO implements Serializable{

   	/**
	 * 
	 */
	private static final long serialVersionUID = 8547925446801525705L;
      private String code;
	  private BigDecimal payAmount;
	  private  Date createTime;
	  

	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public BigDecimal getPayAmount() {
		return payAmount;
	}
	public void setPayAmount(BigDecimal payAmount) {
		this.payAmount = payAmount;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	  
	  
}
