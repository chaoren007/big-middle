package com.morning.star.retail.shiro.filter;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.apache.shiro.web.util.WebUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.morning.star.retail.shiro.bean.LoginUser;
import com.morning.star.retail.shiro.token.TokenManager;

import net.sf.json.JSONObject;

/**
 * 账号登录认证过滤器
 *
 * @author jiangyf
 * @date 2017年10月27日 下午1:49:49
 */
public class AuthenticateFilter extends FormAuthenticationFilter {
    private static final Logger LOGGER = LoggerFactory.getLogger(AuthenticateFilter.class);

    @Override
    public boolean onPreHandle(ServletRequest request, ServletResponse response, Object mappedValue) {
        Subject subject = getSubject(request, response);

        boolean isAuthenticated = subject.isAuthenticated();
        boolean isLoginRequest = isLoginRequest(request, response);

        // 如果用户没有登录，且非请求登录
        if (!isAuthenticated && !isLoginRequest) {
            Map<String, Object> message = new HashMap<>();
            message.put("code", 1003);
            message.put("desc", "用户未登录，请重新登录");
            message.put("tid", UUID.randomUUID().toString());
            out(response, message);

            return Boolean.FALSE;
        }

        if (isAuthenticated && isLoginRequest) { // 重复登录
            if (isLoginSubmission(request, response)) {
                //本次登陆的用户
                String username = getUsername(request);
                //之前登陆的用户
                LoginUser loginUser = TokenManager.getLoginUser();

                // 若两次登录的用户名不一致，前一登录用户强制登出
                if (loginUser != null && !username.equals(loginUser.getUsername())) {
                    TokenManager.subject().logout();
                }
            }
        }

        return super.isAccessAllowed(request, response, mappedValue);
    }

    @Override
    protected boolean onLoginSuccess(AuthenticationToken token, Subject subject, ServletRequest request,
                                     ServletResponse response) throws Exception {
        WebUtils.getAndClearSavedRequest(request);
        WebUtils.redirectToSavedRequest(request, response, getSuccessUrl());
        return false;
    }

    private void out(ServletResponse response, Map<String, Object> message) {
        try {
            response.setContentType("text/html;charset=UTF-8");
            response.setCharacterEncoding("UTF-8");
            PrintWriter out = response.getWriter();
            out.println(JSONObject.fromObject(message).toString());
            out.flush();
            out.close();
        } catch (Exception e) {
            LOGGER.info(" ------------ AuthenticationFilter out message fail ------------ ");
        }
    }

}