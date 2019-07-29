package com.retail.push.msg.api.enums;

/**
 * @author ethan
 * @create_time 2018/9/20 14:22
 */
public enum MessageType {
	CONNECT_REQ((byte) 1),
	CONNECT_SUCCESS((byte) 2),
	CONNECT_FAIL((byte) 3),
	HEARTBEAT_REQ((byte) 4),
	HEARTBEAT_RESP((byte) 5),
	MSG_PUSH((byte) 6),
	MSG_PUSH_ASK((byte) 7),
	OFF_LINE((byte) 8);

	private byte value;

	MessageType(byte value) {
		this.value = value;
	}

	public byte getValue() {
		return value;
	}

	public void setValue(byte value) {
		this.value = value;
	}
}
