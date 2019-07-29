package com.morning.star.cache;

import com.morning.star.redis.Redis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import org.springframework.data.redis.core.RedisTemplate;

@Configuration
@ConditionalOnProperty(name = "cache_key_pre")
public class CacheAutoConfiguration {
    /**
     * DB_BASE_PACKAGE
     */
    private static final String KEY_PRE_CONFIG ="cache_key_pre";


    @Autowired
    private Redis redis;

    @Autowired
    private RedisTemplate<byte[], byte[]> redisTemplate;

    @Bean
    public Serializer serializeUtils() {
        Serializer serializeUtils = new KryoSerializer();
        return serializeUtils;
    }


    @Bean
    public CacheKeyGenerator cacheKeyGenerator(Environment env) {

        CacheKeyGenerator keyGenerator = new CacheKeyGenerator(env.getProperty(KEY_PRE_CONFIG), new CglibSerializer());

        return keyGenerator;
    }

    @Bean
    public KeyContext keyContext(Environment env) {
        KeyContext keyContext = new KeyContext(env.getProperty(KEY_PRE_CONFIG));
        return keyContext;
    }


/*
    @Bean
    public CacheTemplate cacheTemplate(Serializer serializeUtils) {
        CacheTemplate cacheManager = new RedisCacheTemplate(serializeUtils, redis, redisTemplate);
        return cacheManager;
    }
*/

    @Bean
    public CacheHashTemplate cacheHashTemplate(CacheKeyGenerator keyGenerator, Serializer serializeUtils) {
        CacheHashTemplate cacheManager = new RedisCacheTemplate(keyGenerator, serializeUtils, redis, redisTemplate);
        return cacheManager;
    }

    @Bean
    public CacheAspect aspect(CacheHashTemplate managerStringKey, CacheKeyGenerator keyGenerator) {
        return new CacheAspect(managerStringKey, keyGenerator);
    }

}
