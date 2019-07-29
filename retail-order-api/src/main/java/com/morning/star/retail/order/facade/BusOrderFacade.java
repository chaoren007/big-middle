package com.morning.star.retail.order.facade;

import com.morning.star.retail.order.facade.dto.BusOrderDTO;

import java.util.List;

/**
 * 供运营端推送订单调用的接口
 */
public interface BusOrderFacade {
    void add(BusOrderDTO dto);

    /**
     * 获取供应商未处理的订单
     * @return
     */
    BusOrderDTO getByDealWith();

    void updateStatus(List<Long> ids);

}
