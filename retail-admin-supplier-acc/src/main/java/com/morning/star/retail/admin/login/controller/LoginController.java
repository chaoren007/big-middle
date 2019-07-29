package com.morning.star.retail.admin.login.controller;


import com.morning.star.retail.admin.enums.AccountLevelEnum;
import com.morning.star.retail.admin.facade.AccountFacade;
import com.morning.star.retail.admin.facade.SupplierAccountFacade;
import com.morning.star.retail.admin.util.AdminController;
import com.morning.star.retail.admin.util.WebBean;
import com.morning.star.retail.enums.PlatformEnum;
import com.morning.star.retail.shiro.bean.LoginUser;
import com.morning.star.retail.shiro.bean.UserLogin;
import com.morning.star.retail.shiro.token.LoginType;
import com.morning.star.retail.shiro.token.TokenManager;
import com.morning.star.retail.util.VerifyCodeUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.Validate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.time.LocalDateTime;
import java.time.ZoneId;

/**
 * 后台登录管理
 *
 * @author jiangyf
 */
@Api(tags = {"后台登录管理"})
@RestController
@RequestMapping("/api/admin/")
public class LoginController extends AdminController {
	private Logger LOGGER = LoggerFactory.getLogger(LoginController.class);

	@Autowired
	private SupplierAccountFacade accountFacade;

	@ApiOperation(value = "用户登录")
	@RequestMapping(value = "login", method = RequestMethod.POST)
	@ResponseBody
	public WebBean<LoginUser> login(@RequestBody UserLogin userLogin, HttpSession session) {
		LOGGER.info("start ----------- admin-store-acc-login ----------- ");
		// 密码登录需要校验图形验证码
		if (LoginType.PASSWORD.equals(userLogin.getLoginType())) {
			checkCaptchaImg(session, userLogin.getImgCode());
		}
		LoginUser loginUser = TokenManager.login(userLogin, PlatformEnum.SUPPLIER);
		// TODO 更新登录状态，时间，次数
		if (TokenManager.subject().isAuthenticated()) {
			accountFacade.addLoginCount(loginUser.getAccount(), AccountLevelEnum.SUPPLIER);
			if (loginUser.getLoginCount() != null) {
				loginUser.setLoginCount(loginUser.getLoginCount() + 1);
			} else {
				loginUser.setLoginCount(1);
			}
		}
		LOGGER.info("end ----------- admin-store-acc-login ----------- ");
		return WebBean.ok(loginUser.filter());
	}

	@ApiOperation(value = "用户登出")
	@RequestMapping(value = "logout", method = RequestMethod.POST)
	@ResponseBody
	public WebBean logout() {
		LOGGER.info("start ----------- admin-store-acc-logout ----------- ");
		TokenManager.logout();
		// TODO 更新登录状态
		if (!TokenManager.subject().isAuthenticated()) {
		}
		LOGGER.info("end ----------- admin-store-acc-logout ----------- ");
		return WebBean.ok();
	}

	@ApiOperation(value = "短信登录")
	@RequestMapping(value = "login/captcha", method = RequestMethod.GET)
	public WebBean captcha(@RequestParam String mobile) {
		LOGGER.info("start ---------------- 发送验证码 ----------------");
		accountFacade.captcha(mobile, AccountLevelEnum.SUPPLIER);
		LOGGER.info("end ---------------- 发送验证码 ----------------");
		return WebBean.ok();
	}

	@ApiOperation(value = "图形验证码")
	@RequestMapping(value = "login/captcha-img", method = RequestMethod.GET)
	public void captchaImg(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setHeader("Pragma", "No-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		response.setContentType("image/jpeg");
		// 生成随机字串
		String verifyCode = VerifyCodeUtils.generateVerifyCode(4);
		// 存入会话session
		HttpSession session = request.getSession(true);
		// 删除以前的
		session.removeAttribute("verCode");
		session.removeAttribute("codeTime");
		session.setAttribute("verCode", verifyCode.toLowerCase());
		session.setAttribute("codeTime", LocalDateTime.now());
		// 生成图片
		int w = 100, h = 30;
		OutputStream out = response.getOutputStream();
		VerifyCodeUtils.outputImage(w, h, out, verifyCode);
	}

	@ApiOperation(value = "图形验证码-返回base64")
	@RequestMapping(value = "login/captcha-img-base64", method = RequestMethod.GET)
	public WebBean captchaImgV2(HttpServletRequest request) throws IOException {
		// 生成随机字串
		String verifyCode = VerifyCodeUtils.generateVerifyCode(4);
		// 存入会话session
		HttpSession session = request.getSession(true);
		// 删除以前的
		session.removeAttribute("verCode");
		session.removeAttribute("codeTime");
		session.setAttribute("verCode", verifyCode.toLowerCase());
		session.setAttribute("codeTime", LocalDateTime.now());
		// 生成图片
		int w = 100, h = 30;
		OutputStream out = new ByteArrayOutputStream();

		VerifyCodeUtils.outputImage(w, h, out, verifyCode);
		return WebBean.ok("data:image/jpg;base64," + new String(Base64.encodeBase64(((ByteArrayOutputStream) out).toByteArray())));
	}

	private void checkCaptchaImg(HttpSession session, String code) {
		Object verCode = session.getAttribute("verCode");
		Validate.isTrue(null != verCode, "验证码已失效，请重新获取");
		String verCodeStr = verCode.toString();
		LocalDateTime localDateTime = (LocalDateTime) session.getAttribute("codeTime");
		long past = localDateTime.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
		long now = LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
		if (verCodeStr == null || code == null || code.isEmpty() || !verCodeStr.equalsIgnoreCase(code)) {
			throw new IllegalArgumentException("验证码错误");
		}
		if ((now - past) / 1000 / 60 > 5) {
			throw new IllegalArgumentException("验证码已过期，重新获取");
		}
		session.removeAttribute("verCode");
		session.removeAttribute("codeTime");
	}

}
