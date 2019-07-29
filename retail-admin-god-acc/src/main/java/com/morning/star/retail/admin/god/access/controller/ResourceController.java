package com.morning.star.retail.admin.god.access.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.morning.star.retail.admin.dto.ResourceFormDTO;
import com.morning.star.retail.admin.dto.ResourceQueryDTO;
import com.morning.star.retail.admin.facade.ResourceFacade;
import com.morning.star.retail.admin.util.AdminController;
import com.morning.star.retail.bean.WebJsonBean;
import com.morning.star.retail.validate.CreateGroup;
import com.morning.star.retail.validate.DeleteGroup;
import com.morning.star.retail.validate.ModifyGroup;
import com.morning.star.retail.validate.Validate;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 权限资源（仅限root管理员操作）
 *
 * @author jiangyf
 */
@Controller
@RequestMapping("/api/resource/")
@Api(tags = "权限资源")
public class ResourceController extends AdminController {

    @Autowired
    private ResourceFacade resourceFacade;

    @ApiOperation(value = "资源列表")
    @RequestMapping(value = "list", method = RequestMethod.GET)
    @ResponseBody
    public WebJsonBean list(@RequestParam(required = true) String classify) {
        return success(resourceFacade.list(ResourceQueryDTO.from(classify, getLoginAdmin())));
    }

    @ApiOperation(value = "新增资源")
    @RequestMapping(value = "create", method = RequestMethod.POST)
    @ResponseBody
    @Validate(groups = CreateGroup.class)
    public WebJsonBean create(@RequestBody ResourceFormDTO formDTO) {
        resourceFacade.create(ResourceFormDTO.from(formDTO, getLoginAdmin()));
        return success();
    }

    @ApiOperation(value = "修改资源")
    @RequestMapping(value = "modify", method = RequestMethod.POST)
    @ResponseBody
    @Validate(groups = ModifyGroup.class)
    public WebJsonBean modify(@RequestBody ResourceFormDTO formDTO) {
        resourceFacade.modify(ResourceFormDTO.from(formDTO, getLoginAdmin()));
        return success();
    }

    @ApiOperation(value = "删除资源")
    @RequestMapping(value = "delete", method = RequestMethod.POST)
    @ResponseBody
    @Validate(groups = DeleteGroup.class)
    public WebJsonBean delete(@RequestBody ResourceFormDTO formDTO) {
        resourceFacade.delete(ResourceFormDTO.from(formDTO, getLoginAdmin()));
        return success();
    }

}
