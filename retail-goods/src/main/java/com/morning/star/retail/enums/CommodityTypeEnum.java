package com.morning.star.retail.enums;

import com.morning.star.retail.utils.entity.AbstractHasCodeConverter;
import com.morning.star.retail.utils.entity.HasCode;
import org.apache.commons.beanutils.converters.AbstractConverter;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 商品类型
 */
public enum CommodityTypeEnum implements HasCode {
	STANDARD(0, "标品"),
	NO_STANDARD(1, "非标品"),
	CLOTHES(2, "服饰");

	private final Integer code;

	private final String desc;

	CommodityTypeEnum(Integer code, String desc) {
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
	
	private static Map<Integer, CommodityTypeEnum> map = Arrays.asList(CommodityTypeEnum.values())
	        .stream().collect(Collectors.toMap(CommodityTypeEnum::getCode, e -> e));
	
	public static CommodityTypeEnum from(Object code) {
	    return map.get(code);
	}

	public static class BeanSerializer extends AbstractConverter {
		@SuppressWarnings({"unchecked", "rawtypes"})
		@Override
		protected Object convertToType(Class type, Object value) throws Throwable {
			return value == null ? null : ((CommodityTypeEnum) value).getCode();
		}

		@Override
		protected Class<?> getDefaultType() {
			return CommodityTypeEnum.class;
		}
	}

	public static class BeanDeserializer extends AbstractConverter {
		@SuppressWarnings({"unchecked", "rawtypes"})
		@Override
		protected Object convertToType(Class type, Object value) throws Throwable {
			return CommodityTypeEnum.from(value);
		}

		@Override
		protected Class<?> getDefaultType() {
			return CommodityTypeEnum.class;
		}
	}

	public static class DBConverter extends AbstractHasCodeConverter<CommodityTypeEnum> {
        @Override
        public CommodityTypeEnum from(Integer code) {
            return CommodityTypeEnum.from(code);
        }

	}

}
