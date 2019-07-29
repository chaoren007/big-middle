package com.morning.star.retail.facade.dto.purchase;


import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by ethan on 2018/5/3.
 */
public class PurchaseDetailImportDTO implements Serializable {

	private static final long serialVersionUID = 5899067468623906496L;

	private String productCode;

	private BigDecimal qty;

	private String storeCode;

	private BigDecimal price;

	private Integer taxRate;

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public BigDecimal getQty() {
		return qty;
	}

	public void setQty(BigDecimal qty) {
		this.qty = qty;
	}

	public String getStoreCode() {
		return storeCode;
	}

	public void setStoreCode(String storeCode) {
		this.storeCode = storeCode;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Integer getTaxRate() {
		return taxRate;
	}

	public void setTaxRate(Integer taxRate) {
		this.taxRate = taxRate;
	}
}
