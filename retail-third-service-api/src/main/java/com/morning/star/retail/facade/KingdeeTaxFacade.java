package com.morning.star.retail.facade;

import com.morning.star.retail.facade.dto.TaxKdDTO;

/**
 * 税率、税种
 * @author kimhuhg
 */
public interface KingdeeTaxFacade {

	/**
	 * 添加税率
	 */
	void addTaxRate(TaxKdDTO dto);

	/**
	 * 添加税种
	 */
	void addTaxCategory(TaxKdDTO dto);

}
