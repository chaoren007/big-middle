package com.morning.star.retail.admin.order.controller;


import com.morning.star.retail.admin.util.AdminController;
import com.morning.star.retail.admin.util.WebBean;
import com.morning.star.retail.dto.BusSupplyGoodsDetailDTO;
import com.morning.star.retail.facade.SupplierGoodsFacade;
import com.morning.star.retail.order.facade.BusAfterSalesServiceFacade;
import com.morning.star.retail.order.facade.OrderFacade;
import com.morning.star.retail.order.facade.dto.*;
import com.morning.star.retail.utils.page.PageBean;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 后台登录管理
 *
 * @author jiangyf
 */
@Api(tags = {"统计"})
@RestController
@RequestMapping("/api/order_statistics/")
public class BusOrderStatisticsController extends AdminController {
    private Logger LOGGER = LoggerFactory.getLogger(BusOrderStatisticsController.class);
    @Autowired
    private OrderFacade orderFacade;

    @ApiOperation(value = "统计状态")
    @RequestMapping(value = "statisticOrderStatus", method = RequestMethod.GET)
    @ResponseBody
    public WebBean<BusOrderStatusStatisticsDTO> statisticOrderStatus() {
        BusOrderStatusStatisticsDTO dto = orderFacade.statisticOrderStatus();
        return WebBean.ok(dto);
    }

    @ApiOperation(value = "热卖商品")
    @RequestMapping(value = "topItems", method = RequestMethod.GET)
    @ResponseBody
    public WebBean<List<BusTopItemsDTO>> getBusTopItems() {
        List<BusTopItemsDTO> result = orderFacade.getBusTopItems();
        return WebBean.ok(result);
    }

    @ApiOperation(value = "销量销售额统计")
    @RequestMapping(value = "orderStatistics", method = RequestMethod.GET)
    @ResponseBody
    public WebBean<List<BusOrderStatisticsDTO>> getOrderStatistics(BusOrderStatisticsQueryDTO dto) {
        List<BusOrderStatisticsDTO> result = orderFacade.getOrderStatistics(dto);
        return WebBean.ok(result);
    }

}
