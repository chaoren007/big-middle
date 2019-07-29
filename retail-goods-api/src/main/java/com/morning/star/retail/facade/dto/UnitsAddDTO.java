package com.morning.star.retail.facade.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * 单位
 *
 * @author obama
 */
@ApiModel
public class UnitsAddDTO implements Serializable {
	private static final long serialVersionUID = -8994600146977519440L;

	
	@ApiModelProperty(required=true,value = "单位名称")
	private String unitsName;


	public String getUnitsName() {
		return unitsName;
	}


	public void setUnitsName(String unitsName) {
		this.unitsName = unitsName;
	}
	

}
