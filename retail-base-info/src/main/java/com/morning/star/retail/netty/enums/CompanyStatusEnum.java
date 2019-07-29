package com.morning.star.retail.netty.enums;

/**
 * 公司状态（0：未激活 ；1：已激活）
 * 
 * @author jiangyf
 */
public enum CompanyStatusEnum {
	UNACTIVATED(0, "未激活"), ACTIVATED(1, "已激活");

	private Integer code;
	private String desc;

	private CompanyStatusEnum(Integer code, String desc) {
		this.code = code;
		this.desc = desc;
	}

	public Integer getCode() {
		return code;
	}

	public String getDesc() {
		return desc;
	}

	public static CompanyStatusEnum getEnum(Integer code) {
		for (CompanyStatusEnum value : values()) {
			if (value.getCode().equals(code)) {
				return value;
			}
		}
		return null;
	}
}
