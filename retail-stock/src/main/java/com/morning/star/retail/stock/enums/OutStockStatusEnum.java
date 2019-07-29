package com.morning.star.retail.stock.enums;

import com.morning.star.retail.utils.entity.AbstractHasCodeConverter;
import com.morning.star.retail.utils.entity.HasCode;
import org.apache.commons.beanutils.converters.AbstractConverter;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public enum OutStockStatusEnum implements HasCode {
	PREPARE_DRAFT(0, "草稿"),
	WAIT_AUDIT(10, "待审核"),
	AUDIT_SUCCESS(20, "审核成功"),
	AUDIT_REJECT(30, "审核失败"),
	AUDIT_OUT(40, "已出库");

	private final Integer code;
	private final String desc;

	OutStockStatusEnum(Integer code, String desc) {
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

	private final static Map<Integer, OutStockStatusEnum> map = Arrays.asList(OutStockStatusEnum.values()).stream()
		.collect(Collectors.toMap(OutStockStatusEnum::getCode, e -> e));

	public static OutStockStatusEnum from(Object code) {
		return map.get(code);
	}

	public static class BeanSerializer extends AbstractConverter {
		@SuppressWarnings({"unchecked", "rawtypes"})
		@Override
		protected Object convertToType(Class type, Object value) throws Throwable {
			return value == null ? null : ((OutStockStatusEnum) value).getCode();
		}

		@Override
		protected Class<?> getDefaultType() {
			return OutStockStatusEnum.class;
		}
	}

	public static class BeanDeserializer extends AbstractConverter {

		@SuppressWarnings({"unchecked", "rawtypes"})
		@Override
		protected Object convertToType(Class type, Object value) throws Throwable {
			return OutStockStatusEnum.from(value);
		}

		@Override
		protected Class<?> getDefaultType() {
			return OutStockStatusEnum.class;
		}
	}

	public static class DBConverter extends AbstractHasCodeConverter<OutStockStatusEnum> {

		@Override
		public OutStockStatusEnum from(Integer code) {
			return OutStockStatusEnum.from(code);
		}
	}
}
