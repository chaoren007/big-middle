package com.morning.star.retail.stock.bo;

import java.io.Serializable;

/**
 * 库存日志-查询对象
 * 
 * @author jiangyf
 */
public class StockLogBO implements Serializable {
	private static final long serialVersionUID = -3419886921594355665L;

	/**
	 * 公司编码
	 */
	private String companyCode;
	/**
	 * 门店编码
	 */
	private String storeCode;

	public String getCompanyCode() {
		return companyCode;
	}

	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}

	public String getStoreCode() {
		return storeCode;
	}

	public void setStoreCode(String storeCode) {
		this.storeCode = storeCode;
	}

}
