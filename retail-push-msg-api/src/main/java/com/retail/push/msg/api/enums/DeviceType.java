package com.retail.push.msg.api.enums;

public enum DeviceType {

	ANDROID(1, "android"),
	IOS(2, "ios"),
	WAP(3, "wap"),
	PC(4, "pc"),
	POS(5, "pos");

	private int code;
	private String desc;

	DeviceType(int code, String desc) {
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
}
