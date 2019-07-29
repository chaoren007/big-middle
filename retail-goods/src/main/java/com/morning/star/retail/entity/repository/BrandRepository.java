package com.morning.star.retail.entity.repository;

import java.util.List;

import org.springframework.data.repository.Repository;

import com.morning.star.retail.entity.BrandEntity;

public interface BrandRepository extends Repository<BrandEntity, Long> {

	BrandEntity save(BrandEntity brandEntity);

	BrandEntity findOne(Long id);

	boolean existsByBrandName(String brandName);

	List<BrandEntity> getByBrandName(String brandName);
	

}
