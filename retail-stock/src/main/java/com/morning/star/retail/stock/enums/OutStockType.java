package com.morning.star.retail.stock.enums;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.beanutils.converters.AbstractConverter;

import com.morning.star.retail.utils.entity.AbstractHasCodeConverter;
import com.morning.star.retail.utils.entity.HasCode;

public enum OutStockType implements HasCode {
	ALLOCATION(1,"调拨出库"),
	REFUND(2,"退货出库"),
	OTHERS(3,"其他");

	private final Integer code;
	private final String desc;

	OutStockType(Integer code,String desc) {
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

	private final static Map<Integer, OutStockType> map = Arrays.asList(OutStockType.values()).stream()
		.collect(Collectors.toMap(OutStockType::getCode, e -> e));

	public static OutStockType from(Object code) {
		return map.get(code);
	}

	public static class BeanSerializer extends AbstractConverter {
		@SuppressWarnings({"unchecked", "rawtypes"})
		@Override
		protected Object convertToType(Class type, Object value) throws Throwable {
			return value == null ? null : ((OutStockType) value).getCode();
		}

		@Override
		protected Class<?> getDefaultType() {
			return OutStockType.class;
		}
	}

	public static class BeanDeserializer extends AbstractConverter {
		@SuppressWarnings({"unchecked", "rawtypes"})
		@Override
		protected Object convertToType(Class type, Object value) throws Throwable {
			return OutStockType.from(value);
		}

		@Override
		protected Class<?> getDefaultType() {
			return OutStockType.class;
		}
	}

	public static class DBConverter extends AbstractHasCodeConverter<OutStockType> {

        @Override
        public OutStockType from(Integer code) {
            return OutStockType.from(code);
        }


	}

}
