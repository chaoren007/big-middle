package com.morning.star.retail.admin.group.order.controller.command;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;

/**
 * Created by liangguobin on 2017/5/26.
 */
public class AuditOrderCommand implements Serializable {

    @ApiModelProperty(value = "售后单号")
    private String afterSalesCode;

    @ApiModelProperty(value = "备注")
    private String remark;

    @ApiModelProperty(value = "审核结果(0-不同意,1-不同意)")
    private int agree;

    public String getAfterSalesCode() {
        return afterSalesCode;
    }

    public void setAfterSalesCode(String afterSalesCode) {
        this.afterSalesCode = afterSalesCode;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public int getAgree() {
        return agree;
    }

    public void setAgree(int agree) {
        this.agree = agree;
    }
}
