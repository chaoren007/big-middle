package com.morning.star.retail.order.enums;

import com.morning.star.retail.utils.entity.AbstractHasCodeConverter;
import com.morning.star.retail.utils.entity.HasCode;
import org.apache.commons.beanutils.converters.AbstractConverter;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public enum BusAfterSalesStatusEnum implements HasCode {
    NO_DEAL(0, "未处理"),
    DEALED(1, "已处理");

    private final Integer code;
    private final String desc;

    BusAfterSalesStatusEnum(Integer code, String desc) {
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

    private static Map<Integer, BusAfterSalesStatusEnum> map = Arrays.asList(BusAfterSalesStatusEnum.values())
            .stream().collect(Collectors.toMap(BusAfterSalesStatusEnum::getCode, e -> e));

    public static BusAfterSalesStatusEnum from(Object code) {
        return map.get(code);
    }


    public static class BeanSerializer extends AbstractConverter {
        @SuppressWarnings({"unchecked", "rawtypes"})
        @Override
        protected Object convertToType(Class type, Object value) {
            return value == null ? null : ((BusAfterSalesStatusEnum) value).getCode();
        }

        @Override
        protected Class<?> getDefaultType() {
            return BusAfterSalesStatusEnum.class;
        }
    }

    public static class BeanDeserializer extends AbstractConverter {

        @Override
        protected Object convertToType(Class type, Object value) {
            return BusAfterSalesStatusEnum.from(value);
        }

        @Override
        protected Class<?> getDefaultType() {
            return BusAfterSalesStatusEnum.class;
        }
    }

    public static class DBConverter extends AbstractHasCodeConverter<BusAfterSalesStatusEnum> {

        @Override
        public BusAfterSalesStatusEnum from(Integer code) {
            return BusAfterSalesStatusEnum.from(code);
        }

    }

}
