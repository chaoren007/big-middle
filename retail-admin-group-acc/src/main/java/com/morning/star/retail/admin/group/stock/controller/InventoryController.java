package com.morning.star.retail.admin.group.stock.controller;

import java.util.List;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.morning.star.retail.admin.util.AdminController;
import com.morning.star.retail.admin.util.WebBean;
import com.morning.star.retail.facade.InventoryFacade;
import com.morning.star.retail.stock.dto.InventoryAdjustDTO;
import com.morning.star.retail.stock.dto.InventoryDTO;
import com.morning.star.retail.stock.dto.InventoryItemQueryDTO;
import com.morning.star.retail.stock.dto.InventoryItemWaterDTO;
import com.morning.star.retail.stock.dto.InventoryQueryDTO;
import com.morning.star.retail.stock.dto.InventoryStatementDTO;
import com.morning.star.retail.stock.dto.InventoryStatementItemDTO;
import com.morning.star.retail.stock.dto.InventoryStatementQueryDTO;
import com.morning.star.retail.stock.dto.InventoryWaterDTO;
import com.morning.star.retail.utils.page.PageBean;
import com.morning.star.retail.validate.Validate;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "盘点接口")
@RestController
@RequestMapping("/api/inventory")
public class InventoryController extends AdminController {

    @Autowired
    private InventoryFacade inventoryFacade;

    @ApiOperation(value = "盘点列表")
    @RequestMapping(value = "list", method = RequestMethod.GET)
    @RequiresPermissions("inventory:list")
    public WebBean<PageBean<InventoryDTO>> list(InventoryQueryDTO queryDTO) {
        queryDTO.setGroupCode(getLoginAdmin().getGroupCode());
        return WebBean.ok(inventoryFacade.list(queryDTO));
    }

    @ApiOperation(value = "盘点详情")
    @RequestMapping(value = "get", method = RequestMethod.GET)
    @RequiresPermissions("inventory:get")
    @Validate
    public WebBean<InventoryDTO> get(InventoryItemQueryDTO queryDTO) {
        return WebBean.ok(inventoryFacade.get(queryDTO));
    }

    @ApiOperation(value = "盘点调整-列表")
    @RequestMapping(value = "adjust/list", method = RequestMethod.GET)
    @RequiresPermissions("inventory-adjust:query")
    @Validate
    public WebBean<List<InventoryAdjustDTO>> list(@RequestParam(value = "inventoryCode", required = true) String inventoryCode, @RequestParam(value = "goodsCode", required = true) String goodsCode) {
        return WebBean.ok(inventoryFacade.queryAdjust(inventoryCode, goodsCode));
    }

    @ApiOperation(value = "盘点长短单-列表")
    @RequestMapping(value = "statement/list", method = RequestMethod.GET)
    @RequiresPermissions("inventory-statement:list")
    public WebBean<List<InventoryStatementDTO>> queryStatement(@RequestParam(required = true) String inventoryCode) {
        return WebBean.ok(inventoryFacade.queryStatement(inventoryCode));
    }

    @ApiOperation(value = "盘点长短单明细-列表")
    @RequestMapping(value = "statement/item/list", method = RequestMethod.GET)
    @RequiresPermissions("inventory-statement-item:list")
    @Validate
    public WebBean<PageBean<InventoryStatementItemDTO>> queryStatementItem(InventoryStatementQueryDTO queryDTO) {
        return WebBean.ok(inventoryFacade.queryStatementItem(queryDTO));
    }

    @ApiOperation(value = "盘点操作历史")
    @RequestMapping(value = "water", method = RequestMethod.GET)
    @RequiresPermissions("inventory:water")
    @Validate
    public WebBean<List<InventoryWaterDTO>> water(@RequestParam(required = true) String inventoryCode) {
        return WebBean.ok(inventoryFacade.queryWater(inventoryCode));
    }

    @ApiOperation(value = "盘点明细操作历史")
    @RequestMapping(value = "item/water", method = RequestMethod.GET)
    @RequiresPermissions("inventory-item:water")
    @Validate
    public WebBean<PageBean<InventoryItemWaterDTO>> itemWater(InventoryItemQueryDTO queryDTO) {
        return WebBean.ok(inventoryFacade.queryItemWater(queryDTO));
    }

}
