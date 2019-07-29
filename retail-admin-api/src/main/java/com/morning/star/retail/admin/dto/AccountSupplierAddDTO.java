package com.morning.star.retail.admin.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@ApiModel(value = "供应商账号")
@Data
public class AccountSupplierAddDTO extends AccountBaseDTO implements Serializable {
	private static final long serialVersionUID = -6696850827700547146L;

	@ApiModelProperty(value = "集团编码", hidden = true)
	private String groupCode;

	@ApiModelProperty(value = "集团名称", hidden = true)
	private String groupName;

	@ApiModelProperty(value = "供应商编码")
	@NotNull(message = "供应商编码不能为空")
	private String supplierCode;

	@ApiModelProperty(value = "供应商名称")
	@NotNull(message = "供应商名称不能为空")
	private String supplierName;
}