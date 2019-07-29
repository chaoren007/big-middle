package com.morning.star.retail.admin.order.vo;

import java.io.Serializable;

public class CancelVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8411634295076713132L;
	
	
	private String reason;


    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
	
	

}
