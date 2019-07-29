package com.morning.star.retail.admin.group.store.controller.command;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 门店-实体对象
 * 
 */
@ApiModel
public class ModifyStoreCommand implements Serializable {
	private static final long serialVersionUID = 4513502104947576129L;

	@ApiModelProperty(value = "门店编码")
	@NotNull(message = "门店编码不能为空")
	private String storeCode;

	@ApiModelProperty(value = "门店名称")
	@NotNull(message = "门店名称不能为空")
	private String storeName;

	@ApiModelProperty(value = "门店地址")
	@NotNull(message = "详细地址不能为空")
	private String address;

	@ApiModelProperty(value = "省")
	@NotNull(message = "省不能为空")
	private Long provinceId;

	@ApiModelProperty(value = "市")
	@NotNull(message = "市不能为空")
	private Long cityId;

	@ApiModelProperty(value = "区")
	@NotNull(message = "区不能为空")
	private Long countyId;

	@ApiModelProperty(value = "权限ID（逗号分隔）")
	@NotNull(message = "门店角色不能为空")
	private String accessIds;


	public String getStoreCode() {
		return storeCode;
	}

	public void setStoreCode(String storeCode) {
		this.storeCode = storeCode;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Long getProvinceId() {
		return provinceId;
	}

	public void setProvinceId(Long provinceId) {
		this.provinceId = provinceId;
	}

	public Long getCityId() {
		return cityId;
	}

	public void setCityId(Long cityId) {
		this.cityId = cityId;
	}

	public Long getCountyId() {
		return countyId;
	}

	public void setCountyId(Long countyId) {
		this.countyId = countyId;
	}

	public String getAccessIds() {
		return accessIds;
	}

	public void setAccessIds(String accessIds) {
		this.accessIds = accessIds;
	}

}
