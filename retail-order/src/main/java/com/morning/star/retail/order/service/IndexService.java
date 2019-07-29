package com.morning.star.retail.order.service;

import com.morning.star.retail.order.facade.order.req.IndexReqParams;
import com.morning.star.retail.order.facade.order.resp.IndexVo;

public interface IndexService {


    IndexVo getUpIndex(IndexReqParams reqParams);
}
