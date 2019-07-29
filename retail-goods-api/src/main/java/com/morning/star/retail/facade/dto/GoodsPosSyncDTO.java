package com.morning.star.retail.facade.dto;

import java.io.Serializable;

public class GoodsPosSyncDTO implements Serializable {
	private static final long serialVersionUID = 735382006815547012L;

	/**
	 * 货品编码
	 */
	private String goodsCode;
	/**
	 * 货品名称
	 */
	private String productName;

	public String getGoodsCode() {
		return goodsCode;
	}

	public void setGoodsCode(String goodsCode) {
		this.goodsCode = goodsCode;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}
}
