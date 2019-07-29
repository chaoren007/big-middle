package com.morning.star.retail.admin.account.command;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class ChangePasswordCommand implements Serializable {
	private static final long serialVersionUID = -7490388518399871383L;

	@ApiModelProperty(value = "登录账号", hidden = true)
	private String account;

	@ApiModelProperty(value = "短信验证码TOKEN", required = true)
	private String captchaToken;

	@ApiModelProperty(value = "新密码", required = true)
	private String password;

}