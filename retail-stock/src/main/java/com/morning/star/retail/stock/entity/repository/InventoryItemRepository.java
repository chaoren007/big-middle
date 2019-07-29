package com.morning.star.retail.stock.entity.repository;

import java.util.List;

import org.springframework.data.repository.Repository;

import com.morning.star.retail.stock.entity.InventoryItemEntity;

public interface InventoryItemRepository extends Repository<InventoryItemEntity, Long> {

    InventoryItemEntity save(InventoryItemEntity entity);

    List<InventoryItemEntity> getByInventoryCode(String inventoryCode);

    InventoryItemEntity getByInventoryCodeAndGoodsCode(String inventoryCode, String goodsCode);

}
