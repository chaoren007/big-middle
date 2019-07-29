package com.morning.star.retail.enums;

import com.morning.star.retail.utils.entity.AbstractHasCodeConverter;
import com.morning.star.retail.utils.entity.HasCode;
import org.apache.commons.beanutils.converters.AbstractConverter;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 商品存储类型
 */
public enum StorageTypeEnum implements HasCode {
	COLD(0, "冷藏存储"),
	NORMAL(1, "普通存储"),
	FREEZING(2, "冷冻存储");

	private final Integer code;

	private final String desc;

	StorageTypeEnum(Integer code, String desc) {
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
	
	private static Map<Integer, StorageTypeEnum> map = Arrays.asList(StorageTypeEnum.values())
	        .stream().collect(Collectors.toMap(StorageTypeEnum::getCode, e -> e));
	
	public static StorageTypeEnum from(Object code) {
	    return map.get(code);
	}

	public static class BeanSerializer extends AbstractConverter {
		@SuppressWarnings({"unchecked", "rawtypes"})
		@Override
		protected Object convertToType(Class type, Object value) throws Throwable {
			return value == null ? null : ((StorageTypeEnum) value).getCode();
		}

		@Override
		protected Class<?> getDefaultType() {
			return StorageTypeEnum.class;
		}
	}

	public static class BeanDeserializer extends AbstractConverter {
		@SuppressWarnings({"unchecked", "rawtypes"})
		@Override
		protected Object convertToType(Class type, Object value) throws Throwable {
			return StorageTypeEnum.from(value);
		}

		@Override
		protected Class<?> getDefaultType() {
			return StorageTypeEnum.class;
		}
	}

	public static class DBConverter extends AbstractHasCodeConverter<StorageTypeEnum> {
        @Override
        public StorageTypeEnum from(Integer code) {
            return StorageTypeEnum.from(code);
        }

	}

}
