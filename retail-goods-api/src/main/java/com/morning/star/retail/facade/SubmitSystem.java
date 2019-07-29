package com.morning.star.retail.facade;

/**
 * @author ethan
 * @create_time 2019/4/4 10:01
 */
public enum SubmitSystem {
	DEFAULT("DEFAULT_SYSTEM"),
	GROUP("GROUP_SYSTEM"),
	STORE("STORE_SYSTEM"),
	SUPPLIER("SUPPLIER_SYSTEM"),
	BUS("BUS_SYSTEM"),;

	private String source;

	SubmitSystem(String source) {
		this.source = source;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}
}
