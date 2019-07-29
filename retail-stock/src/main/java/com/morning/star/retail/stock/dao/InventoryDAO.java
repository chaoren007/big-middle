package com.morning.star.retail.stock.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import com.github.pagehelper.Page;
import com.morning.star.retail.stock.dto.InventoryDTO;
import com.morning.star.retail.stock.dto.InventoryItemDTO;
import com.morning.star.retail.stock.dto.InventoryItemQueryDTO;
import com.morning.star.retail.stock.dto.InventoryItemWaterDTO;
import com.morning.star.retail.stock.dto.InventoryQueryDTO;
import com.morning.star.retail.stock.dto.InventoryStatDTO;
import com.morning.star.retail.stock.dto.InventoryStatementItemDTO;
import com.morning.star.retail.stock.dto.InventoryStatementQueryDTO;
import com.morning.star.retail.stock.dto.InventoryWaterDTO;

public interface InventoryDAO {

    Page<InventoryDTO> queryByPage(InventoryQueryDTO queryDTO, RowBounds rowBounds);

    List<InventoryWaterDTO> queryWater(@Param("inventoryCode") String inventoryCode);

    List<InventoryItemDTO> queryItem(InventoryItemQueryDTO queryDTO);

    Page<InventoryItemDTO> queryItemByPage(InventoryItemQueryDTO queryDTO, RowBounds rowBounds);

    Page<InventoryItemWaterDTO> queryItemWater(InventoryItemQueryDTO queryDTO, RowBounds rowBounds);

    Page<InventoryStatementItemDTO> queryStatementItemByPage(InventoryStatementQueryDTO queryDTO, RowBounds rowBounds);

    InventoryStatDTO queryStat(@Param("inventoryCode") String inventoryCode);
}
