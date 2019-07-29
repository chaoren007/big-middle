package com.morning.star.retail.admin.enums;

/**
 * 登录账户状态（0：正常；1：冻结；2：作废）
 * 
 * @author jiangyf
 */
public enum LoginAccountStatusEnum {
	NORMAL(0, "正常"), FREEZE(1, "冻结"), DELETE(2, "作废");

	private Integer code;
	private String desc;

	private LoginAccountStatusEnum(Integer code, String desc) {
		this.code = code;
		this.desc = desc;
	}

	public Integer getCode() {
		return code;
	}

	public String getDesc() {
		return desc;
	}

	public static LoginAccountStatusEnum getEnum(Integer code) {
		for (LoginAccountStatusEnum value : values()) {
			if (value.getCode().equals(code)) {
				return value;
			}
		}
		return null;
	}
}