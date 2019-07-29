package com.morning.star.retail.admin.bean;

/**
 * Created by liangguobin on 2017/5/10.
 */
public class HeartbeatConfDO {

    private long id;
    private String companyCode;
    private int interval;
    private int alertLimit;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    public int getInterval() {
        return interval;
    }

    public void setInterval(int interval) {
        this.interval = interval;
    }

    public int getAlertLimit() {
        return alertLimit;
    }

    public void setAlertLimit(int alertLimit) {
        this.alertLimit = alertLimit;
    }
}
