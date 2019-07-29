package com.morning.star.retail.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.morning.star.retail.facade.dto.CategoryWmsDTO;
import org.hibernate.annotations.Where;

import java.math.BigDecimal;

@Entity
@Table(name = "retail_category")
@Where(clause = "delete_flag <> 1")
public class CategoryEntity extends BaseEntity {
	private static final long serialVersionUID = 3176858011720865431L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column
	private Integer clevel;
	
	@Column
	private Long parentId;

	@Column
	private Long categoryId;

	@Column(length=64)
	private String categoryName;
	
	@Column
	private Integer weight;

	@Column
	private String url;
	
	@Column
	private Integer sort;

	@Column
	private BigDecimal maxCommission;

	@Column
	private BigDecimal minCommission;

	public BigDecimal getMaxCommission() {
		return maxCommission;
	}

	public void setMaxCommission(BigDecimal maxCommission) {
		this.maxCommission = maxCommission;
	}

	public BigDecimal getMinCommission() {
		return minCommission;
	}

	public void setMinCommission(BigDecimal minCommission) {
		this.minCommission = minCommission;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getClevel() {
		return clevel;
	}

	public void setClevel(Integer clevel) {
		this.clevel = clevel;
	}

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
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

	public Integer getWeight() {
		return weight;
	}

	public void setWeight(Integer weight) {
		this.weight = weight;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public static CategoryWmsDTO toWmsDTO(CategoryEntity entity) {
		if(entity == null) {
			return null;
		}
		CategoryWmsDTO wms = new CategoryWmsDTO();
		wms.setCategoryName(entity.getCategoryName());
		wms.setCategoryId(entity.getCategoryId());

		return wms;
	}
}
