package com.morning.star.retail.stock.entity.repository;


import com.morning.star.retail.stock.entity.PurchaseInOrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PurchaseInOrderRepository extends JpaRepository<PurchaseInOrderEntity, Long> {
	PurchaseInOrderEntity findByPurchaseInCode(String code);

	List<PurchaseInOrderEntity> getByPurchaseCode(String code);
}
