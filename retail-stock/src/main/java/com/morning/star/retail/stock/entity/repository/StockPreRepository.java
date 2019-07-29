package com.morning.star.retail.stock.entity.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import com.morning.star.retail.stock.entity.StockPreEntity;

public interface StockPreRepository extends Repository<StockPreEntity, Long> {

    void save(StockPreEntity entity);

    @Modifying
    @Query(value = "update StockPreEntity set status = :status where orderCode = :orderCode")
    void modifyStatus(@Param("status") Integer status, @Param("orderCode") String orderCode);

}
