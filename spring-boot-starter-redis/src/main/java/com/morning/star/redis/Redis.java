package com.morning.star.redis;

import java.util.concurrent.TimeUnit;

public interface Redis {
    
	void set(String key, String t);

	void set(byte[] key, byte[] val);
	
	void setex(String key, String t, int expireSeconds);

	void setex(byte[] key, byte[] t, int expireSeconds);
	
	void setex(String key, String t, long timeout, TimeUnit unit);

	void setex(byte[] key, byte[] t, long timeout, TimeUnit unit);

	void publish(String key, String t);
	
	String get(String key);

	byte[] get(byte[] key);

	void delete(String key);

	void delete(byte[] key);

    Long getExpire(String key);

	Long getExpire(byte[] key);

    Long getExpire(String key, TimeUnit timeUnit);

	Long getExpire(byte[] key, TimeUnit timeUnit);

	Long incro (String key);
}