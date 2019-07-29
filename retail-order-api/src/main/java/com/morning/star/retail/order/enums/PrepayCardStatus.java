package com.morning.star.retail.order.enums;

import com.morning.star.retail.order.facade.dto.SalesOrderStatusDTO;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public enum PrepayCardStatus {
	UNUSE(0,"未使用"),			//已经预占但未使用
	USING(1,"使用中"),			//已预占并使用中
    USED(2, "已使用"),			//已预占并使用成功
    ;
    

    
    private int code;
    private String name;
    
    private PrepayCardStatus(int code, String name) {
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
    private static Map<Integer,PrepayCardStatus> map = new HashMap<>();
    
    
    /**
     * 根据错误编码返回对应的错误枚举
     * @param code
     * @return
     */
    private static PrepayCardStatus getStatusByCode(int code){
        if(map == null || map.isEmpty()) {
            map = new HashMap<>();
            for(PrepayCardStatus status : PrepayCardStatus.values()) {
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
        return Arrays.asList(PrepayCardStatus.values()).stream()
                .map(e -> new SalesOrderStatusDTO(e.getCode(), e.getName()))
                .collect(Collectors.toList());
    }
}
