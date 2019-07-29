package com.morning.star.retail.stock.facade.assembler;

import java.util.ArrayList;
import java.util.List;

import com.morning.star.retail.facade.dto.replenish.ReplenishItemDTO;
import com.morning.star.retail.stock.entity.ReplenishItemEntity;
import com.morning.star.retail.utils.entity.BeanUtils;

public class ReplenishItemDTOAssembler {

	public ReplenishItemDTO toDTO(ReplenishItemEntity entity) {
		ReplenishItemDTO dto = new ReplenishItemDTO();
		BeanUtils.copy(entity, dto);
		return dto;
	}

	public List<ReplenishItemDTO> toDTO(List<ReplenishItemEntity> entitys) {
		List<ReplenishItemDTO> dtos = new ArrayList<>(entitys.size());
		entitys.forEach(e -> dtos.add(toDTO(e)));
		return dtos;
	}

}
