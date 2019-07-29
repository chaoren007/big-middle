package com.morning.star.retail.admin.group.stock.controller.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.morning.star.retail.base.poi.ExcelColumn;

/**
 * Created by lenovo on 2018/5/3.
 */
public class PurchaseDetailRptExportVO implements Serializable {

    private static final long serialVersionUID = -1462294568434137504L;
    @ExcelColumn(name = "采购单号")
    private String purchaseCode;
    @ExcelColumn(name = "创建时间")
    private String purchaseTime;
    @ExcelColumn(name = "状态")
    private String statusName;
    @ExcelColumn(name = "货品编码")
    private String goodsCode;
    @ExcelColumn(name = "货品名称")
    private String goodsName;

    @ExcelColumn(name = "UPC")
    private String upc;
    @ExcelColumn(name = "单位")
    private String units;
    /**
     * 规格
     */
    @ExcelColumn(name = "规格")
    private String specInfo;

    @ExcelColumn(name = "供应商编码")
    private String supplierCode;
    @ExcelColumn(name = "供应商名称")
    private String supplierName;

    /**
     * 采购价
     */
    @ExcelColumn(name = "采购价")
    private BigDecimal price= BigDecimal.ZERO;
    @ExcelColumn(name = "采购数量")
    private BigDecimal qty;
    @ExcelColumn(name = "采购金额")
    private BigDecimal amount;
    //入库单号
    @ExcelColumn(name = "入库单号")
    private String receiptCode;
    //入库时间
    @ExcelColumn(name = "入库时间")
    private Date receiptTime;
    /**
     * 入库门店
     */
    @ExcelColumn(name = "入库门店")
    private String storeCode;
    /**
     * 入库门店名称
     */
    @ExcelColumn(name = "入库门店名称")
    private String storeName;

    /**
     * 入库数量
     */
    @ExcelColumn(name = "入库数量")
    private BigDecimal receiptQty;

    /**
     * 入库金额
     */
    @ExcelColumn(name = "入库金额")
    private BigDecimal receiptAmount;

    /**
     * 未入库数量
     */
    @ExcelColumn(name = "未入库数量")
    private BigDecimal noReceiptQty;
    /**
     * 未入库金额
     */
    @ExcelColumn(name = "未入库金额")
    private BigDecimal noReceiptAmount;

    /**
     * 备注
     */
    @ExcelColumn(name = "备注")
    private String memo;


    public String getPurchaseCode() {
        return purchaseCode;
    }

    public void setPurchaseCode(String purchaseCode) {
        this.purchaseCode = purchaseCode;
    }

    public String getPurchaseTime() {
        return purchaseTime;
    }

    public void setPurchaseTime(String purchaseTime) {
        this.purchaseTime = purchaseTime;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    public String getGoodsCode() {
        return goodsCode;
    }

    public void setGoodsCode(String goodsCode) {
        this.goodsCode = goodsCode;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getUpc() {
        return upc;
    }

    public void setUpc(String upc) {
        this.upc = upc;
    }

    public String getUnits() {
        return units;
    }

    public void setUnits(String units) {
        this.units = units;
    }

    public String getSpecInfo() {
        return specInfo;
    }

    public void setSpecInfo(String specInfo) {
        this.specInfo = specInfo;
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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getQty() {
        return qty;
    }

    public void setQty(BigDecimal qty) {
        this.qty = qty;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getReceiptCode() {
        return receiptCode;
    }

    public void setReceiptCode(String receiptCode) {
        this.receiptCode = receiptCode;
    }

    public Date getReceiptTime() {
        return receiptTime;
    }

    public void setReceiptTime(Date receiptTime) {
        this.receiptTime = receiptTime;
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

    public BigDecimal getReceiptQty() {
        return receiptQty;
    }

    public void setReceiptQty(BigDecimal receiptQty) {
        this.receiptQty = receiptQty;
    }

    public BigDecimal getReceiptAmount() {
        return receiptAmount;
    }

    public void setReceiptAmount(BigDecimal receiptAmount) {
        this.receiptAmount = receiptAmount;
    }

    public BigDecimal getNoReceiptQty() {
        return noReceiptQty;
    }

    public void setNoReceiptQty(BigDecimal noReceiptQty) {
        this.noReceiptQty = noReceiptQty;
    }

    public BigDecimal getNoReceiptAmount() {
        return noReceiptAmount;
    }

    public void setNoReceiptAmount(BigDecimal noReceiptAmount) {
        this.noReceiptAmount = noReceiptAmount;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }
}
