package com.morning.star.retail.bo;

import java.io.Serializable;

/**
 * 货品规格
 * 
 * @author jiangyf
 * @date 2017年6月30日 上午10:18:11
 */
public class GoodsSpecBO implements Serializable {
	private static final long serialVersionUID = -1710057501892288396L;

	/**
	 * spu
	 */
	private String spuCode;
	/**
	 * 规格名称
	 */
	private String specKey;
	/**
	 * 规格值
	 */
	private String specValue;

	public String getSpuCode() {
		return spuCode;
	}

	public void setSpuCode(String spuCode) {
		this.spuCode = spuCode;
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

}
