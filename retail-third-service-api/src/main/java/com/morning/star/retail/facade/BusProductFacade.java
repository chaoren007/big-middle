package com.morning.star.retail.facade;

import com.morning.star.retail.facade.dto.BusProductDTO;
import com.morning.star.retail.facade.dto.BusResultDTO;

/**
 * RPC调用运营端
 */
public interface BusProductFacade {

	/**
	 * 创建运营点
	 * @param dto
	 */
	void add(BusProductDTO dto);
}
