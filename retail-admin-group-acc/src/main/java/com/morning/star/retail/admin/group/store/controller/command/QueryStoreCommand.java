package com.morning.star.retail.admin.group.store.controller.command;

import java.io.Serializable;

/**
 * 门店
 *
 */
public class QueryStoreCommand implements Serializable {
	private static final long serialVersionUID = 3332684132435520479L;

	/**
	 * 门店编码
	 */
	private String storeCode;
	/**
	 * 门店名称
	 */
	private String storeName;

	/**
     * 页码
     */
    private Integer pageNo;
    /**
     * 记录数
     */
    private Integer pageSize;

    public String getStoreCode() {
        return storeCode;
    }
    public void setStoreCode(String storeCode) {
        this.storeCode = storeCode;
    }
    public String getStoreName() {
        return storeName;
    }
    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }
    public Integer getPageNo() {
        return pageNo;
    }
    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }
    public Integer getPageSize() {
        return pageSize;
    }
    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
