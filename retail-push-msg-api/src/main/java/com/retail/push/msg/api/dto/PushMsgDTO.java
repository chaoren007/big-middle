package com.retail.push.msg.api.dto;

import com.retail.push.msg.api.enums.MessageType;
import com.retail.push.msg.api.info.PushMsg;
import com.retail.push.msg.api.info.PushParams;

import java.io.Serializable;

public class PushMsgDTO implements Serializable {

	private static final long serialVersionUID = -4636639682550329810L;

	private String msgCode;

	private Long uin;

	private String equipmentId;

	private String msg;

	public PushMsgDTO(String msgCode, Long uin, String equipmentId, String msg) {
		this.msgCode = msgCode;
		this.uin = uin;
		this.equipmentId = equipmentId;
		this.msg = msg;
	}

	public PushMsg toPushMsg() {
		PushMsg pushMsg = new PushMsg(this.getEquipmentId());
		PushParams pushParams = new PushParams();
		pushParams.setMsgCode(this.getMsgCode());
		pushParams.setMsg(this.getMsg());
		pushMsg.setData(pushParams);
		return pushMsg;
	}

	public String getMsgCode() {
		return msgCode;
	}

	public void setMsgCode(String msgCode) {
		this.msgCode = msgCode;
	}

	public Long getUin() {
		return uin;
	}

	public void setUin(Long uin) {
		this.uin = uin;
	}

	public String getEquipmentId() {
		return equipmentId;
	}

	public void setEquipmentId(String equipmentId) {
		this.equipmentId = equipmentId;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
}
