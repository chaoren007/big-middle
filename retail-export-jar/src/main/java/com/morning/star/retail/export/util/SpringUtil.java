package com.morning.star.retail.export.util;

import com.morning.star.retail.export.annotation.ComponentExport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @Author: kimhuhg
 * @Date: 18-11-9 下午3:35
 * @desc: 获取bean的工具类
 */
@Component
public class SpringUtil implements ApplicationContextAware {

//    private Logger logger = LoggerFactory.getLogger(SpringUtil.class);

    private static ApplicationContext applicationContext;

    @Override

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {

        if(SpringUtil.applicationContext == null) {

            SpringUtil.applicationContext = applicationContext;

        }

//        logger.info("ApplicationContext配置成功,applicationContext对象："+SpringUtil.applicationContext);

    }

    public static ApplicationContext getApplicationContext() {

        return applicationContext;

    }

    public static Object getBean(String name) {
        try {
            return getApplicationContext().getBean(name);
        } catch (Exception e) {
//            e.printStackTrace();
            return null;
        }

    }

    public static <T> T getBean(Class<T> clazz) {

        return getApplicationContext().getBean(clazz);

    }

    public static <T> T getBean(String name,Class<T> clazz) {

        return getApplicationContext().getBean(name,clazz);

    }

    public static Map<String, Object> getBeanByAnnotation() {

        return getApplicationContext().getBeansWithAnnotation(ComponentExport.class);

    }

}
