package com.morning.star.retail.facade.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 品牌
 *
 * @author obama
 */
@ApiModel
public class BrandDeleteDTO implements Serializable {
	private static final long serialVersionUID = 6348392991146109707L;

	@ApiModelProperty(required=true,value = "品牌ID")
	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


}
