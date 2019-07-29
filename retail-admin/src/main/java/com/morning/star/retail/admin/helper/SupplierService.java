package com.morning.star.retail.admin.helper;

import com.morning.star.retail.dto.SupplierDTO;
import com.morning.star.retail.dto.store.StoreDTO;
import com.morning.star.retail.facade.SupplierFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SupplierService {

	@Autowired
	private SupplierFacade supplierFacade;


	public SupplierDTO get(String code) {
		return supplierFacade.get(code);
	}

}