package com.morning.star.retail.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "供应货品")
public class SupplierItemDTO implements Serializable {
    private static final long serialVersionUID = -1932115876410624055L;

    @ApiModelProperty(value = "集团编码")
    private String groupCode;

    @ApiModelProperty(value = "供应商编码")
    private String supplierCode;

    @ApiModelProperty(value = "供应商名称")
    private String supplierName;

    @ApiModelProperty(value = "SAP货品编码")
    private String sapProductCode;

    @ApiModelProperty(value = "货品编码")
    private String productCode;

    @ApiModelProperty(value = "货品名称")
    private String productName;

    @ApiModelProperty(value = "货品upc")
    private String upcCode;

    @ApiModelProperty(value = "货品图片")
    private String iconPath;

    @ApiModelProperty(value = "单位")
    private String units;

    @ApiModelProperty(value = "规格信息")
    private String spuInfo;

    @ApiModelProperty(value = "一级分类id")
    private Long categoryId1;

    @ApiModelProperty(value = "一级分类名称")
    private String categoryName1;

    @ApiModelProperty(value = "二级分类id")
    private Long categoryId2;

    @ApiModelProperty(value = "二级分类名称")
    private String categoryName2;

    @ApiModelProperty(value = "三级分类id")
    private Long categoryId3;

    @ApiModelProperty(value = "三级分类名称")
    private String categoryName3;

    @ApiModelProperty(value = "四级分类id")
    private Long categoryId4;

    @ApiModelProperty(value = "四级分类名称")
    private String categoryName4;

    @ApiModelProperty(value = "五级分类id")
    private Long categoryId5;

    @ApiModelProperty(value = "五级分类名称")
    private String categoryName5;

    @ApiModelProperty(value = "税率")
    private Integer taxRate;

    @ApiModelProperty(value = "价格")
    private BigDecimal price;

    public String getGroupCode() {
        return groupCode;
    }

    public void setGroupCode(String groupCode) {
        this.groupCode = groupCode;
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

    public String getUnits() {
        return units;
    }

    public void setUnits(String units) {
        this.units = units;
    }

    public String getSpuInfo() {
        return spuInfo;
    }

    public void setSpuInfo(String spuInfo) {
        this.spuInfo = spuInfo;
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

    public Integer getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(Integer taxRate) {
        this.taxRate = taxRate;
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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
