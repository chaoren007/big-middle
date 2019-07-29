package com.morning.star.retail.facade.dto.receipt;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

/**
 * 设备
 *
 * @author kimhuhg
 */
public class SureReceiptInfoDTO implements Serializable {
    private static final long serialVersionUID = 4700941315542549468L;

    @NotNull(message = "入库单号不能为空")
    @ApiModelProperty(value = "入库单号")
    private String receiptCode;

    @ApiModelProperty(value = "商品列表")
    private List<SureReceiptDTO> item;

    public String getReceiptCode() {
        return receiptCode;
    }

    public void setReceiptCode(String receiptCode) {
        this.receiptCode = receiptCode;
    }

    public List<SureReceiptDTO> getItem() {
        return item;
    }

    public void setItem(List<SureReceiptDTO> item) {
        this.item = item;
    }
}
