package com.morning.star.retail.admin.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import com.github.pagehelper.Page;
import com.morning.star.retail.admin.dto.AccountDTO;
import com.morning.star.retail.admin.dto.QueryAccountDTO;

public interface AccountDAO {

    Page<AccountDTO> selectAll(QueryAccountDTO dto, RowBounds rowBounds);

    AccountDTO getOneByAccessIds(@Param("accessIds") String accessIds);

}