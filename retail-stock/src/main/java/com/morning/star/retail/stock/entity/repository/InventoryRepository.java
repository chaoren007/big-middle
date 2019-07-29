package com.morning.star.retail.stock.entity.repository;

import org.springframework.data.repository.Repository;

import com.morning.star.retail.stock.entity.InventoryEntity;

public interface InventoryRepository extends Repository<InventoryEntity, String> {

    void save(InventoryEntity entity);

    InventoryEntity getByInventoryCode(String inventoryCode);

}
