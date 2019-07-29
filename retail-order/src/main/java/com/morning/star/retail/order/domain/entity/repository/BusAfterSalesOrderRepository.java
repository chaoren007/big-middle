package com.morning.star.retail.order.domain.entity.repository;

import com.morning.star.retail.order.domain.entity.BusAfterSalesOrderEntity;
import org.springframework.data.repository.Repository;

public interface BusAfterSalesOrderRepository extends Repository<BusAfterSalesOrderEntity, Long> {
    BusAfterSalesOrderEntity getByAfterSalesCode(String afterSalesCode);

    void save(BusAfterSalesOrderEntity byAfterSalesCode);
}
