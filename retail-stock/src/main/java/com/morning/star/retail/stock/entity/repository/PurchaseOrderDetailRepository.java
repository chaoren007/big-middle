package com.morning.star.retail.stock.entity.repository;


import java.util.List;

import org.springframework.data.repository.Repository;

import com.morning.star.retail.stock.entity.PurchaseOrderDetailEntity;

public interface PurchaseOrderDetailRepository extends Repository<PurchaseOrderDetailEntity, Long> {

	PurchaseOrderDetailEntity save(PurchaseOrderDetailEntity purchaseOrderDetailEntity);

	List<PurchaseOrderDetailEntity> getByPurchaseCode(String purchaseCode);

	void deleteByPurchaseCode(String purchaseCode);

}
