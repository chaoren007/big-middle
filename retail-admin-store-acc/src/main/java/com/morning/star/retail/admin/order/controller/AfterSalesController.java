package com.morning.star.retail.admin.order.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.morning.star.retail.admin.order.controller.command.AuditOrderCommand;
import com.morning.star.retail.admin.order.controller.command.ExamineGoodsCommand;
import com.morning.star.retail.admin.order.controller.command.QueryAfterSalesCommand;
import com.morning.star.retail.admin.util.AdminController;
import com.morning.star.retail.admin.util.BeanUtils;
import com.morning.star.retail.admin.util.WebBean;
import com.morning.star.retail.bean.AdminLoginContent;
import com.morning.star.retail.order.facade.AfterSalesServiceFacade;
import com.morning.star.retail.order.facade.dto.AfterSalesOrderDTO;
import com.morning.star.retail.order.qo.ExamineGoodsQO;
import com.morning.star.retail.utils.page.PageBean;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(tags = "售后接口")
@Controller
@RequestMapping(value = "/api/after-sales")
public class AfterSalesController extends AdminController {

    @Autowired
    private AfterSalesServiceFacade facade;

    @RequiresPermissions(value = "after-sales:query")
    @ApiOperation(value = "售后列表")
	@RequestMapping(value = "/query", method = RequestMethod.GET)
    @ResponseBody
    public WebBean<PageBean<AfterSalesOrderDTO>> listAfterSalesOrders(QueryAfterSalesCommand search) {
	    AdminLoginContent login = getLoginAdmin();
	    search.setGroupCode(login.getGroupCode());
        search.setStoreCode(login.getStoreCode());
        AfterSalesOrderDTO afterSalesOrderDTO = new AfterSalesOrderDTO();
        BeanUtils.copy(search, afterSalesOrderDTO);

        //TODO 刘越群
        List list = new ArrayList();
        PageBean<AfterSalesOrderDTO> dataPage = new PageBean<>(1, list, search.getPageNo(), search.getPageSize(), 1);
        //facade.listAfterSalesOrders(afterSalesOrderDTO);
        return WebBean.ok(dataPage);
    }

    @RequiresPermissions(value = "after-sales:get-by-code")
    @ApiOperation(value = "售后详情")
    @RequestMapping(value = "/get-by-code", method = RequestMethod.GET)
    @ResponseBody
    public WebBean<AfterSalesOrderDTO> AfterSalesDetail(@RequestParam @ApiParam(value = "售后编码", required = true) String afterSalesCode){
        return WebBean.ok(facade.getDetail(afterSalesCode));
    }

    @RequiresPermissions(value = "after-sales:audit")
    @ApiOperation(value = "售后审核")
    @RequestMapping(value = "/audit", method = RequestMethod.POST)
    @ResponseBody
    public WebBean<Void> auditOrder(@RequestBody AuditOrderCommand qo) {
        facade.auditOrder(qo.getAfterSalesCode(), qo.getAgree(), qo.getRemark());
        return WebBean.ok();
    }

    @RequiresPermissions(value = "after-sales:examine")
    @ApiOperation(value = "售后验货")
    @RequestMapping(value = "/examine", method = RequestMethod.POST)
    @ResponseBody
    public WebBean<Void> examineGoods(@RequestBody ExamineGoodsCommand examineGoodsCommand) {
        ExamineGoodsQO examineGoodsQO = new ExamineGoodsQO();
        BeanUtils.copy(examineGoodsCommand, examineGoodsQO);
        facade.examineGoods(examineGoodsQO);
        return WebBean.ok();
    }
}