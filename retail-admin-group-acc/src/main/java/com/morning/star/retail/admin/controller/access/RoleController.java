package com.morning.star.retail.admin.controller.access;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.morning.star.retail.admin.dto.RoleFormDTO;
import com.morning.star.retail.admin.dto.RoleQueryDTO;
import com.morning.star.retail.admin.facade.RoleFacade;
import com.morning.star.retail.admin.util.AdminController;
import com.morning.star.retail.bean.AdminLoginContent;
import com.morning.star.retail.bean.WebJsonBean;
import com.morning.star.retail.validate.CreateGroup;
import com.morning.star.retail.validate.DeleteGroup;
import com.morning.star.retail.validate.DetailGroup;
import com.morning.star.retail.validate.ModifyGroup;
import com.morning.star.retail.validate.PageGroup;
import com.morning.star.retail.validate.Validate;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 角色
 *
 * @author jiangyf
 */
@Api(tags = "角色")
@Controller
@RequestMapping("/api/role/")
public class RoleController extends AdminController {

    @Autowired
    private RoleFacade roleFacade;


    @ApiOperation(value = "角色列表")
    @RequestMapping(value = "page", method = RequestMethod.GET)
    @ResponseBody
    @Validate(groups = PageGroup.class)
    public WebJsonBean page(RoleQueryDTO queryDTO) {
        return success(roleFacade.page(RoleQueryDTO.from(queryDTO, getLoginAdmin())));
    }

    @ApiOperation(value = "查询角色")
    @RequestMapping(value = "list", method = RequestMethod.GET)
    @ResponseBody
    public WebJsonBean list(@RequestParam(required = true) String classify) {
        return success(roleFacade.list(RoleQueryDTO.from(classify, getLoginAdmin())));
    }

    @ApiOperation(value = "新增角色")
    @RequestMapping(value = "create", method = RequestMethod.POST)
    @ResponseBody
    @Validate(groups = CreateGroup.class)
    public WebJsonBean create(@RequestBody RoleFormDTO formDTO) {
        roleFacade.create(RoleFormDTO.from(formDTO, getLoginAdmin()));
        return success();
    }

    @ApiOperation(value = "修改角色")
    @RequestMapping(value = "modify", method = RequestMethod.POST)
    @ResponseBody
    @Validate(groups = ModifyGroup.class)
    public WebJsonBean modify(@RequestBody RoleFormDTO formDTO) {
        roleFacade.modify(RoleFormDTO.from(formDTO, getLoginAdmin()));
        return success();
    }

    @ApiOperation(value = "删除角色")
    @RequestMapping(value = "delete", method = RequestMethod.POST)
    @ResponseBody
    @Validate(groups = DeleteGroup.class)
    public WebJsonBean delete(@RequestBody RoleFormDTO formDTO) {
        roleFacade.delete(RoleFormDTO.from(formDTO, getLoginAdmin()));
        return success();
    }

    @ApiOperation(value = "角色详情")
    @RequestMapping(value = "detail", method = RequestMethod.GET)
    @ResponseBody
    @Validate(groups = DetailGroup.class)
    public WebJsonBean detail(RoleQueryDTO queryDTO) {
        return success(roleFacade.detail(RoleQueryDTO.from(queryDTO, getLoginAdmin())));
    }

    @ApiOperation(value = "权限详情")
    @RequestMapping(value = "accessInfo", method = RequestMethod.GET)
    @ResponseBody
    public WebJsonBean accessInfo() {
        AdminLoginContent content = getLoginAdmin();
        return success(roleFacade.accessInfo(content.getAccount(), content.getAccountLevel()));
    }

}
