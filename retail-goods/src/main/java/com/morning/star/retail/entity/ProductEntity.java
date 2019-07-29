package com.morning.star.retail.entity;

import com.morning.star.retail.enums.*;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "retail_product")
@Where(clause = "delete_flag <> 1")
public class ProductEntity extends BaseEntity {
	private static final long serialVersionUID = 559028683041454996L;

	@Id
	@Column(length = 64, unique = true, updatable = false)
	@Comment("货品唯一编码")
	private String productCode;

	@Comment("SAP货品编码")
	@Column
	private String sapProductCode;

	@Comment("货品SAP母码")
	@Column
	private String sapMotherCode;

	@Comment("货品名称")
	@Column(nullable = false)
	private String productName;

	@Comment("集团编码")
	@Column(length = 64, updatable = false)
	private String groupCode;

	@Comment("集团名称")
	@Column(length = 64)
	private String groupName;

	@Comment("规格编码")
	@Column(length = 64, updatable = false)
	private String spuCode;

	@Comment("规格详情")
	private String spuInfo;

	@Comment("UPC编码")
	@Column(length = 64, updatable = false)
	private String upcCode;

	@Comment("是否为串码管理，0-否 1-是 ")
	@Column(length = 2)
	private Integer isSerialCode;

	@Comment("计量单位ID")
	@Column
	private Long unitsId;

	@Comment("计量单位名称")
	@Column(length = 64)
	private String unitsName;

	@Comment("货品类型 SP-单品,PP-套装")
	@Column(length = 2)
	private String productType;

	@Comment("包装容量")
	@Column
	private Integer packSpecNum;

	@Comment("包装容量单位（如：箱）")
	@Column(length = 64)
	private String packSpecUnits;

	@Comment("如果是单品为null，如果是套装，记录套装内对应单品的product_code")
	@Column(length = 64)
	private String unitProductCode;

	@Comment("货品上下架状态")
	@Column(length = 2, nullable = false)
	@Convert(converter = ProductMarketStatus.DBConverter.class)
	private ProductMarketStatus status;

	@Comment("销售状态")
	@Column(length = 2, nullable = false)
	@Convert(converter = GoodsSaleStatus.DBConverter.class)
	private GoodsSaleStatus saleStatus;

	@Comment("成本价")
	@Column(precision = 19, scale = 3)
	private BigDecimal costPrice;

	@Comment("销售指导价")
	@Column(precision = 19, scale = 3)
	private BigDecimal guidePrice;

	@Comment("销售价")
	@Column(precision = 19, scale = 3)
	private BigDecimal salePrice;

	@Comment("品牌ID")
	@Column
	private Long brandId;

	@Comment("品牌名称")
	@Column(length = 64)
	private String brandName;

	@Comment("标准类型（0：标品，1：非标品，2：服饰）")
	@Column(length = 1, nullable = false)
	private Integer standardType = 0;

	@Comment("货品重量")
	@Column(precision = 19, scale = 3)
	private BigDecimal weight;

	@Comment("货品介绍")
	private String productIntroduce;

	@Comment("一级类目ID")
	@Column
	private Long categoryId1;

	@Comment("一级类目")
	@Column(length = 64)
	private String categoryName1;

	@Comment("二级类目ID")
	private Long categoryId2;

	@Comment("二级类目")
	@Column(length = 64)
	private String categoryName2;

	@Comment("三级类目ID")
	private Long categoryId3;

	@Comment("三级类目")
	@Column(length = 64)
	private String categoryName3;

	@Comment("四级类目ID")
	private Long categoryId4;

	@Comment("四级类目")
	@Column(length = 64)
	private String categoryName4;

	@Comment("五级类目ID")
	private Long categoryId5;

	@Comment("五级类目")
	@Column(length = 64)
	private String categoryName5;

	@Comment("自定义字段值，json格式")
	private String customAttrs;

	@Comment("保质期（天）")
	@Column
	private Integer shelfLife;

	@Comment("货品图标")
	@Column(length = 64)
	private String iconPath;

	@Comment("权重")
	@Column
	private Integer priority;

	@Comment("三公里配送字段 1是 0否")
	@Column
	private Integer delivery = 1;

	@Comment("销售类型（0：仅自营；1：仅代销；2：先自营后代销；3：先代销后自营）")
	@Column(length = 2)
	private Integer salesType;

	@Comment("供应商编码")
	@Column(length = 64)
	private String supplierCode;

	@Comment("供应商名称")
	@Column(length = 64)
	private String supplierName;

	@Comment("采购价")
	@Column(precision = 19, scale = 3)
	private BigDecimal purchasePrice;

	@Comment("产地")
	@Column
	private String originPlace;

	@Comment("税率")
	@Column
	private Integer taxRate;

