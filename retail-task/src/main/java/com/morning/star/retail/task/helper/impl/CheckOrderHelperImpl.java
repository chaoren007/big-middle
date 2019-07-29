package com.morning.star.retail.task.helper.impl;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.morning.star.retail.order.enums.PaymentStatus;
import com.morning.star.retail.order.facade.dto.SalesOrderDTO;
import com.morning.star.retail.task.helper.CheckOrderHelper;
import com.morning.star.retail.task.helper.PayServiceHelper;
import com.morning.star.retail.task.helper.dto.PayResultDTO;

@Service
public class CheckOrderHelperImpl implements CheckOrderHelper {
	@Autowired private PayServiceHelper payServiceHelper;
	
	@Override
	public boolean checkCanCancelPay(SalesOrderDTO order) {
    	
		if(order.getPayAmount().compareTo(BigDecimal.ZERO) > 0
    			&& order.getPayStatus() != PaymentStatus.PAY_SUCC.getCode()) {
            PayResultDTO payResult = payServiceHelper.queryResult(order.getOrderCode());
            if(payResult.isPaySucc()) {
            	return false;
            }
        }
		
		if(order.getPayAmount().compareTo(BigDecimal.ZERO) > 0
    	       && order.getPayStatus() == PaymentStatus.PAY_SUCC.getCode()
    			) {
    		return false;
    	}
    	
		return true;
	}

}
