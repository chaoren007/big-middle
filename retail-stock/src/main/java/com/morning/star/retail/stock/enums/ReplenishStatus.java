package com.morning.star.retail.stock.enums;

import com.morning.star.retail.utils.entity.AbstractHasCodeConverter;
import com.morning.star.retail.utils.entity.HasCode;
import org.apache.commons.beanutils.converters.AbstractConverter;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 补货状态（0：待确认，1：已确认，2：驳回）
 *
 * @author jiangyf
 */
public enum ReplenishStatus implements HasCode {
    WAIT_AUDIT(0, "待确认"),
    AUDIT_SUCCESS(1, "已确认"),
    AUDIT_FAIL(2, "驳回");

    private final Integer code;
    private final String desc;

    ReplenishStatus(Integer code, String desc) {
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

    private static Map<Integer, ReplenishStatus> map = Arrays.asList(ReplenishStatus.values())
            .stream().collect(Collectors.toMap(ReplenishStatus::getCode, e -> e));

    public static ReplenishStatus from(Object code) {
        return map.get(code);
    }

    public static class BeanSerializer extends AbstractConverter {
        @SuppressWarnings({"unchecked", "rawtypes"})
        @Override
        protected Object convertToType(Class type, Object value) throws Throwable {
            return value == null ? null : ((ReplenishStatus) value).getCode();
        }

        @Override
        protected Class<?> getDefaultType() {
            return ReplenishStatus.class;
        }
    }

    public static class BeanDeserializer extends AbstractConverter {
        @SuppressWarnings({"unchecked", "rawtypes"})
        @Override
        protected Object convertToType(Class type, Object value) throws Throwable {
            return ReplenishStatus.from(value);
        }

        @Override
        protected Class<?> getDefaultType() {
            return ReplenishStatus.class;
        }
    }

    /**
     * JPA 列绑定枚举类型数据
     */
    public static class ReplenishStatusConverter extends AbstractHasCodeConverter<ReplenishStatus> {

        @Override
        public ReplenishStatus from(Integer code) {
            return ReplenishStatus.from(code);
        }

    }
}
