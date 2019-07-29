package com.morning.star.retail.admin.group.account.controller;


import org.apache.commons.lang.Validate;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.morning.star.retail.admin.dto.AccountDTO;
import com.morning.star.retail.admin.dto.AccountGroupAddDTO;
import com.morning.star.retail.admin.dto.ChangePasswordDTO;
import com.morning.star.retail.admin.dto.ChangeSelfPasswordDTO;
import com.morning.star.retail.admin.dto.ModifyAccountDTO;
import com.morning.star.retail.admin.dto.QueryAccountDTO;
import com.morning.star.retail.admin.enums.AccountLevelEnum;
import com.morning.star.retail.admin.facade.AccountFacade;
import com.morning.star.retail.admin.group.account.controller.command.ChangeSelfPasswordCommand;
import com.morning.star.retail.admin.group.account.controller.command.CreateGroupAccountCommand;
import com.morning.star.retail.admin.group.account.controller.command.DeleteAccountCommand;
import com.morning.star.retail.admin.group.account.controller.command.GetAccountCommand;
import com.morning.star.retail.admin.group.account.controller.command.QueryGroupAccountCommand;
import com.morning.star.retail.admin.group.account.controller.vo.GroupAccountVO;
import com.morning.star.retail.admin.util.AdminController;
import com.morning.star.retail.admin.util.WebBean;
import com.morning.star.retail.bean.AdminLoginContent;
import com.morning.star.retail.exception.CODE;
import com.morning.star.retail.utils.page.PageBean;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * Created by lenovo on 2017/11/3.
 */
@Api(tags = "集团账户接口")
@RestController
@RequestMapping("/api/group/account")
public class GroupAccountController extends AdminController {

	@Autowired
	private AccountFacade accountFacade;

	@ApiOperation(value = "集团账户列表")
	@RequestMapping(value = "/query", method = RequestMethod.GET)
	public WebBean<PageBean<GroupAccountVO>> page(QueryGroupAccountCommand command) {

		AdminLoginContent admin = getLoginAdmin();
		QueryAccountDTO dto = new QueryAccountDTO();
		BeanUtils.copyProperties(command, dto);
		dto.setGroupCode(admin.getGroupCode());
		dto.setAccountLevels(AccountLevelEnum.groupOwnLevel);
		return WebBean.ok(accountFacade.query(dto).to(GroupAccountVO.class));
	}

	@ApiOperation(value = "获取账号详情")
	@RequestMapping(value = "/get", method = RequestMethod.GET)
	public WebBean<GroupAccountVO> getInfo(GetAccountCommand command) {
		Validate.notEmpty(command.getAccount(), "账号不能为空");

		AccountDTO dto = accountFacade.getGroupAccount(command.getAccount());
		if (dto == null) {
			return WebBean.ok(null);
		}
		GroupAccountVO vo = new GroupAccountVO();
		BeanUtils.copyProperties(dto, vo);
		return WebBean.ok(vo);
	}

	@ApiOperation(value = "添加普通集团账号")
	@RequiresPermissions(value = "group:account:create")
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	@com.morning.star.retail.validate.Validate
	public WebBean<Void> add(@RequestBody CreateGroupAccountCommand command) {
		Validate.notEmpty(command.getAccount(), "账号不能为空");

		AdminLoginContent admin = getLoginAdmin();
		if (!admin.getAccountLevel().equals(AccountLevelEnum.GROUP_ADMIN.getCode())) {
			return new WebBean<>(CODE.ACCESE_NO);
		}

		AccountGroupAddDTO dto = new AccountGroupAddDTO();
		BeanUtils.copyProperties(command, dto);
		dto.setGroupCode(admin.getGroupCode());
		dto.setAccountLevel(AccountLevelEnum.GROUP_NORMAL.getCode());
		accountFacade.addGroupAccount(dto);
		return WebBean.ok();
	}

	@RequiresPermissions(value = "group:account:edit")
	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public WebBean<Void> modify(@RequestBody ModifyAccountDTO dto) {
		Validate.notEmpty(dto.getAccount(), "账号不能为空");
		accountFacade.modifyAccount(dto);
		return WebBean.ok();
	}

	@RequiresPermissions(value = "group:account:delete")
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public WebBean<Void> delete(@RequestBody DeleteAccountCommand command) {
		accountFacade.delete(command.getAccount());
		return WebBean.ok();
	}

	@RequestMapping(value = "/change-self-password", method = RequestMethod.POST)
	public WebBean<Void> changeSelfPassword(@RequestBody ChangeSelfPasswordCommand command) {
		ChangeSelfPasswordDTO dto = new ChangeSelfPasswordDTO();
		dto.setAccount(getLoginAdmin().getAccount());
		dto.setOldPassword(command.getOldPassword());
		dto.setNewPassword(command.getNewPassword());
		accountFacade.changeSelfPassword(dto);
		return WebBean.ok();
	}

	@RequiresPermissions(value = "group:account:password")
	@RequestMapping(value = "/change-password", method = RequestMethod.POST)
	public WebBean<Void> changePassword(@RequestBody ChangePasswordDTO dto) {
		Validate.notEmpty(dto.getAccount(), "账号不能为空");

		accountFacade.changePassword(dto);
		return WebBean.ok();
	}

}
