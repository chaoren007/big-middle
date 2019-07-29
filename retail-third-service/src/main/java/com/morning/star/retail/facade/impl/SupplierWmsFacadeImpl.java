package com.morning.star.retail.facade.impl;

import com.morning.star.retail.application.ThirdServiceBaseApplication;
import com.morning.star.retail.facade.SupplierWmsFacade;
import com.morning.star.retail.facade.dto.SupplierWmsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class SupplierWmsFacadeImpl implements SupplierWmsFacade {
	@Autowired
	private ThirdServiceBaseApplication thirdServiceBaseApplication;

	@Override
	public void add(SupplierWmsDTO dto) {
		dto.setPushType("S");
		thirdServiceBaseApplication.addPersonnel(dto);
	}
}
