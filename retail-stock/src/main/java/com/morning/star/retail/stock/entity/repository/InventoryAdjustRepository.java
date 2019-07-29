package com.morning.star.retail.stock.entity.repository;

import java.util.List;

import org.springframework.data.repository.Repository;

import com.morning.star.retail.stock.entity.InventoryAdjustEntity;

public interface InventoryAdjustRepository extends Repository<InventoryAdjustEntity, Long> {

    void save(InventoryAdjustEntity entity);

    List<InventoryAdjustEntity> getByInventoryCodeAndGoodsCodeOrderByCreateTimeDesc(String inventoryCode, String goodsCode);

}
