package com.morning.star.retail.stock.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@ApiModel(value = "盘点单")
public class InventoryFormDTO implements Serializable {
    private static final long serialVersionUID = -5196228839756751315L;

    @ApiModelProperty(value = "盘点编码")
    @NotNull(message = "盘点编码不能为空")
    private String inventoryCode;

    @ApiModelProperty(value = "盘点名称")
    private String inventoryName;

    @ApiModelProperty(value = "商品编码")
    @NotNull(message = "商品编码不能为空")
    private List<String> goodsCodes;

    @ApiModelProperty(value = "备注")
    private String remark;

    public String getInventoryCode() {
        return inventoryCode;
    }

    public void setInventoryCode(String inventoryCode) {
        this.inventoryCode = inventoryCode;
    }

    public String getInventoryName() {
        return inventoryName;
    }

    public void setInventoryName(String inventoryName) {
        this.inventoryName = inventoryName;
    }

    public List<String> getGoodsCodes() {
        return goodsCodes;
    }

    public void setGoodsCodes(List<String> goodsCodes) {
        this.goodsCodes = goodsCodes;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
