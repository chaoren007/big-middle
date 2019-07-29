package com.morning.star.retail.kingdee.service.impl;

import com.alibaba.fastjson.JSON;
import com.morning.star.retail.dao.PushMsgRepository;
import com.morning.star.retail.entity.PushMsgEntity;
import com.morning.star.retail.enums.PushMsgStatus;
import com.morning.star.retail.enums.PushMsgType;
import com.morning.star.retail.helper.AccountService;
import com.morning.star.retail.helper.info.AccountInfo;
import com.morning.star.retail.kingdee.service.PushMsgService;
import com.morning.star.retail.util.UniqueNoUtils;
import com.retail.push.msg.api.dto.PushMsgDTO;
import com.retail.push.msg.api.info.PushParams;
import org.apache.commons.lang.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author ethan
 * @create_time 2018/9/21 14:42
 */
@Service
@Transactional
public class PushMsgServiceImpl implements PushMsgService {
	@Autowired
	private PushMsgRepository pushMsgRepository;

	@Autowired
	private AccountService accountService;

	@Override
	public PushMsgDTO add(Long uin, PushParams msg) {
		PushMsgEntity entity = new PushMsgEntity();
		String msgCode = UniqueNoUtils.next(UniqueNoUtils.UniqueNoType.PMC);
		entity.setMsgCode(msgCode);
		entity.setMsg(JSON.toJSONString(msg));
		entity.setUin(uin);

		PushMsgType msgType = PushMsgType.getByCode(msg.getMsgType());
		Validate.notNull(msgType, "消息类型错误：" + msg.getMsgType());
		entity.setPushType(msgType);
		pushMsgRepository.save(entity);

		return new PushMsgDTO(msgCode, uin, null, JSON.toJSONString(msg));
	}

	@Override
	public List<PushMsgDTO> addByStore(String storeCode, PushParams msg) {
		List<AccountInfo> accountInfoList = accountService.getByStore(storeCode);
		return accountInfoList.stream().map(accountInfo -> add(accountInfo.getId(), msg)).collect(Collectors.toList());
	}

	@Override
	public List<PushMsgDTO> getUserMsg(Long uin, PushMsgStatus status) {
		List<PushMsgEntity> entityList = pushMsgRepository.getByUinAndStatus(uin, status);
		return entityList.stream()
			.map(entity -> new PushMsgDTO(entity.getMsgCode(), entity.getUin(), entity.getEquipmentId(), entity.getMsg()))
			.collect(Collectors.toList());
	}

	@Override
	public void updateStatus(String code, PushMsgStatus status) {
		if (status == null) return;
		PushMsgEntity entity = pushMsgRepository.findOne(code);
		if (entity != null) {
			entity.setStatus(status);
			pushMsgRepository.save(entity);
		}
	}

	@Override
	public void successMsg(String code, String clientId) {
		PushMsgEntity entity = pushMsgRepository.findOne(code);
		if (entity != null) {
			entity.setStatus(PushMsgStatus.SUCCESS);
			entity.setEquipmentId(clientId);
			pushMsgRepository.save(entity);
		}
	}
}
