package com.morning.star.retail.facade.impl;

import com.morning.star.retail.application.ThirdServiceStockApplication;
import com.morning.star.retail.facade.MoveStockWmsFacade;
import com.morning.star.retail.facade.dto.MoveStockWmsDTO;
import com.morning.star.retail.validate.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MoveStockWmsFacadeImpl implements MoveStockWmsFacade {
	@Autowired
	private ThirdServiceStockApplication thirdServiceStockApplication;

	@Override
	@Validate
	public Integer add(MoveStockWmsDTO dto) {
		return thirdServiceStockApplication.addMoveStock(dto);
	}
}
