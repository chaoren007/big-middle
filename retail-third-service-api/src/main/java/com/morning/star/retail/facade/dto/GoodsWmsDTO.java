package com.morning.star.retail.facade.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 外部服务商品dto
 */
@ApiModel
public class GoodsWmsDTO implements Serializable {
	private static final long serialVersionUID = 735382006815547012L;

	@ApiModelProperty(required = true, value = "商品编码")
	@NotNull(message = "商品编码不能为空")
	private String goodsCode;

	@ApiModelProperty(required = true, value = "商品名称")
	@NotNull(message = "商品名称不能为空")
	private String goodsName;

	@ApiModelProperty(required = true, value = "商品规格详情")
	private String spuInfo;

	@ApiModelProperty(required = true, value = "计量单位名称")
	@NotNull(message = "计量单位名称不能为空")
	private String unitsName;

	@ApiModelProperty(required = true, value = "三级分类ID")
	@NotNull(message = "三级分类id不能为空")
	private Long categoryId3;

	@ApiModelProperty(required = true, value = "保质天数")
	private Integer shelfLife;

	@ApiModelProperty(required = true, value = "条码")
	@NotNull(message = "条码不能为空")
	private String upcCode;

	@ApiModelProperty(required = true, value = "品牌名称")
	@NotNull(message = "品牌名称不能为空")
	private String brandName;

	@ApiModelProperty(required = true, value = "分公司编码")
	@NotNull(message = "分公司编码不能为空")
	private String storeCode;

	@ApiModelProperty(required = true, value = "存储类型")
	@NotNull(message = "存储类型不能为空")
	private Integer storageType;

	@ApiModelProperty(required = true, value = "商品类型")
	@NotNull(message = "商品类型不能为空")
	private Integer commodityType;

	@ApiModelProperty(value = "体积长度，单位CM")
	private BigDecimal volumeLength;

	@ApiModelProperty(value = "体积宽度，单位CM")
	private BigDecimal volumeWidth;

	@ApiModelProperty(value = "体积高度，单位CM")
	private BigDecimal volumeHeight;

	@ApiModelProperty(value = "重量")
	private BigDecimal weight;

	@ApiModelProperty(value = "图片")
	private String icon;

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

	public String getSpuInfo() {
		return spuInfo;
	}

	public void setSpuInfo(String spuInfo) {
		this.spuInfo = spuInfo;
	}

	public String getUnitsName() {
		return unitsName;
	}

	public void setUnitsName(String unitsName) {
		this.unitsName = unitsName;
	}

	public Long getCategoryId3() {
		return categoryId3;
	}

	public void setCategoryId3(Long categoryId3) {
		this.categoryId3 = categoryId3;
	}

	public Integer getShelfLife() {
		return shelfLife;
	}

	public void setShelfLife(Integer shelfLife) {
		this.shelfLife = shelfLife;
	}

	public String getUpcCode() {
		return upcCode;
	}

	public void setUpcCode(String upcCode) {
		this.upcCode = upcCode;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public String getStoreCode() {
		return storeCode;
	}

	public void setStoreCode(String storeCode) {
		this.storeCode = storeCode;
	}

	public Integer getStorageType() {
		return storageType;
	}

	public void setStorageType(Integer storageType) {
		this.storageType = storageType;
	}

	public Integer getCommodityType() {
		return commodityType;
	}

	public void setCommodityType(Integer commodityType) {
		this.commodityType = commodityType;
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

	public BigDecimal getWeight() {
		return weight;
	}

	public void setWeight(BigDecimal weight) {
		this.weight = weight;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}
}
