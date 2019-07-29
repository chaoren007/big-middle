package com.morning.star.retail.admin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.Filter;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.mgt.eis.EnterpriseCacheSessionDAO;
import org.apache.shiro.session.mgt.eis.JavaUuidSessionIdGenerator;
import org.apache.shiro.session.mgt.quartz.QuartzSessionValidationScheduler;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.apache.shiro.web.filter.authc.LogoutFilter;
import org.apache.shiro.web.mgt.CookieRememberMeManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.cache.CacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.core.RedisTemplate;

import com.morning.star.retail.admin.shiro.LoginRealm;
import com.morning.star.retail.cache.ShiroSpringCacheManager;
import com.morning.star.retail.shiro.credentials.RetryLimitHashedCredentialsMatcher;
import com.morning.star.retail.shiro.util.CryptoUtil;

@Configuration
public class ShiroConfiguration {

    @Bean
    public ShiroFilterFactoryBean shiroFilter(SecurityManager securityManager) {
        Map<String, Filter> filters = new HashMap<>();
        filters.put("authc", new FormAuthenticationFilter());
        filters.put("logout", new LogoutFilter());

        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
        bean.setSecurityManager(securityManager);
        bean.setLoginUrl("/api/admin/login");
        bean.setSuccessUrl("/");
        bean.setUnauthorizedUrl("/api/admin/unauthorized");
        // 自定义过滤器
        bean.setFilters(filters);
        // filterChainDefinitions 用于声明 url 和 filter 的关系，即 ini 配置中的[urls]部分；anon：匿名；authc：登录认证；user：用户已登录；logout：退出
        bean.setFilterChainDefinitions("/api/admin/login=anon\n"
                + "/api/admin/logout=logout\n"
            + "/api/account/check-captcha=anon\n"
        +"/api/account/change-password=anon");
        return bean;
    }

    /**
     * 基于 Form 表单的身份验证过滤器
     *
     * @return
     */
    @Bean
    public FormAuthenticationFilter formAuthenticationFilter() {
        FormAuthenticationFilter filter = new FormAuthenticationFilter();
        filter.setUsernameParam("username");
        filter.setPasswordParam("password");
        filter.setRememberMeParam("rememberMe");
        return filter;
    }

    /**
     * 缓存管理器，使用 Ehcache 实现
     *
     * @return
     */
//    @Bean
//    public EhCacheManager ehCacheManager() {
//        EhCacheManager ehCacheManager = new EhCacheManager();
//        ehCacheManager.setCacheManagerConfigFile("classpath:shiro-ehcache.xml");
//        return ehCacheManager;
//    }
    @Bean
    public CacheManager springCacheManager(RedisTemplate<String, String> redisTemplate) {
        RedisCacheManager cacheManager = new RedisCacheManager(redisTemplate);
        cacheManager.setDefaultExpiration(600L);
        List<String> cacheNames = new ArrayList<>();
        cacheNames.add("authenticationCache");
        cacheNames.add("authorizationCache");
        cacheNames.add("activeSessionsCache");
        cacheNames.add("passwordRetryCache");
        cacheManager.setCacheNames(cacheNames);
        Map<String, Long> expires = new HashMap<>();
        expires.put("authenticationCache", 1800L);
        expires.put("authorizationCache", 1800L);
        expires.put("activeSessionsCache", 1800L);
        expires.put("passwordRetryCache", 1800L);
        cacheManager.setExpires(expires);
        return cacheManager;
    }

    /**
     * 缓存管理器，使用 redis 实现
     *
     * @return
     */
    @Bean
    public ShiroSpringCacheManager ssCacheManager(CacheManager springCacheManager, RedisTemplate<byte[], byte[]> redis) {
        ShiroSpringCacheManager cacheManager = new ShiroSpringCacheManager();
        cacheManager.setCacheManager(springCacheManager);
        cacheManager.setRedis(redis);
        return cacheManager;
    }

    /**
     * 凭证匹配器
     *
     * @return
     */
    @Bean
    public RetryLimitHashedCredentialsMatcher credentialsMatcher(ShiroSpringCacheManager ssCacheManager) {
        RetryLimitHashedCredentialsMatcher credentialsMatcher = new RetryLimitHashedCredentialsMatcher(ssCacheManager);
        // 散列算法
        credentialsMatcher.setHashAlgorithmName(CryptoUtil.algorithmName);
        // 迭代次数
        credentialsMatcher.setHashIterations(CryptoUtil.hashIterations);
        // true:存储散列后的密码为16进制，false:默认base64
        credentialsMatcher.setStoredCredentialsHexEncoded(false);
        return credentialsMatcher;
    }

    /**
     * 登录 Realm 实现
     *
     * @return
     */
    @Bean
    public LoginRealm loginRealm(RetryLimitHashedCredentialsMatcher credentialsMatcher) {
        LoginRealm loginRealm = new LoginRealm();
        loginRealm.setCredentialsMatcher(credentialsMatcher);
        loginRealm.setCachingEnabled(false);
        loginRealm.setAuthenticationCachingEnabled(false);
        loginRealm.setAuthenticationCacheName("authenticationCache");
        loginRealm.setAuthorizationCachingEnabled(false);
        loginRealm.setAuthorizationCacheName("authorizationCache");
        return loginRealm;
    }

    /**
     * 会话 ID 生成器
     *
     * @return
     */
    @Bean
    public JavaUuidSessionIdGenerator sessionIdGenerator() {
        JavaUuidSessionIdGenerator sessionIdGenerator = new JavaUuidSessionIdGenerator();
        return sessionIdGenerator;
    }

