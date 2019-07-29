package com.morning.star.retail.helper;

import com.morning.star.retail.dto.AddressDTO;
import com.morning.star.retail.facade.AddressFacade;
import com.morning.star.retail.helper.vo.AddressInfo;
import com.morning.star.retail.utils.entity.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ethan
 * @create_time 2018/7/26 10:52
 */
@Service
public class AddressService {
	@Autowired
	private AddressFacade addressFacade;

	public AddressInfo getById(Long id) {
		AddressDTO address = addressFacade.getAddressById(id);
		if (address == null) {
			return null;
		}
		AddressInfo info = new AddressInfo();
		BeanUtils.copy(address, info);
		return info;
	}
}
