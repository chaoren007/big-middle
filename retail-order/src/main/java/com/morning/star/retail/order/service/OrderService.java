package com.morning.star.retail.order.service;

import java.util.Date;
import java.util.List;

import com.morning.star.retail.order.facade.dto.*;
import com.morning.star.retail.order.facade.order.dto.OrderGoodsItemDTO;
import com.morning.star.retail.order.facade.order.req.OrderListReqParams;
import com.morning.star.retail.order.facade.order.req.OrderReqParams;
import com.morning.star.retail.order.facade.order.resp.SalesOrderVO;
import com.morning.star.retail.utils.page.PageBean;

public interface OrderService {

    String posOrder(OrderReqParams params);

    PageBean<SalesOrderVO> querySalesOrderPage(OrderListReqParams orderListReqParams);

    SalesOrderVO getSalesOrder(String orderCode);

    List<OrderGoodsItemDTO> getOrderGoodsItem(String orderCode);

    void test();

    PageBean<BusAfterSalesDTO> getBusAfterSales(BusAfterSalesQueryDTO busAfterSalesQueryDTO);

    /**
     * 统计运营端销售数量和销售额
     */
    void statisticOrder(Date date);

    List<BusOrderStatisticsDTO> getOrderStatistics(BusOrderStatisticsQueryDTO query);

    BusOrderStatusStatisticsDTO statisticOrderStatus();

    List<BusTopItemsDTO> getBusTopItems();
}
