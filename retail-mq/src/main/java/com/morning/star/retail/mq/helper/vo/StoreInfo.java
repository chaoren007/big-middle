package com.morning.star.retail.mq.helper.vo;

import java.io.Serializable;

public class StoreInfo implements Serializable {
	private static final long serialVersionUID = -5886149595928713815L;
	/**
	 * 门店编码
	 */
	private String storeCode;
	/**
	 * 门店名称
	 */
	private String storeName;
	/**
	 * 负责人
	 */
	private String manager;
	/**
	 * 负责人邮箱
	 */
	private String email;
	/**
	 * 负责人电话
	 */
	private String mobile;
    private Integer stockModel;

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

	public String getManager() {
		return manager;
	}

	public void setManager(String manager) {
		this.manager = manager;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

    public Integer getStockModel() {
        return stockModel;
    }

    public void setStockModel(Integer stockModel) {
        this.stockModel = stockModel;
    }
    
    
}
