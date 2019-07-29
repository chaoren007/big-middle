package com.morning.star.retail.facade.impl;

import com.morning.star.retail.application.ThirdServiceBaseApplication;
import com.morning.star.retail.facade.StorageWmsFacade;
import com.morning.star.retail.facade.dto.StorageWmsDTO;
import com.morning.star.retail.validate.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StorageWmsFacadeImpl implements StorageWmsFacade {
	@Autowired
	private ThirdServiceBaseApplication thirdServiceBaseApplication;

	@Override
	@Validate
	public void add(StorageWmsDTO dto) {
		thirdServiceBaseApplication.addStorage(dto);
	}
}
