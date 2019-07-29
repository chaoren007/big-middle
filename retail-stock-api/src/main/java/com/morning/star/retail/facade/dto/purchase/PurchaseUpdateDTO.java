package com.morning.star.retail.facade.dto.purchase;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

public class PurchaseUpdateDTO implements Serializable {

	private static final long serialVersionUID = 7117356089100225871L;

	@NotNull(message = "采购单号不能为空")
	@ApiModelProperty(value = "采购单号")
	private String purchaseCode;

	@ApiModelProperty(value = "集团编码", hidden = true)
	private String groupCode;

	@ApiModelProperty(value = "门店编码")
	private String storeCode;

	@NotNull(message = "供应商编码不能为空")
	@ApiModelProperty(value = "供应商编码")
	private String supplierCode;

	@ApiModelProperty(value = "采购合同")
	private String contract;

	@NotNull(message = "支付方式不能为空")
	@ApiModelProperty(value = "支付方式")
	private Integer payments;

	@ApiModelProperty(value = "备注信息")
	private String remark;

	@NotNull(message = "更新商品明细不能为空")
	@ApiModelProperty(value = "更新商品明细")
	private List<PurchaseDetailSubmitDTO> orderDetail;

	public String getPurchaseCode() {
		return purchaseCode;
	}

	public void setPurchaseCode(String purchaseCode) {
		this.purchaseCode = purchaseCode;
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

	public String getSupplierCode() {
		return supplierCode;
	}

	public void setSupplierCode(String supplierCode) {
		this.supplierCode = supplierCode;
	}

	public String getContract() {
		return contract;
	}

	public void setContract(String contract) {
		this.contract = contract;
	}

	public Integer getPayments() {
		return payments;
	}

	public void setPayments(Integer payments) {
		this.payments = payments;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public List<PurchaseDetailSubmitDTO> getOrderDetail() {
		return orderDetail;
	}

	public void setOrderDetail(List<PurchaseDetailSubmitDTO> orderDetail) {
		this.orderDetail = orderDetail;
	}
}
