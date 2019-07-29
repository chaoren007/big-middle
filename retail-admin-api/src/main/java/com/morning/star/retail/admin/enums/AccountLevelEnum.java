package com.morning.star.retail.admin.enums;

import java.util.Arrays;
import java.util.List;

/**
 * @author ethan
 * @create_time 2018/8/17 9:19
 */
public enum AccountLevelEnum {
	GOD("root", "上帝端账号"),
	GROUP_ADMIN("group", "集团超级管理员"),
	GROUP_NORMAL("normal", "集团普通管理员"),
	STORE_ADMIN("store", "管理员"),
	STORE_CLERK("clerk", "普通员工"),
	STORE_SELLER("seller", "促销员"),
	SUPPLIER("supplier", "供应商");

	private final String code;
	private final String desc;

	AccountLevelEnum(String code, String desc) {
		this.code = code;
		this.desc = desc;
	}

	// 门店所属账号等级
	public static final List<String> storeOwnLevel = Arrays.asList(STORE_ADMIN.getCode(), STORE_CLERK.getCode(), STORE_SELLER.getCode());
	// 集团所属账号等级
	public static final List<String> groupOwnLevel = Arrays.asList(GROUP_ADMIN.getCode(), GROUP_NORMAL.getCode());
	// 供应商所属账号等级
	public static final List<String> supplierOwnLevel = Arrays.asList(SUPPLIER.getCode());

	public String getCode() {
		return code;
	}

	public String getDesc() {
		return desc;
	}

	public static AccountLevelEnum getByCode(String code) {
		for (AccountLevelEnum levelEnum : AccountLevelEnum.values()) {
			if (levelEnum.getCode().equals(code)) {
				return levelEnum;
			}
		}
		return null;
	}
}
