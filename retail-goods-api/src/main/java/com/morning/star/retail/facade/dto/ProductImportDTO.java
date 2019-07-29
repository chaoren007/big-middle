package com.morning.star.retail.facade.dto;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@ApiModel
public class ProductImportDTO implements Serializable {
	private static final long serialVersionUID = 735382006815547012L;

	@NotNull(message = "集团不能为空")
	@ApiModelProperty(value = "集团编码", hidden = true)
	private String groupCode;

	@ApiModelProperty(value = "大柜组编码")
	private String vcontainerCode;

	@ApiModelProperty(value = "货品编码")
	private String productCode;

	@ApiModelProperty(value = "SAP货品编码")
	private String sapProductCode;

	@NotNull(message = "货品名称不能为空")
	@ApiModelProperty(value = "货品名称")
	private String productName;

	@ApiModelProperty(value = "一级分类ID")
	private Long categoryId1;

	@ApiModelProperty(value = "一级分类名称")
	private String categoryName1;

	@ApiModelProperty(value = "二级分类ID")
	private Long categoryId2;

	@ApiModelProperty(value = "二级分类名称")
	private String categoryName2;

	@ApiModelProperty(value = "三级分类ID")
	private Long categoryId3;

	@ApiModelProperty(value = "三级分类名称")
	private String categoryName3;

	@ApiModelProperty(value = "四级分类ID")
	private Long categoryId4;

	@ApiModelProperty(value = "四级分类名")
	private String categoryName4;

	@ApiModelProperty(value = "五级分类ID")
	private Long categoryId5;

	@ApiModelProperty(value = "五级分类名称")
	private String categoryName5;

	@NotNull(message = "品牌ID不能为空")
	@ApiModelProperty(value = "品牌ID")
	private Long brandId;

	@ApiModelProperty(value = "品牌名称")
	private String brandName;

	@ApiModelProperty(value = "货品图标")
	private String iconPath;

	@NotNull(message = "条形码不能为空")
	@ApiModelProperty(value = "条形码")
	private String upcCode;

	@NotNull(message = "标准类型不能为空：0：非称重，1：称重")
	@ApiModelProperty(value = "标准类型（0：标品，1：非标品，2：服饰）")
	private Integer standardType = 0;

	@NotNull(message = "单位ID不能为空")
	@ApiModelProperty(value = "单位ID")
	private Long unitsId;

	@ApiModelProperty(value = "计量单位名称")
	private String unitsName;

	@ApiModelProperty(value = "重量")
	private BigDecimal weight;

	@ApiModelProperty(value = "成本价")
	private BigDecimal costPrice;

	@NotNull(message = "销售指导价不能为空")
	@DecimalMin(value = "0", message = "销售指导价不能小于0")
	@ApiModelProperty(value = "销售指导价")
	private BigDecimal guidePrice;

	@NotNull(message = "销售价不能为空")
	@DecimalMin(value = "0", message = "销售价不能小于0")
	@ApiModelProperty(value = "销售价")
	private BigDecimal salePrice;

	@NotNull(message = "序列号管理不能为空：0-否 1-是")
	@ApiModelProperty(value = "是否为序列号管理，0-否 1-是")
	private Integer isSerialCode;

	@ApiModelProperty(value = "货品规格")
	private List<ProductSpecDTO> productSpecInfo;

	@ApiModelProperty(value = "商品图册图片（逗号隔开）")
	private String imgPaths;

	@ApiModelProperty(value = "商品介绍图片（逗号隔开）")
	private String introImgPaths;

	@ApiModelProperty(value = "商品规格编码")
	private String spuCode;

	@ApiModelProperty(value = "商品规格信息")
	private String spuInfo;

	@ApiModelProperty(value = "权重")
	private Integer priority;

	@ApiModelProperty(value = "销售类型（0：仅自营；1：仅代销；2：先自营后代销；3：先代销后自营）")
	private Integer salesType;

	@ApiModelProperty(value = "供应商编码")
	private String supplierCode;

	@ApiModelProperty(value = "供应商名称")
	private String supplierName;

	@NotNull(message = "采购价不能为空")
	@DecimalMin(value = "0", message = "采购价不能小于0")
	@ApiModelProperty(value = "采购价")
	private BigDecimal purchasePrice;

	@ApiModelProperty(value = "产地")
	private String originPlace;

	@NotNull(message = "税率不能为空")
	@Min(value = 0, message = "税率不能小于0")
	@Max(value = 99, message = "税率不能大于99")
	@ApiModelProperty(value = "税率")
	private Integer taxRate;

	@ApiModelProperty(value = "货品类型，套装或单品")
	private String productType;

	@ApiModelProperty(value = "套装数量")
	private Integer packSpecNum;

	@ApiModelProperty(value = "套装单位")
	private String packSpecUnits;

	@ApiModelProperty(value = "套装信息描述")
	private String packSpecDesc;

	@ApiModelProperty(value = "套装编码")
	private String unitProductCode;

	@ApiModelProperty(value = "商品介绍")
	private String productIntroduce;

	@ApiModelProperty(value = "生鲜类型，0,普通商品;1,称重管重量；2,称重不管重量;3,计件")
	private Integer freshType;

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

	public Integer getIsSerialCode() {
		return isSerialCode;
	}

	public void setIsSerialCode(Integer isSerialCode) {
		this.isSerialCode = isSerialCode;
	}

	public List<ProductSpecDTO> getProductSpecInfo() {
		return productSpecInfo;
	}

	public void setProductSpecInfo(List<ProductSpecDTO> productSpecInfo) {
		this.productSpecInfo = productSpecInfo;
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

	public String getGroupCode() {
		return groupCode;
	}

	public void setGroupCode(String groupCode) {
		this.groupCode = groupCode;
	}

	public String getVcontainerCode() {
		return vcontainerCode;
	}

	public void setVcontainerCode(String vcontainerCode) {
		this.vcontainerCode = vcontainerCode;
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

	public Integer getPriority() {
		return priority;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
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

	public String getPackSpecDesc() {
		return packSpecDesc;
	}

	public void setPackSpecDesc(String packSpecDesc) {
		this.packSpecDesc = packSpecDesc;
	}

	public String getUnitProductCode() {
		return unitProductCode;
	}

	public void setUnitProductCode(String unitProductCode) {
		this.unitProductCode = unitProductCode;
	}

	public String getProductIntroduce() {
		return productIntroduce;
	}

	public void setProductIntroduce(String productIntroduce) {
		this.productIntroduce = productIntroduce;
	}

	public Integer getFreshType() {
		return freshType;
	}

	public void setFreshType(Integer freshType) {
		this.freshType = freshType;
	}

	public BigDecimal getSalePrice() {
		return salePrice;
	}

	public void setSalePrice(BigDecimal salePrice) {
		this.salePrice = salePrice;
	}
}
