package com.morning.star.retail.stock.enums;

public enum ReplenishStatusEnum {
	APPLYED("APPLYED", "已申请"), 
	AUDITSUCCESS("AUDITSUCCESS", "审核成功"), 
	AUDITFAIL("AUDITFAIL", "审核失败"), 
	PREPARED("PREPARED", "拣货中"), 
	SHIPPED("SHIPPED", "配送中"), 
	SIGNED("SIGNED", "已收货");

	private String code;
	private String desc;

	private ReplenishStatusEnum(String code, String desc) {
		this.code = code;
		this.desc = desc;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public static ReplenishStatusEnum getReplenishStatus(String code) {
		for (ReplenishStatusEnum ReplenishStatusEnum : values()) {
			if (ReplenishStatusEnum.getCode().equals(code)) {
				return ReplenishStatusEnum;
			}
		}
		return null;
	}
}
