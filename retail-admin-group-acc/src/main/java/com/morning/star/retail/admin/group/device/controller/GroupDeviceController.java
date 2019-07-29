package com.morning.star.retail.admin.group.device.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.morning.star.retail.admin.group.device.controller.command.DistributeDeviceCommand;
import com.morning.star.retail.admin.group.device.controller.command.QueryCommand;
import com.morning.star.retail.admin.util.AdminController;
import com.morning.star.retail.admin.util.BeanUtils;
import com.morning.star.retail.admin.util.WebBean;
import com.morning.star.retail.bean.AdminLoginContent;
import com.morning.star.retail.dto.DeviceInfoDTO;
import com.morning.star.retail.dto.QueryPageDeviceDTO;
import com.morning.star.retail.facade.DeviceFacade;
import com.morning.star.retail.utils.page.PageBean;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 设备
 *
 * @author jiangyf
 * @date 2017年5月24日 下午1:48:40
 */
@Api(tags = "设备接口")
@Controller
@RequestMapping("/api/device/")
public class GroupDeviceController extends AdminController {

    @Autowired
    private DeviceFacade deviceFacade;

    @RequiresPermissions(value = "device:query")
    @ApiOperation(value = "分页查询")
    @RequestMapping(value = "query", method = RequestMethod.GET)
    @ResponseBody
    public WebBean<PageBean<DeviceInfoDTO>> query(QueryCommand queryCommand) {
        AdminLoginContent login = getLoginAdmin();
        QueryPageDeviceDTO dto = new QueryPageDeviceDTO();
        BeanUtils.copy(queryCommand, dto);
        dto.setGroupCode(login.getGroupCode());
        return WebBean.ok(deviceFacade.listDevice(dto));
    }

    @RequiresPermissions(value = "device:distribute")
    @ApiOperation(value = "分配秘钥到门店")
    @RequestMapping(value = "distribute", method = RequestMethod.POST)
    @ResponseBody
    public WebBean<Void> distributeForStore(@RequestBody DistributeDeviceCommand comand) {
        this.deviceFacade.distributeKey(comand.getStoreCode(), comand.getKeys());
        return WebBean.ok();
    }

}
