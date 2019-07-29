package com.morning.star.retail.stock.dao;

import com.github.pagehelper.Page;
import com.morning.star.retail.facade.dto.out.OutStockDTO;
import com.morning.star.retail.facade.dto.out.OutStockQueryDTO;
import org.apache.ibatis.session.RowBounds;

/**
 * 库存出库单
 */
public interface OutStockDAO {
	Page<OutStockDTO> queryPage(OutStockQueryDTO queryDTO, RowBounds rowBounds);
}
