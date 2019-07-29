
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import com.morning.star.retail.order.enums.SalesOrderStatus;
import com.morning.star.retail.order.enums.SalesOrderType;

import lombok.Data;


@Entity
@Table(name = "order_base_info")
@Data
public class SalesOrderEntity extends BaseEntity {


    private static final long serialVersionUID = 1L;

    @Id
    @Comment("pos传入不自动生成,订单编号")
    @Column(length = 64, updatable = false, nullable = false)
    private String orderCode;

    @Temporal(TemporalType.TIME)
    @Comment("下单时间")
    private Date orderTime;

    @Column(length = 2, nullable = false)
    @Comment("订单类型   0：线上    1：线下")
    @Convert(converter = SalesOrderType.Convert.class)
    private SalesOrderType orderType = SalesOrderType.OFFLINE_ORDER;

    @Column(length = 2, nullable = false)
    @Convert(converter = SalesOrderStatus.Convert.class)
    @Comment("订单状态： 100-待支付 110-已支付  115-待确认  116-待拣货  120-待配送  121-待自提  130-配送中  140-已收货  150-已完成  160-超时取消  170-交易关闭 ")
    private SalesOrderStatus orderStatus ;

    @Comment("备注")
    private String buyRemark;

    @Column(precision = 19, scale = 3, nullable = false)
    @Comment("商品总额")
    private BigDecimal totalAmount;

    @Column(precision = 19, scale = 3, nullable = false)
    @Comment("优惠金额")
    private BigDecimal discountAmount;

    @Comment("关闭原因")
    @Column(length = 50)
    private String cancelReason;

    @Embedded
    @Comment("购买者")
    private BuyerEntity buyer;

    @Embedded
    @Comment("组织结构")
    private DepartmentEntity department;

    @Version
    @Column(length = 2)
    private int version;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "orderCode", referencedColumnName = "orderCode", foreignKey = @ForeignKey(name = "none", value = ConstraintMode.NO_CONSTRAINT))
    private List<SalesOrderItemEntity> items;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "orderCode", referencedColumnName = "orderCode", foreignKey = @ForeignKey(name = "none", value = ConstraintMode.NO_CONSTRAINT))
    private List<SalesOrderOperationEntity> operation;



}
