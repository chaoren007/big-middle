package com.morning.star.retail.entity.repository;


import com.morning.star.retail.entity.GoodsSupplyWaterEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GoodsSupplyWaterRepository extends JpaRepository<GoodsSupplyWaterEntity, Long> {

	List<GoodsSupplyWaterEntity> findByProductCode(String code);

}
