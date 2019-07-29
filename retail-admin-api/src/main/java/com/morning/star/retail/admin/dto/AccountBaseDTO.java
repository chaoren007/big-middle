package com.morning.star.retail.admin.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author ethan
 * @create_time 2018/8/17 9:34
 */
@ApiModel
@Data
public class AccountBaseDTO {

	@ApiModelProperty(value = "账号")
	@NotNull(message = "账号为空")
	private String account;

	@ApiModelProperty(value = "密码")
	@NotNull(message = "密码为空")
	private String password;

	@ApiModelProperty(value = "用户名")
	@NotNull(message = "用户名为空")
	private String name;

	@ApiModelProperty(value = "手机号")
	@NotNull(message = "手机号为空")
	private String mobile;

	@ApiModelProperty(value = "邮箱")
	@NotNull(message = "邮箱为空")
	private String email;

	@ApiModelProperty(value = "账号等级", hidden = true)
	private String accountLevel;

	@ApiModelProperty(value = "权限ID（逗号分隔）")
	private String accessIds;

	@ApiModelProperty(value = "折扣")
	private Integer discount;
}
