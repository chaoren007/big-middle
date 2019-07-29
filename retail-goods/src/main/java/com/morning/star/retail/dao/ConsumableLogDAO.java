package com.morning.star.retail.dao;

import com.github.pagehelper.Page;
import com.morning.star.retail.facade.dto.ConsumableDTO;
import com.morning.star.retail.facade.dto.ConsumableQueryDTO;
import com.morning.star.retail.facade.dto.ConsumableWaterDTO;
import com.morning.star.retail.facade.dto.ConsumableWaterQueryDTO;
import org.apache.ibatis.session.RowBounds;

public interface ConsumableLogDAO {

	Page<ConsumableWaterDTO> query(ConsumableWaterQueryDTO consumableWaterQueryDTO, RowBounds rowBounds);

}
