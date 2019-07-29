package com.morning.star.retail.enums;

import javax.persistence.AttributeConverter;

public enum EquipmentStatus {

	INIT(0, "初始状态"),
	ACTIVE(1, "活跃状态"),
	CLOSE(2, "关闭状态");

	private int code;
	private String desc;

	EquipmentStatus(int code, String desc) {
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

	public static class Convert implements AttributeConverter<EquipmentStatus, Integer> {
		@Override
		public Integer convertToDatabaseColumn(EquipmentStatus attribute) {
			return attribute == null ? null : attribute.getCode();
		}

		@Override
		public EquipmentStatus convertToEntityAttribute(Integer dbData) {
			for (EquipmentStatus type : EquipmentStatus.values()) {
				if (dbData.equals(type.getCode())) {
					return type;
				}
			}
			throw new RuntimeException("Unknown database value: " + dbData);
		}
	}
}
