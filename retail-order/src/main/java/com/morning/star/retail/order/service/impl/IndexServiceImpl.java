package com.morning.star.retail.order.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.morning.star.retail.async.AsyncSetter;
import com.morning.star.retail.async.AsyncSetterFactory;
import com.morning.star.retail.order.facade.order.req.IndexReqParams;
import com.morning.star.retail.order.facade.order.resp.IndexVo;
import com.morning.star.retail.order.facade.order.resp.Model1Vo;
import com.morning.star.retail.order.service.IndexService;
import com.morning.star.retail.repository.OrderRepository;

@Service
public class IndexServiceImpl implements IndexService {

    @Autowired
    private OrderRepository orderRepository;


    @Autowired
    private AsyncSetterFactory asyncSetterFactory;


    @Override
    public IndexVo getUpIndex(IndexReqParams reqParams) {

        AsyncSetter<IndexVo> asyncSetter = asyncSetterFactory.getAsyncSetter();
        asyncSetter.setOriginal(new IndexVo())
                .addRunnable(vo -> buildModel1(vo, reqParams))
                .addRunnable(vo -> buildModel2(vo, reqParams))
                .addRunnable(vo -> buildModel3(vo, reqParams))
                .execute();
        return asyncSetter.getOriginal();
    }

    private void buildModel3(IndexVo vo, IndexReqParams reqParams) {

    }

    private void buildModel2(IndexVo vo, IndexReqParams reqParams) {

    }

    private void buildModel1(IndexVo vo, IndexReqParams reqParams) {
        Model1Vo vo1 = new Model1Vo();

    }



}
