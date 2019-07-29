package com.morning.star.retail.entity.repository;


import com.morning.star.retail.entity.WarehouseEntity;
import org.springframework.data.repository.Repository;

public interface WarehouseRepository extends Repository<WarehouseEntity, String> {

    WarehouseEntity save(WarehouseEntity entity);

    WarehouseEntity getByWarehouseCodeAndGroupCode(String warehouseCode,String groupCode);

    WarehouseEntity getByWarehouseCodeAndStoreCode(String warehouseCode,String storeCode);

    WarehouseEntity getByWarehouseCode(String warehouseCode);

}
