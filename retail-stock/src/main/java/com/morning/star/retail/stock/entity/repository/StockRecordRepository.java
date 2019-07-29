package com.morning.star.retail.stock.entity.repository;

import com.morning.star.retail.stock.entity.StockRecordEntity;
import org.springframework.data.repository.Repository;

public interface StockRecordRepository extends Repository<StockRecordEntity, Long> {

    void save(StockRecordEntity entity);

    int countByOrderCodeAndTypeAndWarehouseCode(String orderCode, String type, String warehouseCode);

}
