package com.morning.star.retail.application.impl;

import com.morning.star.retail.RabbitConfig;
import com.morning.star.retail.facade.dto.UnitsKdDTO;
import com.morning.star.retail.helper.MqHelperService;
import org.apache.commons.lang.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.morning.star.retail.application.UnitsApplication;
import com.morning.star.retail.entity.UnitsEntity;
import com.morning.star.retail.entity.repository.UnitsRepository;
import com.morning.star.retail.facade.dto.UnitsAddDTO;

@Service
public class UnitsApplicationImpl implements UnitsApplication {

    @Autowired
    private UnitsRepository unitsRepository;
    @Autowired
    private MqHelperService mqHelperService;
    @Autowired
    private RabbitConfig rabbitConfig;
    @Override
    public void create(UnitsAddDTO dto) {
        UnitsEntity getByName = unitsRepository.getByUnitsName(dto.getUnitsName());
        Validate.isTrue(getByName == null, "单位已存在");
        UnitsEntity entity = new UnitsEntity();
        entity.setUnitsName(dto.getUnitsName());
        UnitsEntity result = unitsRepository.save(entity);

        //同步到kingdee
        UnitsKdDTO units = new UnitsKdDTO(result.getUnitsName(),result.getId());
        mqHelperService.send(rabbitConfig.getExchange(),rabbitConfig.getCreateUnitsQueue(),units);
    }

    @Override
    public void delete(Long id) {
        UnitsEntity findOne = unitsRepository.findOne(id);
        Validate.notNull(findOne, "单位不存在");
        findOne.delete();
        unitsRepository.save(findOne);

        //同步到kingdee
        UnitsKdDTO units = new UnitsKdDTO(findOne.getUnitsName(),findOne.getId());
        mqHelperService.send(rabbitConfig.getExchange(),rabbitConfig.getDeleteUnitsQueue(),units);

    }

}
