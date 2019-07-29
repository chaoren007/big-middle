package com.morning.star.retail.admin.controller.supplier;

import com.morning.star.retail.admin.util.AdminController;
import com.morning.star.retail.admin.util.WebBean;
import com.morning.star.retail.base.enums.SupplierAuthFailReasonEnum;
import com.morning.star.retail.base.enums.SupplierStatusEnum;
import com.morning.star.retail.base.enums.SupplierTypeEnum;
import com.morning.star.retail.base.page.PageBeans;
import com.morning.star.retail.bean.AdminLoginContent;
import com.morning.star.retail.dto.*;
import com.morning.star.retail.facade.SupplierFacade;
import com.morning.star.retail.validate.SaveGroup;
import com.morning.star.retail.validate.Validate;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 供应商管理（供应商，供货门店， 供应货品）
 *
 * @author jiangyf
 */
@Api(tags = "总部你我您供应商列表")
@RestController
@RequestMapping("/api/supplier")
public class SupplierController extends AdminController {

    @Autowired
    private SupplierFacade facade;

    @ApiOperation(value = "供应商申请-列表")
    @RequestMapping(value = "/list-apply", method = RequestMethod.GET)
    public WebBean<PageBeans<SupplierApplyDTO>> listApply(SupplierQueryDTO queryDTO) {
        AdminLoginContent content = getLoginAdmin();
        queryDTO.setGroupCode(content.getGroupCode());
        return WebBean.ok(facade.listApply(queryDTO));
    }

    @ApiOperation(value = "供应商申请-详情")
    @RequestMapping(value = "/get-apply", method = RequestMethod.GET)
    public WebBean<SupplierApplyDTO> getApply(@RequestParam(required = true) Long id) {
        return WebBean.ok(facade.getApply(id));
    }

    @ApiOperation(value = "供应商申请-审核失败原因")
    @RequestMapping(value = "/auth-fail-reason", method = RequestMethod.GET)
    public WebBean<List<Map<String, Object>>> authFailReason() {
        return WebBean.ok(SupplierAuthFailReasonEnum.list());
    }

    @ApiOperation(value = "供应商申请-审核通过")
    @RequestMapping(value = "/auth-pass", method = RequestMethod.POST)
    public WebBean authPass(@RequestBody SupplierAuthPassDTO dto) {
        facade.authPass(dto);
        return WebBean.ok();
    }

    @ApiOperation(value = "供应商申请-审核失败")
    @RequestMapping(value = "/auth-fail", method = RequestMethod.POST)
    public WebBean authFail(@RequestBody SupplierAuthFailDTO dto) {
        facade.authFail(dto);
        return WebBean.ok();
    }


    @ApiOperation(value = "供应商-列表")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public WebBean<PageBeans<SupplierDTO>> list(SupplierQueryDTO queryDTO) {
        AdminLoginContent content = getLoginAdmin();
        queryDTO.setGroupCode(content.getGroupCode());
        return WebBean.ok(facade.list(queryDTO));
    }

    @ApiOperation(value = "供应商-详情")
    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public WebBean<SupplierDTO> get(@RequestParam(required = true) Long id) {
        return WebBean.ok(facade.get(id));
    }


    @ApiOperation(value = "供应商-新增")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @Validate(groups = SaveGroup.class)
    public WebBean create(@RequestBody SupplierCreateDTO dto) {
        dto.setGroupCode(getLoginAdmin().getGroupCode());
        dto.setType(SupplierTypeEnum.HEAD.getCode());
        facade.create(dto);
        return WebBean.ok();
    }

    @ApiOperation(value = "供应商-启用")
    @RequestMapping(value = "/enable", method = RequestMethod.POST)
    public WebBean enable(@RequestBody SupplierModifyDTO dto) {
        dto.setStatus(SupplierStatusEnum.ENABLE.getCode());
        facade.modifyStatus(dto);
        return WebBean.ok();
    }

    @ApiOperation(value = "供应商-禁用")
    @RequestMapping(value = "/disable", method = RequestMethod.POST)
    public WebBean disable(@RequestBody SupplierModifyDTO dto) {
        dto.setStatus(SupplierStatusEnum.DISABLE.getCode());
        facade.modifyStatus(dto);
        return WebBean.ok();
    }

    @ApiOperation(value = "查询启用状态的供应商")
    @RequestMapping(value = "/query", method = RequestMethod.GET)
    public WebBean<List<SupplierDTO>> query(SupplierQueryDTO queryDTO) {
        queryDTO.setGroupCode(getLoginAdmin().getGroupCode());
        queryDTO.setStatus(SupplierStatusEnum.ENABLE.getCode());
        queryDTO.setPageSize(Integer.MAX_VALUE);
        return WebBean.ok(facade.list(queryDTO).getRecord());
    }
}
