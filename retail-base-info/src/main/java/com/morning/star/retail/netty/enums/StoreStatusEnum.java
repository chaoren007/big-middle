package com.morning.star.retail.netty.enums;

/**
 * 门店营业状态
 * 
 * @author jiangyf
 */
public enum StoreStatusEnum {
	OPEN("OPEN", "营业中"), CLOSE("CLOSE", "关闭中");

	private String code;
	private String desc;

	private StoreStatusEnum(String code, String desc) {
		this.code = code;
		this.desc = desc;
	}

	public String getCode() {
		return code;
	}

	public String getDesc() {
		return desc;
	}

	public static StoreStatusEnum getEnum(String code) {
		for (StoreStatusEnum value : values()) {
			if (value.getCode().equals(code)) {
				return value;
			}
		}
		return null;
	}
}
