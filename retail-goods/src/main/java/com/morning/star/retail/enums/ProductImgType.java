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
public enum ProductImgType implements HasCode {
	ICON(1, "icon图片"),
	ATLAS(2, "图册"),
	INTRODUCE(3, "介绍图");

	private final Integer code;
	private final String desc;

	ProductImgType(Integer code, String desc) {
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
	

    private static Map<Integer, ProductImgType> map = Arrays.asList(ProductImgType.values())
        .stream().collect(Collectors.toMap(ProductImgType::getCode, e -> e));

    public static ProductImgType from(Object code) {
        return map.get(code);
    }

	public static class BeanSerializer extends AbstractConverter {
		@SuppressWarnings({"unchecked", "rawtypes"})
		@Override
		protected Object convertToType(Class type, Object value) throws Throwable {
			return value == null ? null : ((ProductImgType) value).getCode();
		}

		@Override
		protected Class<?> getDefaultType() {
			return ProductImgType.class;
		}
	}

	public static class BeanDeserializer extends AbstractConverter {

		@SuppressWarnings({"unchecked", "rawtypes"})
		@Override
		protected Object convertToType(Class type, Object value) throws Throwable {
			return ProductImgType.from(value);
		}

		@Override
		protected Class<?> getDefaultType() {
			return ProductImgType.class;
		}
	}

	public static class DBConverter extends AbstractHasCodeConverter<ProductImgType> {

		@Override
		public ProductImgType from(Integer code) {
			return ProductImgType.from(code);
		}

	}
}
