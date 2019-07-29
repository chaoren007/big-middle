package com.morning.star.retail.helper.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class AddressInfo implements Serializable {
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
	private String pathCh;
	private String addressCode;
	@ApiModelProperty(value = "大区编码")
	private String regionCode;
	@ApiModelProperty(value = "大区名称")
	private String regionName;
}
