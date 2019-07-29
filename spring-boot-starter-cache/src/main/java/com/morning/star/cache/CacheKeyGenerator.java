package com.morning.star.cache;


import org.apache.commons.lang3.ArrayUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.MessageFormat;


public class CacheKeyGenerator {
    private Logger logger = LoggerFactory.getLogger(CacheKeyGenerator.class);

    private String cacheKeyPre;

    private Serializer serializer;

    public CacheKeyGenerator(String cacheKeyPre, Serializer serializeUtils) {
        this.cacheKeyPre = cacheKeyPre;
        this.serializer = serializeUtils;
    }

//    public KeyContext generateKey(CacheKey key, Object... args) {
//        String cacheKey = key.getVal();
//
//        if(args != null && args.length > 0) {
//            cacheKey = MessageFormat.format(cacheKey, args);
//        }
//        return new KeyContext(cacheKeyPre, cacheKey);
//    }

    public KeyContext generateKey(String pre, Object... args) {
        StringBuilder key = new StringBuilder(pre);
        if(ArrayUtils.isNotEmpty(args)) {
            for(Object arg : args)
                key.append(generateArgsKey(arg)).append("|");
        }

        return new KeyContext(cacheKeyPre, key.toString().trim());
    }

    /**
     * 为方法参数生成cache key
     * @param o
     * @return
     */
    private String generateArgsKey(Object o) {
        if(o == null) {
            return "null";
        }
        // 基本对象，转为String
        if(o instanceof Integer || o instanceof Long || o instanceof Float || o instanceof  Double || o instanceof Short ||
                o instanceof Boolean || o instanceof  Byte || o instanceof Character) {
            return String.valueOf(o);
        }

        if(o instanceof String) {
            return (String) o;
        }

        // 复杂对象，系列化
        return serializer.serializeToString(o);
    }
}