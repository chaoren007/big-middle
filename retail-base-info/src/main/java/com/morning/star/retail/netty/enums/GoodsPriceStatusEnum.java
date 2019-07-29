package com.morning.star.retail.netty.enums;

/**
 * 货品定价状态（0：待审核，1：审核成功，2：审核失败)
 * 
 * @author jiangyf
 */
public enum GoodsPriceStatusEnum {
	WAIT_AUDIT(0, "待审核"), AUDIT_SUCCESS(1, "审核成功"), AUDIT_FAIL(1, "审核失败");

	private Integer code;
	private String desc;

	private GoodsPriceStatusEnum(Integer code, String desc) {
		this.code = code;
		this.desc = desc;
	}

	public Integer getCode() {
		return code;
	}

	public String getDesc() {
		return desc;
	}

	public static GoodsPriceStatusEnum getEnum(Integer code) {
		for (GoodsPriceStatusEnum value : values()) {
			if (value.getCode().equals(code)) {
				return value;
			}
		}
		return null;
	}
}
