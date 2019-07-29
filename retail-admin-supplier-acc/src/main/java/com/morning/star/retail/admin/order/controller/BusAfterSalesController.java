package com.morning.star.retail.admin.order.controller;


import com.morning.star.retail.admin.util.AdminController;
import com.morning.star.retail.admin.util.WebBean;
import com.morning.star.retail.dto.BusSupplyGoodsDetailDTO;
import com.morning.star.retail.facade.SupplierGoodsFacade;
import com.morning.star.retail.order.facade.BusAfterSalesServiceFacade;
import com.morning.star.retail.order.facade.dto.BusAfterSalesDTO;
import com.morning.star.retail.order.facade.dto.BusAfterSalesQueryDTO;
import com.morning.star.retail.utils.page.PageBean;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 后台登录管理
 *
 * @author jiangyf
 */
@Api(tags = {"运营端售后"})
@RestController
@RequestMapping("/api/after_sales/")
public class BusAfterSalesController extends AdminController {
    private Logger LOGGER = LoggerFactory.getLogger(BusAfterSalesController.class);
    @Autowired
    private BusAfterSalesServiceFacade busAfterSalesServiceFacade;

    @Autowired
    private SupplierGoodsFacade supplierGoodsFacade;

    @ApiOperation(value = "售后单列表")
    @RequestMapping(value = "after-sales", method = RequestMethod.GET)
    @ResponseBody
    public WebBean<PageBean<BusAfterSalesDTO>> getBusAfterSales(BusAfterSalesQueryDTO busAfterSalesQueryDTO) {
        PageBean<BusAfterSalesDTO> busAfterSales = busAfterSalesServiceFacade.getBusAfterSales(busAfterSalesQueryDTO);
        return WebBean.ok(busAfterSales);
    }

    @ApiOperation(value = "售后单列表")
    @RequestMapping(value = "after-sales/detail", method = RequestMethod.GET)
    @ResponseBody
    public WebBean<BusAfterSalesDTO> getBusAfterSalesDetail(String afterSalesCode) {
        BusAfterSalesQueryDTO busAfterSalesQueryDTO = new BusAfterSalesQueryDTO();
        busAfterSalesQueryDTO.setPageNo(1);
        busAfterSalesQueryDTO.setPageSize(100);
        busAfterSalesQueryDTO.setAfterSalesCode(afterSalesCode);
        PageBean<BusAfterSalesDTO> busAfterSales = busAfterSalesServiceFacade.getBusAfterSales(busAfterSalesQueryDTO);
        BusAfterSalesDTO record = busAfterSales.getRecord().get(0);
        BusSupplyGoodsDetailDTO supplyGoodsDetail = supplierGoodsFacade.getSupplyGoodsDetail(record.getSupplyCode());
        record.setPrice(supplyGoodsDetail.getSupplyPrice());
        record.setBrandName(supplyGoodsDetail.getUnitName());
        return WebBean.ok(record);
    }


    @ApiOperation(value = "售后单列表")
    @RequestMapping(value = "after-sales/confirm", method = RequestMethod.GET)
    @ResponseBody
    public WebBean<Void> confirm(String afterSalesCode) {
        busAfterSalesServiceFacade.confirm(afterSalesCode);
        return WebBean.ok();
    }
}
