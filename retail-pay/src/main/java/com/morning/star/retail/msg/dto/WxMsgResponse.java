package com.morning.star.retail.msg.dto;

import java.io.Serializable;

public class WxMsgResponse implements Serializable {
	private static final long serialVersionUID = -776895041521500626L;

	private int errcode;
	private String errmsg;
	private String msgid;

	public WxMsgResponse() {
		super();
	}

	public WxMsgResponse(int errcode, String errmsg) {
		super();
		this.errcode = errcode;
		this.errmsg = errmsg;
	}

	public WxMsgResponse(int errcode, String errmsg, String msgid) {
		super();
		this.errcode = errcode;
		this.errmsg = errmsg;
		this.msgid = msgid;
	}

	public int getErrcode() {
		return errcode;
	}

	public void setErrcode(int errcode) {
		this.errcode = errcode;
	}

	public String getErrmsg() {
		return errmsg;
	}

	public void setErrmsg(String errmsg) {
		this.errmsg = errmsg;
	}

	public String getMsgid() {
		return msgid;
	}

	public void setMsgid(String msgid) {
		this.msgid = msgid;
	}

}
