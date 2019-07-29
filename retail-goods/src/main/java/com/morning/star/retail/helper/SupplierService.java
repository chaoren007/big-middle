package com.morning.star.retail.helper;

import com.morning.star.retail.dto.SupplierDTO;
import com.morning.star.retail.facade.SupplierFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author kimhuhg
 * @create_time 2018/11/26 11:44
 */
@Service
public class SupplierService {
	@Autowired
	private SupplierFacade supplierFacade;

	public SupplierDTO get(String supplierCode) {
		return supplierFacade.get(supplierCode);
	}

	public SupplierDTO get(String supplierCode, String groupCode) {
		return supplierFacade.get(supplierCode, groupCode);
	}
}
