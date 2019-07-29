package com.morning.star.retail.objectcopier;

/**
 * Object 转换完成后进行的操作
 * Created by liangguobin on 2017/5/24.
 */
public interface ObjectCopierFuture<E, R> {
    void process(R src, E target);
}
