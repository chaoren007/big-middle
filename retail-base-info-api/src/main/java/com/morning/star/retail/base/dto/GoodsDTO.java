package com.morning.star.retail.base.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.validation.constraints.NotNull;

import com.morning.star.retail.validate.CreateGroup;

/**
 * Created by liangguobin on 2017/5/9.
 */
public class GoodsDTO implements Serializable {
    private static final long serialVersionUID = 735382006815547012L;

    /** ##################### 新增货品属性 ##################### */
    /**
     * 货品编码
     */
    @NotNull(message = "货品编码")
    private String goodsCode;
    /**
     * 货品名称
     */
    @NotNull(message = "货品名称")
    private String goodsName;
    /**
     * 分类1ID
     */
    private Long categoryId1;
    /**
     * 分类1名字
     */
    private String categoryName1;
    /**
     * 分类2ID
     */
    private Long categoryId2;
    /**
     * 分类2名字
     */
    private String categoryName2;
    /**
     * 分类3ID
     */
    private Long categoryId3;
    /**
     * 分类3名字
     */
    private String categoryName3;
    /**
     * 品牌id
     */
    private Integer brandId;
    /**
     * 品牌名称
     */
    private String brandName;
    /**
     * 头图
     */
    private String iconPath;
    /**
     * 条形码
     */
    @NotNull(message = "upc")
    private String upcCode;
    /**
     * 标准类型（0：非称重，1：称重）
     */
    private Integer standardType;
    /**
     * 单位id
     */
    private Integer unitsId;
    /**
     * 计量单位
     */
    @NotNull(message = "计量单位")
    private String unitsName;
    /**
     * 重量
     */
    @NotNull(message = "重量")
    private BigDecimal weight;
    /**
     * 成本价
     */
    private BigDecimal costPrice;
    /**
     * 销售指导价
     */
    @NotNull(message = "销售指导价")
    private BigDecimal guidePrice;
    /**
     * 是否为序列号管理，0-否 1-是
     */
    @NotNull(message = "序列号管理")
    private Integer isSerialCode;
    /**
     * 货品规格
     */
    private List<GoodsSpecDTO> goodsSpecInfo;
    /**
     * 商品图册图片（逗号隔开）
     */
    private String imgPaths;
    /**
     * 商品介绍图片（逗号隔开）
     */
    private String introImgPaths;
    /**
     * 公司编码
     */
    private String companyCode;
    /**
     * 公司编码
     */
    private String groupCode;
    /**
     * 操作人id
     */
    private Integer operatorId;
    /**
     * 操作人名
     */
    private String operatorName;
    /**
     * 商品规格编码
     */
    private String spuCode;
    /**
     * 权重
     */
    private Integer priority;

    /**
     * 销售价
     */
    @NotNull(message = "请输入销售价", groups = CreateGroup.class) // 添加商品时必填
    private BigDecimal salePrice;

    /**
     * 三公里配送字段 1是 0否 TODO
     */
    private Integer delivery;

    /**
     * 销售类型（0：仅自营；1：仅代销；2：先自营后代销；3：先代销后自营）
     */
    @NotNull(message = "销售类型")
    private Integer salesType;

    /**
     * 供应商编码
     */
    @NotNull(message = "供应商编码")
    private String supplierCode;

    /**
     * 供应商名称
     */
    private String supplierName;

    /**
     * 采购价
     */
    private BigDecimal purchasePrice;

    /**
     * 产地
     */
    private String originPlace;

    /**
     * 税率
     */
    private Integer taxRate;

    /**
     * ##################### 查询结果 #####################
     */
    private Integer id;
    private Integer saleStatus;
    private Integer status;
    private String goodsSpecs;
    private List<SpuSpecDTO> spuSpecInfo;

    /**
     * ##################### 以下属性暂时未用到 #####################
     */
    private String goodsType;
    private Integer packSpecNum;
    private String packSpecUnits;
    // 包装规格描述，如“10个/箱”
    private String packSpecDesc;
    private String unitGoodsCode;
    private String goodsIntroduce;
    private String customAttrs;
    private String tagIds;
    private Integer shelfLife;
    private String unitGoodsUpc;


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

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getIconPath() {
        return iconPath;
    }

    public void setIconPath(String iconPath) {
        this.iconPath = iconPath;
    }

    public String getUpcCode() {
        return upcCode;
    }

    public void setUpcCode(String upcCode) {
        this.upcCode = upcCode;
    }

    public Integer getStandardType() {
        return standardType;
    }

    public void setStandardType(Integer standardType) {
        this.standardType = standardType;
    }

    public String getUnitsName() {
        return unitsName;
    }

