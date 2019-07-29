package com.morning.star.retail.order.domain.entity.repository;

import com.morning.star.retail.order.domain.entity.BusOrderStatisticsEntity;
import org.springframework.data.repository.Repository;

import java.util.Date;
import java.util.List;

public interface BusOrderStatisticsRepository extends Repository<BusOrderStatisticsEntity, Long> {
   void save(BusOrderStatisticsEntity entity);

   List<BusOrderStatisticsEntity> getByDateBetween(Date starTime, Date endTime);

    BusOrderStatisticsEntity getByDate(Date date);

}
