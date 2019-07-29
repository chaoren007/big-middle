package com.morning.star.retail.order.facade.dto;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;

public class BusTopItemsDTO implements Serializable {
	private static final long serialVersionUID = 1213829454950205914L;

	
	@ApiModelProperty("商品名称")
	private String  pName;

	@ApiModelProperty("商品编码")
	private String  pCode;

	@ApiModelProperty("销售量")
	private BigDecimal count;

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public String getpCode() {
		return pCode;
	}

	public void setpCode(String pCode) {
		this.pCode = pCode;
	}

	public BigDecimal getCount() {
		return count;
	}

	public void setCount(BigDecimal count) {
		this.count = count;
	}
}
