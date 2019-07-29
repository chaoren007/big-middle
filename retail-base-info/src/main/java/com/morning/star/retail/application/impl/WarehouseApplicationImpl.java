package com.morning.star.retail.application.impl;

import com.morning.star.retail.RabbitConfig;
import com.morning.star.retail.application.WarehouseApplication;
import com.morning.star.retail.dto.WarehouseDTO;
import com.morning.star.retail.dto.WarehouseQueryDTO;
import com.morning.star.retail.entity.WarehouseEntity;
import com.morning.star.retail.entity.repository.WarehouseRepository;
import com.morning.star.retail.facade.dto.StorageWmsDTO;
import com.morning.star.retail.helper.MqHelperService;
import com.morning.star.retail.utils.entity.DeleteFlagEnum;
import org.apache.commons.lang.Validate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ethan
 * @create_time 2018/8/16 22:12
 */
@Service
public class WarehouseApplicationImpl implements WarehouseApplication {
    private Logger log = LoggerFactory.getLogger(WarehouseApplicationImpl.class);


    @Autowired
    private WarehouseRepository warehouseRepository;

    @Autowired
    private MqHelperService mqHelperService;
    @Autowired
    private RabbitConfig rabbitConfig;


    @Override
    public String create(WarehouseDTO dto) {
        WarehouseEntity entity = new WarehouseEntity();
        entity.setWarehouseName(dto.getWarehouseName());
        entity.setWarehouseAddress(dto.getWarehouseAddress());
        entity.setTel(dto.getTel());
        entity.setCreateName(dto.getCreateName());
        entity.setStoreCode(dto.getStoreCode());
        entity.setGroupCode(dto.getGroupCode());
        entity.setRemark(dto.getRemark());
        entity.setCity(dto.getCity());
        entity.setCityId(dto.getCityId());
        entity = warehouseRepository.save(entity);
        if (entity.getId() != null) {
            entity.setWarehouseCode("CK" + entity.getId());
            entity = warehouseRepository.save(entity);
        }


        //对接WMS
        StorageWmsDTO wms = WarehouseEntity.toWmsDTO(entity);
        //发送新建仓库MQ
        mqHelperService.send(rabbitConfig.getExchange(), rabbitConfig.getCreateStorageQueue(), wms);

        return entity.getWarehouseCode();
    }

    @Override
    public void edit(WarehouseDTO dto) {
        WarehouseEntity entity;
        if (dto.getStoreCode() == null || dto.getStoreCode().equals("")) {
            entity = warehouseRepository.getByWarehouseCodeAndGroupCode(dto.getWarehouseCode(), dto.getGroupCode());
        } else {
            entity = warehouseRepository.getByWarehouseCodeAndStoreCode(dto.getWarehouseCode(), dto.getStoreCode());
        }
        Validate.notNull(entity, "该仓库编码不存在");
        entity.setWarehouseName(dto.getWarehouseName());
        entity.setWarehouseAddress(dto.getWarehouseAddress());
        entity.setTel(dto.getTel());
        entity.setCreateName(dto.getCreateName());
        entity.setStoreCode(dto.getStoreCode());
        entity.setGroupCode(dto.getGroupCode());
        entity.setRemark(dto.getRemark());
        warehouseRepository.save(entity);
    }

    @Override
    public void delete(WarehouseQueryDTO dto) {
        WarehouseEntity entity;
        if (dto.getStoreCode() == null || dto.getStoreCode().equals("")) {
            entity = warehouseRepository.getByWarehouseCodeAndGroupCode(dto.getWarehouseCode(), dto.getGroupCode());
        } else {
            entity = warehouseRepository.getByWarehouseCodeAndStoreCode(dto.getWarehouseCode(), dto.getStoreCode());
        }
        Validate.notNull(entity, "该仓库编码不存在");
        entity.setDeleteFlag(DeleteFlagEnum.DELETE.getCode());
        warehouseRepository.save(entity);
    }
}
