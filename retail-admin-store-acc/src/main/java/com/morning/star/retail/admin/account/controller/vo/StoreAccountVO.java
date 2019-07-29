package com.morning.star.retail.admin.account.controller.vo;

import java.io.Serializable;
import java.util.Date;

import com.morning.star.retail.admin.enums.AccountLevelEnum;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 登录账号
 *
 * @author jiangyf
 */
@ApiModel("门店账号")
public class StoreAccountVO implements Serializable {
	private static final long serialVersionUID = 6545781209119528246L;
	@ApiModelProperty(value = "ID")
	private Long id;

	@ApiModelProperty(value = "账号")
	private String account;

	@ApiModelProperty(value = "集团编码")
	private String groupCode;

	@ApiModelProperty(value = "集团名称")
	private String groupName;

	@ApiModelProperty(value = "门店编码")
	private String storeCode;

	@ApiModelProperty(value = "门店名称")
	private String storeName;

	@ApiModelProperty(value = "用户名")
	private String name;

	@ApiModelProperty(value = "手机号")
	private String mobile;

	@ApiModelProperty(value = "邮箱")
	private String email;

	@ApiModelProperty(value = "账号等级")
	private String accountLevel;

	@ApiModelProperty("账号等级名")
	private String accountLevelStr;

	@ApiModelProperty(value = "创建时间")
	private Date createTime;

	@ApiModelProperty(value = "权限ID（逗号分隔）")
	private String accessIds;

	@ApiModelProperty(value = "权限名称（逗号分隔）")
	private String accessNameList;

	@ApiModelProperty(value = "折扣")
	private Integer discount;

	@ApiModelProperty(value = "状态（0：正常；1：冻结；2：作废）")
	private Integer status;


	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAccountLevel() {
		return accountLevel;
	}

	public void setAccountLevel(String accountLevel) {
		this.accountLevel = accountLevel;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getAccessIds() {
		return accessIds;
	}

	public void setAccessIds(String accessIds) {
		this.accessIds = accessIds;
	}

	public String getAccessNameList() {
		return accessNameList;
	}

	public void setAccessNameList(String accessNameList) {
		this.accessNameList = accessNameList;
	}

	public Integer getDiscount() {
		return discount;
	}

	public void setDiscount(Integer discount) {
		this.discount = discount;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAccountLevelStr() {
		return AccountLevelEnum.getByCode(this.accountLevel).getDesc();
	}

	public void setAccountLevelStr(String accountLevelStr) {
		this.accountLevelStr = accountLevelStr;
	}
}