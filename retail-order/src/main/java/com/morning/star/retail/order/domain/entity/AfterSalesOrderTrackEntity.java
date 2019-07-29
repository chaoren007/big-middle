package com.morning.star.retail.order.domain.entity;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 售后轨迹
 */
@Entity
@Table(name = "retail_after_sales_order_track")
public class AfterSalesOrderTrackEntity extends WaterEntity {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private String afterSalesOrderCode;     // 售后订单号
    private Integer status; //  操作后的status
    private BigDecimal refundAmount;   // 退款金额
    private String trackComment;
    private String refundOrderCode; // 退款订单code


    public String getAfterSalesOrderCode() {
        return afterSalesOrderCode;
    }

    public void setAfterSalesOrderCode(String afterSalesOrderCode) {
        this.afterSalesOrderCode = afterSalesOrderCode;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public BigDecimal getRefundAmount() {
        return refundAmount;
    }

    public void setRefundAmount(BigDecimal refundAmount) {
        this.refundAmount = refundAmount;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getTrackComment() {
        return trackComment;
    }

    public void setTrackComment(String trackComment) {
        this.trackComment = trackComment;
    }

    public String getRefundOrderCode() {
        return refundOrderCode;
    }

    public void setRefundOrderCode(String refundOrderCode) {
        this.refundOrderCode = refundOrderCode;
    }
}
