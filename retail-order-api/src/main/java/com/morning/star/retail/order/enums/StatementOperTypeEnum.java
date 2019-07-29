package com.morning.star.retail.order.enums;


public enum StatementOperTypeEnum {
	CREATE("C", "增"), READ("R", "查"), UPDATE("U", "改"), DELETE("D", "删");

	private String code;
	private String desc;

	private StatementOperTypeEnum(String code, String desc) {
		this.code = code;
		this.desc = desc;
	}

	public String getCode() {
		return code;
	}

	public String getDesc() {
		return desc;
	}

	public static StatementOperTypeEnum getStatementOperType(String code) {
		for (StatementOperTypeEnum statementOperTypeEnum : values()) {
			if (statementOperTypeEnum.getCode().equals(code)) {
				return statementOperTypeEnum;
			}
		}
		return null;
	}

}
