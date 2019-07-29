package com.morning.star.retail.admin.enums;

/**
 * 资源状态（0：正常，1：删除；2：锁定）
 * 
 * @author jiangyf
 */
public enum ResourceStatusEnum {
	NORMAL(0, "正常"), DELETED(1, "删除"), LOCKED(2, "锁定");

	private Integer code;
	private String desc;

	private ResourceStatusEnum(Integer code, String desc) {
		this.code = code;
		this.desc = desc;
	}

	public static ResourceStatusEnum getEnum(Integer code) {
		for (ResourceStatusEnum value : values()) {
			if (value.getCode().equals(code)) {
				return value;
			}
		}
		return null;
	}

	public Integer getCode() {
		return code;
	}

	public String getDesc() {
		return desc;
	}
}