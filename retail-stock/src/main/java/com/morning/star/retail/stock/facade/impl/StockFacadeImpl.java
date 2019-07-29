package com.morning.star.retail.stock.facade.impl;

import com.github.pagehelper.PageHelper;
import com.morning.star.retail.base.page.PageBeans;
import com.morning.star.retail.facade.StockFacade;
import com.morning.star.retail.stock.application.StockApplication;
import com.morning.star.retail.stock.dao.StockDAO;
import com.morning.star.retail.stock.dto.*;
import com.morning.star.retail.stock.enums.StockRecordTypeEnum;
import com.morning.star.retail.stock.listener.mq.ImportStockQueue;
import com.morning.star.retail.stock.logicservice.StockLogicService;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StockFacadeImpl implements StockFacade {

	@Autowired
	private StockDAO stockDAO;
	@Autowired
	private StockApplication stockApplication;
	@Autowired
	private StockLogicService stockLogicService;

	@Override
	public StockDTO get(StockQueryDTO queryDTO) {
		return stockApplication.get(queryDTO);
	}

	@Override
	public List<StockDTO> query(StockQueryDTO queryDTO) {
		return stockDAO.query(queryDTO);
	}

	@Override
	public PageBeans<StockDTO> list(StockQueryDTO queryDTO) {
		PageHelper.startPage(queryDTO.getPageNo(), queryDTO.getPageSize());
		List<StockDTO> list = stockDAO.queryForPage(queryDTO);
		PageBeans<StockDTO> pageBean = new PageBeans<>(list);
		return pageBean;
	}

	@Override
	public boolean modify(StockFormDTO formDTO) {
		return stockApplication.modify(formDTO);
	}

	@Override
	public boolean save(StockFormDTO formDTO) {
		return stockApplication.save(formDTO);
	}

	@Override
	public boolean onlinePreStock(StockOrderDTO dto) {
		return stockLogicService.onlinePreStock(dto);
	}

	@Override
	public boolean checkOnlinePreStock(StockOrderDTO dto) {
		return stockLogicService.checkOnlinePreStock(dto);
	}

	@Override
	public boolean onlineFreeStock(StockOrderDTO dto) {
		return stockLogicService.onlineFreeStock(dto);
	}

	@Override
	public boolean onlineOutStock(StockOrderDTO dto) {
		return stockLogicService.onlineOutStock(dto);
	}

	@Override
	public boolean rejectInStock(StockOrderDTO dto) {
		return stockLogicService.directInStock(dto, StockRecordTypeEnum.REJECT_IN);
	}

	@Override
	public boolean returnInStock(StockOrderDTO dto) {
		return stockLogicService.directInStock(dto, StockRecordTypeEnum.RETURN_IN);
	}

	@Override
	public boolean offlineOutStock(StockOrderDTO dto) {
		return stockLogicService.offlineOutStock(dto);
	}

	@Override
	public void importStock(List<StockImportDTO> list) {
		if (CollectionUtils.isEmpty(list)) {
			return;
		}
		List<StockImportDTO> tmp = new ArrayList<>(500);
		for (int i = 0; i < list.size(); i++) {
			tmp.add(list.get(i));
			if (tmp.size() == 500 || i == list.size() - 1) {
				new ImportStockQueue(tmp).publish();
				tmp.clear();
			}
		}
	}

}
