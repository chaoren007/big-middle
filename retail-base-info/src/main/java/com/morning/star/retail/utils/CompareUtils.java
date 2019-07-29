package com.morning.star.retail.utils;

import java.lang.reflect.Field;

/**
 * Created by lenovo on 2017/10/17.
 */
public class CompareUtils {

    public static String compareTowClass(Object class1, Object class2) throws IllegalAccessException {
        StringBuilder sb = new StringBuilder();
        //获取对象的class
        Class<?> clazz1 = class1.getClass();
        Class<?> clazz2 = class2.getClass();
        //获取对象的属性列表
        Field[] field1 = clazz1.getDeclaredFields();
        Field[] field2 = clazz2.getDeclaredFields();
        //遍历属性列表field1
        for (int i = 0; i < field1.length; i++) {
            //遍历属性列表field2
            for (int j = 0; j < field2.length; j++) {
                //如果field1[i]属性名与field2[j]属性名内容相同
                if (field1[i].getName().equals(field2[j].getName())) {
                    if (field1[i].getName().equals(field2[j].getName())) {
                        field1[i].setAccessible(true);
                        field2[j].setAccessible(true);
                        //如果field1[i]属性值与field2[j]属性值内容不相同
                        if (!compareTwo(field1[i].get(class1), field2[j].get(class2))) {
                            sb.append("将");
                            /*Map<String, Object> map2 = new HashMap<String, Object>();
                            map2.put("name", field1[i].getName());
                            map2.put("old", field1[i].get(class1));
                            map2.put("new", field2[j].get(class2));
                            list.add(map2);*/
                        }
                        break;
                    }
                }
            }
        }
        return sb.toString();
    }

    /**
     * 对比两个数据是否内容相同
     *
     * @param object1,object2
     * @return boolean类型
     */
    public static boolean compareTwo(Object object1, Object object2) {

        if (object1 == null && object2 == null) {
            return true;
        }
        if (object1 == null && object2 != null) {
            return false;
        }
        if (object1.equals(object2)) {
            return true;
        }
        return false;
    }
}
