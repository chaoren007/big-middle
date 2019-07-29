package com.morning.star.cache;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * Created by liangguobin on 2017/6/12.
 */
public class JsonSerializer implements Serializer {
    private Logger logger = LoggerFactory.getLogger(JsonSerializer.class);

    private static ObjectMapper mapper = new ObjectMapper();
    static {
        mapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);

        // 使用该配置, jackson会将序列化的class信息都放到结果中, 反序列化时不会因为泛型或复杂对象报错
        mapper.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
    }



    @Override
    public byte[] serialize(Object o) {
        String json = serializeToString(o);

        byte[] bytes =  json.getBytes();

        return bytes;
    }

    @Override
    public String serializeToString(Object o) {
        try {

            return mapper.writeValueAsString(o);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Object deserialize(byte[] bytes, Class clazz) {
        if(bytes == null) {
            return null;
        }

        if(clazz == null) {
            throw new IllegalArgumentException("json deserialize clazz is null");
        }

        String json = new String(bytes);

        try {
            return mapper.readValue(json, clazz);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}