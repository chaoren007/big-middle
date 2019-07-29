package com.morning.star.retail.facade.dto.purchase;

import io.swagger.annotations.ApiModel;

import java.io.Serializable;
import java.util.List;

@ApiModel
public class PurchaseImportUpdateDTO implements Serializable {
	private static final long serialVersionUID = -8137520453003973871L;

	private String groupCode;

	private String storeCode;

	private String purchaseCode;

	private List<PurchaseDetailImportDTO> purchaseDetailImportDTOS;

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

	public String getPurchaseCode() {
		return purchaseCode;
	}

	public void setPurchaseCode(String purchaseCode) {
		this.purchaseCode = purchaseCode;
	}

	public List<PurchaseDetailImportDTO> getPurchaseDetailImportDTOS() {
		return purchaseDetailImportDTOS;
	}

	public void setPurchaseDetailImportDTOS(List<PurchaseDetailImportDTO> purchaseDetailImportDTOS) {
		this.purchaseDetailImportDTOS = purchaseDetailImportDTOS;
	}
}
