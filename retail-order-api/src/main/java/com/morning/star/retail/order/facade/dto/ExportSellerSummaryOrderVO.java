package com.morning.star.retail.order.facade.dto;

import com.morning.star.retail.base.poi.ExcelColumn;

import java.io.Serializable;
import java.math.BigDecimal;


/**
 * Created by lenovo on 2018/1/5.
 */
public class ExportSellerSummaryOrderVO implements Serializable {
    private static final long serialVersionUID = 2720488644075985569L;

    @ExcelColumn(name = "促销员", isExport = true)
    private String sellerCode;

    @ExcelColumn(name = "促销员编码", isExport = true)
    private String sellerName;

    @ExcelColumn(name = "门店名称", isExport = true)
    private String storeName;

    @ExcelColumn(name = "门店编码", isExport = true)
    private String storeCode;

    @ExcelColumn(name = "订单时间", isExport = true)
    private String payTime;

    @ExcelColumn(name = "订单号/退款单号", isExport = true)
    private String orderCode;

    @ExcelColumn(name = "订单金额", isExport = true)
    private BigDecimal amount = BigDecimal.ZERO;

    @ExcelColumn(name = "模式", isExport = true)
    private String type;

    public String getSellerCode() {
        return sellerCode;
    }

    public void setSellerCode(String sellerCode) {
        this.sellerCode = sellerCode;
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getStoreCode() {
        return storeCode;
    }

    public void setStoreCode(String storeCode) {
        this.storeCode = storeCode;
    }

    public String getPayTime() {
        return payTime;
    }

    public void setPayTime(String payTime) {
        this.payTime = payTime;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
