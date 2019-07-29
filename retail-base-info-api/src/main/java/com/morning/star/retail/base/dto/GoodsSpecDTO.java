package com.morning.star.retail.base.dto;

import java.io.Serializable;

/**
 * Created by liangguobin on 2017/5/9.
 */
public class GoodsSpecDTO implements Serializable {
	private static final long serialVersionUID = 5851005014593494406L;

	/**
	 * 规格编码
	 */
	private String spuCode;
	/**
	 * 货品编码
	 */
	private String goodsCode;
	/**
	 * 规格名称
	 */
	private String specKey;
	/**
	 * 规格值
	 */
	private String specValue;
	/**
	 * 排序
	 */
	private Integer priority;

	public String getSpuCode() {
		return spuCode;
	}

	public void setSpuCode(String spuCode) {
		this.spuCode = spuCode;
	}

	public String getGoodsCode() {
		return goodsCode;
	}

	public void setGoodsCode(String goodsCode) {
		this.goodsCode = goodsCode;
	}

	public String getSpecKey() {
		return specKey;
	}

	public void setSpecKey(String specKey) {
		this.specKey = specKey;
	}

	public String getSpecValue() {
		return specValue;
	}

	public void setSpecValue(String specValue) {
		this.specValue = specValue;
	}

	public Integer getPriority() {
		return priority;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
	}

	public GoodsSpecDTO() {
	}

	public GoodsSpecDTO(String spuCode, String goodsCode, String specKey, String specValue) {
		this.spuCode = spuCode;
		this.goodsCode = goodsCode;
		this.specKey = specKey;
		this.specValue = specValue;
	}

	public static GoodsSpecDTO instance(String specKey, String specValue) {
		return new GoodsSpecDTO(null, null, specKey, specValue);
	}

}
