package com.morning.star.retail.admin.shiro;

import java.util.HashSet;
import java.util.List;

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

import com.google.gson.Gson;
import com.morning.star.retail.admin.dto.AccountDTO;
import com.morning.star.retail.admin.enums.LoginAccountStatusEnum;
import com.morning.star.retail.admin.facade.AccountFacade;
import com.morning.star.retail.admin.facade.RoleFacade;
import com.morning.star.retail.admin.helper.StoreService;
import com.morning.star.retail.cache.MyByteSource;
import com.morning.star.retail.dto.store.StoreDTO;
import com.morning.star.retail.exception.AccessErrorCode;
import com.morning.star.retail.exception.AdminErrorCode;
import com.morning.star.retail.exception.LoginAccountErrorCode;
import com.morning.star.retail.objectcopier.ObjectCopier;
import com.morning.star.retail.shiro.bean.LoginUser;
import com.morning.star.retail.shiro.token.TokenManager;
import com.morning.star.retail.util.CollectionUtil;
import com.morning.star.retail.util.LoggerUtil;

/**
 * 用户权限认证和授权
 *
 * @author jiangyf
 * @date 2017年7月31日 下午12:46:32
 */
public class LoginRealm extends AuthorizingRealm {

    @Autowired
    private AccountFacade accountFacade;
    @Autowired
    private RoleFacade roleFacade;
    @Autowired
    private StoreService storeService;

    /**
     * 认证
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token)
            throws AuthenticationException {
        String username = (String) token.getPrincipal();
        LoggerUtil.fmtInfo(getClass(), "start ----------- doGetAuthenticationInfo ----------- username : %s", username);
        LoginUser user = checkGetLoginUser(username);
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
        LoginUser user = TokenManager.getLoginUser();
        List<String> permissions = roleFacade.queryResource(user.getAccessIds());
        if (permissions.isEmpty()) {
            throw AccessErrorCode.LOGIN_ACCOUNT_NO_ACCESS.build();
        }
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
        AccountDTO accountDTO = accountFacade.getStoreAccount(username);
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
        StoreDTO store = storeService.getStore(accountDTO.getStoreCode());
        LoginUser user = ObjectCopier.copyObject(LoginUser.class, accountDTO);
        user.setAccountLevel(accountDTO.getAccountLevel());
        user.setUsername(username);
        user.setStoreName(store == null ? null : store.getStoreName());
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
