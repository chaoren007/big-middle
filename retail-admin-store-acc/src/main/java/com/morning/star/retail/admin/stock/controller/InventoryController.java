package com.morning.star.retail.admin.stock.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.morning.star.retail.admin.util.AdminController;
import com.morning.star.retail.admin.util.WebBean;
import com.morning.star.retail.base.poi.ExcelUtil;
import com.morning.star.retail.bean.AdminLoginContent;
import com.morning.star.retail.facade.InventoryFacade;
import com.morning.star.retail.stock.dto.ExportInventoryItemDTO;
import com.morning.star.retail.stock.dto.InventoryAdjustDTO;
import com.morning.star.retail.stock.dto.InventoryCodeDTO;
import com.morning.star.retail.stock.dto.InventoryDTO;
import com.morning.star.retail.stock.dto.InventoryFormDTO;
import com.morning.star.retail.stock.dto.InventoryItemQueryDTO;
import com.morning.star.retail.stock.dto.InventoryItemWaterDTO;
import com.morning.star.retail.stock.dto.InventoryQueryDTO;
import com.morning.star.retail.stock.dto.InventoryStatementDTO;
import com.morning.star.retail.stock.dto.InventoryStatementItemDTO;
import com.morning.star.retail.stock.dto.InventoryStatementQueryDTO;
import com.morning.star.retail.stock.dto.InventoryWaterDTO;
import com.morning.star.retail.util.UniqueNoUtils;
import com.morning.star.retail.utils.page.PageBean;
import com.morning.star.retail.validate.Validate;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "盘点接口")
@RestController
@RequestMapping("/api/inventory/")
public class InventoryController extends AdminController {

    @Autowired
    private InventoryFacade inventoryFacade;

    @ApiOperation(value = "生成盘点编码")
    @RequestMapping(value = "code", method = RequestMethod.GET)
    public WebBean<String> code() {
        return WebBean.ok(UniqueNoUtils.next(UniqueNoUtils.UniqueNoType.PD));
    }

    @ApiOperation(value = "创建盘点单")
    @RequestMapping(value = "create", method = RequestMethod.POST)
    @Validate
    @RequiresPermissions("inventory:create")
    public WebBean<String> create(@RequestBody InventoryFormDTO formDTO) {
        inventoryFacade.create(formDTO);
        return WebBean.ok();
    }

    @ApiOperation(value = "盘点列表")
    @RequestMapping(value = "list", method = RequestMethod.GET)
    @RequiresPermissions("inventory:list")
    public WebBean<PageBean<InventoryDTO>> list(InventoryQueryDTO queryDTO) {
        AdminLoginContent content = getLoginAdmin();
        queryDTO.setStoreCode(content.getStoreCode());
        queryDTO.setGroupCode(content.getGroupCode());
        return WebBean.ok(inventoryFacade.list(queryDTO));
    }

    @ApiOperation(value = "盘点详情")
    @RequestMapping(value = "get", method = RequestMethod.GET)
    @RequiresPermissions("inventory:get")
    @Validate
    public WebBean<InventoryDTO> get(InventoryItemQueryDTO queryDTO) {
        return WebBean.ok(inventoryFacade.get(queryDTO));
    }

    @ApiOperation(value = "阅读盘点单")
    @RequestMapping(value = "read", method = RequestMethod.POST)
    @RequiresPermissions("inventory:read")
    public WebBean<Integer> batchRead(@RequestBody InventoryCodeDTO dto) {
        String storeCode = getLoginAdmin().getStoreCode();
        return WebBean.ok(inventoryFacade.batchRead(dto.getInventoryCode(), storeCode));
    }

    @ApiOperation(value = "盘点扎帐")
    @RequestMapping(value = "stash", method = RequestMethod.POST)
    @RequiresPermissions("inventory:stash")
    public WebBean<Void> stash(@RequestBody InventoryCodeDTO dto) {
        inventoryFacade.stash(dto.getInventoryCode());
        return WebBean.ok();
    }

    @ApiOperation(value = "导出全部盘点结果")
    @RequestMapping(value = "export-all", method = RequestMethod.GET)
    @RequiresPermissions("inventory:export-all")
    public WebBean<Void> queryExportItemAll(InventoryCodeDTO dto, HttpServletResponse response) {
        String storeCode = getLoginAdmin().getStoreCode();
        List<ExportInventoryItemDTO> list = inventoryFacade.queryExportAllItem(dto.getInventoryCode(), storeCode);
        try {
            new ExcelUtil<>(ExportInventoryItemDTO.class).writeToHttpResponse(list, dto.getInventoryCode() + "全部明细.xls", "全部明细", response);
        } catch (Exception e) {
            throw new RuntimeException("导出全部盘点结果错误");
        }
        return WebBean.ok();
    }

