package com.morning.star.retail.order.facade.dto;

import com.morning.star.retail.base.poi.ExcelColumn;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by lenovo on 2017/11/30.
 */
public class ExportStatementSummaryDTO implements Serializable {


    private static final long serialVersionUID = 4127073659175242914L;
    //支付渠道： 微商城、app、扫码购
    @ExcelColumn(name = "业务渠道", isExport = true)
    private String tradeChannel;

    //业务类型： 欧亚到家、全球购、扫码购
    @ExcelColumn(name = "业务类型", isExport = true)
    private String businessType;

    //现金
    @ExcelColumn(name = "现金", isExport = true)
    private BigDecimal cashAmount = BigDecimal.ZERO;
    //支付宝支付金额
    @ExcelColumn(name = "支付宝", isExport = true)
    private BigDecimal aliPayAmount = BigDecimal.ZERO;

    //微信支付金额
    @ExcelColumn(name = "微信", isExport = true)
    private BigDecimal wxPayAmount = BigDecimal.ZERO;

    @ExcelColumn(name = "其他支付", isExport = true)
    private BigDecimal otherPayAmount = BigDecimal.ZERO;

    //总金额
    @ExcelColumn(name = "汇总", isExport = true)
    private BigDecimal totalAmount = BigDecimal.ZERO;

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

    public BigDecimal getOtherPayAmount() {
        return otherPayAmount;
    }

    public void setOtherPayAmount(BigDecimal otherPayAmount) {
        this.otherPayAmount = otherPayAmount;
    }
}
