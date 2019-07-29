package com.morning.star.retail.facade.impl;

import com.morning.star.retail.application.SupBusItemApplication;
import com.morning.star.retail.dto.*;
import com.morning.star.retail.enums.SupBusItemStatusEnum;
import com.morning.star.retail.facade.SupplierGoodsFacade;
import com.morning.star.retail.utils.page.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierGoodsFacadeImpl implements SupplierGoodsFacade {

    @Autowired
    private SupBusItemApplication supBusItemApplication;


    @Override
    public PageBean<BusSupplyGoodsDTO> getSupplyGoods(BusSupplyGoodsQueryDTO dto) {
        return supBusItemApplication.getSupplyGoods(dto);
    }

    @Override
    public void comfire(BusSupplyConfireDTO dto) {
        supBusItemApplication.comfire(dto);
    }

    @Override
    public List<String> listDepots(List<String> dto) {
        return supBusItemApplication.listDepots(dto);
    }

    @Override
    public PageBean<BusShipGoodsDTO> getShipGoods(BusShipGoodsQueryDTO queryDTO) {
        return supBusItemApplication.getShipGoods(queryDTO);
    }

    @Override
    public BusSupplyGoodsDetailDTO getSupplyGoodsDetail(String supplyCode) {
        return supBusItemApplication.getSupplyGoodsDetail(supplyCode);
    }

    @Override
    public BusShipGoodsDetailDTO getShipGoodsDetail(String shipCode) {
        return supBusItemApplication.getShipGoodsDetail(shipCode);
    }

    @Override
    public List<BusSupplyGoodsNumDTO> getsupplyStatistics(String supplierCode) {
        List<BusSupplyGoodsNumDTO> list = supBusItemApplication.getsupplyStatistics(supplierCode);

        for (BusSupplyGoodsNumDTO busSupplyGoodsNumDTO : list) {
            SupBusItemStatusEnum anEnum = SupBusItemStatusEnum.getEnum(busSupplyGoodsNumDTO.getStatus());
            if (anEnum != null) {
                busSupplyGoodsNumDTO.setStatusName(anEnum.getDesc());
            }
        }
        return list;
    }

    @Override
    public void insertSupBusItem() {
        supBusItemApplication.insertSupBusItem();
    }

    @Override
    public void taskBus() {
        supBusItemApplication.taskBus();
    }
}
