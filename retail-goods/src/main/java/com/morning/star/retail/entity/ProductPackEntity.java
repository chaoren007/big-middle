package com.morning.star.retail.entity;

import com.morning.star.retail.enums.ProductPackStatus;
import org.hibernate.annotations.Where;

import javax.persistence.*;

@Entity
@Table(name = "retail_product_pack")
@Where(clause = "delete_flag <> 1")
public class ProductPackEntity extends BaseEntity {
	private static final long serialVersionUID = 1990467488083690464L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Comment("集团编码")
	@Column(length = 64, updatable = false)
	private String groupCode;

	@Comment("大包装货品信息")
	@Embedded
	private ProductPackInfo productPackInfo;

	@Comment("小包装货品信息")
	@Embedded
	@AttributeOverrides( value = {
		@AttributeOverride(name = "productCode", column = @Column(name = "pack_product_code")),
		@AttributeOverride(name = "sapProductCode", column = @Column(name = "pack_sap_product_code")),
		@AttributeOverride(name = "productName", column = @Column(name = "pack_product_name")),
		@AttributeOverride(name = "upcCode", column = @Column(name = "pack_upc_code")),
		@AttributeOverride(name = "unitsId", column = @Column(name = "pack_units_id")),
		@AttributeOverride(name = "unitsName", column = @Column(name = "pack_units_name"))
	})
	private ProductPackInfo smallProductPackInfo;

	@Column
	@Comment("包装容量")
	private Integer packNum;

	@Comment("包装状态")
	@Column(length = 2, nullable = false)
	@Convert(converter = ProductPackStatus.DBConverter.class)
	private ProductPackStatus status;

	@Column
	@Comment("权重")
	private Integer priority;

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

	public ProductPackInfo getProductPackInfo() {
		return productPackInfo;
	}

	public void setProductPackInfo(ProductPackInfo productPackInfo) {
		this.productPackInfo = productPackInfo;
	}

	public ProductPackInfo getSmallProductPackInfo() {
		return smallProductPackInfo;
	}

	public void setSmallProductPackInfo(ProductPackInfo smallProductPackInfo) {
		this.smallProductPackInfo = smallProductPackInfo;
	}

	public Integer getPackNum() {
		return packNum;
	}

	public void setPackNum(Integer packNum) {
		this.packNum = packNum;
	}

	public ProductPackStatus getStatus() {
		return status;
	}

	public void setStatus(ProductPackStatus status) {
		this.status = status;
	}

	public Integer getPriority() {
		return priority;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
	}
}
