package com.morning.star.retail.facade.impl;

import com.morning.star.retail.dao.MqErrorDAO;
import com.morning.star.retail.dto.MqerrorDTO;
import com.morning.star.retail.facade.MqErrorFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class MqErrorFacadeImpl implements MqErrorFacade {
    @Autowired
    private MqErrorDAO mqErrorDAO;

    @Override
    public void insert(MqerrorDTO dto) {
        mqErrorDAO.insert(dto);
    }
}
