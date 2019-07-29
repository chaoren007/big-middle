package com.morning.star.retail.order.domain.entity;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


@Entity
@Table(name = "bus_retail_after_sales_order")
@Data
public class BusAfterSalesOrderEntity extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(length = 10)
    private Long id;

    @Column(length = 64, nullable = false)
    private String afterSalesCode;

    @Column(length = 64)
    @Comment("供货单号")
    private String supplyCode;

    @Column(length = 64)
    @Comment("商品ID")
    private String pCode;
    @Column(length = 64)
    @Comment("商品名称")
    private String pName;

    @Column(length = 19)
    @Comment("数量")
    private BigDecimal count;

    @Column(length = 19)
    @Comment("金额")
    private BigDecimal amount;

    @Column(length = 64)
    @Comment("售后城市ID")
    private String cityId;
    @Column(length = 64)
    @Comment("售后城市名称")
    private String cityName;

    @Column(length = 19)
    @Comment("售后申请时间")
    private Date afterSalesTime;

    @Column(length = 19)
    @Comment("售后类型-1退货退款 2换货 3补货 4仅退款")
    private Integer afterSalesType;
    @Column(length = 19)
    @Comment("售后类型名称")
    private String afterSalesTypeName;

    @Column(length = 19)
    @Comment("状态0待处理  1已处理")
    private Integer status;
    @Column(length = 19)
    @Comment("状态名称")
    private String statusName;

    @Column(length = 64)
    @Comment("原因")
    private String reason;
    @Column(length = 64)
    @Comment("描述")
    private String description;

    @Column(length = 64)
    @Comment("凭证地址")
    private String imgPath;



}
