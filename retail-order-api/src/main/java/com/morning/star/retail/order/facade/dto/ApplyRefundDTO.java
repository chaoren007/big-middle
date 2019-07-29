package com.morning.star.retail.order.facade.dto;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 申请退款DTO.
 * @author Tim
 *
 */
public class ApplyRefundDTO implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = -8492464184390327985L;
	private String groupCode;
	private String companyCode;
    private String orderCode;
    private String afterSalesCode;
    private BigDecimal amount;		//退款金额
    private int refundType;
    private String remark;
    
    private BigDecimal prepayCardAmount;	//退款的预付款金额
    
    
    public BigDecimal getPrepayCardAmount() {
		return prepayCardAmount;
	}
	public void setPrepayCardAmount(BigDecimal prepayCardAmount) {
		this.prepayCardAmount = prepayCardAmount;
	}
	public String getOrderCode() {
        return orderCode;
    }
    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }
    public String getAfterSalesCode() {
        return afterSalesCode;
    }
    public void setAfterSalesCode(String afterSalesCode) {
        this.afterSalesCode = afterSalesCode;
    }
    public BigDecimal getAmount() {
        return amount;
    }
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
    public int getRefundType() {
        return refundType;
    }
    public void setRefundType(int refundType) {
        this.refundType = refundType;
    }
    public String getRemark() {
        return remark;
    }
    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getGroupCode() {
        return groupCode;
    }

    public void setGroupCode(String groupCode) {
        this.groupCode = groupCode;
    }

    public String getCompanyCode() {
        return companyCode;
    }
    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }
    
}
