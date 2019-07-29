package com.morning.star.retail.order.enums;

import com.morning.star.retail.order.facade.dto.SalesOrderStatusDTO;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public enum SalesOrderClosedType {
    
	CANCEL_CLOSE(100, "取消关闭"),
	REJECT_CLOSE(110, "拒收关闭");
    
    private int code;
    private String name;
    
    private SalesOrderClosedType(int code, String name) {
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
    private static Map<Integer,SalesOrderClosedType> map = new HashMap<>();
    
    
    /**
     * 根据错误编码返回对应的错误枚举
     * @param code
     * @return
     */
    private static SalesOrderClosedType getStatusByCode(int code){
        if(map == null || map.isEmpty()) {
            map = new HashMap<>();
            for(SalesOrderClosedType status : SalesOrderClosedType.values()) {
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
        return Arrays.asList(SalesOrderClosedType.values()).stream()
                .map(e -> new SalesOrderStatusDTO(e.getCode(), e.getName()))
                .collect(Collectors.toList());
    }
}
