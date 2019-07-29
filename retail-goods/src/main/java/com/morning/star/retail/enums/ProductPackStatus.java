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
public enum ProductPackStatus implements HasCode {
	ON(0, "初始状态");

	private final Integer code;
	private final String desc;

	ProductPackStatus(Integer code, String desc) {
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
	

    private static Map<Integer, ProductPackStatus> map = Arrays.asList(ProductPackStatus.values())
        .stream().collect(Collectors.toMap(ProductPackStatus::getCode, e -> e));

    public static ProductPackStatus from(Object code) {
        return map.get(code);
    }

	public static class BeanSerializer extends AbstractConverter {
		@SuppressWarnings({"unchecked", "rawtypes"})
		@Override
		protected Object convertToType(Class type, Object value) throws Throwable {
			return value == null ? null : ((ProductPackStatus) value).getCode();
		}

		@Override
		protected Class<?> getDefaultType() {
			return ProductPackStatus.class;
		}
	}

	public static class BeanDeserializer extends AbstractConverter {

		@SuppressWarnings({"unchecked", "rawtypes"})
		@Override
		protected Object convertToType(Class type, Object value) throws Throwable {
			return ProductPackStatus.from(value);
		}

		@Override
		protected Class<?> getDefaultType() {
			return ProductPackStatus.class;
		}
	}

	public static class DBConverter extends AbstractHasCodeConverter<ProductPackStatus> {

		@Override
		public ProductPackStatus from(Integer code) {
			return ProductPackStatus.from(code);
		}

	}
}
