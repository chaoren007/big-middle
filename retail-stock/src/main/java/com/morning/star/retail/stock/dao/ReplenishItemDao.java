package com.morning.star.retail.stock.dao;

import org.apache.ibatis.session.RowBounds;

import com.github.pagehelper.Page;
import com.morning.star.retail.facade.dto.replenish.ReplenishItemQueryDTO;
import com.morning.star.retail.facade.dto.replenish.ReplenishItemSimpleDTO;

public interface ReplenishItemDao {

    Page<ReplenishItemSimpleDTO> getReplenishItemList(ReplenishItemQueryDTO replenishVO, RowBounds rowBounds);
}
