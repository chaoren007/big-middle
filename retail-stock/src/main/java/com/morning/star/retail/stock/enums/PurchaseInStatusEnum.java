package com.morning.star.retail.stock.enums;

import com.morning.star.retail.utils.entity.AbstractHasCodeConverter;
import com.morning.star.retail.utils.entity.HasCode;
import org.apache.commons.beanutils.converters.AbstractConverter;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public enum PurchaseInStatusEnum implements HasCode {
	SUCCESS(20, "待推送"),
	PUSH(30, "未入库"),// 推送WMS成功后，等待入库
	PART_RECEIPT(35, "部分入库"),
    ALL_RECEIPT(40, "入库完毕"),
	CLOSE(50, "未入库关闭"),
	PART_CLOSE(51, "部分入库完毕");

	private final Integer code;
	private final String desc;

	PurchaseInStatusEnum(Integer code, String desc) {
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

	private final static Map<Integer, PurchaseInStatusEnum> map = Arrays.asList(PurchaseInStatusEnum.values()).stream()
		.collect(Collectors.toMap(PurchaseInStatusEnum::getCode, e -> e));

	public static PurchaseInStatusEnum from(Object code) {
		return map.get(code);
	}

	public static class BeanSerializer extends AbstractConverter {
		@SuppressWarnings({"unchecked", "rawtypes"})
		@Override
		protected Object convertToType(Class type, Object value) throws Throwable {
			return value == null ? null : ((PurchaseInStatusEnum) value).getCode();
		}

		@Override
		protected Class<?> getDefaultType() {
			return PurchaseInStatusEnum.class;
		}
	}

	public static class BeanDeserializer extends AbstractConverter {

		@SuppressWarnings({"unchecked", "rawtypes"})
		@Override
		protected Object convertToType(Class type, Object value) throws Throwable {
			return PurchaseInStatusEnum.from(value);
		}

		@Override
		protected Class<?> getDefaultType() {
			return PurchaseInStatusEnum.class;
		}
	}

	public static class DBConverter extends AbstractHasCodeConverter<PurchaseInStatusEnum> {

        @Override
        public PurchaseInStatusEnum from(Integer code) {
            return PurchaseInStatusEnum.from(code);
        }
	}
}
