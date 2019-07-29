package com.morning.star.retail.stock.entity.repository;


import org.springframework.data.repository.Repository;

import com.morning.star.retail.stock.entity.PurchaseOrderEntity;

public interface PurchaseOrderRepository extends Repository<PurchaseOrderEntity, Long> {

	PurchaseOrderEntity save(PurchaseOrderEntity purchaseOrderEntity);

	PurchaseOrderEntity getByPurchaseCode(String purchaseCode);

	PurchaseOrderEntity getByPurchaseCodeAndStoreCode(String purchaseCode, String storeCode);

	Boolean existsByPurchaseCode(String purchaseCode);

}
