package com.morning.star.retail.order.service;

import com.morning.star.retail.order.facade.order.req.ApplyRefundReqParams;

public interface ApplyRefundService {

    String refundAmount(ApplyRefundReqParams applyRefundReqParams);
}
