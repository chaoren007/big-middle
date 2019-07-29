package com.morning.star.retail.stock.service;

import com.morning.star.retail.stock.bean.SupplierStockRecordDO;

/**
 * 供应商库存流水
 *
 * @author jiangyf
 * @date 2017/11/16
 */
public interface SupplierStockRecordService {

    /**
     * 新增库存供应商流水
     *
     * @param supplierStockRecordDO
     * @return
     */
    int add(SupplierStockRecordDO supplierStockRecordDO);
}
