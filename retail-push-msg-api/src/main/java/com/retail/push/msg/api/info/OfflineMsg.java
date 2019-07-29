package com.retail.push.msg.api.info;


import com.retail.push.msg.api.enums.MessageType;

/**
 * Created by Dell on 2018/7/17.
 */
public class OfflineMsg extends BaseMsg {
	public OfflineMsg(String clientId) {
		super(clientId);
		setType(MessageType.OFF_LINE);
	}
}


