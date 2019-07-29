package com.morning.star.retail.order.facade.dto;

import java.io.Serializable;
import java.math.BigDecimal;

public class FinishRefundDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private String afterSalesCode;
    private BigDecimal amount;
    private String refundInfo;
    
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
    public String getRefundInfo() {
        return refundInfo;
    }
    public void setRefundInfo(String refundInfo) {
        this.refundInfo = refundInfo;
    }
}
