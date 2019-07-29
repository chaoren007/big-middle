package com.morning.star.retail.order.helper.impl;

import org.apache.commons.lang.Validate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.morning.star.retail.dto.group.GroupInfoDTO;
import com.morning.star.retail.facade.GroupFacade;
import com.morning.star.retail.order.helper.CompanyServiceHelper;
import com.morning.star.retail.order.logicservice.impl.OrderPayLogicServiceImpl;

@Service
public class CompanyServiceHelperImpl implements CompanyServiceHelper {
    private static final Logger logger = LoggerFactory.getLogger(OrderPayLogicServiceImpl.class);
    @Autowired
    private GroupFacade groupFacade;

    @Override
    public String getPayMerchantCode(String groupCode) {
        GroupInfoDTO byCode = groupFacade.getByCode(groupCode);
        Validate.notNull(byCode,"该商户不存在!");
        Validate.notNull(byCode.getMerchantCode(),"该商户号不存在!");
        return byCode.getMerchantCode();
    }
}
