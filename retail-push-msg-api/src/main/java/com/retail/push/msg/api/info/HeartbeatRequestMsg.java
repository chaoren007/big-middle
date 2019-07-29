package com.retail.push.msg.api.info;


import com.retail.push.msg.api.enums.MessageType;
import com.retail.push.msg.api.info.BaseMsg;

/**
 * Created by Dell on 2018/7/17.
 */
public class HeartbeatRequestMsg extends BaseMsg {
	public HeartbeatRequestMsg(String clientId) {
		super(clientId);
		setType(MessageType.HEARTBEAT_REQ);
	}
}