package com.morning.star.retail.stock.dao;

import java.util.List;

import com.morning.star.retail.stock.bean.StockLogDO;
import com.morning.star.retail.stock.bo.StockLogBO;

public interface StockLogDao {

	int insertStockLog(StockLogDO stockLogDO);

	List<StockLogDO> selectStockLogList(StockLogBO stockLogBO);

}
