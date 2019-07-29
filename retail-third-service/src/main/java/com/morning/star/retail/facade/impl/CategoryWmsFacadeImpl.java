package com.morning.star.retail.facade.impl;

import com.morning.star.retail.application.ThirdServiceBaseApplication;
import com.morning.star.retail.facade.CategoryWmsFacade;
import com.morning.star.retail.facade.dto.CategoryWmsDTO;
import com.morning.star.retail.validate.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryWmsFacadeImpl implements CategoryWmsFacade {

	@Autowired
	private ThirdServiceBaseApplication thirdServiceBaseApplication;

	@Override
	@Validate
	public void add(CategoryWmsDTO dto) {
		thirdServiceBaseApplication.addCategory(dto);
	}
}
