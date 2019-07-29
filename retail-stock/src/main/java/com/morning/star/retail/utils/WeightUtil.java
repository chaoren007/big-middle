package com.morning.star.retail.utils;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author ethan
 * @create_time 2018/8/15 20:30
 */
public class WeightUtil {
	public static Map<String, Integer> WEIGHT_CONSTANT = new HashMap<>();
	static {
		WEIGHT_CONSTANT.put("克", 1);
		WEIGHT_CONSTANT.put("千克", 1000);
		WEIGHT_CONSTANT.put("吨", 1000 * 1000);
		WEIGHT_CONSTANT.put("两", 50);
		WEIGHT_CONSTANT.put("斤", 50 * 10);
		WEIGHT_CONSTANT.put("公斤", 1000);
	}

	public static Set<String> getWeightList() {
		return WEIGHT_CONSTANT.keySet();
	}

	/**
	 * 转化单位为克
	 * @param num   数量
	 * @param units 单位
	 * @return
	 */
	public static BigDecimal get(BigDecimal num, String units) {
		Integer weightNum = WEIGHT_CONSTANT.getOrDefault(units, null);
		if(weightNum == null) {
			throw new IllegalArgumentException("单位不存在：" + units);
		}
		return num.multiply(new BigDecimal(weightNum));
	}


	public static BigDecimal get(BigDecimal num, String units, String targetUnits) {
		Integer weightNum = WEIGHT_CONSTANT.getOrDefault(units, null);
		Integer targetWeightNum = WEIGHT_CONSTANT.getOrDefault(targetUnits, null);
		if(weightNum == null) {
			throw new IllegalArgumentException("原始单位不存在：" + units);
		}
		if(targetWeightNum == null) {
			throw new IllegalArgumentException("目标单位不存在：" + targetUnits);
		}
		return num.multiply(new BigDecimal(weightNum)).divide(new BigDecimal(targetWeightNum));
	}

	public static void main(String[] args) {
		System.out.println(get(new BigDecimal("58.9"), "公斤"));
		System.out.println(get(new BigDecimal("58.9"), "公斤", "两"));
	}
}
