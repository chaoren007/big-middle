package com.morning.star.retail.stock.dao;

import com.github.pagehelper.Page;
import com.morning.star.retail.facade.dto.purchasein.PurchaseInOrderSimpleDTO;
import com.morning.star.retail.facade.dto.purchasein.PurchaseInQueryDTO;
import org.apache.ibatis.session.RowBounds;

public interface PurchaseInOrderDAO {

	Page<PurchaseInOrderSimpleDTO> queryPage(PurchaseInQueryDTO purchaseInQueryDTO, RowBounds rowBounds);

}
