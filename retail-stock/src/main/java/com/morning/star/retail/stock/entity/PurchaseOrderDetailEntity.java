package com.morning.star.retail.stock.entity;

import com.morning.star.retail.facade.dto.purchase.PurchaseDetailSubmitDTO;
import com.morning.star.retail.stock.helper.vo.GoodsInfo;
import com.morning.star.retail.stock.helper.vo.StoreInfo;
import com.morning.star.retail.stock.helper.vo.WarehouseInfo;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.math.BigDecimal;

@Table(name = "retail_purchase_item")
@Where(clause = "delete_flag <> 1")
@Entity
public class PurchaseOrderDetailEntity extends BaseEntity {

	private static final long serialVersionUID = 4345274727789587699L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;    //主键
	@Column(length = 64)
	private String purchaseCode;    //采购单号

	@Comment("集团编码")
	@Column(length = 64, nullable = false)
	private String groupCode;

	@Comment("集团名称")
	@Column(length = 64)
	private String groupName;

	@Comment("市")
	private Long cityId;

	@Comment("市名")
	@Column(length = 16)
	private String cityName;

	@Comment("门店编码")
	@Column(length = 64)
	private String storeCode;

	@Comment("门店名称")
	@Column(length = 64)
	private String storeName;

	@Comment("市")
	private Long warehouseCityId;

	@Comment("市名")
	@Column(length = 16)
	private String warehouseCityName;

	@Comment("门店名称")
	@Column(length = 64)
	private String warehouseCode;

	@Comment("门店名称")
	@Column(length = 64)
	private String warehouseName;

	@Comment("商品编码")
	@Column(length = 64)
	private String goodsCode;

	@Comment("货品编码")
	@Column(length = 64, nullable = false)
	private String productCode;

	@Comment("货品名称")
	@Column(length = 64)
	private String productName;

	@Comment("UPC编码")
	@Column(length = 64)
	private String upcCode;

	@Comment("单位ID")
	private Long unitsId;

	@Comment("单位名称")
	private String unitsName;

	@Comment("原价")
	@Column(precision = 19, scale = 3)
	private BigDecimal originalPrice;

	@Comment("采购数量")
	@Column(nullable = false, precision = 19, scale = 3)
	private BigDecimal qty;

	@Comment("采购原数量")
	@Column(precision = 19, scale = 3)
	private BigDecimal originalQty;

	@Comment("采购原单位")
	@Column(length = 10)
	private String originalUnits;

	@Comment("采购单价（不含税）")
	@Column(precision = 19, scale = 3)
	private BigDecimal price;

	@Comment("采购单价（含税）")
	@Column(precision = 19, scale = 3)
	private BigDecimal ratePrice;

	@Comment("采购总价（不含税）")
	@Column(precision = 19, scale = 3)
	private BigDecimal amount;

	@Comment("采购总价（含税）")
	@Column(precision = 19, scale = 3)
	private BigDecimal rateAmount;

	@Comment("规格信息")
	private String spuInfo;

	@Comment("标准类型（0：非称重，1：称重）")
	@Column(length = 1)
	private Integer standardType;

	@Comment("备注")
	private String remark;

	@Comment("税率")
	private Integer taxRate;

	@Comment("包装规格")
	private String packSpec;

	@Comment("是否允许过期收货（0：不允许，1：允许）")
	@Column(length = 1)
	private Integer expiredAllow;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getUpcCode() {
		return upcCode;
	}

	public void setUpcCode(String upcCode) {
		this.upcCode = upcCode;
	}

	public Long getUnitsId() {
		return unitsId;
	}

	public void setUnitsId(Long unitsId) {
		this.unitsId = unitsId;
	}

	public String getUnitsName() {
		return unitsName;
	}

