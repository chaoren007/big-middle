package com.morning.star.retail.admin.shiro;

import java.util.HashSet;
import java.util.List;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import com.google.gson.Gson;
import com.morning.star.retail.admin.dto.AccountDTO;
import com.morning.star.retail.admin.enums.LoginAccountStatusEnum;
import com.morning.star.retail.admin.facade.AccountFacade;
import com.morning.star.retail.admin.facade.RoleFacade;
import com.morning.star.retail.cache.MyByteSource;
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
        AccountDTO accountDTO = accountFacade.getGroupAccount(username);
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
        user.setUsername(username);
        user.setAccountLevel(accountDTO.getAccountLevel());
        user.setAccessIds(accountDTO.getAccessIds());
        LoggerUtil.fmtInfo(getClass(), " ----------- checkGetLoginUser ----------- user : %s", new Gson().toJson(user));
        return user;
    }

}

