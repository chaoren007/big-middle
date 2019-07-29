package com.morning.star.retail.facade.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 单位
 *
 * @author obama
 */
@ApiModel
public class UnitsDeleteDTO implements Serializable {
	private static final long serialVersionUID = -8994600146977519440L;

	@NotNull(message = "单位ID不能为空")
	@ApiModelProperty(value = "单位ID")
	private Long id;


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	
}
