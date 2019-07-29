package com.morning.star.retail.admin.enums;

/**
 * 状态（0：正常，1：删除；2：锁定）
 * 
 * @author jiangyf
 */
public enum RoleStatusEnum {
	NORMAL(0, "正常"), DELETE(1, "删除"), LOCKED(2, "锁定");

	private Integer code;
	private String desc;

	private RoleStatusEnum(Integer code, String desc) {
		this.code = code;
		this.desc = desc;
	}

	public Integer getCode() {
		return code;
	}

	public String getDesc() {
		return desc;
	}

	public static RoleStatusEnum getEnum(Integer code) {
		for (RoleStatusEnum value : values()) {
			if (value.getCode().equals(code)) {
				return value;
			}
		}
		return null;
	}
}