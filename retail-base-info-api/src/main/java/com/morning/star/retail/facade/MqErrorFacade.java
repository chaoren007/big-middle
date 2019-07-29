package com.morning.star.retail.facade;

import com.morning.star.retail.dto.MqerrorDTO;

public interface MqErrorFacade {

    /**
     * 存发送失败的MQ
     * 
     * @return
     */
    void insert(MqerrorDTO dto);
}
