package com.morning.star.retail.stock.bo;

/**
 * 库存预占记录
 * 
 * @author jiangyf
 * @date 2017年9月1日 下午6:14:34
 */
public class StockPreBO {

	/**
	 * 公司编码
	 */
	private String companyCode;

	/**
	 * 门店编码
	 */
	private String storeCode;

	/**
	 * 订单编码
	 */
	private String orderCode;

	/**
	 * 商品编码
	 */
	private String goodsCode;

	/**
	 * 预占状态（0：初始化；1：确认；2：取消；3：结束）
	 */
	private Integer status;

	private StockPreBO() {
	}

	private StockPreBO(String companyCode, String storeCode, String orderCode, String goodsCode,
			Integer status) {
		this.companyCode = companyCode;
		this.storeCode = storeCode;
		this.orderCode = orderCode;
		this.goodsCode = goodsCode;
		this.status = status;
	}

	public static StockPreBO of(String orderCode, String goodsCode) {
		return new StockPreBO(null, null, orderCode, goodsCode, null);
	}

	public String getCompanyCode() {
		return companyCode;
	}

	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}

	public String getStoreCode() {
		return storeCode;
	}

	public void setStoreCode(String storeCode) {
		this.storeCode = storeCode;
	}

	public String getOrderCode() {
		return orderCode;
	}

	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}

	public String getGoodsCode() {
		return goodsCode;
	}

	public void setGoodsCode(String goodsCode) {
		this.goodsCode = goodsCode;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

}