    @ApiOperation(value = "导出异常盘点结果")
    @RequestMapping(value = "export-warn", method = RequestMethod.GET)
    @RequiresPermissions("inventory:export-warn")
    public WebBean<Void> queryExportItemWarn(InventoryCodeDTO dto, HttpServletResponse response) {
        String storeCode = getLoginAdmin().getStoreCode();
        List<ExportInventoryItemDTO> list = inventoryFacade.queryExportWarnItem(dto.getInventoryCode(), storeCode);
        try {
            new ExcelUtil<>(ExportInventoryItemDTO.class).writeToHttpResponse(list, dto.getInventoryCode() + "异常明细.xls", "异常明细", response);
        } catch (Exception e) {
            throw new RuntimeException("导出异常盘点结果错误");
        }

        return WebBean.ok();
    }

    @ApiOperation(value = "导出漏盘盘点结果")
    @RequestMapping(value = "export-loss", method = RequestMethod.GET)
    @RequiresPermissions("inventory:export-loss")
    public WebBean<Void> queryExportItemLoss(InventoryCodeDTO dto, HttpServletResponse response) {
        String storeCode = getLoginAdmin().getStoreCode();
        List<ExportInventoryItemDTO> list = inventoryFacade.queryExportLossItem(dto.getInventoryCode(), storeCode);
        try {
            new ExcelUtil<>(ExportInventoryItemDTO.class).writeToHttpResponse(list, dto.getInventoryCode() + "漏盘明细.xls", "漏盘明细", response);
        } catch (Exception e) {
            throw new RuntimeException("导出漏盘盘点结果错误");
        }
        return WebBean.ok();
    }

    @ApiOperation(value = "盘点调整-创建")
    @RequestMapping(value = "adjust/crate", method = RequestMethod.POST)
    @RequiresPermissions("inventory-adjust:create")
    @Validate
    public WebBean createAdjust(@RequestBody InventoryAdjustDTO dto) {
        inventoryFacade.createAdjust(dto);
        return WebBean.ok();
    }

    @ApiOperation(value = "盘点调整-列表")
    @RequestMapping(value = "adjust/list", method = RequestMethod.GET)
    @RequiresPermissions("inventory-adjust:query")
    @Validate
    public WebBean<List<InventoryAdjustDTO>> list(@RequestParam(value = "inventoryCode", required = true) String inventoryCode, @RequestParam(value = "goodsCode", required = true) String goodsCode) {
        return WebBean.ok(inventoryFacade.queryAdjust(inventoryCode, goodsCode));
    }

    @ApiOperation(value = "盘点长短单-生成")
    @RequestMapping(value = "statement/create", method = RequestMethod.POST)
    @RequiresPermissions("inventory-statement:create")
    public WebBean<Void> createStatement(@RequestBody InventoryCodeDTO dto) {
        inventoryFacade.createStatement(dto.getInventoryCode(), false);
        return WebBean.ok();
    }

    @ApiOperation(value = "盘点长短单-正式生成")
    @RequestMapping(value = "statement/formal", method = RequestMethod.POST)
    @RequiresPermissions("inventory-statement:formal")
    public WebBean<Void> formalStatement(@RequestBody InventoryCodeDTO dto) {
        inventoryFacade.createStatement(dto.getInventoryCode(), true);
        return WebBean.ok();
    }

    @ApiOperation(value = "盘点长短单-确认")
    @RequestMapping(value = "statement/confirm", method = RequestMethod.POST)
//    @RequiresPermissions("inventory-statement:confirm")
    public WebBean<Void> confirmStatement(@RequestBody InventoryCodeDTO dto) {
        inventoryFacade.confirmStatement(dto.getInventoryCode());
        return WebBean.ok();
    }

    @ApiOperation(value = "盘点长短单-取消确认")
    @RequestMapping(value = "statement/cancel", method = RequestMethod.POST)
    @RequiresPermissions("inventory-statement:cancel")
    public WebBean<Void> cancelStatement(@RequestBody InventoryCodeDTO dto) {
        inventoryFacade.cancelStatement(dto.getInventoryCode());
        return WebBean.ok();
    }

    @ApiOperation(value = "盘点长短单-存档")
    @RequestMapping(value = "statement/archive", method = RequestMethod.POST)
    @RequiresPermissions("inventory-statement:archive")
    public WebBean<Void> archiveStatement(@RequestBody InventoryCodeDTO dto) {
        inventoryFacade.archiveStatement(dto.getInventoryCode());
        return WebBean.ok();
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
