package com.morning.star.retail.task.utils;

import java.util.Iterator;

import org.apache.commons.collections.CollectionUtils;

import com.morning.star.retail.utils.page.PageBean;

/**
 * Created by liangguobin on 2017/5/27.
 */
public class PageIterator<T> implements Iterator<T> {
    

    private PageLoader<T> loader;

    private PageBean<T> data;
    private Iterator<T> iterator;

    private boolean hasLoad;

    int pageNo = 1;

    public PageIterator(PageLoader loader) {
        this.loader = loader;

    }

    @Override
    public boolean hasNext() {
        if(!hasLoad) {  // 如果没加载过数据，开始加载数据
            if(!loadPage(pageNo)) {
                return false;
            }
        }

        if(data == null || iterator == null) {
            return false;
        }

        if(iterator.hasNext()) {    // 当前页没处理完,返回true
            return true;
        }

        if(pageNo == data.getPages()) {   // 最后一页了
            return false;
        }

        // 继续加载下一页
        pageNo++;
        if(!loadPage(pageNo)) {
            return false;
        }

        return iterator.hasNext();
    }

    /**
     *
     * @param pageNo
     * @return  true 加载到数据 false 没加载到数据
     */
    private boolean loadPage(int pageNo) {
        data = loader.load(pageNo);
        hasLoad = true;

        if(data == null || CollectionUtils.isEmpty(data.getRecord())) {   // 没加载到没数据
            return false;
        }

        iterator = data.getRecord().iterator();
        return true;
    }

    @Override
    public T next() {
        return iterator.next();
    }

}
