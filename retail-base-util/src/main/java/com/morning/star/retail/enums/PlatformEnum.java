package com.morning.star.retail.enums;

/**
 * 管理平台
 *
 * @author jiangyf
 */
public enum PlatformEnum {

	GOD("god", "上帝端"),
	GROUP("group", "集团端"),
	STORE("store", "门店端"),
	POS("pos", "POS端"),
	SUPPLIER("supplier", "供应商端");

	private String code;
	private String desc;

	PlatformEnum(String code, String desc) {
		this.code = code;
		this.desc = desc;
	}

	public String getCode() {
		return code;
	}

	public String getDesc() {
		return desc;
	}

}
