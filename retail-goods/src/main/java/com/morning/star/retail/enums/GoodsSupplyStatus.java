package com.morning.star.retail.enums;

import com.morning.star.retail.utils.entity.AbstractHasCodeConverter;
import com.morning.star.retail.utils.entity.HasCode;
import org.apache.commons.beanutils.converters.AbstractConverter;

public enum GoodsSupplyStatus implements HasCode {
	DRAFT(0, "草稿"),
	SUBMIT(10, "待审核"),
	NO_PASS(5, "未通过"),
	ON_SALE(20, "已上架"),
	OFF_SALE(25, "已下架"),
	OPEN_GROUP(30, "开团中");

	private final Integer code;
	private final String desc;

	GoodsSupplyStatus(Integer code, String desc) {
		this.code = code;
		this.desc = desc;
	}

	@Override
	public Integer getCode() {
		return code;
	}

	public String getDesc() {
		return desc;
	}

	public static GoodsSupplyStatus from(Object code) {
		for (GoodsSupplyStatus e : GoodsSupplyStatus.values()) {
			if (e.getCode().equals(code)) {
				return e;
			}
		}
		return null;
	}

	public static class BeanSerializer extends AbstractConverter {
		@SuppressWarnings({"unchecked", "rawtypes"})
		@Override
		protected Object convertToType(Class type, Object value) throws Throwable {
			return value == null ? null : ((GoodsSupplyStatus) value).getCode();
		}

		@Override
		protected Class<?> getDefaultType() {
			return GoodsSupplyStatus.class;
		}
	}

	public static class BeanDeserializer extends AbstractConverter {

		@SuppressWarnings({"unchecked", "rawtypes"})
		@Override
		protected Object convertToType(Class type, Object value) throws Throwable {
			return GoodsSupplyStatus.from(value);
		}

		@Override
		protected Class<?> getDefaultType() {
			return GoodsSupplyStatus.class;
		}
	}

	public static class DBConverter extends AbstractHasCodeConverter<GoodsSupplyStatus> {

		@Override
		public GoodsSupplyStatus from(Integer code) {
			return GoodsSupplyStatus.from(code);
		}
	}

}
