package com.morning.star.retail.order.dao;

import com.morning.star.retail.order.domain.entity.BusOrderStatisticsEntity;
import com.morning.star.retail.order.facade.dto.BusTopItemsDTO;

import java.util.Date;
import java.util.List;

/**
 * @Description TODO
 * @Author LiquorSea
 * @Date 2019/3/26 14:30
 **/
public interface BusOrderStatisticsDAO {
    BusOrderStatisticsEntity statisticsOrder(Date date);

    Integer statisticOrderStatus(Integer statusCode);

    List<BusTopItemsDTO> getBusTopItems();

    Integer getNoDealAfterSalesNum();
}
