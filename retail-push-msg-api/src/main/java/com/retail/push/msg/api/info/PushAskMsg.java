package com.retail.push.msg.api.info;


import com.retail.push.msg.api.enums.MessageType;

/**
 * Created by Dell on 2018/7/17.
 */
public class PushAskMsg extends BaseMsg {
	public PushAskMsg(String clientId) {
		super(clientId);
		setType(MessageType.MSG_PUSH_ASK);
	}

	public PushAskMsg(PushMsg pushMsg) {
		super(pushMsg.getClientId());
		PushParams pushParams = new PushParams();
		pushParams.setMsgCode(pushMsg.getData().getMsgCode());

		setType(MessageType.MSG_PUSH_ASK);
		setData(pushParams);
	}

	private PushParams data;

	public PushParams getData() {
		return data;
	}

	public void setData(PushParams data) {
		this.data = data;
	}
}


