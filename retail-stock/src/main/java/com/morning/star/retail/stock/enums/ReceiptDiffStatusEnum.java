package com.morning.star.retail.stock.enums;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.beanutils.converters.AbstractConverter;

import com.morning.star.retail.utils.entity.AbstractHasCodeConverter;
import com.morning.star.retail.utils.entity.HasCode;

public enum ReceiptDiffStatusEnum implements HasCode {
	WAIT_WRITE(0, "待填写差异单"), WAIT_CHECK(10, "待审核"), WAIT_SCHEME(20, "待提供处理方案"), WAIT_RETURN(30, "待退货"), RESPONSIBLE(40, "已定责");

	private int code;
	private String desc;

	ReceiptDiffStatusEnum(int code, String desc) {
		this.code = code;
		this.desc = desc;
	}

	public Integer getCode() {
		return code;
	}

	public String getDesc() {
		return desc;
	}

	private final static Map<Integer, ReceiptDiffStatusEnum> map = Arrays.asList(ReceiptDiffStatusEnum.values()).stream()
		.collect(Collectors.toMap(ReceiptDiffStatusEnum::getCode, e -> e));

	public static ReceiptDiffStatusEnum from(Object code) {
		return map.get(code);
	}

	public static class BeanSerializer extends AbstractConverter {
		@SuppressWarnings({"unchecked", "rawtypes"})
		@Override
		protected Object convertToType(Class type, Object value) throws Throwable {
			return value == null ? null : ((ReceiptDiffStatusEnum) value).getCode();
		}

		@Override
		protected Class<?> getDefaultType() {
			return ReceiptDiffStatusEnum.class;
		}
	}

	public static class BeanDeserializer extends AbstractConverter {

		@SuppressWarnings({"unchecked", "rawtypes"})
		@Override
		protected Object convertToType(Class type, Object value) throws Throwable {
			return ReceiptDiffStatusEnum.from(value);
		}

		@Override
		protected Class<?> getDefaultType() {
			return ReceiptDiffStatusEnum.class;
		}
	}

	public static class DBConverter extends AbstractHasCodeConverter<ReceiptDiffStatusEnum> {

        @Override
        public ReceiptDiffStatusEnum from(Integer code) {
            return ReceiptDiffStatusEnum.from(code);
        }


	}

}
