package com.morning.star.retail.order.dao;

import com.github.pagehelper.Page;
import com.morning.star.retail.order.facade.dto.BusAfterSalesDTO;
import com.morning.star.retail.order.facade.dto.BusAfterSalesQueryDTO;
import org.apache.ibatis.session.RowBounds;

/**
 * @Description TODO
 * @Author LiquorSea
 * @Date 2019/3/26 14:30
 **/
public interface BusAfterSalesOrderDAO {
    Page<BusAfterSalesDTO> getBusAfterSales(BusAfterSalesQueryDTO busAfterSalesQueryDTO, RowBounds rowBounds);
}
