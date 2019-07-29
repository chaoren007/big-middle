package com.morning.star.retail.facade.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 外部服务分公司dto
 * @author kimhuhg
 */
@ApiModel
public class StoreWmsDTO implements Serializable {
    private static final long serialVersionUID = 735382006815547012L;
    @ApiModelProperty(required = true, value = "分公司编码")
    @NotNull(message = "分公司编码不能为空")
    private String storeCode;

    @ApiModelProperty(required = true, value = "分公司名称")
    @NotNull(message = "分公司名称不能为空")
    private String storeName;

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
}
