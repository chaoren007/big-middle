package com.morning.star.retail.facade.impl;

import com.morning.star.retail.application.CategoryApplication;
import com.morning.star.retail.dao.CategoryDAO;
import com.morning.star.retail.entity.CategoryEntity;
import com.morning.star.retail.facade.CategoryFacade;
import com.morning.star.retail.facade.dto.*;
import com.morning.star.retail.utils.page.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class CategoryFacadeImpl implements CategoryFacade {
    @Autowired
    private CategoryApplication categoryApplication;

    @Autowired
    private CategoryDAO categoryDAO;

    @Override
    public Long create(CategoryAddDTO dto) {

        return categoryApplication.create(dto);
    }

    @Override
    public void delete(Long categoryId) {
        categoryApplication.delete(categoryId);
    }

    @Override
    public void edit(CategoryUpdateDTO dto) {
        categoryApplication.edit(dto);
    }

    @Override
    public List<CategoryDTO> queryList(Long categoryId, String categoryName) {

        return categoryApplication.queryList(categoryId, categoryName);
    }

    @Override
    public List<CategoryDTO> queryCategory3List(String categoryName) {


        return categoryApplication.queryCategory3List(categoryName);
    }


    @Override
    public PageBean<CategoryCountReDTO> queryCountPage(CategoryCountDTO dto) {

        return categoryApplication.queryCountGroupPage(dto);
    }

    @Override
    public PageBean<CategoryCountReDTO> queryCountGroupPage(CategoryCountDTO dto) {

        return categoryApplication.queryCountGroupPage(dto);
    }

    @Override
    public CategoryDTO getByCode(Long categoryId) {

        return categoryApplication.getByCode(categoryId);
    }

    @Override
    public CategoryDTO getProperty(Long categoryId) {
        List<CategoryPropertyDTO> property = categoryApplication.getProperty(categoryId);
        CategoryDTO dto = new CategoryDTO();
        dto.setProperties(property);
        //获取分类属性
        return dto;
    }

    @Override
    public void statisticCategory(Long categoryId) {
        categoryApplication.statisticCategory(categoryId);
    }

    @Override
    public List<CategoryHotListDTO> getUseAlways() {
        List<CategoryHotListDTO> list = new ArrayList<>();
        List<CategoryDTO> useAlways = categoryDAO.getUseAlways();

        if (useAlways != null) {
            useAlways.forEach(e -> {
                CategoryHotListDTO hotlist = new CategoryHotListDTO();
                //三级分类
                CategoryEntity entity3 = categoryApplication.getByCategoryId(e.getCategoryId());
                hotlist.setCategoryId3(entity3.getCategoryId());
                hotlist.setCategoryName3(entity3.getCategoryName());

                //二级分类
                CategoryEntity entity2 = categoryApplication.getByCategoryId(entity3.getParentId());
                hotlist.setCategoryId2(entity2.getCategoryId());
                hotlist.setCategoryName2(entity2.getCategoryName());

                //一级分类
                CategoryEntity entity1 = categoryApplication.getByCategoryId(entity2.getParentId());
                hotlist.setCategoryId1(entity1.getCategoryId());
                hotlist.setCategoryName1(entity1.getCategoryName());
                list.add(hotlist);
            });
        }
        return list;
    }

    @Override
    public List<CategoryDTO> getDepartment() {
        CategoryQueryDTO queryDTO = new CategoryQueryDTO();
        queryDTO.setParentId(0L);
        return categoryDAO.queryList(queryDTO);
    }
}
