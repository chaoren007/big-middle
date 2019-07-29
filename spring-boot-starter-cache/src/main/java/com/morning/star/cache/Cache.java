package com.morning.star.cache;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 添加该注解后，由CacheAspect进行缓存处理
 * Created by liangguobin on 2017/6/6.
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Cache {
    int timeout() default 60;    //    过期时间，单位s
    String key() default "";    // 自定义cache 的key，注意全局的唯一性
}
