package com.morning.star.retail.order.enums;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.beanutils.converters.AbstractConverter;

import com.morning.star.retail.utils.entity.AbstractHasCodeConverter;
import com.morning.star.retail.utils.entity.HasCode;

public enum SalesTypeEnum implements HasCode {
	ONLINE(0, "线上"),
	OUTLINE(1, "线下");

	private final Integer code;
	private final String desc;

	SalesTypeEnum(Integer code, String desc) {
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
	
	private static Map<Integer, SalesTypeEnum> map = Arrays.asList(SalesTypeEnum.values())
	        .stream().collect(Collectors.toMap(SalesTypeEnum::getCode, e -> e));
	
	public static SalesTypeEnum from(Object code) {
	    return map.get(code);
	}

	public static class BeanSerializer extends AbstractConverter {
		@SuppressWarnings({"unchecked", "rawtypes"})
		@Override
		protected Object convertToType(Class type, Object value) throws Throwable {
			return value == null ? null : ((SalesTypeEnum) value).getCode();
		}

		@Override
		protected Class<?> getDefaultType() {
			return SalesTypeEnum.class;
		}
	}

	public static class BeanDeserializer extends AbstractConverter {
		@SuppressWarnings({"unchecked", "rawtypes"})
		@Override
		protected Object convertToType(Class type, Object value) throws Throwable {
			return SalesTypeEnum.from(value);
		}

		@Override
		protected Class<?> getDefaultType() {
			return SalesTypeEnum.class;
		}
	}

	public static class DBConverter extends AbstractHasCodeConverter<SalesTypeEnum> {

        @Override
        public SalesTypeEnum from(Integer code) {
            return SalesTypeEnum.from(code);
        }

	}


}
