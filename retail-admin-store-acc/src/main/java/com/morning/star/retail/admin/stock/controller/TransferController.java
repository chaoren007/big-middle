package com.morning.star.retail.admin.stock.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.morning.star.retail.admin.util.AdminController;
import com.morning.star.retail.admin.util.WebBean;
import com.morning.star.retail.base.poi.ExcelUtil;
import com.morning.star.retail.bean.AdminLoginContent;
import com.morning.star.retail.exception.RetailErrorCode;
import com.morning.star.retail.facade.TransferFacade;
import com.morning.star.retail.stock.dto.TransferDTO;
import com.morning.star.retail.stock.dto.TransferExportDTO;
import com.morning.star.retail.stock.dto.TransferFormDTO;
import com.morning.star.retail.stock.dto.TransferItemDTO;
import com.morning.star.retail.stock.dto.TransferQueryDTO;
import com.morning.star.retail.util.MultipartFileWrapper;
import com.morning.star.retail.util.UniqueNoUtils;
import com.morning.star.retail.utils.page.PageBean;
import com.morning.star.retail.validate.CreateGroup;
import com.morning.star.retail.validate.DetailGroup;
import com.morning.star.retail.validate.Validate;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 库存调拨
 *
 * @author jiangyf
 * @date 2018/3/13
 */
@Api(tags = "库存调拨")
@RestController
@RequestMapping("/api/transfer/")
public class TransferController extends AdminController {

    @Autowired
    private TransferFacade facade;

    @ApiOperation(value = "库存调拨-列表")
    @RequestMapping(value = "list", method = RequestMethod.GET)
    @RequiresPermissions(value = {"transfer:list_all", "transfer:list_draft", "transfer:list_wait_audit",
            "transfer:list_audit_success", "transfer:list_audit_reject"}, logical = Logical.OR)
    public WebBean<PageBean<TransferDTO>> list(TransferQueryDTO queryDTO) {
        AdminLoginContent content = getLoginAdmin();
        queryDTO.setGroupCode(content.getGroupCode());
        queryDTO.setReceiverCode(content.getStoreCode());
        return WebBean.ok(facade.pageQuery(queryDTO));
    }

    @ApiOperation(value = "库存调拨-详情")
    @RequestMapping(value = "get", method = RequestMethod.GET)
    @RequiresPermissions(value = "transfer:get")
    @Validate(groups = DetailGroup.class)
    public WebBean<TransferDTO> get(TransferQueryDTO queryDTO) {
        queryDTO.setGroupCode(getLoginAdmin().getGroupCode());
        return WebBean.ok(facade.get(queryDTO));
    }

    @ApiOperation(value = "库存调拨-生成单号")
    @RequestMapping(value = "generateCode", method = RequestMethod.GET)
    public WebBean<TransferDTO> generateCode() {
        AdminLoginContent content = getLoginAdmin();
        TransferDTO orderDTO = new TransferDTO();
        orderDTO.setTransferCode(UniqueNoUtils.next(UniqueNoUtils.UniqueNoType.DB));
        orderDTO.setReceiverCode(content.getStoreCode());
        orderDTO.setReceiverName(content.getStoreName());
        return WebBean.ok(orderDTO);
    }

    @ApiOperation(value = "库存调拨-保存草稿")
    @RequestMapping(value = "saveDraft", method = RequestMethod.POST)
    @RequiresPermissions(value = "transfer:draft")
    @Validate(groups = CreateGroup.class)
    public WebBean<Boolean> saveDraft(@RequestBody TransferFormDTO formDTO) {
        return WebBean.ok(facade.saveDraft(TransferFormDTO.supply(formDTO, getLoginAdmin())));
    }

    @ApiOperation(value = "库存调拨-提交审核")
    @RequestMapping(value = "submit", method = RequestMethod.POST)
    @RequiresPermissions(value = "transfer:submit")
    @Validate(groups = CreateGroup.class)
    public WebBean<Boolean> submit(@RequestBody TransferFormDTO formDTO) {
        return WebBean.ok(facade.submit(TransferFormDTO.supply(formDTO, getLoginAdmin())));
    }

    @ApiOperation(value = "库存调拨-删除")
    @RequestMapping(value = "delete", method = RequestMethod.POST)
    @RequiresPermissions(value = "transfer:delete")
    @Validate
    public WebBean<Boolean> delete(@RequestBody TransferFormDTO formDTO) {
        formDTO.setGroupCode(getLoginAdmin().getGroupCode());
        return WebBean.ok(facade.delete(formDTO));
    }

    @ApiOperation(value = "库存调拨-导出")
    @RequestMapping(value = "export", method = RequestMethod.GET)
    @RequiresPermissions(value = "transfer:export")
    @Validate
    public void export(@RequestParam(value = "transferCode", required = true) String transferCode, HttpServletResponse response) {
        List<TransferExportDTO> dataList = facade.queryExportData(TransferQueryDTO.of(transferCode, getLoginAdmin()));
        try {
            new ExcelUtil<>(TransferExportDTO.class).writeToHttpResponse(dataList, "导出调拨商品.xlsx", "调拨商品", response);
        } catch (Exception e) {
            throw RetailErrorCode.EXPORT_EXCEL_ERROR.build();
        }
    }

    @ApiOperation(value = "库存调拨-导入")
    @RequestMapping(value = "getImportData", method = RequestMethod.POST)
    @RequiresPermissions(value = "transfer:import")
    public WebBean<List<TransferItemDTO>> getImportData(@RequestParam MultipartFile importFile) {
        MultipartFileWrapper fileWrapper = null;
        try {
            fileWrapper = MultipartFileWrapper.of(importFile);
        } catch (Exception e) {
            throw RetailErrorCode.UPLOAD_FILE_CONTENT_ERROR.build();
        }
        return WebBean.ok(facade.getImportData(fileWrapper, getLoginAdmin()));
    }

}
