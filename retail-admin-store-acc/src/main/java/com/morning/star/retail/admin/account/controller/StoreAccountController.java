package com.morning.star.retail.admin.account.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.Validate;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.morning.star.retail.admin.account.controller.command.ChangePasswordCommand;
import com.morning.star.retail.admin.account.controller.command.ChangeSelfPasswordCommand;
import com.morning.star.retail.admin.account.controller.command.CreateStoreAccountCommand;
import com.morning.star.retail.admin.account.controller.command.DeleteAccountCommand;
import com.morning.star.retail.admin.account.controller.command.QueryStoreAccountCommand;
import com.morning.star.retail.admin.account.controller.vo.StoreAccountVO;
import com.morning.star.retail.admin.dto.AccountDTO;
import com.morning.star.retail.admin.dto.AccountStoreAddDTO;
import com.morning.star.retail.admin.dto.ChangePasswordDTO;
import com.morning.star.retail.admin.dto.ChangeSelfPasswordDTO;
import com.morning.star.retail.admin.dto.LevelDTO;
import com.morning.star.retail.admin.dto.ModifyAccountDTO;
import com.morning.star.retail.admin.dto.QueryAccountDTO;
import com.morning.star.retail.admin.enums.AccountLevelEnum;
import com.morning.star.retail.admin.facade.AccountFacade;
import com.morning.star.retail.admin.util.AdminController;
import com.morning.star.retail.admin.util.WebBean;
import com.morning.star.retail.bean.AdminLoginContent;
import com.morning.star.retail.exception.CODE;
import com.morning.star.retail.util.RegexUtil;
import com.morning.star.retail.utils.page.PageBean;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "门店账号接口")
@RestController
@RequestMapping("/api/store/account")
public class StoreAccountController extends AdminController {

	@Autowired
	private AccountFacade accountFacade;

	/**
	 * 根据公司编码查询登录账号
	 *
	 * @return
	 */
	@ApiOperation(value = "查询门店列表")
	@RequestMapping(value = "/query", method = RequestMethod.GET)
	public WebBean<PageBean<StoreAccountVO>> pageAccount(QueryStoreAccountCommand command) {
		AdminLoginContent login = getLoginAdmin();

		QueryAccountDTO dto = new QueryAccountDTO();
		BeanUtils.copyProperties(command, dto);
		dto.setGroupCode(login.getGroupCode());
		dto.setStoreCode(login.getStoreCode());
		dto.setAccountLevels(AccountLevelEnum.storeOwnLevel);
		return WebBean.ok(accountFacade.query(dto).to(StoreAccountVO.class));
	}


	/**
	 * 新增登录账号
	 *
	 * @return
	 */
	@RequiresPermissions(value = "store:account:create")
	@ApiOperation(value = "创建门店账号")
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public WebBean<Void> addAccount(@RequestBody CreateStoreAccountCommand command) {
		Validate.notEmpty(command.getPassword(), "密码不能为空");
		Validate.notEmpty(command.getAccount(), "账号不能为空");
		Validate.notEmpty(command.getAccountLevel(), "账号级别不能为空");
		Validate.notEmpty(command.getName(), "姓名不能为空");
		Validate.notEmpty(command.getMobile(), "电话不能为空");
		Validate.notEmpty(command.getEmail(), "邮箱不能为空");
		Validate.isTrue(RegexUtil.isMobile(command.getMobile()), "手机号格式错误");
		Validate.isTrue(RegexUtil.isEmail(command.getEmail()), "邮箱格式错误");
		Validate.isTrue(!command.getAccountLevel().equals(AccountLevelEnum.STORE_ADMIN.getCode()), "该门店已经存在管理员!");

		AdminLoginContent login = getLoginAdmin();

		AccountStoreAddDTO dto = new AccountStoreAddDTO();
		BeanUtils.copyProperties(command, dto);
		dto.setGroupCode(login.getGroupCode());
		dto.setStoreCode(login.getStoreCode());

		accountFacade.addStoreAccount(dto);
		return WebBean.ok();
	}


	/**
	 * 查询登录账号详情
	 *
	 * @param account 登录账号ID
	 * @return
	 */
	@ApiOperation(value = "查询门店详情")
	@RequestMapping(value = "/get", method = RequestMethod.GET)
	public WebBean<StoreAccountVO> getAccountInfo(@RequestParam(required = true) String account) {
		AccountDTO dto = accountFacade.getStoreAccount(account);
		if (dto == null) {
			return WebBean.ok(null);
		}
		StoreAccountVO vo = new StoreAccountVO();
		BeanUtils.copyProperties(dto, vo);
		return WebBean.ok(vo);
	}

