package com.morning.star.retail.facade.impl;

import com.morning.star.retail.entity.ThirdServiceEntity;
import com.morning.star.retail.entity.enums.RequestTagEnum;
import com.morning.star.retail.entity.enums.RequestTypeEnum;
import com.morning.star.retail.entity.repository.ThirdServiceFailRepository;
import com.morning.star.retail.entity.repository.ThirdServiceRepository;
import com.morning.star.retail.facade.ThirdServiceFacade;
import com.morning.star.retail.facade.dto.ThirdServiceDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ThirdServiceFacadeImpl implements ThirdServiceFacade {
	@Autowired
	private ThirdServiceRepository thirdServiceRepository;

	@Autowired
	ThirdServiceFailRepository thirdServiceFailRepository;

	@Override
	public void save(ThirdServiceDTO dto) {
		ThirdServiceEntity entity = new ThirdServiceEntity(dto.getRequestApi(), dto.getRequestParam(), RequestTagEnum.WMS_CREATE_CATEGORY, RequestTypeEnum.WMS_RETURN);
		thirdServiceRepository.save(entity);
	}
}
