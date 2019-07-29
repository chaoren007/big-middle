package com.morning.star.retail.dao;

import com.github.pagehelper.Page;
import com.morning.star.retail.dto.*;
import com.morning.star.retail.entity.SupplierBusItemEntity;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

public interface SupplierDAO {

    SupplierDTO getSupplierByMobile(@Param(value = "mobile") String mobile);

    List<SupplierDTO> querySupplierByPage(SupplierQueryDTO queryDTO);

    SupplierApplyDTO getSupplierApplyByMobile(@Param(value = "mobile") String mobile);

    SupplierApplyDTO getSupplierApplyByName(@Param(value = "supplierName") String supplierName);

    List<SupplierApplyDTO> querySupplierApplyByPage(SupplierQueryDTO queryDTO);

    List<SupplierDTO> querySupplierByUpc(SupplierQueryDTO queryDTO);

    List<SupplierTypeDTO> querySupplierTypeByPage(SupplierTypeQueryDTO queryDTO);

    List<SupplierStoreDTO> querySupplierStoreByPage(SupplierQueryDTO queryDTO);

    List<SupplierItemDTO> querySupplierItemByPage(SupplierQueryDTO queryDTO);

    Page<SupplierChangeDTO> querySupplierChangeByPage(SupplierQueryDTO queryDTO, RowBounds build);

    List<SupplierStoreDTO> querySupplierChangeStoreByPage(SupplierQueryDTO queryDTO);

    List<SupplierItemDTO> querySupplierChangeItemByPage(SupplierQueryDTO queryDTO);

    Page<BusSupplyGoodsDTO> getSupplyGoods(BusSupplyGoodsQueryDTO dto, RowBounds rowBounds);

    Page<BusShipGoodsDTO> getShipGoods(BusShipGoodsQueryDTO dto, RowBounds rowBounds);

    Long getSupplierMaxId();

    List<BusSupplyGoodsNumDTO> getsupplyStatistics(String supplierCode);


    BusSupplyGoodsDTO taskBus();

    void updateToDealing();
    void updateToDealed();
}
