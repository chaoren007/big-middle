package com.morning.star.retail.admin.god.device.controller;

import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.morning.star.retail.admin.god.device.controller.command.DistributeForGodCommand;
import com.morning.star.retail.admin.god.device.controller.command.EditExpireDateCommand;
import com.morning.star.retail.admin.god.device.controller.command.QueryCommand;
import com.morning.star.retail.admin.god.device.controller.command.RecoverCommand;
import com.morning.star.retail.admin.util.AdminController;
import com.morning.star.retail.admin.util.BeanUtils;
import com.morning.star.retail.admin.util.WebBean;
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
public class GodDeviceController extends AdminController {

    @Autowired
    private DeviceFacade deviceFacade;

    @ApiOperation(value = "分页查询")
    @RequestMapping(value = "query", method = RequestMethod.GET)
    @ResponseBody
    public WebBean<PageBean<DeviceInfoDTO>> query(QueryCommand queryCommand) {
        QueryPageDeviceDTO dto = new QueryPageDeviceDTO();
        BeanUtils.copy(queryCommand, dto);
        return WebBean.ok(deviceFacade.listDevice(dto));
    }

    @ApiOperation(value = "新增秘钥")
    @RequestMapping(value = "add-key", method = RequestMethod.GET)
    @ResponseBody
    public WebBean<Void> addKey() {
        this.deviceFacade.addKey(setExpireDate());
        return WebBean.ok();
    }

    @ApiOperation(value = "修改秘钥")
    @RequestMapping(value = "edit-expireDate", method = RequestMethod.POST)
    @ResponseBody
    public WebBean<Void> editExpireDate(@RequestBody EditExpireDateCommand editExpireDateCommand) {
        this.deviceFacade.modifyExpireDate(editExpireDateCommand.getKey(),editExpireDateCommand.getExpireDate());
        return WebBean.ok();
    }

    @ApiOperation(value = "分配秘钥到集团")
    @RequestMapping(value = "distribute", method = RequestMethod.POST)
    @ResponseBody
    public WebBean<Void> distributeForStore(@RequestBody DistributeForGodCommand distributeForGodCommand) {
        this.deviceFacade.distributeForGod(distributeForGodCommand.getGroupCode() , distributeForGodCommand.getKey());
        return WebBean.ok();
    }

    @ApiOperation(value = "回收秘钥")
    @RequestMapping(value = "recover", method = RequestMethod.POST)
    @ResponseBody
    public WebBean<Void> recover(@RequestBody RecoverCommand recoverCommand) {
        this.deviceFacade.recover(recoverCommand.getKey());
        return WebBean.ok();
    }

    private Date setExpireDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.YEAR, 1);
        calendar.add(Calendar.DATE, -1);
        return calendar.getTime();
    }

}
