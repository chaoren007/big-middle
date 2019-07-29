package com.morning.star.retail.facade.dto;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@ApiModel
public class ProductSubmitDTO implements Serializable {
	private static final long serialVersionUID = 735382006815547012L;

	@ApiModelProperty(value = "货品编码")
	private String productCode;

	//@NotNull(message = "集团编码不能为空")
	@ApiModelProperty(value = "集团编码", hidden = true)
	private String groupCode;

	//门店编码不作为主商品数据表字段，只用来区别是否为分公司新增的主商品，总部新增数据时，该字段为空
	private String storeCode;

	@NotNull(message = "单位ID不能为空")
	@ApiModelProperty(value = "单位ID")
	private Long unitsId;

	@ApiModelProperty(value = "计量单位名称")
	private String unitsName;

	@ApiModelProperty(value = "重量")
	private BigDecimal weight;

	@NotNull(message = "货品名称不能为空")
	@ApiModelProperty(value = "货品名称")
	private String productName;

	@NotNull(message = "一级类目ID不能为空")
	@ApiModelProperty(value = "一级分类ID")
	private Long categoryId1;

	@ApiModelProperty(value = "一级分类名称")
	private String categoryName1;

	@NotNull(message = "二级类目ID不能为空")
	@ApiModelProperty(value = "二级分类ID")
	private Long categoryId2;

	@ApiModelProperty(value = "二级分类名称")
	private String categoryName2;

	@NotNull(message = "三级类目ID不能为空")
	@ApiModelProperty(value = "三级分类ID")
	private Long categoryId3;

	@ApiModelProperty(value = "三级分类名称")
	private String categoryName3;

	@NotNull(message = "品牌ID不能为空")
	@ApiModelProperty(value = "品牌ID")
	private Long brandId;

	@ApiModelProperty(value = "品牌名称")
	private String brandName;

	@NotNull(message = "条形码不能为空")
	@ApiModelProperty(value = "条形码")
	private String upcCode;

	@NotNull(message = "供货价不能为空")
	@DecimalMin(value = "0", message = "供货价不能小于0")
	@ApiModelProperty(value = "供货价")
	private BigDecimal costPrice;

	@NotNull(message = "市场价不能为空")
	@DecimalMin(value = "0", message = "市场价不能小于0")
	@ApiModelProperty(value = "市场价")
	private BigDecimal salePrice;

	@ApiModelProperty(value = "货品规格")
	private List<ProductSpecDTO> productSpecInfo;

	@ApiModelProperty(value = "货品规格编码")
	private String spuCode;

	@ApiModelProperty(value = "货品图标")
	private String iconPath;

	@NotNull(message = "商品主图不能为空")
	@ApiModelProperty(value = "商品主图（逗号隔开）")
	private String imgPaths;

	@ApiModelProperty(value = "商品详情图（逗号隔开）")
	private String introImgPaths;

	@NotNull(message = "供应商编码不能为空")
	@ApiModelProperty(value = "供应商编码")
	private String supplierCode;

	@ApiModelProperty(value = "供应商名称")
	private String supplierName;

	@ApiModelProperty(value = "产地")
	private String originPlace;

	@ApiModelProperty(value = "母码")
	private String motherCode;

	@NotNull(message = "商品类型不能为空")
	@ApiModelProperty(value = "商品类型，0,标品;1,非标品；2,服饰")
	private Integer commodityType;

	@NotNull(message = "商品存储类型不能为空")
	@ApiModelProperty(value = "存储类型，0,冷藏存储;1,普通存储;2,冷冻存储")
	private Integer storageType;

	@ApiModelProperty(value = "保质期")
	private Integer shelfLife;

	@ApiModelProperty(value = "体积长度，单位CM")
	private BigDecimal volumeLength;

	@ApiModelProperty(value = "体积宽度，单位CM")
	private BigDecimal volumeWidth;

	@ApiModelProperty(value = "体积高度，单位CM")
	private BigDecimal volumeHeight;

	@NotNull(message = "明细中税率为空")
	@Min(value = 0, message = "税率不能小于0")
	@Max(value = 99, message = "税率不能大于99")
	@ApiModelProperty(value = "税率")
	private Integer taxRate;

	@ApiModelProperty(value = "数量/重量/体积 属性信息")
	private String outAttrInfo;

	@ApiModelProperty(value = "分类规格信息")
	private List<ProductSpecDTO> categorySpecInfo;

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
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

	public String getUpcCode() {
		return upcCode;
	}

	public void setUpcCode(String upcCode) {
		this.upcCode = upcCode;
	}

	public BigDecimal getCostPrice() {
		return costPrice;
	}

	public void setCostPrice(BigDecimal costPrice) {
		this.costPrice = costPrice;
	}

	public BigDecimal getSalePrice() {
		return salePrice;
	}

	public void setSalePrice(BigDecimal salePrice) {
		this.salePrice = salePrice;
	}

	public List<ProductSpecDTO> getProductSpecInfo() {
		return productSpecInfo;
	}

	public void setProductSpecInfo(List<ProductSpecDTO> productSpecInfo) {
		this.productSpecInfo = productSpecInfo;
	}

	public String getSpuCode() {
		return spuCode;
	}

	public void setSpuCode(String spuCode) {
		this.spuCode = spuCode;
	}

	public String getIconPath() {
		return iconPath;
	}

	public void setIconPath(String iconPath) {
		this.iconPath = iconPath;
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

	public String getOriginPlace() {
		return originPlace;
	}

	public void setOriginPlace(String originPlace) {
		this.originPlace = originPlace;
	}

	public String getMotherCode() {
		return motherCode;
	}

	public void setMotherCode(String motherCode) {
		this.motherCode = motherCode;
	}

	public Integer getCommodityType() {
		return commodityType;
	}

	public void setCommodityType(Integer commodityType) {
		this.commodityType = commodityType;
	}

	public Integer getShelfLife() {
		return shelfLife;
	}

	public void setShelfLife(Integer shelfLife) {
		this.shelfLife = shelfLife;
	}

	public Integer getStorageType() {
		return storageType;
	}

	public void setStorageType(Integer storageType) {
		this.storageType = storageType;
	}

	public BigDecimal getVolumeLength() {
		return volumeLength;
	}

	public void setVolumeLength(BigDecimal volumeLength) {
		this.volumeLength = volumeLength;
	}

	public BigDecimal getVolumeWidth() {
		return volumeWidth;
	}

	public void setVolumeWidth(BigDecimal volumeWidth) {
		this.volumeWidth = volumeWidth;
	}

	public BigDecimal getVolumeHeight() {
		return volumeHeight;
	}

	public void setVolumeHeight(BigDecimal volumeHeight) {
		this.volumeHeight = volumeHeight;
	}

	public Integer getTaxRate() {
		return taxRate;
	}

	public void setTaxRate(Integer taxRate) {
		this.taxRate = taxRate;
	}

	public String getOutAttrInfo() {
		return outAttrInfo;
	}

	public void setOutAttrInfo(String outAttrInfo) {
		this.outAttrInfo = outAttrInfo;
	}

	public List<ProductSpecDTO> getCategorySpecInfo() {
		return categorySpecInfo;
	}

	public void setCategorySpecInfo(List<ProductSpecDTO> categorySpecInfo) {
		this.categorySpecInfo = categorySpecInfo;
	}
}
