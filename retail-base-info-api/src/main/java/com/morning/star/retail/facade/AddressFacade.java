package com.morning.star.retail.facade;

import com.morning.star.retail.dto.AddressCodeDTO;
import com.morning.star.retail.dto.AddressDTO;

import java.util.List;

public interface AddressFacade {

	/**
	 * 获取所有地址信息
	 *
	 * @return
	 */
	List<AddressDTO> getAll();

	/**
	 * 获取所有省份
	 *
	 * @return
	 */
	List<AddressDTO> getAllProvence();

	/**
	 * 获取所有省份+详情
	 *
	 * @return
	 */
	List<AddressDTO> getAllDetail();

	/**
	 * 获取所有城市
	 *
	 * @return
	 */
	List<AddressDTO> getAllCity();

	/**
	 * 获取省份下的所有市
	 *
	 * @return
	 */
	List<AddressDTO> getCityByProvenceId(long provenceId);

	/**
	 * 获取省份下的所有市
	 *
	 * @return
	 */
	List<AddressDTO> getCityByProvenceIdWithCode(long provenceId);

	/**
	 * 获取城市下的区/县
	 *
	 * @return
	 */
	List<AddressDTO> getDistrictByCityId(long cityId);

	/**
	 * 根据ID获取地址信息
	 *
	 * @param addressId
	 * @return
	 */
	AddressDTO getAddressById(long addressId);


	List<AddressDTO> getCityByRegion(String code);

	/**
	 * 更新地址编码
	 *
	 * @param dto
	 */
	void code(AddressCodeDTO dto);
}
