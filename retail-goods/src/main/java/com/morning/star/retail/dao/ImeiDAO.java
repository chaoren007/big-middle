package com.morning.star.retail.dao;

import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;

import com.github.pagehelper.Page;
import com.morning.star.retail.facade.dto.ImeiAddDTO;
import com.morning.star.retail.facade.dto.ImeiQueryDTO;

@Repository
public interface ImeiDAO {

	Page<ImeiAddDTO> queryPage(ImeiQueryDTO dto, RowBounds bounds);

}
