package com.morning.star.retail.admin.service.impl;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.morning.star.retail.admin.bean.ClerkShiftDO;
import com.morning.star.retail.admin.bo.ClerkShiftBO;
import com.morning.star.retail.admin.dao.ClerkShiftRecordDAO;
import com.morning.star.retail.admin.service.ClerkShiftRecordService;
import com.morning.star.retail.admin.vo.ClerkShiftVO;

/**
 * Created by lenovo on 2017/7/20.
 */
@Service
public class ClerkShiftRecordServiceImpl implements ClerkShiftRecordService {

    @Autowired
    private ClerkShiftRecordDAO clerkShiftRecordDAO;

    @Override
    public int addShiftRecord(ClerkShiftDO clerkShiftDO) {
        return this.clerkShiftRecordDAO.insert(clerkShiftDO);
    }

    @Override
    public Page<ClerkShiftVO> pageShiftRecord(ClerkShiftBO clerkShiftBO,RowBounds build ) {
        return clerkShiftRecordDAO.query(clerkShiftBO,build);
    }
}
