package com.morning.star.retail.entity.repository;


import com.morning.star.retail.entity.GoodsSupplySetWaterEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GoodsSupplySetWaterRepository extends JpaRepository<GoodsSupplySetWaterEntity, Long> {
	GoodsSupplySetWaterEntity findFirstByProductCodeAndVersionCodeAndCityIdOrderByOperateTimeDesc(String productCode, String versionCode, Long cityId);
}
