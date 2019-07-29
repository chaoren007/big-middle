package com.morning.star.cache;

import java.util.Map;

public interface CacheHashTemplate<T> extends CacheTemplate<T> {
    void pushHash(String key, Map<String, T> map, int expireInSec);
    boolean pushToHash(String key, String hashkey, T val, boolean isCreate);
    T getHashVal(String key, String hashkey, Class<T> T);
    Map<String, T> getHash(String key, Class<T> t);
    void removeHashVal(String key, String hashkey);
    void removeHash(String key);
}
