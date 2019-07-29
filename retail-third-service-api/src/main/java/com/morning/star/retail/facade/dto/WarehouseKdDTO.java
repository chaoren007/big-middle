package com.morning.star.retail.facade.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 对接金蝶云的仓库DTO
 */
@ApiModel
public class WarehouseKdDTO implements Serializable {
    private static final long serialVersionUID = 735382006815547012L;
    @ApiModelProperty(required = true, value = "仓库名称")
    @NotNull(message = "仓库名称不能为空")
    private String fName;

    @ApiModelProperty(required = true, value = "是否允许负库存")
    @NotNull(message = "是否允许负库存")
    private boolean fAllowMinusQty;

    public WarehouseKdDTO(String fName, boolean fAllowMinusQty) {
        this.fName = fName;
        this.fAllowMinusQty = fAllowMinusQty;
    }

    public WarehouseKdDTO() {
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public boolean isfAllowMinusQty() {
        return fAllowMinusQty;
    }

    public void setfAllowMinusQty(boolean fAllowMinusQty) {
        this.fAllowMinusQty = fAllowMinusQty;
    }
}
