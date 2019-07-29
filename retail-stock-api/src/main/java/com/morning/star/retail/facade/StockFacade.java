package com.morning.star.retail.facade;

import com.morning.star.retail.base.page.PageBeans;
import com.morning.star.retail.stock.dto.*;

import java.util.List;

/**
 * 库存
 *
 * @author jiangyf
 */
public interface StockFacade {

    /**
     * 单个查询（货品编码，商品编码，upc至少须有一个）
     *
     * @param queryDTO
     * @return
     */
    StockDTO get(StockQueryDTO queryDTO);

    /**
     * 多个查询
     *
     * @param queryDTO
     * @return
     */
    List<StockDTO> query(StockQueryDTO queryDTO);

    /**
     * 列表查询
     *
     * @param queryDTO
     * @return
     */
    PageBeans<StockDTO> list(StockQueryDTO queryDTO);

    /**
     * 修改在库库存
     *
     * @param formDTO
     * @return
     */
    boolean modify(StockFormDTO formDTO);

    /**
     * 新增/修改库存
     *
     * @param formDTO
     * @return
     */
    boolean save(StockFormDTO formDTO);

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
     * 客户拒收入库
     *
     * @param dto
     * @return
     */
    boolean rejectInStock(StockOrderDTO dto);

    /**
     * 客户退货入库
     *
     * @param dto
     * @return
     */
    boolean returnInStock(StockOrderDTO dto);

    /**
     * 线下销售出库
     *
     * @param dto
     * @return
     */
    boolean offlineOutStock(StockOrderDTO dto);

    /**
     * 导入库存（队列）
     *
     * @param list
     */
    void importStock(List<StockImportDTO> list);

}
