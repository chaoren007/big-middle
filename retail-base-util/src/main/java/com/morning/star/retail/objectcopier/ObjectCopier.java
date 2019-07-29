package com.morning.star.retail.objectcopier;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.cglib.beans.BeanCopier;

import com.google.common.collect.HashBasedTable;
import com.morning.star.retail.base.page.PageBeans;
import com.morning.star.retail.exception.RetailErrorCode;

/**
 * Created by liangguobin on 2017/5/24.
 */
public class ObjectCopier {

    @SuppressWarnings("rawtypes")
    private static volatile HashBasedTable<Class, Class, BeanCopier> shallowCopierCache = HashBasedTable.create();
    private static final Object shallowCacheLock = new Object();


    @SuppressWarnings("rawtypes")
    private static BeanCopier getShallowCopier(Class srcClass, Class targetClass) {
        BeanCopier copier = shallowCopierCache.get(srcClass, targetClass);

        if (copier == null) {
            synchronized (shallowCacheLock) {
                copier = shallowCopierCache.get(srcClass, targetClass);

                if (copier == null) {
                    BeanCopier beanCopier = BeanCopier.create(srcClass, targetClass, false);
                    shallowCopierCache.put(srcClass, targetClass, beanCopier);
                    return beanCopier;
                } else {
                    return copier;
                }
            }
        }
        return copier;
    }


    /**
     * 浅复制，只复制类型相同，名字相同的属性
     * 效率高, 优先使用
     *
     * @param <E>
     * @return
     */
    @SuppressWarnings("unchecked")
    public static <E> E copyObject(Class<E> targetClass, Object src) {
        if (src == null) {
            return null;
        }

        BeanCopier copy = getShallowCopier(src.getClass(), targetClass);
        try {
            Object o = targetClass.newInstance();
            copy.copy(src, o, null);
            return (E) o;
        } catch (Exception e) {
            throw RetailErrorCode.OBJECT_CONVERT_ERROR.build(e);
        }
    }


    /**
     * 浅复制，只复制类型相同，名字相同的属性
     * 效率高, 优先使用
     *
     * @param <E>
     * @return
     */
    @SuppressWarnings({"rawtypes", "unchecked"})
    public static <E, R> E copyObject(Class<E> targetClass, R src, ObjectCopierFuture future) {
        E e = copyObject(targetClass, src);

        if (src == null) {
            return null;
        }

        future.process(src, e);
        return e;
    }

    /**
     * 浅复制，只复制类型相同，名字相同的属性,忽略名字相同，类别不同的属性
     * 效率高, 优先使用
     *
     * @param <E>
     * @return
     */
    public static <E> List<E> copyList(Class<E> targetClass, Collection<?> src) {
        List<E> result = new ArrayList<E>();
        if (CollectionUtils.isEmpty(src)) {
            return result;
        }
        try {
            for (Object o : src) {
                result.add(copyObject(targetClass, o));
            }
            return result;
        } catch (Exception e) {
            throw RetailErrorCode.OBJECT_CONVERT_ERROR.build(e);
        }
    }

    /**
     * 浅复制，只复制类型相同，名字相同的属性,忽略名字相同，类别不同的属性
     * 效率高, 优先使用
     *
     * @param <E>
     * @return
     */
    public static <E, R> List<E> copyList(Class<E> targetClass, Collection<R> src, ObjectCopierFuture<E, R> future) {
        List<E> result = new ArrayList<>();
        try {
            for (Object o : src) {
                E e = copyObject(targetClass, o, future);
                result.add(e);
            }
            return result;
        } catch (Exception e) {
            throw RetailErrorCode.OBJECT_CONVERT_ERROR.build(e);
        }
    }


    /**
     * 复制一个dataPage
     *
     * @param clazz
     * @param page
     * @param future
     * @param <E>
     * @param <R>
     * @return
     */
    public static <E, R> PageBeans<E> copierPage(Class<E> clazz, PageBeans<R> page, ObjectCopierFuture<E, R> future) {
        List<E> record = copyList(clazz, page.getRecord(), future);

        return new PageBeans<E>(page.getTotalNum(), record, page.getPageNo(), page.getPageSize(), page.getPages());
    }

    public static <E, R> PageBeans<E> copierPage(Class<E> clazz, PageBeans<R> page) {
        List<E> record = copyList(clazz, page.getRecord());

        return new PageBeans<E>(page.getTotalNum(), record, page.getPageNo(), page.getPageSize(), page.getPages());
    }
}
