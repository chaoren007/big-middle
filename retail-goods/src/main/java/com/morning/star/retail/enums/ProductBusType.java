package com.morning.star.retail.enums;

import com.morning.star.retail.utils.entity.AbstractHasCodeConverter;
import com.morning.star.retail.utils.entity.HasCode;
import org.apache.commons.beanutils.converters.AbstractConverter;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 包装状态
 */
public enum ProductBusType implements HasCode {
	SINGLE(0, "单品"),
	SERIES(1, "系列");

	private final Integer code;
	private final String desc;

	ProductBusType(Integer code, String desc) {
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
	

    private static Map<Integer, ProductBusType> map = Arrays.asList(ProductBusType.values())
        .stream().collect(Collectors.toMap(ProductBusType::getCode, e -> e));

    public static ProductBusType from(Object code) {
        return map.get(code);
    }

	public static class BeanSerializer extends AbstractConverter {
		@SuppressWarnings({"unchecked", "rawtypes"})
		@Override
		protected Object convertToType(Class type, Object value) throws Throwable {
			return value == null ? null : ((ProductBusType) value).getCode();
		}

		@Override
		protected Class<?> getDefaultType() {
			return ProductBusType.class;
		}
	}

	public static class BeanDeserializer extends AbstractConverter {

		@SuppressWarnings({"unchecked", "rawtypes"})
		@Override
		protected Object convertToType(Class type, Object value) throws Throwable {
			return ProductBusType.from(value);
		}

		@Override
		protected Class<?> getDefaultType() {
			return ProductBusType.class;
		}
	}

	public static class DBConverter extends AbstractHasCodeConverter<ProductBusType> {

		@Override
		public ProductBusType from(Integer code) {
			return ProductBusType.from(code);
		}

	}
}
