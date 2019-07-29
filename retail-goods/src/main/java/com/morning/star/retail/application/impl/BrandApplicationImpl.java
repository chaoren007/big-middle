package com.morning.star.retail.application.impl;

import com.github.pagehelper.Page;
import com.morning.star.retail.application.BrandApplication;
import com.morning.star.retail.application.CategoryApplication;
import com.morning.star.retail.dao.BrandDAO;
import com.morning.star.retail.dao.GoodsDAO;
import com.morning.star.retail.dao.ProductDAO;
import com.morning.star.retail.entity.BrandEntity;
import com.morning.star.retail.entity.BrandWaterEntity;
import com.morning.star.retail.entity.repository.BrandRepository;
import com.morning.star.retail.entity.repository.WaterRepository;
import com.morning.star.retail.facade.dto.*;
import com.morning.star.retail.utils.page.PageBean;
import com.morning.star.retail.utils.page.PageBeanAssembler;
import com.morning.star.retail.utils.page.RowBoundsBuilder;
import org.apache.commons.lang.Validate;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Service
public class BrandApplicationImpl implements BrandApplication {
    @Autowired
    private BrandDAO brandDAO;
    @Autowired
    private BrandRepository brandRepository;
    @Autowired
    private WaterRepository waterRepository;
    @Autowired
    private GoodsDAO goodsDAO;
    @Autowired
    private ProductDAO productDAO;

    @Autowired
    private CategoryApplication categoryApplication;


    @Transactional
    @Override
    public Long create(BrandAddDTO dto) {
        String brandName = dto.getBrandName();
        Validate.notNull(brandName, "品牌名称不能为空");
        Validate.notNull(dto.getCategoryIds(), "分类ID不能为空");
        Validate.isTrue(!brandRepository.existsByBrandName(brandName), "品牌名称已经存在");

        //获取部门名称
        StringBuffer categoryId = new StringBuffer();
        StringBuffer categoryName = new StringBuffer();
        String[] split = dto.getCategoryIds().trim().split(",");
        for (String s : split) {
            CategoryDTO byCode = categoryApplication.getByCode(Long.parseLong(s));
            categoryId.append(byCode.getCategoryId()).append(",");
            categoryName.append(byCode.getCategoryName()).append(",");
        }
        BrandEntity brandEntity = new BrandEntity();
        brandEntity.setBrandName(brandName);
        brandEntity.setEnBrandName(dto.getEnName());
        brandEntity.setUrl(dto.getUrl());
        brandEntity.setCategoryId(categoryId.toString());
        brandEntity.setCategoryName(categoryName.toString());
        brandRepository.save(brandEntity);
        waterRepository.save(brandEntity, BrandWaterEntity.class, "新增品牌");
        return brandEntity.getId();
    }

    @Transactional
    @Override
    public void delete(Long id) {
        BrandEntity entity = brandRepository.findOne(id);
        Validate.notNull(entity, "删除的品牌不存在");
        entity.delete();
        brandRepository.save(entity);
        waterRepository.save(entity, BrandWaterEntity.class, "删除品牌");
    }

    @Transactional
    @Override
    public void edit(BrandUpdateDTO dto) {
        //获取部门名称
        StringBuffer categoryId = new StringBuffer();
        StringBuffer categoryName = new StringBuffer();
        String[] split = dto.getCategoryIds().trim().split(",");
        for (String s : split) {
            CategoryDTO byCode = categoryApplication.getByCode(Long.parseLong(s));
            categoryId.append(byCode.getCategoryId()).append(",");
            categoryName.append(byCode.getCategoryName()).append(",");
        }
        BrandEntity entity = brandRepository.findOne(dto.getId());
        entity.setCategoryId(categoryId.toString());
        entity.setUrl(dto.getUrl());
        entity.setCategoryName(categoryName.toString());
        brandRepository.save(entity);
        waterRepository.save(entity, BrandWaterEntity.class, "修改品牌");

    }

    @Override
    public PageBean<BrandDTO> queryPage(BrandQueryDTO brandQueryDTO, RowBounds bounds) {
        if ("".equals(brandQueryDTO.getBrandName())) {
            brandQueryDTO.setBrandName(null);
        }
        Page<BrandDTO> result = brandDAO.queryPage(brandQueryDTO, bounds);
        return new PageBeanAssembler().toBean(result);
    }


    @Override
    public List<BrandDTO> queryList(BrandQueryDTO brandQueryDTO) {

        return brandDAO.queryList(brandQueryDTO);
    }

    @Override
    public PageBean<BrandCountReDTO> queryCountPage(BrandCountDTO dto) {
        RowBounds build = RowBoundsBuilder.build(dto.getPageNo(), dto.getPageSize());
        Page<BrandCountReDTO> page = goodsDAO.countBrand(dto, build);
        return new PageBeanAssembler().toBean(page);
    }

    @Override
    public PageBean<BrandCountReDTO> queryCountGroupPage(BrandCountDTO dto) {
        RowBounds build = RowBoundsBuilder.build(dto.getPageNo(), dto.getPageSize());
        Page<BrandCountReDTO> page = productDAO.countBrand(dto, build);
        return new PageBeanAssembler().toBean(page);
    }

    @Override
    public BrandDTO getByCode(Long id) {

        BrandDTO dto = new BrandDTO();
        BeanUtils.copyProperties(brandRepository.findOne(id), dto);
        return dto;
    }

}
