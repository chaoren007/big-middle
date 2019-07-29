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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

/**
 * 售后退货货品
 */
@Entity
@Table(name = "retail_after_sales_order_item")
@Data
public class AfterSalesOrderItemEntity implements Serializable {
    @Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

	@Column(length = 64, nullable = false)
	@Comment("售后订单code")
	private String afterSalesCode;

	@Column(length = 64, nullable = false)
	@Comment("订单Code")
	private String orderCode;

    @Column(nullable = false)
	@Comment("商品编号")
    private String goodsCode;

	@Column(nullable = false)
	@Comment("商品名称")
    private String goodsName;

    @Embedded
	@Comment("商品类目信息")
    private CategoryEntity categoryEntity;

	@Column(precision = 19, scale = 3, nullable = false)
	@Comment("退货数")
    private BigDecimal refundNum;

	@Column(precision = 19, scale = 3, nullable = false)
	@Comment("购买数")
    private BigDecimal buyNum;

	@Column(precision = 19, scale = 3, nullable = false)
	@Comment("原价")
	private BigDecimal originalPrice;

	@Column(precision = 19, scale = 3, nullable = false)
	@Comment("真实价格")
	private BigDecimal nowPrice;

	@Column(length = 10, nullable = false)
	@Comment("商品单位")
	private String unit;

	@Temporal(TemporalType.TIME)
	@Comment("购买时间")
    private Date buyTime;

	@Temporal(TemporalType.TIME)
	@Comment("售后时间")
    private Date refundTime;

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

	@Column(length = 50, nullable = false)
	@Comment("供应商名字")
    private String supplierName;

	@Column(length = 50, nullable = false)
	@Comment("供应商编码")
    private String supplierCode;

	@Column(precision = 19, scale = 3, nullable = false)
	@Comment("退款金额  由订单明细表中均摊金额可以计算")
	private BigDecimal refundAmount;

	@Embedded
	@Comment("组织结构")
	private DepartmentEntity department;

}
