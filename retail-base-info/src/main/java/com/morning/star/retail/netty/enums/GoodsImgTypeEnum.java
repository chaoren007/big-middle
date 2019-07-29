package com.morning.star.retail.netty.enums;

/**
 * 货品图片类型
 * 
 * @author jiangyf
 * @date 2017年5月19日 下午4:25:58
 */
public enum GoodsImgTypeEnum {
	ICON_IMG(1, "展示图"), BANNER_IMG(2, "轮播图"), DETAIL_IMG(3, "详情图");

	private Integer code;
	private String desc;

	private GoodsImgTypeEnum(Integer code, String desc) {
		this.code = code;
		this.desc = desc;
	}

	public Integer getCode() {
		return code;
	}

	public String getDesc() {
		return desc;
	}

	public static GoodsImgTypeEnum getGoodsImgType(Integer code) {
		for (GoodsImgTypeEnum value : values()) {
			if (value.getCode().equals(code)) {
				return value;
			}
		}
		return null;
	}

}
