package com.morning.star.retail.facade.impl;

import com.alibaba.fastjson.JSON;
import com.morning.star.retail.dto.KingdeeUnitsDTO;
import com.morning.star.retail.entity.enums.RequestTagEnum;
import com.morning.star.retail.facade.KingdeeUnitsFacade;
import com.morning.star.retail.facade.dto.UnitsKdDTO;
import com.morning.star.retail.kingdee.service.KingdeeClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KingdeeUnitsFacadeImpl implements KingdeeUnitsFacade {
    @Autowired
    private KingdeeClient client;

    private static final String FORMID = "BD_UNIT";

    @Override
    public void add(UnitsKdDTO dto) {
        String context = JSON.toJSONString(new KingdeeUnitsDTO(dto.getUnitsName()));
        client.add(FORMID,context,dto.getUnitsId().toString(),RequestTagEnum.KINGDEE_CREATE_UNITS);
    }

    @Override
    public void delete(UnitsKdDTO dto) {
        String context = JSON.toJSONString(new KingdeeUnitsDTO(dto.getUnitsName()));
        client.delete(FORMID,context,dto.getUnitsId().toString(),RequestTagEnum.KINGDEE_DELETE_UNITS);
    }
}
