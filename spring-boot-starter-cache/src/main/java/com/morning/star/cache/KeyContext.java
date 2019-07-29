package com.morning.star.cache;

public class KeyContext {
    private String cacheKeyPre;

    private String key;


    protected KeyContext(String cacheKeyPre) {
        this.cacheKeyPre = cacheKeyPre;
    }

    protected KeyContext(String cacheKeyPre, String key) {
        this.cacheKeyPre = cacheKeyPre;
        this.key = key;
    }

    public  KeyContext k(String key) {
        KeyContext keyContext = new KeyContext(this.cacheKeyPre);
        keyContext.key = key;
        return keyContext;
    }

    public  KeyContext k(Object key) {
        KeyContext keyContext = new KeyContext(this.cacheKeyPre);
        keyContext.key = String.valueOf(key);
        return keyContext;
    }

    public String getStr() {
        return cacheKeyPre + key;
    }

    public byte[] getBytes() {
        return (cacheKeyPre + key).getBytes();
    }
}
