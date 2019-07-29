package com.morning.star.retail.enums;

/**
 * 类目级别（0：根类目；1：一级类目；2：二级类目；3：三级类目）
 *
 * @author jiangyf
 * @date 2017年5月19日 下午4:25:58
 */
public enum CategoryEnum {
	FRUIT(1000, "水果"),
	FRESH(2000, "生鲜"),
	FOOD(3000, "食品"),
	NO_FOOD(4000, "非食品"),
	SERVICE(5000, "服务类"),
	OEM(6000, "OEM自有品牌")
	;

	private Integer code;
	private String desc;

	CategoryEnum(Integer code, String desc) {
		this.code = code;
		this.desc = desc;
	}

	public Integer getCode() {
		return code;
	}

	public String getDesc() {
		return desc;
	}

	public static CategoryEnum getEnum(Integer code) {
		for (CategoryEnum value : values()) {
			if (value.getCode().equals(code)) {
				return value;
			}
		}
		return null;
	}

	public static boolean exitCode(Integer code) {
		for (CategoryEnum value : values()) {
			if (value.getCode().equals(code)) {
				return true;
			}
		}
		return false;
	}

}
