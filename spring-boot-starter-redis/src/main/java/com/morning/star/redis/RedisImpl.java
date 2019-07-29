package com.morning.star.redis;

import java.util.concurrent.TimeUnit;

import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.support.atomic.RedisAtomicLong;

public class RedisImpl implements Redis {

	private RedisTemplate<String, String> stringTemplate;
	private RedisTemplate<byte[], byte[]> template;

	public RedisImpl(RedisTemplate<String, String> stringTemplate, RedisTemplate<byte[], byte[]> template) {
        this.stringTemplate = stringTemplate;
        this.template = template;
    }

	@Override
	public void set(String key, String t) {
		ValueOperations<String, String> valueOper = stringTemplate.opsForValue();
		valueOper.set(key, t);
	}

	@Override
	public void set(byte[] key, byte[] val) {
		ValueOperations<byte[], byte[]> valueOper = template.opsForValue();
		valueOper.set(key, val);
	}

	@Override
	public void setex(String key, String t, int expireSeconds) {
		setex(key, t, expireSeconds, TimeUnit.SECONDS);
	}

	@Override
	public void setex(byte[] key, byte[] val, int expireSeconds) {
		setex(key, val, expireSeconds, TimeUnit.SECONDS);
	}

	@Override
	public void setex(String key, String t, long timeout, TimeUnit unit) {
	    if(timeout <= 0) {
	        throw new IllegalArgumentException("timeout must greater than 0, timeout: " + timeout);
        }

        ValueOperations<String, String> valueOper = stringTemplate.opsForValue();
        valueOper.set(key, t, timeout, unit);
	}

	@Override
	public void setex(byte[] key, byte[] t, long timeout, TimeUnit unit) {
        if(timeout <= 0) {
            throw new IllegalArgumentException("timeout must greater than 0, timeout: " + timeout);
        }

        ValueOperations<byte[], byte[]> valueOper = template.opsForValue();
        valueOper.set(key, t, timeout, unit);
	}

	@Override
	public void publish(String key, String t) {
		stringTemplate.convertAndSend(key, t);
	}

	@Override
	public String get(String key) {
		ValueOperations<String, String> valueOper = stringTemplate.opsForValue();
		String value = valueOper.get(key);
		return value;
	}

	@Override
	public byte[] get(byte[] key) {
		ValueOperations<byte[], byte[]> valueOper = template.opsForValue();
		return valueOper.get(key);
	}

	@Override
	public Long getExpire(String key) {
	    return stringTemplate.getExpire(key);
	}

	@Override
	public Long getExpire(byte[] key) {
		return template.getExpire(key);
	}



	@Override
    public Long getExpire(String key, TimeUnit timeUnit) {
        return stringTemplate.getExpire(key, timeUnit);
    }

	@Override
	public Long getExpire(byte[] key, TimeUnit timeUnit) {
		return template.getExpire(key, timeUnit);
	}

    @Override
	public void delete(String key) {
	    stringTemplate.delete(key);
	}

	@Override
	public void delete(byte[] key) {
		template.delete(key);
	}

    @Override
    public Long incro(String key) {
        return stringTemplate.opsForValue().increment(key, 1L);
    }
}