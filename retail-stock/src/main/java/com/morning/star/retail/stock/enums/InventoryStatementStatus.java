package com.morning.star.retail.stock.enums;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.beanutils.converters.AbstractConverter;

import com.morning.star.retail.utils.entity.AbstractHasCodeConverter;
import com.morning.star.retail.utils.entity.HasCode;

/**
 * 盘点长短单状态（0：未生成；1：已生成；2：已确认；3：已存档）
 */
public enum InventoryStatementStatus implements HasCode {
    NONE(0), GENERATED(1), CONFIRMED(2), ARCHIVED(3);

    private final Integer code;

    InventoryStatementStatus(Integer code) {
        this.code = code;
    }

    @Override
    public Integer getCode() {
        return code;
    }


    private final static Map<Integer, InventoryStatementStatus> map = Arrays.asList(InventoryStatementStatus.values()).stream()
            .collect(Collectors.toMap(InventoryStatementStatus::getCode, e -> e));

    public static InventoryStatementStatus from(Object code) {
        return map.get(code);
    }

    public static class BeanSerializer extends AbstractConverter {
        @SuppressWarnings({"unchecked", "rawtypes"})
        @Override
        protected Object convertToType(Class type, Object value) throws Throwable {
            return value == null ? null : ((InventoryStatementStatus) value).getCode();
        }

        @Override
        protected Class<?> getDefaultType() {
            return InventoryStatementStatus.class;
        }
    }

    public static class BeanDeserializer extends AbstractConverter {

        @SuppressWarnings({"unchecked", "rawtypes"})
        @Override
        protected Object convertToType(Class type, Object value) throws Throwable {
            return InventoryStatementStatus.from(value);
        }

        @Override
        protected Class<?> getDefaultType() {
            return InventoryStatementStatus.class;
        }
    }

    public static class DBConverter extends AbstractHasCodeConverter<InventoryStatementStatus> {

        @Override
        public InventoryStatementStatus from(Integer code) {
            return InventoryStatementStatus.from(code);
        }

    }

}
