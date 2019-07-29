package com.morning.star.retail.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

import com.morning.star.retail.order.domain.entity.SalesOrderEntity;

public interface OrderRepository extends JpaRepository<SalesOrderEntity, String> {

    SalesOrderEntity save(SalesOrderEntity salesOrderEntity);

    Page<SalesOrderEntity> findAll(Specification specification, Pageable pageable);

    SalesOrderEntity getByOrderCode(String orderCode);
}
