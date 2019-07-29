package com.morning.star.retail.stock.dto;

import com.morning.star.retail.base.poi.ExcelColumn;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by lenovo on 2017/11/16.
 */
public class ExportReceiptDetailDTO implements Serializable {
    private static final long serialVersionUID = -4824435727021500248L;

    @ExcelColumn(name = "货品编码")
    private String goodsCode;
    @ExcelColumn(name = "货品名称")
    private String goodsName;
    @ExcelColumn(name = "UPC")
    private String upc;
    @ExcelColumn(name = "采购单价",isExport = false)
    private BigDecimal price;
    @ExcelColumn(name = "采购数量")
    private BigDecimal qty;
    @ExcelColumn(name = "入库数量")
    private BigDecimal realQty;
    @ExcelColumn(name = "单位")
    private String units;
    @ExcelColumn(name = "采购金额",isExport = false)
    private BigDecimal amount;
    /**
     * 实收入库金额/入库成本
     */
    @ExcelColumn(name = "入库成本", isExport = false)
    private BigDecimal realAmount;
    @ExcelColumn(name = "入库门店名称")
    private String storeName;
    @ExcelColumn(name = "入库门店编码")
    private String storeCode;

    @ExcelColumn(name = "调出门店名称",isExport = false)
    private String outStoreName;
    @ExcelColumn(name = "调出门店编码",isExport = false)
    private String outStoreCode;

    @ExcelColumn(name = "保质期")
    private String shelfLife;
    @ExcelColumn(name = "生产日期")
    private String productionDate;

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

    public BigDecimal getRealQty() {
        return realQty;
    }

    public void setRealQty(BigDecimal realQty) {
        this.realQty = realQty;
    }

    public String getUnits() {
        return units;
    }

    public void setUnits(String units) {
        this.units = units;
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

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getOutStoreName() {
        return outStoreName;
    }

    public void setOutStoreName(String outStoreName) {
        this.outStoreName = outStoreName;
    }

    public String getOutStoreCode() {
        return outStoreCode;
    }

    public void setOutStoreCode(String outStoreCode) {
        this.outStoreCode = outStoreCode;
    }

    public String getShelfLife() {
        return shelfLife;
    }

    public void setShelfLife(String shelfLife) {
        this.shelfLife = shelfLife;
    }

    public String getProductionDate() {
        return productionDate;
    }

    public void setProductionDate(String productionDate) {
        this.productionDate = productionDate;
    }

    public BigDecimal getRealAmount() {
        return realAmount;
    }

    public void setRealAmount(BigDecimal realAmount) {
        this.realAmount = realAmount;
    }
}
