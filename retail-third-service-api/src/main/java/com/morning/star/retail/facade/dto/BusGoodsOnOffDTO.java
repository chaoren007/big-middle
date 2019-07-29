package com.morning.star.retail.facade.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 运营端商品信息
 */
@Data
@ApiModel
public class BusGoodsOnOffDTO implements Serializable {
	public static final String ON = "on";
	public static final String AUDIT_ON = "audit_on";
	public static final String OFF = "off";


	@ApiModelProperty(value = "供货商品编码")
	private String goodsSupplyCode;

	@ApiModelProperty(value = "上下架状态")
	private String status;

	public static BusGoodsOnOffDTO builderOn(String goodsSupplyCode) {
		BusGoodsOnOffDTO dto = new BusGoodsOnOffDTO();
		dto.setGoodsSupplyCode(goodsSupplyCode);
		dto.setStatus(ON);
		return dto;
	}


	public static BusGoodsOnOffDTO builderAuditOn(String goodsSupplyCode) {
		BusGoodsOnOffDTO dto = new BusGoodsOnOffDTO();
		dto.setGoodsSupplyCode(goodsSupplyCode);
		dto.setStatus(AUDIT_ON);
		return dto;
	}

	public static BusGoodsOnOffDTO builderOff(String goodsSupplyCode) {
		BusGoodsOnOffDTO dto = new BusGoodsOnOffDTO();
		dto.setGoodsSupplyCode(goodsSupplyCode);
		dto.setStatus(OFF);
		return dto;
	}
}
