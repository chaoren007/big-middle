package com.morning.star.retail.admin.remoteservice;

import com.morning.star.retail.admin.bean.ClerkShiftDO;
import com.morning.star.retail.admin.bo.ClerkShiftBO;
import com.morning.star.retail.admin.vo.ClerkShiftVO;
import com.morning.star.retail.utils.page.PageBean;

/**
 * Created by lenovo on 2017/7/20.
 */
public interface ClerkShiftRemoteService {

    int addShiftRecord(ClerkShiftDO clerkShiftDO);

    PageBean<ClerkShiftVO> listShiftRecord(ClerkShiftBO clerkShiftBO);
}
