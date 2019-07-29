package com.morning.star.retail.stock.enums;

/**
 * 日志操作类型
 * 
 * @author jiangyf
 */
public enum StockLogTypeEnum {
	CREATE("C", "增"),
	READ("R", "查"),
	UPDATE("U", "改"),
	DELETE("D", "删");

	private String code;
	private String desc;

	StockLogTypeEnum(String code, String desc) {
		this.code = code;
		this.desc = desc;
	}

	public String getCode() {
		return code;
	}

	public String getDesc() {
		return desc;
	}

	public static StockLogTypeEnum getStockLogType(String code) {
		for (StockLogTypeEnum stockRecordTypeEnum : values()) {
			if (stockRecordTypeEnum.getCode().equals(code)) {
				return stockRecordTypeEnum;
			}
		}
		return null;
	}

}
