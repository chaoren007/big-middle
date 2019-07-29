package com.morning.star.retail.admin.service;

import com.morning.star.retail.admin.bean.HeartbeatConfDO;

/**
 * Created by liangguobin on 2017/5/12.
 */
public interface HeartbeatConfService {
    HeartbeatConfDO getConf(String companyCode);

    void updateConf(HeartbeatConfDO confDO);
}
