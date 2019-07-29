package com.morning.star.retail.order.qo;

import java.math.BigDecimal;

public class AfterSalesOrderUpdateQO {

    private int newStatus;
    private int oldStatus;
    private long id;
    private BigDecimal refundAmount;
    private BigDecimal prepayCardAmount;
    private String remark;
    private int hasReturnedItem;

    public int getNewStatus() {
        return newStatus;
    }

    public void setNewStatus(int newStatus) {
        this.newStatus = newStatus;
    }

    public int getOldStatus() {
        return oldStatus;
    }

    public void setOldStatus(int oldStatus) {
        this.oldStatus = oldStatus;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public BigDecimal getRefundAmount() {
        return refundAmount;
    }

    public void setRefundAmount(BigDecimal refundAmount) {
        this.refundAmount = refundAmount;
    }

    public BigDecimal getPrepayCardAmount() {
        return prepayCardAmount;
    }

    public void setPrepayCardAmount(BigDecimal prepayCardAmount) {
        this.prepayCardAmount = prepayCardAmount;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public int getHasReturnedItem() {
        return hasReturnedItem;
    }

    public void setHasReturnedItem(int hasReturnedItem) {
        this.hasReturnedItem = hasReturnedItem;
    }
}
