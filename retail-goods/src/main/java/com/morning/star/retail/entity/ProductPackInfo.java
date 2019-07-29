package com.morning.star.retail.entity;

import javax.persistence.Column;
import javax.persistence.Comment;
import java.io.Serializable;

public class ProductPackInfo implements Serializable {
	private static final long serialVersionUID = 5031928689541175005L;
	/**
	 * 大包装货品编码
	 */
	@Comment("")
	@Column(length = 64, updatable = false, nullable = false)
	private String productCode;

	/**
	 * 大包装货品唯一编码
	 */
	@Comment("")
	@Column(updatable = false)
	private String sapProductCode;

	/**
	 * 大包装货品名称
	 */
	@Comment("")
	@Column(nullable = false)
	private String productName;

	/**
	 * 大包装UPC编码
	 */
	@Comment("")
	@Column(updatable = false)
	private String upcCode;

	/**
	 * 大包装计量单位ID
	 */
	@Comment("")
	@Column
	private Long unitsId;

	/**
	 * 大包装计量单位名称
	 */
	@Comment("")
	@Column
	private String unitsName;

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getSapProductCode() {
		return sapProductCode;
	}

	public void setSapProductCode(String sapProductCode) {
		this.sapProductCode = sapProductCode;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getUpcCode() {
		return upcCode;
	}

	public void setUpcCode(String upcCode) {
		this.upcCode = upcCode;
	}

	public Long getUnitsId() {
		return unitsId;
	}

	public void setUnitsId(Long unitsId) {
		this.unitsId = unitsId;
	}

	public String getUnitsName() {
		return unitsName;
	}

	public void setUnitsName(String unitsName) {
		this.unitsName = unitsName;
	}
}
