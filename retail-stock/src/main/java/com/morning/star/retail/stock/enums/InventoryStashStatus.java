package com.morning.star.retail.stock.enums;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.beanutils.converters.AbstractConverter;

import com.morning.star.retail.utils.entity.AbstractHasCodeConverter;
import com.morning.star.retail.utils.entity.HasCode;

/**
 * 盘点扎帐状态（ 0：未扎帐；1：已扎帐）
 */
public enum InventoryStashStatus implements HasCode {
    N(0), Y(1);

    private final Integer code;

    InventoryStashStatus(Integer code) {
        this.code = code;
    }

    @Override
    public Integer getCode() {
        return code;
    }


    private final static Map<Integer, InventoryStashStatus> map = Arrays.asList(InventoryStashStatus.values()).stream()
            .collect(Collectors.toMap(InventoryStashStatus::getCode, e -> e));

    public static InventoryStashStatus from(Object code) {
        return map.get(code);
    }

    public static class BeanSerializer extends AbstractConverter {
        @SuppressWarnings({"unchecked", "rawtypes"})
        @Override
        protected Object convertToType(Class type, Object value) throws Throwable {
            return value == null ? null : ((InventoryStashStatus) value).getCode();
        }

        @Override
        protected Class<?> getDefaultType() {
            return InventoryStashStatus.class;
        }
    }

    public static class BeanDeserializer extends AbstractConverter {

        @SuppressWarnings({"unchecked", "rawtypes"})
        @Override
        protected Object convertToType(Class type, Object value) throws Throwable {
            return InventoryStashStatus.from(value);
        }

        @Override
        protected Class<?> getDefaultType() {
            return InventoryStashStatus.class;
        }
    }

    public static class DBConverter extends AbstractHasCodeConverter<InventoryStashStatus> {

        @Override
        public InventoryStashStatus from(Integer code) {
            return InventoryStashStatus.from(code);
        }

    }

}
