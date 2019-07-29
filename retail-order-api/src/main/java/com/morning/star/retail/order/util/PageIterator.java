package com.morning.star.retail.order.util;

import java.util.Iterator;
import java.util.List;

public class PageIterator<T> implements Iterator<T> {
    private PageLoader<T> loader;
    private Iterator<T> data;
    private Page page;
    private boolean noPage;
    
    public PageIterator(Page startPage, PageLoader<T> loader) {
        this.loader = loader;
        this.page = startPage;
    }
    
    public static interface PageLoader<T> {
        public List<T> load(Page page);
    }

    @Override
    public boolean hasNext() {
        if(data != null && data.hasNext()) {
            return true;
        }
        data = loadMore();
        return data != null && data.hasNext();
    }

    @Override
    public T next() {
        return data.next();
    }
    
    private Iterator<T> loadMore() {
        if(noPage) {
           return null; 
        }
        List<T> list = loader.load(page);
        if(list == null || list.isEmpty()) {
            noPage = true;
            return null;
        }
        if(list.size() < page.getPageSize()) {
            noPage = true;
        }
        page = page.nextPage();
        return list.iterator();
    }
}
