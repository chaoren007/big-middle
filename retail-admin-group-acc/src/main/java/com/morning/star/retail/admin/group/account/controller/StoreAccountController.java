package com.morning.star.retail.admin.group.account.controller;

import org.apache.commons.lang.Validate;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.morning.star.retail.admin.dto.AccountDTO;
import com.morning.star.retail.admin.dto.AccountStoreAddDTO;
import com.morning.star.retail.admin.dto.ChangePasswordDTO;
import com.morning.star.retail.admin.dto.ChangeSelfPasswordDTO;
import com.morning.star.retail.admin.dto.ModifyAccountDTO;
import com.morning.star.retail.admin.dto.QueryAccountDTO;
import com.morning.star.retail.admin.enums.AccountLevelEnum;
import com.morning.star.retail.admin.facade.AccountFacade;
import com.morning.star.retail.admin.group.account.controller.command.ChangePasswordCommand;
import com.morning.star.retail.admin.group.account.controller.command.ChangeSelfPasswordCommand;
import com.morning.star.retail.admin.group.account.controller.command.CreateStoreAccountCommand;
import com.morning.star.retail.admin.group.account.controller.command.DeleteAccountCommand;
import com.morning.star.retail.admin.group.account.controller.command.QueryStoreAccountCommand;
import com.morning.star.retail.admin.group.account.controller.vo.StoreAccountVO;
import com.morning.star.retail.admin.util.AdminController;
import com.morning.star.retail.admin.util.WebBean;
import com.morning.star.retail.bean.AdminLoginContent;
import com.morning.star.retail.utils.page.PageBean;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "门店账号接口")
@RestController
@RequestMapping("/api/store/account")
public class StoreAccountController extends AdminController {

	@Autowired
	private AccountFacade accountFacade;

	@RequiresPermissions(value = "store:account:create")
	@ApiOperation(value = "创建门店")
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public WebBean<Void> add(@RequestBody CreateStoreAccountCommand command) {
		AdminLoginContent login = getLoginAdmin();
		AccountStoreAddDTO dto = new AccountStoreAddDTO();
		BeanUtils.copyProperties(command, dto);
		dto.setAccount(command.getAccount());
		dto.setPassword(command.getPassword());
		dto.setDiscount(command.getDiscount());
		dto.setEmail(command.getEmail());
		dto.setMobile(command.getMobile());
		dto.setName(command.getName());
		dto.setGroupCode(login.getGroupCode());

		dto.setAccountLevel(AccountLevelEnum.STORE_ADMIN.getCode());

		accountFacade.addStoreAccount(dto);
		return WebBean.ok();
	}

	@RequiresPermissions(value = "store:account:edit")
	@ApiOperation(value = "修改门店")
	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public WebBean<Void> modify(@RequestBody ModifyAccountDTO dto) {
		accountFacade.modifyAccount(dto);
		return WebBean.ok();
	}


	@RequiresPermissions(value = "store:account:delete")
	@ApiOperation(value = "删除门店")
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public WebBean<Void> delete(@RequestBody DeleteAccountCommand command) {
		Validate.notEmpty(command.getAccount(), "账号不能为空");
		accountFacade.delete(command.getAccount());
		return WebBean.ok();
	}

	@ApiOperation(value = "查询门店列表")
	@RequestMapping(value = "/query", method = RequestMethod.GET)
	public WebBean<PageBean<StoreAccountVO>> page(QueryStoreAccountCommand command) {
		AdminLoginContent login = getLoginAdmin();
		QueryAccountDTO dto = new QueryAccountDTO();
		BeanUtils.copyProperties(command, dto);
		dto.setGroupCode(login.getGroupCode());
		dto.setAccountLevels(AccountLevelEnum.storeOwnLevel);
		return WebBean.ok(accountFacade.query(dto).to(StoreAccountVO.class));
	}

	@ApiOperation(value = "查询门店详情")
	@RequestMapping(value = "/get", method = RequestMethod.GET)
	public WebBean<StoreAccountVO> getInfo(@RequestParam(required = true) String account) {
		AccountDTO dto = accountFacade.getStoreAccount(account);
		if (dto == null) {
			return WebBean.ok(null);
		}
		StoreAccountVO vo = new StoreAccountVO();
		BeanUtils.copyProperties(dto, vo);
		return WebBean.ok(vo);
	}

	@RequiresPermissions(value = "store:account:password")
	@ApiOperation(value = "修改账号密码")
	@RequestMapping(value = "/change-password", method = RequestMethod.POST)
	public WebBean<Void> changePassword(@RequestBody ChangePasswordCommand command) {
		ChangePasswordDTO dto = new ChangePasswordDTO();
		BeanUtils.copyProperties(command, dto);
		dto.setAccount(command.getAccount());
		dto.setPassword(command.getPassword());
		accountFacade.changePassword(dto);
		return WebBean.ok();
	}

	@ApiOperation(value = "修改账号密码")
	@RequestMapping(value = "/change-self-password", method = RequestMethod.POST)
	public WebBean<Void> changeSelfPassword(@RequestBody ChangeSelfPasswordCommand command) {
		AdminLoginContent login = getLoginAdmin();
		ChangeSelfPasswordDTO dto = new ChangeSelfPasswordDTO();
		dto.setAccount(login.getAccount());
		dto.setOldPassword(command.getOldPassword());
		dto.setNewPassword(command.getNewPassword());
		accountFacade.changeSelfPassword(dto);
		return WebBean.ok();
	}


}
