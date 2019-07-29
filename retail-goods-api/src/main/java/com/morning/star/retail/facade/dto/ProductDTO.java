package com.morning.star.retail.facade.dto;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@ApiModel
public class ProductDTO implements Serializable {
	private static final long serialVersionUID = 735382006815547012L;

	@ApiModelProperty(value = "货品编码")
	private String productCode;

	@ApiModelProperty(value = "SAP货品编码")
	private String sapProductCode;

	@ApiModelProperty(value = "sap母码")
	private String sapMotherCode;

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

	@ApiModelProperty(value = "品牌ID")
	private Long brandId;

	@ApiModelProperty(value = "品牌名称")
	private String brandName;

	@ApiModelProperty(value = "货品图标")
	private String iconPath;

	@ApiModelProperty(value = "条形码")
	private String upcCode;

	@ApiModelProperty(value = "标准类型（0：非称重，1：称重）")
	private Integer standardType;

	@ApiModelProperty(value = "单位ID")
	private Long unitsId;

	@ApiModelProperty(value = "计量单位名称")
	private String unitsName;

	@ApiModelProperty(value = "重量")
	private BigDecimal weight;

	@ApiModelProperty(value = "成本价")
	private BigDecimal costPrice;

	@ApiModelProperty(value = "销售指导价")
	private BigDecimal guidePrice;

	@ApiModelProperty(value = "是否为序列号管理，0-否 1-是")
	private Integer isSerialCode;

	@ApiModelProperty(value = "商品主图（逗号隔开）")
	private String imgPaths;

	@ApiModelProperty(value = "商品详情图（逗号隔开）")
	private String introImgPaths;

	@ApiModelProperty(value = "集团编码")
	private String groupCode;

	@ApiModelProperty("集团名称")
	private String groupName;

	@ApiModelProperty(value = "商品规格编码")
	private String spuCode;

	@ApiModelProperty(value = "商品规格详情")
	private String spuInfo;

	@ApiModelProperty(value = "商品规格详情列表")
	private List<ProductSpecDTO> spuInfoList;

	@ApiModelProperty(value = "权重")
	private Integer priority;

	@ApiModelProperty(value = "销售价")
	private BigDecimal salePrice;

	@ApiModelProperty(value = "三公里配送字段 1是 0否")
	private Integer delivery;

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

	@ApiModelProperty(value = "上下架状态，1：上架状态，0：下架状态")
	private Integer saleStatus;

	@ApiModelProperty(value = "上下市状态，1：上市状态，0：下市状态")
	private Integer status;

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

	@ApiModelProperty(value = "保质天数")
	private Integer shelfLife;

	@ApiModelProperty(value = "是否可拆零，0 否 1是")
	private Integer splitType;

	@ApiModelProperty("商品类型")
	private Integer commodityType;

	@ApiModelProperty("商品存储类型")
	private Integer storageType;

	@ApiModelProperty("母码")
	private String motherCode;

	@ApiModelProperty("市ID")
	private Long cityId;

	@ApiModelProperty("市名")
	private String cityName;

	@ApiModelProperty(value = "体积长度，单位CM")
	private BigDecimal volumeLength;

	@ApiModelProperty(value = "体积宽度，单位CM")
	private BigDecimal volumeWidth;

	@ApiModelProperty(value = "体积高度，单位CM")
	private BigDecimal volumeHeight;

	@ApiModelProperty("数量/重量/体积 属性信息")
	private String outAttrInfo;

	@ApiModelProperty("分类规格信息")
	private String categorySpuInfo;

	@ApiModelProperty(value = "商品分类规格详情列表")
	private List<ProductSpecDTO> categorySpuInfoList;

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

	public String getSapMotherCode() {
		return sapMotherCode;
	}

	public void setSapMotherCode(String sapMotherCode) {
		this.sapMotherCode = sapMotherCode;
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

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public String getSpuCode() {
		return spuCode;
	}

	public void setSpuCode(String spuCode) {
		this.spuCode = spuCode;
	}

	public List<ProductSpecDTO> getSpuInfoList() {
		if (this.spuInfo != null && this.spuInfo.length() > 0) {
			return ProductSpecDTO.builderList(this.spuInfo);
		}
		return null;
	}

	public void setSpuInfoList(List<ProductSpecDTO> spuInfoList) {
		this.spuInfoList = spuInfoList;
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

	public BigDecimal getSalePrice() {
		return salePrice;
	}

	public void setSalePrice(BigDecimal salePrice) {
		this.salePrice = salePrice;
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

	public Integer getShelfLife() {
		return shelfLife;
	}

	public void setShelfLife(Integer shelfLife) {
		this.shelfLife = shelfLife;
	}

	public Integer getSplitType() {
		return splitType;
	}

	public void setSplitType(Integer splitType) {
		this.splitType = splitType;
	}

	public Integer getCommodityType() {
		return commodityType;
	}

	public void setCommodityType(Integer commodityType) {
		this.commodityType = commodityType;
	}

	public String getMotherCode() {
		return motherCode;
	}

	public void setMotherCode(String motherCode) {
		this.motherCode = motherCode;
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

	public String getOutAttrInfo() {
		return outAttrInfo;
	}

	public void setOutAttrInfo(String outAttrInfo) {
		this.outAttrInfo = outAttrInfo;
	}

	public String getCategorySpuInfo() {
		return categorySpuInfo;
	}

	public void setCategorySpuInfo(String categorySpuInfo) {
		this.categorySpuInfo = categorySpuInfo;
	}

	public List<ProductSpecDTO> getCategorySpuInfoList() {
		if (this.categorySpuInfo != null && this.categorySpuInfo.length() > 0) {
			return ProductSpecDTO.builderList(this.categorySpuInfo);
		}
		return null;
	}

	public void setCategorySpuInfoList(List<ProductSpecDTO> categorySpuInfoList) {
		this.categorySpuInfoList = categorySpuInfoList;
	}
}
