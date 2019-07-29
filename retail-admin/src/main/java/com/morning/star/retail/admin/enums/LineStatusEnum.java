package com.morning.star.retail.admin.enums;

/**
 * 登录账户线上状态（0：离线；1：在线）
 * 
 * @author jiangyf
 */
public enum LineStatusEnum {
	OFFLINE(0, "离线"), ONLINE(1, "在线");

	private Integer code;
	private String desc;

	private LineStatusEnum(Integer code, String desc) {
		this.code = code;
		this.desc = desc;
	}

	public Integer getCode() {
		return code;
	}

	public String getDesc() {
		return desc;
	}

	public static LineStatusEnum getEnum(Integer code) {
		for (LineStatusEnum value : values()) {
			if (value.getCode().equals(code)) {
				return value;
			}
		}
		return null;
	}
}