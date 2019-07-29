package com.morning.star.retail.stock.bo;

/**
 * 操作人
 * 
 * @author Tim
 *
 */
public class OperatorBO {

	private String id;
	private String name;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public static OperatorBO of(String id, String name) {
		OperatorBO operatorBO = new OperatorBO();
		operatorBO.setId(id);
		operatorBO.setName(name);
		return operatorBO;
	}

}
