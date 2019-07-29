package com.morning.star.retail.stock.enums;

/**
 * 库存模式
 *
 * @author jiangyf
 */
public enum StockModelEnum {
	MANAGE_STOCK(0, "管理库存"),
	REGISTER_STOCK(1, "登记库存");

	private Integer code;
	private String desc;

	StockModelEnum(Integer code, String desc) {
		this.code = code;
		this.desc = desc;
	}

	public Integer getCode() {
		return code;
	}

	public String getDesc() {
		return desc;
	}

	public static StockModelEnum getStockModel(Integer code) {
		for (StockModelEnum value : values()) {
			if (value.getCode().equals(code)) {
				return value;
			}
		}
		return null;
	}

}
