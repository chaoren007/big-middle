package com.morning.star.retail.stock.enums;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.beanutils.converters.AbstractConverter;

import com.morning.star.retail.utils.entity.AbstractHasCodeConverter;
import com.morning.star.retail.utils.entity.HasCode;

/**
 * 终端盘点状态（0：未经手持终端盘点；1：已经手持终端盘点）
 */
public enum InventoryTerminalStatus implements HasCode {
    N(0), Y(1);

    private final Integer code;

    InventoryTerminalStatus(Integer code) {
        this.code = code;
    }

    @Override
    public Integer getCode() {
        return code;
    }


    private final static Map<Integer, InventoryTerminalStatus> map = Arrays.asList(InventoryTerminalStatus.values()).stream()
            .collect(Collectors.toMap(InventoryTerminalStatus::getCode, e -> e));

    public static InventoryTerminalStatus from(Object code) {
        return map.get(code);
    }

    public static class BeanSerializer extends AbstractConverter {
        @SuppressWarnings({"unchecked", "rawtypes"})
        @Override
        protected Object convertToType(Class type, Object value) throws Throwable {
            return value == null ? null : ((InventoryTerminalStatus) value).getCode();
        }

        @Override
        protected Class<?> getDefaultType() {
            return InventoryTerminalStatus.class;
        }
    }

    public static class BeanDeserializer extends AbstractConverter {

        @SuppressWarnings({"unchecked", "rawtypes"})
        @Override
        protected Object convertToType(Class type, Object value) throws Throwable {
            return InventoryTerminalStatus.from(value);
        }

        @Override
        protected Class<?> getDefaultType() {
            return InventoryTerminalStatus.class;
        }
    }

    public static class DBConverter extends AbstractHasCodeConverter<InventoryTerminalStatus> {

        @Override
        public InventoryTerminalStatus from(Integer code) {
            return InventoryTerminalStatus.from(code);
        }

    }

}
