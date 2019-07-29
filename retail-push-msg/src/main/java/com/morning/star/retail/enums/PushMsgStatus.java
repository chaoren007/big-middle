package com.morning.star.retail.enums;

import javax.persistence.AttributeConverter;

public enum PushMsgStatus {

	INIT(0, "待发送"),
	SEND(1, "已发送"),
	SUCCESS(2, "已成功");

	private int code;
	private String desc;

	PushMsgStatus(int code, String desc) {
		this.code = code;
		this.desc = desc;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public static class Convert implements AttributeConverter<PushMsgStatus, Integer> {
		@Override
		public Integer convertToDatabaseColumn(PushMsgStatus attribute) {
			return attribute == null ? null : attribute.getCode();
		}

		@Override
		public PushMsgStatus convertToEntityAttribute(Integer dbData) {
			for (PushMsgStatus type : PushMsgStatus.values()) {
				if (dbData.equals(type.getCode())) {
					return type;
				}
			}
			throw new RuntimeException("Unknown database value: " + dbData);
		}
	}
}
