package com.morning.star.retail.stock.entity.repository;

import java.util.List;

import org.springframework.data.repository.Repository;

import com.morning.star.retail.stock.entity.InventoryStatementItemEntity;

public interface InventoryStatementItemRepository extends Repository<InventoryStatementItemEntity, Long> {

    void save(InventoryStatementItemEntity entity);

    InventoryStatementItemEntity getByStatementCodeAndGoodsCode(String statementCode, String productCode);

    List<InventoryStatementItemEntity> getByStatementCode(String statementCode);

}
