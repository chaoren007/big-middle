package com.morning.star.retail.dto;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import com.morning.star.retail.validate.CreateGroup;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "供应商门店")
public class SupplierStoreDTO implements Serializable {
    private static final long serialVersionUID = 4505193978818395702L;

    @ApiModelProperty(value = "供应商编码")
    @NotNull(message = "供应商编码不能为空")
    private String supplierCode;

    @ApiModelProperty(value = "门店编码")
    private String storeCode;

    @ApiModelProperty(value = "门店名称")
    private String storeName;

    @ApiModelProperty(value = "集团编码")
    private String groupCode;

    public String getSupplierCode() {
        return supplierCode;
    }

    public void setSupplierCode(String supplierCode) {
        this.supplierCode = supplierCode;
    }

    public String getStoreCode() {
        return storeCode;
    }

    public void setStoreCode(String storeCode) {
        this.storeCode = storeCode;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getGroupCode() {
        return groupCode;
    }

    public void setGroupCode(String groupCode) {
        this.groupCode = groupCode;
    }
}
