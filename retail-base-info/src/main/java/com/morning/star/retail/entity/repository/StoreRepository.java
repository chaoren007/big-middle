package com.morning.star.retail.entity.repository;

import org.springframework.data.repository.Repository;

import com.morning.star.retail.entity.StoreEntity;

public interface StoreRepository extends Repository<StoreEntity, String> {

    StoreEntity findOne(String code);

    void save(StoreEntity entity);

    Boolean existsByStoreNameAndGroupCode(String name, String groupCode);

    Boolean exists(String code);

    StoreEntity findByGroupCodeAndCityId(String groupCode, Long id);

    Boolean existsByGroupCodeAndCityId(String groupCode, Long id);

}
