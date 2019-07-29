package com.morning.star.retail.order.qo;

public class RefundUpdateQO {

    private String code;
    private Integer oldStatus;
    private Integer newStatus;
    private String payNo;

    private String requestNo;
    private Integer amountRefundStatus;
    private Integer oldAmountRefundStatus;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getOldStatus() {
        return oldStatus;
    }

    public void setOldStatus(Integer oldStatus) {
        this.oldStatus = oldStatus;
    }

    public Integer getNewStatus() {
        return newStatus;
    }

    public void setNewStatus(Integer newStatus) {
        this.newStatus = newStatus;
    }

    public String getPayNo() {
        return payNo;
    }

    public void setPayNo(String payNo) {
        this.payNo = payNo;
    }

    public String getRequestNo() {
        return requestNo;
    }

    public void setRequestNo(String requestNo) {
        this.requestNo = requestNo;
    }

    public Integer getAmountRefundStatus() {
        return amountRefundStatus;
    }

    public void setAmountRefundStatus(Integer amountRefundStatus) {
        this.amountRefundStatus = amountRefundStatus;
    }

    public Integer getOldAmountRefundStatus() {
        return oldAmountRefundStatus;
    }

    public void setOldAmountRefundStatus(Integer oldAmountRefundStatus) {
        this.oldAmountRefundStatus = oldAmountRefundStatus;
    }
}
