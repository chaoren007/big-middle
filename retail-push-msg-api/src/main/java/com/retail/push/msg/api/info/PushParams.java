package com.retail.push.msg.api.info;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * Created by Dell on 2018/7/17.
 */
@ApiModel(value = "推送消息主内容")
public class PushParams implements Serializable {
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "消息编码", hidden = true)
	private String msgCode;

	@ApiModelProperty(value = "内容")
	private String msg;

	@ApiModelProperty(value = "消息类型，0：普通消息  1：需要确认收到")
	private Integer msgType;

	public String getMsgCode() {
		return msgCode;
	}

	public void setMsgCode(String msgCode) {
		this.msgCode = msgCode;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Integer getMsgType() {
		return msgType;
	}

	public void setMsgType(Integer msgType) {
		this.msgType = msgType;
	}
}