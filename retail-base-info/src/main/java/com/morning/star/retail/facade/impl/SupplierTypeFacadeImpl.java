package com.morning.star.retail.facade.impl;

import java.util.List;

import org.apache.commons.lang3.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.morning.star.retail.base.page.PageBeans;
import com.morning.star.retail.dao.SupplierDAO;
import com.morning.star.retail.dto.SupplierTypeDTO;
import com.morning.star.retail.dto.SupplierTypeQueryDTO;
import com.morning.star.retail.entity.SupplierTypeEntity;
import com.morning.star.retail.entity.repository.SupplierRespository;
import com.morning.star.retail.entity.repository.SupplierTypeRespository;
import com.morning.star.retail.facade.SupplierTypeFacade;
import com.morning.star.retail.util.UniqueNoUtils;
import com.morning.star.retail.utils.entity.BeanUtils;
import com.morning.star.retail.utils.entity.DeleteFlagEnum;

@Service
public class SupplierTypeFacadeImpl implements SupplierTypeFacade {

    @Autowired
    private SupplierTypeRespository respository;
    @Autowired
    private SupplierRespository supplierRespository;
    @Autowired
    private SupplierDAO supplierDAO;

    @Override
    public void create(SupplierTypeDTO dto) {
        SupplierTypeEntity entity = respository.getByNameAndParentCode(dto.getName(), dto.getParentCode());
        Validate.isTrue(entity == null, "该供应商类别已存在");

        entity = new SupplierTypeEntity();
        BeanUtils.copy(dto, entity);
        entity.setCode(UniqueNoUtils.next(UniqueNoUtils.UniqueNoType.STC));
        respository.save(entity);
    }

    @Override
    public void modify(SupplierTypeDTO dto) {
        SupplierTypeEntity entity = checkGet(dto.getCode());
        checkNotUse(dto.getCode());
        if (!dto.getName().equals(entity.getName())) {
            SupplierTypeEntity supplierType = respository.getByCodeIsNotAndNameAndParentCode(dto.getCode(), dto.getName(), entity.getParentCode());
            Validate.isTrue(supplierType == null, "该供应商类别名称已被使用");
            entity.setName(dto.getName());
        }
        respository.save(entity);
    }

    @Override
    public void delete(String code) {
        SupplierTypeEntity entity = checkGet(code);
        checkNotUse(code);
        entity.setDeleteFlag(DeleteFlagEnum.DELETE.getCode());
        respository.save(entity);
    }

    /**
     * 根据编码检查类别
     *
     * @param code
     * @return
     */
    private SupplierTypeEntity checkGet(String code) {
        SupplierTypeEntity entity = respository.getByCode(code);
        Validate.isTrue(entity != null, "该供应商类别不存在");
        return entity;
    }

    /**
     * 检查是否未被使用
     *
     * @param code
     */
    private void checkNotUse(String code) {
        int count = supplierRespository.countByTypeCode(code);
        Validate.isTrue(count == 0, "该供应商类别正在使用中，不能进行其他操作");
    }

    @Override
    public PageBeans<SupplierTypeDTO> list(SupplierTypeQueryDTO queryDTO) {
        PageHelper.startPage(queryDTO.getPageNo(), queryDTO.getPageSize());
        List<SupplierTypeDTO> list = supplierDAO.querySupplierTypeByPage(queryDTO);
        return new PageBeans<>(list);
    }
}
