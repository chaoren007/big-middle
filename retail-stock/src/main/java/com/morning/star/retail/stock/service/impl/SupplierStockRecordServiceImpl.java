package com.morning.star.retail.stock.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.morning.star.retail.stock.bean.SupplierStockRecordDO;
import com.morning.star.retail.stock.dao.SupplierStockRecordDAO;
import com.morning.star.retail.stock.service.SupplierStockRecordService;

@Service
public class SupplierStockRecordServiceImpl implements SupplierStockRecordService {

    @Autowired
    private SupplierStockRecordDAO supplierStockRecordDAO;

    @Override
    public int add(SupplierStockRecordDO supplierStockRecordDO) {
        return supplierStockRecordDAO.insert(supplierStockRecordDO);
    }
}
