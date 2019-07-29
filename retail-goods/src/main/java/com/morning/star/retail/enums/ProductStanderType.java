package com.morning.star.retail.enums;

import com.morning.star.retail.utils.entity.AbstractHasCodeConverter;
import com.morning.star.retail.utils.entity.HasCode;
import org.apache.commons.beanutils.converters.AbstractConverter;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 货品类型
 */
public enum ProductStanderType implements HasCode {
	STANDARD(0, "标品"),
	NO_STANDARD(1, "非标品"),
	APPAREL(2, "服饰");

	private final Integer code;
	private final String desc;

	ProductStanderType(Integer code, String desc) {
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
	

    private static Map<Integer, ProductStanderType> map = Arrays.asList(ProductStanderType.values())
        .stream().collect(Collectors.toMap(ProductStanderType::getCode, e -> e));

    public static ProductStanderType from(Object code) {
        return map.get(code);
    }

	public static class BeanSerializer extends AbstractConverter {
		@SuppressWarnings({"unchecked", "rawtypes"})
		@Override
		protected Object convertToType(Class type, Object value) throws Throwable {
			return value == null ? null : ((ProductStanderType) value).getCode();
		}

		@Override
		protected Class<?> getDefaultType() {
			return ProductStanderType.class;
		}
	}

	public static class BeanDeserializer extends AbstractConverter {

		@SuppressWarnings({"unchecked", "rawtypes"})
		@Override
		protected Object convertToType(Class type, Object value) throws Throwable {
			return ProductStanderType.from(value);
		}

		@Override
		protected Class<?> getDefaultType() {
			return ProductStanderType.class;
		}
	}

	public static class DBConverter extends AbstractHasCodeConverter<ProductStanderType> {

		@Override
		public ProductStanderType from(Integer code) {
			return ProductStanderType.from(code);
		}

	}
}
