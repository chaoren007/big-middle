package com.morning.star.retail.shiro.token;

import com.morning.star.retail.enums.PlatformEnum;
import com.morning.star.retail.shiro.bean.LoginUser;
import com.morning.star.retail.shiro.bean.UserLogin;
import com.morning.star.retail.shiro.exception.InvalidException;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;

import java.util.Arrays;
import java.util.List;

/**
 * Token工具类
 *
 * @author jiangyf
 */
public class TokenManager {
	public static List<String> godLevelList = Arrays.asList("root");
	public static List<String> groupLevelList = Arrays.asList("group", "normal");
	public static List<String> storeLevelList = Arrays.asList("store", "clerk");
	public static List<String> supplierLevelList = Arrays.asList("supplier");

	/**
	 * 获取主体
	 *
	 * @return
	 */
	public static Subject subject() {
		Subject subject = SecurityUtils.getSubject();
		if (subject == null) {
			throw new InvalidException();
		}
//		Validate.isTrue(subject != null, "用户登录信息失效，请重新登录");
		return subject;
	}

	/**
	 * 登录
	 *
	 * @param user
	 */
	public static LoginUser login(UserLogin user, PlatformEnum platform) {
		Validate.isTrue(user != null, "请输入用户名和密码");
		Validate.isTrue(StringUtils.isNotBlank(user.getUsername()), "用户名不能为空");
		Validate.isTrue(StringUtils.isNotBlank(user.getPassword()), "密码不能为空");
		LoginUser loginUser = login(user.getUsername(), user.getPassword(), user.getRememberMe(), user);
		boolean flag = false;
		String level = loginUser.getAccountLevel();
		if ((PlatformEnum.GOD.equals(platform) && godLevelList.contains(level))
			|| (PlatformEnum.GROUP.equals(platform) && groupLevelList.contains(level))
			|| ((PlatformEnum.STORE.equals(platform) || PlatformEnum.POS.equals(platform)) && storeLevelList.contains(level))
			|| (PlatformEnum.SUPPLIER.equals(platform) && supplierLevelList.contains(level))
			) {
			flag = true;
		}
		if (!flag) {
			subject().logout();
		}
		Validate.isTrue(flag, "该账号非本系统账号");
		return loginUser;
	}

	/**
	 * 登录
	 *
	 * @param username   用户名
	 * @param password   密码
	 * @param rememberMe 密码
	 */
	public static LoginUser login(String username, String password, Boolean rememberMe, UserLogin userLogin) {
//        UsernamePasswordToken token = new UsernamePasswordToken(username, password, rememberMe);
		RetailUsernamePasswordToken token = new RetailUsernamePasswordToken(username, password, rememberMe, userLogin);
		subject().login(token);
		return getLoginUser();
	}

	/**
	 * 登录
	 *
	 * @param user
	 * @param rememberMe
	 * @return
	 */
	public static LoginUser login(LoginUser user, Boolean rememberMe) {
		ShiroToken token = new ShiroToken(user.getUsername(), user.getPassword());
		token.setRememberMe(rememberMe);
		subject().login(token);
		return getLoginUser();
	}

	/**
	 * 判断是否登录
	 *
	 * @return
	 */
	public static boolean isLogin() {
		return null != subject().getPrincipal();
	}

	/**
	 * 退出登录
	 */
	public static void logout() {
		subject().logout();
	}

	/**
	 * 获取当前登录的用户User对象
	 *
	 * @return
	 */
	public static LoginUser getLoginUser() {
		LoginUser loginUser = (LoginUser) subject().getPrincipal();
		if (loginUser == null) {
			throw new InvalidException();
		}
//		Validate.isTrue(loginUser != null, "用户登录信息失效，请重新登录");
		return loginUser;
	}

	/**
	 * 获取当前用户的Session
	 *
	 * @return
	 */
	public static Session getSession() {
		return subject().getSession();
	}


	/**
	 * 获取当前用户名称
	 *
	 * @return
	 */
	public static String getUsername() {
		return getLoginUser().getUsername();
	}

	/**
	 * 把值放入到当前登录用户的Session里
	 *
	 * @param key
	 * @param value
	 */
	public static void setVal2Session(Object key, Object value) {
		getSession().setAttribute(key, value);
	}

	/**
	 * 从当前登录用户的Session里取值
	 *
	 * @param key
	 * @return
	 */
	public static Object getVal2Session(Object key) {
		return getSession().getAttribute(key);
	}

	/**
	 * 获取验证码，获取一次后删除
	 *
	 * @return
	 */
	public static String getYZM() {
		String code = (String) getSession().getAttribute("CODE");
		getSession().removeAttribute("CODE");
		return code;
	}

}

