package com.morning.star.cache;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.lang.reflect.Method;

/**
 * 缓存切面处理
 * Created by liangguobin on 2017/6/6.
 */
@Aspect
//@EnableAspectJAutoProxy
public class CacheAspect {

    private Logger logger = LoggerFactory.getLogger(CacheAspect.class);



    private CacheTemplate cacheManager;


    private CacheKeyGenerator keyGenerator;

    CacheAspect(CacheTemplate CacheManager, CacheKeyGenerator keyGenerator) {
        logger.info("CacheAspect is init");
        this.cacheManager = CacheManager;
        this.keyGenerator = keyGenerator;
    }

    /**
     * 对接口处理结果为null，缓存nullCache对象
     */
    private static final NullCache nullCache = new NullCache();


    @Around("@annotation(cache)")
    public Object cache(ProceedingJoinPoint joinPoint, Cache cache) throws Throwable {
        Signature signature = joinPoint.getSignature();
        // 获取返回的class对象
        Class clazz = null;
        if(signature instanceof  MethodSignature) {
            MethodSignature methodSignature = (MethodSignature)signature;
            Method targetMethod = methodSignature.getMethod();

            clazz = targetMethod.getReturnType();
            if(clazz == void.class) {   // 对于返回void的方法，缓存结果为NullCache
                clazz = NullCache.class;
            }

        }


        String key = generateKey(joinPoint, cache);

        Object o = cacheManager.getCache(key, clazz, joinPoint.getArgs());   // 查询缓存
        if(o == null) {     // 查询失败

            o = joinPoint.proceed(joinPoint.getArgs());     // 调用接口

            if(o == null) {     // 处理接口结果为null的情况
                cacheManager.setCache(key, nullCache, cache.timeout(), joinPoint.getArgs());  // 设置缓存
            } else {
                cacheManager.setCache(key, o, cache.timeout(), joinPoint.getArgs());  // 设置缓存
            }


        } else if(o instanceof NullCache){  // 缓存结果为null

            o = null;
        } else {
//            已命中缓存， 直接返回就行
//            logger.debug("cache hit - {}", key);
        }

        return o;
    }

    /**
     * cache key如何保证唯一性
     *
     *
     * 现在的方案 hash(className + methodName) + methodName + arg
     * hash + methodName  可以减少hash冲突， 也方便key查看
     * 生成cache key
     * @param joinPoint
     * @return
     */
    private String generateKey(ProceedingJoinPoint joinPoint, Cache cache) {
        if(cache.key() != null && cache.key().length() > 0) {
            return cache.key();
        }

        StringBuilder key = new StringBuilder();

        Class clazz = joinPoint.getTarget().getClass();



        String className = clazz.getName();
        String methodName = joinPoint.getSignature().getName();


        key.append((className + methodName).hashCode()).append("_");
        key.append(methodName).append(".");
        key.append(methodName).append("|");


        return key.toString();
    }



}