package com.morning.star.retail.facade.assembler;

import com.morning.star.retail.facade.dto.BusGoodsDTO;
import com.morning.star.retail.facade.dto.supply.GoodsSupplyDTO;
import com.morning.star.retail.utils.entity.BeanUtils;

public class BusGoodsAssembler {

	public static BusGoodsDTO builder(GoodsSupplyDTO dto) {
		if (dto == null) {
			return null;
		}
		BusGoodsDTO busGoodsDTO = new BusGoodsDTO();
		BeanUtils.copy(dto, busGoodsDTO);
		return busGoodsDTO;
	}
}
