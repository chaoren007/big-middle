package com.morning.star.retail.order.enums;

import com.morning.star.retail.utils.entity.AbstractHasCodeConverter;
import com.morning.star.retail.utils.entity.HasCode;
import org.apache.commons.beanutils.converters.AbstractConverter;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public enum BusAfterSalesTypeEnum implements HasCode {
    ITEMANDMONEY(1, "退货退款"),
    CHANGEITEM(2, "换货"),
    ADDITEM(3, "补货"),
    ONLYMONEY(4, "仅退款"),
    ;
    private final Integer code;
    private final String desc;

    BusAfterSalesTypeEnum(Integer code, String desc) {
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

    private static Map<Integer, BusAfterSalesTypeEnum> map = Arrays.asList(BusAfterSalesTypeEnum.values())
            .stream().collect(Collectors.toMap(BusAfterSalesTypeEnum::getCode, e -> e));

    public static BusAfterSalesTypeEnum from(Object code) {
        return map.get(code);
    }


    public static class BeanSerializer extends AbstractConverter {
        @SuppressWarnings({"unchecked", "rawtypes"})
        @Override
        protected Object convertToType(Class type, Object value) {
            return value == null ? null : ((BusAfterSalesTypeEnum) value).getCode();
        }

        @Override
        protected Class<?> getDefaultType() {
            return BusAfterSalesTypeEnum.class;
        }
    }

    public static class BeanDeserializer extends AbstractConverter {

        @Override
        protected Object convertToType(Class type, Object value) {
            return BusAfterSalesTypeEnum.from(value);
        }

        @Override
        protected Class<?> getDefaultType() {
            return BusAfterSalesTypeEnum.class;
        }
    }

    public static class DBConverter extends AbstractHasCodeConverter<BusAfterSalesTypeEnum> {

        @Override
        public BusAfterSalesTypeEnum from(Integer code) {
            return BusAfterSalesTypeEnum.from(code);
        }

    }

}
