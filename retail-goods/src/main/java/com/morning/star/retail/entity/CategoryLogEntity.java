package com.morning.star.retail.entity;

import org.hibernate.annotations.Where;

import javax.persistence.*;

@Entity
@Table(name = "retail_category_log")
@Where(clause = "delete_flag <> 1")
public class CategoryLogEntity extends BaseEntity {
	private static final long serialVersionUID = 3176858011720865431L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column
	private Long categoryId;

	@Column(length=64)
	private String categoryName;

	@Column(length=64)
	private String storeCode;

	@Column(length=64)
	private String groupCode;

	public String getStoreCode() {
		return storeCode;
	}

	public void setStoreCode(String storeCode) {
		this.storeCode = storeCode;
	}

	public String getGroupCode() {
		return groupCode;
	}

	public void setGroupCode(String groupCode) {
		this.groupCode = groupCode;
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
}
