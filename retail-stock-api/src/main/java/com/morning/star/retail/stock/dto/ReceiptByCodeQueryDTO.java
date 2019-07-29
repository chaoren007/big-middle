package com.morning.star.retail.stock.dto;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by kimhuhg.
 */
public class ReceiptByCodeQueryDTO implements Serializable {
    private static final long serialVersionUID = -1269462207476501539L;

    @ApiModelProperty(value = "入库单号")
    private String receiptCode;

    @ApiModelProperty(hidden = true)
    private String groupCode;

    @ApiModelProperty(hidden = true)
    private String storeCode;

    public String getReceiptCode() {
        return receiptCode;
    }

    public void setReceiptCode(String receiptCode) {
        this.receiptCode = receiptCode;
    }

    public String getStoreCode() {
        return storeCode;
    }

    public void setStoreCode(String storeCode) {
        this.storeCode = storeCode;
    }

    public String getGroupCode() {
        return groupCode;
    }

    public void setGroupCode(String groupCode) {
        this.groupCode = groupCode;
    }

}
