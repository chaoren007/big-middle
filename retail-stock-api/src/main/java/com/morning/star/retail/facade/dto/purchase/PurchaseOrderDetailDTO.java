package com.morning.star.retail.facade.dto.purchase;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@ApiModel
public class PurchaseOrderDetailDTO implements Serializable {

	private static final long serialVersionUID = 5512269180604741392L;
	@ApiModelProperty(value = "采购单号")
	private String purchaseCode;

	@ApiModelProperty(value = "入库单号")
	private String receiptCode;

	@ApiModelProperty("集团编码")
	private String groupCode;

	@ApiModelProperty("集团名称")
	private String groupName;

	@ApiModelProperty("市")
	private Long cityId;

	@ApiModelProperty("市名")
	private String cityName;

	@ApiModelProperty("门店编码")
	private String storeCode;

	@ApiModelProperty("门店名称")
	private String storeName;

	@ApiModelProperty("仓库市")
	private Long warehouseCityId;

	@ApiModelProperty("仓库市名")
	private String warehouseCityName;

	@ApiModelProperty("门店名称")
	private String warehouseCode;

	@ApiModelProperty("门店名称")
	private String warehouseName;

	@ApiModelProperty(value = "商品编码")
	private String goodsCode;

	@ApiModelProperty(value = "货品编码")
	private String productCode;

	@ApiModelProperty(value = "货品SAP编码")
	private String sapProductCode;

	@ApiModelProperty(value = "货品名称")
	private String productName;

	@ApiModelProperty(value = "单位ID")
	private String unitsId;

	@ApiModelProperty(value = "单位名称")
	private String unitsName;

	@ApiModelProperty(value = "UPC编码")
	private String upcCode;

	@ApiModelProperty(value = "原价")
	private BigDecimal originalPrice;

	@ApiModelProperty(value = "采购数量")
	private BigDecimal qty;

	@ApiModelProperty(value = "采购价")
	private BigDecimal price = BigDecimal.ZERO;

	@ApiModelProperty(value = "采购单价（含税）")
	private BigDecimal ratePrice = BigDecimal.ZERO;

	@ApiModelProperty(value = "采购金额")
	private BigDecimal amount;

	@ApiModelProperty(value = "采购金额（含税）")
	private BigDecimal rateAmount;

	@ApiModelProperty(value = "货品规格信息")
	private String spuInfo;

	@ApiModelProperty(value = "备注")
	private String remark;

	@ApiModelProperty(value = "创建时间")
	private Date createTime;

	@ApiModelProperty(value = "税率")
	private Integer taxRate;

	@ApiModelProperty(value = "采购原数量")
	private BigDecimal originalQty;

	@ApiModelProperty(value = "采购原单位")
	private String originalUnits;

	@ApiModelProperty(value = "标准类型（0：非称重，1：称重）")
	private Integer standardType;

	@ApiModelProperty(value = "包装规格")
	private String packSpec;

	@ApiModelProperty(value = "是否允许过期收货（0：不允许，1：允许）")
	private Integer expiredAllow;

	public String getPurchaseCode() {
		return purchaseCode;
	}

	public void setPurchaseCode(String purchaseCode) {
		this.purchaseCode = purchaseCode;
	}

	public String getReceiptCode() {
		return receiptCode;
	}

	public void setReceiptCode(String receiptCode) {
		this.receiptCode = receiptCode;
	}

	public String getGroupCode() {
		return groupCode;
	}

	public void setGroupCode(String groupCode) {
		this.groupCode = groupCode;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public String getStoreCode() {
		return storeCode;
	}

	public void setStoreCode(String storeCode) {
		this.storeCode = storeCode;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public Long getCityId() {
		return cityId;
	}

	public void setCityId(Long cityId) {
		this.cityId = cityId;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public Long getWarehouseCityId() {
		return warehouseCityId;
	}

	public void setWarehouseCityId(Long warehouseCityId) {
		this.warehouseCityId = warehouseCityId;
	}

	public String getWarehouseCityName() {
		return warehouseCityName;
	}

	public void setWarehouseCityName(String warehouseCityName) {
		this.warehouseCityName = warehouseCityName;
	}

	public String getWarehouseCode() {
		return warehouseCode;
	}

	public void setWarehouseCode(String warehouseCode) {
		this.warehouseCode = warehouseCode;
	}

	public String getWarehouseName() {
		return warehouseName;
	}

	public void setWarehouseName(String warehouseName) {
		this.warehouseName = warehouseName;
	}

	public String getGoodsCode() {
		return goodsCode;
	}

	public void setGoodsCode(String goodsCode) {
		this.goodsCode = goodsCode;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getSapProductCode() {
		return sapProductCode;
	}

	public void setSapProductCode(String sapProductCode) {
		this.sapProductCode = sapProductCode;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getUnitsId() {
		return unitsId;
	}

	public void setUnitsId(String unitsId) {
		this.unitsId = unitsId;
	}

	public String getUnitsName() {
		return unitsName;
	}

	public void setUnitsName(String unitsName) {
		this.unitsName = unitsName;
	}

	public String getUpcCode() {
		return upcCode;
	}

	public void setUpcCode(String upcCode) {
		this.upcCode = upcCode;
	}

	public BigDecimal getOriginalPrice() {
		return originalPrice;
	}

	public void setOriginalPrice(BigDecimal originalPrice) {
		this.originalPrice = originalPrice;
	}

	public BigDecimal getQty() {
		return qty;
	}

	public void setQty(BigDecimal qty) {
		this.qty = qty;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public BigDecimal getRatePrice() {
		return ratePrice;
	}

	public void setRatePrice(BigDecimal ratePrice) {
		this.ratePrice = ratePrice;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public BigDecimal getRateAmount() {
		return rateAmount;
	}

	public void setRateAmount(BigDecimal rateAmount) {
		this.rateAmount = rateAmount;
	}

	public String getSpuInfo() {
		return spuInfo;
	}

	public void setSpuInfo(String spuInfo) {
		this.spuInfo = spuInfo;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Integer getTaxRate() {
		return taxRate;
	}

	public void setTaxRate(Integer taxRate) {
		this.taxRate = taxRate;
	}

	public BigDecimal getOriginalQty() {
		return originalQty;
	}

	public void setOriginalQty(BigDecimal originalQty) {
		this.originalQty = originalQty;
	}

	public String getOriginalUnits() {
		return originalUnits;
	}

	public void setOriginalUnits(String originalUnits) {
		this.originalUnits = originalUnits;
	}

	public Integer getStandardType() {
		return standardType;
	}

	public void setStandardType(Integer standardType) {
		this.standardType = standardType;
	}

	public String getPackSpec() {
		return packSpec;
	}

	public void setPackSpec(String packSpec) {
		this.packSpec = packSpec;
	}

	public Integer getExpiredAllow() {
		return expiredAllow;
	}

	public void setExpiredAllow(Integer expiredAllow) {
		this.expiredAllow = expiredAllow;
	}
}
