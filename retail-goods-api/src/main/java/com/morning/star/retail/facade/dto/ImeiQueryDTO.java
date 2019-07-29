package com.morning.star.retail.facade.dto;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 品牌
 *
 * @author obama
 */
@ApiModel
public class ImeiQueryDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5938698022164199549L;
	/*
	 * 串码
	 */
	private String imeiCode;

	private String groupCode;

	private String storeCode;

	@ApiModelProperty(value = "sap编码")
	private String sapCode;

	@ApiModelProperty(required=true,value="分页参数")
    private Integer pageNo;
	@ApiModelProperty(required=true,value="分页参数")
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

	public String getImeiCode() {
		return imeiCode;
	}

	public void setImeiCode(String imeiCode) {
		this.imeiCode = imeiCode;
	}

	public String getGroupCode() {
		return groupCode;
	}

	public void setGroupCode(String groupCode) {
		this.groupCode = groupCode;
	}

	public String getStoreCode() {
		return storeCode;
	}

	public void setStoreCode(String storeCode) {
		this.storeCode = storeCode;
	}

	public String getSapCode() {
		return sapCode;
	}

	public void setSapCode(String sapCode) {
		this.sapCode = sapCode;
	}
}
