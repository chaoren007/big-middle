package com.morning.star.retail.stock.dao;

import com.github.pagehelper.Page;
import com.morning.star.retail.facade.dto.replenish.ReplenishDTO;
import com.morning.star.retail.facade.dto.replenish.ReplenishQueryDTO;
import org.apache.ibatis.session.RowBounds;


public interface ReplenishDao {

    Page<ReplenishDTO> queryPage(ReplenishQueryDTO queryDTO, RowBounds rowBounds);

}
