package com.morning.star.retail.entity.repository;

import com.morning.star.retail.entity.SupplierBusItemEntity;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface SupplierBusItemRespository extends Repository<SupplierBusItemEntity, Long> {
    SupplierBusItemEntity save(SupplierBusItemEntity entity);

    SupplierBusItemEntity getByPCodeAndCityIdAndStatusAndSupplierCode(String pCode, String cityId, Integer status, String supplierCode);

    SupplierBusItemEntity getBySupplyCode(String code);

    List<SupplierBusItemEntity> getByShipCode(String shipCode);

    List<SupplierBusItemEntity>  getByCityId(String cityId);

    SupplierBusItemEntity  getByCityIdAndPCodeAndPriodAndStatusAndVersionCode(String cityId,String pCode,String priod,Integer status,String versionCode);

}
