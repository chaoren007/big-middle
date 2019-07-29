package com.morning.star.retail.dto.group;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;

/**
 * Created by kimhuhg.
 */
public class GroupDeleteDTO implements Serializable {

    private static final long serialVersionUID = -8294655291995041409L;

    @ApiModelProperty(value = "集团编码")
    @NotNull(message = "集团编码不能为空")
    private String groupCode;

    /**
     * 操作人ID
     */
    @ApiModelProperty(hidden = true)
    private Integer operatorId;
    /**
     * 操作人姓名
     */
    @ApiModelProperty(hidden = true)
    private String operatorName;

    public String getGroupCode() {
        return groupCode;
    }

    public void setGroupCode(String groupCode) {
        this.groupCode = groupCode;
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
