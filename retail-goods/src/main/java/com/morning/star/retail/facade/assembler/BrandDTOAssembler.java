package com.morning.star.retail.facade.assembler;

import com.morning.star.retail.entity.BrandEntity;
import com.morning.star.retail.facade.dto.BrandDTO;
import com.morning.star.retail.utils.entity.BeanUtils;

public class BrandDTOAssembler {

	public BrandDTO toDTO(BrandEntity entity) {
		BrandDTO dto = new BrandDTO();
		BeanUtils.copy(entity, dto);

		return dto;
	}

}
