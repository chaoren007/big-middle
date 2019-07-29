package com.morning.star.retail.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Where;


@Table(name = "retail_brand_water")
@Where(clause = "delete_flag <> 1")
@Entity
public class BrandWaterEntity extends WaterEntity {
	private static final long serialVersionUID = 1111320370190733556L;



    private Long id;
	/**
	 * 品牌名称
	 */
    @Column(length=64)
	private String brandName;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
}
