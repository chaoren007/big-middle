package com.morning.star.retail.stock.entity.repository;


import org.springframework.data.repository.Repository;

import com.morning.star.retail.stock.entity.TransferEntity;

public interface TransferRepository extends Repository<TransferEntity, Long> {

    TransferEntity save(TransferEntity entity);

    TransferEntity getByTransferCode(String transferCode);

    TransferEntity getByOutstockCode(String outstockCode);
}
