package com.morning.star.retail.admin.group.stock.controller;

import com.morning.star.retail.admin.util.AdminController;
import com.morning.star.retail.base.page.PageBeans;
import com.morning.star.retail.base.poi.ExcelUtil;
import com.morning.star.retail.bean.WebJsonBean;
import com.morning.star.retail.exception.RetailErrorCode;
import com.morning.star.retail.facade.StockFacade;
import com.morning.star.retail.objectcopier.ObjectCopier;
import com.morning.star.retail.stock.dto.ExportStockDTO;
import com.morning.star.retail.stock.dto.StockDTO;
import com.morning.star.retail.stock.dto.StockQueryDTO;
import com.morning.star.retail.stock.enums.StockStatusEnum;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
    public WebJsonBean status() {
        return success(StockStatusEnum.getEnumObjects());
    }

    @ApiOperation(value = "库存列表")
    @RequestMapping(value = "list", method = RequestMethod.GET)
    @RequiresPermissions(value = "stock:list")
    public WebJsonBean list(StockQueryDTO queryDTO) {
        return success(stockFacade.list(StockQueryDTO.supply(queryDTO, getLoginAdmin())));
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
}
