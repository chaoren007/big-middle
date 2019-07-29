package com.morning.star.retail.stock.service;

import java.util.List;

import com.morning.star.retail.stock.bean.StockLogDO;

/**
 * 库存日志接口
 *
 * @author jiangfy
 */
public interface StockLogService {

	/**
	 * 新增库存日志记录
	 * 
	 * @param stockLogDO
	 * @return
	 */
	int insertStockLog(StockLogDO stockLogDO);

	/**
	 * 查询日志
	 * 
	 * @param companyCode
	 *            公司编码
	 * @param storeCode
	 *            门店编码
	 * @param pageNo
	 *            页码
	 * @param pageSize
	 *            每页记录数
	 * @return
	 */
	List<StockLogDO> listStockLogDO(String companyCode, String storeCode);

}
