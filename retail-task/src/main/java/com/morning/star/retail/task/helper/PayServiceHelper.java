package com.morning.star.retail.task.helper;

import com.morning.star.retail.task.helper.dto.PayResultDTO;

public interface PayServiceHelper {
    
    PayResultDTO queryResult(String orderCode);
    
}
