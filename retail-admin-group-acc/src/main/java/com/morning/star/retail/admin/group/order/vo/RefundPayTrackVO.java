package com.morning.star.retail.admin.group.order.vo;

import java.math.BigDecimal;
import java.util.Date;

public class RefundPayTrackVO {
    private Long id;


    private BigDecimal refundAmount;

    private String paymentTradeNo;

    private String operatorName;

    private Integer status;
    private String statusDesc;



//    private Integer target;
//    private Integer way;
//    private Integer client;

    private String desc;
    private Date createTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getRefundAmount() {
        return refundAmount;
    }

    public void setRefundAmount(BigDecimal refundAmount) {
        this.refundAmount = refundAmount;
    }

    public String getPaymentTradeNo() {
        return paymentTradeNo;
    }

    public void setPaymentTradeNo(String paymentTradeNo) {
        this.paymentTradeNo = paymentTradeNo;
    }

    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

//    public Integer getTarget() {
//        return target;
//    }
//
//    public void setTarget(Integer target) {
//        this.target = target;
//    }

//    public Integer getWay() {
//        return way;
//    }
//
//    public void setWay(Integer way) {
//        this.way = way;
//    }
//
//    public Integer getClient() {
//        return client;
//    }
//
//    public void setClient(Integer client) {
//        this.client = client;
//    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getStatusDesc() {
        return statusDesc;
    }

    public void setStatusDesc(String statusDesc) {
        this.statusDesc = statusDesc;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
