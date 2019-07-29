package com.morning.star.retail.admin.shiro;

import com.google.gson.Gson;
import com.morning.star.retail.admin.dto.AccountDTO;
import com.morning.star.retail.admin.enums.AccountLevelEnum;
import com.morning.star.retail.admin.enums.LoginAccountStatusEnum;
import com.morning.star.retail.admin.facade.SupplierAccountFacade;
import com.morning.star.retail.base.sms.CaptchaDTO;
import com.morning.star.retail.cache.MyByteSource;
import com.morning.star.retail.exception.AdminErrorCode;
import com.morning.star.retail.exception.LoginAccountErrorCode;
import com.morning.star.retail.objectcopier.ObjectCopier;
import com.morning.star.retail.shiro.bean.LoginUser;
import com.morning.star.retail.shiro.bean.UserLogin;
import com.morning.star.retail.shiro.token.LoginType;
import com.morning.star.retail.shiro.token.RetailUsernamePasswordToken;
import com.morning.star.retail.util.CollectionUtil;
import com.morning.star.retail.util.LoggerUtil;
import com.morning.star.retail.util.RegexUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * 用户权限认证和授权
 *
 * @author jiangyf
 * @date 2017年7月31日 下午12:46:32
 */
public class LoginRealm extends AuthorizingRealm {

	@Autowired
	private SupplierAccountFacade accountFacade;

	/**
	 * 认证
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token)
		throws AuthenticationException {
		UserLogin userLogin = ((RetailUsernamePasswordToken) token).getUserLogin();
		String username = userLogin.getUsername();
		LoggerUtil.fmtInfo(getClass(), "start ----------- doGetAuthenticationInfo ----------- username : %s", username);
		LoginUser user;
		if (LoginType.CAPTCHA.equals(userLogin.getLoginType())) {
			user = checkGetLoginUserByCaptcha(userLogin);
		} else {
			user = checkGetLoginUser(username);
		}

		LoggerUtil.fmtInfo(getClass(), "end ----------- doGetAuthenticationInfo -----------");
		return new SimpleAuthenticationInfo(user, user.getPassword(), new MyByteSource(user.getSalt()), getName());
	}

	/**
	 * 授权
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		LoggerUtil.fmtInfo(getClass(), "start ----------- doGetAuthorizationInfo ----------- ");
		if (principals == null) {
			throw LoginAccountErrorCode.LOGIN_ACCOUNT_NOT_EXIST.build();
		}
		List<String> permissions = new ArrayList<>();
		SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
		authorizationInfo.setStringPermissions(new HashSet<>(CollectionUtil.removeBlank(permissions)));
		LoggerUtil.fmtInfo(getClass(), "end ----------- doGetAuthorizationInfo -----------");
		return authorizationInfo;
	}

	/**
	 * 检查获取登录用户信息
	 *
	 * @param username 用户名
	 * @return
	 */
	private LoginUser checkGetLoginUser(String username) {
		AccountDTO accountDTO;
		// 账号和手机号都能登录
		if (RegexUtil.isMobile(username)) {
			accountDTO = accountFacade.getAccount(username);
		} else {
			accountDTO = accountFacade.getAccountByName(username);
		}
		LoggerUtil.fmtInfo(getClass(), " ----------- checkGetLoginUser ----------- accountDTO : %s", new Gson().toJson(accountDTO));
		if (accountDTO == null) {
			throw AdminErrorCode.ADMIN_INFO_ERROR.build();
		}
		// 校验登录账户状态是否冻结
		if (LoginAccountStatusEnum.FREEZE.getCode().equals(accountDTO.getStatus())) {
			throw LoginAccountErrorCode.LOGIN_ACCOUNT_FREEZE.build();
		}
		// 校验登录账户状态是否作废
		if (LoginAccountStatusEnum.DELETE.getCode().equals(accountDTO.getStatus())) {
			throw LoginAccountErrorCode.LOGIN_ACCOUNT_DELETE.build();
		}
		LoginUser user = ObjectCopier.copyObject(LoginUser.class, accountDTO);
		user.setAccountLevel(accountDTO.getAccountLevel());
		user.setUsername(username);
		user.setPassword(accountDTO.getPassword());
		LoggerUtil.fmtInfo(getClass(), " ----------- checkGetLoginUser ----------- user : %s", new Gson().toJson(user));
		return user;
	}

