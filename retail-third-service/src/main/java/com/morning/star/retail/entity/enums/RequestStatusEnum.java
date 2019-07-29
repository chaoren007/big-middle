package com.morning.star.retail.entity.enums;

import com.morning.star.retail.utils.entity.AbstractHasCodeConverter;
import com.morning.star.retail.utils.entity.HasCode;
import org.apache.commons.beanutils.converters.AbstractConverter;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 请求标识
 */
public enum RequestStatusEnum implements HasCode {
	/**
     * 下面枚举说明
	 */
	INIT(0, "调用外部接口初始化"),
	BEGIN(1, "开始调用外部接口"),
	SUCCESS(2, "成功"),
	FAIL(3, "失败"),
	SUBMIT(4,"已提交"),
	AUDIT(5,"已审核"),
	UNAUDIT(6,"反审核"),
	DELETE(7,"已删除");

	private final Integer code;

	private final String desc;

	RequestStatusEnum(Integer code, String desc) {
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

	private static Map<Integer, RequestStatusEnum> map = Arrays.asList(RequestStatusEnum.values())
			.stream().collect(Collectors.toMap(RequestStatusEnum::getCode, e -> e));

	public static RequestStatusEnum from(Object code) {
		return map.get(code);
	}

	public static class BeanSerializer extends AbstractConverter {
		@SuppressWarnings({"unchecked", "rawtypes"})
		@Override
		protected Object convertToType(Class type, Object value) throws Throwable {
			return value == null ? null : ((RequestStatusEnum) value).getCode();
		}

		@Override
		protected Class<?> getDefaultType() {
			return RequestStatusEnum.class;
		}
	}

	public static class BeanDeserializer extends AbstractConverter {
		@SuppressWarnings({"unchecked", "rawtypes"})
		@Override
		protected Object convertToType(Class type, Object value) throws Throwable {
			return RequestStatusEnum.from(value);
		}

		@Override
		protected Class<?> getDefaultType() {
			return RequestStatusEnum.class;
		}
	}

	public static class DBConverter extends AbstractHasCodeConverter<RequestStatusEnum> {
		@Override
		public RequestStatusEnum from(Integer code) {
			return RequestStatusEnum.from(code);
		}

	}
}
