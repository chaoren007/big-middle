package com.morning.star.retail.enums;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.beanutils.converters.AbstractConverter;

import com.morning.star.retail.utils.entity.AbstractHasCodeConverter;
import com.morning.star.retail.utils.entity.HasCode;

public enum GoodsSaleStatus implements HasCode {
    ON_SALE(1, "上架状态"),
    OFF_SALE(0, "下架状态");

    private final Integer code;
    private final String desc;

    GoodsSaleStatus(Integer code, String desc) {
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

    private static Map<Integer, GoodsSaleStatus> map = Arrays.asList(GoodsSaleStatus.values())
            .stream().collect(Collectors.toMap(GoodsSaleStatus::getCode, e -> e));
    
    public static GoodsSaleStatus from(Object code) {
        return map.get(code);
    }
    
    public static class BeanSerializer extends AbstractConverter {
        @SuppressWarnings({"unchecked", "rawtypes"})
        @Override
        protected Object convertToType(Class type, Object value) throws Throwable {
            return value == null ? null : ((GoodsSaleStatus) value).getCode();
        }

        @Override
        protected Class<?> getDefaultType() {
            return GoodsSaleStatus.class;
        }
    }

    public static class BeanDeserializer extends AbstractConverter {

        @SuppressWarnings({"unchecked", "rawtypes"})
        @Override
        protected Object convertToType(Class type, Object value) throws Throwable {
            return GoodsSaleStatus.from(value);
        }

        @Override
        protected Class<?> getDefaultType() {
            return GoodsSaleStatus.class;
        }
    }

    public static class DBConverter extends AbstractHasCodeConverter<GoodsSaleStatus> {

        @Override
        public GoodsSaleStatus from(Integer code) {
            return GoodsSaleStatus.from(code);
        }
    }

}
