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
public class PositionKdDTO implements Serializable {
    private static final long serialVersionUID = 735382006815547012L;
    @ApiModelProperty(required = true, value = "岗位名称")
    @NotNull(message = "岗位名称不能为空")
    private String fName;

    @ApiModelProperty(required = true, value = "生效时间")
    @NotNull(message = "生效时间不能为空")
    private String fEffectDate;

    @ApiModelProperty(required = true, value = "失效时间")
    @NotNull(message = "失效时间不能为空")
    private String fLapseDate;

    @ApiModelProperty(required = true, value = "是否负责人岗位")
    @NotNull(message = "是否负责人岗位不能为空")
    private boolean fleaderpost;


    public PositionKdDTO(String fName, String fEffectDate, String fLapseDate, boolean fleaderpost) {
        this.fName = fName;
        this.fEffectDate = fEffectDate;
        this.fLapseDate = fLapseDate;
        this.fleaderpost = fleaderpost;
    }

    public PositionKdDTO() {
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getfEffectDate() {
        return fEffectDate;
    }

    public void setfEffectDate(String fEffectDate) {
        this.fEffectDate = fEffectDate;
    }

    public String getfLapseDate() {
        return fLapseDate;
    }

    public void setfLapseDate(String fLapseDate) {
        this.fLapseDate = fLapseDate;
    }

    public boolean isFleaderpost() {
        return fleaderpost;
    }

    public void setFleaderpost(boolean fleaderpost) {
        this.fleaderpost = fleaderpost;
    }
}
