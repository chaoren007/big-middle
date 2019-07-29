package com.morning.star.retail.entity.repository;

import org.springframework.data.repository.Repository;

import com.morning.star.retail.entity.SupplierStoreEntity;

public interface SupplierStoreRespository extends Repository<SupplierStoreEntity, Long> {

    SupplierStoreEntity getBySupplierCodeAndStoreCode(String supplierCode, String storeCode);

    void save(SupplierStoreEntity entity);

}
