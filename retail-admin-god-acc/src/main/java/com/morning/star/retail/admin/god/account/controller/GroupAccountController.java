package com.morning.star.retail.admin.god.account.controller;


import org.apache.commons.lang.Validate;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.morning.star.retail.admin.dto.AccountDTO;
import com.morning.star.retail.admin.dto.AccountGroupAddDTO;
import com.morning.star.retail.admin.dto.ChangePasswordDTO;
import com.morning.star.retail.admin.dto.ModifyAccountDTO;
import com.morning.star.retail.admin.dto.QueryAccountDTO;
import com.morning.star.retail.admin.enums.AccountLevelEnum;
import com.morning.star.retail.admin.facade.AccountFacade;
import com.morning.star.retail.admin.god.account.controller.command.AddGroupAccountCommand;
import com.morning.star.retail.admin.god.account.controller.command.QueryGroupAccountCommand;
import com.morning.star.retail.admin.god.account.controller.vo.GroupAccountVO;
import com.morning.star.retail.admin.util.AdminController;
import com.morning.star.retail.admin.util.WebBean;
import com.morning.star.retail.utils.page.PageBean;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "集团账户接口")
@RestController
@RequestMapping("/api/group/account")
public class GroupAccountController extends AdminController {

	@Autowired
	private AccountFacade accountFacade;


	@ApiOperation(value = "集团账户列表")
	@RequestMapping(value = "/query", method = RequestMethod.GET)
	public WebBean<PageBean<GroupAccountVO>> page(QueryGroupAccountCommand command) {
		QueryAccountDTO dto = new QueryAccountDTO();
		BeanUtils.copyProperties(command, dto);
		dto.setAccountLevel(AccountLevelEnum.GROUP_ADMIN.getCode());
		return WebBean.ok(accountFacade.query(dto).to(GroupAccountVO.class));
	}


	@ApiOperation(value = "账户详情")
	@RequestMapping(value = "/get", method = RequestMethod.GET)
	public WebBean<GroupAccountVO> getInfo(@RequestParam String account) {
		Validate.notEmpty(account, "账号不能为空");
		AccountDTO dto = accountFacade.getGroupAccount(account);
		if (dto == null) {
			return WebBean.ok(null);
		}
		GroupAccountVO vo = new GroupAccountVO();
		BeanUtils.copyProperties(dto, vo);
		return WebBean.ok(vo);
	}


	@ApiOperation(value = "添加账号")
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public WebBean<Void> add(@RequestBody AddGroupAccountCommand command) {
		Validate.notEmpty(command.getAccount(), "账号不能为空");

		AccountGroupAddDTO dto = new AccountGroupAddDTO();
		dto.setAccount(command.getAccount());
		dto.setPassword(command.getPassword());
		dto.setName(command.getName());
		dto.setMobile(command.getMobile());
		dto.setEmail(command.getEmail());
		dto.setGroupCode(command.getGroupCode());
		dto.setAccountLevel(AccountLevelEnum.GROUP_ADMIN.getCode());

		accountFacade.addGroupAccount(dto);
		return WebBean.ok();
	}


	@ApiOperation(value = "修改账户")
	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public WebBean<Void> modify(@RequestBody ModifyAccountDTO dto) {
		accountFacade.modifyAccount(dto);
		return WebBean.ok();
	}


	@ApiOperation(value = "修改密码")
	@RequestMapping(value = "/change-password", method = RequestMethod.POST)
	public WebBean<Void> changePassword(@RequestBody ChangePasswordDTO dto) {
		String account = dto.getAccount();
		if (StringUtils.isBlank(account)) {
			paramsError("账号");
		}
		accountFacade.changePassword(dto);
		return WebBean.ok();
	}

}
