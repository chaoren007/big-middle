package com.morning.star.retail.facade.impl;

import com.alibaba.fastjson.JSON;
import com.morning.star.retail.application.ThirdServiceBaseApplication;
import com.morning.star.retail.dto.GoodsWmsInfoDTO;
import com.morning.star.retail.entity.ThirdServiceEntity;
import com.morning.star.retail.entity.enums.RequestStatusEnum;
import com.morning.star.retail.entity.enums.RequestTagEnum;
import com.morning.star.retail.entity.repository.ThirdServiceFailRepository;
import com.morning.star.retail.entity.repository.ThirdServiceRepository;
import com.morning.star.retail.facade.ProductWmsFacade;
import com.morning.star.retail.facade.assembler.GoodsAssembler;
import com.morning.star.retail.facade.dto.GoodsWmsDTO;
import com.morning.star.retail.utils.entity.WmsUtils;
import com.morning.star.retail.validate.Validate;
import com.wms.Remsg;
import com.wms.WMS;
import com.wms.WMSPortType;
import com.wms.bean.ResultBean;
import com.wms.bean.ResultFormat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductWmsFacadeImpl implements ProductWmsFacade {
    @Autowired
    private ThirdServiceBaseApplication thirdServiceBaseApplication;

    @Override
    @Validate
    public void add(GoodsWmsDTO dto) {
        thirdServiceBaseApplication.addGoods(dto);
    }
}
