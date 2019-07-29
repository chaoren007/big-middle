package com.morning.star.retail.application.impl;

import com.morning.star.retail.application.StoreApplication;
import com.morning.star.retail.dao.StoreDAO;
import com.morning.star.retail.dto.store.StoreCreateDTO;
import com.morning.star.retail.dto.store.StoreModifyDTO;
import com.morning.star.retail.entity.GroupEntity;
import com.morning.star.retail.entity.StoreEntity;
import com.morning.star.retail.entity.StoreEntityWater;
import com.morning.star.retail.entity.repository.GroupRepository;
import com.morning.star.retail.entity.repository.StoreRepository;
import com.morning.star.retail.entity.repository.WaterRepository;
import com.morning.star.retail.enums.IsFreeEnum;
import com.morning.star.retail.facade.AddressFacade;
import com.morning.star.retail.facade.dto.StoreWmsDTO;
import com.morning.star.retail.user.UserInfo;
import com.morning.star.retail.user.UserPermission;
import com.morning.star.retail.user.UserUtils;
import com.morning.star.retail.utils.entity.BeanUtils;
import com.morning.star.retail.utils.mq.WmsStorePullQueue;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class StoreApplicationImpl implements StoreApplication {

	@Autowired
	private StoreDAO storeDAO;
	@Autowired
	private StoreRepository storeRepository;
	@Autowired
	private GroupRepository groupRepository;
	@Autowired
	private AddressFacade addressFacade;
	@Autowired
	private WaterRepository waterRepository;
	@Autowired
	private WmsStorePullQueue wmsStorePullQueue;


	@Override
	@Transactional
	public void addStore(StoreCreateDTO dto) {
		// 校验门店信息
		Validate.notEmpty(dto.getStoreCode(), "门店编码不能为空");
		Validate.notEmpty(dto.getStoreName(), "门店名称不能为空");
		Validate.notEmpty(dto.getAddress(), "门店地址不能为空");
		Validate.notEmpty(dto.getGroupCode(), "集团编码不能为空");
//		Validate.notEmpty(dto.getVcontainerCode(), "大柜组编码不能为空");

		Validate.notNull(dto.getProvinceId(), "省份不能为空");
		Validate.notNull(dto.getCityId(), "城市不能为空");
		Validate.notNull(dto.getCountyId(), "区/县不能为空");

		Validate.isTrue(!storeRepository.exists(dto.getStoreCode()),
			"该门店编码已存在：" + dto.getStoreCode());
		Validate.isTrue(!storeRepository.existsByStoreNameAndGroupCode(dto.getStoreName(), dto.getGroupCode()),
			"该门店名称已存在" + dto.getStoreName());

		GroupEntity groupEntity = groupRepository.getByGroupCode(dto.getGroupCode());
		Validate.notNull(groupEntity, "集团信息不存在：" + dto.getGroupCode());

		Validate.isTrue(!storeRepository.existsByGroupCodeAndCityId(dto.getGroupCode(), dto.getCityId()),
			"该城市下面已有门店");

		StoreEntity entity = new StoreEntity();
		BeanUtils.copy(dto, entity);
		entity.setProvinceName(addressFacade.getAddressById(dto.getProvinceId()).getAddressName());
		entity.setCityName(addressFacade.getAddressById(dto.getCityId()).getAddressName());
		entity.setCountyName(addressFacade.getAddressById(dto.getCountyId()).getAddressName());

		UserInfo userInfo = UserUtils.currentUser();
		entity.setCreator(userInfo.getId().toString());
		entity.setCreatorName(userInfo.getName());

		entity.setGroupCode(groupEntity.getGroupCode());
		entity.setGroupName(groupEntity.getGroupName());

		storeRepository.save(entity);

		waterRepository.save(entity, StoreEntityWater.class, "创建门店");

		//推送分公司信息到wms
		StoreWmsDTO storeWmsDTO = StoreEntity.toWmsDTO(entity);
		wmsStorePullQueue.send(storeWmsDTO);
	}


	@Override
	public void modifyStore(StoreModifyDTO storeDO) {
		StoreEntity entity = storeRepository.findOne(storeDO.getStoreCode());
		Validate.notNull(entity, "未找到该门店信息");

		new UserPermission(UserUtils.currentUser())
			.tag("groupCode", entity.getGroupCode())
			.pass();

//		if (storeDO.getStoreName() != null && !entity.getStoreName().equals(storeDO.getStoreName())) {
//			Validate.isTrue(!storeRepository.existsByStoreName(storeDO.getStoreName()), "该门店名称【" + storeDO.getStoreName() + "】已被其他门店使用");
//		}
//		if (StringUtils.isNotEmpty(storeDO.getStoreName())) {
//			entity.setStoreName(storeDO.getStoreName());
//		}
		if (StringUtils.isNotEmpty(storeDO.getAccessIds())) {
			entity.setAccessIds(storeDO.getAccessIds());
		}
		if (StringUtils.isNotEmpty(storeDO.getAddress())) {
			entity.setAddress(storeDO.getAddress());
		}
		if (storeDO.getProvinceId() != null) {
			entity.setProvinceId(storeDO.getProvinceId());
			entity.setProvinceName(addressFacade.getAddressById(storeDO.getProvinceId()).getAddressName());
		}
		if (storeDO.getCityId() != null && !storeDO.getCityId().equals(entity.getCityId())) {
			Validate.isTrue(!storeRepository.existsByGroupCodeAndCityId(entity.getGroupCode(), storeDO.getCityId()),
				"该城市下面已有门店");
			entity.setCityId(storeDO.getCityId());
			entity.setCityName(addressFacade.getAddressById(storeDO.getCityId()).getAddressName());

		}
		if (storeDO.getCountyId() != null) {
			entity.setCountyId(storeDO.getCountyId());
			entity.setCountyName(addressFacade.getAddressById(storeDO.getCountyId()).getAddressName());
		}
		storeRepository.save(entity);

		waterRepository.save(entity, StoreEntityWater.class, "修改门店");
	}

	@Override
	public void freezeStore(String storeCode) {
		StoreEntity entity = storeRepository.findOne(storeCode);
		entity.setIsFree(IsFreeEnum.FREEZE.getCode());
		storeRepository.save(entity);

		waterRepository.save(entity, StoreEntityWater.class, "冻结门店");
	}

	@Override
	public void unfreezeStore(String storeCode) {
		StoreEntity entity = storeRepository.findOne(storeCode);
		entity.setIsFree(IsFreeEnum.NORMAL.getCode());
		storeRepository.save(entity);

		waterRepository.save(entity, StoreEntityWater.class, "解冻门店");
	}

	@Override
	public String getCode() {
		return storeDAO.getCode();
	}

}
