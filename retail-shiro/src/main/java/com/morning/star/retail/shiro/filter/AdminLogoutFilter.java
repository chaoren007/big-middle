package com.morning.star.retail.shiro.filter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.LogoutFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.morning.star.retail.exception.LoginAccountErrorCode;

/**
 * 退出登录
 * 
 * @author jiangyf
 * @date 2017年10月27日 下午1:49:49
 */
public class AdminLogoutFilter extends LogoutFilter {
	private static final Logger LOGGER = LoggerFactory.getLogger(AdminLogoutFilter.class);

	@Override
	protected boolean preHandle(ServletRequest request, ServletResponse response) {
		Subject subject = getSubject(request, response);
		if (subject == null) {
			return false;
		}
		LOGGER.info("start ----------- logout ----------- account : {}", subject.getPrincipal());
		try {
			subject.logout();
		} catch (Exception e) {
			throw LoginAccountErrorCode.LOGOUT_FAILED.build();
		}
		LOGGER.info("end ----------- logout ----------- success");
		return false;
	}

}
