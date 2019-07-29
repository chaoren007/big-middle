package com.morning.star.retail.entity;

import org.hibernate.annotations.Where;

import javax.persistence.*;

/**
 * 耗材
 */
@Entity
@Table(name = "retail_consumable")
@Where(clause = "delete_flag <> 1")
public class ConsumableEntity extends BaseEntity {
	private static final long serialVersionUID = 559028683041454996L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Comment("集团编码")
	@Column(length = 64, updatable = false)
	private String groupCode;

	@Comment("门店编码")
	@Column(length = 64, updatable = false)
	private String storeCode;

	@Comment("耗材编码")
	@Column(length = 64, unique = true, updatable = false)
	private String consumableCode;

	@Comment("耗材名称")
	private String consumableName;

	@Comment("耗材数量")
	private Integer consumableNum;

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

	public String getConsumableCode() {
		return consumableCode;
	}

	public void setConsumableCode(String consumableCode) {
		this.consumableCode = consumableCode;
	}

	public String getConsumableName() {
		return consumableName;
	}

	public void setConsumableName(String consumableName) {
		this.consumableName = consumableName;
	}

	public Integer getConsumableNum() {
		return consumableNum;
	}

	public void setConsumableNum(Integer consumableNum) {
		this.consumableNum = consumableNum;
	}
}
