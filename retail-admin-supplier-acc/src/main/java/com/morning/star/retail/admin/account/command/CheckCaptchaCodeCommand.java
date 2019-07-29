package com.morning.star.retail.admin.account.command;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author ethan
 * @create_time 2019/3/25 17:53
 */
@Data
@ApiModel
public class CheckCaptchaCodeCommand implements Serializable {
	private static final long serialVersionUID = -7490388518399871383L;

	@ApiModelProperty(value = "登录账号", required = true)
	private String account;

	@ApiModelProperty(value = "短信验证码", required = true)
	private String captchaCode;

}
