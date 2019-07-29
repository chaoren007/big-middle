package com.morning.star.retail.stock.entity.repository;


import com.morning.star.retail.stock.entity.ReceiptEntity;
import com.morning.star.retail.stock.enums.ReceiptStatusEnum;
import org.springframework.data.repository.Repository;

public interface ReceiptRepository extends Repository<ReceiptEntity, String> {

    void save(ReceiptEntity entity);

    int countByTrackCodeAndStatus(String rackCode, ReceiptStatusEnum status);

    ReceiptEntity getReceiptEntityByReceiptCode(String receiptCode);

    ReceiptEntity findOne(String code);
}
