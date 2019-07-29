package com.morning.star.retail.stock.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Comment;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.morning.star.retail.stock.enums.InventoryTerminalStatus;

@Comment("盘点明细流水")
@Table(name = "retail_inventory_item_water")
@Entity
public class InventoryItemWaterEntity extends WaterEntity {
    private static final long serialVersionUID = 692695806729879986L;

    @Comment("明细id")
    @Column
    private Long id;

    @Comment("盘点编码")
    @Column(length = 64)
    private String inventoryCode;

    @Comment("商品编码")
    @Column(length = 32, nullable = false)
    private String goodsCode;

    @Comment("货品编码")
    @Column(length = 32, nullable = false)
    private String productCode;

    @Comment("货品名称")
    @Column(length = 200, nullable = false)
    private String productName;

    @Comment("单位")
    @Column(length = 10, nullable = false)
    private String units;

    @Comment("货品类型 SP-单品,PP-套装")
    @Column(length = 2)
    private String productType;

    @Comment("包装容量")
    @Column
    private Integer packSpecNum;

    @Comment("包装容量单位（如：箱）")
    @Column(length = 10)
    private String packSpecUnits;

    @Comment("品牌ID")
    @Column(length = 64)
    private Long brandId;

    @Comment("品牌名称")
    @Column(length = 64)
    private String brandName;

    @Comment("一级类目ID")
    @Column(length = 64)
    private Long categoryId1;

    @Comment("一级类目")
    @Column(length = 64)
    private String categoryName1;

    @Comment("二级类目ID")
    private Long categoryId2;

    @Comment("二级类目")
    @Column(length = 64)
    private String categoryName2;

    @Comment("三级类目ID")
    @Column(length = 64)
    private Long categoryId3;

    @Comment("三级类目")
    @Column(length = 64)
    private String categoryName3;

    @Comment("四级类目ID")
    @Column(length = 64)
    private Long categoryId4;

    @Comment("四级类目")
    @Column(length = 64)
    private String categoryName4;

    @Comment("五级类目ID")
    @Column(length = 64)
    private Long categoryId5;

    @Comment("五级类目")
    @Column(length = 64)
    private String categoryName5;

    @Comment("货架数量")
    @Column
    private BigDecimal shelfNum;

    @Comment("仓库数量")
    @Column
    private BigDecimal warehouseNum;

    @Comment("调整数量")
    @Column
    private BigDecimal adjustNum;

    @Comment("合计数量（货架数量+仓库数量+调整数量）")
    @Column
    private BigDecimal totalNum;

    @Comment("在库数量")
    @Column
    private BigDecimal doneInStockNum;

    @Comment("货架调整数量（暂未使用，默认为0）")
    @Column
    private BigDecimal shelfAdjustNum;

    @Comment("仓库调整数量（暂未使用，默认为0）")
    @Column
    private BigDecimal warehouseAdjustNum;

    @Comment("货架合计数量（货架数量+货架调整）")
    @Column
    private BigDecimal shelfTotalNum;

    @Comment("仓库合计数量（仓库数量+仓库调整）")
    @Column
    private BigDecimal warehouseTotalNum;

    @Comment("货架盘点状态")
    @Column
    @Convert(converter = InventoryTerminalStatus.DBConverter.class)
    private InventoryTerminalStatus shelfStatus;

    @Comment("仓库盘点状态")
    @Column
    @Convert(converter = InventoryTerminalStatus.DBConverter.class)
    private InventoryTerminalStatus warehouseStatus;

    @Comment("货架区域编号")
    @Column
    private String shelfAreaNo;

    @Comment("仓库区域编号")
    @Column
    private String warehouseAreaNo;

    @Comment("货架盘点日期")
    @Column
    private Date shelfDate;

    @Comment("仓库盘点日期")
    @Column
    private Date warehouseDate;

    @Comment("货架盘点人")
    @Column
    private Long shelfOperatorId;

    @Comment("仓库盘点人")
    @Column
    private Long warehouseOperatorId;

    @Comment("盘点状态：1：盘盈，2：盘亏，3：漏盘")
    @Column
    private Integer status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getInventoryCode() {
        return inventoryCode;
    }

    public void setInventoryCode(String inventoryCode) {
        this.inventoryCode = inventoryCode;
    }

    public String getGoodsCode() {
        return goodsCode;
    }

