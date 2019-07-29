package com.morning.star.retail.stock.enums;

/**
 * 库存预占状态（0：初始化；1：确认；2：取消；3：结束）
 *
 * @author jiangyf
 */
public enum StockPreStatusEnum {
	INIT_PRE(0, "初始化预占"), CHECK_PRE(1, "确认预占"), CANCEL_PRE(2, "取消预占"), FINISH_PRE(3, "结束预占");

	private Integer code;
	private String desc;

	StockPreStatusEnum(Integer code, String desc) {
		this.code = code;
		this.desc = desc;
	}

	public Integer getCode() {
		return code;
	}

	public String getDesc() {
		return desc;
	}

	public static StockPreStatusEnum getStockModel(Integer code) {
		for (StockPreStatusEnum value : values()) {
			if (value.getCode().equals(code)) {
				return value;
			}
		}
		return null;
	}

}
