package com.morning.star.retail.order.facade;

import com.morning.star.retail.order.facade.dto.BusOrderStatisticsDTO;
import com.morning.star.retail.order.facade.dto.BusOrderStatisticsQueryDTO;
import com.morning.star.retail.order.facade.dto.BusOrderStatusStatisticsDTO;
import com.morning.star.retail.order.facade.dto.BusTopItemsDTO;
import com.morning.star.retail.order.facade.order.req.ApplyRefundReqParams;
import com.morning.star.retail.order.facade.order.req.IndexReqParams;
import com.morning.star.retail.order.facade.order.req.OrderListReqParams;
import com.morning.star.retail.order.facade.order.req.OrderReqParams;
import com.morning.star.retail.order.facade.order.resp.IndexVo;
import com.morning.star.retail.order.facade.order.resp.SalesOrderVO;
import com.morning.star.retail.utils.page.PageBean;

import java.util.Date;
import java.util.List;

public interface OrderFacade {

    String posOrder(OrderReqParams params);

    PageBean<SalesOrderVO> querySalesOrderPage(OrderListReqParams orderListReqParams);

    SalesOrderVO getSalesOrder(String orderCode);

    String refundAmount(ApplyRefundReqParams applyRefundReqParams);

    IndexVo getUpIndex(IndexReqParams reqParams);

    void test();

    List<BusOrderStatisticsDTO> getOrderStatistics(BusOrderStatisticsQueryDTO query);

    void statisticOrder(Date date);

    BusOrderStatusStatisticsDTO statisticOrderStatus();

    List<BusTopItemsDTO> getBusTopItems();
}
