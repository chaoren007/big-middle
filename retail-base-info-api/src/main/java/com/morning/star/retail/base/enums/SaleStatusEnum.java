package com.morning.star.retail.base.enums;

/**
 * 线上销售状态（0：下架；1：上架）
 * 
 * @author jiangyf
 */
public enum SaleStatusEnum {
	OFFSALE(0, "下架"), ONSALE(1, "上架");

	private Integer code;
	private String desc;

	private SaleStatusEnum(Integer code, String desc) {
		this.code = code;
		this.desc = desc;
	}

	public Integer getCode() {
		return code;
	}

	public String getDesc() {
		return desc;
	}

	public static SaleStatusEnum getEnum(Integer code) {
		for (SaleStatusEnum value : values()) {
			if (value.getCode().equals(code)) {
				return value;
			}
		}
		return null;
	}
}
