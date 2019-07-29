package com.morning.star.retail.order.enums;

import com.morning.star.retail.utils.entity.AbstractHasCodeConverter;
import com.morning.star.retail.utils.entity.HasCode;
import org.apache.commons.beanutils.converters.AbstractConverter;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public enum DealWithEnum implements HasCode {
	YES(1, "已处理"),
	NO(0, "未处理");

	private final Integer code;
	private final String desc;

	DealWithEnum(Integer code, String desc) {
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

	private static Map<Integer, DealWithEnum> map = Arrays.asList(DealWithEnum.values())
	        .stream().collect(Collectors.toMap(DealWithEnum::getCode, e -> e));
	
	public static DealWithEnum from(Object code) {
	    return map.get(code);
	}
	
	
	public static class BeanSerializer extends AbstractConverter {
		@SuppressWarnings({"unchecked", "rawtypes"})
		@Override
		protected Object convertToType(Class type, Object value) {
			return value == null ? null : ((DealWithEnum) value).getCode();
		}

		@Override
		protected Class<?> getDefaultType() {
			return DealWithEnum.class;
		}
	}

	public static class BeanDeserializer extends AbstractConverter {

		@Override
		protected Object convertToType(Class type, Object value) {
			return DealWithEnum.from(value);
		}

		@Override
		protected Class<?> getDefaultType() {
			return DealWithEnum.class;
		}
	}

	public static class DBConverter extends AbstractHasCodeConverter<DealWithEnum> {

        @Override
        public DealWithEnum from(Integer code) {
            return DealWithEnum.from(code);
        }

	}

}
