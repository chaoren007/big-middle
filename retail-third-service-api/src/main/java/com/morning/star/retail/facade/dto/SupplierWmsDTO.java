package com.morning.star.retail.facade.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 外部服务商品dto
 */
@ApiModel
public class SupplierWmsDTO implements Serializable {
	private static final long serialVersionUID = 735382006815547012L;
	@ApiModelProperty(value = "供应商编码")
	@NotNull(message = "供应商编码不能为空")
	private String supplierCode;

	@ApiModelProperty(value = "供应商名称")
	@NotNull(message = "供应商名称不能为空")
	private String supplierName;

	@ApiModelProperty(value = "联系人")
	private String linkman;

	@ApiModelProperty(value = "联系方式")
	private String phone;

	@ApiModelProperty(value = "联系方式")
	private String address;

	@ApiModelProperty(value = "推送类型（S-供应商、C-客户、W-人员）")
	@NotNull(message = "推送类型不能为空")
	private String pushType;

	@ApiModelProperty(value = "所属城市id")
	private Long cityId;

	@ApiModelProperty(value = "所属城市编码")
	private String cityCode;

	@ApiModelProperty(value = "所属城市名称")
	private String cityName;

	@ApiModelProperty(value = "分城市编码")
	private String storeCode;

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

	public String getLinkman() {
		return linkman;
	}

	public void setLinkman(String linkman) {
		this.linkman = linkman;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPushType() {
		return pushType;
	}

	public void setPushType(String pushType) {
		this.pushType = pushType;
	}

	public Long getCityId() {
		return cityId;
	}

	public void setCityId(Long cityId) {
		this.cityId = cityId;
	}

	public String getCityCode() {
		return cityCode;
	}

	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getStoreCode() {
		return storeCode;
	}

	public void setStoreCode(String storeCode) {
		this.storeCode = storeCode;
	}
}
