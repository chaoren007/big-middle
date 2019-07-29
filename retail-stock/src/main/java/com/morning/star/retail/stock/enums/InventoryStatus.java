package com.morning.star.retail.stock.enums;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.beanutils.converters.AbstractConverter;

import com.morning.star.retail.utils.entity.AbstractHasCodeConverter;
import com.morning.star.retail.utils.entity.HasCode;

/**
 * 状态（ 0：使用中；1：已废弃）
 */
public enum InventoryStatus implements HasCode {
    USED(0),
    UNUSED(1);

    private final Integer code;

    InventoryStatus(Integer code) {
        this.code = code;
    }

    @Override
    public Integer getCode() {
        return code;
    }


    private final static Map<Integer, InventoryStatus> map = Arrays.asList(InventoryStatus.values()).stream()
            .collect(Collectors.toMap(InventoryStatus::getCode, e -> e));

    public static InventoryStatus from(Object code) {
        return map.get(code);
    }

    public static class BeanSerializer extends AbstractConverter {
        @SuppressWarnings({"unchecked", "rawtypes"})
        @Override
        protected Object convertToType(Class type, Object value) throws Throwable {
            return value == null ? null : ((InventoryStatus) value).getCode();
        }

        @Override
        protected Class<?> getDefaultType() {
            return InventoryStatus.class;
        }
    }

    public static class BeanDeserializer extends AbstractConverter {

        @SuppressWarnings({"unchecked", "rawtypes"})
        @Override
        protected Object convertToType(Class type, Object value) throws Throwable {
            return InventoryStatus.from(value);
        }

        @Override
        protected Class<?> getDefaultType() {
            return InventoryStatus.class;
        }
    }

    public static class DBConverter extends AbstractHasCodeConverter<InventoryStatus> {

        @Override
        public InventoryStatus from(Integer code) {
            return InventoryStatus.from(code);
        }
    }

}
