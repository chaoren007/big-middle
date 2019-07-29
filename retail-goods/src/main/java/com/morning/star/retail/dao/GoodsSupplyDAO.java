package com.morning.star.retail.dao;

import com.github.pagehelper.Page;
import com.morning.star.retail.facade.dto.supply.GoodsSupplyBusDTO;
import com.morning.star.retail.facade.dto.supply.GoodsSupplyDTO;
import com.morning.star.retail.facade.dto.supply.GoodsSupplyQueryDTO;
import org.apache.ibatis.session.RowBounds;

public interface GoodsSupplyDAO {

	Page<GoodsSupplyDTO> page(GoodsSupplyQueryDTO dto, RowBounds rowBounds);

}
