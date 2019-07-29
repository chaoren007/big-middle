package com.morning.star.retail.admin.group.goods.controller.vo;


import java.io.Serializable;

import org.apache.commons.lang.StringUtils;

import com.morning.star.retail.admin.util.BeanUtils;
import com.morning.star.retail.base.poi.ExcelColumn;
import com.morning.star.retail.facade.dto.ProductImportDTO;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class ProductInfoImportVO implements Serializable {
	private static final long serialVersionUID = 735382006815547012L;

	@ExcelColumn(name = "商品名称", column = "0")
	@ApiModelProperty(value = "货品名称")
	private String productName;

	@ExcelColumn(name = "UPC", column = "1")
	@ApiModelProperty(value = "条形码")
	private String upcCode;

	@ExcelColumn(name = "一级分类ID", column = "2")
	@ApiModelProperty(value = "一级分类ID")
	private String categoryId1;

	@ExcelColumn(name = "一级分类名称", column = "3")
	@ApiModelProperty(value = "一级分类名称")
	private String categoryName1;

	@ExcelColumn(name = "二级分类ID", column = "4")
	@ApiModelProperty(value = "二级分类ID")
	private String categoryId2;

	@ExcelColumn(name = "二级分类名称", column = "5")
	@ApiModelProperty(value = "二级分类名称")
	private String categoryName2;

	@ExcelColumn(name = "三级分类ID", column = "6")
	@ApiModelProperty(value = "三级分类ID")
	private String categoryId3;

	@ExcelColumn(name = "三级分类名称", column = "7")
	@ApiModelProperty(value = "三级分类名称")
	private String categoryName3;

	@ExcelColumn(name = "四级分类ID", column = "8")
	@ApiModelProperty(value = "四级分类ID")
	private String categoryId4;

	@ExcelColumn(name = "四级分类名", column = "9")
	@ApiModelProperty(value = "四级分类名")
	private String categoryName4;

	@ExcelColumn(name = "五级分类ID", column = "10")
	@ApiModelProperty(value = "五级分类ID")
	private String categoryId5;

	@ExcelColumn(name = "五级分类名称", column = "11")
	@ApiModelProperty(value = "五级分类名称")
	private String categoryName5;

	@ExcelColumn(name = "品牌ID", column = "12")
	@ApiModelProperty(value = "品牌ID")
	private String brandId;

	@ExcelColumn(name = "品牌名称", column = "13")
	@ApiModelProperty(value = "品牌名称")
	private String brandName;

	@ExcelColumn(name = "标准类型（0：非称重，1：称重）", column = "14")
	@ApiModelProperty(value = "标准类型（0：非称重，1：称重）")
	private String standardType;

	@ExcelColumn(name = "单位ID", column = "15")
	@ApiModelProperty(value = "单位ID")
	private String unitsId;

	@ExcelColumn(name = "计量单位名称", column = "16")
	@ApiModelProperty(value = "计量单位名称")
	private String unitsName;

	@ExcelColumn(name = "重量", column = "17")
	@ApiModelProperty(value = "重量")
	private String weight;

	@ExcelColumn(name = "成本价", column = "18")
	@ApiModelProperty(value = "成本价")
	private String costPrice;

	@ExcelColumn(name = "销售指导价", column = "19")
	@ApiModelProperty(value = "销售指导价")
	private String guidePrice;

	@ExcelColumn(name = "销售价", column = "20")
	@ApiModelProperty(value = "销售价")
	private String salePrice;

	@ExcelColumn(name = "是否为序列号管理，0-否 1-是", column = "21")
	@ApiModelProperty(value = "是否为序列号管理，0-否 1-是")
	private String isSerialCode;

	@ExcelColumn(name = "货品规格", column = "22")
	@ApiModelProperty(value = "货品规格编码")
	private String spuCode;

	@ExcelColumn(name = "货品规格", column = "23")
	@ApiModelProperty(value = "货品规格")
	private String spuInfo;

	@ExcelColumn(name = "销售类型（0：仅自营；1：仅代销；2：先自营后代销；3：先代销后自营）", column = "24")
	@ApiModelProperty(value = "销售类型（0：仅自营；1：仅代销；2：先自营后代销；3：先代销后自营）")
	private String salesType;

	@ExcelColumn(name = "采购价", column = "25")
	@ApiModelProperty(value = "采购价")
	private String purchasePrice;

	@ExcelColumn(name = "税率", column = "26")
	@ApiModelProperty(value = "税率")
	private String taxRate;

	@ExcelColumn(name = "生鲜类型，0,普通商品;1,称重管重量；2,称重不管重量;3,计件", column = "27")
	@ApiModelProperty(value = "生鲜类型，0,普通商品;1,称重管重量；2,称重不管重量;3,计件")
	private String freshType;

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

	public String getCategoryId1() {
		return categoryId1;
	}

	public void setCategoryId1(String categoryId1) {
		this.categoryId1 = categoryId1;
	}

	public String getCategoryName1() {
		return categoryName1;
	}

	public void setCategoryName1(String categoryName1) {
		this.categoryName1 = categoryName1;
	}

	public String getCategoryId2() {
		return categoryId2;
	}

	public void setCategoryId2(String categoryId2) {
		this.categoryId2 = categoryId2;
	}

	public String getCategoryName2() {
		return categoryName2;
	}

	public void setCategoryName2(String categoryName2) {
		this.categoryName2 = categoryName2;
	}

	public String getCategoryId3() {
		return categoryId3;
	}

	public void setCategoryId3(String categoryId3) {
		this.categoryId3 = categoryId3;
	}

	public String getCategoryName3() {
		return categoryName3;
	}

	public void setCategoryName3(String categoryName3) {
		this.categoryName3 = categoryName3;
	}

	public String getCategoryId4() {
		return categoryId4;
	}

	public void setCategoryId4(String categoryId4) {
		this.categoryId4 = categoryId4;
	}

	public String getCategoryName4() {
		return categoryName4;
	}

	public void setCategoryName4(String categoryName4) {
		this.categoryName4 = categoryName4;
	}

	public String getCategoryId5() {
		return categoryId5;
	}

	public void setCategoryId5(String categoryId5) {
		this.categoryId5 = categoryId5;
	}

	public String getCategoryName5() {
		return categoryName5;
	}

	public void setCategoryName5(String categoryName5) {
		this.categoryName5 = categoryName5;
	}

	public String getBrandId() {
		return brandId;
	}

	public void setBrandId(String brandId) {
		this.brandId = brandId;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public String getStandardType() {
		return standardType;
	}

	public void setStandardType(String standardType) {
		this.standardType = standardType;
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

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public String getCostPrice() {
		return costPrice;
	}

	public void setCostPrice(String costPrice) {
		this.costPrice = costPrice;
	}

	public String getGuidePrice() {
		return guidePrice;
	}

	public void setGuidePrice(String guidePrice) {
		this.guidePrice = guidePrice;
	}

	public String getSalePrice() {
		return salePrice;
	}

	public void setSalePrice(String salePrice) {
		this.salePrice = salePrice;
	}

	public String getIsSerialCode() {
		return isSerialCode;
	}

	public void setIsSerialCode(String isSerialCode) {
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

	public String getSalesType() {
		return salesType;
	}

	public void setSalesType(String salesType) {
		this.salesType = salesType;
	}

	public String getPurchasePrice() {
		return purchasePrice;
	}

	public void setPurchasePrice(String purchasePrice) {
		this.purchasePrice = purchasePrice;
	}

	public String getTaxRate() {
		return taxRate;
	}

	public void setTaxRate(String taxRate) {
		this.taxRate = taxRate;
	}

	public String getFreshType() {
		return freshType;
	}

	public void setFreshType(String freshType) {
		this.freshType = freshType;
	}

	public ProductImportDTO transform() {
		ProductImportDTO productImportDTO = new ProductImportDTO();
		BeanUtils.copy(this, productImportDTO);
		if (StringUtils.isNotBlank(this.unitsId)) productImportDTO.setUnitsId(Long.valueOf(this.unitsId));
		if (StringUtils.isNotBlank(this.brandId)) productImportDTO.setBrandId(Long.valueOf(this.brandId));
		if (StringUtils.isNotBlank(this.categoryId1)) productImportDTO.setCategoryId1(Long.valueOf(this.categoryId1));
		if (StringUtils.isNotBlank(this.categoryId2)) productImportDTO.setCategoryId2(Long.valueOf(this.categoryId2));
		if (StringUtils.isNotBlank(this.categoryId3)) productImportDTO.setCategoryId3(Long.valueOf(this.categoryId3));
		if (StringUtils.isNotBlank(this.categoryId4)) productImportDTO.setCategoryId4(Long.valueOf(this.categoryId4));
		if (StringUtils.isNotBlank(this.categoryId5)) productImportDTO.setCategoryId5(Long.valueOf(this.categoryId5));

		if (StringUtils.isNotBlank(this.standardType)) {
			productImportDTO.setStandardType(Integer.valueOf(this.standardType));
		} else {
			productImportDTO.setStandardType(0);
		}

		if (StringUtils.isNotBlank(this.isSerialCode)) {
			productImportDTO.setIsSerialCode(Integer.valueOf(this.isSerialCode));
		} else {
			productImportDTO.setIsSerialCode(0);
		}

		if (StringUtils.isNotBlank(this.salesType)) {
			productImportDTO.setSalesType(Integer.valueOf(this.salesType));
		} else {
			productImportDTO.setSalesType(0);
		}

		if (StringUtils.isNotBlank(this.taxRate)) {
			productImportDTO.setTaxRate(Integer.valueOf(this.taxRate));
		} else {
			productImportDTO.setTaxRate(0);
		}

		if (StringUtils.isNotBlank(this.freshType)) {
			productImportDTO.setFreshType(Integer.valueOf(this.freshType));
		} else {
			productImportDTO.setFreshType(0);
		}
		return productImportDTO;
	}
}
