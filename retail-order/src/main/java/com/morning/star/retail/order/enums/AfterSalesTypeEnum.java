package com.morning.star.retail.order.enums;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.beanutils.converters.AbstractConverter;

import com.morning.star.retail.utils.entity.AbstractHasCodeConverter;
import com.morning.star.retail.utils.entity.HasCode;

public enum AfterSalesTypeEnum implements HasCode {
	RETURN_GOODS(1, "退货"),
	EXCHANGE_GOODS(2, "换货");

	private final Integer code;
	private final String desc;

	AfterSalesTypeEnum(Integer code, String desc) {
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

	private static Map<Integer, AfterSalesTypeEnum> map = Arrays.asList(AfterSalesTypeEnum.values())
	        .stream().collect(Collectors.toMap(AfterSalesTypeEnum::getCode, e -> e));
	
	public static AfterSalesTypeEnum from(Object code) {
	    return map.get(code);
	}
	
	
	public static class BeanSerializer extends AbstractConverter {
		@SuppressWarnings({"unchecked", "rawtypes"})
		@Override
		protected Object convertToType(Class type, Object value) {
			return value == null ? null : ((AfterSalesTypeEnum) value).getCode();
		}

		@Override
		protected Class<?> getDefaultType() {
			return AfterSalesTypeEnum.class;
		}
	}

	public static class BeanDeserializer extends AbstractConverter {

		@Override
		protected Object convertToType(Class type, Object value) {
			return AfterSalesTypeEnum.from(value);
		}

		@Override
		protected Class<?> getDefaultType() {
			return AfterSalesTypeEnum.class;
		}
	}

	public static class DBConverter extends AbstractHasCodeConverter<AfterSalesTypeEnum> {

        @Override
        public AfterSalesTypeEnum from(Integer code) {
            return AfterSalesTypeEnum.from(code);
        }

	}

}
