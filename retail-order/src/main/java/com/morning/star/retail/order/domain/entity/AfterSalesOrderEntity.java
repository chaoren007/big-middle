package com.morning.star.retail.order.domain.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Comment;
import javax.persistence.ConstraintMode;
import javax.persistence.Convert;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.morning.star.retail.order.enums.AfterSalesOrderStatus;
import com.morning.star.retail.order.enums.AfterSalesTypeEnum;
import com.morning.star.retail.order.enums.RefundTypeEnum;
import com.morning.star.retail.order.enums.SalesTypeEnum;

import lombok.Data;


@Entity
@Table(name = "retail_after_sales_order")
@Data
public class AfterSalesOrderEntity extends BaseEntity {

    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(length = 64, nullable = false)
    private String afterSalesCode;

    @Column(length = 2, nullable = false)
    @Comment("售后单状态   100：待审核 110：审核失败 120：待验货  130：验货失败  140：待退款 150：已退款 ")
    private AfterSalesOrderStatus afterSalesOrderStatus;

    @Column(length = 64)
    @Comment("订单编号")
    private String orderCode;

    @Column(updatable = false)
    @org.hibernate.annotations.CreationTimestamp
    private Date applyTime;

    @Embedded
    @Comment("购买者")
    private BuyerEntity buyer;

    @Embedded
    @Comment("组织结构")
    private DepartmentEntity department;

    @Column(precision = 19, scale = 3, nullable = false)
    @Comment("订单金额")
    private BigDecimal orderAmount;

    @Column(precision = 19, scale = 3, nullable = false)
    @Comment("（总）正常退款金额")
    private BigDecimal refundAmount;

    @Column(length = 2)
    @Convert(converter = AfterSalesTypeEnum.DBConverter.class)
    @Comment("售后类型 1-退货 2-换货")
    private AfterSalesTypeEnum afterSalesType;

    @Column
    @Comment("退款理由")
    private String refundReason;

    @Column(length = 2, nullable = false)
    @Convert(converter = RefundTypeEnum.DBConverter.class)
    @Comment("退货类别 1-全部退货  2-部分退货 3-拒收")
    private RefundTypeEnum refundType;

    @Column(length = 2, nullable = false)
    @Convert(converter = SalesTypeEnum.DBConverter.class)
    @Comment("订单类型 0线上 1线下")
    private SalesTypeEnum orderType;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "afterSalesCode", referencedColumnName = "afterSalesCode", foreignKey = @ForeignKey(name = "none", value = ConstraintMode.NO_CONSTRAINT))
    private List<AfterSalesOrderItemEntity> items;



}
