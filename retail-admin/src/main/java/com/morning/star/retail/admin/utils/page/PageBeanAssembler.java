package com.morning.star.retail.admin.utils.page;

import com.github.pagehelper.Page;
import com.morning.star.retail.utils.page.PageBean;

public class PageBeanAssembler {
    
    public <T> PageBean<T> toBean(Page<T> page) {
        return new PageBean<T>(
                        page.getTotal(), 
                        page.getResult(), 
                        page.getPageNum(), 
                        page.getPageSize(), 
                        page.getPages());
    }
    
}
