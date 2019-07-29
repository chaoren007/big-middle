package com.retail.push.msg.api.enums;

/**
 * Created by lenovo on 2017/9/15.
 */
public enum UserType {
	MANAGER(0, "管理用户"),
	NORMAL(1, "普通用户"),
	NO_LOGIN(2, "未登陆用户");

	private int code;
	private String desc;

	UserType(int code, String desc) {
		this.code = code;
		this.desc = desc;
	}

	public int getCode() {
		return code;
	}

	public String getDesc() {
		return desc;
	}
}
