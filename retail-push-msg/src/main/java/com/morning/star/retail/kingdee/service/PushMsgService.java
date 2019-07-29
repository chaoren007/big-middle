package com.morning.star.retail.kingdee.service;

import com.morning.star.retail.enums.PushMsgStatus;
import com.retail.push.msg.api.dto.PushMsgDTO;
import com.retail.push.msg.api.info.PushParams;

import java.util.List;

/**
 * Created by Dell on 2018/7/17.
 */
public interface PushMsgService {
	PushMsgDTO add(Long uin, PushParams msg);

	List<PushMsgDTO> addByStore(String storeCode, PushParams msg);

	List<PushMsgDTO> getUserMsg(Long uin, PushMsgStatus status);

	void updateStatus(String code, PushMsgStatus status);

	void successMsg(String code, String clientId);
}
