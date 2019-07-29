package com.morning.star.retail.admin.group.account.controller.vo;

import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.ApiModelProperty;

/**
 * 登录账号
 */
public class GroupAccountVO implements Serializable {

	private static final long serialVersionUID = 3180911585619876463L;

	@ApiModelProperty("账号ID")
	private Long id;

	@ApiModelProperty("集团编码")
	private String groupCode;

	@ApiModelProperty("集团名称")
	private String groupName;

	@ApiModelProperty("账号")
	private String account;

	@ApiModelProperty("用户名")
	private String name;

	@ApiModelProperty("手机号")
	private String mobile;

	@ApiModelProperty("邮箱")
	private String email;

	@ApiModelProperty("账号等级")
	private String accountLevel;

	@ApiModelProperty("账号等级名")
	private String accountLevelStr;

	@ApiModelProperty("集团权限")
	private String accessIds;

	@ApiModelProperty("是否在线（0：离线；1：在线）")
	private Integer isOnline;

	@ApiModelProperty("状态（0：正常；1：冻结；2：作废）")
	private Integer status;

	@ApiModelProperty("登录次数")
	private Integer loginCount;

	@ApiModelProperty("上次登录时间")
	private Date lastLoginTime;

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

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
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

	public String getAccountLevelStr() {
		return accountLevelStr;
	}

	public void setAccountLevelStr(String accountLevelStr) {
		this.accountLevelStr = accountLevelStr;
	}

	public String getAccessIds() {
		return accessIds;
	}

	public void setAccessIds(String accessIds) {
		this.accessIds = accessIds;
	}

	public Integer getIsOnline() {
		return isOnline;
	}

	public void setIsOnline(Integer isOnline) {
		this.isOnline = isOnline;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getLoginCount() {
		return loginCount;
	}

	public void setLoginCount(Integer loginCount) {
		this.loginCount = loginCount;
	}

	public Date getLastLoginTime() {
		return lastLoginTime;
	}

	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
}