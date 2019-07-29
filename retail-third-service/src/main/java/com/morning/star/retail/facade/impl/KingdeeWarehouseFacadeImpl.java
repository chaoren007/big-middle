package com.morning.star.retail.facade.impl;

import com.alibaba.fastjson.JSON;
import com.morning.star.retail.dto.KingdeeWarehouseDTO;
import com.morning.star.retail.entity.enums.RequestTagEnum;
import com.morning.star.retail.facade.KingdeeWarehouseFacade;
import com.morning.star.retail.facade.dto.WarehouseKdDTO;
import com.morning.star.retail.kingdee.service.KingdeeClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KingdeeWarehouseFacadeImpl implements KingdeeWarehouseFacade {
    @Autowired
    private KingdeeClient client;

    private static final String FORMID = "BD_STOCK";

    @Override
    public void add(WarehouseKdDTO dto) {
        String context = JSON.toJSONString(new KingdeeWarehouseDTO(dto.getfName(),dto.isfAllowMinusQty()));
        client.add(FORMID,context,"KingdeeWarehouseFacade",RequestTagEnum.KINGDEE_CREATE_WAREHOUSE);
    }
}
