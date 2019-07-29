package com.morning.star.retail.order.facade.dto;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class BusOrderStatisticsDTO implements Serializable {
	private static final long serialVersionUID = 1213829454950205914L;

	
	@ApiModelProperty("日期")
	private Date date;

	@ApiModelProperty("购买者")
	private String  code;

	@ApiModelProperty("销售量")
	private BigDecimal count;

	@ApiModelProperty("销售额")
	private BigDecimal amount;

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public BigDecimal getCount() {
		return count;
	}

	public void setCount(BigDecimal count) {
		this.count = count;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
}
