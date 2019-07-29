package com.morning.star.retail.facade.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 外部服务分类dto
 *
 * @author kimhuhg
 */
@ApiModel
public class UnitsKdDTO implements Serializable {
    private static final long serialVersionUID = 735382006815547012L;
    @ApiModelProperty(required = true, value = "单位名称")
    @NotNull(message = "单位名称不能为空")
    private String unitsName;

    @ApiModelProperty(required = true, value = "单位ID")
    @NotNull(message = "单位ID不能为空")
    private Long unitsId;

    public UnitsKdDTO(){}
    public UnitsKdDTO(String unitsName,Long unitsId) {
        this.unitsName = unitsName;
        this.unitsId = unitsId;
    }

    public Long getUnitsId() {
        return unitsId;
    }

    public void setUnitsId(Long unitsId) {
        this.unitsId = unitsId;
    }

    public String getUnitsName() {
        return unitsName;
    }

    public void setUnitsName(String unitsName) {
        this.unitsName = unitsName;
    }
}
