package com.morning.star.retail.facade.impl;

import com.morning.star.retail.entity.GoodsSupplySetEntity;
import com.morning.star.retail.entity.GoodsSupplySetWaterEntity;
import com.morning.star.retail.entity.repository.GoodsSupplySetRepository;
import com.morning.star.retail.entity.repository.GoodsSupplySetWaterRepository;
import com.morning.star.retail.facade.GoodsSupplySetFacade;
import com.morning.star.retail.facade.dto.supply.GoodsSupplySetDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ethan
 * @create_time 2019/3/13 15:54
 */
@Service
public class GoodsSupplySetFacadeImpl implements GoodsSupplySetFacade {
	@Autowired
	private GoodsSupplySetRepository goodsSupplySetRepository;
	@Autowired
	private GoodsSupplySetWaterRepository goodsSupplySetWaterRepository;

	@Override
	public GoodsSupplySetDTO get(String productCode, Long cityId) {
		GoodsSupplySetEntity entity = goodsSupplySetRepository.findByProductCodeAndCityId(productCode, cityId);
		return GoodsSupplySetEntity.toDTO(entity);
	}

	@Override
	public GoodsSupplySetDTO getLog(String productCode, String versionCode, Long cityId) {
		GoodsSupplySetWaterEntity entity = goodsSupplySetWaterRepository.findFirstByProductCodeAndVersionCodeAndCityIdOrderByOperateTimeDesc(productCode, versionCode, cityId);
		return GoodsSupplySetWaterEntity.toDTO(entity);
	}
}
