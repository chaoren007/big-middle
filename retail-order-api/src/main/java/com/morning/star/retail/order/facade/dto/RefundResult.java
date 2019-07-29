package com.morning.star.retail.order.facade.dto;

import com.morning.star.retail.order.enums.RefundPayStatus;

import java.io.Serializable;

public class RefundResult implements Serializable{

    private RefundPayStatus payStatus;


    private String payNo;
    private String payType;
    private String refundStatusDesc;    // 查询返回的状态
    private String refundAmount;
    private String requestNo;


    public RefundResult() {

    }

    public String getPayNo() {
        return payNo;
    }

    public void setPayNo(String payNo) {
        this.payNo = payNo;
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

    public String getRefundStatusDesc() {
        return refundStatusDesc;
    }

    public void setRefundStatusDesc(String refundStatusDesc) {
        this.refundStatusDesc = refundStatusDesc;
    }

    public String getRefundAmount() {
        return refundAmount;
    }

    public void setRefundAmount(String refundAmount) {
        this.refundAmount = refundAmount;
    }

    public String getRequestNo() {
        return requestNo;
    }

    public void setRequestNo(String requestNo) {
        this.requestNo = requestNo;
    }

    public RefundPayStatus getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(RefundPayStatus payStatus) {
        this.payStatus = payStatus;
    }

}
