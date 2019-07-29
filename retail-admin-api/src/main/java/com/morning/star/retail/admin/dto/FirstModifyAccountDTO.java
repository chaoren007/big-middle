package com.morning.star.retail.admin.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 登录账号
 */
@Data
public class FirstModifyAccountDTO implements Serializable {

	private static final long serialVersionUID = -9057076021816031093L;

	@ApiModelProperty(value = "登录账号", hidden = true)
	private String account;

	@ApiModelProperty(value = "联系人姓名")
	@NotNull(message = "联系人姓名不能为空")
	private String name;

	@ApiModelProperty(value = "联系人邮箱")
	@NotNull(message = "联系人邮箱不能为空")
	private String email;

	@ApiModelProperty(value = "头像")
	@NotNull(message = "头像不能为空")
	private String icon;

	@ApiModelProperty(value = "密码")
	@NotNull(message = "密码不能为空")
	private String password;
}