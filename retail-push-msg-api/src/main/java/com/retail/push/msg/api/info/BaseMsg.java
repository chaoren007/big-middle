package com.retail.push.msg.api.info;


import com.retail.push.msg.api.enums.MessageType;

import java.io.Serializable;

/**
 * Created by Dell on 2018/7/17.
 */
public abstract class BaseMsg implements Serializable {
	private static final long serialVersionUID = 1L;
	private MessageType type;
	//必须唯一，否者会出现channel调用混乱
	private String clientId;

	public BaseMsg() {
	}

	public BaseMsg(String clientId) {
		this.clientId = clientId;
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public MessageType getType() {
		return type;
	}

	public void setType(MessageType type) {
		this.type = type;
	}
}
