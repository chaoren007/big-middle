package com.morning.star.retail.vo;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 货品信息
 * 
 * @author jiangyf
 * @date 2017年5月31日 下午8:30:16
 */
public class GoodsInfoVO implements Serializable {
	private static final long serialVersionUID = -3996164134444051851L;

	/**
	 * 货品编码
	 */
	private String goodsCode;

	/**
	 * 商品名称
	 */
	private String goodsName;

	/**
	 * upc
	 */
	private String upcCode;

	/**
	 * 商品类型 SP-单品,PP-套装
	 */
	private String goodsType;

	/**
	 * 销售指导价
	 */
	private BigDecimal guidePrice;

	/**
	 * 销售价
	 */
	private BigDecimal salePrice;

	public String getGoodsCode() {
		return goodsCode;
	}

	public void setGoodsCode(String goodsCode) {
		this.goodsCode = goodsCode;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public String getUpcCode() {
		return upcCode;
	}

	public void setUpcCode(String upcCode) {
		this.upcCode = upcCode;
	}

	public String getGoodsType() {
		return goodsType;
	}

	public void setGoodsType(String goodsType) {
		this.goodsType = goodsType;
	}

	public BigDecimal getGuidePrice() {
		return guidePrice;
	}

	public void setGuidePrice(BigDecimal guidePrice) {
		this.guidePrice = guidePrice;
	}

	public BigDecimal getSalePrice() {
		return salePrice;
	}

	public void setSalePrice(BigDecimal salePrice) {
		this.salePrice = salePrice;
	}

}
