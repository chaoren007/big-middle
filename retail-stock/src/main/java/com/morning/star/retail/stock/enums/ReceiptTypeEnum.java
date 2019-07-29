package com.morning.star.retail.stock.enums;

import com.morning.star.retail.utils.entity.AbstractHasCodeConverter;
import com.morning.star.retail.utils.entity.HasCode;
import org.apache.commons.beanutils.converters.AbstractConverter;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 入库类型（0：采购入库，1：退货入库）
 *
 * @author jiangyf
 */
public enum ReceiptTypeEnum implements HasCode {
    PURCHASE_IN(0, "采购入库"), RETURN_IN(1, "退货入库"), TRANSFER_IN(2, "调拨入库");

    private int code;
    private String desc;

    ReceiptTypeEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public static ReceiptTypeEnum getByValues(String desc) {
        ReceiptTypeEnum[] values = ReceiptTypeEnum.values();
        for (ReceiptTypeEnum value : values) {
            if (value.getDesc().equals(desc)) {
                return value;
            }
        }
        return null;
    }

    @Override
    public Integer getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    private final static Map<Integer, ReceiptTypeEnum> map = Arrays.asList(ReceiptTypeEnum.values()).stream()
            .collect(Collectors.toMap(ReceiptTypeEnum::getCode, e -> e));

    public static ReceiptTypeEnum from(Object code) {
        return map.get(code);
    }

    public static class BeanSerializer extends AbstractConverter {
        @SuppressWarnings({"unchecked", "rawtypes"})
        @Override
        protected Object convertToType(Class type, Object value) throws Throwable {
            return value == null ? null : ((ReceiptTypeEnum) value).getCode();
        }

        @Override
        protected Class<?> getDefaultType() {
            return ReceiptTypeEnum.class;
        }
    }

    public static class BeanDeserializer extends AbstractConverter {

        @SuppressWarnings({"unchecked", "rawtypes"})
        @Override
        protected Object convertToType(Class type, Object value) throws Throwable {
            return ReceiptTypeEnum.from(value);
        }

        @Override
        protected Class<?> getDefaultType() {
            return ReceiptTypeEnum.class;
        }
    }

    public static class DBConverter extends AbstractHasCodeConverter<ReceiptTypeEnum> {

        @Override
        public ReceiptTypeEnum from(Integer code) {
            return ReceiptTypeEnum.from(code);
        }

    }

}
