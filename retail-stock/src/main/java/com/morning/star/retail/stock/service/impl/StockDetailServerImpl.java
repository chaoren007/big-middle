package com.morning.star.retail.stock.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.morning.star.retail.stock.bean.StockDetailDO;
import com.morning.star.retail.stock.bo.ItemInBO;
import com.morning.star.retail.stock.bo.ItemOutBO;
import com.morning.star.retail.stock.bo.OperatorBO;
import com.morning.star.retail.stock.bo.WarehouseBO;
import com.morning.star.retail.stock.bo.WarehouseInBO;
import com.morning.star.retail.stock.bo.WarehouseOutBO;
import com.morning.star.retail.stock.dao.StockDetailDAO;
import com.morning.star.retail.stock.enums.StockDetailStatus;
import com.morning.star.retail.stock.enums.WarehouseInType;
import com.morning.star.retail.stock.service.StockDetailService;

@Service
public class StockDetailServerImpl implements StockDetailService {

    private final static int TRY_TIMES_OF_WAREHOURSE_OUT = 3;
    
    @Autowired
    private StockDetailDAO stockDetailDAO;
    

    @Override
    @Transactional
    public void warehouseInByRejection(WarehouseInBO warehouseInBO) {
        // TODO 参数验证
        warehouseIn(warehouseInBO, WarehouseInType.WAREHOUSEIN_BY_REJECTION);
    }


    @Override
    @Transactional
    public void warehouseInByRefund(WarehouseInBO warehouseInBO) {
        // TODO 参数验证
        warehouseIn(warehouseInBO, WarehouseInType.WAREHOUSEIN_BY_REFUND);
    }


    /**
     * 入库
     * @param warehouseInBO
     * @param inType
     */
    public void warehouseIn(WarehouseInBO warehouseInBO, int inType) {
        for(ItemInBO itemInBO : warehouseInBO.getItemInBOs()) {
            StockDetailDO stockDetailDO = oneIn(warehouseInBO.getCompanyCode(), warehouseInBO.getWarehouseBO(), itemInBO, warehouseInBO.getOperatorBO(), inType);
            if(stockDetailDO == null) {
                throw new RuntimeException("明细入库失败");
            }
            if(itemInBO.isSerialCode()) {
                water(stockDetailDO);
            }
        }
    }
    
    /**
     * 出库
     * @param warehouseOutBO
     * @param outType
     */
    public void warehouseOut(WarehouseOutBO warehouseOutBO, int outType) {
        for(ItemOutBO itemOutBO : warehouseOutBO.getItemOutBOs()) {
            StockDetailDO stockDetailDO = oneOut(warehouseOutBO.getCompanyCode(), warehouseOutBO.getWarehouseBO(), itemOutBO, warehouseOutBO.getOperatorBO(), outType);
            if(stockDetailDO == null) {
                throw new RuntimeException("明细出库失败");
            }
            
            if(itemOutBO.isSerialCode()) {
                water(stockDetailDO);
            }
        }
    }
    
    
    /**
     * 单个入库
     * @param companyCode
     * @param warehouseBO
     * @param itemInBO
     * @param operatorBO
     * @param inType
     * @return
     */
    private StockDetailDO oneIn(String companyCode, WarehouseBO warehouseBO, ItemInBO itemInBO, OperatorBO operatorBO, int inType) {
        if(inType == WarehouseInType.WAREHOUSEIN_BY_PURCHASE || !itemInBO.isSerialCode()) {
            // 新建明细
            StockDetailDO stockDetailDO = StockDetailDO.create(companyCode, warehouseBO, itemInBO, operatorBO, inType);
            stockDetailDAO.save(stockDetailDO);
            return stockDetailDO;
        } else {
            // 修改明细
            StockDetailDO stockDetailDO = stockDetailDAO.findBySerialId(companyCode, warehouseBO.getId(), itemInBO.getSerialId());
            if(stockDetailDO == null) {
                throw new IllegalArgumentException("明细不存在");
            }
            if(stockDetailDO.getStatus() == StockDetailStatus.IN) {
                throw new IllegalArgumentException("明细状态不匹配");
            }
            stockDetailDO = stockDetailDO.update(itemInBO, operatorBO, inType);
            if(stockDetailDAO.update(stockDetailDO) == 0) {
                throw new IllegalArgumentException("数据库更新失败");
            }
            return stockDetailDO;
        }
    }
    
    /**
     * 单个出库
     * @param companyCode
     * @param warehouseBO
     * @param itemOutBO
     * @param operatorBO
     * @param outType
     * @return
     */
    private StockDetailDO oneOut(String companyCode, WarehouseBO warehouseBO, ItemOutBO itemOutBO, OperatorBO operatorBO, int outType) {
        for(int i = 0; i < TRY_TIMES_OF_WAREHOURSE_OUT; i++) {
            StockDetailDO stockDetailDO = itemOutBO.isSerialCode()
                    ? stockDetailDAO.findBySerialId(companyCode, warehouseBO.getId(), itemOutBO.getSerialId())
                    : stockDetailDAO.findOne(companyCode, warehouseBO.getId(), itemOutBO.getGoodsId(), StockDetailStatus.IN);
            if(stockDetailDO == null) {
                throw new IllegalArgumentException("明细不存在");
            }
            if(stockDetailDO.getStatus() == StockDetailStatus.OUT) {
                throw new IllegalArgumentException("明细状态不匹配");
            }
            stockDetailDO = stockDetailDO.update(itemOutBO, operatorBO, outType);
            if(stockDetailDAO.update(stockDetailDO) == 1) {
                return stockDetailDO;
            }
        }
        throw new RuntimeException("数据库更新失败");
    }
    
    /**
     * 保存流水记录
     * @param stockDetailDO
     */
    private void water(StockDetailDO stockDetailDO) {
        stockDetailDAO.saveWater(stockDetailDO);
    }
    
}
