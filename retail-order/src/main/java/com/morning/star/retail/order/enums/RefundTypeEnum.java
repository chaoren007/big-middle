package com.morning.star.retail.order.enums;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.beanutils.converters.AbstractConverter;

import com.morning.star.retail.utils.entity.AbstractHasCodeConverter;
import com.morning.star.retail.utils.entity.HasCode;

public enum RefundTypeEnum implements HasCode {
	ALL(1, "全部退货"),
	PART(2, "部分退货"),
	REJECT(3, "拒收");

	private final Integer code;
	private final String desc;

	RefundTypeEnum(Integer code, String desc) {
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
	
	private static Map<Integer, RefundTypeEnum> map = Arrays.asList(RefundTypeEnum.values())
	        .stream().collect(Collectors.toMap(RefundTypeEnum::getCode, e -> e));
	
	public static RefundTypeEnum from(Object code) {
	    return map.get(code);
	}

	public static class BeanSerializer extends AbstractConverter {
		@SuppressWarnings({"unchecked", "rawtypes"})
		@Override
		protected Object convertToType(Class type, Object value) throws Throwable {
			return value == null ? null : ((RefundTypeEnum) value).getCode();
		}

		@Override
		protected Class<?> getDefaultType() {
			return RefundTypeEnum.class;
		}
	}

	public static class BeanDeserializer extends AbstractConverter {
		@SuppressWarnings({"unchecked", "rawtypes"})
		@Override
		protected Object convertToType(Class type, Object value) throws Throwable {
			return RefundTypeEnum.from(value);
		}

		@Override
		protected Class<?> getDefaultType() {
			return RefundTypeEnum.class;
		}
	}

	public static class DBConverter extends AbstractHasCodeConverter<RefundTypeEnum> {

        @Override
        public RefundTypeEnum from(Integer code) {
            return RefundTypeEnum.from(code);
        }


	}

}
