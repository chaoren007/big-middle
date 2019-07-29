package com.morning.star.retail;

import java.util.concurrent.TimeUnit;

import com.morning.star.redis.Redis;
import com.morning.star.retail.util.Context;
import com.morning.star.retail.util.Json;


/**
 * 用户 redis 管理工具类
 *
 * @author mantou
 */
public class UserUtils {


    public static int EXP_ONE_DAY = 60 * 60 * 24;


    private static String LOGIN_TOKEN = "LOGIN_TOKEN_";

    private static final String DEVICE_INFO = "DEVICE_INFO_";
    


    /**
     * 设置用户信息
     *
     * @param key
     * @param val
     * @param exptime 值为0表示不设置有效期
     */
    public static void setUserInfo(String key, Object val, int exptime) {
    	if(exptime <= 0){
    		Context.getBean(Redis.class).set(LOGIN_TOKEN + key, Json.toJson(val));
    	}else{
    		Context.getBean(Redis.class).setex(LOGIN_TOKEN + key, Json.toJson(val), exptime, TimeUnit.SECONDS);
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


    /**
     * 设置用户信息
     * @param key
     * @param val
     * @param exptime 值为0表示不设置有效期
     */
    public static void setDeviceInfo(String key, Object val, int exptime) {
    	if(exptime <= 0){
    		Context.getBean(Redis.class).set(DEVICE_INFO + key, Json.toJson(val));
    	}else {
    		 Context.getBean(Redis.class).setex(DEVICE_INFO + key, Json.toJson(val),exptime, TimeUnit.SECONDS);
    	}
       
    }

}
