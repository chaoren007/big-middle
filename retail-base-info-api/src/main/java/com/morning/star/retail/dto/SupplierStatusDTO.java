package com.morning.star.retail.dto;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.io.Serializable;


public class SupplierStatusDTO implements Serializable {
    private static final long serialVersionUID = 4505193978818395702L;

    @ApiModelProperty(value = "供应商编码")
    @NotNull(message = "供应商编码不能为空")
    private String supplierCode;

    public String getSupplierCode() {
        return supplierCode;
    }

    public void setSupplierCode(String supplierCode) {
        this.supplierCode = supplierCode;
    }
}
