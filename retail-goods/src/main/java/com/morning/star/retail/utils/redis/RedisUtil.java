package com.morning.star.retail.utils.redis;

import com.morning.star.redis.Redis;
import com.morning.star.retail.util.Context;
import org.springframework.stereotype.Component;

/**
 * @Author: kimhuhg
 * @Date: 18-11-26 下午3:40
 * @desc: 缓存工具类
 */
@Component
public class RedisUtil {
    public void set(String key, String value) {
        Context.getBean(Redis.class).set(key, value);
    }

    public String get(String key) {
        return Context.getBean(Redis.class).get(key);
    }

    public Long incro (String key) {
        return Context.getBean(Redis.class).incro(key);
    }
    public void setex (String key, String t, int expireSeconds) {
        Context.getBean(Redis.class).setex(key,t,expireSeconds);
    }
}