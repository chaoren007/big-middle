package com.morning.star.retail.stock.enums;

import com.morning.star.retail.utils.entity.AbstractHasCodeConverter;
import com.morning.star.retail.utils.entity.HasCode;
import org.apache.commons.beanutils.converters.AbstractConverter;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public enum ReceiptStatusEnum implements HasCode {
    N(0, "未入库"), Y(1, "已入库");

    private int code;
    private String desc;

    ReceiptStatusEnum(int code, String desc) {
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

    private final static Map<Integer, ReceiptStatusEnum> map = Arrays.asList(ReceiptStatusEnum.values()).stream()
            .collect(Collectors.toMap(ReceiptStatusEnum::getCode, e -> e));

    public static ReceiptStatusEnum from(Object code) {
        return map.get(code);
    }

    public static class BeanSerializer extends AbstractConverter {
        @SuppressWarnings({"unchecked", "rawtypes"})
        @Override
        protected Object convertToType(Class type, Object value) throws Throwable {
            return value == null ? null : ((ReceiptStatusEnum) value).getCode();
        }

        @Override
        protected Class<?> getDefaultType() {
            return ReceiptStatusEnum.class;
        }
    }

    public static class BeanDeserializer extends AbstractConverter {

        @SuppressWarnings({"unchecked", "rawtypes"})
        @Override
        protected Object convertToType(Class type, Object value) throws Throwable {
            return ReceiptStatusEnum.from(value);
        }

        @Override
        protected Class<?> getDefaultType() {
            return ReceiptStatusEnum.class;
        }
    }

    public static class DBConverter extends AbstractHasCodeConverter<ReceiptStatusEnum> {

        @Override
        public ReceiptStatusEnum from(Integer code) {
            return ReceiptStatusEnum.from(code);
        }
    }

}
