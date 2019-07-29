package com.morning.star.retail.facade.impl;

import com.alibaba.fastjson.JSON;
import com.morning.star.retail.entity.ThirdServiceEntity;
import com.morning.star.retail.entity.enums.RequestStatusEnum;
import com.morning.star.retail.entity.enums.RequestTagEnum;
import com.morning.star.retail.entity.enums.RequestTypeEnum;
import com.morning.star.retail.entity.repository.ThirdServiceRepository;
import com.morning.star.retail.facade.BusOpcFacade;
import com.morning.star.retail.facade.dto.BusOpcDTO;
import com.morning.star.retail.facade.dto.BusResultDTO;
import org.apache.commons.lang.Validate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

@Service
public class BusOpcFacadeimpl implements BusOpcFacade {

    @Value("${business.url}")
    private String url;

    private String uri = "/pt-ms/api/opc/createOpc?" +
            "opc={opc}&opcName={opcName}&supplierEnterPhone={supplierEnterPhone}&agentEnterPhone={agentEnterPhone}&createTime={createTime}";
    private static final Logger log = LoggerFactory.getLogger(BusOpcFacadeimpl.class);

    @Autowired
    private ThirdServiceRepository thirdServiceRepository;

    @Override
    public BusResultDTO add(BusOpcDTO dto) {
        Validate.notNull(dto.getOpc(), "运营点编码不能为空!");
        Validate.notNull(dto.getOpcName(), "运营点名称不能为空!");
        Validate.notNull(dto.getAgentEnterPhone(), "运营点团长入驻电话不能为空!");
        Validate.notNull(dto.getSupplierEnterPhone(), "运营点供应商申请电话不能为空!");
        Validate.notNull(dto.getCreateTime(), "运营点创建时间不能为空!");
        String context = JSON.toJSONString(dto);
        ThirdServiceEntity entity = new ThirdServiceEntity(BusOpcFacadeimpl.class.getSimpleName() + "-" + dto.getOpc(), context, RequestTagEnum.BUISNESS_CREATE_OPC, RequestTypeEnum.BUISNESS);
        ThirdServiceEntity saveEntity = thirdServiceRepository.save(entity);
        RestTemplate restTemplate = new RestTemplate();
        String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(dto.getCreateTime());
        Map map = new HashMap<>();
        map.put("opc", dto.getOpc());
        map.put("opcName", dto.getOpcName());
        map.put("supplierEnterPhone", dto.getSupplierEnterPhone());
        map.put("agentEnterPhone", dto.getAgentEnterPhone());
        map.put("createTime", date);
        BusResultDTO result = null;
        try {
             result = restTemplate.getForObject(url+uri, BusResultDTO.class, map);
             saveEntity.setResponse(JSON.toJSONString(result));
             if(result.getCode().intValue()==1000){
                 saveEntity.setRequestStatus(RequestStatusEnum.SUCCESS);
             }
        } catch (Exception e) {
            log.info("调用运营端URI解析错误!");
        }finally {
            thirdServiceRepository.save(saveEntity);
        }
        return result;
    }
}
