package com.morning.star.retail.stock.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.morning.star.retail.stock.bean.SupplierStockDO;
import com.morning.star.retail.stock.dao.SupplierStockDAO;
import com.morning.star.retail.stock.dto.SupplierStockQueryDTO;
import com.morning.star.retail.stock.exception.SupplierStockErrorCode;
import com.morning.star.retail.stock.po.SupplierStockPO;
import com.morning.star.retail.stock.service.SupplierStockService;

@Service
public class SupplierStockServiceImpl implements SupplierStockService {

    @Autowired
    private SupplierStockDAO supplierStockDAO;

    @Override
    public boolean isExist(SupplierStockQueryDTO queryDTO) {
        return supplierStockDAO.count(queryDTO) > 0 ? true : false;
    }

    @Override
    public boolean checkExist(SupplierStockQueryDTO queryDTO) {
        if (!isExist(queryDTO)) {
            throw SupplierStockErrorCode.STOCK_IS_NULL.build();
        }
        return true;
    }

    @Override
    public boolean checkNotExist(SupplierStockQueryDTO queryDTO) {
        if (isExist(queryDTO)) {
            throw SupplierStockErrorCode.STOCK_IS_EXIST.build();
        }
        return true;
    }

    @Override
    public int add(SupplierStockDO supplierStockDO) {
        return supplierStockDAO.insert(supplierStockDO);
    }

    @Override
    public int modifyByInc(SupplierStockDO supplierStockDO) {
        return supplierStockDAO.updateByInc(supplierStockDO);
    }

    @Override
    public int checkModifyByInc(SupplierStockDO supplierStockDO) {
        if (isExist(SupplierStockQueryDTO.from(supplierStockDO))) {
            return supplierStockDAO.updateByInc(supplierStockDO);
        }
        return supplierStockDAO.insert(supplierStockDO);
    }

    @Override
    public List<SupplierStockPO> query(SupplierStockQueryDTO queryDTO) {
        return supplierStockDAO.select(queryDTO);
    }

    @Override
    public SupplierStockPO queryOne(SupplierStockQueryDTO queryDTO) {
        return supplierStockDAO.selectOne(queryDTO);
    }
}
