package com.morning.star.cache;


/**
 * 缓存管理器
 * Created by liangguobin on 2017/6/6.
 */
public interface CacheTemplate<T> {

//    Object getCache(Class clazz, CacheKey key, Object... params);

//    void setCache(Object val, int expire, CacheKey key, Object... params);

    void  removeCache(String key, Object... params);

    /**
     * 查询缓存
     * @param key
     * @return
     */
    T getCache(String key, Class<T> clazz, Object... params);



    /**
     * 设置缓存
     * @param key
     * @param o
     * @param timeout
     */
    void setCache(String key, T o, int timeout, Object... params);

}
