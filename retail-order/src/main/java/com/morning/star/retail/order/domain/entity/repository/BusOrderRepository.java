package com.morning.star.retail.order.domain.entity.repository;

import com.morning.star.retail.order.domain.entity.BusOrderEntity;
import org.springframework.data.repository.Repository;

public interface BusOrderRepository extends Repository<BusOrderEntity, Long> {
    BusOrderEntity save(BusOrderEntity entity);
    BusOrderEntity  getByOrderNo(String orderNo);
}
