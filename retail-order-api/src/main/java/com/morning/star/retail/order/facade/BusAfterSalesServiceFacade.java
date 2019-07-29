package com.morning.star.retail.order.facade;

import com.morning.star.retail.order.facade.dto.BusAfterSalesDTO;
import com.morning.star.retail.order.facade.dto.BusAfterSalesQueryDTO;
import com.morning.star.retail.utils.page.PageBean;

/**
 * Created by liangguobin on 2017/5/18.
 */
public interface BusAfterSalesServiceFacade {

    PageBean<BusAfterSalesDTO> getBusAfterSales(BusAfterSalesQueryDTO busAfterSalesQueryDTO);

    void confirm(String afterSalesCode);
}
