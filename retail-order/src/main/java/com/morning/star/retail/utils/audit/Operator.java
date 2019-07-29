package com.morning.star.retail.utils.audit;

import java.io.Serializable;

public class Operator implements Serializable{

    private Long operatorId;
    private String operatorName;
    
    public Long getOperatorId() {
        return operatorId;
    }
    public void setOperatorId(Long operatorId) {
        this.operatorId = operatorId;
    }
    public String getOperatorName() {
        return operatorName;
    }
    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }
    
}
