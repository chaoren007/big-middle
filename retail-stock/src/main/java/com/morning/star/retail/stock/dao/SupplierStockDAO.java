package com.morning.star.retail.stock.dao;

import java.util.List;

import com.morning.star.retail.stock.bean.SupplierStockDO;
import com.morning.star.retail.stock.dto.SupplierStockQueryDTO;
import com.morning.star.retail.stock.po.SupplierStockPO;

public interface SupplierStockDAO {

    List<SupplierStockPO> select(SupplierStockQueryDTO queryDTO);

    SupplierStockPO selectOne(SupplierStockQueryDTO queryDTO);

    int count(SupplierStockQueryDTO queryDTO);

    int insert(SupplierStockDO supplierStockDO);

    int update(SupplierStockDO supplierStockDO);

    int updateByInc(SupplierStockDO supplierStockDO);

    int updateDoneInStockNum(SupplierStockDO supplierStockDO);
}