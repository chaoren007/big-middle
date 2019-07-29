package com.morning.star.retail.admin.group.order.controller.command;

import java.io.Serializable;
import java.math.BigDecimal;

import io.swagger.annotations.ApiModelProperty;

/**
 * Created by liangguobin on 2017/5/26.
 */
public class ExamineGoodsCommand implements Serializable {

    @ApiModelProperty(value = "售后单号")
    private String afterSalesCode;

    @ApiModelProperty(value = "备注")
    private String remark;

    @ApiModelProperty(value = "验货时填入的退款金额")
    private BigDecimal realTotalRefundAmount;

    @ApiModelProperty(value = "是否退货入库")
    private int hasReturnedItem;

    @ApiModelProperty(value = "验货结果")
    private int pass;

    @ApiModelProperty(value = "审核结果")
    private int agree;

    public String getAfterSalesCode() {
        return afterSalesCode;
    }

    public void setAfterSalesCode(String afterSalesCode) {
        this.afterSalesCode = afterSalesCode;
    }

    public int getPass() {
        return pass;
    }

    public void setPass(int pass) {
        this.pass = pass;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public BigDecimal getRealTotalRefundAmount() {
        return realTotalRefundAmount;
    }

    public void setRealTotalRefundAmount(BigDecimal realTotalRefundAmount) {
        this.realTotalRefundAmount = realTotalRefundAmount;
    }

    public int getHasReturnedItem() {
        return hasReturnedItem;
    }

    public void setHasReturnedItem(int hasReturnedItem) {
        this.hasReturnedItem = hasReturnedItem;
    }

//    public int getNewStatus() {
//        return newStatus;
//    }
//
//    public void setNewStatus(int newStatus) {
//        this.newStatus = newStatus;
//    }
//
    public int getAgree() {
        return agree;
    }

    public void setAgree(int agree) {
        this.agree = agree;
    }

//    public int getOldStatus() {
//        return oldStatus;
//    }
//
//    public void setOldStatus(int oldStatus) {
//        this.oldStatus = oldStatus;
//    }
//
//    public long getId() {
//        return id;
//    }
//
//    public void setId(long id) {
//        this.id = id;
//    }
//
//    public BigDecimal getRefundAmount() {
//        return refundAmount;
//    }
//
//    public void setRefundAmount(BigDecimal refundAmount) {
//        this.refundAmount = refundAmount;
//    }
//
//    public BigDecimal getPrepayCardAmount() {
//        return prepayCardAmount;
//    }
//
//    public void setPrepayCardAmount(BigDecimal prepayCardAmount) {
//        this.prepayCardAmount = prepayCardAmount;
//    }
}