    public void setGoodsCode(String goodsCode) {
        this.goodsCode = goodsCode;
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

    public Long getBrandId() {
        return brandId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public Long getCategoryId1() {
        return categoryId1;
    }

    public void setCategoryId1(Long categoryId1) {
        this.categoryId1 = categoryId1;
    }

    public String getCategoryName1() {
        return categoryName1;
    }

    public void setCategoryName1(String categoryName1) {
        this.categoryName1 = categoryName1;
    }

    public Long getCategoryId2() {
        return categoryId2;
    }

    public void setCategoryId2(Long categoryId2) {
        this.categoryId2 = categoryId2;
    }

    public String getCategoryName2() {
        return categoryName2;
    }

    public void setCategoryName2(String categoryName2) {
        this.categoryName2 = categoryName2;
    }

    public Long getCategoryId3() {
        return categoryId3;
    }

    public void setCategoryId3(Long categoryId3) {
        this.categoryId3 = categoryId3;
    }

    public String getCategoryName3() {
        return categoryName3;
    }

    public void setCategoryName3(String categoryName3) {
        this.categoryName3 = categoryName3;
    }

    public Long getCategoryId4() {
        return categoryId4;
    }

    public void setCategoryId4(Long categoryId4) {
        this.categoryId4 = categoryId4;
    }

    public String getCategoryName4() {
        return categoryName4;
    }

    public void setCategoryName4(String categoryName4) {
        this.categoryName4 = categoryName4;
    }

    public Long getCategoryId5() {
        return categoryId5;
    }

    public void setCategoryId5(Long categoryId5) {
        this.categoryId5 = categoryId5;
    }

    public String getCategoryName5() {
        return categoryName5;
    }

    public void setCategoryName5(String categoryName5) {
        this.categoryName5 = categoryName5;
    }

    public BigDecimal getShelfNum() {
        return shelfNum;
    }

    public void setShelfNum(BigDecimal shelfNum) {
        this.shelfNum = shelfNum;
    }

    public BigDecimal getWarehouseNum() {
        return warehouseNum;
    }

    public void setWarehouseNum(BigDecimal warehouseNum) {
        this.warehouseNum = warehouseNum;
    }

    public BigDecimal getAdjustNum() {
        return adjustNum;
    }

    public void setAdjustNum(BigDecimal adjustNum) {
        this.adjustNum = adjustNum;
    }

    public BigDecimal getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(BigDecimal totalNum) {
        this.totalNum = totalNum;
    }

    public BigDecimal getDoneInStockNum() {
        return doneInStockNum;
    }

    public void setDoneInStockNum(BigDecimal doneInStockNum) {
        this.doneInStockNum = doneInStockNum;
    }

    public BigDecimal getShelfAdjustNum() {
        return shelfAdjustNum;
    }

    public void setShelfAdjustNum(BigDecimal shelfAdjustNum) {
        this.shelfAdjustNum = shelfAdjustNum;
    }

    public BigDecimal getWarehouseAdjustNum() {
        return warehouseAdjustNum;
    }

    public void setWarehouseAdjustNum(BigDecimal warehouseAdjustNum) {
        this.warehouseAdjustNum = warehouseAdjustNum;
    }

    public BigDecimal getShelfTotalNum() {
        return shelfTotalNum;
    }

    public void setShelfTotalNum(BigDecimal shelfTotalNum) {
        this.shelfTotalNum = shelfTotalNum;
    }

    public BigDecimal getWarehouseTotalNum() {
        return warehouseTotalNum;
    }

    public void setWarehouseTotalNum(BigDecimal warehouseTotalNum) {
        this.warehouseTotalNum = warehouseTotalNum;
    }

    public InventoryTerminalStatus getShelfStatus() {
        return shelfStatus;
    }

    public void setShelfStatus(InventoryTerminalStatus shelfStatus) {
        this.shelfStatus = shelfStatus;
    }

    public InventoryTerminalStatus getWarehouseStatus() {
        return warehouseStatus;
    }

    public void setWarehouseStatus(InventoryTerminalStatus warehouseStatus) {
        this.warehouseStatus = warehouseStatus;
    }

    public String getShelfAreaNo() {
        return shelfAreaNo;
    }

    public void setShelfAreaNo(String shelfAreaNo) {
        this.shelfAreaNo = shelfAreaNo;
    }

    public String getWarehouseAreaNo() {
        return warehouseAreaNo;
    }

    public void setWarehouseAreaNo(String warehouseAreaNo) {
        this.warehouseAreaNo = warehouseAreaNo;
    }

    public Date getShelfDate() {
        return shelfDate;
    }

    public void setShelfDate(Date shelfDate) {
        this.shelfDate = shelfDate;
    }

    public Date getWarehouseDate() {
        return warehouseDate;
    }

    public void setWarehouseDate(Date warehouseDate) {
        this.warehouseDate = warehouseDate;
    }

    public Long getShelfOperatorId() {
        return shelfOperatorId;
    }

    public void setShelfOperatorId(Long shelfOperatorId) {
        this.shelfOperatorId = shelfOperatorId;
    }

    public Long getWarehouseOperatorId() {
        return warehouseOperatorId;
    }

    public void setWarehouseOperatorId(Long warehouseOperatorId) {
        this.warehouseOperatorId = warehouseOperatorId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
