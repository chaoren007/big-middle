package com.morning.star.retail.stock.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@ApiModel(value = "提交盘点数据")
public class InventorySubmitDTO implements Serializable {
    private static final long serialVersionUID = -5196228839756751315L;

    @ApiModelProperty(value = "盘点编码")
    @NotNull(message = "盘点编码不能为空")
    private String inventoryCode;

    @ApiModelProperty(value = "盘点数据")
    @NotNull(message = "盘点数据不能为空")
    private List<InventoryItemSubmitDTO> items;

    @ApiModelProperty(value = "盘点类型（0：盘点货架；1：盘点仓库）")
    @NotNull(message = "盘点类型不能为空")
    private Integer type;

    @ApiModelProperty(value = "备注")
    private String remark;

    public String getInventoryCode() {
        return inventoryCode;
    }

    public void setInventoryCode(String inventoryCode) {
        this.inventoryCode = inventoryCode;
    }

    public List<InventoryItemSubmitDTO> getItems() {
        return items;
    }

    public void setItems(List<InventoryItemSubmitDTO> items) {
        this.items = items;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
