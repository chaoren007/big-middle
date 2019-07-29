package com.morning.star.retail.task.utils;

import com.morning.star.retail.utils.page.PageBean;

/**
 * Created by liangguobin on 2017/5/27.
 */
public interface PageLoader<T> {

    int DEFAULT_PAGE_SIZE = 10;
    PageBean<T> load(int pageNo);
}
