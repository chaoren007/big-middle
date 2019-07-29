package com.morning.star.retail.util;

import java.util.Collections;
import java.util.List;

/**
 * 集合工具
 *
 * @author jiangyf
 */
public class CollectionUtil {

    /**
     * 去除集合中 null值
     *
     * @param list
     * @param <T>
     * @return
     */
    public static <T> List<T> removeNull(List<? extends T> list) {
        list.removeAll(Collections.singleton(null));
        return (List<T>) list;
    }

    /**
     * 去除集合中 空值
     *
     * @param list
     * @param <T>
     * @return
     */
    public static <T> List<T> removeEmpty(List<? extends T> list) {
        list.removeAll(Collections.singleton(""));
        return (List<T>) list;
    }

    /**
     * 去除集合中 null值和空值
     *
     * @param list
     * @param <T>
     * @return
     */
    public static <T> List<T> removeBlank(List<? extends T> list) {
        removeNull(list);
        removeEmpty(list);
        return (List<T>) list;
    }

}
