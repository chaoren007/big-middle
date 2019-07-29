package com.morning.star.retail.export.annotation;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * @Author: kimhuhg
 * @Date: 18-11-13 下午4:31
 * @desc:
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
public @interface ComponentExport {

    String value() default "";

    String name() default "";
}
