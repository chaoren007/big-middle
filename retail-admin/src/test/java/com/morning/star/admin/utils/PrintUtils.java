package com.morning.star.admin.utils;

import java.util.List;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import com.alibaba.fastjson.JSON;

/**
 * Created by liangguobin on 2017/5/12.
 */
public class PrintUtils {
    public static  <E> void print(E e) {
        if(e == null) {
            System.out.println("null");
        } else {
            System.out.println(ReflectionToStringBuilder.toString(e));
        }
    }

    public static  <E> void print(List<E> arr) {
        for(E e : arr) {
            System.out.println(ReflectionToStringBuilder.toString(e));
        }
    }

    public static  <E> void printJson(E e) {
        System.out.println("-------------- print start --------------");
        if(e == null) {
            System.out.println("null");
        } else {
            System.out.println(JSON.toJSON(e));
        }
        System.out.println("-------------- print end --------------");
    }




}
