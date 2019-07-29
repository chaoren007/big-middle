package com.morning.star.retail.application;

import com.morning.star.retail.dto.*;
import com.morning.star.retail.utils.page.PageBean;

import java.util.List;

/**
 * 供应商供货
 */
public interface SupBusItemApplication {
    /**
     * 添加供货商品 如果存在，则累加供货数量；如果不存在，则添加供货数据。定时任务调用
     */
    void insertSupBusItem();

    PageBean<BusSupplyGoodsDTO> getSupplyGoods(BusSupplyGoodsQueryDTO dto);


    void comfire(BusSupplyConfireDTO dto);

    List<String> listDepots(List<String> dto);

    PageBean<BusShipGoodsDTO> getShipGoods(BusShipGoodsQueryDTO queryDTO);

    BusSupplyGoodsDetailDTO getSupplyGoodsDetail(String supplyCode);

    BusShipGoodsDetailDTO getShipGoodsDetail(String shipCode);

    List<BusSupplyGoodsNumDTO> getsupplyStatistics(String supplierCode);

    void taskBus();
}
