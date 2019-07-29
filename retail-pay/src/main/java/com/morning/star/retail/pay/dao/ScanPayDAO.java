package com.morning.star.retail.pay.dao;

import com.morning.star.retail.pay.entity.ScanPayPO;

public interface ScanPayDAO {

    void save(ScanPayPO scanPay);
    
    int update(ScanPayPO scanPay);

    ScanPayPO get(String outTradeNo);


}
