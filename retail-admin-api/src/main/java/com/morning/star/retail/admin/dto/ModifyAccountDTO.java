package com.morning.star.retail.admin.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 登录账号
 */
@Data
public class ModifyAccountDTO implements Serializable {

	private static final long serialVersionUID = -9057076021816031093L;

	@ApiModelProperty(value = "登录账号")
	@NotNull(message = "登录账号不能为空")
	private String account;

	@ApiModelProperty(value = "联系人姓名")
	@NotNull(message = "联系人姓名不能为空")
	private String name;

	@ApiModelProperty(value = "联系人手机")
	@NotNull(message = "联系人手机不能为空")
	private String mobile;

	@ApiModelProperty(value = "联系人邮箱")
	@NotNull(message = "联系人邮箱不能为空")
	private String email;

	@ApiModelProperty(value = "权限")
	@NotNull(message = "权限不能为空")
	private String accessIds;

	@ApiModelProperty(value = "账号等级", hidden = true)
	private String accountLevel;

	@ApiModelProperty(value = "头像")
	private String icon;
}