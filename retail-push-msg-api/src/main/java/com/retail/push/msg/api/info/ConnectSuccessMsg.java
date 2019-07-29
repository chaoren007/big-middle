package com.retail.push.msg.api.info;


import com.retail.push.msg.api.enums.MessageType;
import com.retail.push.msg.api.info.BaseMsg;

/**
 * Created by Dell on 2018/7/17.
 */
public class ConnectSuccessMsg extends BaseMsg {
	public ConnectSuccessMsg(String clientId) {
		super(clientId);
		setType(MessageType.CONNECT_SUCCESS);
	}
}