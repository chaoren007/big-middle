package com.morning.star.retail.enums;

/**
 * @author ethan
 * @create_time 2019/5/22 10:37
 */
public enum GoodsAttributeEnum {
	// 外购
	OUT_BUY("OUT_BUY", "外购");

	private final String code;
	private final String desc;

	GoodsAttributeEnum(String code, String desc) {
		this.code = code;
		this.desc = desc;
	}

	public String getCode() {
		return code;
	}

	public String getDesc() {
		return desc;
	}

	public static boolean exitCode(String code) {
		for (GoodsAttributeEnum value : values()) {
			if (value.getCode().equals(code)) {
				return true;
			}
		}
		return false;
	}
}
