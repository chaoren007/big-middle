package com.morning.star.retail.facade.dto;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;

@ApiModel
public class ImeiUpdateDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5938698022164199549L;
	/*
	 * 串码
	 */
	private String oldImeiCode;

	private String newImeiCode;

	public String getOldImeiCode() {
		return oldImeiCode;
	}

	public void setOldImeiCode(String oldImeiCode) {
		this.oldImeiCode = oldImeiCode;
	}

	public String getNewImeiCode() {
		return newImeiCode;
	}

	public void setNewImeiCode(String newImeiCode) {
		this.newImeiCode = newImeiCode;
	}

}
