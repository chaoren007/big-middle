package com.morning.star.retail.stock.bean;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 补货数据（用于接收json数据）
 */
public class ReplenishBean implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2093452928273571315L;
	/**
	 * 商品编码
	 */
	private String goodsCode;
	/**
	 * 补货数量
	 */
	private BigDecimal replenishNum;
	
	
	public String getGoodsCode() {
		return goodsCode;
	}

	public void setGoodsCode(String goodsCode) {
		this.goodsCode = goodsCode;
	}

	public BigDecimal getReplenishNum() {
		return replenishNum;
	}

	public void setReplenishNum(BigDecimal replenishNum) {
		this.replenishNum = replenishNum;
	}

	

}
