package com.morning.star.retail.admin.enums;

/**
 * 资源级别（group：分组；mode：模块；method：方法）
 * 
 * @author jiangyf
 */
public enum ResourceLevelEnum {
	GROUP("group", "分组"), MODE("mode", "模块"), METHOD("method", "方法");

	private String code;
	private String desc;

	private ResourceLevelEnum(String code, String desc) {
		this.code = code;
		this.desc = desc;
	}

	public static ResourceLevelEnum getEnum(String code) {
		for (ResourceLevelEnum value : values()) {
			if (value.getCode().equals(code)) {
				return value;
			}
		}
		return null;
	}

	public String getCode() {
		return code;
	}

	public String getDesc() {
		return desc;
	}
}