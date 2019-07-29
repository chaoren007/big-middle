package com.morning.star.retail.stock.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.morning.star.retail.stock.bean.StockLogDO;
import com.morning.star.retail.stock.bo.StockLogBO;
import com.morning.star.retail.stock.dao.StockLogDao;
import com.morning.star.retail.stock.service.StockLogService;

@Service("stockLogService")
public class StockLogServiceImpl implements StockLogService {

	@Autowired
	private StockLogDao stockLogDao;

	@Override
	public int insertStockLog(StockLogDO stockLogDO) {
		return stockLogDao.insertStockLog(stockLogDO);
	}

	@Override
	public List<StockLogDO> listStockLogDO(String companyCode,
			String storeCode) {
		StockLogBO stockLogBO = this.setStockLogBO(companyCode, storeCode);
		return stockLogDao.selectStockLogList(stockLogBO);
	}

	private StockLogBO setStockLogBO(String companyCode, String storeCode) {
		StockLogBO stockLogBO = new StockLogBO();
		stockLogBO.setCompanyCode(companyCode);
		stockLogBO.setStoreCode(storeCode);
		return stockLogBO;
	}

}
