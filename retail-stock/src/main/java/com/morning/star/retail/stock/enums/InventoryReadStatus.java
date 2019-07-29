package com.morning.star.retail.stock.enums;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.beanutils.converters.AbstractConverter;

import com.morning.star.retail.utils.entity.AbstractHasCodeConverter;
import com.morning.star.retail.utils.entity.HasCode;

/**
 * 阅读状态（0：未查阅；1：已查阅）
 */
public enum InventoryReadStatus implements HasCode {
    N(0), Y(1);

    private final Integer code;

    InventoryReadStatus(Integer code) {
        this.code = code;
    }

    @Override
    public Integer getCode() {
        return code;
    }


    private final static Map<Integer, InventoryReadStatus> map = Arrays.asList(InventoryReadStatus.values()).stream()
            .collect(Collectors.toMap(InventoryReadStatus::getCode, e -> e));

    public static InventoryReadStatus from(Object code) {
        return map.get(code);
    }

    public static class BeanSerializer extends AbstractConverter {
        @SuppressWarnings({"unchecked", "rawtypes"})
        @Override
        protected Object convertToType(Class type, Object value) throws Throwable {
            return value == null ? null : ((InventoryReadStatus) value).getCode();
        }

        @Override
        protected Class<?> getDefaultType() {
            return InventoryReadStatus.class;
        }
    }

    public static class BeanDeserializer extends AbstractConverter {

        @SuppressWarnings({"unchecked", "rawtypes"})
        @Override
        protected Object convertToType(Class type, Object value) throws Throwable {
            return InventoryReadStatus.from(value);
        }

        @Override
        protected Class<?> getDefaultType() {
            return InventoryReadStatus.class;
        }
    }

    public static class DBConverter extends AbstractHasCodeConverter<InventoryReadStatus> {

        @Override
        public InventoryReadStatus from(Integer code) {
            return InventoryReadStatus.from(code);
        }

    }

}
