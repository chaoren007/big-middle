package com.morning.star.retail.facade;

import com.morning.star.retail.facade.dto.BusGoodsDTO;
import com.morning.star.retail.facade.dto.BusGoodsOnOffDTO;

/**
 * RPC调用运营端
 */
public interface BusTransferFacade {

	void addGoods(BusGoodsDTO dto);

	void onOffGoods(BusGoodsOnOffDTO dto);
}
