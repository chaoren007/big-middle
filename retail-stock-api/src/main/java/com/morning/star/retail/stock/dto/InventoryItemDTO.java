package com.morning.star.retail.stock.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@ApiModel(value = "盘点单")
public class InventoryItemDTO implements Serializable {
    private static final long serialVersionUID = -8141872529794177353L;

    @ApiModelProperty(value = "任务编码")
    private String taskCode;

    @ApiModelProperty(value = "商品编码")
    private String goodsCode;

    @ApiModelProperty(value = "货品编码")
    private String productCode;

    @ApiModelProperty(value = "货品名称")
    private String productName;

    @ApiModelProperty(value = "集团编码")
    private String groupCode;

    @ApiModelProperty(value = "门店编码")
    private String storeCode;

    @ApiModelProperty(value = "门店名称")
    private String storeName;

    @ApiModelProperty(value = "品牌ID")
    private Long brandId;

    @ApiModelProperty(value = "品牌名称")
    private String brandName;

    @ApiModelProperty(value = "一级类目ID")
    private Long categoryId1;

    @ApiModelProperty(value = "一级类目")
    private String categoryName1;

    @ApiModelProperty(value = "二级类目ID")
    private Long categoryId2;

    @ApiModelProperty(value = "二级类目")
    private String categoryName2;

    @ApiModelProperty(value = "三级类目ID")
    private Long categoryId3;

    @ApiModelProperty(value = "三级类目")
    private String categoryName3;

    @ApiModelProperty(value = "四级类目ID")
    private Long categoryId4;

    @ApiModelProperty(value = "四级类目")
    private String categoryName4;

    @ApiModelProperty(value = "五级类目ID")
    private Long categoryId5;

    @ApiModelProperty(value = "五级类目")
    private String categoryName5;

    @ApiModelProperty(value = "货架数量")
    private BigDecimal shelfNum;

    @ApiModelProperty(value = "仓库数量")
    private BigDecimal warehouseNum;

    @ApiModelProperty(value = "调整数量")
    private BigDecimal adjustNum;

    @ApiModelProperty(value = "合计数量（货架数量+仓库数量+调整数量）")
    private BigDecimal totalNum;

    @ApiModelProperty(value = "在库数量")
    private BigDecimal doneInStockNum;

    @ApiModelProperty(value = "货架调整数量（暂未使用，默认为0）")
    private BigDecimal shelfAdjustNum;

    @ApiModelProperty(value = "仓库调整数量（暂未使用，默认为0）")
    private BigDecimal warehouseAdjustNum;

    @ApiModelProperty(value = "货架合计数量（货架数量+货架调整）")
    private BigDecimal shelfTotalNum;

    @ApiModelProperty(value = "仓库合计数量（仓库数量+仓库调整）")
    private BigDecimal warehouseTotalNum;

    @ApiModelProperty(value = "货架盘点状态")
    private Integer shelfStatus;

    @ApiModelProperty(value = "仓库盘点状态")
    private Integer warehouseStatus;

    @ApiModelProperty(value = "货架区域编号")
    private String shelfAreaNo;

    @ApiModelProperty(value = "仓库区域编号")
    private String warehouseAreaNo;

    @ApiModelProperty(value = "货架盘点日期")
    private Date shelfDate;

    @ApiModelProperty(value = "仓库盘点日期")
    private Date warehouseDate;

    @ApiModelProperty(value = "货架盘点人")
    private Long shelfOperatorId;

    @ApiModelProperty(value = "仓库盘点人")
    private Long warehouseOperatorId;

    @ApiModelProperty(value = "盘点状态：1：盘盈，2：盘亏，3：漏盘")
    private Integer status;

    public String getTaskCode() {
        return taskCode;
    }

    public void setTaskCode(String taskCode) {
        this.taskCode = taskCode;
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

    public String getGroupCode() {
        return groupCode;
    }

    public void setGroupCode(String groupCode) {
        this.groupCode = groupCode;
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

    public Integer getShelfStatus() {
        return shelfStatus;
    }

    public void setShelfStatus(Integer shelfStatus) {
        this.shelfStatus = shelfStatus;
    }

    public Integer getWarehouseStatus() {
        return warehouseStatus;
    }

    public void setWarehouseStatus(Integer warehouseStatus) {
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

