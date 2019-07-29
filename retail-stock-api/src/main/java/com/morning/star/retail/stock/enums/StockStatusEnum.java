package com.morning.star.retail.stock.enums;

import java.util.ArrayList;
import java.util.List;

/**
 * 库存状态
 * 
 * @author jiangyf
 */
public enum StockStatusEnum {
	HAS_USED_STOCK("1", "有可用库存"), NO_USED_STOCK("2", "无可用库存");

	private String code;
	private String desc;

	StockStatusEnum(String code, String desc) {
		this.code = code;
		this.desc = desc;
	}

	public String getCode() {
		return code;
	}

	public String getDesc() {
		return desc;
	}

	public static StockStatusEnum getStockStatusEnum(String code) {
		for (StockStatusEnum stockStatusEnum : values()) {
			if (stockStatusEnum.getCode().equals(code)) {
				return stockStatusEnum;
			}
		}
		return null;
	}

	public static List<EnumObject> enumObjects = new ArrayList<>();

	/**
	 * 把库存状态转换为枚举对象
	 * 
	 * @return
	 */
	public static List<EnumObject> getEnumObjects() {
		if (enumObjects.isEmpty()) {
			for (StockStatusEnum en : StockStatusEnum.values()) {
				enumObjects.add(EnumObject.of(en.getCode(), en.getDesc()));
			}
		}
		return enumObjects;
	}

}
