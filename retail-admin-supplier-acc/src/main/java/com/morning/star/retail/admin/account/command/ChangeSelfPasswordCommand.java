package com.morning.star.retail.admin.account.command;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class ChangeSelfPasswordCommand implements Serializable {

	private static final long serialVersionUID = -5645189964306400975L;

	@ApiModelProperty(value = "旧密码", required = true)
	private String oldPassword;

	@ApiModelProperty(value = "新密码", required = true)
	private String newPassword;

}