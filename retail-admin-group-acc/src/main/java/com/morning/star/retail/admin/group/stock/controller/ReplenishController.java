package com.morning.star.retail.admin.group.stock.controller;

import com.morning.star.retail.admin.util.AdminController;
import com.morning.star.retail.admin.util.WebBean;
import com.morning.star.retail.bean.AdminLoginContent;
import com.morning.star.retail.bean.WebJsonBean;
import com.morning.star.retail.exception.CODE;
import com.morning.star.retail.facade.ReplenishFacade;
import com.morning.star.retail.facade.dto.replenish.ReplenishAuditDTO;
import com.morning.star.retail.facade.dto.replenish.ReplenishDTO;
import com.morning.star.retail.facade.dto.replenish.ReplenishQueryDTO;
import com.morning.star.retail.facade.dto.replenish.ReplenishUpdateDTO;
import com.morning.star.retail.validate.Validate;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;

@RestController
@RequestMapping("/api/replenish/")
@Api(tags = "补货单接口")
public class ReplenishController extends AdminController {
    @Autowired
    private ReplenishFacade replenishFacade;

    @RequestMapping(value = "list", method = RequestMethod.GET)
    @ApiOperation(value = "补货单列表")
    @RequiresPermissions(value = {"replenish:list"})
    public WebJsonBean getReplenishList(ReplenishQueryDTO queryDTO) {
        AdminLoginContent login = getLoginAdmin();
        queryDTO.setGroupCode(login.getGroupCode());
        return new WebJsonBean(CODE.SUCCESS, replenishFacade.list(queryDTO));
    }

    @RequestMapping(value = "get", method = RequestMethod.GET)
    @ApiOperation(value = "补货单详情")
    @RequiresPermissions(value = {"replenish:get"})
    public WebBean<ReplenishDTO> get(@RequestParam(required = true) String replenishCode) {
        AdminLoginContent login = getLoginAdmin();
        ReplenishQueryDTO queryDTO = new ReplenishQueryDTO();
        queryDTO.setReplenishCode(replenishCode);
        queryDTO.setGroupCode(login.getGroupCode());
        return WebBean.ok(replenishFacade.get(queryDTO));
    }

    @RequestMapping(value = "edit", method = RequestMethod.POST)
    @ApiOperation(value = "补货单修改")
    @Validate
    @RequiresPermissions(value = {"replenish:update"})
    public WebJsonBean modify(@RequestBody ReplenishUpdateDTO replenishDTO) {
        Integer count = replenishFacade.modify(replenishDTO);
        return count > 0 ? success() : fail();
    }

    @RequestMapping(value = "audit/confirm", method = RequestMethod.POST)
    @ApiOperation(value = "补货单审核通过")
    @Validate
    @RequiresPermissions(value = {"replenish:confirm", "replenish:batch_confirm"}, logical = Logical.OR)
    public WebJsonBean confirm(@RequestBody ReplenishAuditDTO replenishAuditDTO) {
        Integer count = replenishFacade.confirm(Collections.singletonList(replenishAuditDTO));
        return count > 0 ? success() : fail();
    }

    @RequestMapping(value = "audit/reject", method = RequestMethod.POST)
    @ApiOperation(value = "补货单审核不通过")
    @Validate
    @RequiresPermissions(value = {"replenish:reject", "replenish:batch_reject"}, logical = Logical.OR)
    public WebJsonBean reject(@RequestBody ReplenishAuditDTO replenishAuditDTO) {
        Integer count = replenishFacade.reject(Collections.singletonList(replenishAuditDTO));
        return count > 0 ? success() : fail();
    }
}
