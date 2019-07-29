package com.morning.star.retail.order.facade.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by lenovo on 2017/11/24.
 */
public class StatementSummaryOrderVO implements Serializable {

    private static final long serialVersionUID = -1568256439960647250L;

    private String orderCode;

    //账期类型：“入账” “出账”
    private String type;
    private Date payTime;

    private BigDecimal amount = BigDecimal.ZERO;    		//金额

    private String storeCode;
    private String storeName;

    //支付方式
    private Integer payChannel;
    private String payChannelDesc;
    //配送费
    private String deliveryFee;
    //业务类型
    private String businessType;
    //支付渠道
    private String tradeChannel;

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getPayTime() {
        return payTime;
    }

    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
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

    public Integer getPayChannel() {
        return payChannel;
    }

    public void setPayChannel(Integer payChannel) {
        this.payChannel = payChannel;
    }

    public String getPayChannelDesc() {
        return payChannelDesc;
    }

    public void setPayChannelDesc(String payChannelDesc) {
        this.payChannelDesc = payChannelDesc;
    }

    public String getDeliveryFee() {
        return deliveryFee;
    }

    public void setDeliveryFee(String deliveryFee) {
        this.deliveryFee = deliveryFee;
    }

    public String getBusinessType() {
        return businessType;
    }

    public void setBusinessType(String businessType) {
        this.businessType = businessType;
    }

    public String getTradeChannel() {
        return tradeChannel;
    }

    public void setTradeChannel(String tradeChannel) {
        this.tradeChannel = tradeChannel;
    }
}
