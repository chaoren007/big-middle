package com.morning.star.retail.admin.group.goods.controller.enums;

/**
 * 流通状态，0：退市 1：上市
 */
public enum ProductMarketStatus {
	ON_MARKET(1, "上市"),
	OFF_MARKET(0, "退市");

	private final Integer code;
	private final String desc;

	ProductMarketStatus(Integer code, String desc) {
		this.code = code;
		this.desc = desc;
	}

	public Integer getCode() {
		return code;
	}

	public String getDesc() {
		return desc;
	}

	public static ProductMarketStatus get(Integer code) {
		ProductMarketStatus groupGoodsMarketStatus = null;
		for (ProductMarketStatus status : ProductMarketStatus.values()) {
			if (status.getCode().equals(code)) {
				groupGoodsMarketStatus = status;
				break;
			}
		}
		if (groupGoodsMarketStatus == null) {
			throw new IllegalArgumentException("集团商品上下市状态异常：" + code);
		}
		return groupGoodsMarketStatus;
	}
}
