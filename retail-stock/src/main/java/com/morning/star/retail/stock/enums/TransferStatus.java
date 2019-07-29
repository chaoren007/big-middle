package com.morning.star.retail.stock.enums;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.beanutils.converters.AbstractConverter;

import com.morning.star.retail.utils.entity.AbstractHasCodeConverter;
import com.morning.star.retail.utils.entity.HasCode;

/**
 * 调拨状态
 */
public enum TransferStatus implements HasCode {
	DRAFT(0), WAIT_AUDIT(10), AUDIT_SUCCESS(20), AUDIT_REJECT(30);

	private final Integer code;

	TransferStatus(Integer code) {
		this.code = code;
	}

	@Override
	public Integer getCode() {
		return code;
	}
	
	private static Map<Integer, TransferStatus> map = Arrays.asList(TransferStatus.values())
	        .stream().collect(Collectors.toMap(TransferStatus::getCode, e -> e));
	
	public static TransferStatus from(Object code) {
	    return map.get(code);
	}

	public static class BeanConverter extends AbstractConverter {
		@SuppressWarnings({"unchecked", "rawtypes"})
		@Override
		protected Object convertToType(Class type, Object value) throws Throwable {
			return value == null ? null : ((TransferStatus) value).getCode();
		}

		@Override
		protected Class<?> getDefaultType() {
			return TransferStatus.class;
		}
	}

	public static class BeanReConverter extends AbstractConverter {
		@SuppressWarnings({"unchecked", "rawtypes"})
		@Override
		protected Object convertToType(Class type, Object value) throws Throwable {
			return TransferStatus.from(value);
		}

		@Override
		protected Class<?> getDefaultType() {
			return TransferStatus.class;
		}
	}

	/**
	 * JPA 列绑定枚举类型数据
	 */
	public static class TransferStatusConverter extends AbstractHasCodeConverter<TransferStatus> {
		@Override
		public TransferStatus from(Integer code) {
			return TransferStatus.from(code);
		}

	}
}
