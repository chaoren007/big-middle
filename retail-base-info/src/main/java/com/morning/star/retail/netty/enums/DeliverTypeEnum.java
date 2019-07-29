package com.morning.star.retail.netty.enums;

/**
 * 配送方式（1：送货上门；2：门店自提）
 * 
 * @author jiangyf
 * @date 2017年5月19日 下午4:25:58
 */
public enum DeliverTypeEnum {
	TO_HOME(1, "送货上门"), TO_STORE(2, "门店自提"),SELF_DELIVERY(3,"自己配送");

	private Integer code;
	private String desc;

	private DeliverTypeEnum(Integer code, String desc) {
		this.code = code;
		this.desc = desc;
	}

	public Integer getCode() {
		return code;
	}

	public String getDesc() {
		return desc;
	}

	public static DeliverTypeEnum getEnum(Integer code) {
		for (DeliverTypeEnum value : values()) {
			if (value.getCode().equals(code)) {
				return value;
			}
		}
		return null;
	}

}
