package com.morning.star.retail.stock.enums;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.beanutils.converters.AbstractConverter;

import com.morning.star.retail.utils.entity.AbstractHasCodeConverter;
import com.morning.star.retail.utils.entity.HasCode;

public enum InventoryMode implements HasCode {
	SOME(0), // 抽盘
	ALL(1); // 全盘

	private final Integer code;

	private InventoryMode(Integer code) {
		this.code = code;
	}

	@Override
	public Integer getCode() {
		return code;
	}

	private final static Map<Integer, InventoryMode> map = Arrays.asList(InventoryMode.values()).stream()
		.collect(Collectors.toMap(InventoryMode::getCode, e -> e));

	public static InventoryMode from(Object code) {
		return map.get(code);
	}

	public static class BeanSerializer extends AbstractConverter {
		@SuppressWarnings({"unchecked", "rawtypes"})
		@Override
		protected Object convertToType(Class type, Object value) throws Throwable {
			return value == null ? null : ((InventoryMode) value).getCode();
		}

		@Override
		protected Class<?> getDefaultType() {
			return InventoryMode.class;
		}
	}

	public static class BeanDeserializer extends AbstractConverter {
		@SuppressWarnings({"unchecked", "rawtypes"})
		@Override
		protected Object convertToType(Class type, Object value) throws Throwable {
			return InventoryMode.from(value);
		}

		@Override
		protected Class<?> getDefaultType() {
			return InventoryMode.class;
		}
	}

	public static class DBConverter extends AbstractHasCodeConverter<InventoryMode> {

        @Override
        public InventoryMode from(Integer code) {
            return InventoryMode.from(code);
        }


	}

}
