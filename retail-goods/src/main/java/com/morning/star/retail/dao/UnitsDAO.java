package com.morning.star.retail.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

import com.github.pagehelper.Page;
import com.morning.star.retail.facade.dto.UnitsDTO;
import com.morning.star.retail.facade.dto.UnitsQueryDTO;

public interface UnitsDAO {
	Page<UnitsDTO> queryPage(UnitsQueryDTO dto, RowBounds rowBounds);

	List<UnitsDTO> queryList();
}
