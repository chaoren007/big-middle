package com.morning.star.retail.entity.repository;

import com.morning.star.retail.entity.SupplierEntity;
import org.springframework.data.repository.Repository;

public interface SupplierRespository extends Repository<SupplierEntity, String> {

	SupplierEntity getById(Long id);

	SupplierEntity getBySupplierCode(String supplierCode);

	SupplierEntity getBySupplierName(String supplierName);

	void save(SupplierEntity entity);

	int countByTypeCode(String typeCode);

	int countByMobile(String mobile);

	int count();

}
