package com.morning.star.retail.order.enums;

import com.morning.star.retail.order.facade.dto.SalesOrderStatusDTO;

import javax.persistence.AttributeConverter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public enum SalesOrderType {
    ONLINE_ORDER(0, "线上订单"),
    OFFLINE_ORDER(1, "线下订单"),
	;

    
    private Integer code;
    private String name;
    
    SalesOrderType(int code, String name) {
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
    private static Map<Integer,SalesOrderType> map = new HashMap<>();
    
    
    /**
     * 根据错误编码返回对应的错误枚举
     * @param code
     * @return
     */
    public static SalesOrderType getStatusByCode(int code){
        if(map == null || map.isEmpty()) {
            map = new HashMap<>();
            for(SalesOrderType status : SalesOrderType.values()) {
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
        SalesOrderType type = getStatusByCode(code);
        return type == null ? "" : type.getName();
    }
    
   
    public static List<SalesOrderStatusDTO> toList() {
        return Arrays.asList(SalesOrderType.values()).stream()
                .map(e -> new SalesOrderStatusDTO(e.getCode(), e.getName()))
                .collect(Collectors.toList());
    }

    public static class Convert implements AttributeConverter<SalesOrderType, Integer> {
        @Override
        public Integer convertToDatabaseColumn(SalesOrderType attribute) {
            return attribute == null ? null : attribute.getCode();
        }

        @Override
        public SalesOrderType convertToEntityAttribute(Integer dbData) {
            for (SalesOrderType type : SalesOrderType.values()) {
                if (dbData.equals(type.getCode())) {
                    return type;
                }
            }
            throw new RuntimeException("Unknown database value: " + dbData);
        }
    }
}
