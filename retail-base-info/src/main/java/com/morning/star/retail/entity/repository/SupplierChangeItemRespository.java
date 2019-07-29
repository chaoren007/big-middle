package com.morning.star.retail.entity.repository;

import java.util.List;

import org.springframework.data.repository.Repository;

import com.morning.star.retail.entity.SupplierChangeItemEntity;

public interface SupplierChangeItemRespository extends Repository<SupplierChangeItemEntity, Long> {

    void save(SupplierChangeItemEntity entity);

    void deleteByChangeCodeAndSupplierCodeAndGroupCode(String changeCode, String supplierCode, String groupCode);

    List<SupplierChangeItemEntity> getByChangeCodeAndSupplierCodeAndGroupCode(String changeCode, String supplierCode, String groupCode);

}
