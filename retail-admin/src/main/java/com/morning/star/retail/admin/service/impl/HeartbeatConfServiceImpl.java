package com.morning.star.retail.admin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.morning.star.retail.admin.bean.HeartbeatConfDO;
import com.morning.star.retail.admin.dao.HeartbeatConfDAO;
import com.morning.star.retail.admin.service.HeartbeatConfService;

/**
 * Created by liangguobin on 2017/5/12.
 */
@Service
public class HeartbeatConfServiceImpl implements HeartbeatConfService {

    @Autowired
    private HeartbeatConfDAO confDAO;

    @Override
    public HeartbeatConfDO getConf(String companyCode) {
        return confDAO.getConf(companyCode);
    }

    @Override
    public void updateConf(HeartbeatConfDO confDO) {
        confDAO.updateConf(confDO);
    }
}
