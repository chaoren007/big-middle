package com.morning.star.retail.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@ApiModel(value = "更新地址编码")
@Data
public class AddressCodeDTO implements Serializable {

    private static final long serialVersionUID = -2415654623413404712L;

    @ApiModelProperty(value = "地址ID", required = true)
    private Long addressId;
    @ApiModelProperty(value = "地址名称")
    private String addressCode;
    @ApiModelProperty(value = "大区编码")
    private String regionCode;
    @ApiModelProperty(value = "大区名称")
    private String regionName;
}
