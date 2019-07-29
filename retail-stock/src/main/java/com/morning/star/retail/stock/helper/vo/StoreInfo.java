package com.morning.star.retail.stock.helper.vo;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 门店详情-展示对象
 *
 * @author jiangyf
 */
public class StoreInfo implements Serializable {
	private static final long serialVersionUID = -5886149595928713815L;

	@ApiModelProperty("门店编码")
	private String storeCode;

	@ApiModelProperty("门店名称")
	private String storeName;

	@ApiModelProperty("集团编码")
	private String groupCode;

	@ApiModelProperty("集团名称")
	private String groupName;

	@ApiModelProperty("负责人")
	private String manager;

	@ApiModelProperty("负责人邮箱")
	private String email;

	@ApiModelProperty("负责人电话")
	private String mobile;

	@ApiModelProperty("市")
	private Long cityId;

	@ApiModelProperty("市名")
	private String cityName;

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

	public String getManager() {
		return manager;
	}

	public void setManager(String manager) {
		this.manager = manager;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
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
}
