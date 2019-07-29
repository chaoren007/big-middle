package com.morning.star.retail.facade.dto;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@ApiModel
public class ProductSyncGoodsDTO implements Serializable {
	private static final long serialVersionUID = 735382006815547012L;

	@ApiModelProperty(value = "货品编码")
	private String productCode;

	@ApiModelProperty(value = "集团编码")
	private String groupCode;

	public ProductSyncGoodsDTO() {
	}

	public ProductSyncGoodsDTO(String productCode, String groupCode) {
		this.productCode = productCode;
		this.groupCode = groupCode;
	}

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
}
