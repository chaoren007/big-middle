package com.morning.star.retail.order.facade.dto;

import java.io.Serializable;

/**
 * PayChannel DTO.
 * 
 * @author Tim
 *
 */
public class PayChannelDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private final int code;
    private final String name;
    
    public PayChannelDTO(int code, String name) {
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
