package com.morning.star.retail.stock.facade.assembler;

import com.morning.star.retail.facade.dto.replenish.ReplenishDTO;
import com.morning.star.retail.stock.entity.ReplenishEntity;
import com.morning.star.retail.utils.entity.BeanUtils;

public class ReplenishDTOAssembler {

	public ReplenishDTO toDTO(ReplenishEntity entity) {
		ReplenishDTO dto = new ReplenishDTO();
		BeanUtils.copy(entity, dto);
		dto.setStatusName(entity.getStatus().getDesc());
		return dto;
	}

}
