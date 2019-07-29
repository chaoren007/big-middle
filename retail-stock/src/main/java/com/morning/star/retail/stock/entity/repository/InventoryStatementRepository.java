package com.morning.star.retail.stock.entity.repository;

import java.util.List;

import org.springframework.data.repository.Repository;

import com.morning.star.retail.stock.entity.InventoryStatementEntity;

public interface InventoryStatementRepository extends Repository<InventoryStatementEntity, String> {

    void save(InventoryStatementEntity entity);

    InventoryStatementEntity getByStatementCode(String statementCode);

    InventoryStatementEntity getByInventoryCodeAndType(String inventoryCode, Integer type);

    List<InventoryStatementEntity> getByInventoryCode(String inventoryCode);

}
