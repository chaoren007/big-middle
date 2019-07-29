package com.morning.star.retail.stock.bean;

import java.io.Serializable;

/**
 * Created by lenovo on 2017/9/20.
 */
public class StockSyncMQBean implements Serializable {
    private static final long serialVersionUID = 2088060628756630327L;

    private String groupCode;

    private String companyCode;

    private Integer operatorId;

    private String operatorName;

    public String getGroupCode() {
        return groupCode;
    }

    public void setGroupCode(String groupCode) {
        this.groupCode = groupCode;
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
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
}
