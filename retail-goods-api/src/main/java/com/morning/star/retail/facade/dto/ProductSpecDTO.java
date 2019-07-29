package com.morning.star.retail.facade.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by liangguobin on 2017/5/9.
 */
@ApiModel
@Data
public class ProductSpecDTO implements Serializable {
	private static final long serialVersionUID = 5851005014593494406L;


	@ApiModelProperty(value = "规格编码")
	private String spuCode;

	@ApiModelProperty(value = "货品编码")
	private String productCode;

	@ApiModelProperty(value = "规格名称")
	private String specKey;

	@ApiModelProperty(value = "规格值")
	private String specValue;

	@ApiModelProperty(value = "规格值集合")
	private Set<String> specValueSet;

	@ApiModelProperty(value = "权重")
	private Integer priority;

	public ProductSpecDTO() {
	}

	public ProductSpecDTO(String spuCode, String productCode, String specKey, String specValue) {
		this.spuCode = spuCode;
		this.productCode = productCode;
		this.specKey = specKey;
		this.specValue = specValue;
	}

	public static ProductSpecDTO instance(String specKey, String specValue) {
		return new ProductSpecDTO(null, null, specKey, specValue);
	}

	/**
	 * 把多规格信息转化成字符串
	 */
	public static String formStr(List<ProductSpecDTO> list) {
		return list.stream()
			.filter(spec -> spec.getSpecValue() != null && spec.getSpecValue().length() > 0 &&
				spec.getSpecKey() != null && spec.getSpecKey().length() > 0)
			.map(spec -> spec.getSpecKey() + ":" + spec.getSpecValue())
			.collect(Collectors.joining(";"));
	}

	/**
	 * 把指定规格的字符串转化成多规格信息
	 * @param spuInfoStr    key1:value1;key2:value2;key3:value3
	 */
	public static List<ProductSpecDTO> builderList(String spuInfoStr) {
		return Arrays.stream(spuInfoStr.split(";")).map(spu -> {
			String[] split = spu.split(":");
			ProductSpecDTO productSpecDTO = new ProductSpecDTO();
			productSpecDTO.setSpecKey(split[0]);
			productSpecDTO.setSpecValue(split[1]);
			return productSpecDTO;
		}).collect(Collectors.toList());
	}

	public static List<ProductSpecDTO> builderList(List<ProductSpecDTO> list) {
		List<ProductSpecDTO> result = new ArrayList<>();
		list.stream().collect(Collectors.groupingBy(ProductSpecDTO::getSpecKey)).forEach((specKey, specList) -> {
			ProductSpecDTO productSpecDTO = new ProductSpecDTO();
			Set<String> specValueSet = specList.stream().map(ProductSpecDTO::getSpecValue).collect(Collectors.toSet());
			productSpecDTO.setSpecKey(specKey);
			productSpecDTO.setSpecValueSet(specValueSet);
			result.add(productSpecDTO);
		});

		return result;
	}

}
