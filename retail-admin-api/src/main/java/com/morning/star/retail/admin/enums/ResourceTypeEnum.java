package com.morning.star.retail.admin.enums;

/**
 * 资源类型（menu：菜单；button：按钮）
 * 
 * @author jiangyf
 */
public enum ResourceTypeEnum {
	MENU("menu", "菜单"), BUTTON("button", "按钮");

	private String code;
	private String desc;

	private ResourceTypeEnum(String code, String desc) {
		this.code = code;
		this.desc = desc;
	}

	public static ResourceTypeEnum getEnum(String code) {
		for (ResourceTypeEnum value : values()) {
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