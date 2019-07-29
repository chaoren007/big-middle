package com.morning.star.retail.facade;

import com.morning.star.retail.base.page.PageBeans;
import com.morning.star.retail.dto.SupplierChangeDTO;
import com.morning.star.retail.dto.SupplierItemDTO;
import com.morning.star.retail.dto.SupplierQueryDTO;
import com.morning.star.retail.dto.SupplierStoreDTO;
import com.morning.star.retail.utils.page.PageBean;

/**
 * 供应商变更
 */
public interface SupplierChangeFacade {

    void save(SupplierChangeDTO dto);

    void delete(SupplierChangeDTO dto);

    void audit(SupplierChangeDTO dto);

    PageBean<SupplierChangeDTO> list(SupplierQueryDTO queryDTO);

    SupplierChangeDTO get(String code, String groupCode);

    PageBeans<SupplierStoreDTO> listStore(SupplierQueryDTO queryDTO);

    PageBeans<SupplierItemDTO> listItem(SupplierQueryDTO queryDTO);
	
}
