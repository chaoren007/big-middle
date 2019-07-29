package com.morning.star.retail.dto;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;

/**
 * 设备
 * 
 * @author jiangyf (rebuild:kimhuhg)
 */
public class BindDeviceDTO implements Serializable {
	private static final long serialVersionUID = -515923820244145087L;


	@ApiModelProperty(value = "门店编码")
	private String storeCode;

	@ApiModelProperty(value = "设备ID")
	private String deviceId;

	@ApiModelProperty(value = "设备型号：V1/V2/M1/T1")
	private String deviceVersion;

	@ApiModelProperty(value = "程序版本")
	private String softwareVersion;

	@ApiModelProperty(value = "密钥")
	private String secretKey;

    public String getStoreCode() {
        return storeCode;
    }

    public void setStoreCode(String storeCode) {
        this.storeCode = storeCode;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getDeviceVersion() {
        return deviceVersion;
    }

    public void setDeviceVersion(String deviceVersion) {
        this.deviceVersion = deviceVersion;
    }

    public String getSoftwareVersion() {
        return softwareVersion;
    }

    public void setSoftwareVersion(String softwareVersion) {
        this.softwareVersion = softwareVersion;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

}