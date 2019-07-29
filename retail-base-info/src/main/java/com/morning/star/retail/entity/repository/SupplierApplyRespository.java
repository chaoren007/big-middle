package com.morning.star.retail.entity.repository;

import com.morning.star.retail.entity.SupplierApplyEntity;
import org.springframework.data.repository.Repository;

public interface SupplierApplyRespository extends Repository<SupplierApplyEntity, String> {

    SupplierApplyEntity getById(Long id);

    void save(SupplierApplyEntity entity);

}
