package com.morning.star.retail.dao;

import com.github.pagehelper.Page;
import com.morning.star.retail.dto.store.CityDTO;
import com.morning.star.retail.dto.store.StoreDTO;
import com.morning.star.retail.dto.store.StoreQueryDTO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

public interface StoreDAO {

    Page<StoreDTO> selectAll(StoreQueryDTO storeBO, RowBounds rowBounds);

    List<StoreDTO> selectAllList(StoreQueryDTO storeBO);

    String getCode();

    List<CityDTO> selectCity(@Param(value = "groupCode") String groupCode);
}
