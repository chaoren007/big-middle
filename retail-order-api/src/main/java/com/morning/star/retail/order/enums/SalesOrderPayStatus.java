package com.morning.star.retail.order.enums;

import java.util.HashMap;
import java.util.Map;

public enum SalesOrderPayStatus {
	NOT_PAYED(0, "未支付"), PAYED(1, "已支付");

	private final int code;
	private final String desc;

	private SalesOrderPayStatus(int code, String desc) {
		this.code = code;
		this.desc = desc;
	}

	public int getCode() {
		return code;
	}

	public String getDesc() {
		return desc;
	}

	/**
	 * 错误编码以及对应的错误枚举对应关系
	 */
	private static Map<Integer, SalesOrderPayStatus> map = new HashMap<>();

	/**
	 * 根据错误编码返回对应的错误枚举
	 * 
	 * @param code
	 * @return
	 */
	private static SalesOrderPayStatus getStatusByCode(int code) {
		if (map == null || map.isEmpty()) {
			map = new HashMap<>();
			for (SalesOrderPayStatus status : SalesOrderPayStatus.values()) {
				map.put(status.getCode(), status);
			}
		}
		return map.get(code);
	}

	/**
	 * 根据错误编码返回对应的错误信息
	 * 
	 * @param code
	 * @return
	 */
	public static String getDesc(int code) {
		return getStatusByCode(code).getDesc();
	}
}
