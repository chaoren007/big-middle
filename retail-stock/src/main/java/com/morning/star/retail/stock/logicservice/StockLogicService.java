package com.morning.star.retail.stock.logicservice;

import com.morning.star.retail.stock.dto.StockOrderDTO;
import com.morning.star.retail.stock.enums.StockRecordTypeEnum;

/**
 * 库存
 *
 * @author jiangyf
 * @date 2017年5月19日 下午8:13:11
 */
public interface StockLogicService {

    /**
     * 线上预占库存
     *
     * @param dto
     * @return
     */
    boolean onlinePreStock(StockOrderDTO dto);

    /**
     * 确认线上预占库存（支付）
     *
     * @param dto
     * @return
     */
    boolean checkOnlinePreStock(StockOrderDTO dto);

    /**
     * 线上释放库存
     *
     * @param dto
     * @return
     */
    boolean onlineFreeStock(StockOrderDTO dto);

    /**
     * 线上销售出库
     *
     * @param dto
     * @return
     */
    boolean onlineOutStock(StockOrderDTO dto);

    /**
     * 线下销售出库
     *
     * @param dto
     * @return
     */
    boolean offlineOutStock(StockOrderDTO dto);

    /**
     * 门店调拨出库
     *
     * @param dto
     * @return
     */
    boolean transferOutStock(StockOrderDTO dto);

    /**
     * 门店退货供应商出库
     *
     * @param dto
     * @return
     */
    boolean returnOutStock(StockOrderDTO dto);

    /**
     * 盘亏出库
     *
     * @param dto
     * @return
     */
    boolean inventoryLossOutStock(StockOrderDTO dto);

    /**
     * 直接入库
     *
     * @param dto
     * @param type
     * @return
     */
    boolean directInStock(StockOrderDTO dto, StockRecordTypeEnum type);

    /**
     * 采购待入库
     *
     * @param dto
     * @return
     */
    boolean purchaseWaitInStock(StockOrderDTO dto);

    /**
     * 调拨待入库
     *
     * @param dto
     * @return
     */
    boolean transferWaitInStock(StockOrderDTO dto);

    /**
     * 采购入库
     *
     * @param dto
     * @return
     */
    boolean purchaseInStock(StockOrderDTO dto);

    /**
     * 调拨入库
     *
     * @param dto
     * @return
     */
    boolean transferInStock(StockOrderDTO dto);

    /**
     * 盘盈入库
     *
     * @param dto
     * @return
     */
    boolean inventoryProfitInStock(StockOrderDTO dto);

    /**
     * 其他入库（直接入库）
     *
     * @param dto
     * @return
     */
    boolean otherIn(StockOrderDTO dto);

}
