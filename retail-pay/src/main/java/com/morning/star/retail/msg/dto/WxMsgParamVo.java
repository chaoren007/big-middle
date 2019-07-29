package com.morning.star.retail.msg.dto;

import java.io.Serializable;

public class WxMsgParamVo implements Serializable {
	private static final long serialVersionUID = 1070419010467157320L;

	private String value;
	private String color = "#4169E1";	// 显示这个字段时使用的颜色

	public WxMsgParamVo() {
		super();
	}
	
	public WxMsgParamVo(String value) {
		this.value = value;
	}

	public WxMsgParamVo(String value, String color) {
		super();
		this.value = value;
		this.color = color;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

}
