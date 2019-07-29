package com.morning.star.retail.order.facade;

import com.morning.star.retail.order.facade.dto.BusOrderStatisticsDTO;
import com.morning.star.retail.order.facade.dto.BusOrderStatisticsQueryDTO;
import com.morning.star.retail.order.facade.dto.BusOrderStatusStatisticsDTO;
import com.morning.star.retail.order.facade.dto.BusTopItemsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.morning.star.retail.order.facade.order.req.ApplyRefundReqParams;
import com.morning.star.retail.order.facade.order.req.IndexReqParams;
import com.morning.star.retail.order.facade.order.req.OrderListReqParams;
import com.morning.star.retail.order.facade.order.req.OrderReqParams;
import com.morning.star.retail.order.facade.order.resp.IndexVo;
import com.morning.star.retail.order.facade.order.resp.SalesOrderVO;
import com.morning.star.retail.order.service.ApplyRefundService;
import com.morning.star.retail.order.service.IndexService;
import com.morning.star.retail.order.service.OrderService;
import com.morning.star.retail.utils.page.PageBean;

import java.util.Date;
import java.util.List;

@Service
public class OrderFacadeImpl implements OrderFacade {

    @Autowired
    OrderService orderService;

    @Autowired
    IndexService indexService;

    @Autowired
    ApplyRefundService applyRefundService;

    @Override
    public String posOrder(OrderReqParams params) {
        return orderService.posOrder(params);
    }

    @Override
    public PageBean<SalesOrderVO> querySalesOrderPage(OrderListReqParams orderListReqParams) {
        return orderService.querySalesOrderPage(orderListReqParams);
    }

    @Override
    public SalesOrderVO getSalesOrder(String orderCode) {
        return orderService.getSalesOrder(orderCode);
    }

    @Override
    public String refundAmount(ApplyRefundReqParams applyRefundReqParams) {
        return applyRefundService.refundAmount(applyRefundReqParams);
    }

    @Override
    public IndexVo getUpIndex(IndexReqParams reqParams) {
        return indexService.getUpIndex(reqParams);
    }

    @Override
    public void test() {
        orderService.test();
    }

    @Override
    public List<BusOrderStatisticsDTO> getOrderStatistics(BusOrderStatisticsQueryDTO query) {

        return orderService.getOrderStatistics(query);
    }

    @Override
    public void statisticOrder(Date date) {
        orderService.statisticOrder(date);
    }

    @Override
    public BusOrderStatusStatisticsDTO statisticOrderStatus() {
        return orderService.statisticOrderStatus();
    }

    @Override
    public List<BusTopItemsDTO> getBusTopItems() {
        return orderService.getBusTopItems();
    }
}
