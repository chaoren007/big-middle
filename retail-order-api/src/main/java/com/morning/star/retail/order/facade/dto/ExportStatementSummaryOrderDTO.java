package com.morning.star.retail.order.facade.dto;

import com.morning.star.retail.base.poi.ExcelColumn;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by lenovo on 2017/11/30.
 */
public class ExportStatementSummaryOrderDTO implements Serializable {


    private static final long serialVersionUID = -6797480464117403743L;
    @ExcelColumn(name = "订单号（退款单号）", isExport = true)
    private String orderCode;

    @ExcelColumn(name = "时间", isExport = true)
    private String createTime;

    @ExcelColumn(name = "门店编码", isExport = true)
    private String storeCode;

    @ExcelColumn(name = "门店", isExport = true)
    private String storeName;

    //支付方式
    @ExcelColumn(name = "支付方式", isExport = true)
    private String payChannelDesc;

    //支付渠道： 微商城、app、扫码购
    @ExcelColumn(name = "业务渠道", isExport = true)
    private String tradeChannel;

    //业务类型： 欧亚到家、全球购、扫码购
    @ExcelColumn(name = "业务类型", isExport = true)
    private String businessType;

    //账期类型：“入账” “出账”
    @ExcelColumn(name = "模式", isExport = true)
    private String type;

    @ExcelColumn(name = "金额", isExport = true)
    private BigDecimal amount = BigDecimal.ZERO;    		//金额

    //配送费
    @ExcelColumn(name = "运费", isExport = true)
    private String deliveryFee;

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
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

    public String getPayChannelDesc() {
        return payChannelDesc;
    }

    public void setPayChannelDesc(String payChannelDesc) {
        this.payChannelDesc = payChannelDesc;
    }

    public String getTradeChannel() {
        return tradeChannel;
    }

    public void setTradeChannel(String tradeChannel) {
        this.tradeChannel = tradeChannel;
    }

    public String getBusinessType() {
        return businessType;
    }

    public void setBusinessType(String businessType) {
        this.businessType = businessType;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getDeliveryFee() {
        return deliveryFee;
    }

    public void setDeliveryFee(String deliveryFee) {
        this.deliveryFee = deliveryFee;
    }
}
