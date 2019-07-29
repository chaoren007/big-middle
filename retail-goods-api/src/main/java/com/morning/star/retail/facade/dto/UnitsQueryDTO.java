package com.morning.star.retail.facade.dto;

import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;

/**
 * 单位
 *
 * @author obama
 */
@ApiModel
public class UnitsQueryDTO implements Serializable {
	private static final long serialVersionUID = -8994600146977519440L;

	private Long id;

	@ApiModelProperty(value = "单位名称")
	private String unitsName;

	@ApiModelProperty(required=true,value = "分页页码")
	private Integer pageNo;

	@ApiModelProperty(required=true,value = "分页大小")
	private Integer pageSize;

	
	
	public Integer getPageNo() {
		return pageNo;
	}

	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUnitsName() {
		return unitsName;
	}

	public void setUnitsName(String unitsName) {
		this.unitsName = unitsName;
	}


}
