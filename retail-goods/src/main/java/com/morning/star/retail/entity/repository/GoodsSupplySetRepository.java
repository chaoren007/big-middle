package com.morning.star.retail.entity.repository;


import com.morning.star.retail.entity.GoodsSupplySetEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GoodsSupplySetRepository extends JpaRepository<GoodsSupplySetEntity, Long> {
	void deleteByGoodsSupplyCode(String code);

	GoodsSupplySetEntity findByProductCodeAndCityId(String productCode, Long cityId);

	List<GoodsSupplySetEntity> findByGoodsSupplyCode(String code);
}
