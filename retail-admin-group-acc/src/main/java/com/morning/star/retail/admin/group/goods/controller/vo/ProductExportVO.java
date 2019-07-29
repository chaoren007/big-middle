package com.morning.star.retail.admin.group.goods.controller.vo;


import java.io.Serializable;
import java.math.BigDecimal;

import com.morning.star.retail.base.poi.ExcelColumn;

/**
 * Created by ethan on 2018/5/3.
 */
public class ProductExportVO implements Serializable {

	private static final long serialVersionUID = 5899067468623906496L;

	@ExcelColumn(name = "商品名称")
	private String productName;

	@ExcelColumn(name = "商品编码")
	private String productCode;

	@ExcelColumn(name = "UPC")
	private String upcCode;

	@ExcelColumn(name = "一级分类ID")
	private Long categoryId1;

	@ExcelColumn(name = "一级分类名称")
	private String categoryName1;

	@ExcelColumn(name = "二级分类ID")
	private Long categoryId2;

	@ExcelColumn(name = "二级分类名称")
	private String categoryName2;

	@ExcelColumn(name = "三级分类ID")
	private Long categoryId3;

	@ExcelColumn(name = "三级分类名称")
	private String categoryName3;

	@ExcelColumn(name = "四级分类ID")
	private Long categoryId4;

	@ExcelColumn(name = "四级分类名")
	private String categoryName4;

	@ExcelColumn(name = "五级分类ID")
	private Long categoryId5;

	@ExcelColumn(name = "五级分类名称")
	private String categoryName5;

	@ExcelColumn(name = "品牌ID")
	private Long brandId;

	@ExcelColumn(name = "品牌名称")
	private String brandName;

	@ExcelColumn(name = "标准类型（0：非称重，1：称重）")
	private Integer standardType = 0;

	@ExcelColumn(name = "单位ID")
	private Long unitsId;

	@ExcelColumn(name = "计量单位名称")
	private String unitsName;

	@ExcelColumn(name = "重量")
	private BigDecimal weight;

	@ExcelColumn(name = "成本价")
	private BigDecimal costPrice;

	@ExcelColumn(name = "销售指导价")
	private BigDecimal guidePrice;

	@ExcelColumn(name = "销售价")
	private BigDecimal salePrice;

	@ExcelColumn(name = "是否为序列号管理，0-否 1-是")
	private Integer isSerialCode;

	@ExcelColumn(name = "货品规格")
	private String spuCode;

	@ExcelColumn(name = "货品规格")
	private String spuInfo;

	@ExcelColumn(name = "销售类型（0：仅自营；1：仅代销；2：先自营后代销；3：先代销后自营）")
	private Integer salesType;

	@ExcelColumn(name = "采购价")
	private BigDecimal purchasePrice;

	@ExcelColumn(name = "税率")
	private Integer taxRate;

	@ExcelColumn(name = "生鲜类型，0,普通商品;1,称重管重量；2,称重不管重量;3,计件")
	private Integer freshType;

	@ExcelColumn(name = "流通状态")
	private String status;

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getUpcCode() {
		return upcCode;
	}

	public void setUpcCode(String upcCode) {
		this.upcCode = upcCode;
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

	public BigDecimal getSalePrice() {
		return salePrice;
	}

	public void setSalePrice(BigDecimal salePrice) {
		this.salePrice = salePrice;
	}

	public Integer getIsSerialCode() {
		return isSerialCode;
	}

	public void setIsSerialCode(Integer isSerialCode) {
		this.isSerialCode = isSerialCode;
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

	public Integer getSalesType() {
		return salesType;
	}

	public void setSalesType(Integer salesType) {
		this.salesType = salesType;
	}

	public BigDecimal getPurchasePrice() {
		return purchasePrice;
	}

	public void setPurchasePrice(BigDecimal purchasePrice) {
		this.purchasePrice = purchasePrice;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
