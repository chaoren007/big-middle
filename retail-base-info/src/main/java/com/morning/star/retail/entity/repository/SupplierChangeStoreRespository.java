package com.morning.star.retail.entity.repository;

import java.util.List;

import org.springframework.data.repository.Repository;

import com.morning.star.retail.entity.SupplierChangeStoreEntity;

public interface SupplierChangeStoreRespository extends Repository<SupplierChangeStoreEntity, Long> {

    void save(SupplierChangeStoreEntity entity);

    void deleteByChangeCodeAndSupplierCodeAndGroupCode(String changeCode, String supplierCode, String groupCode);

    List<SupplierChangeStoreEntity> getByChangeCodeAndSupplierCodeAndGroupCode(String changeCode, String supplierCode, String groupCode);

}
