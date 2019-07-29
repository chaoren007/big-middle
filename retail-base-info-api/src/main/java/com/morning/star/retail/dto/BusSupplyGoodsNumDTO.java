package com.morning.star.retail.dto;

import java.io.Serializable;

public class BusSupplyGoodsNumDTO implements Serializable {
    private static final long serialVersionUID = 4505193978818395702L;
    private String statusName;
    private Integer status;
    private Integer num;

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }
}
