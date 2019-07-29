package com.morning.star.retail.base.dto;

import java.io.Serializable;

/**
 * spu规格
 * 
 * @author jiangyf
 * @date 2017年6月29日 下午4:56:42
 */
public class SpuSpecDTO implements Serializable {
	private static final long serialVersionUID = -4098460951176014280L;

	/**
	 * 规格名称
	 */
	private String specKey;
	/**
	 * 规格值
	 */
	private String[] specValues;

	public String getSpecKey() {
		return specKey;
	}

	public void setSpecKey(String specKey) {
		this.specKey = specKey;
	}

	public String[] getSpecValues() {
		return specValues;
	}

	public void setSpecValues(String[] specValues) {
		this.specValues = specValues;
	}

	public SpuSpecDTO() {
	}

	public SpuSpecDTO(String specKey, String[] specValues) {
		this.specKey = specKey;
		this.specValues = specValues;
	}

	public static SpuSpecDTO instance(String specKey, String[] specValues) {
		return new SpuSpecDTO(specKey, specValues);
	}

}
