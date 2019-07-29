package com.morning.star.retail.stock.entity.repository;


import com.morning.star.retail.stock.entity.PurchaseInOrderDetailEntity;
import com.morning.star.retail.stock.entity.PurchaseOrderDetailEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PurchaseInOrderDetailRepository extends JpaRepository<PurchaseInOrderDetailEntity, Long> {

	PurchaseInOrderDetailEntity findByPurchaseInCodeAndProductCode(String purchaseInCode, String productCode);

	PurchaseInOrderDetailEntity findByPurchaseInCodeAndGoodsCode(String purchaseInCode, String goodsCode);
}
