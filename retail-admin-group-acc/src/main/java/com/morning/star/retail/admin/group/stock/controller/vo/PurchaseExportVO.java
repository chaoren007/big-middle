package com.morning.star.retail.admin.group.stock.controller.vo;

import java.io.Serializable;
import java.math.BigDecimal;

import com.morning.star.retail.base.poi.ExcelColumn;

/**
 * Created by lenovo on 2017/11/17.
 */
public class PurchaseExportVO implements Serializable {
    private static final long serialVersionUID = -4143265591197869541L;

    @ExcelColumn(name = "采购单号")
    private String purchaseCode;
    @ExcelColumn(name = "创建时间")
    private String createTime;
    @ExcelColumn(name = "供应商编码")
    private String supplierCode;
    @ExcelColumn(name = "供应商名称")
    private String supplierName;
    @ExcelColumn(name = "采购金额")
    private BigDecimal amount;

    public String getPurchaseCode() {
        return purchaseCode;
    }

    public void setPurchaseCode(String purchaseCode) {
        this.purchaseCode = purchaseCode;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getSupplierCode() {
        return supplierCode;
    }

    public void setSupplierCode(String supplierCode) {
        this.supplierCode = supplierCode;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
