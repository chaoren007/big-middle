package com.morning.star.retail.entity.repository;


import org.springframework.data.repository.Repository;

import com.morning.star.retail.entity.GoodsEntity;

import java.util.List;

public interface GoodsRepository extends Repository<GoodsEntity, String> {


	void save(GoodsEntity entity);

	GoodsEntity findOne(String code);

	GoodsEntity findByStoreCodeAndProductInfoSapMotherCode(String storeCode, String motherCode);

    GoodsEntity findOneByStoreCodeAndProductInfoSapProductCode(String storeCode, String sapCode);

	GoodsEntity getByStoreCodeAndProductInfoProductCode(String storeCode, String product);

	List<GoodsEntity> getByStoreCode(String storeCode);

	List<GoodsEntity> getByProductInfoGroupCodeAndProductInfoProductCode(String groupCode, String productCode);

	Boolean existsByProductInfoProductCodeAndStoreCode(String productCode, String storeCode);
}
