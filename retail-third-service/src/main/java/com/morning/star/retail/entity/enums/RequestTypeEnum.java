package com.morning.star.retail.entity.enums;

import com.morning.star.retail.utils.entity.AbstractHasCodeConverter;
import com.morning.star.retail.utils.entity.HasCode;
import org.apache.commons.beanutils.converters.AbstractConverter;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 请求类型
 */
public enum RequestTypeEnum implements HasCode {
	/**
	 * 0-wms,1-金蝶云
	 */
	WMS(0, "wms第三方服务"),
	WMS_RETURN(2, "wms第三方服务回写"),
	KINGDEE_CLOUD(1, "金蝶云第三方服务"),
	BUISNESS(3, "运营端"),;

	private final Integer code;

	private final String desc;

	RequestTypeEnum(Integer code, String desc) {
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

	private static Map<Integer, RequestTypeEnum> map = Arrays.asList(RequestTypeEnum.values())
			.stream().collect(Collectors.toMap(RequestTypeEnum::getCode, e -> e));

	public static RequestTypeEnum from(Object code) {
		return map.get(code);
	}

	public static class BeanSerializer extends AbstractConverter {
		@SuppressWarnings({"unchecked", "rawtypes"})
		@Override
		protected Object convertToType(Class type, Object value) throws Throwable {
			return value == null ? null : ((RequestTypeEnum) value).getCode();
		}

		@Override
		protected Class<?> getDefaultType() {
			return RequestTypeEnum.class;
		}
	}

	public static class BeanDeserializer extends AbstractConverter {
		@SuppressWarnings({"unchecked", "rawtypes"})
		@Override
		protected Object convertToType(Class type, Object value) throws Throwable {
			return RequestTypeEnum.from(value);
		}

		@Override
		protected Class<?> getDefaultType() {
			return RequestTypeEnum.class;
		}
	}

	public static class DBConverter extends AbstractHasCodeConverter<RequestTypeEnum> {
		@Override
		public RequestTypeEnum from(Integer code) {
			return RequestTypeEnum.from(code);
		}

	}
}
