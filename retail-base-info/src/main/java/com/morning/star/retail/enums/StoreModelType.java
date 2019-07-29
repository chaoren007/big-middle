package com.morning.star.retail.enums;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.beanutils.converters.AbstractConverter;

import com.morning.star.retail.utils.entity.AbstractHasCodeConverter;
import com.morning.star.retail.utils.entity.HasCode;

public enum StoreModelType implements HasCode {
	SELF(0, "自营"),
	JOIN(1, "联营"),
	RENT(2, "租赁");

	private final Integer code;
	private final String desc;

	StoreModelType(Integer code, String desc) {
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

	private static Map<Integer, StoreModelType> map = Arrays.asList(StoreModelType.values())
		.stream().collect(Collectors.toMap(StoreModelType::getCode, e -> e));

	public static StoreModelType from(Object code) {
		return map.get(code);
	}

	public static class BeanSerializer extends AbstractConverter {
		@SuppressWarnings({"unchecked", "rawtypes"})
		@Override
		protected Object convertToType(Class type, Object value) throws Throwable {
			return value == null ? null : ((StoreModelType) value).getCode();
		}

		@Override
		protected Class<?> getDefaultType() {
			return StoreModelType.class;
		}
	}

	public static class BeanDeserializer extends AbstractConverter {

		@SuppressWarnings({"unchecked", "rawtypes"})
		@Override
		protected Object convertToType(Class type, Object value) throws Throwable {
			return StoreModelType.from(value);
		}

		@Override
		protected Class<?> getDefaultType() {
			return StoreModelType.class;
		}
	}

	public static class DBConverter extends AbstractHasCodeConverter<StoreModelType> {

		@Override
		public StoreModelType from(Integer code) {
			return StoreModelType.from(code);
		}


	}

}
