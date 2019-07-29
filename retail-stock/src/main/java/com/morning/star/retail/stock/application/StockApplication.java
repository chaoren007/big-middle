package com.morning.star.retail.stock.application;


import com.morning.star.retail.stock.dto.StockDTO;
import com.morning.star.retail.stock.dto.StockFormDTO;
import com.morning.star.retail.stock.dto.StockQueryDTO;
import com.morning.star.retail.stock.entity.StockEntity;
import com.morning.star.retail.stock.enums.StockPreStatusEnum;

import java.math.BigDecimal;

public interface StockApplication {

    StockDTO get(StockQueryDTO queryDTO);

    boolean save(StockEntity stockEntity);

    boolean modify(StockFormDTO formDTO);

    boolean save(StockFormDTO formDTO);

    /**
     * 直接入库  在库库存 + num
     *
     * @param num
     * @param goodsCode
     * @param warehouseCode
     */
    void directInStock(BigDecimal num, String goodsCode, String warehouseCode);

    /**
     * 入库  待入库存 + num
     *
     * @param num
     * @param goodsCode
     * @param warehouseCode
     */
    void waitInStock(BigDecimal num, String goodsCode, String warehouseCode);

    /**
     * 待入库  在库库存 + doneInStockNum，待入库存 - waitInStockNum
     *
     * @param doneInStockNum
     * @param waitInStockNum
     * @param goodsCode
     * @param warehouseCode
     */
    void doneInStock(BigDecimal doneInStockNum, BigDecimal waitInStockNum, String goodsCode, String warehouseCode);

    /**
     * 直接出库  在库库存 - num
     *
     * @param num
     * @param goodsCode
     * @param warehouseCode
     */
    void directOutStock(BigDecimal num, String goodsCode, String warehouseCode);

    /**
     * 预占库存  预占库存 + num
     *
     * @param num
     * @param goodsCode
     * @param warehouseCode
     */
    void preStock(BigDecimal num, String goodsCode, String warehouseCode);

    /**
     * 释放预占库存  预占库存 - num
     *
     * @param num
     * @param goodsCode
     * @param warehouseCode
     */
    void freePreStock(BigDecimal num, String goodsCode, String warehouseCode);

    /**
     * 待发库存  预占库存 - num，待发库存 + num
     *
     * @param num
     * @param goodsCode
     * @param warehouseCode
     */
    void waitOutStock(BigDecimal num, String goodsCode, String warehouseCode);

    /**
     * 释放待发库存  预占库存 + num，待发库存 - num
     *
     * @param num
     * @param goodsCode
     * @param warehouseCode
     */
    void freeWaitOutStock(BigDecimal num, String goodsCode, String warehouseCode);


    /**
     * 出库 在库库存 - num，待发库存 - num，已发库存 + num
     *
     * @param num
     * @param goodsCode
     * @param warehouseCode
     */
    void doneOutStock(BigDecimal num, String goodsCode, String warehouseCode);

    /**
     * 更新库存预占状态
     *
     * @param status
     * @param orderCode
     */
    void modifyStockPreStatus(StockPreStatusEnum status, String orderCode);

}
