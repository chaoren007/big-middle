package com.morning.star.retail.facade.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 获取单个集团商品查询条件类
 */
@ApiModel
public class ProductGetUpcDTO implements Serializable {
	private static final long serialVersionUID = -8369469132421362933L;

	@ApiModelProperty(value = "UPC编码")
	private String productUpc;

	@ApiModelProperty(value = "集团编码", hidden = true)
	private String groupCode;

	public String getProductUpc() {
		return productUpc;
	}

	public void setProductUpc(String productUpc) {
		this.productUpc = productUpc;
	}

	public String getGroupCode() {
		return groupCode;
	}

	public void setGroupCode(String groupCode) {
		this.groupCode = groupCode;
	}
}
