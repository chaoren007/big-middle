package com.morning.star.retail.order.facade.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class RefundDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private String refundCode;
    private Date createTime;
    private Date modifyTime;
    private Long operatorId;
    private String operatorName; 
    private String afterSalesCode;
    private BigDecimal amount;
    private Integer amountRefundStatus;
    private String buyerPhone;
    private Integer channel;
    private String orderCode;
    private Integer payChannel;
    private String payRequestNo;
    private String receiverPhone;
    private String refundInfo;
    private Date refundTime;
    private String refundWaterCode;
    private String remark;
    private Integer status;
    private String groupCode;
    private String groupName;
    private String storeCode;
    private String storeName;
    private String storePhone;
    private Integer type;
    private Integer way;
    
    public String getRefundCode() {
        return refundCode;
    }
    public void setRefundCode(String refundCode) {
        this.refundCode = refundCode;
    }
    public Date getCreateTime() {
        return createTime;
    }
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
    public Date getModifyTime() {
        return modifyTime;
    }
    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }
    public Long getOperatorId() {
        return operatorId;
    }
    public void setOperatorId(Long operatorId) {
        this.operatorId = operatorId;
    }
    public String getOperatorName() {
        return operatorName;
    }
    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
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
    public Integer getAmountRefundStatus() {
        return amountRefundStatus;
    }
    public void setAmountRefundStatus(Integer amountRefundStatus) {
        this.amountRefundStatus = amountRefundStatus;
    }
    public String getBuyerPhone() {
        return buyerPhone;
    }
    public void setBuyerPhone(String buyerPhone) {
        this.buyerPhone = buyerPhone;
    }
    public Integer getChannel() {
        return channel;
    }
    public void setChannel(Integer channel) {
        this.channel = channel;
    }
    public String getOrderCode() {
        return orderCode;
    }
    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }
    public Integer getPayChannel() {
        return payChannel;
    }
    public void setPayChannel(Integer payChannel) {
        this.payChannel = payChannel;
    }
    public String getPayRequestNo() {
        return payRequestNo;
    }
    public void setPayRequestNo(String payRequestNo) {
        this.payRequestNo = payRequestNo;
    }
    public String getReceiverPhone() {
        return receiverPhone;
    }
    public void setReceiverPhone(String receiverPhone) {
        this.receiverPhone = receiverPhone;
    }
    public String getRefundInfo() {
        return refundInfo;
    }
    public void setRefundInfo(String refundInfo) {
        this.refundInfo = refundInfo;
    }
    public Date getRefundTime() {
        return refundTime;
    }
    public void setRefundTime(Date refundTime) {
        this.refundTime = refundTime;
    }
    public String getRefundWaterCode() {
        return refundWaterCode;
    }
    public void setRefundWaterCode(String refundWaterCode) {
        this.refundWaterCode = refundWaterCode;
    }
    public String getRemark() {
        return remark;
    }
    public void setRemark(String remark) {
        this.remark = remark;
    }
    public Integer getStatus() {
        return status;
    }
    public void setStatus(Integer status) {
        this.status = status;
    }
    public String getGroupCode() {
        return groupCode;
    }
    public void setGroupCode(String groupCode) {
        this.groupCode = groupCode;
    }
    public String getGroupName() {
        return groupName;
    }
    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }
    public String getStoreCode() {
        return storeCode;
    }
    public void setStoreCode(String storeCode) {
        this.storeCode = storeCode;
    }
    public String getStoreName() {
        return storeName;
    }
    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }
    public String getStorePhone() {
        return storePhone;
    }
    public void setStorePhone(String storePhone) {
        this.storePhone = storePhone;
    }
    public Integer getType() {
        return type;
    }
    public void setType(Integer type) {
        this.type = type;
    }
    public Integer getWay() {
        return way;
    }
    public void setWay(Integer way) {
        this.way = way;
    }
    
}
