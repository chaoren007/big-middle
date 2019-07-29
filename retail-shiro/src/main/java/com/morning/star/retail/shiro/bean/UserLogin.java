package com.morning.star.retail.shiro.bean;

import com.morning.star.retail.shiro.token.LoginType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 用户登录
 *
 * @author jiangyf
 */
@ApiModel(value = "用户登录")
@Data
public class UserLogin implements Serializable {
	private static final long serialVersionUID = 509576192116214635L;

	@ApiModelProperty(value = "登录账号")
	@NotNull(message = "登录账号不能为空")
	private String username;

	@ApiModelProperty(value = "登录密码")
	@NotNull(message = "登录密码不能为空")
	private String password;

	@ApiModelProperty(value = "是否开启记住我功能")
	private Boolean rememberMe = true;

	@ApiModelProperty(value = "登录方式")
	private LoginType loginType;

	@ApiModelProperty(value = "图形验证码")
	private String imgCode;
}
