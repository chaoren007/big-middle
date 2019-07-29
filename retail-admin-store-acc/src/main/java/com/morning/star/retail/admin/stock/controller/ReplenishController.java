package com.morning.star.retail.admin.stock.controller;

import com.morning.star.retail.admin.util.AdminController;
import com.morning.star.retail.admin.util.WebBean;
import com.morning.star.retail.base.poi.ExcelUtil;
import com.morning.star.retail.bean.AdminLoginContent;
import com.morning.star.retail.bean.WebJsonBean;
import com.morning.star.retail.exception.CODE;
import com.morning.star.retail.exception.RetailErrorCode;
import com.morning.star.retail.facade.ReplenishFacade;
import com.morning.star.retail.facade.dto.replenish.*;
import com.morning.star.retail.stock.dto.ExportReplenishDTO;
import com.morning.star.retail.validate.Validate;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/api/replenish/")
@Api(tags = "补货单接口")
public class ReplenishController extends AdminController {

    @Autowired
    private ReplenishFacade replenishFacade;

    @ApiOperation(value = "提交补货单")
    @RequestMapping(value = "submit", method = RequestMethod.POST)
    @RequiresPermissions(value = {"replenish:submit"})
    @Validate
    public WebBean<String> submit(@RequestBody ReplenishSubmitDTO replenishDTO) {
        replenishDTO.fillLoginUser(getLoginAdmin());
        replenishDTO.setReplenishType(0);
        return WebBean.ok(replenishFacade.submit(replenishDTO));
    }

    @RequestMapping(value = "list", method = RequestMethod.GET)
    @ApiOperation(value = "补货单列表")
    @RequiresPermissions(value = {"replenish:list"})
    public WebJsonBean list(ReplenishQueryDTO queryDTO) {
        AdminLoginContent login = getLoginAdmin();
        queryDTO.setGroupCode(login.getGroupCode());
        queryDTO.setStoreCode(login.getStoreCode());
        return new WebJsonBean(CODE.SUCCESS, replenishFacade.list(queryDTO));
    }

    @RequestMapping(value = "get", method = RequestMethod.GET)
    @ApiOperation(value = "补货单详情")
    @RequiresPermissions(value = {"replenish:get"})
    public WebBean<ReplenishDTO> get(@RequestParam(required = true) String replenishCode) {
        AdminLoginContent login = getLoginAdmin();
        ReplenishQueryDTO queryDTO = new ReplenishQueryDTO();
        queryDTO.setReplenishCode(replenishCode);
        queryDTO.setStoreCode(login.getStoreCode());
        queryDTO.setGroupCode(login.getGroupCode());
        return WebBean.ok(replenishFacade.get(queryDTO));
    }

    @RequestMapping(value = "edit", method = RequestMethod.POST)
    @ApiOperation(value = "补货单修改")
    @Validate
    @RequiresPermissions(value = {"replenish:update"})
    public WebJsonBean modify(@RequestBody ReplenishUpdateDTO replenishDTO) {
        AdminLoginContent login = getLoginAdmin();
        Integer count = replenishFacade.modify(replenishDTO);
        return count > 0 ? success() : fail();
    }

    @RequestMapping(value = "audit/confirm", method = RequestMethod.POST)
    @ApiOperation(value = "补货单审核通过")
    @Validate
    @RequiresPermissions(value = {"replenish:audit_confirm"})
    public WebJsonBean confirm(@RequestBody List<ReplenishAuditDTO> replenishAuditDTOS) {
        AdminLoginContent login = getLoginAdmin();
        Integer count = replenishFacade.confirm(replenishAuditDTOS);
        return count > 0 ? success() : fail();
    }

    @RequestMapping(value = "audit/reject", method = RequestMethod.POST)
    @ApiOperation(value = "补货单审核不通过")
    @Validate
    @RequiresPermissions(value = {"replenish:audit_reject"})
    public WebJsonBean reject(@RequestBody List<ReplenishAuditDTO> replenishAuditDTOS) {
        Integer count = replenishFacade.reject(replenishAuditDTOS);
        return count > 0 ? success() : fail();
    }

    @RequestMapping(value = "export", method = RequestMethod.GET)
    @ApiOperation(value = "补货单导出")
    @RequiresPermissions(value = {"replenish:export"})
    public WebJsonBean export(ReplenishQueryDTO replenishQueryDTO, HttpServletResponse response) {
        AdminLoginContent login = getLoginAdmin();
        replenishQueryDTO.setGroupCode(login.getGroupCode());
        replenishQueryDTO.setStoreCode(login.getStoreCode());

        List<ExportReplenishDTO> list = replenishFacade.getExportData(replenishQueryDTO);
        try {
            new ExcelUtil<>(ExportReplenishDTO.class).writeToHttpResponse(list, "导出补货列表.xlsx", "补货列表", response);
        } catch (Exception e) {
            throw RetailErrorCode.EXPORT_EXCEL_ERROR.build();
        }
        return success();
    }

    @RequestMapping(value = "prepare", method = RequestMethod.POST)
    @ApiOperation(value = "补货单拣货")
    @Validate
    @RequiresPermissions(value = {"replenish:audit_prepare"})
    public WebJsonBean prepareReplenish(@RequestBody ReplenishAuditDTO replenishAuditDTO) {
        Integer returnVale = replenishFacade.prepareReplenish(replenishAuditDTO);
        return success(returnVale);
    }

    @RequestMapping(value = "delivery", method = RequestMethod.POST)
    @ApiOperation(value = "补货单配送")
    @Validate
    @RequiresPermissions(value = {"replenish:audit_delivery"})
    public WebJsonBean deliveryReplenish(@RequestBody ReplenishAuditDTO replenishAuditDTO) {
        Integer returnVale = replenishFacade.deliveryReplenish(replenishAuditDTO);
        return success(returnVale);
    }

}
