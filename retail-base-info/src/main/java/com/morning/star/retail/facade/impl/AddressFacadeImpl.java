package com.morning.star.retail.facade.impl;

import com.morning.star.retail.dto.AddressCodeDTO;
import com.morning.star.retail.dto.AddressDTO;
import com.morning.star.retail.entity.AddressEntity;
import com.morning.star.retail.entity.repository.AddressRespository;
import com.morning.star.retail.facade.AddressFacade;
import com.morning.star.retail.utils.entity.BeanUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class AddressFacadeImpl implements AddressFacade {

	@Autowired
	private AddressRespository addressRespository;

	@Override
	public List<AddressDTO> getAll() {
		List<AddressEntity> addressList1 = addressRespository.findByAddressLevel(1);
		List<AddressEntity> addressList2 = addressRespository.findByAddressLevel(2);
		List<AddressEntity> addressList3 = addressRespository.findByAddressLevel(3);

		Map<Long, List<AddressEntity>> map2 = addressList2.stream().collect(Collectors.groupingBy(AddressEntity::getParentAddressId));
		Map<Long, List<AddressEntity>> map3 = addressList3.stream().collect(Collectors.groupingBy(AddressEntity::getParentAddressId));

		return addressList1.stream().map(item1 -> {
			AddressDTO dto1 = new AddressDTO();
			BeanUtils.copy(item1, dto1);
			dto1.setList(map2.getOrDefault(dto1.getAddressId(), Collections.emptyList()).stream().map(item2 -> {
				AddressDTO dto2 = new AddressDTO();
				BeanUtils.copy(item2, dto2);
				dto2.setList(map3.getOrDefault(item2.getAddressId(), Collections.emptyList()).stream().map(item3 -> {
					AddressDTO dto3 = new AddressDTO();
					BeanUtils.copy(item3, dto3);
					return dto3;
				}).collect(Collectors.toList()));
				return dto2;
			}).collect(Collectors.toList()));
			return dto1;
		}).collect(Collectors.toList());
	}

	@Override
	public List<AddressDTO> getAllProvence() {
		List<AddressEntity> addressList = addressRespository.findByAddressLevel(1);
		List<AddressDTO> result = new ArrayList<>(addressList.size());
		for (AddressEntity entity : addressList) {
			AddressDTO dto = new AddressDTO();
			BeanUtils.copy(entity, dto);
			result.add(dto);
		}
		return result;
	}

	@Override
	public List<AddressDTO> getAllDetail() {
		List<AddressDTO> allProvence = getAllProvence();
		for (AddressDTO addressDTO : allProvence) {
			List<AddressDTO> cityByProvenceIdWithCode = getCityByProvenceId(addressDTO.getAddressId());
			addressDTO.setList(cityByProvenceIdWithCode);
		}

		return allProvence;
	}

	@Override
	public List<AddressDTO> getAllCity() {
		List<AddressEntity> addressList = addressRespository.findByAddressLevel(2);
		List<AddressDTO> result = new ArrayList<>(addressList.size());
		for (AddressEntity entity : addressList) {
			AddressDTO dto = new AddressDTO();
			BeanUtils.copy(entity, dto);
			result.add(dto);
		}
		return result;
	}

	@Override
	public List<AddressDTO> getCityByProvenceId(long provenceId) {
		List<AddressEntity> addressList = addressRespository.findByParentAddressId(provenceId);
		List<AddressDTO> result = new ArrayList<>(addressList.size());
		for (AddressEntity entity : addressList) {
			AddressDTO dto = new AddressDTO();
			BeanUtils.copy(entity, dto);
			result.add(dto);
		}
		return result;
	}

	@Override
	public List<AddressDTO> getCityByProvenceIdWithCode(long provenceId) {
		List<AddressEntity> addressList = addressRespository.findByParentAddressIdAndAddressCodeNotNull(provenceId);
		List<AddressDTO> result = new ArrayList<>(addressList.size());
		for (AddressEntity entity : addressList) {
			AddressDTO dto = new AddressDTO();
			BeanUtils.copy(entity, dto);
			result.add(dto);
		}
		return result;
	}

	@Override
	public List<AddressDTO> getDistrictByCityId(long cityId) {
		List<AddressEntity> addressList = addressRespository.findByParentAddressId(cityId);
		List<AddressDTO> result = new ArrayList<>(addressList.size());
		for (AddressEntity entity : addressList) {
			AddressDTO dto = new AddressDTO();
			BeanUtils.copy(entity, dto);
			result.add(dto);
		}
		return result;
	}

	@Override
	public AddressDTO getAddressById(long addressId) {
		AddressEntity entity = addressRespository.findOne(addressId);
		AddressDTO dto = new AddressDTO();
		BeanUtils.copy(entity, dto);
		return dto;
	}

	@Override
	public List<AddressDTO> getCityByRegion(String code) {
		if (StringUtils.isNotBlank(code)) {
			List<AddressEntity> addressList = addressRespository.findByRegionCode(code);
			return addressList.stream().map(entity -> {
				AddressDTO dto = new AddressDTO();
				BeanUtils.copy(entity, dto);
				return dto;
			}).collect(Collectors.toList());
		} else {
			List<AddressEntity> addressList = addressRespository.findByRegionBind(1);
			Map<String, List<AddressEntity>> addressMap = addressList.stream().collect(Collectors.groupingBy(AddressEntity::getRegionCode));
			List<AddressDTO> result = new ArrayList<>();
			for (Map.Entry<String, List<AddressEntity>> entry : addressMap.entrySet()) {
				AddressDTO addressDTO = new AddressDTO();
				addressDTO.setRegionCode(entry.getValue().get(0).getRegionCode());
				addressDTO.setRegionName(entry.getValue().get(0).getRegionName());
				addressDTO.setList(entry.getValue().stream().map(entity -> {
					AddressDTO dto = new AddressDTO();
					BeanUtils.copy(entity, dto);
					return dto;
				}).collect(Collectors.toList()));
				result.add(addressDTO);
			}
			result.sort(Comparator.comparing((AddressDTO o) -> o.getRegionCode()));
			return result;
		}
	}

	@Override
	public void code(AddressCodeDTO dto) {
		AddressEntity entity = addressRespository.findOne(dto.getAddressId());
		Validate.notNull(entity, String.format("未找到该地址【地址id：%s】相关信息", dto.getAddressId()));

		if (StringUtils.isNotBlank(dto.getAddressCode())) {
			Validate.isTrue(!addressRespository.existsByAddressCode(dto.getAddressCode()),
				"该城市代码已存在");
			entity.setAddressCode(dto.getAddressCode());
		}

		if (StringUtils.isNotBlank(dto.getRegionCode())) {
			entity.setRegionCode(dto.getRegionCode());
			entity.setRegionName(dto.getRegionName());
			entity.setRegionBind(1);
		}

		addressRespository.save(entity);
	}

}
