package com.morning.star.retail.stock.entity;

import javax.persistence.Column;
import javax.persistence.Comment;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

@Table(name = "retail_stock_water")
@Entity
public class StockWaterEntity extends WaterEntity {
    private static final long serialVersionUID = 3871422085023566734L;

    @Column
    @Comment("库存id")
    private Long id;

    @Column(length = 64)
    @Comment("仓库编码")
    private String warehouseCode;

    @Column(length = 64)
    @Comment("仓库名称")
    private String warehouseName;

    @Column
    @Comment("城市id")
    private Long cityId;

    @Column(length = 16)
    @Comment("城市名称")
    private String cityName;

    @Comment("门店编码")
    @Column(length = 64, updatable = false)
    private String storeCode;

    @Comment("门店名称")
    @Column(length = 64)
    private String storeName;

    @Comment("集团编码")
    @Column(length = 64, updatable = false)
    private String groupCode;

    @Comment("集团名称")
    @Column(length = 64)
    private String groupName;

    @Comment("货品编码")
    @Column(length = 32, nullable = false)
    private String productCode;

    @Comment("货品名称")
    @Column(length = 200, nullable = false)
    private String productName;

    @Comment(value = "SAP货品编码")
    @Column(length = 32, nullable = false)
    private String sapProductCode;

    @Comment("商品编码")
    @Column(length = 32, nullable = false)
    private String goodsCode;

    @Comment("商品名称")
    @Column(length = 32, nullable = false)
    private String goodsName;

    @Comment("条形码")
    @Column
    private String upcCode;

    @Comment("在库数量")
    @Column
    private BigDecimal doneInStockNum;

    @Comment("待入数量")
    @Column
    private BigDecimal waitInStockNum;

    @Comment("占用数量")
    @Column
    private BigDecimal preStockNum;

    @Comment("待出数量")
    @Column
    private BigDecimal waitOutStockNum;

    @Comment("已出数量")
    @Column
    private BigDecimal doneOutStockNum;

    @Comment("单位")
    @Column(length = 8)
    private String units;

    @Comment("货品类型 SP-单品,PP-套装")
    @Column(length = 8)
    private String productType;

    @Comment("包装容量")
    @Column
    private Integer packSpecNum;

    @Comment("包装容量单位（如：箱）")
    @Column(length = 32)
    private String packSpecUnits;

    @Comment("库存成本单价（不含税）")
    @Column
    private BigDecimal costPrice;

    @Comment("库存成本单价（含税）")
    @Column
    private BigDecimal taxCostPrice;

    @Comment("库存成本（不含税）")
    @Column
    private BigDecimal totalCost;

    @Comment("库存成本（含税）")
    @Column
    private BigDecimal totalTaxCost;

    @Comment("详情备注")
    @Column(length = 100)
    private String remark;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public String getSapProductCode() {
        return sapProductCode;
    }

    public void setSapProductCode(String sapProductCode) {
        this.sapProductCode = sapProductCode;
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

    public BigDecimal getDoneInStockNum() {
        return doneInStockNum;
    }

    public void setDoneInStockNum(BigDecimal doneInStockNum) {
        this.doneInStockNum = doneInStockNum;
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
