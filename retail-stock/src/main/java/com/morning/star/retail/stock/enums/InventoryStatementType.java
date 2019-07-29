package com.morning.star.retail.stock.enums;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.beanutils.converters.AbstractConverter;

import com.morning.star.retail.utils.entity.AbstractHasCodeConverter;
import com.morning.star.retail.utils.entity.HasCode;

/**
 * 类型（0：长货；1；短货）
 */
public enum InventoryStatementType implements HasCode {
    PROFIT(0), LOSS(1);

    private final Integer code;

    InventoryStatementType(Integer code) {
        this.code = code;
    }

    @Override
    public Integer getCode() {
        return code;
    }


    private final static Map<Integer, InventoryStatementType> map = Arrays.asList(InventoryStatementType.values()).stream()
            .collect(Collectors.toMap(InventoryStatementType::getCode, e -> e));

    public static InventoryStatementType from(Object code) {
        return map.get(code);
    }

    public static class BeanSerializer extends AbstractConverter {
        @SuppressWarnings({"unchecked", "rawtypes"})
        @Override
        protected Object convertToType(Class type, Object value) throws Throwable {
            return value == null ? null : ((InventoryStatementType) value).getCode();
        }

        @Override
        protected Class<?> getDefaultType() {
            return InventoryStatementType.class;
        }
    }

    public static class BeanDeserializer extends AbstractConverter {

        @SuppressWarnings({"unchecked", "rawtypes"})
        @Override
        protected Object convertToType(Class type, Object value) throws Throwable {
            return InventoryStatementType.from(value);
        }

        @Override
        protected Class<?> getDefaultType() {
            return InventoryStatementType.class;
        }
    }

    public static class DBConverter extends AbstractHasCodeConverter<InventoryStatementType> {

        @Override
        public InventoryStatementType from(Integer code) {
            return InventoryStatementType.from(code);
        }

    }

}
