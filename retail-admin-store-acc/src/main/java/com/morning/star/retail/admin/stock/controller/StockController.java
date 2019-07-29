package com.morning.star.retail.admin.stock.controller;

import com.morning.star.retail.admin.util.AdminController;
import com.morning.star.retail.admin.util.WebBean;
import com.morning.star.retail.base.page.PageBeans;
import com.morning.star.retail.base.poi.ExcelUtil;
import com.morning.star.retail.enums.OriginalType;
import com.morning.star.retail.exception.RetailErrorCode;
import com.morning.star.retail.facade.StockFacade;
import com.morning.star.retail.objectcopier.ObjectCopier;
import com.morning.star.retail.stock.dto.*;
import com.morning.star.retail.stock.enums.EnumObject;
import com.morning.star.retail.stock.enums.StockRecordTypeEnum;
import com.morning.star.retail.stock.enums.StockStatusEnum;
import com.morning.star.retail.validate.ModifyGroup;
import com.morning.star.retail.validate.Validate;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Api(tags = "库存接口")
@RestController
@RequestMapping("/api/stock/")
public class StockController extends AdminController {

    @Autowired
    private StockFacade stockFacade;

    @ApiOperation(value = "库存状态")
    @RequestMapping(value = "status", method = RequestMethod.GET)
    public WebBean<List<EnumObject>> status() {
        return WebBean.ok(StockStatusEnum.getEnumObjects());
    }

    @ApiOperation(value = "库存列表")
    @RequestMapping(value = "list", method = RequestMethod.GET)
    @RequiresPermissions(value = "stock:list")
    public WebBean<PageBeans<StockDTO>> list(StockQueryDTO queryDTO) {
        return WebBean.ok(stockFacade.list(StockQueryDTO.supply(queryDTO, getLoginAdmin())));
    }

    @ApiOperation(value = "修改库存")
    @RequestMapping(value = "modify", method = RequestMethod.POST)
    @RequiresPermissions(value = "stock:modify")
    @Validate(groups = ModifyGroup.class)
    public WebBean<Boolean> modify(@RequestBody StockFormDTO formDTO) {
        formDTO.supply(getLoginAdmin(), StockRecordTypeEnum.MANUAL_MODIFY);
        return WebBean.ok(stockFacade.modify(formDTO));
    }

    @ApiOperation(value = "导出库存")
    @RequestMapping(value = "export", method = RequestMethod.GET)
    @RequiresPermissions(value = "stock:export")
    public void exportStock(String productCode, String productName, String upcCode, Integer stockStatus,
                            Integer pageNo, Integer pageSize, HttpServletResponse response) {
        StockQueryDTO queryDTO = StockQueryDTO.from(productCode, productName, upcCode, stockStatus, pageNo, pageSize, getLoginAdmin());
        PageBeans<StockDTO> page = stockFacade.list(queryDTO);
        List<ExportStockDTO> dataList = ObjectCopier.copyList(ExportStockDTO.class, page.getRecord());
        try {
            new ExcelUtil<>(ExportStockDTO.class).writeToHttpResponse(dataList, "导出库存.xlsx", "库存", response);
        } catch (Exception e) {
            throw RetailErrorCode.EXPORT_EXCEL_ERROR.build();
        }
    }

    @ApiOperation(value = "导入库存")
    @RequestMapping(value = "import", method = RequestMethod.POST)
    @RequiresPermissions(value = "stock:import")
    public WebBean importStock(@RequestParam MultipartFile importFile) {
        List<StockImportDTO> list = new ExcelUtil<>(StockImportDTO.class).readXLSData(importFile, OriginalType.XLSX);
        stockFacade.importStock(list);
        return WebBean.ok();
    }

    @ApiOperation(value = "查询库存")
    @RequestMapping(value = "query", method = RequestMethod.GET)
    public WebBean<List<StockDTO>> query(@RequestParam String keyWord) {
        StockQueryDTO queryDTO = new StockQueryDTO();
        queryDTO.setKeyWord(keyWord);
        return WebBean.ok(stockFacade.query(StockQueryDTO.supply(queryDTO, getLoginAdmin())));
    }
}