    public void setUnitsName(String unitsName) {
        this.unitsName = unitsName;
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
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

    public Integer getIsSerialCode() {
        return isSerialCode;
    }

    public void setIsSerialCode(Integer isSerialCode) {
        this.isSerialCode = isSerialCode;
    }

    public List<GoodsSpecDTO> getGoodsSpecInfo() {
        return goodsSpecInfo;
    }

    public void setGoodsSpecInfo(List<GoodsSpecDTO> goodsSpecInfo) {
        this.goodsSpecInfo = goodsSpecInfo;
    }

    public String getImgPaths() {
        return imgPaths;
    }

    public void setImgPaths(String imgPaths) {
        this.imgPaths = imgPaths;
    }

    public String getIntroImgPaths() {
        return introImgPaths;
    }

    public void setIntroImgPaths(String introImgPaths) {
        this.introImgPaths = introImgPaths;
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }

    public String getSpuCode() {
        return spuCode;
    }

    public void setSpuCode(String spuCode) {
        this.spuCode = spuCode;
    }

    public BigDecimal getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(BigDecimal salePrice) {
        this.salePrice = salePrice;
    }

    public String getCategoryName1() {
        return categoryName1;
    }

    public void setCategoryName1(String categoryName1) {
        this.categoryName1 = categoryName1;
    }

    public String getCategoryName2() {
        return categoryName2;
    }

    public void setCategoryName2(String categoryName2) {
        this.categoryName2 = categoryName2;
    }

    public String getCategoryName3() {
        return categoryName3;
    }

    public void setCategoryName3(String categoryName3) {
        this.categoryName3 = categoryName3;
    }

    public Integer getSaleStatus() {
        return saleStatus;
    }

    public void setSaleStatus(Integer saleStatus) {
        this.saleStatus = saleStatus;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getGoodsSpecs() {
        return goodsSpecs;
    }

    public void setGoodsSpecs(String goodsSpecs) {
        this.goodsSpecs = goodsSpecs;
    }

    public List<SpuSpecDTO> getSpuSpecInfo() {
        return spuSpecInfo;
    }

    public void setSpuSpecInfo(List<SpuSpecDTO> spuSpecInfo) {
        this.spuSpecInfo = spuSpecInfo;
    }

    public String getGoodsType() {
        return goodsType;
    }

    public void setGoodsType(String goodsType) {
        this.goodsType = goodsType;
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

    public String getPackSpecDesc() {
        return packSpecDesc;
    }

    public void setPackSpecDesc(String packSpecDesc) {
        this.packSpecDesc = packSpecDesc;
    }

    public String getUnitGoodsCode() {
        return unitGoodsCode;
    }

    public void setUnitGoodsCode(String unitGoodsCode) {
        this.unitGoodsCode = unitGoodsCode;
    }

    public String getGoodsIntroduce() {
        return goodsIntroduce;
    }

    public void setGoodsIntroduce(String goodsIntroduce) {
        this.goodsIntroduce = goodsIntroduce;
    }

    public String getCustomAttrs() {
        return customAttrs;
    }

    public void setCustomAttrs(String customAttrs) {
        this.customAttrs = customAttrs;
    }

    public String getTagIds() {
        return tagIds;
    }

    public void setTagIds(String tagIds) {
        this.tagIds = tagIds;
    }

    public Integer getShelfLife() {
        return shelfLife;
    }

    public void setShelfLife(Integer shelfLife) {
        this.shelfLife = shelfLife;
    }

    public String getUnitGoodsUpc() {
        return unitGoodsUpc;
    }

    public void setUnitGoodsUpc(String unitGoodsUpc) {
        this.unitGoodsUpc = unitGoodsUpc;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public void setCategoryId1(Long categoryId1) {
        this.categoryId1 = categoryId1;
    }

    public void setCategoryId2(Long categoryId2) {
        this.categoryId2 = categoryId2;
    }

    public void setCategoryId3(Long categoryId3) {
        this.categoryId3 = categoryId3;
    }

    public Integer getBrandId() {
        return brandId;
    }

    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
    }

    public void setUnitsId(Integer unitsId) {
        this.unitsId = unitsId;
    }

    public Integer getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(Integer operatorId) {
        this.operatorId = operatorId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getCategoryId1() {
        return categoryId1;
    }

    public Long getCategoryId2() {
        return categoryId2;
    }

    public Long getCategoryId3() {
        return categoryId3;
    }

    public Integer getUnitsId() {
        return unitsId;
    }

    public Integer getDelivery() {
        return delivery;
    }

    public void setDelivery(Integer delivery) {
        this.delivery = delivery;
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

    public String getGroupCode() {
        return groupCode;
    }

    public void setGroupCode(String groupCode) {
        this.groupCode = groupCode;
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
}
