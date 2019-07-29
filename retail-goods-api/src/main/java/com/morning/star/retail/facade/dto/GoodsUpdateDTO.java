package com.morning.star.retail.facade.dto;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;

@ApiModel
public class GoodsUpdateDTO implements Serializable {
	private static final long serialVersionUID = 735382006815547012L;

	@NotNull(message = "商品编码不能为空")
	@ApiModelProperty(value = "商品编码")
	private String goodsCode;

	@ApiModelProperty(value = "集团编码", hidden = true)
//	@NotNull(message = "集团编码不能为空")
	private String groupCode;

	@ApiModelProperty(value = "门店编码", hidden = true)
//	@NotNull(message = "分公司编码不能为空")
	private String storeCode;

	@ApiModelProperty(value = "供应商编码")
	@NotNull(message = "供应商编码不能为空")
	private String supplierCode;

	@ApiModelProperty(value = "供应商名称")
	private String supplierName;

	@NotNull(message = "供货价不能为空")
	@DecimalMin(value = "0", message = "供货价不能小于0")
	@ApiModelProperty(value = "供货价")
	private BigDecimal costPrice;

	@NotNull(message = "市场价不能为空")
	@DecimalMin(value = "0", message = "市场价不能小于0")
	@ApiModelProperty(value = "市场价")
	private BigDecimal salePrice;

	@ApiModelProperty(value = "货品图标")
	private String iconPath;

	@NotNull(message = "商品主图不能为空")
	@ApiModelProperty(value = "商品主图（逗号隔开）")
	private String imgPaths;

	@ApiModelProperty(value = "商品详情图（逗号隔开）")
	private String introImgPaths;

	@ApiModelProperty(value = "产地")
	private String originPlace;

	public String getGoodsCode() {
		return goodsCode;
	}

	public void setGoodsCode(String goodsCode) {
		this.goodsCode = goodsCode;
	}

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

	public String getOriginPlace() {
		return originPlace;
	}

	public void setOriginPlace(String originPlace) {
		this.originPlace = originPlace;
	}

	public String getStoreCode() {
		return storeCode;
	}

	public void setStoreCode(String storeCode) {
		this.storeCode = storeCode;
	}
}
