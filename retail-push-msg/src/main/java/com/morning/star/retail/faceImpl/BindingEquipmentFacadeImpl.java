package com.morning.star.retail.faceImpl;

import com.morning.star.retail.kingdee.service.EquipmentService;
import com.retail.push.msg.api.BindingEquipmentFacade;
import com.retail.push.msg.api.dto.PushUserAddDTO;
import com.retail.push.msg.api.info.PushParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BindingEquipmentFacadeImpl implements BindingEquipmentFacade {

	@Autowired
	private EquipmentService equipmentService;

	@Override
	public void loginBinding(PushUserAddDTO dto) {
		equipmentService.loginBinding(dto);
	}

	@Override
	public void pushMsgByStore(String storeCode, PushParams msg) {
		equipmentService.pushMsgByStore(storeCode, msg);
	}

	@Override
	public void pushMsg(Long uin, PushParams msg) {
		equipmentService.pushMsg(uin, msg);
	}

	@Override
	public void pushMsgNoLogin(PushParams msg) {
		equipmentService.pushMsgNoLogin(msg);
	}
}
