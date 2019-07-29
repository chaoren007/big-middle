package com.morning.star.cache;


import com.morning.star.redis.Redis;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * redis缓存处理器
 * Created by liangguobin on 2017/6/6.
 */
public class RedisCacheTemplate<T> implements CacheTemplate<T>, CacheHashTemplate<T> {
    private Logger logger = LoggerFactory.getLogger(RedisCacheTemplate.class);

    private Serializer serializeUtils;

    private Redis redis;
    private RedisTemplate<byte[], byte[]> redisTemplate;
    private HashOperations<byte[], byte[], byte[]> hashOperations;
    private CacheKeyGenerator keyGenerator;

    public RedisCacheTemplate(CacheKeyGenerator keyGenerator, Serializer serializeUtils, Redis redis, RedisTemplate<byte[], byte[]> redisTemplate) {
        this.keyGenerator = keyGenerator;
        this.serializeUtils = serializeUtils;
        this.redis = redis;
        this.redisTemplate = redisTemplate;
        this.hashOperations = redisTemplate.opsForHash();
    }


    @Override
    public void removeCache(String key, Object... params) {

    }

    @Override
    public T getCache(String key, Class<T> clazz, Object... params) {
        try {

            KeyContext keyContext = keyGenerator.generateKey(key, params);
            byte[] data = redis.get(keyContext.getBytes());  // 查询数据
            logger.debug("cache {} - {}", data == null ? "miss" : "hit",keyContext.getStr());

            return serializeUtils.deserialize(data, clazz);    // 反系列化
        } catch (Exception e) {
            logger.error("redis cache", "redis cache get cache error, key : {}", key, e);
        }

        return null;
    }

    @Override
    public void setCache(String key, Object o, int expire, Object... params) {
        try {
            if (expire > 0) {
                redis.setex(keyGenerator.generateKey(key, params).getBytes(), serializeUtils.serialize(o), expire);
            }
            else {
                redis.set(key.getBytes(), serializeUtils.serialize(o));
            }
        } catch (Exception e) {
            logger.error("redis cache", "redis cache set cache error, key : {}", key, e);
        }
    }


    @Override
    public void pushHash(String key, Map<String, T> map, int expireInSec) {
        KeyContext keyContext = keyGenerator.generateKey(key);
        Map<byte[], byte[]> putMap = new HashMap<>();
        map.entrySet().forEach(e -> {
            if(e.getKey() != null && e.getValue() != null) {
                putMap.put(e.getKey().getBytes(), serializeUtils.serialize(e.getValue()));
            }
        });

        redisTemplate.expire(keyContext.getBytes(), expireInSec, TimeUnit.SECONDS);
        hashOperations.putAll(keyContext.getBytes(), putMap);
    }

    @Override
    public boolean pushToHash(String key, String hashKey, T val, boolean isCreate) {
        byte[] keyBytes = keyGenerator.generateKey(key).getBytes();
        if(!isCreate && !redisTemplate.hasKey(keyBytes)) {
            return false;
        }

        hashOperations.put(keyBytes, hashKey.getBytes(), serializeUtils.serialize(val));
        return true;
    }

    @Override
    public T getHashVal(String key, String hashkey, Class<T> t) {

        byte[] bytes = hashOperations.get(keyGenerator.generateKey(key).getBytes(), hashkey.getBytes());


        if(bytes == null) {
            return null;
        }

        return serializeUtils.deserialize(bytes, t);
    }

    @Override
    public Map<String, T> getHash(String key, Class<T> t) {

        KeyContext keyContext = keyGenerator.generateKey(key);
        Map<byte[], byte[]> getMap = hashOperations.entries(keyContext.getBytes());

        logger.debug("cache hash key {} : {}", getMap == null ? "miss":"hit", keyContext.getStr());

        if(getMap == null) {
            return new HashMap<>();
        }

        Map<String, T> result = new HashMap<>();
        getMap.entrySet().forEach(e -> {
            result.put(new String(e.getKey()), serializeUtils.deserialize(e.getValue(), t));
        });
        return result;
    }

    @Override
    public void removeHashVal(String key, String hashkey) {
        hashOperations.delete(keyGenerator.generateKey(key).getBytes(), hashkey.getBytes());
    }

    @Override
    public void removeHash(String key) {
        redisTemplate.delete(keyGenerator.generateKey(key).getBytes());
    }



}