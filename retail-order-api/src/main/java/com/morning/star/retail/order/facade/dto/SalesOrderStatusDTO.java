package com.morning.star.retail.order.facade.dto;

import java.io.Serializable;

/**
 * SalesOrderStatus DTO.
 * 
 * @author Tim
 *
 */
public class SalesOrderStatusDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private final int code;
    private final String name;
    
    public SalesOrderStatusDTO(int code, String name) {
        this.code = code;
        this.name = name;
    }

    public int getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

}
