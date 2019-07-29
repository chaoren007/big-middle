package com.morning.star.retail.admin.group.stock.controller.command;

import com.morning.star.retail.facade.dto.receipt.ReceiptImeiDTO;
import com.morning.star.retail.facade.dto.receipt.SureReceiptDTO;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

/**
 * 设备
 *
 * @author jiangyf (rebuild:kimhuhg)
 * @date 2017年5月24日 上午11:22:54
 */
public class SureReceiptCommand implements Serializable {
    private static final long serialVersionUID = 4700941315542549468L;

    @NotNull(message = "入库单号不能为空")
    @ApiModelProperty(value = "入库单号")
    private String receiptCode;

    @ApiModelProperty(value = "商品列表")
    private List<SureReceiptDTO> item;

    @ApiModelProperty(value = "串码列表")
    List<ReceiptImeiDTO> imeis;

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

    public List<ReceiptImeiDTO> getImeis() {
        return imeis;
    }

    public void setImeis(List<ReceiptImeiDTO> imeis) {
        this.imeis = imeis;
    }
}
