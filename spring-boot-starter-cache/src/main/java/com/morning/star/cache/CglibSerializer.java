package com.morning.star.cache;

import org.springframework.cglib.beans.BeanMap;

import java.util.Map;

public class CglibSerializer implements Serializer {
    @Override
    public byte[] serialize(Object o) {
        throw new UnsupportedOperationException("CglibSerializer unsupported serialize");
    }

    @Override
    public String serializeToString(Object o) {
        if(o == null) {
            return "nil";
        }

        Map<String, Object> map = BeanMap.create(o);
        StringBuilder sb = new StringBuilder();
        map.values().forEach(v -> {
            if(v != null)
                sb.append(v).append("_");
        });
        return sb.toString();
    }

    @Override
    public Object deserialize(byte[] bytes, Class clazz) {
        throw new UnsupportedOperationException("CglibSerializer unsupported deserialize");
    }
}
