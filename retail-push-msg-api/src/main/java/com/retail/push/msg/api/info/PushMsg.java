package com.retail.push.msg.api.info;


import com.retail.push.msg.api.enums.MessageType;

/**
 * Created by Dell on 2018/7/17.
 */
public class PushMsg extends BaseMsg {
	public PushMsg(String clientId) {
		super(clientId);
		setType(MessageType.MSG_PUSH);
	}

	private PushParams data;

	public PushParams getData() {
		return data;
	}

	public void setData(PushParams data) {
		this.data = data;
	}
}


