package com.morning.star.retail.application.impl;

import com.morning.star.retail.user.UserPermission;
import com.morning.star.retail.util.Json;
import com.morning.star.retail.util.StringUtil;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.Validate;
import org.apache.ibatis.session.RowBounds;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.morning.star.retail.application.ImeiApplication;
import com.morning.star.retail.dao.ImeiDAO;
import com.morning.star.retail.entity.ImeiEntity;
import com.morning.star.retail.entity.repository.ImeiRepository;
import com.morning.star.retail.facade.dto.ImeiAddDTO;
import com.morning.star.retail.facade.dto.ImeiQueryDTO;
import com.morning.star.retail.facade.dto.ImeiUpdateDTO;
import com.morning.star.retail.user.UserUtils;
import com.morning.star.retail.utils.page.PageBean;
import com.morning.star.retail.utils.page.PageBeanAssembler;
import com.morning.star.retail.utils.page.RowBoundsBuilder;

@Service
public class ImeiApplicationImpl implements ImeiApplication {

    @Autowired
    private ImeiRepository imeiRepository;
    @Autowired
    private ImeiDAO imeiDAO;

    private static Logger log = LoggerFactory.getLogger(ImeiApplicationImpl.class);
    @Override
    public void create(ImeiAddDTO dto) {
        ImeiEntity byImeiCode = imeiRepository.getByImeiCode(dto.getImeiCode());
        Validate.isTrue(byImeiCode==null,"串码已经存在");
        ImeiEntity entity = new ImeiEntity();
        BeanUtils.copyProperties(dto, entity);
        imeiRepository.save(entity);
    }

    @Override
    public void edit(ImeiUpdateDTO dto) {
        ImeiEntity oldEntity = imeiRepository.getByImeiCode(dto.getOldImeiCode());
        Validate.notNull(oldEntity, "原串码不存在");
        new UserPermission(UserUtils.currentUser())
            .tag("storeCode", oldEntity.getStoreCode())
            .pass();
        ImeiEntity newEntity = imeiRepository.getByImeiCode(dto.getNewImeiCode());
        Validate.isTrue(newEntity==null,"新串码已存在");
        oldEntity.setImeiCode(dto.getNewImeiCode());
        log.info("=============="+ Json.toJson(oldEntity));
        imeiRepository.save(oldEntity);
    }

    @Override
    public PageBean<ImeiAddDTO> queryPage(ImeiQueryDTO dto) {
        RowBounds build = RowBoundsBuilder.build(dto.getPageNo(), dto.getPageSize());
        Page<ImeiAddDTO> queryPage = imeiDAO.queryPage(dto, build);
        return new PageBeanAssembler().toBean(queryPage);
    }

}
