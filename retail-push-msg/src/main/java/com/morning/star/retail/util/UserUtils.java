package com.morning.star.retail.util;

import com.morning.star.redis.Redis;
import com.morning.star.retail.bean.AdminLoginContent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;


public class UserUtils {


    public static int EXP_ONE_DAY = 60 * 60 * 24;


    private static String LOGIN_TOKEN = "LOGIN_TOKEN_";

    private static final String DEVICE_INFO = "DEVICE_INFO_";
    
    private static final Logger logger = LoggerFactory.getLogger(UserUtils.class);


    /**
     * 设置用户信息
     *
     * @param key
     * @param val
     * @param exptime 值为0表示不设置有效期
     */
    public static void setUserInfo(String key, Object val, int exptime) {
        Context.getBean(Redis.class).setex(LOGIN_TOKEN + key, Json.toJson(val), exptime, TimeUnit.SECONDS);
    }

    /**
     * 获取用户信息
     *
     * @param key
     * @return
     */
    public static AdminLoginContent getUserInfo(String key) {
    	logger.info("Spring_INFO:{}" ,Context.getBean(Redis.class).toString());
    	logger.info("REDIS_BEAN:{}" ,Context.getBean(Redis.class).toString());
        String result = Context.getBean(Redis.class).get(LOGIN_TOKEN + key);
        if (result == null || result.equals("null")) {
            return null;
        } else {
            return Json.fromJson(result, AdminLoginContent.class);
        }
    }

    /**
     * 清空用户信息
     *
     * @param key
     */
    public static void clearUserInfo(String key) {
        Context.getBean(Redis.class).delete(LOGIN_TOKEN + key);
    }


    public static <T> T getDeviceInfo(String key, Class<T> cls) {
        String result = Context.getBean(Redis.class).get(DEVICE_INFO + key);
        if (result == null || result.equals("null")) {
            return null;
        } else {
            return Json.fromJson(result, cls);
        }
    }

}
