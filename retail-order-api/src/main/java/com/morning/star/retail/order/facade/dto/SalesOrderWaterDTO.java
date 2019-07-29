package com.morning.star.retail.order.facade.dto;

import java.io.Serializable;
import java.util.Date;

public class SalesOrderWaterDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private int status;
    private String statusName;
    private String operatorName;
    private Date modifyTime;
    private String remark;
    public int getStatus() {
        return status;
    }
    public void setStatus(int status) {
        this.status = status;
    }
    public String getStatusName() {
        return statusName;
    }
    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }
    public String getOperatorName() {
        return operatorName;
    }
    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }
    public String getRemark() {
        return remark;
    }
    public void setRemark(String remark) {
        this.remark = remark;
    }
    public Date getModifyTime() {
        return modifyTime;
    }
    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }
    
}
