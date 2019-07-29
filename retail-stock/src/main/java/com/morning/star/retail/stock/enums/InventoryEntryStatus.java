package com.morning.star.retail.stock.enums;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.beanutils.converters.AbstractConverter;

import com.morning.star.retail.utils.entity.AbstractHasCodeConverter;
import com.morning.star.retail.utils.entity.HasCode;

/**
 * 盘点录入状态（ 0：未录入；1：已录入）
 */
public enum InventoryEntryStatus implements HasCode {
    N(0), Y(1);

    private final Integer code;

    InventoryEntryStatus(Integer code) {
        this.code = code;
    }

    @Override
    public Integer getCode() {
        return code;
    }


    private final static Map<Integer, InventoryEntryStatus> map = Arrays.asList(InventoryEntryStatus.values()).stream()
            .collect(Collectors.toMap(InventoryEntryStatus::getCode, e -> e));

    public static InventoryEntryStatus from(Object code) {
        return map.get(code);
    }

    public static class BeanSerializer extends AbstractConverter {
        @SuppressWarnings({"unchecked", "rawtypes"})
        @Override
        protected Object convertToType(Class type, Object value) throws Throwable {
            return value == null ? null : ((InventoryEntryStatus) value).getCode();
        }

        @Override
        protected Class<?> getDefaultType() {
            return InventoryEntryStatus.class;
        }
    }

    public static class BeanDeserializer extends AbstractConverter {

        @SuppressWarnings({"unchecked", "rawtypes"})
        @Override
        protected Object convertToType(Class type, Object value) throws Throwable {
            return InventoryEntryStatus.from(value);
        }

        @Override
        protected Class<?> getDefaultType() {
            return InventoryEntryStatus.class;
        }
    }

    public static class DBConverter extends AbstractHasCodeConverter<InventoryEntryStatus> {

        @Override
        public InventoryEntryStatus from(Integer code) {
            return InventoryEntryStatus.from(code);
        }

    }

}
