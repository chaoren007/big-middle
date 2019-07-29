package com.morning.star.retail.entity.repository;

import java.util.List;

import org.springframework.data.repository.Repository;

import com.morning.star.retail.entity.SupplierItemEntity;

public interface SupplierItemRespository extends Repository<SupplierItemEntity, Long> {

    SupplierItemEntity getBySupplierCodeAndSapProductCode(String supplierCode, String sapProductCode);

    SupplierItemEntity getBySupplierCodeAndProductCode(String supplierCode, String productCode);

    SupplierItemEntity getBySupplierCodeAndUpcCode(String supplierCode, String upcCode);

    List<SupplierItemEntity> getBySupplierCode(String supplierCode);

    void save(SupplierItemEntity entity);

}
