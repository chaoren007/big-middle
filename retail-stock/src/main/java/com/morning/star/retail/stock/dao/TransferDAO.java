package com.morning.star.retail.stock.dao;

import org.apache.ibatis.session.RowBounds;

import com.github.pagehelper.Page;
import com.morning.star.retail.stock.dto.TransferDTO;
import com.morning.star.retail.stock.dto.TransferItemDTO;
import com.morning.star.retail.stock.dto.TransferQueryDTO;

/**
 * 库存调拨单
 *
 * @author jiangyf
 * @date 2018/3/13
 */
public interface TransferDAO {

    Page<TransferDTO> selectByPage(TransferQueryDTO queryDTO, RowBounds build);

    Page<TransferItemDTO> selectItemByPage(TransferQueryDTO queryDTO, RowBounds build);
}
