package com.morning.star.retail.admin.group.account.controller.command;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 登录账号
 *
 * @author wumengzhen
 */
@ApiModel
public class CreateGroupAccountCommand implements Serializable {

	private static final long serialVersionUID = -9057076021816031093L;

	public static final String DEFAULT_PASSWORD = "12345678";

	@ApiModelProperty("账号")
	@NotNull(message = "账号不能为空")
	private String account;

	@ApiModelProperty("密码")
	@NotNull(message = "密码不能为空")
	private String password;

	@ApiModelProperty("用户名")
	@NotNull(message = "用户名不能为空")
	private String name;

	@ApiModelProperty("手机号")
	@NotNull(message = "手机号不能为空")
	private String mobile;

	@ApiModelProperty("邮箱")
	@NotNull(message = "邮箱不能为空")
	private String email;

	@ApiModelProperty("集团权限")
	@NotNull(message = "集团权限不能为空")
	private String accessIds;


	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public String getAccessIds() {
		return accessIds;
	}

	public void setAccessIds(String accessIds) {
		this.accessIds = accessIds;
	}
}