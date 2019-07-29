package com.morning.star.retail.enums;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.beanutils.converters.AbstractConverter;

import com.morning.star.retail.utils.entity.AbstractHasCodeConverter;
import com.morning.star.retail.utils.entity.HasCode;

/**
 * 流通状态，0：退市 1：上市
 */
public enum ProductMarketStatus implements HasCode {
	ON_MARKET(1),
	OFF_MARKET(0);

	private final Integer code;

	ProductMarketStatus(Integer code) {
		this.code = code;
	}

	@Override
	public Integer getCode() {
		return code;
	}
	
	private static Map<Integer, ProductMarketStatus> map = Arrays.asList(ProductMarketStatus.values())
	        .stream().collect(Collectors.toMap(ProductMarketStatus::getCode, e -> e));
	
	public static ProductMarketStatus from(Object code) {
	    return map.get(code);
	}


	public static class BeanSerializer extends AbstractConverter {
		@SuppressWarnings({"unchecked", "rawtypes"})
		@Override
		protected Object convertToType(Class type, Object value) throws Throwable {
			return value == null ? null : ((ProductMarketStatus) value).getCode();
		}

		@Override
		protected Class<?> getDefaultType() {
			return ProductMarketStatus.class;
		}
	}

	public static class BeanDeserializer extends AbstractConverter {

		@SuppressWarnings({"unchecked", "rawtypes"})
		@Override
		protected Object convertToType(Class type, Object value) throws Throwable {
			return ProductMarketStatus.from(value);
		}

		@Override
		protected Class<?> getDefaultType() {
			return ProductMarketStatus.class;
		}
	}

	public static class DBConverter extends AbstractHasCodeConverter<ProductMarketStatus> {

        @Override
        public ProductMarketStatus from(Integer code) {
            return ProductMarketStatus.from(code);
        }

	}
}
