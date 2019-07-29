package com.morning.star.retail.enums;

import javax.persistence.AttributeConverter;

public enum EquipmentTypeEnum {

	ANDROID(1, "android"),
	IOS(2, "ios"),
	WAP(3, "wap"),
	PC(4, "pc"),
	POS(5, "pos");

	private int code;
	private String desc;

	EquipmentTypeEnum(int code, String desc) {
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

	public static class Convert implements AttributeConverter<EquipmentTypeEnum, Integer> {
		@Override
		public Integer convertToDatabaseColumn(EquipmentTypeEnum attribute) {
			return attribute == null ? null : attribute.getCode();
		}

		@Override
		public EquipmentTypeEnum convertToEntityAttribute(Integer dbData) {
			for (EquipmentTypeEnum type : EquipmentTypeEnum.values()) {
				if (dbData.equals(type.getCode())) {
					return type;
				}
			}
			throw new RuntimeException("Unknown database value: " + dbData);
		}
	}

	public static EquipmentTypeEnum getByCode(Integer code) {
		for (EquipmentTypeEnum typeEnum : EquipmentTypeEnum.values()) {
			if (typeEnum.getCode() == code) {
				return typeEnum;
			}
		}
		return null;

	}
}
