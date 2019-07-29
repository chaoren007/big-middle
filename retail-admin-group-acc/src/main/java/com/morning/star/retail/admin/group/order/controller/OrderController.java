package com.morning.star.retail.admin.group.order.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.morning.star.retail.admin.util.AdminController;
import com.morning.star.retail.admin.util.WebBean;
import com.morning.star.retail.bean.AdminLoginContent;
import com.morning.star.retail.order.enums.SalesOrderStatus;
import com.morning.star.retail.order.facade.OrderFacade;
import com.morning.star.retail.order.facade.order.req.OrderListReqParams;
import com.morning.star.retail.order.facade.order.resp.SalesOrderVO;
import com.morning.star.retail.util.Json;
import com.morning.star.retail.utils.page.PageBean;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RequestMapping("api/v1")
@RestController
@Api(tags = "订单服务v1")
public class OrderController extends AdminController {

    @Autowired
    private OrderFacade orderFacade;

    private static final Logger logger = LoggerFactory.getLogger(OrderController.class);

    /**
     * 订单列表
     *
     * @param orderListReqParams
     * @return
     */
    @RequiresPermissions(value = "orders:page")
    @ApiOperation(value = "订单列表")
    @GetMapping("/orders")
    public WebBean<PageBean<SalesOrderVO>> getOrders(OrderListReqParams orderListReqParams) {
        AdminLoginContent login = getLoginAdmin();
        String groupCode = login.getGroupCode();
        orderListReqParams.setGroupCode(groupCode);

        logger.info("getOrders========================"+ Json.toJson(orderListReqParams));

        PageBean<SalesOrderVO> salesOrderDTOPageBean = orderFacade.querySalesOrderPage(orderListReqParams);
        return WebBean.ok(salesOrderDTOPageBean);
    }


    /**
     * 订单详情
     *
     * @param orderCode
     * @return
     */
    @ApiOperation(value = "订单详情")
    @GetMapping("/order")
    public WebBean<SalesOrderVO> getOrder(String orderCode) {
        SalesOrderVO salesOrder = orderFacade.getSalesOrder(orderCode);
        return WebBean.ok(salesOrder);
    }

    /**
     * 订单的所有状态
     *
     * @return
     */
    @ApiOperation(value = "订单的所有状态")
    @GetMapping("/order/status")
    public WebBean<Object> getOrderStatus() {
        return WebBean.ok(JSON.toJSON(SalesOrderStatus.toList()));
    }

}
