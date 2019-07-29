package com.morning.star.retail.admin.god.login.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.morning.star.retail.admin.util.AdminController;
import com.morning.star.retail.bean.WebJsonBean;
import com.morning.star.retail.enums.PlatformEnum;
import com.morning.star.retail.shiro.bean.LoginUser;
import com.morning.star.retail.shiro.bean.UserLogin;
import com.morning.star.retail.shiro.token.TokenManager;
import com.morning.star.retail.util.LoggerUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 后台登录管理
 *
 * @author jiangyf
 */
@Api(tags = {"后台登录管理"})
@Controller
@RequestMapping("/api/admin/")
public class LoginController extends AdminController {

    @ApiOperation(value = "用户登录")
    @RequestMapping(value = "login", method = RequestMethod.POST)
    @ResponseBody
    public WebJsonBean login(@RequestBody UserLogin userLogin) {
        LoggerUtil.info(getClass(), "start ----------- admin-god-acc-login ----------- ");
        LoginUser loginUser = TokenManager.login(userLogin, PlatformEnum.GOD);
        LoggerUtil.info(getClass(), "end ----------- admin-god-acc-login ----------- ");
        return success(loginUser.filter());
    }

    @ApiOperation(value = "用户登出")
    @RequestMapping(value = "logout", method = RequestMethod.POST)
    @ResponseBody
    public WebJsonBean logout() {
        LoggerUtil.info(getClass(), "start ----------- admin-god-acc-logout ----------- ");
        TokenManager.logout();
        LoggerUtil.info(getClass(), "end ----------- admin-god-acc-logout ----------- ");
        return success();
    }

}
