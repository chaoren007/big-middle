package com.morning.star.retail.validate;


import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.groups.Default;

    
@Retention(RetentionPolicy.RUNTIME)//注解会在class中存在，运行时可通过反射获取    
@Target(ElementType.METHOD)//目标是方法
@Documented//文档生成时，该注解将被包含在javadoc中，可去掉  
/**
 * 校验注解通过AOP切面监控校验对象
 * @author zhouwen
 */
public @interface Validate  {

	/**
     * 分组校验,默认校验不分组需传递Class
     * @return
     */
	public Class<?> groups() default Default.class;
	
	/**
	 * 校验并抛出异常 默认不抛出异常
	 */
	public boolean exception() default true;

}


