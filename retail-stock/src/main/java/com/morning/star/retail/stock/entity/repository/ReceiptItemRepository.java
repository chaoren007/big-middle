package com.morning.star.retail.stock.entity.repository;


import com.morning.star.retail.stock.entity.ReceiptItemEntity;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface ReceiptItemRepository extends Repository<ReceiptItemEntity, Long> {

    void save(ReceiptItemEntity entity);

    ReceiptItemEntity findOne(Long id);

    List<ReceiptItemEntity> findAllByReceiptCode(String receiptCode);

}
