package com.morning.star.retail.admin.group.stock.controller;

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

import com.morning.star.retail.admin.util.AdminController;
import com.morning.star.retail.admin.util.WebBean;
import com.morning.star.retail.base.poi.ExcelUtil;
import com.morning.star.retail.enums.PlatformEnum;
import com.morning.star.retail.exception.RetailErrorCode;
import com.morning.star.retail.facade.TransferFacade;
import com.morning.star.retail.stock.dto.TransferDTO;
import com.morning.star.retail.stock.dto.TransferExportDTO;
import com.morning.star.retail.stock.dto.TransferFormDTO;
import com.morning.star.retail.stock.dto.TransferQueryDTO;
import com.morning.star.retail.utils.page.PageBean;
import com.morning.star.retail.validate.DetailGroup;
import com.morning.star.retail.validate.ModifyGroup;
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
@RequestMapping("/api/group/transfer/")
public class TransferController extends AdminController {

    @Autowired
    private TransferFacade facade;

    @ApiOperation(value = "库存调拨-列表")
    @RequestMapping(value = "list", method = RequestMethod.GET)
    @RequiresPermissions(value = {"transfer:list_all", "transfer:list_wait_audit", "transfer:list_audit_success",
            "transfer:list_audit_reject"}, logical = Logical.OR)
    public WebBean<PageBean<TransferDTO>> list(TransferQueryDTO queryDTO) {
        queryDTO.setPlatform(PlatformEnum.GROUP.getCode());
        queryDTO.setGroupCode(getLoginAdmin().getGroupCode());
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

    @ApiOperation(value = "库存调拨-审核通过")
    @RequestMapping(value = "auditSuccess", method = RequestMethod.POST)
    @RequiresPermissions(value = "transfer:audit_success")
    @Validate(groups = ModifyGroup.class)
    public WebBean<Boolean> auditSuccess(@RequestBody TransferFormDTO formDTO) {
        formDTO.setGroupCode(getLoginAdmin().getGroupCode());
        return WebBean.ok(facade.auditSuccess(formDTO));
    }

    @ApiOperation(value = "库存调拨-审核驳回")
    @RequestMapping(value = "auditReject", method = RequestMethod.POST)
    @RequiresPermissions(value = "transfer:audit_reject")
    @Validate
    public WebBean<Boolean> auditReject(@RequestBody TransferFormDTO formDTO) {
        formDTO.setGroupCode(getLoginAdmin().getGroupCode());
        return WebBean.ok(facade.auditReject(formDTO));
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

}
