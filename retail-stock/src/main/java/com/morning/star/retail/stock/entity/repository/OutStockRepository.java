package com.morning.star.retail.stock.entity.repository;


import com.morning.star.retail.stock.entity.OutStockEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OutStockRepository extends JpaRepository<OutStockEntity, String> {


}
