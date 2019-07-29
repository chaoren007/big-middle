package com.morning.star.retail.entity;

import javax.persistence.Column;
import javax.persistence.Comment;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Where;

/**
 * 品牌
 *
 * @author obama
 */
@Table(name = "retail_brand")
@Where(clause = "delete_flag <> 1")
@Entity
public class BrandEntity extends BaseEntity {
	private static final long serialVersionUID = 1111320370190733556L;

	public static final String INDEX_NAME = "index_brand_entity";

	public static final String TYPE = "type_test";

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Comment("品牌id")
	private Long id;
	
	
	
	/**
	 * 品牌名称
	 */
	@Column(length=64)
	@Comment("品牌名称")
	private String brandName;

	private String enBrandName;
	private String url;

	private String categoryId;
	private String categoryName;



	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	public String getEnBrandName() {
		return enBrandName;
	}

	public void setEnBrandName(String enBrandName) {
		this.enBrandName = enBrandName;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

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
