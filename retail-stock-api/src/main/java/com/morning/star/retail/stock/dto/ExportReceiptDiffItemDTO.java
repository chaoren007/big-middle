package com.morning.star.retail.stock.dto;

import com.morning.star.retail.base.poi.ExcelColumn;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by kimhuhg.
 */
public class ExportReceiptDiffItemDTO implements Serializable {
    private static final long serialVersionUID = 4641390325344723431L;

    @ExcelColumn(name = "入库差异单编码")
    private String receiptDiffCode;

    @ExcelColumn(name = "货品编码")
    private String goodsCode;

    @ExcelColumn(name = "单位id")
    private String unitsId;

    @ExcelColumn(name = "单位名称")
    private String unitsName;

    @ExcelColumn(name = "upc编码")
    private String upcCode;

    @ExcelColumn(name = "产品编码")
    private String productCode;

    @ExcelColumn(name = "产品名称")
    private String productName;

    @ExcelColumn(name = "产品类型")
    private String productType;

    @ExcelColumn(name = "入库价")
    private BigDecimal price;

    @ExcelColumn(name = "备注")
    private String remark;

    @ExcelColumn(name = "保质期")
    private Integer shelfLife;

    @ExcelColumn(name = "生产日期")
    private Date productionDate;

    @ExcelColumn(name = "过期时间")
    private Date expirationDate;

    @ExcelColumn(name = "差异数量")
    private BigDecimal differenceQty;

    @ExcelColumn(name = "差异原因")
    private String diffReason;

    public String getReceiptDiffCode() {
        return receiptDiffCode;
    }

    public void setReceiptDiffCode(String receiptDiffCode) {
        this.receiptDiffCode = receiptDiffCode;
    }

    public String getGoodsCode() {
        return goodsCode;
    }

    public void setGoodsCode(String goodsCode) {
        this.goodsCode = goodsCode;
    }

    public String getUnitsId() {
        return unitsId;
    }

    public void setUnitsId(String unitsId) {
        this.unitsId = unitsId;
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

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
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

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public BigDecimal getDifferenceQty() {
        return differenceQty;
    }

    public void setDifferenceQty(BigDecimal differenceQty) {
        this.differenceQty = differenceQty;
    }

    public String getDiffReason() {
        return diffReason;
    }

    public void setDiffReason(String diffReason) {
        this.diffReason = diffReason;
    }
}
