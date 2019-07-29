package com.morning.star.retail.admin.group.stock.controller.enums;

public enum PurchaseStatusEnum {
	PREPARE_DRAFT(0, "草稿"),
	WAIT_AUDIT(10, "待审核"),
	AUDIT_SUCCESS(20, "审核成功"),
	AUDIT_REJECT(30, "审核失败"),
	MANAGER_AUDIT(40, "负责人审核成功"),
	BOSS_AUDIT(50, "老板审核成功");

	private Integer code;
	private String desc;

	PurchaseStatusEnum(Integer code, String desc) {
		this.code = code;
		this.desc = desc;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public static PurchaseStatusEnum getPurchaseStatus(int code) {
		for (PurchaseStatusEnum PurchaseStatusEnum : values()) {
			if (PurchaseStatusEnum.getCode() == (code)) {
				return PurchaseStatusEnum;
			}
		}
		return null;
	}
}
