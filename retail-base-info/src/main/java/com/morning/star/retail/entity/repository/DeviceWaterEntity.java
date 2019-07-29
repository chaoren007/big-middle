package com.morning.star.retail.entity.repository;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Where;

import com.morning.star.retail.entity.WaterEntity;

import io.swagger.annotations.ApiModelProperty;

/**
 * 设备
 */

@Entity
@Table(name = "retail_device_water")
@Where(clause = "delete_flag <> 1")
public class DeviceWaterEntity extends WaterEntity {
	private static final long serialVersionUID = -515923820244145087L;

	@ApiModelProperty(value = "集团编码")
	private String groupCode;

	@ApiModelProperty(value = "集团名称")
	private String groupName;

	@ApiModelProperty(value = "门店编码")
	private String storeCode;
	
	@ApiModelProperty(value = "门店名称")
	private String storeName;

	@ApiModelProperty(value = "设备ID")
	private String deviceId;

	@ApiModelProperty(value = "设备型号：V1/V2/M1/T1")
	private String deviceVersion;

	@ApiModelProperty(value = "程序版本")
	private String softwareVersion;

	@ApiModelProperty(value = "密钥")
	private String secretKey;

	@ApiModelProperty(value = "状态（0：未激活 ；1：已激活；2：已冻结）")
	private Integer status;

	@ApiModelProperty(value = "激活时间")
	private Date activityTime;

	@ApiModelProperty(value = "设备最后一次登陆的时间")
	private Date lastLoginTime;

	@ApiModelProperty(value = "设备最后一次注册/订阅的时间")
	private Date lastRegTime;

	@ApiModelProperty(value = "设备最后一次发送心跳的时间")
	private Date lastHeartbeatTime;

	@ApiModelProperty(value = "到期时间")
	private Date expireDate;

	@ApiModelProperty(value = "详情备注")
	private String remark;

    public String getGroupCode() {
        return groupCode;
    }

    public void setGroupCode(String groupCode) {
        this.groupCode = groupCode;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getActivityTime() {
        return activityTime;
    }

    public void setActivityTime(Date activityTime) {
        this.activityTime = activityTime;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public Date getLastRegTime() {
        return lastRegTime;
    }

    public void setLastRegTime(Date lastRegTime) {
        this.lastRegTime = lastRegTime;
    }

    public Date getLastHeartbeatTime() {
        return lastHeartbeatTime;
    }

    public void setLastHeartbeatTime(Date lastHeartbeatTime) {
        this.lastHeartbeatTime = lastHeartbeatTime;
    }

    public Date getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(Date expireDate) {
        this.expireDate = expireDate;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }
}