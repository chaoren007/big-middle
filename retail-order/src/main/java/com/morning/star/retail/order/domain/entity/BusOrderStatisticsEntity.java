package com.morning.star.retail.order.domain.entity;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


@Entity
@Table(name = "bus_retail_order_statistics")
@Data
public class BusOrderStatisticsEntity extends BaseEntity {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(length = 10)
    private Long id;

    @Column(length = 64)
    @Comment("日期")
    private Date date;

    @Column(length = 64)
    @Comment("购买者")
    private String  code;


    @Column(length = 19)
    @Comment("销售量")
    private BigDecimal count;

    @Column(length = 19)
    @Comment("销售额")
    private BigDecimal amount;




}
