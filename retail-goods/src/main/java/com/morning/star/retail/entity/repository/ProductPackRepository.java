package com.morning.star.retail.entity.repository;


import com.morning.star.retail.entity.ProductPackEntity;
import org.springframework.data.repository.Repository;

public interface ProductPackRepository extends Repository<ProductPackEntity, Long> {

	ProductPackEntity save(ProductPackEntity entity);

	ProductPackEntity findOne(Long id);

	Boolean existsByProductPackInfoProductCode(String productCode);

	Boolean existsByProductPackInfoSapProductCode(String sapProductCode);

}