	private LoginUser checkGetLoginUserByCaptcha(UserLogin userLogin) {
		CaptchaDTO captchaDTO = new CaptchaDTO();
		captchaDTO.setMobile(userLogin.getUsername());
		captchaDTO.setCaptcha(userLogin.getPassword());
		AccountDTO accountDTO = accountFacade.checkCaptcha(captchaDTO, AccountLevelEnum.SUPPLIER);
		LoggerUtil.fmtInfo(getClass(), " ----------- checkGetLoginUser ----------- accountDTO : %s", new Gson().toJson(accountDTO));
		if (accountDTO == null) {
			throw AdminErrorCode.ADMIN_INFO_ERROR.build();
		}
		// 校验登录账户状态是否冻结
		if (LoginAccountStatusEnum.FREEZE.getCode().equals(accountDTO.getStatus())) {
			throw LoginAccountErrorCode.LOGIN_ACCOUNT_FREEZE.build();
		}
		// 校验登录账户状态是否作废
		if (LoginAccountStatusEnum.DELETE.getCode().equals(accountDTO.getStatus())) {
			throw LoginAccountErrorCode.LOGIN_ACCOUNT_DELETE.build();
		}
		LoginUser user = ObjectCopier.copyObject(LoginUser.class, accountDTO);
		user.setAccountLevel(accountDTO.getAccountLevel());
		user.setUsername(accountDTO.getAccount());
		user.setPassword(accountDTO.getPassword());
		user.setLoginType(userLogin.getLoginType());
		LoggerUtil.fmtInfo(getClass(), " ----------- checkGetLoginUser ----------- user : %s", new Gson().toJson(user));
		return user;
	}

	/**
	 * 获取用户输入的明文密码
	 *
	 * @param token
	 * @return
	 */
	private String getInputPassword(AuthenticationToken token) {
		return new String((char[]) token.getCredentials());
	}


	/**
	 * 清空当前用户认证信息
	 */
	@Override
	public void clearCachedAuthenticationInfo(PrincipalCollection principals) {
		super.clearCachedAuthenticationInfo(principals);
	}

	/**
	 * 清空当前用户授权信息
	 */
	public void clearCachedAuthorizationInfo() {
		PrincipalCollection principalCollection = SecurityUtils.getSubject().getPrincipals();
		SimplePrincipalCollection principals = new SimplePrincipalCollection(principalCollection, getName());
		super.clearCachedAuthorizationInfo(principals);
	}

	/**
	 * 清除指定 principalCollection
	 */
	@Override
	public void clearCachedAuthorizationInfo(PrincipalCollection principalCollection) {
		SimplePrincipalCollection principals = new SimplePrincipalCollection(principalCollection, getName());
		super.clearCachedAuthorizationInfo(principals);
	}

	/**
	 * 清除用户缓存信息
	 */
	@Override
	public void clearCache(PrincipalCollection principals) {
		super.clearCache(principals);
	}

	/**
	 * 清除所有认证信息
	 */
	public void clearAllCachedAuthenticationInfo() {
		getAuthenticationCache().clear();
	}

	/**
	 * 清除所有授权信息
	 */
	public void clearAllCachedAuthorizationInfo() {
		getAuthorizationCache().clear();
	}

	/**
	 * 清除所有认证/授权信息
	 */
	public void clearAllCache() {
		clearAllCachedAuthenticationInfo();
		clearAllCachedAuthorizationInfo();
	}

}
