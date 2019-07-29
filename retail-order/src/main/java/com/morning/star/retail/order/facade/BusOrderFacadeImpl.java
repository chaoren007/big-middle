package com.morning.star.retail.order.facade;

import com.morning.star.retail.order.domain.entity.BusOrderDetailEntity;
import com.morning.star.retail.order.domain.entity.BusOrderEntity;
import com.morning.star.retail.order.domain.entity.repository.BusOrderDetailRepository;
import com.morning.star.retail.order.domain.entity.repository.BusOrderRepository;
import com.morning.star.retail.order.enums.DealWithEnum;
import com.morning.star.retail.order.facade.dto.BusOrderDTO;
import com.morning.star.retail.utils.entity.BeanUtils;
import org.apache.commons.lang.Validate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BusOrderFacadeImpl implements BusOrderFacade {

    @Autowired
    private BusOrderRepository busOrderRepository;
    @Autowired
    private BusOrderDetailRepository busOrderDetailRepository;
    private static  Logger log = LoggerFactory.getLogger(BusOrderFacadeImpl.class);
    @Override
    public void add(BusOrderDTO dto) {
        BusOrderEntity orderNo = busOrderRepository.getByOrderNo(dto.getOrderNo());
        Validate.isTrue(orderNo==null,"订单号已经存在!");
            BusOrderEntity entity = new BusOrderEntity();
            BeanUtils.copy(dto,entity);
            busOrderRepository.save(entity);
        List<BusOrderDTO.Detail> detailList = dto.getDetailList();
        if(detailList!=null && !detailList.isEmpty()) {
            for (BusOrderDTO.Detail detail : detailList) {
                BusOrderDetailEntity detailEntity = new BusOrderDetailEntity();
                BeanUtils.copy(detail, detailEntity);
                busOrderDetailRepository.save(detailEntity);
            }
        }
    }

    @Override
    public BusOrderDTO getByDealWith() {
        BusOrderDTO dto = new BusOrderDTO();
        List<BusOrderDTO.Detail> list = new ArrayList();
        List<BusOrderDetailEntity> byDealWith = busOrderDetailRepository.getByDealWith(DealWithEnum.NO.getCode());
        for (BusOrderDetailEntity entity : byDealWith) {
            BusOrderDTO.Detail detail  = new BusOrderDTO.Detail();
            BeanUtils.copy(entity, detail);
            list.add(detail);
        }
        dto.setDetailList(list);
        return dto;
    }

    @Override
    public void updateStatus(List<Long> ids) {
        for (Long id : ids) {
            BusOrderDetailEntity byId = busOrderDetailRepository.getById(id);
            byId.setDealWith(DealWithEnum.YES.getCode());
            busOrderDetailRepository.save(byId);
        }
    }
}
