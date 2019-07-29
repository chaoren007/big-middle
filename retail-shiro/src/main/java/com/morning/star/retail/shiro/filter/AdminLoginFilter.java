package com.morning.star.retail.shiro.filter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.morning.star.retail.consts.RetailDefaultConst;
import com.morning.star.retail.exception.LoginAccountErrorCode;

/**
 * 账号登录
 * 
 * @author jiangyf
 * @date 2017年10月27日 下午1:49:49
 */
public class AdminLoginFilter extends FormAuthenticationFilter {
	private static final Logger LOGGER = LoggerFactory.getLogger(AdminLoginFilter.class);

	@Override
	protected boolean preHandle(ServletRequest request, ServletResponse response) {
		Subject subject = getSubject(request, response);
		if (subject == null) {
			return false;
		}
		String token = ((HttpServletRequest) request).getHeader(RetailDefaultConst.ADMIN_TOKEN);
		try {
			subject.logout();
		} catch (Exception e) {
			throw LoginAccountErrorCode.LOGOUT_FAILED.build();
		}
		return false;
	}

	protected boolean executeLogin(ServletRequest request, ServletResponse response) throws Exception {
		AuthenticationToken token = createToken(request, response);
		if (token == null) {
			throw new IllegalStateException("create AuthenticationToken error");
		}
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		String username = (String) token.getPrincipal();
		LOGGER.info("start ----------- login ----------- account : {}", username);
		try {
			Subject subject = getSubject(request, response);
			subject.login(token);
		} catch (AuthenticationException e) {
		}

		LOGGER.info("end ----------- login ----------- success");
		return true;
	}

}
