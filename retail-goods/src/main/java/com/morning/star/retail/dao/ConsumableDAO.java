package com.morning.star.retail.dao;

import com.github.pagehelper.Page;
import com.morning.star.retail.facade.dto.ConsumableDTO;
import com.morning.star.retail.facade.dto.ConsumableQueryDTO;
import org.apache.ibatis.session.RowBounds;

public interface ConsumableDAO {

	Page<ConsumableDTO> query(ConsumableQueryDTO consumableQueryDTO, RowBounds rowBounds);

}
