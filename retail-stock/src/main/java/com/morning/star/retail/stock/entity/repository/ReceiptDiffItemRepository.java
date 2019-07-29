package com.morning.star.retail.stock.entity.repository;


import java.util.List;

import org.springframework.data.repository.Repository;

import com.morning.star.retail.stock.entity.ReceiptDiffItemEntity;

public interface ReceiptDiffItemRepository extends Repository<ReceiptDiffItemEntity, Long> {


	void save(ReceiptDiffItemEntity entity);

    ReceiptDiffItemEntity findOne(Long id);

    List<ReceiptDiffItemEntity> findAllByReceiptDiffCode(String receiptDifferenceCode);

    void delete(Long id);

}
