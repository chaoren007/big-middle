package com.morning.star.retail.admin.device.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.morning.star.retail.admin.device.controller.command.DistributeKeyCommand;
import com.morning.star.retail.admin.device.controller.command.LockKeyCommand;
import com.morning.star.retail.admin.device.controller.command.UnLockKeyCommand;
import com.morning.star.retail.admin.util.AdminController;
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
@Api(tags={"设备管理"})
@Controller
@RequestMapping("/api/device/")
public class DeviceController extends AdminController {

	@Autowired
	private DeviceFacade deviceFacade;

	@RequiresPermissions(value = "device:list-device")
	@ApiOperation(value = "获取设备列表")
	@RequestMapping(value = "list-device",method=RequestMethod.GET)
	@ResponseBody
	public WebBean<PageBean<DeviceInfoDTO>> listDevice() {
		AdminLoginContent login = getLoginAdmin();
		QueryPageDeviceDTO dto = new QueryPageDeviceDTO();
		dto.setGroupCode(login.getGroupCode());
		dto.setStoreCode(login.getStoreCode());
		return WebBean.ok(deviceFacade.listDevice(dto));
	}

	@RequiresPermissions(value = "device:lock-key")
	@ApiOperation(value = "锁定设备")
	@RequestMapping(value = "lock-key",method=RequestMethod.POST)
	@ResponseBody
	public WebBean<Void> lockKey(@RequestBody LockKeyCommand lockKeyCommand) {
	    deviceFacade.lockKey(lockKeyCommand.getStoreCode(), lockKeyCommand.getKey());
		return WebBean.ok();
	}

	@RequiresPermissions(value = "device:unlock-key")
	@ApiOperation(value = "解锁设备")
	@RequestMapping(value = "unlock-key",method=RequestMethod.POST)
	@ResponseBody
	public WebBean<Void> unlockKey(@RequestBody UnLockKeyCommand unLockKeyCommand) {
	    deviceFacade.unlockKey(unLockKeyCommand.getStoreCode(), unLockKeyCommand.getKey());
		return WebBean.ok();
	}

	/**
	 * 解绑设备(已被屏蔽)
	 *
	 * @return
	 */
//	@RequestMapping(value = "unbindDevice",method=RequestMethod.POST)
//	@ResponseBody
//	public WebBean<Void> unbindDevice(String storeCode, String key) {
//		throw RetailException.of(DeviceErrorCode.UNBIND_DEVICE_INTERANCE_CLOSED, "");
//	}

	@RequiresPermissions(value = "device:distribute-key")
	@ApiOperation(value = "分配秘钥")
	@RequestMapping(value = "distribute-key",method=RequestMethod.POST)
	@ResponseBody
	public WebBean<Void> distributeKey(DistributeKeyCommand distributeKeyCommand) {
		deviceFacade.distributeKey(distributeKeyCommand.getStoreCode(), distributeKeyCommand.getKey());
		return WebBean.ok();
	}

}
