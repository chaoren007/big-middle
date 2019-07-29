package com.morning.star.retail.stock.enums;

/**
 * 库存类型
 *
 * @author jiangyf
 */
public enum StockTypeEnum {
	IN_STOCK("IN_STOCK", "入库"), OUT_STOCK("OUT_STOCK", "出库");

	private String code;
	private String desc;

	StockTypeEnum(String code, String desc) {
		this.code = code;
		this.desc = desc;
	}

	public String getCode() {
		return code;
	}

	public String getDesc() {
		return desc;
	}

	public static StockTypeEnum getStockType(String code) {
		for (StockTypeEnum stockTypeEnum : values()) {
			if (stockTypeEnum.getCode().equals(code)) {
				return stockTypeEnum;
			}
		}
		return null;
	}

}
