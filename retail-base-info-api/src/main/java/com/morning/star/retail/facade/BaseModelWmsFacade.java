package com.morning.star.retail.facade;

public interface BaseModelWmsFacade {
	/**
	 * 推送供应商信息到第三方
	 */
	void pushSupplier(String code);

	/**
	 * 推送仓库信息到第三方
	 */
	void pushWarehouse(String code);

	/**
	 * 推送门店信息到第三方
	 */
	void pushStore(String code);

}
