package com.morning.star.retail.entity;

import org.hibernate.annotations.Where;

import javax.persistence.*;

/**
 * upc对应商品表
 */
@Entity
@Table(name = "retail_upc_code")
@Where(clause = "delete_flag <> 1")
public class UpcCodeEntity extends BaseEntity {
	private static final long serialVersionUID = -6317728108971810835L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Comment("关联货品SAP编码")
	@Column
	private String sapProductCode;

	@Comment("关联货品编码")
	@Column(length = 64)
	private String productCode;

	@Comment("UPC编码")
	@Column(length = 64, updatable = false, nullable = false)
	private String upcCode;

	public UpcCodeEntity() {
	}

	public UpcCodeEntity(String sapProductCode, String productCode, String upcCode) {
		this.sapProductCode = sapProductCode;
		this.productCode = productCode;
		this.upcCode = upcCode;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSapProductCode() {
		return sapProductCode;
	}

	public void setSapProductCode(String sapProductCode) {
		this.sapProductCode = sapProductCode;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getUpcCode() {
		return upcCode;
	}

	public void setUpcCode(String upcCode) {
		this.upcCode = upcCode;
	}
}
