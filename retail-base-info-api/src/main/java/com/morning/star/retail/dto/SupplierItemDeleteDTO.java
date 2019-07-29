package com.morning.star.retail.dto;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "供应商货品-删除")
public class SupplierItemDeleteDTO implements Serializable {
    private static final long serialVersionUID = -1932115876410624055L;

    @ApiModelProperty(value = "供应商编码")
    @NotNull(message = "供应商编码不能为空")
    private String supplierCode;

    @ApiModelProperty(value = "SAP货品编码")
    @NotNull(message = "SAP货品编码不能为空")
    private String sapProductCode;

    public String getSupplierCode() {
        return supplierCode;
    }

    public void setSupplierCode(String supplierCode) {
        this.supplierCode = supplierCode;
    }

    public String getSapProductCode() {
        return sapProductCode;
    }

    public void setSapProductCode(String sapProductCode) {
        this.sapProductCode = sapProductCode;
    }
}
