package com.morning.star.retail.facade.assembler;


import com.morning.star.retail.entity.GoodsEntity;
import com.morning.star.retail.facade.dto.GoodsDTO;
import com.morning.star.retail.utils.entity.BeanUtils;

public class GoodsDTOAssembler {

	public GoodsDTO toDTO(GoodsEntity entity) {
		if(entity == null) {
			return null;
		}
		GoodsDTO dto = new GoodsDTO();
		BeanUtils.copy(entity.getProductInfo(), dto);
		dto.setGoodsCode(entity.getGoodsCode());
		dto.setGoodsName(entity.getGoodsName());
		dto.setStoreCode(entity.getStoreCode());
		dto.setStoreName(entity.getStoreName());
		dto.setSaleStatus(entity.getSaleStatus().getCode());
//		dto.setSalePrice(entity.getSalePrice());
		return dto;
	}

}
