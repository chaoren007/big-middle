package com.morning.star.retail.facade;

import com.morning.star.retail.base.page.PageBeans;
import com.morning.star.retail.dto.SupplierTypeDTO;
import com.morning.star.retail.dto.SupplierTypeQueryDTO;

public interface SupplierTypeFacade {

    void create(SupplierTypeDTO dto);

    void modify(SupplierTypeDTO dto);

    void delete(String code);

    PageBeans<SupplierTypeDTO> list(SupplierTypeQueryDTO queryDTO);

}
