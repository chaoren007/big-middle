package com.morning.star.retail.admin.group.account.controller.command;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


@ApiModel
public class CreateStoreAccountCommand implements Serializable {
	private static final long serialVersionUID = -7490388518399871383L;

	@ApiModelProperty(value = "登录账号", required = true)
	@NotNull(message = "登录账号不能为空")
	private String account;

	@ApiModelProperty(value = "登录密码", required = true)
	@NotNull(message = "登录密码不能为空")
	private String password;

	@ApiModelProperty(value = "联系人姓名", required = true)
	@NotNull(message = "联系人姓名不能为空")
	private String name;

	@ApiModelProperty(value = "联系人手机", required = true)
	@NotNull(message = "联系人手机不能为空")
	@Pattern(regexp = "^[1][0,1,2,3,4,5,6,7,8,9][0-9]{9}$", message = "手机号格式不对")
	private String mobile;

	@ApiModelProperty(value = "联系人邮箱", required = true)
	@NotNull(message = "联系人邮箱不能为空")
	@Pattern(regexp = "^([\\w-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([\\w-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$", message = "邮箱格式不对")
	private String email;

	@ApiModelProperty(value = "门店编码", required = true)
	@NotNull(message = "门店编码不能为空")
	private String storeCode;

	@ApiModelProperty(value = "折扣", required = true)
	private Integer discount;

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

	public Integer getDiscount() {
		return discount;
	}

	public void setDiscount(Integer discount) {
		this.discount = discount;
	}

}
