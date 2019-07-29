package com.morning.star.retail.stock.entity.repository;


import java.util.List;

import org.springframework.data.repository.Repository;

import com.morning.star.retail.stock.entity.OutstockOrderDetailEntity;

public interface OutstockDetailRepository extends Repository<OutstockOrderDetailEntity, Long> {


	void save(OutstockOrderDetailEntity entity);

	List<OutstockOrderDetailEntity> getByOutstockCode(String outstockCode);

	OutstockOrderDetailEntity getByOutstockCodeAndProductCode(String outstockCode,String productCode);
	
	void deleteById(Long id);

}
