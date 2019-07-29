package com.morning.star.retail.admin.account.command;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 登录账号
 */
@Data
public class ModifyAccountCommand implements Serializable {

	private static final long serialVersionUID = -9057076021816031093L;

	@ApiModelProperty(value = "头像")
	@NotNull(message = "头像地址不能为空")
	private String icon;

	@ApiModelProperty(value = "联系人姓名")
	@NotNull(message = "联系人姓名不能为空")
	private String name;

	@ApiModelProperty(value = "联系人邮箱")
	@NotNull(message = "联系人邮箱不能为空")
	private String email;
}