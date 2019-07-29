package com.morning.star.retail.admin.group.stock.controller.command;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;

/**
 * 设备
 *
 * @author jiangyf (rebuild:kimhuhg)
 * @date 2017年5月24日 上午11:22:54
 */
public class ConfirmDeliveryCommand implements Serializable {
    private static final long serialVersionUID = 4700941315542549468L;

    @NotNull(message = "入库单号不能为空")
    @ApiModelProperty(value = "入库单号",required = true)
    private String receiptCode;

    public String getReceiptCode() {
        return receiptCode;
    }

    public void setReceiptCode(String receiptCode) {
        this.receiptCode = receiptCode;
    }
}
