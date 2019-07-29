package com.morning.star.retail.entity;

import org.hibernate.annotations.Where;

import javax.persistence.*;

@Entity
@Table(name = "retail_product_spec")
@Where(clause = "delete_flag <> 1")
public class ProductSpecEntity extends BaseEntity {
	private static final long serialVersionUID = 559028683041454996L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Comment("规格编码")
	@Column(nullable = false, updatable = false, length = 64)
	private String spuCode;

	@Comment("货品编码")
	@Column(updatable = false, length = 64)
	private String productCode;

	@Comment("商品编码")
	@Column(updatable = false, length = 64)
	private String goodsCode;

	@Comment("规格名称")
	@Column(nullable = false)
	private String specKey;

	@Comment("规格值")
	@Column(nullable = false)
	private String specValue;

	@Comment("集团编码")
	@Column(length = 64)
	private String groupCode;

	@Comment("门店编码")
	@Column(length = 64)
	private String storeCode;

	@Comment("是否是主规格")
	@Column(length = 2)
	private Integer isMain;

	@Comment("权重")
	@Column
	private Integer priority;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSpuCode() {
		return spuCode;
	}

	public void setSpuCode(String spuCode) {
		this.spuCode = spuCode;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getGoodsCode() {
		return goodsCode;
	}

	public void setGoodsCode(String goodsCode) {
		this.goodsCode = goodsCode;
	}

	public String getSpecKey() {
		return specKey;
	}

	public void setSpecKey(String specKey) {
		this.specKey = specKey;
	}

	public String getSpecValue() {
		return specValue;
	}

	public void setSpecValue(String specValue) {
		this.specValue = specValue;
	}

	public String getGroupCode() {
		return groupCode;
	}

	public void setGroupCode(String groupCode) {
		this.groupCode = groupCode;
	}

	public String getStoreCode() {
		return storeCode;
	}

	public void setStoreCode(String storeCode) {
		this.storeCode = storeCode;
	}

	public Integer getIsMain() {
		return isMain;
	}

	public void setIsMain(Integer isMain) {
		this.isMain = isMain;
	}

	public Integer getPriority() {
		return priority;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
	}
}
