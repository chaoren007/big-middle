package com.morning.star.retail.dao;

import com.github.pagehelper.Page;
import com.morning.star.retail.facade.dto.ThirdServiceFailDTO;
import com.morning.star.retail.facade.dto.ThirdServiceQueryDTO;
import org.apache.ibatis.session.RowBounds;

public interface ThirdServiceFailDAO {

	Page<ThirdServiceFailDTO> queryByPage(ThirdServiceQueryDTO queryDTO, RowBounds rowBounds);

}
