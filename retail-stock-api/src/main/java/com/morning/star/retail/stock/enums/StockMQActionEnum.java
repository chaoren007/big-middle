package com.morning.star.retail.stock.enums;

/**
 * Created by lenovo on 2017/9/20.
 */
public enum StockMQActionEnum {
	SYNC_STOCK("syncStock", "同步库存"), SUBMIT_INVENTORY("submitInventory", "提交盘点");

	private String code;
	private String desc;

	private StockMQActionEnum(String code, String desc) {
		this.code = code;
		this.desc = desc;
	}

	public String getCode() {
		return code;
	}

	public String getDesc() {
		return desc;
	}

	public static StockMQActionEnum getStockType(String code) {
		for (StockMQActionEnum stockSyncMQActionEnum : values()) {
			if (stockSyncMQActionEnum.getCode().equals(code)) {
				return stockSyncMQActionEnum;
			}
		}
		return null;
	}
}