	/**
	 * 修改登录账号
	 *
	 * @param dto
	 * @return
	 */
	@RequiresPermissions(value = "store:account:edit")
	@ApiOperation(value = "修改门店")
	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public WebBean<Void> modifyAccount(@RequestBody ModifyAccountDTO dto) {
		Validate.notEmpty(dto.getAccount(), "账号不能为空");
		Validate.notEmpty(dto.getName(), "姓名不能为空");
		Validate.notEmpty(dto.getMobile(), "电话不能为空");
		Validate.notEmpty(dto.getEmail(), "邮箱不能为空");
		Validate.isTrue(RegexUtil.isMobile(dto.getMobile()), "手机号格式错误");
		Validate.isTrue(RegexUtil.isEmail(dto.getEmail()), "邮箱格式错误");

		AdminLoginContent login = getLoginAdmin();

		AccountDTO accountDTO = this.accountFacade.getStoreAccount(dto.getAccount());
		if (accountDTO.getAccountLevel().equals(AccountLevelEnum.STORE_ADMIN.getCode())
			&& !login.getAccount().equals(dto.getAccount())) {
			return new WebBean<>(CODE.ACCESE_NO);
		}

		accountFacade.modifyAccount(dto);
		return WebBean.ok();
	}


	@RequiresPermissions(value = "store:account:password")
	@ApiOperation(value = "修改账号密码")
	@RequestMapping(value = "/change-password", method = RequestMethod.POST)
	public WebBean<Void> changePassword(@RequestBody ChangePasswordCommand command) {
		AdminLoginContent login = getLoginAdmin();

		AccountDTO accountDTO = this.accountFacade.getStoreAccount(command.getAccount());
		if (accountDTO.getAccountLevel().equals(AccountLevelEnum.STORE_SELLER.getCode())) {
			return new WebBean<>(CODE.ACCESE_NO);
		}

		if (accountDTO.getAccountLevel().equals(AccountLevelEnum.STORE_ADMIN.getCode())
			&& !login.getAccount().equals(command.getAccount())) {
			return new WebBean<>(CODE.ACCESE_NO);
		}

		ChangePasswordDTO dto = new ChangePasswordDTO();
		dto.setAccount(command.getAccount());
		dto.setPassword(command.getPassword());
		accountFacade.changePassword(dto);
		return WebBean.ok();
	}

	@ApiOperation(value = "修改账号密码")
	@RequestMapping(value = "/change-self-password", method = RequestMethod.POST)
	public WebBean<String> changePassword(@RequestBody ChangeSelfPasswordCommand modifyPassword) {
		AdminLoginContent login = getLoginAdmin();

		if (login.getAccountLevel().equals(AccountLevelEnum.STORE_SELLER.getCode())) {
			return WebBean.fail("促销员不能修改密码");
		}

		ChangeSelfPasswordDTO dto = new ChangeSelfPasswordDTO();
		dto.setAccount(login.getAccount());
		dto.setOldPassword(modifyPassword.getOldPassword());
		dto.setNewPassword(modifyPassword.getNewPassword());
		this.accountFacade.changeSelfPassword(dto);
		return WebBean.ok();
	}


	@RequiresPermissions(value = "store:account:delete")
	@ApiOperation(value = "删除门店")
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public WebBean<Void> delete(@RequestBody DeleteAccountCommand command) {
		AdminLoginContent login = getLoginAdmin();

		if (login.getAccount().equals(command.getAccount())) {
			return new WebBean<>(CODE.ACCESE_NO);
		}
		AccountDTO accountDTO = this.accountFacade.getStoreAccount(command.getAccount());
		if (accountDTO.getAccountLevel().equals(AccountLevelEnum.STORE_ADMIN.getCode())) {
			return new WebBean<>(CODE.ACCESE_NO);
		}

		accountFacade.delete(command.getAccount());
		return WebBean.ok();
	}

	@ApiOperation(value = "账号等级")
	@RequestMapping(value = "/listLevel", method = RequestMethod.GET)
	public WebBean<List<LevelDTO>> listLevel() {
		List<LevelDTO> list = new ArrayList<>();
		list.add(LevelDTO.of(AccountLevelEnum.STORE_ADMIN.getCode(),
			AccountLevelEnum.STORE_ADMIN.getDesc()));
		list.add(LevelDTO.of(AccountLevelEnum.STORE_CLERK.getCode(),
			AccountLevelEnum.STORE_CLERK.getDesc()));
		list.add(LevelDTO.of(AccountLevelEnum.STORE_SELLER.getCode(),
			AccountLevelEnum.STORE_SELLER.getDesc()));
		return WebBean.ok(list);
	}

}
