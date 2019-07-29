package com.morning.star.retail.enums;

/**
 * 是否冻结
 * 
 * @author jiangyf
 * @date 2017年7月17日 下午5:49:30
 */
public enum IsFreeEnum {
	NORMAL(0, "正常"), FREEZE(1, "冻结");

	private Integer code;
	private String desc;

	private IsFreeEnum(Integer code, String desc) {
		this.code = code;
		this.desc = desc;
	}

	public Integer getCode() {
		return code;
	}

	public String getDesc() {
		return desc;
	}

	public static IsFreeEnum getEnum(Integer code) {
		for (IsFreeEnum value : values()) {
			if (value.getCode().equals(code)) {
				return value;
			}
		}
		return null;
	}

}
