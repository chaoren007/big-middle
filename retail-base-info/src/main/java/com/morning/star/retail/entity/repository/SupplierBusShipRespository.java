package com.morning.star.retail.entity.repository;

import com.morning.star.retail.entity.SupplierBusShipEntity;
import org.springframework.data.repository.Repository;

public interface SupplierBusShipRespository extends Repository<SupplierBusShipEntity, Long> {
    SupplierBusShipEntity save(SupplierBusShipEntity entity);

    SupplierBusShipEntity getByShipCode(String shipCode);
}
