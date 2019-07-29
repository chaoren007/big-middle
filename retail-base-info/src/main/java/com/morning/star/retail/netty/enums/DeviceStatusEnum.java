package com.morning.star.retail.netty.enums;

/**
 * 设备状态（0：未激活 ；1：已激活；2：已锁定）
 * 
 * @author jiangyf
 */
public enum DeviceStatusEnum {
	UNACTIVATED(0, "未激活"), ACTIVATED(1, "已激活"), LOCKED(2, "已锁定");

	private Integer code;
	private String desc;

	private DeviceStatusEnum(Integer code, String desc) {
		this.code = code;
		this.desc = desc;
	}

	public Integer getCode() {
		return code;
	}

	public String getDesc() {
		return desc;
	}

	public static DeviceStatusEnum getEnum(Integer code) {
		for (DeviceStatusEnum value : values()) {
			if (value.getCode().equals(code)) {
				return value;
			}
		}
		return null;
	}
}
