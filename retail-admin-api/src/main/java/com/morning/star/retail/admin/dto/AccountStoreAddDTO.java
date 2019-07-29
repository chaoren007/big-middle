package com.morning.star.retail.admin.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@ApiModel(value = "门店账号")
public class AccountStoreAddDTO extends AccountBaseDTO implements Serializable {
	private static final long serialVersionUID = -6696850827700547146L;

	public static final String DEFAULT_PASSWORD = "123456";


	@ApiModelProperty(value = "集团编码", hidden = true)
	private String groupCode;

	@ApiModelProperty(value = "门店编码")
	@NotNull(message = "门店编码不能为空")
	private String storeCode;

	public String getGroupCode() {
		return groupCode;
	}

	public void setGroupCode(String groupCode) {
		this.groupCode = groupCode;
	}

	public String getStoreCode() {
		return storeCode;
	}

	public void setStoreCode(String storeCode) {
		this.storeCode = storeCode;
	}
}