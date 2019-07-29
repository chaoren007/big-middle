package com.morning.star.retail.entity;

import com.morning.star.retail.enums.GoodsSaleStatus;
import com.morning.star.retail.enums.ProductMarketStatus;
import com.morning.star.retail.facade.dto.BusProductDTO;
import com.morning.star.retail.facade.dto.GoodsWmsDTO;
import org.hibernate.annotations.Where;

import javax.persistence.*;

@Entity
@Table(name = "retail_goods")
@Where(clause = "delete_flag <> 1")
public class GoodsEntity extends BaseEntity {
	private static final long serialVersionUID = 559028683041454996L;

	public GoodsEntity() {
	}

	public GoodsEntity(String goodsCode) {
		this.goodsCode = goodsCode;
	}

	@Id
	@Column(length = 64, unique = true, updatable = false)
	@Comment("商品编码，门店唯一码")
	private String goodsCode;

	@Comment("商品名称，同货品名")
	private String goodsName;

	@Comment("门店编码")
	@Column(length = 64, updatable = false)
	private String storeCode;

	@Comment("门店名称")
	@Column(length = 64)
	private String storeName;

	@Column(length = 2)
	@Convert(converter = GoodsSaleStatus.DBConverter.class)
	@Comment("销售状态（0：下架；1：上架）")
	private GoodsSaleStatus saleStatus;

	@Column(length = 2)
	@Convert(converter = ProductMarketStatus.DBConverter.class)
	@Comment("上下架状态（0：下市；1：上市）")
	private ProductMarketStatus marketStatus;

	@Embedded
	private ProductInfo productInfo;


	public String getGoodsCode() {
		return goodsCode;
	}

	public void setGoodsCode(String goodsCode) {
		this.goodsCode = goodsCode;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
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

	public ProductInfo getProductInfo() {
		return productInfo;
	}

	public void setProductInfo(ProductInfo productInfo) {
		this.productInfo = productInfo;
	}

	public GoodsSaleStatus getSaleStatus() {
		return saleStatus;
	}

	public void setSaleStatus(GoodsSaleStatus saleStatus) {
		this.saleStatus = saleStatus;
	}

	public ProductMarketStatus getMarketStatus() {
		return marketStatus;
	}

	public void setMarketStatus(ProductMarketStatus marketStatus) {
		this.marketStatus = marketStatus;
	}

	public static GoodsWmsDTO toWmsDTO(GoodsEntity entity) {
		if (entity == null) {
			return null;
		}
		ProductInfo productInfo = entity.getProductInfo();

		GoodsWmsDTO wmsDTO = new GoodsWmsDTO();
		wmsDTO.setUnitsName(productInfo.getUnitsName());
		wmsDTO.setSpuInfo(productInfo.getSpuInfo());
		wmsDTO.setShelfLife(productInfo.getShelfLife());
		wmsDTO.setCategoryId3(productInfo.getCategoryId3());
		wmsDTO.setBrandName(productInfo.getBrandName());
		wmsDTO.setGoodsCode(productInfo.getProductCode());
		wmsDTO.setGoodsName(entity.getGoodsName());
		wmsDTO.setStoreCode(entity.getStoreCode());
		wmsDTO.setUpcCode(productInfo.getUpcCode());
		wmsDTO.setCommodityType(productInfo.getCommodityType().getCode());
		wmsDTO.setStorageType(productInfo.getStorageType().getCode());
		wmsDTO.setVolumeHeight(productInfo.getVolumeHeight());
		wmsDTO.setVolumeLength(productInfo.getVolumeLength());
		wmsDTO.setVolumeWidth(productInfo.getVolumeWidth());
		wmsDTO.setWeight(productInfo.getWeight());
		wmsDTO.setIcon(productInfo.getIconPath());

		return wmsDTO;
	}

	public static BusProductDTO toBusDTO(GoodsEntity entity) {
		if (entity == null) {
			return null;
		}
		BusProductDTO busDTO = new BusProductDTO();
		return busDTO;
	}
}
