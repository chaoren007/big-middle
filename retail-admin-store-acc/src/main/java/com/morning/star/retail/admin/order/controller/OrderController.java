package com.morning.star.retail.admin.order.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.morning.star.retail.admin.util.AdminController;
import com.morning.star.retail.admin.util.WebBean;
import com.morning.star.retail.bean.WebJsonBean;
import com.morning.star.retail.order.enums.SalesOrderStatus;
import com.morning.star.retail.order.facade.OrderFacade;
import com.morning.star.retail.order.facade.order.req.OrderListReqParams;
import com.morning.star.retail.order.facade.order.resp.SalesOrderVO;
import com.morning.star.retail.utils.page.PageBean;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "订单接口")
@RestController
@RequestMapping(value = "/api/v1")
public class OrderController extends AdminController {
    
    @Autowired
    private OrderFacade orderFacade;


    @ApiOperation(value = "订单状态列表")
    @RequestMapping(value = "/order/status/all", method = RequestMethod.GET)
    public WebJsonBean listOrderStatus() {
        return success(SalesOrderStatus.toList());
    }



    @RequiresPermissions(value = "orders:page")
    @ApiOperation(value = "订单列表")
    @GetMapping(value = "/orders")
    public WebBean<PageBean<SalesOrderVO>> listOrder(OrderListReqParams search) {
        search.setStoreCode(getLoginAdmin().getStoreCode());
        PageBean<SalesOrderVO> dataPage = orderFacade.querySalesOrderPage(search);
        return WebBean.ok(dataPage);
    }



    @ApiOperation(value = "订单详情")
    @GetMapping(value = "/order")
    public WebBean<SalesOrderVO> getOrder(String orderCode) {
        SalesOrderVO salesOrder = orderFacade.getSalesOrder(orderCode);
        return WebBean.ok(salesOrder);
    }


}
