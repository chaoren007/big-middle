package com.morning.star.retail.facade.impl;

import com.alibaba.fastjson.JSON;
import com.morning.star.retail.dto.KingdeePositionDTO;
import com.morning.star.retail.entity.enums.RequestTagEnum;
import com.morning.star.retail.facade.KingdeePositionFacade;
import com.morning.star.retail.facade.dto.PositionKdDTO;
import com.morning.star.retail.kingdee.service.KingdeeClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KingdeePositionFacadeImpl implements KingdeePositionFacade {
    @Autowired
    private KingdeeClient client;

    private static final String FORMID = "HR_ORG_HRPOST";

    @Override
    public void add(PositionKdDTO dto) {
        String context = JSON.toJSONString(new KingdeePositionDTO(dto.getfName(),dto.getfEffectDate(),dto.getfLapseDate(),dto.isFleaderpost()));
        client.add(FORMID,context,"KingdeePositionFacade",RequestTagEnum.KINGDEE_CREATE_POSITION);
    }
}
