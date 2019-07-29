package com.morning.star.retail.order.facade;

import org.springframework.stereotype.Service;

import com.morning.star.retail.base.page.PageBeans;
import com.morning.star.retail.order.facade.dto.ClerkShiftBO;
import com.morning.star.retail.order.facade.dto.ClerkShiftDO;
import com.morning.star.retail.order.facade.dto.ClerkShiftDetailDO;
import com.morning.star.retail.order.facade.dto.ClerkShiftInfoVO;
import com.morning.star.retail.order.facade.dto.ClerkShiftVO;

/**
 * Created by lenovo on 2017/12/27.
 */
@Service
public interface ClerkShiftServiceFacade {
    int addShiftRecord(ClerkShiftDO clerkShiftDO);

    PageBeans<ClerkShiftVO> listShiftRecord(ClerkShiftBO clerkShiftBO);

    ClerkShiftInfoVO getShiftRecord(Integer shiftRecordId);

    /**
     * 交班对账数据
     * @param clerkShiftBO
     * @return
     */
    ClerkShiftInfoVO generateShiftData(ClerkShiftBO clerkShiftBO);

    int addShiftDetail(ClerkShiftDetailDO clerkShiftDetailDO);

}
