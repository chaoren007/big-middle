package com.morning.star.retail.pay.dao;

import com.morning.star.retail.pay.entity.AlipayKeyEntity;

public interface AlipayPayDao {
	public AlipayKeyEntity getAlipayKey(int ownerId);
}
