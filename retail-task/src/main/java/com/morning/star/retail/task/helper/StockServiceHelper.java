package com.morning.star.retail.task.helper;

import com.morning.star.retail.order.facade.dto.SalesOrderDTO;

/**
 * Stock Helper.
 * 
 * @author Tim
 *
 */
public interface StockServiceHelper {

    /**
     * 确认预占库存
     * @param order
     */
    public void confirmStock(SalesOrderDTO order);
    
    /**
     * 消费库存（出库）
     * @param order
     */
    public void consumeStock(SalesOrderDTO order);

    /**
     * 释放库存
     * @param order
     */
    public void releaseStock(SalesOrderDTO order);

}
