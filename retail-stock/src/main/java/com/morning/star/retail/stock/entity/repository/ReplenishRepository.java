package com.morning.star.retail.stock.entity.repository;


import java.util.List;

import org.springframework.data.repository.Repository;

import com.morning.star.retail.stock.entity.ReplenishEntity;
import com.morning.star.retail.stock.enums.ReplenishStatus;

public interface ReplenishRepository extends Repository<ReplenishEntity, Long> {

	ReplenishEntity save(ReplenishEntity replenishEntity);

	ReplenishEntity findOne(Long id);

	ReplenishEntity getByReplenishCodeAndStatus(String replenishCode, ReplenishStatus status);

	ReplenishEntity getByReplenishCode(String replenishCode);

	ReplenishEntity getByReplenishCodeAndStoreCode(String replenishCode, String storeCode);

	List<ReplenishEntity> getByStoreCode(String storeCode);

}
