package com.morning.star.retail.facade.dto.purchasein;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;

@ApiModel
public class PurchaseInDetailUpdateDTO implements Serializable {
	private static final long serialVersionUID = 5512269180604741392L;

	@ApiModelProperty(value = "入库单号")
	private String receiptCode;

	@ApiModelProperty(value = "商品编号")
	private String productCode;

	@ApiModelProperty(value = "采购入库数量")
	private BigDecimal receiptQty = BigDecimal.ZERO;

	public String getReceiptCode() {
		return receiptCode;
	}

	public void setReceiptCode(String receiptCode) {
		this.receiptCode = receiptCode;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public BigDecimal getReceiptQty() {
		return receiptQty;
	}

	public void setReceiptQty(BigDecimal receiptQty) {
		this.receiptQty = receiptQty;
	}
}
