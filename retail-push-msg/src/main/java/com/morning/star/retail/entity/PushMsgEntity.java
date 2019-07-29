package com.morning.star.retail.entity;

import com.morning.star.retail.enums.PushMsgStatus;
import com.morning.star.retail.enums.PushMsgType;
import org.hibernate.annotations.Where;

import javax.persistence.*;

@Entity
@Table(name = "t_push_msg")
@Where(clause = "delete_flag <> 1")
public class PushMsgEntity extends BaseEntity {

	@Id
	@Column(length = 64, unique = true, updatable = false)
	@Comment("推送消息编码")
	private String msgCode;

	@Comment(value = "用户ID")
	private Long uin;

	@Comment(value = "链接推送ID")
	private String equipmentId;

	private String msg;

	@Convert(converter = PushMsgType.Convert.class)
	private PushMsgType pushType = PushMsgType.NORMAL;

	@Convert(converter = PushMsgStatus.Convert.class)
	private PushMsgStatus status = PushMsgStatus.INIT;

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

	public PushMsgType getPushType() {
		return pushType;
	}

	public void setPushType(PushMsgType pushType) {
		this.pushType = pushType;
	}

	public PushMsgStatus getStatus() {
		return status;
	}

	public void setStatus(PushMsgStatus status) {
		this.status = status;
	}
}
