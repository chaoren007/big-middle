package com.morning.star.retail.kingdee.service.impl;

import com.morning.star.retail.bean.AdminLoginContent;
import com.morning.star.retail.dao.EquipmentRepository;
import com.morning.star.retail.entity.EquipmentEntity;
import com.morning.star.retail.enums.DeleteFlagEnum;
import com.morning.star.retail.enums.EquipmentStatus;
import com.morning.star.retail.enums.EquipmentTypeEnum;
import com.morning.star.retail.kingdee.service.PushMsgService;
import com.morning.star.retail.netty.NettySendFactory;
import com.morning.star.retail.kingdee.service.EquipmentService;
import com.morning.star.retail.util.UserUtils;
import com.retail.push.msg.api.dto.EquipmentDTO;
import com.retail.push.msg.api.dto.PushMsgDTO;
import com.retail.push.msg.api.dto.PushUserAddDTO;
import com.retail.push.msg.api.enums.UserType;
import com.retail.push.msg.api.info.OfflineMsg;
import com.retail.push.msg.api.info.PushMsg;
import com.retail.push.msg.api.info.PushParams;
import org.apache.commons.lang.Validate;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by Dell on 2018/7/17.
 */
@Service
@Transactional
public class EquipmentServiceImpl implements EquipmentService {

	@Value("${netty.post}")
	private int port;

	@Autowired
	private EquipmentRepository equipmentRepository;

	@Autowired
	private NettySendFactory nettySendFactory;

	@Autowired
	private PushMsgService pushMsgService;

	@Override
	public List<EquipmentDTO> getEquipmentId(String storeCode) {
		List<EquipmentEntity> entities = equipmentRepository.getByStoreCode(storeCode);
		return entities.stream().map(entity -> {
			EquipmentDTO dto = new EquipmentDTO();
			BeanUtils.copyProperties(entity, dto);
			dto.setEquipmentType(entity.getEquipmentType().getCode());
			dto.setStatus(entity.getStatus().getCode());

			return dto;
		}).collect(Collectors.toList());
	}

	@Override
	public void loginBinding(PushUserAddDTO dto) {
		EquipmentEntity equipmentEntity = new EquipmentEntity();

		EquipmentTypeEnum equipmentType = EquipmentTypeEnum.getByCode(dto.getDeviceType());
		Validate.notNull(equipmentType, "设备类型错误：" + dto.getDeviceType());
		equipmentEntity.setEquipmentType(equipmentType);
		equipmentEntity.setUserType(dto.getUserType());

		if (dto.getUserType() == UserType.NO_LOGIN.getCode()) {
			equipmentEntity.setEquipmentId(dto.getDeviceId());
			equipmentEntity.setUin(0L);
		} else {
			AdminLoginContent userInfo = UserUtils.getUserInfo(dto.getToken());
			Validate.notNull(userInfo, "TOKEN失效");

			equipmentEntity.setEquipmentId(dto.getDeviceId());
			equipmentEntity.setToken(userInfo.getToken());
			equipmentEntity.setUin(userInfo.getId());
			equipmentEntity.setGroupCode(userInfo.getGroupCode());
			equipmentEntity.setStoreCode(userInfo.getStoreCode());
			equipmentEntity.setAccount(userInfo.getAccount());

		}
		List<EquipmentEntity> entityList = equipmentRepository.getByUinOrEquipmentId(equipmentEntity.getUin(), equipmentEntity.getEquipmentId());
		if (entityList != null) {
			entityList.forEach(entity -> entity.setDeleteFlag(DeleteFlagEnum.DELETE.getCode()));
			nettySendFactory.sendBaseMsg(
				entityList.stream()
					.map(entity -> new OfflineMsg(entity.getEquipmentId()))
					.collect(Collectors.toList())
			);
		}
		equipmentRepository.save(entityList);
		equipmentRepository.save(equipmentEntity);

	}

	@Override
	public void removeByEquipmentId(String equipmentId) {
		EquipmentEntity entity = equipmentRepository.getByEquipmentId(equipmentId);
		if (entity != null) {
			entity.setDeleteFlag(DeleteFlagEnum.DELETE.getCode());
			equipmentRepository.save(entity);
		}
	}

	@Override
	public void closeByEquipmentId(String equipmentId) {
		EquipmentEntity entity = equipmentRepository.getByEquipmentId(equipmentId);
		if (entity != null && entity.getStatus() != EquipmentStatus.CLOSE) {
			entity.setStatus(EquipmentStatus.CLOSE);
			equipmentRepository.save(entity);
		}
	}

	@Override
	public void activeByEquipmentId(String equipmentId) {
		EquipmentEntity entity = equipmentRepository.getByEquipmentId(equipmentId);
		if (entity != null && entity.getStatus() == EquipmentStatus.INIT) {
			entity.setStatus(EquipmentStatus.ACTIVE);
			equipmentRepository.save(entity);
		}
	}

	@Override
	public void pushMsgByStore(String storeCode, PushParams msg) {
		List<PushMsgDTO> pushMsgDTOS = pushMsgService.addByStore(storeCode, msg);
		Map<Long, PushMsgDTO> map = pushMsgDTOS.stream().collect(Collectors.toMap(PushMsgDTO::getUin, e -> e));

		List<EquipmentEntity> entityList = equipmentRepository.getByStoreCode(storeCode);
		if (entityList != null && entityList.size() > 0) {
			List<PushMsg> pushMsgList = entityList.stream().map(entity -> {
				PushMsg pushMsg = new PushMsg(entity.getEquipmentId());
				PushMsgDTO pushMsgDTO = map.getOrDefault(entity.getUin(), null);
				if (pushMsgDTO == null) {
					return null;
				} else {
					msg.setMsgCode(pushMsgDTO.getMsgCode());
					pushMsg.setData(msg);
					return pushMsg;
				}

			}).filter(e -> e != null).collect(Collectors.toList());
			nettySendFactory.sendMsg(pushMsgList);
		}

	}

	@Override
	public void pushMsg(Long uin, PushParams msg) {
		PushMsgDTO pushMsgDTO = pushMsgService.add(uin, msg);
		if (pushMsgDTO == null) return;
		List<EquipmentEntity> entityList = equipmentRepository.getByUin(uin);
		if (entityList != null && entityList.size() > 0) {
			List<PushMsg> pushMsgList = entityList.stream().map(entity -> {
				PushMsg pushMsg = new PushMsg(entity.getEquipmentId());
				msg.setMsgCode(pushMsgDTO.getMsgCode());
				pushMsg.setData(msg);
				return pushMsg;
			}).collect(Collectors.toList());
			nettySendFactory.sendMsg(pushMsgList);
		}
	}

	@Override
	public void pushMsgNoLogin(PushParams msg) {
		pushMsg(0L, msg);
	}
}
