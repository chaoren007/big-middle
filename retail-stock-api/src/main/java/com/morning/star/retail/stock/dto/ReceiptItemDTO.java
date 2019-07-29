package com.morning.star.retail.stock.dto;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class ReceiptItemDTO implements Serializable {
    private static final long serialVersionUID = 4641390325344723431L;

    @ApiModelProperty(value = "id")
    private Long id;

    @ApiModelProperty(value = "入库单号")
    private String receiptCode;

    @ApiModelProperty("商品编码")
    private String goodsCode;

    @ApiModelProperty("商品名称")
    private String goodsName;

    @ApiModelProperty("条形码")
    private String upcCode;

    @ApiModelProperty(value = "货品编码")
    private String productCode;

    @ApiModelProperty(value = "货品名称")
    private String productName;

    @ApiModelProperty("规格信息")
    private String spuInfo;

    @ApiModelProperty(value = "货品类型:SP-单品,PP-套装")
    private String productType;

    @ApiModelProperty(value = "包装数量")
    private Integer packSpecNum;

    @ApiModelProperty(value = "包装单位")
    private String packSpecUnits;

    @ApiModelProperty(value = "单位id")
    private Long unitsId;

    @ApiModelProperty(value = "单位名称")
    private String unitsName;

    @ApiModelProperty("标准类型（0：非称重，1：称重）")
    private Integer standardType;

    @ApiModelProperty(value = "需要入库数量")
    private BigDecimal needNum;

    @ApiModelProperty(value = "实收入库数量")
    private BigDecimal realNum;

    @ApiModelProperty("库存成本（不含税）")
    private BigDecimal totalCost;

    @ApiModelProperty("库存成本（含税）")
    private BigDecimal totalTaxCost;

    @ApiModelProperty(value = "保质期")
    private Integer shelfLife;

    @ApiModelProperty(value = "生产日期")
    private Date productionDate;

    @ApiModelProperty(value = "过期日期")
    private Date expirationDate;

    @ApiModelProperty(value = "备注说明")
    private String remark;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
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

    public String getSpuInfo() {
        return spuInfo;
    }

    public void setSpuInfo(String spuInfo) {
        this.spuInfo = spuInfo;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
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

    public Long getUnitsId() {
        return unitsId;
    }

    public void setUnitsId(Long unitsId) {
        this.unitsId = unitsId;
    }

    public String getUnitsName() {
        return unitsName;
    }

    public void setUnitsName(String unitsName) {
        this.unitsName = unitsName;
    }

    public Integer getStandardType() {
        return standardType;
    }

    public void setStandardType(Integer standardType) {
        this.standardType = standardType;
    }

    public BigDecimal getNeedNum() {
        return needNum;
    }

    public void setNeedNum(BigDecimal needNum) {
        this.needNum = needNum;
    }

    public BigDecimal getRealNum() {
        return realNum;
    }

    public void setRealNum(BigDecimal realNum) {
        this.realNum = realNum;
    }

    public BigDecimal getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(BigDecimal totalCost) {
        this.totalCost = totalCost;
    }

    public BigDecimal getTotalTaxCost() {
        return totalTaxCost;
    }

    public void setTotalTaxCost(BigDecimal totalTaxCost) {
        this.totalTaxCost = totalTaxCost;
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
