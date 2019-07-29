package com.morning.star.retail.facade;

import com.morning.star.retail.facade.dto.BusOpcDTO;
import com.morning.star.retail.facade.dto.BusResultDTO;

/**
 * RPC调用运营端
 */
public interface BusOpcFacade {

	/**
	 * 创建运营点
	 * @param dto
	 */
	BusResultDTO add(BusOpcDTO dto);
}
