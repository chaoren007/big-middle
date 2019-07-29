package com.morning.star.retail.base.poi;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.Map;

/**
 * Created by lenovo on 2018/3/16.
 */
public class ReflectFieldUtil<T> {
    /**
     * 声明数据类
     */
    private Class<T> clazz;

    public ReflectFieldUtil(Class<T> clazz) {
        this.clazz = clazz;
    }

    public void   modifyFieldValue(String strfield,String name,boolean isExport,T t) throws NoSuchFieldException, IllegalAccessException {
        T obj = (T)t;
        //获取类的字段
        Field field = t.getClass().getDeclaredField(strfield);
        //获取val字段上的Foo注解实例
        ExcelColumn foo = field.getAnnotation(ExcelColumn.class);
        //获取 foo 这个代理实例所持有的 InvocationHandler
        InvocationHandler h = Proxy.getInvocationHandler(foo);
        // 获取 AnnotationInvocationHandler 的 memberValues 字段
        Field hField = h.getClass().getDeclaredField("memberValues");
        // 因为这个字段事 private final 修饰，所以要打开权限
        hField.setAccessible(true);
        // 获取 memberValues
        Map memberValues = (Map) hField.get(h);
        // 修改 value 属性值
        memberValues.put("name", name);
        memberValues.put("isExport", isExport);

    }
}
