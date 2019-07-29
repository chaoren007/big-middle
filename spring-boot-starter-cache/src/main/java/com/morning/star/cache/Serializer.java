package com.morning.star.cache;

/**
 * Created by liangguobin on 2017/6/9.
 */
public interface Serializer {

    byte[] serialize(Object o) ;

    String serializeToString(Object o);

    <T> T deserialize(byte[] bytes, Class<T> clazz);

}