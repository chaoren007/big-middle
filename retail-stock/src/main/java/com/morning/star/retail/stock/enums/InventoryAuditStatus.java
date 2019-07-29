package com.morning.star.retail.stock.enums;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.beanutils.converters.AbstractConverter;

import com.morning.star.retail.utils.entity.AbstractHasCodeConverter;
import com.morning.star.retail.utils.entity.HasCode;

/**
 * 盘点审核状态
 */
public enum InventoryAuditStatus implements HasCode {
    WAIT_AUDIT(0), //待审核
    AUDIT_SUCC(1), // 审核成功
    AUDIT_FAIL(2); // 审核失败

    private final Integer code;

    InventoryAuditStatus(Integer code) {
        this.code = code;
    }

    @Override
    public Integer getCode() {
        return code;
    }

    private final static Map<Integer, InventoryAuditStatus> map = Arrays.asList(InventoryAuditStatus.values()).stream().collect(Collectors.toMap(InventoryAuditStatus::getCode, e -> e));

    public static InventoryAuditStatus from(Object code) {
        return map.get(code);
    }

    public static class BeanSerializer extends AbstractConverter {
        @SuppressWarnings({"unchecked", "rawtypes"})
        @Override
        protected Object convertToType(Class type, Object value) throws Throwable {
            return value == null ? null : ((InventoryAuditStatus) value).getCode();
        }

        @Override
        protected Class<?> getDefaultType() {
            return InventoryAuditStatus.class;
        }
    }

    public static class BeanDeserializer extends AbstractConverter {

        @SuppressWarnings({"unchecked", "rawtypes"})
        @Override
        protected Object convertToType(Class type, Object value) throws Throwable {
            return InventoryAuditStatus.from(value);
        }

        @Override
        protected Class<?> getDefaultType() {
            return InventoryAuditStatus.class;
        }
    }

    public static class DBConverter extends AbstractHasCodeConverter<InventoryAuditStatus> {

        @Override
        public InventoryAuditStatus from(Integer code) {
            return InventoryAuditStatus.from(code);
        }

    }

}