	@Comment("生鲜类型")
	@Column
	@Convert(converter = FreshTypeEnum.DBConverter.class)
	private FreshTypeEnum freshType;

	@Comment("商品类型")
	@Column(nullable = false)
	@Convert(converter = CommodityTypeEnum.DBConverter.class)
	private CommodityTypeEnum commodityType;

	@Comment("存储类型")
	@Column(nullable = false)
	@Convert(converter = StorageTypeEnum.DBConverter.class)
	private StorageTypeEnum storageType;

	@Comment("货品母码")
	@Column
	private String motherCode;

	@Comment("市")
	private Long cityId;

	@Comment("市名")
	@Column(length = 16)
	private String cityName;

	@Comment("是否可以拆零，0-否 1-是")
	@Column(length = 1)
	private Integer splitType = 0;

	@Comment("体积长度，单位CM")
	@Column(precision = 19, scale = 3)
	private BigDecimal volumeLength;

	@Comment("体积宽度，单位CM")
	@Column(precision = 19, scale = 3)
	private BigDecimal volumeWidth;

	@Comment("体积高度，单位CM")
	@Column(precision = 19, scale = 3)
	private BigDecimal volumeHeight;

	@Comment("数量/重量/体积 属性信息")
	private String outAttrInfo;

	@Comment("分类规格信息")
	private String categorySpuInfo;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "productCode", referencedColumnName = "productCode", foreignKey = @ForeignKey(name = "none", value = ConstraintMode.NO_CONSTRAINT))
	private List<UpcCodeEntity> upcCodeEntityList;

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

	public String getSapMotherCode() {
		return sapMotherCode;
	}

	public void setSapMotherCode(String sapMotherCode) {
		this.sapMotherCode = sapMotherCode;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
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

	public String getSpuCode() {
		return spuCode;
	}

	public void setSpuCode(String spuCode) {
		this.spuCode = spuCode;
	}

	public String getSpuInfo() {
		return spuInfo;
	}

	public void setSpuInfo(String spuInfo) {
		this.spuInfo = spuInfo;
	}

	public String getUpcCode() {
		return upcCode;
	}

	public void setUpcCode(String upcCode) {
		this.upcCode = upcCode;
	}

	public Integer getIsSerialCode() {
		return isSerialCode;
	}

	public void setIsSerialCode(Integer isSerialCode) {
		this.isSerialCode = isSerialCode;
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

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public Integer getPackSpecNum() {
		return packSpecNum;
	}

	public void setPackSpecNum(Integer packSpecNum) {
		this.packSpecNum = packSpecNum;
	}

	public String getPackSpecUnits() {
		return packSpecUnits;
	}

	public void setPackSpecUnits(String packSpecUnits) {
		this.packSpecUnits = packSpecUnits;
	}

	public String getUnitProductCode() {
		return unitProductCode;
	}

	public void setUnitProductCode(String unitProductCode) {
		this.unitProductCode = unitProductCode;
	}

	public ProductMarketStatus getStatus() {
		return status;
	}

	public void setStatus(ProductMarketStatus status) {
		this.status = status;
	}

	public GoodsSaleStatus getSaleStatus() {
		return saleStatus;
	}

	public void setSaleStatus(GoodsSaleStatus saleStatus) {
		this.saleStatus = saleStatus;
	}

	public BigDecimal getCostPrice() {
		return costPrice;
	}

	public void setCostPrice(BigDecimal costPrice) {
		this.costPrice = costPrice;
	}

	public BigDecimal getGuidePrice() {
		return guidePrice;
	}

	public void setGuidePrice(BigDecimal guidePrice) {
		this.guidePrice = guidePrice;
	}

	public BigDecimal getSalePrice() {
		return salePrice;
	}

	public void setSalePrice(BigDecimal salePrice) {
		this.salePrice = salePrice;
	}

	public Long getBrandId() {
		return brandId;
	}

	public void setBrandId(Long brandId) {
		this.brandId = brandId;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public Integer getStandardType() {
		return standardType;
	}

	public void setStandardType(Integer standardType) {
		this.standardType = standardType;
	}

	public BigDecimal getWeight() {
		return weight;
	}

	public void setWeight(BigDecimal weight) {
		this.weight = weight;
	}

	public String getProductIntroduce() {
		return productIntroduce;
	}

	public void setProductIntroduce(String productIntroduce) {
		this.productIntroduce = productIntroduce;
	}

	public Long getCategoryId1() {
		return categoryId1;
	}

	public void setCategoryId1(Long categoryId1) {
		this.categoryId1 = categoryId1;
	}

	public String getCategoryName1() {
		return categoryName1;
	}

	public void setCategoryName1(String categoryName1) {
		this.categoryName1 = categoryName1;
	}

	public Long getCategoryId2() {
		return categoryId2;
	}

	public void setCategoryId2(Long categoryId2) {
		this.categoryId2 = categoryId2;
	}

	public String getCategoryName2() {
		return categoryName2;
	}

	public void setCategoryName2(String categoryName2) {
		this.categoryName2 = categoryName2;
	}

	public Long getCategoryId3() {
		return categoryId3;
	}

	public void setCategoryId3(Long categoryId3) {
		this.categoryId3 = categoryId3;
	}

	public String getCategoryName3() {
		return categoryName3;
	}

	public void setCategoryName3(String categoryName3) {
		this.categoryName3 = categoryName3;
	}

	public Long getCategoryId4() {
		return categoryId4;
	}

	public void setCategoryId4(Long categoryId4) {
		this.categoryId4 = categoryId4;
	}

	public String getCategoryName4() {
		return categoryName4;
	}

	public void setCategoryName4(String categoryName4) {
		this.categoryName4 = categoryName4;
	}

	public Long getCategoryId5() {
		return categoryId5;
	}

	public void setCategoryId5(Long categoryId5) {
		this.categoryId5 = categoryId5;
	}

	public String getCategoryName5() {
		return categoryName5;
	}

	public void setCategoryName5(String categoryName5) {
		this.categoryName5 = categoryName5;
	}

	public String getCustomAttrs() {
		return customAttrs;
	}

	public void setCustomAttrs(String customAttrs) {
		this.customAttrs = customAttrs;
	}

	public Integer getShelfLife() {
		return shelfLife;
	}

	public void setShelfLife(Integer shelfLife) {
		this.shelfLife = shelfLife;
	}

	public String getIconPath() {
		return iconPath;
	}

	public void setIconPath(String iconPath) {
		this.iconPath = iconPath;
	}

	public Integer getPriority() {
		return priority;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
	}

	public Integer getDelivery() {
		return delivery;
	}

	public void setDelivery(Integer delivery) {
		this.delivery = delivery;
	}

	public Integer getSalesType() {
		return salesType;
	}

	public void setSalesType(Integer salesType) {
		this.salesType = salesType;
	}

	public String getSupplierCode() {
		return supplierCode;
	}

	public void setSupplierCode(String supplierCode) {
		this.supplierCode = supplierCode;
	}

	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	public BigDecimal getPurchasePrice() {
		return purchasePrice;
	}

	public void setPurchasePrice(BigDecimal purchasePrice) {
		this.purchasePrice = purchasePrice;
	}

	public String getOriginPlace() {
		return originPlace;
	}

	public void setOriginPlace(String originPlace) {
		this.originPlace = originPlace;
	}

	public Integer getTaxRate() {
		return taxRate;
	}

	public void setTaxRate(Integer taxRate) {
		this.taxRate = taxRate;
	}

	public FreshTypeEnum getFreshType() {
		return freshType;
	}

	public void setFreshType(FreshTypeEnum freshType) {
		this.freshType = freshType;
	}

	public Integer getSplitType() {
		return splitType;
	}

	public void setSplitType(Integer splitType) {
		this.splitType = splitType;
	}

	public List<UpcCodeEntity> getUpcCodeEntityList() {
		return upcCodeEntityList;
	}

	public void setUpcCodeEntityList(List<UpcCodeEntity> upcCodeEntityList) {
		this.upcCodeEntityList = upcCodeEntityList;
	}

	public CommodityTypeEnum getCommodityType() {
		return commodityType;
	}

	public void setCommodityType(CommodityTypeEnum commodityType) {
		this.commodityType = commodityType;
	}

	public String getMotherCode() {
		return motherCode;
	}

	public void setMotherCode(String motherCode) {
		this.motherCode = motherCode;
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

	public StorageTypeEnum getStorageType() {
		return storageType;
	}

	public void setStorageType(StorageTypeEnum storageType) {
		this.storageType = storageType;
	}

	public BigDecimal getVolumeLength() {
		return volumeLength;
	}

	public void setVolumeLength(BigDecimal volumeLength) {
		this.volumeLength = volumeLength;
	}

	public BigDecimal getVolumeWidth() {
		return volumeWidth;
	}

	public void setVolumeWidth(BigDecimal volumeWidth) {
		this.volumeWidth = volumeWidth;
	}

	public BigDecimal getVolumeHeight() {
		return volumeHeight;
	}

	public void setVolumeHeight(BigDecimal volumeHeight) {
		this.volumeHeight = volumeHeight;
	}

	public String getOutAttrInfo() {
		return outAttrInfo;
	}

	public void setOutAttrInfo(String outAttrInfo) {
		this.outAttrInfo = outAttrInfo;
	}

	public String getCategorySpuInfo() {
		return categorySpuInfo;
	}

	public void setCategorySpuInfo(String categorySpuInfo) {
		this.categorySpuInfo = categorySpuInfo;
	}
}
