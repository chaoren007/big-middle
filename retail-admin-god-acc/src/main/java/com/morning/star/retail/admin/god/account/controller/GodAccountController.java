package com.morning.star.retail.admin.god.account.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.morning.star.retail.admin.dto.ChangeSelfPasswordDTO;
import com.morning.star.retail.admin.facade.AccountFacade;
import com.morning.star.retail.admin.god.account.controller.command.ChangeSelfPasswordCommand;
import com.morning.star.retail.admin.util.AdminController;
import com.morning.star.retail.admin.util.WebBean;
import com.morning.star.retail.bean.AdminLoginContent;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "上帝修改密码")
@RestController
@RequestMapping("/api/god")
public class GodAccountController extends AdminController {


	@Autowired
	private AccountFacade accountFacade;

	@ApiOperation(value = "上帝修改密码")
	@RequestMapping(value = "/change-self-password", method = RequestMethod.POST)
	public WebBean<Void> modify(@RequestBody ChangeSelfPasswordCommand command) {
		AdminLoginContent login = getLoginAdmin();
		ChangeSelfPasswordDTO dto = new ChangeSelfPasswordDTO();
		dto.setAccount(login.getAccount());
		dto.setOldPassword(command.getOldPassword());
		dto.setNewPassword(command.getNewPassword());
		accountFacade.changeSelfPassword(dto);
		return WebBean.ok();
	}
}
