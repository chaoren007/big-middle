package com.morning.star.retail.stock.dto;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 盘点编码
 *
 * @author jiangyf
 */
public class InventoryCodeDTO implements Serializable {
    private static final long serialVersionUID = -5196228839756751315L;

    @ApiModelProperty(required = true, value = "盘点编码")
    private String inventoryCode;

    public String getInventoryCode() {
        return inventoryCode;
    }

    public void setInventoryCode(String inventoryCode) {
        this.inventoryCode = inventoryCode;
    }

}
