package com.morning.star.retail.stock.dao;

import org.apache.ibatis.session.RowBounds;

import com.github.pagehelper.Page;
import com.morning.star.retail.stock.dto.QueryReceiptDiffDTO;
import com.morning.star.retail.stock.dto.ReceiptDiffInfoDTO;

public interface ReceiptDiffDAO {

    Page<ReceiptDiffInfoDTO> selectAll(QueryReceiptDiffDTO queryReceiptDiffDTO, RowBounds rowBounds);
}
