package com.morning.star.retail.stock.entity.repository;


import org.springframework.data.repository.Repository;

import com.morning.star.retail.stock.entity.ReceiptDiffEntity;

public interface ReceiptDiffRepository extends Repository<ReceiptDiffEntity, String> {
	void save(ReceiptDiffEntity entity);

	ReceiptDiffEntity findOne(String code);

    boolean exists(String code);


}
