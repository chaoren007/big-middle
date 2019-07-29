package com.morning.star.retail.utils.audit;

import javax.persistence.Comment;
import java.io.Serializable;

public class Operator implements Serializable {

    private static final long serialVersionUID = 8602815170668688013L;
    @Comment("操作人id")
    private Long operatorId;
    @Comment("操作人名称")
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
