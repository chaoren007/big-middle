package com.morning.star.retail.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.morning.star.retail.order.domain.entity.SalesOrderItemEntity;

public interface OrderGoodsRepository extends JpaRepository<SalesOrderItemEntity, Long> {

    //@Query(value = "select t from order_items_info t where t.order_code =: orderCode")
    //List<SalesOrderItemEntity> findAllByOrderCode(@Param("orderCode") String orderCode);
}
