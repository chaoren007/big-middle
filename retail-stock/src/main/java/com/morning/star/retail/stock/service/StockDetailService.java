package com.morning.star.retail.stock.service;

import com.morning.star.retail.stock.bo.WarehouseInBO;

/**
 * 库存明细服务
 * 
 * @author Tim
 *
 */
public interface StockDetailService {
    
    /**
     * 拒收入库
     * @param warehouseInBO
     */
    void warehouseInByRejection(WarehouseInBO warehouseInBO);
    
    /**
     * 退货入库
     * @param warehouseInBO
     */
    void warehouseInByRefund(WarehouseInBO warehouseInBO);
    
}
