package com.morning.star.retail.stock.helper.vo;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;

public class GoodsInfo implements Serializable {
    private static final long serialVersionUID = 735382006815547012L;

    @ApiModelProperty(value = "商品编码")
    private String goodsCode;

    @ApiModelProperty(value = "商品名称")
    private String goodsName;

    @ApiModelProperty(value = "母码")
    private String sapMotherCode;

    @ApiModelProperty(value = "门店编码")
    private String storeCode;

    @ApiModelProperty(value = "门店名称")
    private String storeName;

    @ApiModelProperty(value = "销售价")
    private BigDecimal salePrice;

    @ApiModelProperty(value = "货品编码")
    private String productCode;

    @ApiModelProperty(value = "货品SAP编码")
    private String sapProductCode;

    @ApiModelProperty(value = "货品名称")
    private String productName;

    @ApiModelProperty(value = "规格编码")
    private String spuCode;

    @ApiModelProperty(value = "规格详情")
    private String spuInfo;

    @ApiModelProperty(value = "UPC编码")
    private String upcCode;

    @ApiModelProperty(value = "计量单位ID")
    private Long unitsId;

    @ApiModelProperty(value = "计量单位名称")
    private String unitsName;

    @ApiModelProperty(value = "货品类型 SP-单品,PP-套装")
    private String productType;

    @ApiModelProperty(value = "包装容量")
    private Integer packSpecNum;

    @ApiModelProperty(value = "包装容量单位（如：箱）")
    private String packSpecUnits;

    @ApiModelProperty(value = "如果是单品为null，如果是套装，记录套装内对应单品的product_code")
    private String unitProductCode;

    @ApiModelProperty(value = "上下市状态0：下架状态  1：上架状态")
    private Integer status;

    @ApiModelProperty(value = "上下市状态0：下架状态  1：上架状态")
    private Integer marketStatus;

    @ApiModelProperty(value = "上下架状态0：下架状态  1：上架状态")
    private Integer saleStatus;

    @ApiModelProperty(value = "成本价")
    private BigDecimal costPrice;

    @ApiModelProperty(value = "销售指导价")
    private BigDecimal guidePrice;

    @ApiModelProperty(value = "品牌ID")
    private Long brandId;

    @ApiModelProperty(value = "品牌名称")
    private String brandName;

    @ApiModelProperty(value = "标准类型（0：非称重，1：称重）")
    private Integer standardType;

    @ApiModelProperty(value = "货品重量")
    private String weight;

    @ApiModelProperty(value = "货品介绍")
    private String productIntroduce;

    @ApiModelProperty(value = "是否序列化管理 0：否  1：是")
    private Integer isSerialCode;

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

    @ApiModelProperty(value = "保质期（天）")
    private Integer shelfLife;

    @ApiModelProperty(value = "销售类型（0：仅自营；1：仅代销；2：先自营后代销；3：先代销后自营）")
    private Integer salesType;

    @ApiModelProperty(value = "供应商编码")
    private String supplierCode;

    @ApiModelProperty(value = "供应商名称")
    private String supplierName;

    @ApiModelProperty(value = "采购价")
    private BigDecimal purchasePrice;

    @ApiModelProperty(value = "产地")
    private String originPlace;

    @ApiModelProperty(value = "税率")
    private Integer taxRate;

    @ApiModelProperty(value = "生鲜类型，0,普通商品;1,称重管重量；2,称重不管重量;3,计件")
    private Integer freshType;

    @ApiModelProperty(value = "集团编码")
    private String groupCode;

    @ApiModelProperty("集团名称")
    private String groupName;

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

    public String getSapMotherCode() {
        return sapMotherCode;
    }

    public void setSapMotherCode(String sapMotherCode) {
        this.sapMotherCode = sapMotherCode;
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

    public BigDecimal getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(BigDecimal salePrice) {
        this.salePrice = salePrice;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getSapProductCode() {
        return sapProductCode;
    }

    public void setSapProductCode(String sapProductCode) {
        this.sapProductCode = sapProductCode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getSpuCode() {
        return spuCode;
    }

    public void setSpuCode(String spuCode) {
        this.spuCode = spuCode;
    }

    public String getSpuInfo() {
        return spuInfo;
    }

    public void setSpuInfo(String spuInfo) {
        this.spuInfo = spuInfo;
    }

    public String getUpcCode() {
        return upcCode;
    }

    public void setUpcCode(String upcCode) {
        this.upcCode = upcCode;
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

    public String getUnitProductCode() {
        return unitProductCode;
    }

    public void setUnitProductCode(String unitProductCode) {
        this.unitProductCode = unitProductCode;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getMarketStatus() {
        return marketStatus;
    }

    public void setMarketStatus(Integer marketStatus) {
        this.marketStatus = marketStatus;
    }

    public Integer getSaleStatus() {
        return saleStatus;
    }

    public void setSaleStatus(Integer saleStatus) {
        this.saleStatus = saleStatus;
    }

    public BigDecimal getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(BigDecimal costPrice) {
        this.costPrice = costPrice;
    }

    public BigDecimal getGuidePrice() {
        return guidePrice;
    }

    public void setGuidePrice(BigDecimal guidePrice) {
        this.guidePrice = guidePrice;
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

    public Integer getStandardType() {
        return standardType;
    }

    public void setStandardType(Integer standardType) {
        this.standardType = standardType;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getProductIntroduce() {
        return productIntroduce;
    }

    public void setProductIntroduce(String productIntroduce) {
        this.productIntroduce = productIntroduce;
    }

    public Integer getIsSerialCode() {
        return isSerialCode;
    }

    public void setIsSerialCode(Integer isSerialCode) {
        this.isSerialCode = isSerialCode;
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

    public Integer getShelfLife() {
        return shelfLife;
    }

    public void setShelfLife(Integer shelfLife) {
        this.shelfLife = shelfLife;
    }

    public Integer getSalesType() {
        return salesType;
    }

    public void setSalesType(Integer salesType) {
        this.salesType = salesType;
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

    public BigDecimal getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(BigDecimal purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public String getOriginPlace() {
        return originPlace;
    }

    public void setOriginPlace(String originPlace) {
        this.originPlace = originPlace;
    }

    public Integer getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(Integer taxRate) {
        this.taxRate = taxRate;
    }

    public Integer getFreshType() {
        return freshType;
    }

    public void setFreshType(Integer freshType) {
        this.freshType = freshType;
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
}
