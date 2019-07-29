package com.morning.star.retail.entity;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.beanutils.converters.AbstractConverter;

import com.morning.star.retail.utils.entity.AbstractHasCodeConverter;
import com.morning.star.retail.utils.entity.HasCode;

public enum GroupType implements HasCode {
	GROUP(1, "集团型"),
	POP(2, "POP型");

	private final Integer code;
	private final String desc;

	GroupType(Integer code, String desc) {
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
	
	private static Map<Integer, GroupType> map = Arrays.asList(GroupType.values())
	        .stream().collect(Collectors.toMap(GroupType::getCode, e -> e));
	
	public static GroupType from(Object code) {
	    return map.get(code);
	}

	public static class BeanSerializer extends AbstractConverter {
		@SuppressWarnings({"unchecked", "rawtypes"})
		@Override
		protected Object convertToType(Class type, Object value) throws Throwable {
			return value == null ? null : ((GroupType) value).getCode();
		}

		@Override
		protected Class<?> getDefaultType() {
			return GroupType.class;
		}
	}

	public static class BeanDeserializer extends AbstractConverter {

		@SuppressWarnings({"unchecked", "rawtypes"})
		@Override
		protected Object convertToType(Class type, Object value) throws Throwable {
			return GroupType.from(value);
		}

		@Override
		protected Class<?> getDefaultType() {
			return GroupType.class;
		}
	}

	public static class DBConverter extends AbstractHasCodeConverter<GroupType> {

        @Override
        public GroupType from(Integer code) {
            return GroupType.from(code);
        }


	}

}
