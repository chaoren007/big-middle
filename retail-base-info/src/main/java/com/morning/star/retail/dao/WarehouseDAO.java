package com.morning.star.retail.dao;

import com.morning.star.retail.dto.WarehouseDTO;
import com.morning.star.retail.dto.WarehouseQueryDTO;

import java.util.List;

public interface WarehouseDAO {

	List<WarehouseDTO> list(WarehouseQueryDTO dto);

    List<WarehouseDTO> listcity(String groupCode);

    List<WarehouseDTO> listWarehouse(WarehouseQueryDTO dto);
}
