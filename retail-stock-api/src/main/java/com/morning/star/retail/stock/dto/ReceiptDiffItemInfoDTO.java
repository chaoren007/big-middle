package com.morning.star.retail.stock.dto;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by kimhuhg.
 */
public class ReceiptDiffItemInfoDTO implements Serializable {
    private static final long serialVersionUID = 4641390325344723431L;

    private Long id;

    @ApiModelProperty(value = "入库差异单编码")
    private String receiptDiffCode;

    @ApiModelProperty(value = "商品编码")
    private String goodsCode;

    @ApiModelProperty(value = "单位id")
    private String unitsId;

    @ApiModelProperty(value = "单位名称")
    private String unitsName;

    @ApiModelProperty(value = "upc编码")
    private String upcCode;

    @ApiModelProperty(value = "包装规格数量")
    private Integer packSpecNum;

    @ApiModelProperty(value = "包装规格单位")
    private String packSpecUnits;

    @ApiModelProperty(value = "货品编码")
    private String productCode;

    @ApiModelProperty(value = "货品名称")
    private String productName;

    @ApiModelProperty(value = "货品类型")
    private String productType;

    @ApiModelProperty(value = "采购价")
    private BigDecimal price;

    @ApiModelProperty(value = "备注")
    private String remark;

    @ApiModelProperty(value = "保质期")
    private Integer shelfLife;

    @ApiModelProperty(value = "生产日期")
    private Date productionDate;

    @ApiModelProperty(value = "过期时间")
    private Date expirationDate;

    @ApiModelProperty(value = "差异数量")
    private BigDecimal differenceQty;

    @ApiModelProperty(value = "差异原因")
    private String diffReason;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "SAP编码")
    private String sapProductCode;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public Integer getPackSpecNum() {
        return packSpecNum;
    }

    public void setPackSpecNum(Integer packSpecNum) {
        this.packSpecNum = packSpecNum;
    }

    public String getPackSpecUnits() {
        return packSpecUnits;
    }

    public void setPackSpecUnits(String packSpecUnits) {
        this.packSpecUnits = packSpecUnits;
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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getSapProductCode() {
        return sapProductCode;
    }

    public void setSapProductCode(String sapProductCode) {
        this.sapProductCode = sapProductCode;
    }
}
