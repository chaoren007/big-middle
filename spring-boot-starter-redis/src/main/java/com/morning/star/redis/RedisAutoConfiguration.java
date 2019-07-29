package com.morning.star.redis;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisShardInfo;


@Configuration
@EnableConfigurationProperties(RedisProperties.class)
public class RedisAutoConfiguration {

    @Autowired
    private RedisProperties properties;


    @Bean
    public JedisPoolConfig getRedisConfig() {
        JedisPoolConfig config = new JedisPoolConfig();
        return config;
    }

    @Bean
    public Jedis jedis() {
        JedisShardInfo jedisShardInfo = new JedisShardInfo(properties.getIp(), properties.getPort(), -1);
        jedisShardInfo.setPassword(properties.getPwd());
        Jedis jedis = new Jedis(jedisShardInfo);
        return jedis;
    }


    @Bean
    public JedisConnectionFactory getConnectionFactory(JedisPoolConfig config) {
        JedisConnectionFactory factory = new JedisConnectionFactory();
        factory.setPoolConfig(config);
        factory.setUsePool(true);
        factory.setHostName(properties.getIp());
        factory.setPassword(properties.getPwd());
        factory.setPort(properties.getPort());
        return factory;
    }

    @Bean
    public RedisTemplate<String, String> stringRedisTemplate(RedisConnectionFactory factory) {
        StringRedisTemplate template = new StringRedisTemplate(factory);

        template.afterPropertiesSet();
        return template;
    }

    @Bean
    public RedisTemplate<byte[], byte[]> byteArrayTemplate(RedisConnectionFactory factory) {
        RedisTemplate<byte[], byte[]> template = new RedisTemplate<>();
        template.setConnectionFactory(factory);

        // 必须定义ByteArrayRedisSerializer，否则springboot会使用jdk序列化一遍byte数组
        RedisSerializer<byte[]> stringSerializer = new ByteArrayRedisSerializer();
        template.setKeySerializer(stringSerializer);
        template.setValueSerializer(stringSerializer);
        template.setHashKeySerializer(stringSerializer);
        template.setHashValueSerializer(stringSerializer);
        template.afterPropertiesSet();
        return template;
    }

    @Bean
    public Redis redis(JedisConnectionFactory factory) {
        return new RedisImpl(stringRedisTemplate(factory), byteArrayTemplate(factory));
    }
}
