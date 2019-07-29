package com.retail.push.msg.api;

import com.retail.push.msg.api.dto.PushUserAddDTO;
import com.retail.push.msg.api.info.PushParams;

public interface BindingEquipmentFacade {

	void loginBinding(PushUserAddDTO dto);

	void pushMsgByStore(String storeCode, PushParams msg);

	void pushMsg(Long uin, PushParams msg);

	void pushMsgNoLogin(PushParams msg);

}
