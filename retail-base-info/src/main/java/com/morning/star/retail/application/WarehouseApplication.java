package com.morning.star.retail.application;

import com.morning.star.retail.dto.WarehouseDTO;
import com.morning.star.retail.dto.WarehouseQueryDTO;

/**
 * 门店
 *
 */
public interface WarehouseApplication {

    String create(WarehouseDTO dto);

    void edit(WarehouseDTO dto);

    void delete(WarehouseQueryDTO dto);
}
