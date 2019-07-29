package com.morning.star.retail.kingdee.service;

import com.retail.push.msg.api.dto.EquipmentDTO;
import com.retail.push.msg.api.dto.PushUserAddDTO;
import com.retail.push.msg.api.info.PushParams;

import java.util.List;
import java.util.Set;

/**
 * Created by Dell on 2018/7/17.
 */
public interface EquipmentService {

	List<EquipmentDTO> getEquipmentId(String storeCode);

	void loginBinding(PushUserAddDTO dto);

	void removeByEquipmentId(String equipmentId);

	void closeByEquipmentId(String equipmentId);

	void activeByEquipmentId(String equipmentId);

	void pushMsgByStore(String storeCode, PushParams msg);

	void pushMsg(Long uin, PushParams msg);

	void pushMsgNoLogin(PushParams msg);
}
