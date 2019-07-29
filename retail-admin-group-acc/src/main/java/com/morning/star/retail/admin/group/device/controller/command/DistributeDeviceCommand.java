package com.morning.star.retail.admin.group.device.controller.command;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;

/**
 * 设备
 * 
 * @author jiangyf (rebuild:kimhuhg)
 */
public class DistributeDeviceCommand implements Serializable {
	private static final long serialVersionUID = -515923820244145087L;

	@ApiModelProperty(value = "门店编码")
	private String storeCode;

	@ApiModelProperty(value = "密钥")
	private String keys;

    public String getStoreCode() {
        return storeCode;
    }

    public void setStoreCode(String storeCode) {
        this.storeCode = storeCode;
    }


    public String getKeys() {
        return keys;
    }

    public void setKeys(String keys) {
        this.keys = keys;
    }
}