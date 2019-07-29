package com.morning.star.retail.facade.assembler;


import com.morning.star.retail.entity.GoodsSupplyEntity;
import com.morning.star.retail.entity.GoodsSupplySetEntity;
import com.morning.star.retail.facade.dto.ProductSpecDTO;
import com.morning.star.retail.facade.dto.supply.GoodsSupplyDTO;
import com.morning.star.retail.facade.dto.supply.GoodsSupplySetDTO;
import com.morning.star.retail.facade.dto.supply.GoodsSupplySpuDTO;
import com.morning.star.retail.utils.entity.BeanUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class GoodsSupplyAssembler {

	public static GoodsSupplyDTO builderDTO(List<GoodsSupplyEntity> entityList, boolean areaGroup) {
		if (entityList == null || entityList.size() <= 0) {
			return null;
		}
		GoodsSupplyDTO resultDTO = new GoodsSupplyDTO();
		List<GoodsSupplySpuDTO> spuDetailList = new ArrayList<>(entityList.size());
		// 是否是单品
		Boolean isSingle = "SP".equals(entityList.get(0).getProductType());
		for (GoodsSupplyEntity entity : entityList) {
			// 设置主规格信息
			if (entity.getMainSpu().equals(1)) {
				BeanUtils.copy(entity, resultDTO);
			}

			// 是单品或者是多规格非主规格的设置详情信息
			if (isSingle || !entity.getMainSpu().equals(1)) {
				// 设置各个规格的商品信息
				GoodsSupplySpuDTO spuDetail = new GoodsSupplySpuDTO();
				BeanUtils.copy(entity, spuDetail);

				if (StringUtils.isNotBlank(entity.getSpuInfo())) {
					spuDetail.setProductSpecInfo(ProductSpecDTO.builderList(entity.getSpuInfo()));
				} else {
					spuDetail.setProductSpecInfo(Collections.emptyList());
				}

				// 设置单规格的供货区域信息
				if (areaGroup) {
					spuDetail.setAreaDetail(entity.getAreaDetail().stream()
						.collect(Collectors.groupingBy(areaItem -> areaItem.getSubmitGroup().toString() + "##" + areaItem.getPrice()))
						.entrySet().stream().map(entry -> {
							GoodsSupplySetDTO areaDTO = new GoodsSupplySetDTO();
							BeanUtils.copy(entry.getValue().get(0), areaDTO);

							List<String> cityIdList = entry.getValue().stream()
								.map(cityItem -> String.valueOf(cityItem.getCityId()))
								.collect(Collectors.toList());
							List<String> cityNameList = entry.getValue().stream()
								.map(GoodsSupplySetEntity::getCityName)
								.collect(Collectors.toList());
							String cityIds = String.join(",", cityIdList);
							String cityNames = String.join(",", cityNameList);
							areaDTO.setCityId(cityIds);
							areaDTO.setCityIds(cityIdList);
							areaDTO.setCityName(cityNames);
							areaDTO.setCityNames(cityNameList);
							return areaDTO;
						}).collect(Collectors.toList())
					);
				} else {
					spuDetail.setAreaDetail(entity.getAreaDetail().stream().map(area -> {
						GoodsSupplySetDTO areaDTO = new GoodsSupplySetDTO();
						BeanUtils.copy(area, areaDTO);
						return areaDTO;
					}).collect(Collectors.toList()));
				}
				spuDetailList.add(spuDetail);
			}
		}
		if (StringUtils.isNotBlank(entityList.get(0).getCategorySpuInfo())) {
			resultDTO.setCategorySpuInfoList(ProductSpecDTO.builderList(entityList.get(0).getCategorySpuInfo()));
		}
		resultDTO.setSpuDetailList(spuDetailList);
		resultDTO.setProductSpecInfo(ProductSpecDTO.builderList(spuDetailList.stream()
			.flatMap(spec -> spec.getProductSpecInfo().stream())
			.collect(Collectors.toList())));
		return resultDTO;
	}

}
