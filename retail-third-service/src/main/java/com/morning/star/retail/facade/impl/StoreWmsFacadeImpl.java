package com.morning.star.retail.facade.impl;

import com.morning.star.retail.application.ThirdServiceBaseApplication;
import com.morning.star.retail.facade.StoreWmsFacade;
import com.morning.star.retail.facade.dto.StoreWmsDTO;
import com.morning.star.retail.validate.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StoreWmsFacadeImpl implements StoreWmsFacade {
	@Autowired
	private ThirdServiceBaseApplication thirdServiceBaseApplication;

	@Override
	@Validate
	public void add(StoreWmsDTO dto) {
		thirdServiceBaseApplication.addStore(dto);
	}
}
