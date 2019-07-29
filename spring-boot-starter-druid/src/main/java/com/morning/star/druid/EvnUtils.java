package com.morning.star.druid;

import org.springframework.core.env.Environment;

import com.google.common.base.Preconditions;

/**
 * 上下文获取工具
 * @author zhouwen
 */
class EvnUtils {

	/**
     * 根据上下文获取信息并转换字符串
     * @param env	上下文
     * @param key	目标key
     */
    public static  String getStringValue(Environment env,String key){
    	String value =env.getProperty(key);
    	return Preconditions.checkNotNull(value);
    }
    
    /**
     * 根据上下文获取信息
     * @param env
     * @param key
     * @return
     */
    public static boolean getBooleanValue(Environment env,String key){
    	
    	boolean result = Boolean.parseBoolean(getStringValue(env,key));
    	
    	return result;
    }

 
    /**
     * 根据上下文获取信息并转换为整形
     * @param env	上下文
     * @param key	目标key
     */
    public static  int getIntValue(Environment env,String key){
    	String value = getStringValue(env,key);
    	return Integer.parseInt(value);
    }

	
	
	
    /**
     * 根据上下文获取信息并转换字符串
     * @param env	上下文
     * @param key	目标key
     * @param defaultValue 默认值
     * @return String
     */
    public static  String getStringValue(Environment env,String key,String defaultValue){
    	String value =env.getProperty(key,defaultValue);
    	return Preconditions.checkNotNull(value);
    }
    
    /**
     * 根据上下文获取信息
     * @param env	上下文
     * @param key	目标key
     * @param defaultValue 默认值
     * @return boolean
     */
    public static boolean getBooleanValue(Environment env,String key,String defaultValue){
    	
    	boolean result = Boolean.parseBoolean(getStringValue(env,key,defaultValue));
    	
    	return result;
    }

 
    /**
     * 根据上下文获取信息并转换为整形
     * @param env	上下文
     * @param key	目标key
     * @param defaultValue 默认值
     * @reutn int
     */
    public static  int getIntValue(Environment env,String key,String defaultValue){
    	String value = getStringValue(env,key,defaultValue);
    	return Integer.parseInt(value);
    }
}
