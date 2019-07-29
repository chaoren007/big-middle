package com.morning.star.retail.facade.assembler;


import com.morning.star.retail.entity.UnitsEntity;
import com.morning.star.retail.facade.dto.UnitsDTO;
import com.morning.star.retail.utils.entity.BeanUtils;

public class UnitsDTOAssembler {

	public UnitsDTO toDTO(UnitsEntity entity) {
		UnitsDTO dto = new UnitsDTO();
		BeanUtils.copy(entity, dto);
		return dto;
	}

}
