package com.morning.star.retail.facade.assembler;

import com.morning.star.retail.entity.ProductEntity;
import com.morning.star.retail.facade.dto.ProductDTO;
import com.morning.star.retail.utils.entity.BeanUtils;

public class ProductDTOAssembler {

	public ProductDTO toDTO(ProductEntity entity) {
		if(entity == null) {
			return null;
		}
		ProductDTO dto = new ProductDTO();
		BeanUtils.copy(entity, dto);
		return dto;
	}

}
