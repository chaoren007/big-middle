package com.morning.star.retail.stock.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 库存
 *
 * @author jiangyf
 */
@ApiModel
public class StockDTO implements Serializable {
    private static final long serialVersionUID = -298016382709475288L;

    @ApiModelProperty("仓库编码")
    private String warehouseCode;

    @ApiModelProperty("仓库名称")
    private String warehouseName;

    @ApiModelProperty("城市id")
    private Long cityId;

    @ApiModelProperty("城市名称")
    private String cityName;

    @ApiModelProperty("门店编码")
    private String storeCode;

    @ApiModelProperty("门店名称")
    private String storeName;

    @ApiModelProperty("集团编码")
    private String groupCode;

    @ApiModelProperty("集团名称")
    private String groupName;

    @ApiModelProperty(value = "SAP货品编码")
    private String sapProductCode;

    @ApiModelProperty(value = "货品编码")
    private String productCode;

    @ApiModelProperty(value = "货品名称")
    private String productName;

    @ApiModelProperty(value = "商品编码")
    private String goodsCode;

    @ApiModelProperty(value = "商品名称")
    private String goodsName;

    @ApiModelProperty(value = "upc")
    private String upcCode;

    @ApiModelProperty(value = "货品图片")
    private String iconPath;

    @ApiModelProperty(value = "在库数量")
    private BigDecimal doneInStockNum;

    @ApiModelProperty(value = "可售数量")
    private BigDecimal usedStockNum;

    @ApiModelProperty(value = "待入数量")
    private BigDecimal waitInStockNum;

    @ApiModelProperty(value = "预占数量")
    private BigDecimal preStockNum;

    @ApiModelProperty(value = "待出数量")
    private BigDecimal waitOutStockNum;

    @ApiModelProperty(value = "已出数量")
    private BigDecimal doneOutStockNum;

    @ApiModelProperty(value = "单位")
    private String units;

    @ApiModelProperty(value = "货品类型 SP-单品,PP-套装")
    private String productType;

    @ApiModelProperty(value = "包装容量")
    private Integer packSpecNum;

    @ApiModelProperty(value = "包装容量单位")
    private String packSpecUnits;

    @ApiModelProperty(value = "库存成本单价（不含税）")
    private BigDecimal costPrice;

    @ApiModelProperty(value = "库存成本单价（含税）")
    private BigDecimal taxCostPrice;

    @ApiModelProperty(value = "库存成本（不含税）")
    private BigDecimal totalCost;

    @ApiModelProperty(value = "库存成本（含税）")
    private BigDecimal totalTaxCost;

    public String getWarehouseCode() {
        return warehouseCode;
    }

    public void setWarehouseCode(String warehouseCode) {
        this.warehouseCode = warehouseCode;
    }

    public String getWarehouseName() {
        return warehouseName;
    }

    public void setWarehouseName(String warehouseName) {
        this.warehouseName = warehouseName;
    }

    public Long getCityId() {
        return cityId;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
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

    public String getGroupCode() {
        return groupCode;
    }

    public void setGroupCode(String groupCode) {
        this.groupCode = groupCode;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getSapProductCode() {
        return sapProductCode;
    }

    public void setSapProductCode(String sapProductCode) {
        this.sapProductCode = sapProductCode;
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

    public String getIconPath() {
        return iconPath;
    }

    public void setIconPath(String iconPath) {
        this.iconPath = iconPath;
    }

    public BigDecimal getDoneInStockNum() {
        return doneInStockNum;
    }

    public void setDoneInStockNum(BigDecimal doneInStockNum) {
        this.doneInStockNum = doneInStockNum;
    }

    public BigDecimal getUsedStockNum() {
        return usedStockNum;
    }

    public void setUsedStockNum(BigDecimal usedStockNum) {
        this.usedStockNum = usedStockNum;
    }

    public BigDecimal getWaitInStockNum() {
        return waitInStockNum;
    }

    public void setWaitInStockNum(BigDecimal waitInStockNum) {
        this.waitInStockNum = waitInStockNum;
    }

    public BigDecimal getPreStockNum() {
        return preStockNum;
    }

    public void setPreStockNum(BigDecimal preStockNum) {
        this.preStockNum = preStockNum;
    }

    public BigDecimal getWaitOutStockNum() {
        return waitOutStockNum;
    }

    public void setWaitOutStockNum(BigDecimal waitOutStockNum) {
        this.waitOutStockNum = waitOutStockNum;
    }

    public BigDecimal getDoneOutStockNum() {
        return doneOutStockNum;
    }

    public void setDoneOutStockNum(BigDecimal doneOutStockNum) {
        this.doneOutStockNum = doneOutStockNum;
    }

    public String getUnits() {
        return units;
    }

    public void setUnits(String units) {
        this.units = units;
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

    public BigDecimal getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(BigDecimal costPrice) {
        this.costPrice = costPrice;
    }

    public BigDecimal getTaxCostPrice() {
        return taxCostPrice;
    }

    public void setTaxCostPrice(BigDecimal taxCostPrice) {
        this.taxCostPrice = taxCostPrice;
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
}
