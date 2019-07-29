package com.morning.star.retail.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class AddressDTO implements Serializable {
    private static final long serialVersionUID = -2415654623413404712L;

    @ApiModelProperty(value = "地址ID")
    private long addressId;
    @ApiModelProperty(value = "地址级别")
    private int addressLevel;
    @ApiModelProperty(value = "地址父ID")
    private long parentAddressId;
    @ApiModelProperty(value = "地址名称")
    private String addressName;
    @ApiModelProperty(value = "行政区域")
    private String path;
    @ApiModelProperty(value = "邮编")
    private String zipCode;
    private String pathCh;
    private String addressCode;
    private String addressAttr;
    @ApiModelProperty(value = "大区编码")
    private String regionCode;
    @ApiModelProperty(value = "大区名称")
    private String regionName;

    private List<AddressDTO> list;
}
