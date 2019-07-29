package com.morning.star.retail.order.facade.dto;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

public class BusOrderStatusStatisticsDTO implements Serializable {
	private static final long serialVersionUID = 1213829454950205914L;

	
	@ApiModelProperty("待发货数量")
	private Integer no_deal_num;

	@ApiModelProperty("已发货数量")
	private Integer dealed_num;

	@ApiModelProperty("待结算数量")
	private Integer settlement_num;

	@ApiModelProperty("待处理售后数量")
	private Integer after_sales_num;


	public Integer getAfter_sales_num() {
		return after_sales_num;
	}

	public void setAfter_sales_num(Integer after_sales_num) {
		this.after_sales_num = after_sales_num;
	}

	public Integer getNo_deal_num() {
		return no_deal_num;
	}

	public void setNo_deal_num(Integer no_deal_num) {
		this.no_deal_num = no_deal_num;
	}

	public Integer getDealed_num() {
		return dealed_num;
	}

	public void setDealed_num(Integer dealed_num) {
		this.dealed_num = dealed_num;
	}

	public Integer getSettlement_num() {
		return settlement_num;
	}

	public void setSettlement_num(Integer settlement_num) {
		this.settlement_num = settlement_num;
	}
}
