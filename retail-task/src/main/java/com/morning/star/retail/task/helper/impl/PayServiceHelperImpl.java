package com.morning.star.retail.task.helper.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.morning.star.external.pay.service.QueryPaymentService;
import com.morning.star.retail.task.helper.PayServiceHelper;
import com.morning.star.retail.task.helper.dto.PayResultDTO;
import com.pugwoo.soa.client.SOAClient;

@Service
public class PayServiceHelperImpl implements PayServiceHelper {
    
    private static Logger logger = LoggerFactory.getLogger(PayServiceHelperImpl.class);
    
    @Override
    public PayResultDTO queryResult(String orderCode) {
        QueryPaymentService paymentSerivce = SOAClient.getService(QueryPaymentService.class, "apiQueryPaymentServiceImpl");
        Map<String, String> payResult = paymentSerivce.queryPaymentSuc(orderCode);
        return toDTO(payResult);
    }
    
    private PayResultDTO toDTO(Map<String, String> payResult) {
        PayResultDTO dto = new PayResultDTO();
        try {
            BeanUtils.populate(dto, payResult);
        } catch (IllegalAccessException | InvocationTargetException e) {
            logger.error("parse pay result", e);
        }
        return dto;
    }
    
}
