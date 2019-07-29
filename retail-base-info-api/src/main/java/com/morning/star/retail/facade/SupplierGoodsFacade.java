package com.morning.star.retail.facade;

import com.morning.star.retail.dto.*;
import com.morning.star.retail.utils.page.PageBean;

import java.util.List;

public interface SupplierGoodsFacade {

    PageBean<BusSupplyGoodsDTO> getSupplyGoods(BusSupplyGoodsQueryDTO dto);

    void comfire(BusSupplyConfireDTO dto);

    List<String> listDepots(List<String> dto);

    PageBean<BusShipGoodsDTO> getShipGoods(BusShipGoodsQueryDTO queryDTO);

    BusSupplyGoodsDetailDTO getSupplyGoodsDetail(String supplyCode);

    BusShipGoodsDetailDTO getShipGoodsDetail(String shipCode);

    List<BusSupplyGoodsNumDTO> getsupplyStatistics(String supplierCode);

    void insertSupBusItem();

    void taskBus();

}
