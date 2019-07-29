package com.morning.star.retail.admin.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 登录账号
 *
 * @author wumengzhen
 */
@ApiModel(value = "集团账号")
public class AccountGroupAddDTO extends AccountBaseDTO implements Serializable {

	private static final long serialVersionUID = -9057076021816031093L;

	public static final String DEFAULT_PASSWORD = "12345678";

	@ApiModelProperty(value = "集团编码")
	@NotNull(message = "集团编码为空")
	private String groupCode;

	public String getGroupCode() {
		return groupCode;
	}

	public void setGroupCode(String groupCode) {
		this.groupCode = groupCode;
	}
}