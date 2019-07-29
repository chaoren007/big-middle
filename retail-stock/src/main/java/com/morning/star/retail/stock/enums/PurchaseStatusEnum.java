package com.morning.star.retail.stock.enums;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.beanutils.converters.AbstractConverter;

import com.morning.star.retail.utils.entity.AbstractHasCodeConverter;
import com.morning.star.retail.utils.entity.HasCode;

public enum PurchaseStatusEnum implements HasCode {
	PREPARE_DRAFT(0, "草稿"),
	WAIT_AUDIT(10, "待审核"),
	AUDIT_SUCCESS(20, "审核成功"),
	AUDIT_REJECT(30, "审核失败");

	private final Integer code;
	private final String desc;

	PurchaseStatusEnum(Integer code, String desc) {
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

	private final static Map<Integer, PurchaseStatusEnum> map = Arrays.asList(PurchaseStatusEnum.values()).stream()
		.collect(Collectors.toMap(PurchaseStatusEnum::getCode, e -> e));

	public static PurchaseStatusEnum from(Object code) {
		return map.get(code);
	}

	public static class BeanSerializer extends AbstractConverter {
		@SuppressWarnings({"unchecked", "rawtypes"})
		@Override
		protected Object convertToType(Class type, Object value) throws Throwable {
			return value == null ? null : ((PurchaseStatusEnum) value).getCode();
		}

		@Override
		protected Class<?> getDefaultType() {
			return PurchaseStatusEnum.class;
		}
	}

	public static class BeanDeserializer extends AbstractConverter {

		@SuppressWarnings({"unchecked", "rawtypes"})
		@Override
		protected Object convertToType(Class type, Object value) throws Throwable {
			return PurchaseStatusEnum.from(value);
		}

		@Override
		protected Class<?> getDefaultType() {
			return PurchaseStatusEnum.class;
		}
	}

	public static class DBConverter extends AbstractHasCodeConverter<PurchaseStatusEnum> {

        @Override
        public PurchaseStatusEnum from(Integer code) {
            return PurchaseStatusEnum.from(code);
        }
	}
}
