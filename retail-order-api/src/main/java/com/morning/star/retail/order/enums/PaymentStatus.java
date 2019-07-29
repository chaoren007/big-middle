package com.morning.star.retail.order.enums;

import javax.persistence.AttributeConverter;
import java.util.HashMap;
import java.util.Map;

public enum PaymentStatus {
	PAY_WAIT(0, "等待支付"), 
	PAY_ING(1, "支付中"), 
	PAY_SUCC(2, "支付成功"), 
	PAY_FAIL(3, "支付失败");

	private final int code;
	private final String desc;

	PaymentStatus(int code, String desc) {
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
	private static Map<Integer, PaymentStatus> map = new HashMap<>();

	/**
	 * 根据错误编码返回对应的错误枚举
	 * 
	 * @param code
	 * @return
	 */
	public static PaymentStatus getStatusByCode(int code) {
		if (map == null || map.isEmpty()) {
			map = new HashMap<>();
			for (PaymentStatus status : PaymentStatus.values()) {
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

	public static class Convert implements AttributeConverter<PaymentStatus, Integer> {
		@Override
		public Integer convertToDatabaseColumn(PaymentStatus attribute) {
			return attribute == null ? null : attribute.getCode();
		}

		@Override
		public PaymentStatus convertToEntityAttribute(Integer dbData) {
			for (PaymentStatus type : PaymentStatus.values()) {
				if (dbData.equals(type.getCode())) {
					return type;
				}
			}
			throw new RuntimeException("Unknown database value: " + dbData);
		}
	}
}
