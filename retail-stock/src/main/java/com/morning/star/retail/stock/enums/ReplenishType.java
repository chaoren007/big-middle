package com.morning.star.retail.stock.enums;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.beanutils.converters.AbstractConverter;

import com.morning.star.retail.utils.entity.AbstractHasCodeConverter;
import com.morning.star.retail.utils.entity.HasCode;

/**
 * 补货类型，0：门店申请补货，1：总部主动补货
 */
public enum ReplenishType implements HasCode {
	STORE_APPLY(0),
	GROUP_LAUNCH(1);

	private final Integer code;

	ReplenishType(Integer code) {
		this.code = code;
	}

	@Override
	public Integer getCode() {
		return code;
	}
	
	private static Map<Integer, ReplenishType> map = Arrays.asList(ReplenishType.values())
	        .stream().collect(Collectors.toMap(ReplenishType::getCode, e -> e));
	
	public static ReplenishType from(Object code) {
	    return map.get(code);
	}


	public static class BeanConverter extends AbstractConverter {
		@SuppressWarnings({"unchecked", "rawtypes"})
		@Override
		protected Object convertToType(Class type, Object value) throws Throwable {
			return value == null ? null : ((ReplenishType) value).getCode();
		}

		@Override
		protected Class<?> getDefaultType() {
			return ReplenishType.class;
		}
	}

	public static class BeanReConverter extends AbstractConverter {
		@SuppressWarnings({"unchecked", "rawtypes"})
		@Override
		protected Object convertToType(Class type, Object value) throws Throwable {
			return ReplenishType.from(value);
		}

		@Override
		protected Class<?> getDefaultType() {
			return ReplenishType.class;
		}
	}

	/**
	 * JPA 列绑定枚举类型数据
	 */
	public static class ReplenishTypeConverter extends AbstractHasCodeConverter<ReplenishType> {

        @Override
        public ReplenishType from(Integer code) {
            return ReplenishType.from(code);
        }


	}
}
