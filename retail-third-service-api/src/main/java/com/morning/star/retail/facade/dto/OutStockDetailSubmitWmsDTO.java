package com.morning.star.retail.facade.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 外部服务出库细表dto
 */
@ApiModel
public class OutStockDetailSubmitWmsDTO implements Serializable {
	private static final long serialVersionUID = 735382006815547012L;

	@ApiModelProperty(required = true, value = "货品编码")
	private String productCode;

	@ApiModelProperty(required = true, value = "采购数量")
	private BigDecimal qty;

	public OutStockDetailSubmitWmsDTO() {
	}

	public OutStockDetailSubmitWmsDTO(String productCode, BigDecimal qty) {
		this.productCode = productCode;
		this.qty = qty;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public BigDecimal getQty() {
		return qty;
	}

	public void setQty(BigDecimal qty) {
		this.qty = qty;
	}

}
