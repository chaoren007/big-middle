package com.morning.star.retail.admin.service;

import org.apache.ibatis.session.RowBounds;

import com.github.pagehelper.Page;
import com.morning.star.retail.admin.bean.ClerkShiftDO;
import com.morning.star.retail.admin.bo.ClerkShiftBO;
import com.morning.star.retail.admin.vo.ClerkShiftVO;

/**
 * Created by lenovo on 2017/7/20.
 */
public interface ClerkShiftRecordService {

    int addShiftRecord(ClerkShiftDO clerkShiftDO);

    Page<ClerkShiftVO> pageShiftRecord(ClerkShiftBO clerkShiftBO,RowBounds build );
}
