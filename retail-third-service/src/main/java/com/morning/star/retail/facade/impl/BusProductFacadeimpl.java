package com.morning.star.retail.facade.impl;

import com.alibaba.fastjson.JSON;
import com.morning.star.retail.entity.ThirdServiceEntity;
import com.morning.star.retail.entity.enums.RequestStatusEnum;
import com.morning.star.retail.entity.enums.RequestTagEnum;
import com.morning.star.retail.entity.enums.RequestTypeEnum;
import com.morning.star.retail.entity.repository.ThirdServiceRepository;
import com.morning.star.retail.facade.BusProductFacade;
import com.morning.star.retail.facade.dto.BusProductDTO;
import com.morning.star.retail.facade.dto.BusResultDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class BusProductFacadeimpl implements BusProductFacade {

    @Value("${business.url}")
    private String url;

    @Autowired
    private RestTemplate restTemplate;

    private String uri = "/pt-ms/api/product/createProduct";
    private static final Logger log = LoggerFactory.getLogger(BusProductFacadeimpl.class);

    @Autowired
    private ThirdServiceRepository thirdServiceRepository;

    @Override
    public void add(BusProductDTO dto) {
        String context = JSON.toJSONString(dto);
        ThirdServiceEntity entity = new ThirdServiceEntity(BusOpcFacadeimpl.class.getSimpleName() + "-" + dto.getpCode(), context, RequestTagEnum.BUISNESS_CREATE_PRODUCT, RequestTypeEnum.BUISNESS);
        ThirdServiceEntity saveEntity = thirdServiceRepository.save(entity);
        try{
        BusResultDTO result = restTemplate.postForObject(url+uri, dto, BusResultDTO.class);
        saveEntity.setResponse(JSON.toJSONString(result));
        if(result.getCode().intValue()==1000){
            saveEntity.setRequestStatus(RequestStatusEnum.SUCCESS);
        }else {
            saveEntity.setRequestStatus(RequestStatusEnum.FAIL);
        }
        }catch (Exception e){

        }finally {
           thirdServiceRepository.save(saveEntity);
        }
    }
}
