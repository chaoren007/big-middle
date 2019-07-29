package com.morning.star.retail.admin.order.vo;

import java.io.Serializable;

public class RefuseOrderVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7931151321862510889L;

	private String reason;

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
	
	
}