    /**
     * 会话持久化
     *
     * @return
     */
    @Bean
    public EnterpriseCacheSessionDAO sessionDAO() {
        EnterpriseCacheSessionDAO sessionDAO = new EnterpriseCacheSessionDAO();
        sessionDAO.setActiveSessionsCacheName("activeSessionsCache");
        sessionDAO.setSessionIdGenerator(sessionIdGenerator());
        return sessionDAO;
    }

    /**
     * 会话 Cookie 模板
     *
     * @return
     */
    @Bean
    public SimpleCookie sessionIdCookie() {
        SimpleCookie sessionIdCookie = new SimpleCookie("sid");
        // 如果设置为 true，则客户端不会暴露给客户端脚本代码，使用HttpOnly cookie有助于减少某些类型的跨站点脚本攻击；此特性需要实现了 Servlet 2.5 MR6及以上版本的规范的 Servlet 容器支持
        sessionIdCookie.setHttpOnly(true);
        // 设置 Cookie 的过期时间，单位：秒，默认-1表示关闭浏览器时过期 Cookie
        sessionIdCookie.setMaxAge(180000);
        return sessionIdCookie;
    }

    /**
     * rememberMe 会话 Cookie 模板
     *
     * @return
     */
    @Bean
    public SimpleCookie rememberMeCookie() {
        SimpleCookie rememberMeCookie = new SimpleCookie("rememberMe");
        rememberMeCookie.setHttpOnly(true);
        /** 设置 Cookie 的过期时间30天 **/
        rememberMeCookie.setMaxAge(2592000);
        return rememberMeCookie;
    }

    /**
     * 会话管理器
     *
     * @return
     */
    @Bean
    public DefaultWebSessionManager sessionManager() {
        DefaultWebSessionManager sessionManager = new DefaultWebSessionManager();
        // 会话的全局过期时间（单位：毫秒），默认 30 分钟
        sessionManager.setGlobalSessionTimeout(1800000);
        // 是否开启删除过期会话，默认是开启的，在会话过期后会调用 SessionDAO 的 delete 方法删除会话：如会话时持久化存储的，可以调用此方法进行删除
        sessionManager.setDeleteInvalidSessions(true);
        // 是否启用/禁用会话验证调器，默认是开启的
        sessionManager.setSessionDAO(sessionDAO());
        // 是否启用/禁用 Session Id Cookie，默认是启用的
        // 如果禁用后将不会设置 Session Id Cookie，即默认使用了 Servlet 容器的 JSESSIONID，且通过 URL 重写（URL 中的“;JSESSIONID=id”部分）保存 Session Id
        sessionManager.setSessionIdCookieEnabled(true);
        sessionManager.setSessionIdCookie(sessionIdCookie());
        return sessionManager;
    }

    /**
     * rememberMe 会话管理器
     *
     * @return
     */
    @Bean
    public CookieRememberMeManager rememberMeManager() {
        CookieRememberMeManager rememberMeManager = new CookieRememberMeManager();
        // cipherKey 是加密 rememberMe Cookie 的密钥；默认 AES 算法
        rememberMeManager.setCipherKey(org.apache.shiro.codec.Base64.decode("4AvVhmFLUs0KTA3Kprsdag=="));
        rememberMeManager.setCookie(rememberMeCookie());
        return rememberMeManager;
    }

    /**
     * Quartz 会话验证调度器，用于定期的验证会话是否已过期，如果过期将停止会话
     *
     * @return
     */
    @Bean
    public QuartzSessionValidationScheduler sessionValidationScheduler() {
        QuartzSessionValidationScheduler sessionValidationScheduler = new QuartzSessionValidationScheduler();
        // 设置调度时间间隔，单位:毫秒，默认就是 1 小时
        sessionValidationScheduler.setSessionValidationInterval(1800000);
        // 设置会话验证调度器进行会话验证时的会话管理器
        DefaultWebSessionManager sessionManager = sessionManager();
        sessionValidationScheduler.setSessionManager(sessionManager);
        sessionManager.setSessionValidationSchedulerEnabled(true);
        sessionManager.setSessionValidationScheduler(sessionValidationScheduler);
        return sessionValidationScheduler;
    }

    /**
     * 安全管理器
     *
     * @return
     */
    @Bean
    public DefaultWebSecurityManager securityManager(ShiroSpringCacheManager ssCacheManager, LoginRealm loginRealm) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealms(Arrays.asList(loginRealm));
        securityManager.setSessionManager(sessionManager());
        securityManager.setCacheManager(ssCacheManager);
        // 状态安全管理器
        SecurityUtils.setSecurityManager(securityManager);
        return securityManager;
    }

    /**
     * 生命周期处理器
     *
     * @return
     */
    @Bean
    public LifecycleBeanPostProcessor lifecycleBeanPostProcessor() {
        LifecycleBeanPostProcessor lifecycleBeanPostProcessor = new LifecycleBeanPostProcessor();
        return lifecycleBeanPostProcessor;
    }

    /**
     * 开启添加权限的注解扫描
     *
     * @return
     */
    @Bean
    @DependsOn("lifecycleBeanPostProcessor")
    public DefaultAdvisorAutoProxyCreator advisorAutoProxyCreator() {
        DefaultAdvisorAutoProxyCreator advisorAutoProxyCreator = new DefaultAdvisorAutoProxyCreator();
        advisorAutoProxyCreator.setProxyTargetClass(true);
        return advisorAutoProxyCreator;
    }

    /**
     * 开启 Shiro Spring AOP 权限注解的支持
     */
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(DefaultWebSecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
        return authorizationAttributeSourceAdvisor;
    }
}
