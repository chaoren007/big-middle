package com.morning.star.retail.admin.device.controller.command;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;

/**
 * 设备
 *
 * @author jiangyf (rebuild:kimhuhg)
 * @date 2017年5月24日 上午11:22:54
 */
public class DistributeKeyCommand implements Serializable {
    private static final long serialVersionUID = 4700941315542549468L;

    @ApiModelProperty(value = "门店编码")
    @NotNull(message = "门店编码不能为空")
    private String storeCode;

    @NotNull(message = "密钥不能为空")
    @ApiModelProperty(value = "密钥")
    private String key;

    public String getStoreCode() {
        return storeCode;
    }

    public void setStoreCode(String storeCode) {
        this.storeCode = storeCode;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
