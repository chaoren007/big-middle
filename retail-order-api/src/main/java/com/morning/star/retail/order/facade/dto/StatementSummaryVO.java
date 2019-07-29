package com.morning.star.retail.order.facade.dto;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by lenovo on 2017/11/24.
 */
public class StatementSummaryVO implements Serializable {

    private static final long serialVersionUID = -4163882497708885674L;
    private String storeCode;
    private String storeName;

    //业务类型： 欧亚到家、全球购、扫码购
    private String businessType;
    //支付渠道： 微商城、app、扫码购
    private String tradeChannel;

    private BigDecimal cashAmount = BigDecimal.ZERO;
    //支付宝支付金额
    private BigDecimal aliPayAmount = BigDecimal.ZERO;

    //微信支付金额
    private BigDecimal wxPayAmount = BigDecimal.ZERO;

    /**
     * 其他支付金额
     */
    private BigDecimal otherPayAmount = BigDecimal.ZERO;
    //按业务类型汇总金额
    private BigDecimal businessTypeAmount = BigDecimal.ZERO;
    //按支付渠道汇总金额
    private BigDecimal tradeChannelAmount = BigDecimal.ZERO;

    //总金额
    private BigDecimal totalAmount = BigDecimal.ZERO;

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

    public BigDecimal getCashAmount() {
        return cashAmount;
    }

    public void setCashAmount(BigDecimal cashAmount) {
        this.cashAmount = cashAmount;
    }

    public BigDecimal getAliPayAmount() {
        return aliPayAmount;
    }

    public void setAliPayAmount(BigDecimal aliPayAmount) {
        this.aliPayAmount = aliPayAmount;
    }

    public BigDecimal getWxPayAmount() {
        return wxPayAmount;
    }

    public void setWxPayAmount(BigDecimal wxPayAmount) {
        this.wxPayAmount = wxPayAmount;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public BigDecimal getBusinessTypeAmount() {
        return businessTypeAmount;
    }

    public void setBusinessTypeAmount(BigDecimal businessTypeAmount) {
        this.businessTypeAmount = businessTypeAmount;
    }

    public BigDecimal getTradeChannelAmount() {
        return tradeChannelAmount;
    }

    public void setTradeChannelAmount(BigDecimal tradeChannelAmount) {
        this.tradeChannelAmount = tradeChannelAmount;
    }

    public BigDecimal getOtherPayAmount() {
        return otherPayAmount;
    }

    public void setOtherPayAmount(BigDecimal otherPayAmount) {
        this.otherPayAmount = otherPayAmount;
    }
}
