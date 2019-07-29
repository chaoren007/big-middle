package com.morning.star.redis;



import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;


@ConfigurationProperties(prefix = "redis")
public class RedisProperties {
    
    @Value("${redis.ip}")
    private String ip;
    @Value("${redis.port}")
    private int port;
    @Value("${redis.pwd}")
    private String pwd;
    
    public String getIp() {
        return ip;
    }

    public int getPort() {
        return port;
    }

    public String getPwd() {
        return pwd;
    }

}
