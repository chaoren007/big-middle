package com.morning.star.retail.dto.store;

import java.io.Serializable;
import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("门店查询")
public class StoreQueryDTO implements Serializable {
	private static final long serialVersionUID = 3332684132435520479L;

	@ApiModelProperty("集团编码")
	private String groupCode;

	@ApiModelProperty("门店编码")
	private String storeCode;

	@ApiModelProperty("门店编码列表")
	private List<String> storeCodes;

	@ApiModelProperty("门店名称")
	private String storeName;

	@ApiModelProperty("关键字")
	private String keyWord;

	@ApiModelProperty("负责人")
	private String manager;

	@ApiModelProperty("门店电话")
	private String tel;

	@ApiModelProperty("门店营业状态 (OPEN-营业中；CLOSE-关闭中)")
	private String status;

	@ApiModelProperty("是否冻结（0-正常 ，1-已冻结）")
	private Integer isFree;

	@ApiModelProperty("页码")
	private Integer pageNo;

	@ApiModelProperty("记录数")
	private Integer pageSize;

	@ApiModelProperty("角色ID")
	private String findAccessIds;

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

	public List<String> getStoreCodes() {
		return storeCodes;
	}

	public void setStoreCodes(List<String> storeCodes) {
		this.storeCodes = storeCodes;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public String getKeyWord() {
		return keyWord;
	}

	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}

	public String getManager() {
		return manager;
	}

	public void setManager(String manager) {
		this.manager = manager;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getIsFree() {
		return isFree;
	}

	public void setIsFree(Integer isFree) {
		this.isFree = isFree;
	}

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

	public StoreQueryDTO() {
	}

	public StoreQueryDTO(String storeCode) {
		this.storeCode = storeCode;
	}

	public String getFindAccessIds() {
		return findAccessIds;
	}

	public void setFindAccessIds(String findAccessIds) {
		this.findAccessIds = findAccessIds;
	}

}
