package com.morning.star.retail.entity.repository;

import org.springframework.data.repository.Repository;

import com.morning.star.retail.entity.SupplierTypeEntity;

public interface SupplierTypeRespository extends Repository<SupplierTypeEntity, String> {

    SupplierTypeEntity getByCode(String code);

    SupplierTypeEntity getByNameAndParentCode(String name, String parentCode);

    SupplierTypeEntity getByCodeIsNotAndNameAndParentCode(String code, String name, String parentCode);

    void save(SupplierTypeEntity entity);

}
