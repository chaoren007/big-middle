package com.morning.star.retail.dto;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang.StringUtils;

import io.swagger.annotations.ApiModelProperty;

/**
 * 设备
 *
 * @author jiangyf (rebuild:kimhuhg)
 * @date 2017年5月24日 上午10:11:01
 */
public class DevicePageDTO implements Serializable {
    private static final long serialVersionUID = -7930499553841514888L;

    @ApiModelProperty(value = "设备ID")
    private String deviceId;

    @ApiModelProperty(value = "设备型号：V1/V2/M1/T1")
    private String deviceVersion;

    @ApiModelProperty(value = "程序版本")
    private String softwareVersion;

    @ApiModelProperty(value = "密钥")
    private String key;

    @ApiModelProperty(value = "状态（0：未激活 ；1：已激活；2：已冻结）")
    private Integer status;

    @ApiModelProperty(value = "激活时间")
    private Date activityTime;

    @ApiModelProperty(value = "离线时间")
    private Date offLineTime;

    @ApiModelProperty(value = "在线状态（0：离线；1：在线）")
    private Integer onLineStatus;

    @ApiModelProperty(value = "集团编码")
    private String groupCode;

    @ApiModelProperty(value = "集团名称")
    private String groupName;

    @ApiModelProperty(value = "门店编码")
    private String storeCode;

    @ApiModelProperty(value = "门店名称")
    private String storeName;

    @ApiModelProperty(value = "到期日期")
    private Date expireDate;

    @ApiModelProperty(value = "是否过期(1-未过期，2-已过期)")
    private Integer overdue;

    @ApiModelProperty(value = "分配状态(1-集团未分配，2-集团已分配，3-公司未分配，4-公司已分配)")
    private Integer state;

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

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
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

    public Date getOffLineTime() {
        return offLineTime;
    }

    public void setOffLineTime(Date offLineTime) {
        this.offLineTime = offLineTime;
    }

    public Integer getOnLineStatus() {
        return onLineStatus;
    }

    public void setOnLineStatus(Integer onLineStatus) {
        this.onLineStatus = onLineStatus;
    }

    public String getGroupCode() {
        return groupCode;
    }

    public void setGroupCode(String groupCode) {
        this.groupCode = groupCode;
        if (StringUtils.isBlank(this.groupCode)) {
            this.state = 1;
        } else {
            this.state = 2;
        }
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

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public Date getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(Date expireDate) {
        this.expireDate = expireDate;
        if(expireDate != null){
            if (expireDate.after(new Date())) {
                this.overdue = 1;
            } else {
                this.overdue = 2;
            }
        }
    }

    public Integer getOverdue() {
        return overdue;
    }

    public void setOverdue(Integer overdue) {
        this.overdue = overdue;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    
}
