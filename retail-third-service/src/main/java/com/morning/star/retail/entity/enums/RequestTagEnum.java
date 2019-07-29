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
public enum RequestTagEnum implements HasCode {
	/**
     * 下面枚举说明
	 */
	WMS_CREATE_GOODS(1, "wms添加商品"),
	WMS_CREATE_CATEGORY(2, "wms添加分类"),
	WMS_CREATE_STORAGE(3, "wms添加仓库"),
	WMS_CREATE_PURCHASE(4, "wms采购订单推送"),
	WMS_CREATE_SUPPLIER(5, "wms添加供应商"),
	WMS_CREATE_STORE(6, "wms添加分公司"),
	WMS_INSTOCK_RETURN(7,"mws入库回写"),
	WMS_OUTSTOCK_RETURN(8,"mws出库回写"),
	WMS_MOVE(9,"mws移库推送"),
	WMS_OUTSTOCK(10,"mws出库推送（S-销售出库单，P-调拨出库单，SR-销售入库单，PR-调拨入库单）"),



	
	KINGDEE_CREATE_UNITS(30,"金蝶云添加单位"),
	KINGDEE_DELETE_UNITS(31,"金蝶云删除单位"),
	KINGDEE_CREATE_TAXRATE(32,"金蝶云添加税率"),
	KINGDEE_CREATE_TAXTYPE(33,"金蝶云添加税种"),
	KINGDEE_CREATE_POSITION(34,"金蝶云添加岗位"),
	KINGDEE_CREATE_WAREHOUSE(35,"金蝶云添加仓库"),
	KINGDEE_CREATE_GOODS(36,"金蝶云添加物料"),
	BUISNESS_CREATE_OPC(60,"创建运营端"),
	BUISNESS_CREATE_PRODUCT(61,"同步商品到运营端"),
	;

	private final Integer code;

	private final String desc;

	RequestTagEnum(Integer code, String desc) {
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

	private static Map<Integer, RequestTagEnum> map = Arrays.asList(RequestTagEnum.values())
			.stream().collect(Collectors.toMap(RequestTagEnum::getCode, e -> e));

	public static RequestTagEnum from(Object code) {
		return map.get(code);
	}

	public static class BeanSerializer extends AbstractConverter {
		@SuppressWarnings({"unchecked", "rawtypes"})
		@Override
		protected Object convertToType(Class type, Object value) throws Throwable {
			return value == null ? null : ((RequestTagEnum) value).getCode();
		}

		@Override
		protected Class<?> getDefaultType() {
			return RequestTagEnum.class;
		}
	}

	public static class BeanDeserializer extends AbstractConverter {
		@SuppressWarnings({"unchecked", "rawtypes"})
		@Override
		protected Object convertToType(Class type, Object value) throws Throwable {
			return RequestTagEnum.from(value);
		}

		@Override
		protected Class<?> getDefaultType() {
			return RequestTagEnum.class;
		}
	}

	public static class DBConverter extends AbstractHasCodeConverter<RequestTagEnum> {
		@Override
		public RequestTagEnum from(Integer code) {
			return RequestTagEnum.from(code);
		}

	}
}
