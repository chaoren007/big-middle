package com.morning.star.retail.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * 设备流水
 */
public class DeviceWaterDTO implements Serializable {

    private static final long serialVersionUID = 6016966572958676191L;

    public static final String OPERATOR_ADD = "add";

    public static final String OPERATOR_MODIFY = "modify";

    public static final String OPERATOR_DISTRIBUTE = "distribute";

    public static final String OPERATOR_RECOVER = "recover";

    /**
     * 记录ID
     */
    private Integer id;

    /**
     * 集团编码
     */
    private String groupCode;

    /**
     * 集团名称
     */
    private String groupName;

    /**
     * 公司编码
     */
    private String companyCode;

    /**
     * 公司名称
     */
    private String companyName;

    /**
     * 门店编码
     */
    private String storeCode;

    /**
     * 设备ID
     */
    private String deviceId;

    /**
     * 设备型号：V1/V2/M1/T1
     */
    private String deviceVersion;

    /**
     * 程序版本
     */
    private String softwareVersion;

    /**
     * 密钥
     */
    private String key;

    /**
     * 状态（0：未激活 ；1：已激活；2：已冻结）
     */
    private Integer status;

    /**
     * 激活时间
     */
    private Date activityTime;

    /**
     * 设备最后一次登陆的时间
     */
    private Date lastLoginTime;

    /**
     * 设备最后一次注册/订阅的时间
     */
    private Date lastRegTime;

    /**
     * 设备最后一次发送心跳的时间
     */
    private Date lastHeartbeatTime;

    /**
     * 到期时间
     */
    private Date expireDate;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 当前操作员ID
     */
    private Integer operatorId;

    /**
     * 当前操作员姓名
     */
    private String operatorName;

    /**
     * 操作类型
     */
    private String operateType;

    /**
     * 详情备注
     */
    private String remark;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(Integer operatorId) {
        this.operatorId = operatorId;
    }

    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }

    public String getOperateType() {
        return operateType;
    }

    public void setOperateType(String operateType) {
        this.operateType = operateType;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

}