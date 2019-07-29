package com.morning.star.retail.facade;

import com.morning.star.retail.facade.dto.supply.GoodsSupplySetDTO;

public interface GoodsSupplySetFacade {

	/**
	 * 获取商品供货设置信息
	 *
	 * @param productCode 单品编码
	 * @param cityId      供货城市ID
	 */
	GoodsSupplySetDTO get(String productCode, Long cityId);


	/**
	 * 获取商品历史供货设置信息
	 */
	GoodsSupplySetDTO getLog(String productCode, String versionCode, Long cityId);

}

