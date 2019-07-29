package com.morning.star.retail.facade.impl;

import com.morning.star.retail.application.ThirdServiceBaseApplication;
import com.morning.star.retail.facade.CustomerWmsFacade;
import com.morning.star.retail.facade.dto.SupplierWmsDTO;
import com.morning.star.retail.validate.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class CustomerWmsFacadeImpl implements CustomerWmsFacade {
	@Autowired
	private ThirdServiceBaseApplication thirdServiceBaseApplication;

	@Override
	@Validate
	public void add(SupplierWmsDTO dto) {
		dto.setPushType("C");
		thirdServiceBaseApplication.addPersonnel(dto);
	}
}
