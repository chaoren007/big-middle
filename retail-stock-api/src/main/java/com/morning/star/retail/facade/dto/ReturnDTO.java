package com.morning.star.retail.facade.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

@ApiModel
public class ReturnDTO implements Serializable {
	private static final long serialVersionUID = -3354852096303379642L;

	@ApiModelProperty(value = "退货商品编码")
	private String goodsCode;

	@ApiModelProperty(value = "退货数量")
	private Integer returnAmount;

	public String getGoodsCode() {
		return goodsCode;
	}

	public void setGoodsCode(String goodsCode) {
		this.goodsCode = goodsCode;
	}

	public Integer getReturnAmount() {
		return returnAmount;
	}

	public void setReturnAmount(Integer returnAmount) {
		this.returnAmount = returnAmount;
	}
}