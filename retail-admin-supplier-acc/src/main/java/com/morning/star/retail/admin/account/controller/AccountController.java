package com.morning.star.retail.admin.account.controller;

import com.morning.star.retail.admin.account.command.ChangePasswordCommand;
import com.morning.star.retail.admin.account.command.ChangeSelfPasswordCommand;
import com.morning.star.retail.admin.account.command.CheckCaptchaCodeCommand;
import com.morning.star.retail.admin.dto.AccountDTO;
import com.morning.star.retail.admin.dto.ChangePasswordDTO;
import com.morning.star.retail.admin.dto.ChangeSelfPasswordDTO;
import com.morning.star.retail.admin.dto.FirstModifyAccountDTO;
import com.morning.star.retail.admin.enums.AccountLevelEnum;
import com.morning.star.retail.admin.facade.SupplierAccountFacade;
import com.morning.star.retail.admin.util.AdminController;
import com.morning.star.retail.admin.util.BeanUtils;
import com.morning.star.retail.admin.util.WebBean;
import com.morning.star.retail.base.sms.CaptchaDTO;
import com.morning.star.retail.bean.AdminLoginContent;
import com.morning.star.retail.dto.SupplierDTO;
import com.morning.star.retail.facade.SupplierFacade;
import com.morning.star.retail.shiro.bean.LoginUser;
import com.morning.star.retail.util.RandomUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.time.ZoneId;

@Api(tags = "账号接口")
@RestController
@RequestMapping("/api/account")
public class AccountController extends AdminController {

	@Autowired
	private SupplierAccountFacade accountFacade;

	@Autowired
	private SupplierFacade supplierFacade;

	@ApiOperation(value = "获取账号信息")
	@RequestMapping(value = "/info", method = RequestMethod.GET)
	public WebBean<LoginUser> getInfo() {
		AdminLoginContent login = getLoginAdmin();
		LoginUser loginUser = new LoginUser();
		BeanUtils.copy(login, loginUser);
		return WebBean.ok(loginUser.filter());
	}

	@ApiOperation(value = "获取账号供应商信息")
	@RequestMapping(value = "/supplier", method = RequestMethod.GET)
	public WebBean<SupplierDTO> getSupplier() {
		AdminLoginContent login = getLoginAdmin();
		return WebBean.ok(supplierFacade.get(login.getSupplierCode()));
	}

	@ApiOperation(value = "修改账号信息")
	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public WebBean<Void> modify(@RequestBody FirstModifyAccountDTO dto) {
		AdminLoginContent login = getLoginAdmin();
		dto.setAccount(login.getAccount());
		accountFacade.modifyAccount(dto);
		return WebBean.ok();
	}

	@ApiOperation(value = "校验短信验证码")
	@RequestMapping(value = "/check-captcha", method = RequestMethod.POST)
	public WebBean<String> checkCaptcha(HttpServletRequest request, @RequestBody CheckCaptchaCodeCommand command) {
		CaptchaDTO captchaDTO = new CaptchaDTO();
		captchaDTO.setMobile(command.getAccount());
		captchaDTO.setCaptcha(command.getCaptchaCode());
		AccountDTO accountDTO = accountFacade.checkCaptcha(captchaDTO, AccountLevelEnum.SUPPLIER);
		Validate.isTrue(accountDTO != null, "账号不存在");

		// 短信验证成功后返回TOKEN
		String token = RandomUtil.generateString(12);
		HttpSession session = request.getSession(true);
		// 删除以前的
		session.removeAttribute("captchaToken");
		session.removeAttribute("captchaTime");
		session.setAttribute("captchaToken", token);
		session.setAttribute("captchaTime", LocalDateTime.now());
		return WebBean.ok(token);
	}

	@ApiOperation(value = "修改账号密码（通过短信验证）")
	@RequestMapping(value = "/change-password", method = RequestMethod.POST)
	public WebBean<Void> changePassword(HttpServletRequest request, @RequestBody ChangePasswordCommand command) {
		HttpSession session = request.getSession(true);
		// 校验短信TOKEN
		checkCaptchaToken(session, command.getCaptchaToken());

		ChangePasswordDTO dto = new ChangePasswordDTO();
		dto.setAccount(command.getAccount());
		dto.setPassword(command.getPassword());
		accountFacade.changePassword(dto);
		return WebBean.ok();
	}

	private void checkCaptchaToken(HttpSession session, String code) {
		Object verCode = session.getAttribute("captchaToken");
		Validate.isTrue(null != verCode, "TOKEN已失效，请重新验证");
		String verCodeStr = verCode.toString();
		LocalDateTime localDateTime = (LocalDateTime) session.getAttribute("captchaTime");
		long past = localDateTime.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
		long now = LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
		if (verCodeStr == null || code == null || code.isEmpty() || !verCodeStr.equalsIgnoreCase(code)) {
			throw new IllegalArgumentException("验证码错误");
		}
		if ((now - past) / 1000 / 60 > 5) {
			throw new IllegalArgumentException("验证码已过期，重新获取");
		}
		session.removeAttribute("captchaToken");
		session.removeAttribute("captchaTime");
	}

	@ApiOperation(value = "修改账号密码（通过原密码）")
	@RequestMapping(value = "/change-self-password", method = RequestMethod.POST)
	public WebBean<String> changePassword(@RequestBody ChangeSelfPasswordCommand modifyPassword) {
		AdminLoginContent login = getLoginAdmin();

		ChangeSelfPasswordDTO dto = new ChangeSelfPasswordDTO();
		dto.setAccount(login.getAccount());
		dto.setOldPassword(modifyPassword.getOldPassword());
		dto.setNewPassword(modifyPassword.getNewPassword());
		this.accountFacade.changeSelfPassword(dto);
		return WebBean.ok();
	}

}
