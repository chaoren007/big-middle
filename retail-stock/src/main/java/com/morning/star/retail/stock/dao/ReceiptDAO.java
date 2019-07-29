package com.morning.star.retail.stock.dao;

import org.apache.ibatis.session.RowBounds;

import com.github.pagehelper.Page;
import com.morning.star.retail.stock.dto.ExpiredGoodsDTO;
import com.morning.star.retail.stock.dto.ExpiredGoodsQueryDTO;
import com.morning.star.retail.stock.dto.QueryByRoleDTO;
import com.morning.star.retail.stock.dto.ReceiptByCodeQueryDTO;
import com.morning.star.retail.stock.dto.ReceiptDTO;
import com.morning.star.retail.stock.dto.ReceiptQueryDTO;

public interface ReceiptDAO {

    Page<ReceiptDTO> selectAll(ReceiptQueryDTO receiptQueryDTO, RowBounds rowBounds);

    ReceiptDTO selectOne(ReceiptByCodeQueryDTO receiptByCodeQueryDTO);

    Page<ExpiredGoodsDTO> selectExpiredGoods(ExpiredGoodsQueryDTO queryDTO, RowBounds rowBounds);

    Page<ReceiptDTO> list(QueryByRoleDTO queryReceiptDTO, RowBounds rowBounds);

}
