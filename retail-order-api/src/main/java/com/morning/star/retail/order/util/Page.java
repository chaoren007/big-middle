package com.morning.star.retail.order.util;

import java.io.Serializable;

public class Page implements Serializable {

   
    
    /**
	 * 
	 */
	private static final long serialVersionUID = -3259065959854268660L;
	
	/** 页码 */
    private final int pageNo;
    /** 每页记录数 */
    private final int pageSize;
    
    
    public Page(int pageNo, int pageSize) {
        this.pageNo = pageNo;
        this.pageSize = pageSize;
    }
    


    public Page() {
        this(1, 10);
    }

    public int getPageNo() {
        return pageNo;
    }

    public int getPageSize() {
        return pageSize;
    }

    public int countOffset() {
        return (pageNo - 1) * pageSize;
    }

    public Page nextPage() {
        return new Page(pageNo + 1, pageSize);
    }

    @Override
    public String toString() {
        return "Page [pageNo=" + pageNo + ", pageSize=" + pageSize + "]";
    }
    
}
