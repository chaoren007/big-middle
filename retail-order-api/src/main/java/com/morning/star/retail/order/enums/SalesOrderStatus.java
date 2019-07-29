package com.morning.star.retail.order.enums;

import com.morning.star.retail.order.facade.dto.SalesOrderStatusDTO;

import javax.persistence.AttributeConverter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public enum SalesOrderStatus {
    
	WAIT_PAY(100, "待支付"),
	PAYED(110, "已支付"),
	WAIT_CONFIRM(115, "待确认"),

    PENDING_DELIVERY(120, "待配送"),

    DELIVERED(130, "配送中"),
    RECEIVED(140, "已收货"),
    DONE(150, "已完成"),
    CLOSE(170, "交易关闭");

    
    private int code;
    private String name;
    
    SalesOrderStatus(int code, String name) {
        this.code = code;
        this.name = name;
    }

    public int getCode() {
        return code;
    }

    public String getName() {
        return name;
    }
    
    /**
     * 错误编码以及对应的错误枚举对应关系
     */
    private static Map<Integer,SalesOrderStatus> map = new HashMap<>();
    
    
    /**
     * 根据错误编码返回对应的错误枚举
     * @param code
     * @return
     */
    public static SalesOrderStatus getStatusByCode(int code){
        if(map == null || map.isEmpty()) {
            map = new HashMap<>();
            for(SalesOrderStatus status : SalesOrderStatus.values()) {
                map.put(status.getCode(), status);
            }
        }
        return map.get(code);
    }
    
    /**
     * 根据错误编码返回对应的错误信息
     * @param code
     * @return
     */
    public static String getName(int code){
        return getStatusByCode(code).getName();
    }
    
   
    public static List<SalesOrderStatusDTO> toList() {
        return Arrays.asList(SalesOrderStatus.values()).stream()
                .map(e -> new SalesOrderStatusDTO(e.getCode(), e.getName()))
                .collect(Collectors.toList());
    }

    public static class Convert implements AttributeConverter<SalesOrderStatus, Integer> {
        @Override
        public Integer convertToDatabaseColumn(SalesOrderStatus attribute) {
            return attribute == null ? null : attribute.getCode();
        }

        @Override
        public SalesOrderStatus convertToEntityAttribute(Integer dbData) {
            for (SalesOrderStatus type : SalesOrderStatus.values()) {
                if (dbData.equals(type.getCode())) {
                    return type;
                }
            }
            throw new RuntimeException("Unknown database value: " + dbData);
        }
    }
}
