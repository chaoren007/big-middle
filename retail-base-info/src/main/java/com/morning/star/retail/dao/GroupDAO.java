package com.morning.star.retail.dao;

import org.apache.ibatis.session.RowBounds;

import com.github.pagehelper.Page;
import com.morning.star.retail.dto.group.GroupInfoDTO;
import com.morning.star.retail.dto.group.GroupQueryDTO;

/**
 * Created by kimhuhg.
 */
public interface GroupDAO {

    String getCode();

    Page<GroupInfoDTO> selectAll(GroupQueryDTO groupQueryDTO, RowBounds rowBounds);

    GroupInfoDTO selectOne(GroupQueryDTO groupQueryDTO);
}
