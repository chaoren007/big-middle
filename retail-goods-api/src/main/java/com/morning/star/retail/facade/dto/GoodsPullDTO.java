package com.morning.star.retail.facade.dto;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@ApiModel
public class GoodsPullDTO implements Serializable {
	private static final long serialVersionUID = 735382006815547012L;

	@NotNull(message = "货品编码不能为空")
	@ApiModelProperty(value = "货品编码")
	private String productCode;

	//@NotNull(message = "集团编码不能为空")
	@ApiModelProperty(value = "集团编码", hidden = true)
	private String groupCode;

	//@NotNull(message = "门店编码不能为空")
	@ApiModelProperty(value = "门店编码", hidden = true)
	private String storeCode;

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

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
