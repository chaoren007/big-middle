package com.morning.star.retail.admin.access.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.morning.star.retail.admin.dto.ResourceQueryDTO;
import com.morning.star.retail.admin.facade.ResourceFacade;
import com.morning.star.retail.admin.util.AdminController;
import com.morning.star.retail.bean.WebJsonBean;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 权限资源
 *
 * @author jiangyf
 */
@Api(tags = "权限资源")
@Controller
@RequestMapping("/api/resource/")
public class ResourceController extends AdminController {

    @Autowired
    private ResourceFacade resourceFacade;

    @ApiOperation(value = "资源列表")
    @RequestMapping(value = "list")
    @ResponseBody
    public WebJsonBean list() {
        return success(resourceFacade.list(ResourceQueryDTO.from(getLoginAdmin())));
    }

}
