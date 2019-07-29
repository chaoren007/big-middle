package com.morning.star.retail.admin.login.controller;


import com.morning.star.retail.admin.util.AdminController;
import com.morning.star.retail.bean.WebJsonBean;
import com.morning.star.retail.enums.PlatformEnum;
import com.morning.star.retail.shiro.bean.LoginUser;
import com.morning.star.retail.shiro.bean.UserLogin;
import com.morning.star.retail.shiro.token.TokenManager;
import com.morning.star.retail.util.LoggerUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

/**
 * 后台登录管理
 *
 * @author jiangyf
 */
@Api(tags = {"后台登录管理"})
@RestController
@RequestMapping("/api/admin/")
public class LoginController extends AdminController {

	@ApiOperation(value = "用户登录")
	@RequestMapping(value = "login", method = RequestMethod.POST)
	@ResponseBody
	public WebJsonBean login(@RequestBody UserLogin userLogin) {
		LoggerUtil.info(getClass(), "start ----------- admin-store-acc-login ----------- ");
		LoginUser loginUser = TokenManager.login(userLogin, PlatformEnum.STORE);
		// TODO 更新登录状态，时间，次数
		if (TokenManager.subject().isAuthenticated()) {
		}
		LoggerUtil.info(getClass(), "end ----------- admin-store-acc-login ----------- ");
		return success(loginUser.filter());
	}

	@ApiOperation(value = "用户登出")
	@RequestMapping(value = "logout", method = RequestMethod.POST)
	@ResponseBody
	public WebJsonBean logout() {
		LoggerUtil.info(getClass(), "start ----------- admin-store-acc-logout ----------- ");
		TokenManager.logout();
		// TODO 更新登录状态
		if (!TokenManager.subject().isAuthenticated()) {
		}
		LoggerUtil.info(getClass(), "end ----------- admin-store-acc-logout ----------- ");
		return success();
	}

}
