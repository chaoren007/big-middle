package com.morning.star.retail.entity.repository;

import org.springframework.data.repository.Repository;

import com.morning.star.retail.entity.SupplierChangeEntity;

public interface SupplierChangeRespository extends Repository<SupplierChangeEntity, String> {

    SupplierChangeEntity getByCodeAndGroupCode(String code, String groupCode);

    void save(SupplierChangeEntity entity);

}
