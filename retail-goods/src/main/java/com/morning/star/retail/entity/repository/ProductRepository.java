package com.morning.star.retail.entity.repository;


import com.morning.star.retail.entity.ProductEntity;
import com.morning.star.retail.enums.CommodityTypeEnum;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface ProductRepository extends Repository<ProductEntity, String> {


	ProductEntity save(ProductEntity entity);

	ProductEntity findOne(String code);

	ProductEntity getByGroupCodeAndSapProductCode(String groupCode, String sapCode);

	ProductEntity getByGroupCodeAndProductCode(String groupCode, String productCode);

	List<ProductEntity> getByGroupCode(String groupCode);

	Boolean existsBySapProductCodeAndGroupCode(String sapProductCode, String groupCode);

	Boolean existsByProductName(String productName);

	ProductEntity getBySapProductCode(String sapCode);

	Boolean existsByProductCode(String productCode);
}
