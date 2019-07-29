package com.morning.star.retail.stock.enums;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.beanutils.converters.AbstractConverter;

import com.morning.star.retail.utils.entity.AbstractHasCodeConverter;
import com.morning.star.retail.utils.entity.HasCode;

public enum ReceiptDiffPlanEnum implements HasCode {
	//0、物流公司上架 10、物流公司全责 20、物流公司门店各50% 30.门店全责
	COMPANY_UP(0, "物流公司上架"), COMPANY_DEAL(10, "物流公司全责"), COMPANY_STORE(20, "物流公司门店各50"), STORE_DEAL(30, "门店全责");

	private int code;
	private String desc;

	ReceiptDiffPlanEnum(int code, String desc) {
		this.code = code;
		this.desc = desc;
	}

	public Integer getCode() {
		return code;
	}

	public String getDesc() {
		return desc;
	}

	private final static Map<Integer, ReceiptDiffPlanEnum> map = Arrays.asList(ReceiptDiffPlanEnum.values()).stream()
		.collect(Collectors.toMap(ReceiptDiffPlanEnum::getCode, e -> e));

	public static ReceiptDiffPlanEnum from(Object code) {
		return map.get(code);
	}

	public static class BeanSerializer extends AbstractConverter {
		@SuppressWarnings({"unchecked", "rawtypes"})
		@Override
		protected Object convertToType(Class type, Object value) throws Throwable {
			return value == null ? null : ((ReceiptDiffPlanEnum) value).getCode();
		}

		@Override
		protected Class<?> getDefaultType() {
			return ReceiptDiffPlanEnum.class;
		}
	}

	public static class BeanDeserializer extends AbstractConverter {

		@SuppressWarnings({"unchecked", "rawtypes"})
		@Override
		protected Object convertToType(Class type, Object value) throws Throwable {
			return ReceiptDiffPlanEnum.from(value);
		}

		@Override
		protected Class<?> getDefaultType() {
			return ReceiptDiffPlanEnum.class;
		}
	}

	public static class DBConverter extends AbstractHasCodeConverter<ReceiptDiffPlanEnum> {

        @Override
        public ReceiptDiffPlanEnum from(Integer code) {
            return ReceiptDiffPlanEnum.from(code);
        }


	}

}
