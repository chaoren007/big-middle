package com.morning.star.retail.admin.dao;

import com.morning.star.retail.admin.bean.HeartbeatConfDO;

/**
 * Created by liangguobin on 2017/5/12.
 */
public interface HeartbeatConfDAO {
    HeartbeatConfDO getConf(String companyCode);
    void updateConf(HeartbeatConfDO confDO);
}
