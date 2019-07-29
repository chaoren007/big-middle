package com.morning.star.retail.msg.dto;

import java.io.Serializable;

public class WxMsgRequest implements Serializable {
	private static final long serialVersionUID = 1097034446858838360L;

	private String touser;
	private String template_id;
	private String url;
	private WxMsg data;

	public WxMsgRequest() {
		super();
	}

	public WxMsgRequest(String touser, String template_id, String url, WxMsg data) {
		super();
		this.touser = touser;
		this.template_id = template_id;
		this.url = url;
		this.data = data;
	}

	public String getTouser() {
		return touser;
	}

	public void setTouser(String touser) {
		this.touser = touser;
	}

	public String getTemplate_id() {
		return template_id;
	}

	public void setTemplate_id(String template_id) {
		this.template_id = template_id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public WxMsg getData() {
		return data;
	}

	public void setData(WxMsg data) {
		this.data = data;
	}

}
