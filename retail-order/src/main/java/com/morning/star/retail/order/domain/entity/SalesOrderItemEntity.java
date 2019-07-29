package com.morning.star.retail.order.domain.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Comment;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

/**
 * 订单商品明细.
 * @author Tim
 *
 */
@Entity
@Table(name = "order_items_info")
@Data
public class SalesOrderItemEntity implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "order_item_id")
	@SequenceGenerator(name = "order_item_id", sequenceName = "order_item_id", allocationSize = 1)
	@Comment("id")
    private Long id;

	@Column(length = 50, nullable = false)
	@Comment("商品编号")
	private String goodsCode;

	@Column(length = 50, nullable = false)
	@Comment("商品名称")
	private String goodsName;

	@Column(nullable = false)
	@Comment("购买时间")
	private Date buyTime;

	@Column(precision = 19, scale = 3, nullable = false)
	@Comment("购买数量")
	private BigDecimal buyNum;

	@Column(length = 10, nullable = false)
	@Comment("商品单位")
	private String unit;

	@Column(length = 50, nullable = false)
	@Comment("条形码")
	private String upcCode;

	@Column(length = 50, nullable = false)
	@Comment("规格")
	private String specInfo;

	@Column(length = 50, nullable = false)
	@Comment("品牌id")
	private Long brandId;

	@Column(length = 50, nullable = false)
	@Comment("品牌名称")
	private String brandName;

	@Column(precision = 19, scale = 3, nullable = false)
	@Comment("原价")
	private BigDecimal originalPrice = BigDecimal.ZERO;

	@Column(precision = 19, scale = 3, nullable = false)
	@Comment("现价")
	private BigDecimal nowPrice = BigDecimal.ZERO;

	@Column(precision = 19, scale = 3, nullable = false)
	@Comment("商品优惠后的单价")
	private BigDecimal avgPrice = BigDecimal.ZERO;

	@Column(precision = 19, scale = 3, nullable = false)
	@Comment("优惠总金额")
	private BigDecimal discountAmount = BigDecimal.ZERO;

	@Embedded
	@Comment("类目信息")
	private CategoryEntity categoryEntity;

	@Embedded
	@Comment("组织结构")
	private DepartmentEntity department;

}
