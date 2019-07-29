package com.morning.star.retail.stock.enums;

import com.morning.star.retail.utils.entity.AbstractHasCodeConverter;
import com.morning.star.retail.utils.entity.HasCode;
import org.apache.commons.beanutils.converters.AbstractConverter;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public enum PurchaseSubmitEnum implements HasCode {
	GROUP(10, "总部提交"),
	STORE(20, "分城市提交");

	private final Integer code;
	private final String desc;

	PurchaseSubmitEnum(Integer code, String desc) {
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

	private final static Map<Integer, PurchaseSubmitEnum> map = Arrays.asList(PurchaseSubmitEnum.values()).stream()
		.collect(Collectors.toMap(PurchaseSubmitEnum::getCode, e -> e));

	public static PurchaseSubmitEnum from(Object code) {
		return map.get(code);
	}

	public static class BeanSerializer extends AbstractConverter {
		@SuppressWarnings({"unchecked", "rawtypes"})
		@Override
		protected Object convertToType(Class type, Object value) throws Throwable {
			return value == null ? null : ((PurchaseSubmitEnum) value).getCode();
		}

		@Override
		protected Class<?> getDefaultType() {
			return PurchaseSubmitEnum.class;
		}
	}

	public static class BeanDeserializer extends AbstractConverter {

		@SuppressWarnings({"unchecked", "rawtypes"})
		@Override
		protected Object convertToType(Class type, Object value) throws Throwable {
			return PurchaseSubmitEnum.from(value);
		}

		@Override
		protected Class<?> getDefaultType() {
			return PurchaseSubmitEnum.class;
		}
	}

	public static class DBConverter extends AbstractHasCodeConverter<PurchaseSubmitEnum> {

        @Override
        public PurchaseSubmitEnum from(Integer code) {
            return PurchaseSubmitEnum.from(code);
        }
	}
}
