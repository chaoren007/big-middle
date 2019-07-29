package com.morning.star.retail.entity;

import com.morning.star.retail.enums.ProductImgType;
import org.hibernate.annotations.Where;

import javax.persistence.*;

@Table(name = "retail_product_img")
@Where(clause = "delete_flag <> 1")
@Entity
public class ProductImgEntity extends BaseEntity {
	private static final long serialVersionUID = 5031928689541175005L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(length = 19)
	private Long id;

	@Column(length = 64)
	@Comment("集团编码")
	private String groupCode;

	@Column(length = 64)
	@Comment("门店编码")
	private String storeCode;

	@Column(length = 64, updatable = false, nullable = false)
	@Comment("货品主数据编码")
	private String sapProductCode;

	@Column(length = 64, updatable = false, nullable = false)
	@Comment("货品编码")
	private String productCode;

	@Column(length = 128, updatable = false, nullable = false)
	@Comment("图片路径")
	private String imgUri;

	@Column(length = 2, updatable = false, nullable = false)
	@Comment("图片类型")
	@Convert(converter = ProductImgType.DBConverter.class)
	private ProductImgType imgType;

	@Comment("权重")
	@Column
	private Integer priority;

	public ProductImgEntity() {
	}

	public ProductImgEntity(String groupCode, String storeCode, String sapProductCode, String productCode, String imgUri, ProductImgType imgType, Integer priority) {
		this.groupCode = groupCode;
		this.storeCode = storeCode;
		this.sapProductCode = sapProductCode;
		this.productCode = productCode;
		this.imgUri = imgUri;
		this.imgType = imgType;
		this.priority = priority;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getImgUri() {
		return imgUri;
	}

	public void setImgUri(String imgUri) {
		this.imgUri = imgUri;
	}

	public ProductImgType getImgType() {
		return imgType;
	}

	public void setImgType(ProductImgType imgType) {
		this.imgType = imgType;
	}

	public Integer getPriority() {
		return priority;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
	}
}
