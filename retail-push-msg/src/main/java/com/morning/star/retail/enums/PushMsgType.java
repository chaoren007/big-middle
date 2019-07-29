package com.morning.star.retail.enums;

import javax.persistence.AttributeConverter;

public enum PushMsgType {

	NORMAL(0, "基础消息"),
	CONFIRM(1, "需确认消息");

	private int code;
	private String desc;

	PushMsgType(int code, String desc) {
		this.code = code;
		this.desc = desc;
	}

	public static PushMsgType getByCode(Integer code) {
		for (PushMsgType pushMsgType : PushMsgType.values()) {
			if (pushMsgType.getCode() == code) {
				return pushMsgType;
			}
		}
		return null;
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

	public static class Convert implements AttributeConverter<PushMsgType, Integer> {
		@Override
		public Integer convertToDatabaseColumn(PushMsgType attribute) {
			return attribute == null ? null : attribute.getCode();
		}

		@Override
		public PushMsgType convertToEntityAttribute(Integer dbData) {
			for (PushMsgType type : PushMsgType.values()) {
				if (dbData.equals(type.getCode())) {
					return type;
				}
			}
			throw new RuntimeException("Unknown database value: " + dbData);
		}
	}
}
