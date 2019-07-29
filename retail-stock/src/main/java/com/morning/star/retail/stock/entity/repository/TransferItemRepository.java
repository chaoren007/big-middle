package com.morning.star.retail.stock.entity.repository;


import java.util.List;

import org.springframework.data.repository.Repository;

import com.morning.star.retail.stock.entity.TransferItemEntity;

public interface TransferItemRepository extends Repository<TransferItemEntity, Long> {

    TransferItemEntity save(TransferItemEntity entity);

    TransferItemEntity getByTransferCodeAndGoodsCode(String transferCode, String goodsCode);

    List<TransferItemEntity> getByTransferCode(String transferCode);

    void deleteByTransferCode(String transferCode);
}
