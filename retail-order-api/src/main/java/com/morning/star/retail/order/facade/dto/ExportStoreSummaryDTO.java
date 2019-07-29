package com.morning.star.retail.order.facade.dto;

import com.morning.star.retail.base.poi.ExcelColumn;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by lenovo on 2017/11/30.
 */
public class ExportStoreSummaryDTO implements Serializable {


    private static final long serialVersionUID = 9083182006671191933L;
    @ExcelColumn(name = "门店", isExport = true)
    private String storeName;

    //支付宝支付金额
    @ExcelColumn(name = "支付宝", isExport = true)
    private BigDecimal aliPayAmount = BigDecimal.ZERO;

    //微信支付金额
    @ExcelColumn(name = "微信", isExport = true)
    private BigDecimal wxPayAmount = BigDecimal.ZERO;

    @ExcelColumn(name = "现金", isExport = true)
    private BigDecimal cashAmount= BigDecimal.ZERO;

    @ExcelColumn(name = "其他支付", isExport = true)
    private BigDecimal otherPayAmount = BigDecimal.ZERO;

    //总金额
    @ExcelColumn(name = "汇总", isExport = true)
    private BigDecimal totalAmount = BigDecimal.ZERO;

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
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

    public BigDecimal getCashAmount() {
        return cashAmount;
    }

    public void setCashAmount(BigDecimal cashAmount) {
        this.cashAmount = cashAmount;
    }

    public BigDecimal getOtherPayAmount() {
        return otherPayAmount;
    }

    public void setOtherPayAmount(BigDecimal otherPayAmount) {
        this.otherPayAmount = otherPayAmount;
    }
}
