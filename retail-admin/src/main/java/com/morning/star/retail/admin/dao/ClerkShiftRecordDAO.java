package com.morning.star.retail.admin.dao;

import org.apache.ibatis.session.RowBounds;

import com.github.pagehelper.Page;
import com.morning.star.retail.admin.bean.ClerkShiftDO;
import com.morning.star.retail.admin.bo.ClerkShiftBO;
import com.morning.star.retail.admin.vo.ClerkShiftVO;

/**
 * Created by lenovo on 2017/7/20.
 */
public interface ClerkShiftRecordDAO {

    int insert(ClerkShiftDO clerkShiftDO);

    Page<ClerkShiftVO> query(ClerkShiftBO clerkShiftBO,RowBounds build);
}
