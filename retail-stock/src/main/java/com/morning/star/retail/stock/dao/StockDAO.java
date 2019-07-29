package com.morning.star.retail.stock.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.morning.star.retail.stock.dto.StockDTO;
import com.morning.star.retail.stock.dto.StockQueryDTO;

public interface StockDAO {

    List<StockDTO> query(StockQueryDTO queryDTO);

    List<StockDTO> queryForPage(StockQueryDTO queryDTO);

    /**
     * 查询最新的库存预占状态
     *
     * @param orderCode
     * @return
     */
    Integer queryLastPreStatus(@Param("orderCode") String orderCode);

}