	public void setUnitsName(String unitsName) {
		this.unitsName = unitsName;
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

	public Integer getStandardType() {
		return standardType;
	}

	public void setStandardType(Integer standardType) {
		this.standardType = standardType;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Integer getTaxRate() {
		return taxRate;
	}

	public void setTaxRate(Integer taxRate) {
		this.taxRate = taxRate;
	}

	public String getPackSpec() {
		return packSpec;
	}

	public void setPackSpec(String packSpec) {
		this.packSpec = packSpec;
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

	public Integer getExpiredAllow() {
		return expiredAllow;
	}

	public void setExpiredAllow(Integer expiredAllow) {
		this.expiredAllow = expiredAllow;
	}

	/**
	 * 采购单详情转化为采购入库单详情
	 */
	public static PurchaseInOrderDetailEntity formIn(PurchaseOrderDetailEntity purchaseOrderDetailEntity, String purchaseInCode) {
		PurchaseInOrderDetailEntity entity = new PurchaseInOrderDetailEntity();
		entity.setPurchaseInCode(purchaseInCode);

		entity.setPurchaseCode(purchaseOrderDetailEntity.getPurchaseCode());

		entity.setGroupCode(purchaseOrderDetailEntity.getGroupCode());
		entity.setGroupName(purchaseOrderDetailEntity.getGroupName());
		entity.setStoreCode(purchaseOrderDetailEntity.getStoreCode());
		entity.setStoreName(purchaseOrderDetailEntity.getStoreName());

		entity.setProductCode(purchaseOrderDetailEntity.getProductCode());
		entity.setGoodsCode(purchaseOrderDetailEntity.getGoodsCode());
		entity.setProductName(purchaseOrderDetailEntity.getProductName());
		entity.setUpcCode(purchaseOrderDetailEntity.getUpcCode());
		entity.setUnitsId(purchaseOrderDetailEntity.getUnitsId());
		entity.setUnitsName(purchaseOrderDetailEntity.getUnitsName());
		entity.setOriginalPrice(purchaseOrderDetailEntity.getOriginalPrice());
		entity.setQty(purchaseOrderDetailEntity.getQty());
		entity.setReceiptQty(BigDecimal.ZERO);
		entity.setOriginalQty(purchaseOrderDetailEntity.getOriginalQty());
		entity.setOriginalUnits(purchaseOrderDetailEntity.getOriginalUnits());
		entity.setPrice(purchaseOrderDetailEntity.getPrice());
		entity.setRatePrice(purchaseOrderDetailEntity.getRatePrice());
		entity.setAmount(purchaseOrderDetailEntity.getAmount());
		entity.setRateAmount(purchaseOrderDetailEntity.getRateAmount());
		entity.setSpuInfo(purchaseOrderDetailEntity.getSpuInfo());
		entity.setStandardType(purchaseOrderDetailEntity.getStandardType());
		entity.setRemark(purchaseOrderDetailEntity.getRemark());
		entity.setTaxRate(purchaseOrderDetailEntity.getTaxRate());
		entity.setPackSpec(purchaseOrderDetailEntity.getPackSpec());
		entity.setExpiredAllow(purchaseOrderDetailEntity.getExpiredAllow());

		return entity;
	}

	public static PurchaseOrderDetailEntity formSubmit(PurchaseDetailSubmitDTO detail) {
		PurchaseOrderDetailEntity entity = new PurchaseOrderDetailEntity();
		entity.setPackSpec(detail.getPackSpec());
		entity.setUpcCode(detail.getUpcCode());

		entity.setQty(detail.getQty());
		entity.setOriginalQty(detail.getQty());

		entity.setTaxRate(detail.getTaxRate());
		entity.setRatePrice(detail.getRatePrice());
		entity.setPrice(detail.getRatePrice()
			.multiply(
				new BigDecimal(100 - detail.getTaxRate()).divide(new BigDecimal(100))
			));

		entity.setAmount(entity.getPrice().multiply(detail.getQty()));
		entity.setRateAmount(detail.getRatePrice().multiply(detail.getQty()));

		entity.setRemark(detail.getRemark());
		entity.setExpiredAllow(detail.getExpiredAllow());

		return entity;
	}

	public void fillGoodsInfo(GoodsInfo goodsInfo) {
		this.setGroupCode(goodsInfo.getGroupCode());
		this.setGroupName(goodsInfo.getGroupName());
		this.setStoreCode(goodsInfo.getStoreCode());
		this.setStoreName(goodsInfo.getStoreName());

		this.setProductCode(goodsInfo.getProductCode());
		this.setGoodsCode(goodsInfo.getGoodsCode());
		this.setProductName(goodsInfo.getProductName());
		this.setUnitsId(goodsInfo.getUnitsId());
		this.setUnitsName(goodsInfo.getUnitsName());
		this.setOriginalPrice(goodsInfo.getPurchasePrice());
		this.setOriginalUnits(goodsInfo.getUnitsName());
		this.setSpuInfo(goodsInfo.getSpuInfo());
		this.setStandardType(goodsInfo.getStandardType());
	}

	public void fillStoreInfo(StoreInfo storeInfo) {
		this.setStoreCode(storeInfo.getStoreCode());
		this.setStoreName(storeInfo.getStoreName());
		this.setCityId(storeInfo.getCityId());
		this.setCityName(storeInfo.getCityName());
	}

	public void fillWarehouseInfo(WarehouseInfo warehouseInfo) {
		this.setWarehouseCode(warehouseInfo.getWarehouseCode());
		this.setWarehouseName(warehouseInfo.getWarehouseName());
		this.setWarehouseCityId(warehouseInfo.getCityId());
		this.setWarehouseCityName(warehouseInfo.getCity());
	}
}
