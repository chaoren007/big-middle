package com.retail.push.msg.api.info;


import com.retail.push.msg.api.enums.MessageType;
import com.retail.push.msg.api.info.BaseMsg;

/**
 * Created by Dell on 2018/7/17.
 */
public class ConnectFailMsg extends BaseMsg {
	private String failMsg;

	public String getFailMsg() {
		return failMsg;
	}

	public void setFailMsg(String failMsg) {
		this.failMsg = failMsg;
	}

	public ConnectFailMsg(String clientId, String failMsg) {
		super(clientId);
		setType(MessageType.CONNECT_FAIL);
		setFailMsg(failMsg);
	}
}