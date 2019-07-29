package com.morning.star.retail.admin.controller.supplier;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.morning.star.retail.admin.util.AdminController;
import com.morning.star.retail.bean.WebJsonBean;
import com.morning.star.retail.dto.SupplierTypeDTO;
import com.morning.star.retail.dto.SupplierTypeQueryDTO;
import com.morning.star.retail.facade.SupplierTypeFacade;
import com.morning.star.retail.validate.CreateGroup;
import com.morning.star.retail.validate.DeleteGroup;
import com.morning.star.retail.validate.ModifyGroup;
import com.morning.star.retail.validate.Validate;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 供应商类别
 *
 * @author jiangyf
 */
@Api(tags = "供应商类别")
@RestController
@RequestMapping("/api/supplier-type/")
public class SupplierTypeController extends AdminController {

    @Autowired
    private SupplierTypeFacade facade;

    @ApiOperation(value = "供应商类别-新增")
    @RequestMapping(value = "create", method = RequestMethod.POST)
    @RequiresPermissions(value = "supplier-type:create")
    @Validate(groups = CreateGroup.class)
    public WebJsonBean create(@RequestBody SupplierTypeDTO dto) {
        dto.setGroupCode(getLoginAdmin().getGroupCode());
        facade.create(dto);
        return success();
    }

    @ApiOperation(value = "供应商类别-修改")
    @RequestMapping(value = "modify", method = RequestMethod.POST)
    @RequiresPermissions(value = "supplier-type:modify")
    @Validate(groups = ModifyGroup.class)
    public WebJsonBean modify(@RequestBody SupplierTypeDTO dto) {
        dto.setGroupCode(getLoginAdmin().getGroupCode());
        facade.modify(dto);
        return success();
    }

    @ApiOperation(value = "供应商类别-删除")
    @RequestMapping(value = "delete", method = RequestMethod.POST)
    @RequiresPermissions(value = "supplier-type:delete")
    @Validate(groups = DeleteGroup.class)
    public WebJsonBean modify(@RequestParam(required = true) String code) {
        facade.delete(code);
        return success();
    }

    @ApiOperation(value = "供应商类别-列表")
    @RequestMapping(value = "list", method = RequestMethod.GET)
    @RequiresPermissions(value = "supplier-type:list")
    public WebJsonBean list(SupplierTypeQueryDTO queryDTO) {
        queryDTO.setGroupCode(getLoginAdmin().getGroupCode());
        return success(facade.list(queryDTO));
    }

    @ApiOperation(value = "供应商类别-条件查询")
    @RequestMapping(value = "query", method = RequestMethod.GET)
    public WebJsonBean query(SupplierTypeQueryDTO queryDTO) {
        queryDTO.setGroupCode(getLoginAdmin().getGroupCode());
        queryDTO.setPageSize(Integer.MAX_VALUE);
        return success(facade.list(queryDTO).getRecord());
    }
}
