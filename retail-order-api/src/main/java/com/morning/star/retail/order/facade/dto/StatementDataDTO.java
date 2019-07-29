package com.morning.star.retail.order.facade.dto;

import java.io.Serializable;
import java.math.BigDecimal;

public class StatementDataDTO implements Serializable{
	  
	  
	    /**
	 * 
	 */
	private static final long serialVersionUID = -2852474972810725196L;
		//	成交订单金额
	    private BigDecimal dealAmount;
	    //退款金额
	    private BigDecimal refundAmount;
	 
		
		public BigDecimal getDealAmount() {
			return dealAmount;
		}

		public void setDealAmount(BigDecimal dealAmount) {
			this.dealAmount = dealAmount;
		}

		public BigDecimal getRefundAmount() {
			return refundAmount;
		}

		public void setRefundAmount(BigDecimal refundAmount) {
			this.refundAmount = refundAmount;
		}

	
	    
}
