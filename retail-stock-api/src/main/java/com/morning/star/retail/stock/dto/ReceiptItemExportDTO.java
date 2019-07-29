package com.morning.star.retail.stock.dto;

import com.morning.star.retail.base.poi.ExcelColumn;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by kimhuhg.
 */
public class ReceiptItemExportDTO implements Serializable {

    private static final long serialVersionUID = 4641390325344723431L;

    @ExcelColumn(name = "入库编码")
    private String receiptCode;

    @ExcelColumn(name = "商品编码")
    private String goodsCode;

    @ExcelColumn(name = "货品名称")
    private String productName;

    @ExcelColumn(name = "单位")
    private String unitsName;

    @ExcelColumn(name = "upc编码")
    private String upcCode;

    @ExcelColumn(name = "入库数量")
    private BigDecimal qty=BigDecimal.ZERO;

    @ExcelColumn(name = "入库价")
    private BigDecimal price=BigDecimal.ZERO;

    @ExcelColumn(name = "实收入库数量")
    private BigDecimal realQty;

    @ExcelColumn(name = "保质期")
    private Integer shelfLife;

    @ExcelColumn(name = "生产日期")
    private Date productionDate;

    public String getReceiptCode() {
        return receiptCode;
    }

    public void setReceiptCode(String receiptCode) {
        this.receiptCode = receiptCode;
    }

    public String getGoodsCode() {
        return goodsCode;
    }

    public void setGoodsCode(String goodsCode) {
        this.goodsCode = goodsCode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getUnitsName() {
        return unitsName;
    }

    public void setUnitsName(String unitsName) {
        this.unitsName = unitsName;
    }

    public String getUpcCode() {
        return upcCode;
    }

    public void setUpcCode(String upcCode) {
        this.upcCode = upcCode;
    }

    public BigDecimal getQty() {
        return qty;
    }

    public void setQty(BigDecimal qty) {
        this.qty = qty;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getRealQty() {
        return realQty;
    }

    public void setRealQty(BigDecimal realQty) {
        this.realQty = realQty;
    }

    public Integer getShelfLife() {
        return shelfLife;
    }

    public void setShelfLife(Integer shelfLife) {
        this.shelfLife = shelfLife;
    }

    public Date getProductionDate() {
        return productionDate;
    }

    public void setProductionDate(Date productionDate) {
        this.productionDate = productionDate;
    }
}
