package com.morning.star.retail.pay.dao;

import com.morning.star.retail.pay.entity.WxPayKeyEntity;

public interface WxPayDao {
	WxPayKeyEntity getWxPayKey(int ownerId);
}
