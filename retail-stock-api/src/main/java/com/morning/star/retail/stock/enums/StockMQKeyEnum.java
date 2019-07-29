package com.morning.star.retail.stock.enums;

/**
 * Created by lenovo on 2017/9/21.
 */
public enum StockMQKeyEnum {
	STOCK_SYNC_KEY("stock_sync", "同步库存key"), SUBMIT_INVENTORY_KEY("submit_inventory", "提交盘点key");

	private String code;
	private String desc;

	private StockMQKeyEnum(String code, String desc) {
		this.code = code;
		this.desc = desc;
	}

	public String getCode() {
		return code;
	}

	public String getDesc() {
		return desc;
	}

	public static StockMQKeyEnum getStockQueue(String code) {
		for (StockMQKeyEnum stockQueueEnum : values()) {
			if (stockQueueEnum.getCode().equals(code)) {
				return stockQueueEnum;
			}
		}
		return null;
	}
}
