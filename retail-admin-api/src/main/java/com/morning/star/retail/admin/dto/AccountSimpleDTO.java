package com.morning.star.retail.admin.dto;


import com.morning.star.retail.admin.enums.AccountLevelEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

@ApiModel
public class AccountSimpleDTO extends AccountBaseDTO implements Serializable {

	private static final long serialVersionUID = 1111320370190733557L;

	@ApiModelProperty("账号ID")
	private Long id;

	@ApiModelProperty("集团编码")
	private String groupCode;

	@ApiModelProperty("集团名称")
	private String groupName;

	@ApiModelProperty("门店编码")
	private String storeCode;

	@ApiModelProperty("门店名称")
	private String storeName;

	@ApiModelProperty("账号等级名")
	private String accountLevelStr;

	@ApiModelProperty("创建时间")
	private Date createTime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getAccountLevelStr() {
		return AccountLevelEnum.getByCode(this.getAccountLevel()).getDesc();
	}

	public void setAccountLevelStr(String accountLevelStr) {
		this.accountLevelStr = accountLevelStr;
	}
}