package com.morning.star.retail.order.domain.entity.repository;

import com.morning.star.retail.order.domain.entity.BusOrderDetailEntity;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface BusOrderDetailRepository extends Repository<BusOrderDetailEntity, Long> {
    BusOrderDetailEntity save(BusOrderDetailEntity entity);

    List<BusOrderDetailEntity>  getByDealWith(Integer dealWith);

    BusOrderDetailEntity getById(Long id);
}
