package com.morning.star.retail.enums;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.beanutils.converters.AbstractConverter;

import com.morning.star.retail.utils.entity.AbstractHasCodeConverter;
import com.morning.star.retail.utils.entity.HasCode;

/**
 * 生鲜类型
 */
public enum FreshTypeEnum implements HasCode {
	NO_FRESH(0, "普通商品"),
	WEIGH_COUNT(1, "称重管重量"),
	WEIGH_NO_COUNT(2, "称重不管重量"),
	PIECE(3, "计件");

	private final Integer code;

	private final String desc;

	FreshTypeEnum(Integer code, String desc) {
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
	
	private static Map<Integer, FreshTypeEnum> map = Arrays.asList(FreshTypeEnum.values())
	        .stream().collect(Collectors.toMap(FreshTypeEnum::getCode, e -> e));
	
	public static FreshTypeEnum from(Object code) {
	    return map.get(code);
	}

	public static class BeanSerializer extends AbstractConverter {
		@SuppressWarnings({"unchecked", "rawtypes"})
		@Override
		protected Object convertToType(Class type, Object value) throws Throwable {
			return value == null ? null : ((FreshTypeEnum) value).getCode();
		}

		@Override
		protected Class<?> getDefaultType() {
			return FreshTypeEnum.class;
		}
	}

	public static class BeanDeserializer extends AbstractConverter {
		@SuppressWarnings({"unchecked", "rawtypes"})
		@Override
		protected Object convertToType(Class type, Object value) throws Throwable {
			return FreshTypeEnum.from(value);
		}

		@Override
		protected Class<?> getDefaultType() {
			return FreshTypeEnum.class;
		}
	}

	public static class DBConverter extends AbstractHasCodeConverter<FreshTypeEnum> {
        @Override
        public FreshTypeEnum from(Integer code) {
            return FreshTypeEnum.from(code);
        }

	}

}
