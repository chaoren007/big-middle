package com.morning.star.retail.application.impl;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.morning.star.redis.Redis;
import com.morning.star.retail.RabbitConfig;
import com.morning.star.retail.application.CategoryApplication;
import com.morning.star.retail.dao.CategoryDAO;
import com.morning.star.retail.dao.GoodsDAO;
import com.morning.star.retail.dao.ProductDAO;
import com.morning.star.retail.entity.CategoryEntity;
import com.morning.star.retail.entity.CategoryLogEntity;
import com.morning.star.retail.entity.CategoryPropertyEntity;
import com.morning.star.retail.entity.CategoryWaterEntity;
import com.morning.star.retail.entity.repository.CategoryLogRepository;
import com.morning.star.retail.entity.repository.CategoryPropertyRepository;
import com.morning.star.retail.entity.repository.CategoryRepository;
import com.morning.star.retail.entity.repository.WaterRepository;
import com.morning.star.retail.enums.CategoryLevelEnum;
import com.morning.star.retail.facade.dto.*;
import com.morning.star.retail.helper.MqHelperService;
import com.morning.star.retail.utils.entity.DeleteFlagEnum;
import com.morning.star.retail.utils.page.PageBean;
import com.morning.star.retail.utils.page.PageBeanAssembler;
import com.morning.star.retail.utils.page.RowBoundsBuilder;
import org.apache.commons.lang.Validate;
import org.apache.ibatis.session.RowBounds;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class CategoryApplicationImpl implements CategoryApplication {

    private Logger log = LoggerFactory.getLogger(CategoryApplicationImpl.class);

    @Value("${create_parent_category}")
    private boolean flag;
    private static final Integer maxCategoryId1 = 90;
    private static final Integer minCategoryId1 = 10;
    private static final Integer maxCategoryId2 = 9099;
    private static final Integer minCategoryId2 = 1001;
    private static final Integer maxCategoryId3 = 909999;
    private static final Integer minCategoryId3 = 100101;
    private static final String all_categorys_redis_key = "all_categorys";
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private CategoryPropertyRepository categoryPropertyRepository;
    @Autowired
    private CategoryLogRepository categoryLogRepository;
    @Autowired
    private RabbitConfig rabbitConfig;
    @Autowired
    private MqHelperService mqHelperService;
    @Autowired
    private CategoryDAO categoryDAO;
    @Autowired
    private WaterRepository waterRepository;
    @Autowired
    private GoodsDAO goodsDAO;
    @Autowired
    private ProductDAO productDAO;
    @Autowired
    private Redis redisUtil;

    @Transactional
    @Override
    public Long create(CategoryAddDTO dto) {
        Long parentId = dto.getParentId();
        String categoryName = dto.getCategoryName();
        Validate.notNull(parentId, "父分类不能为空");
        Validate.notNull(categoryName, "分类名称不能为空");
        int categoryLevel = 1;
        int minSort = 1;
        // 检查当前层级类目中该类目名称是否已被占用
        boolean existsByCategoryName = categoryRepository.existsByCategoryName(categoryName);
        Validate.isTrue(!existsByCategoryName, "该类目名称已被占用");
        Long categoryId = -2L;
        // 检查父级分类是否存在
        if (parentId != 0) {
            //非添加根分类
            CategoryEntity findOne = categoryRepository.getByCategoryId(parentId);
            Validate.notNull(findOne, "父级分类不存在，请确认参数");
            //
            BigDecimal maxCommission = dto.getMaxCommission() == null ? findOne.getMaxCommission() : dto.getMaxCommission();
            BigDecimal minCommission = dto.getMinCommission() == null ? findOne.getMinCommission() : dto.getMinCommission();
            boolean a = findOne.getMaxCommission().compareTo(maxCommission) >= 0;
            boolean b = findOne.getMinCommission().compareTo(minCommission) <= 0;
            Validate.isTrue(a && b, "分佣比例应该在上级分类的分佣比例范围内");
            dto.setMaxCommission(maxCommission);
            dto.setMinCommission(minCommission);
            categoryLevel = findOne.getClevel() + 1;
            Validate.isTrue(categoryLevel <= 3, "最多三级分类");


            //分类ID分配规则 参数 分类level , 和传入的分类ID
            //checkCategory(categoryLevel, parentId);
        } else {
            Validate.isTrue(flag, "不支持添加根分类!");
            BigDecimal maxCommission = dto.getMaxCommission() == null ? new BigDecimal(99) : dto.getMaxCommission();
            BigDecimal minCommission = dto.getMinCommission() == null ? new BigDecimal(1) : dto.getMinCommission();
            dto.setMaxCommission(maxCommission);
            dto.setMinCommission(minCommission);

        }
        if (categoryLevel == 1) {
            categoryId = parentId + 1000 + 1;
        } else if (categoryLevel == 2L || categoryLevel == 3L) {
            categoryId = parentId * 100 + 1;
        }
        List<CategoryEntity> entitys = categoryRepository.getByParentId(parentId);
        List<Long> ids = new ArrayList();
        for (CategoryEntity entity : entitys) {
            ids.add(entity.getCategoryId());
        }
        Collections.sort(ids);
        for (Long id : ids) {
            if (id.equals(categoryId)) {
                categoryId = id + 1;
            } else {
                break;
            }
        }
        int maxSort = categoryDAO.getMaxSort(parentId);
        minSort = maxSort + 1;
        CategoryEntity categoryEntity = new CategoryEntity();
        categoryEntity.setClevel(categoryLevel);
        categoryEntity.setParentId(parentId);
        categoryEntity.setSort(minSort);
        categoryEntity.setCategoryName(categoryName);
        categoryEntity.setCategoryId(categoryId);
        categoryEntity.setMaxCommission(dto.getMaxCommission());
        categoryEntity.setMinCommission(dto.getMinCommission());
        categoryRepository.save(categoryEntity);
        List<CategoryPropertyDTO> propertyList = dto.getPropertyList();
        if (propertyList != null && !propertyList.isEmpty()) {
            propertyList.forEach(e -> {
                if (e.getPropertyKey() != null && !e.getPropertyKey().isEmpty()) {
                    CategoryPropertyEntity entity = new CategoryPropertyEntity();
                    entity.setCategoryId(categoryEntity.getCategoryId());
                    entity.setCategoryName(categoryEntity.getCategoryName());
                    entity.setPropertyKey(e.getPropertyKey());
                    entity.setPropertyVal(e.getPropertyVal());
                    categoryPropertyRepository.save(entity);
                }
            });
        }

        waterRepository.save(categoryEntity, CategoryWaterEntity.class, "新增分类");


        //发出添加分类事件
        CategoryWmsDTO wms = CategoryEntity.toWmsDTO(categoryEntity);
        mqHelperService.send(rabbitConfig.getExchange(), rabbitConfig.getCreateCategoryQueue(), wms);
        redisUtil.delete(all_categorys_redis_key);
        return categoryId;
    }


    private void checkCategory(Integer clevel, Long parentId, Long categoryId) {
        if (CategoryLevelEnum.SECOND.getCode().equals(clevel)) {
            Long a = categoryId / 100;
            Validate.isTrue(parentId.equals(a) && categoryId >= minCategoryId2 && categoryId <= maxCategoryId2, CategoryLevelEnum.SECOND.getDesc() + "分类编码不规范:" + minCategoryId2 + "~" + maxCategoryId2);
            return;
        }
        if (CategoryLevelEnum.THIRD.getCode().equals(clevel)) {
            Long a = categoryId / 100;
            Validate.isTrue(parentId.equals(a) && categoryId >= minCategoryId3 && categoryId <= maxCategoryId3, CategoryLevelEnum.THIRD.getDesc() + "分类编码不规范:" + minCategoryId3 + "~" + maxCategoryId3);
            return;
        }
    }

    @Override
    public void delete(Long categoryId) {
        //判断是否存在子分类
        boolean b = categoryRepository.existsByParentId(categoryId);
        Validate.isTrue(!b, "该分类存在子分类,不能删除");
        CategoryEntity byCategoryId = categoryRepository.getByCategoryId(categoryId);
        byCategoryId.setDeleteFlag(DeleteFlagEnum.DELETE.getCode());
        categoryRepository.save(byCategoryId);
    }

    @Override
    public void edit(CategoryUpdateDTO dto) {
        Validate.notNull(dto.getCategoryId(), "分类id不能为空");
        Validate.notNull(dto.getCategoryName(), "分类名称不能为空");
        CategoryEntity entity = categoryRepository.getByCategoryId(dto.getCategoryId());
        Validate.notNull(entity, "该类目不存在");
        Long parentId = entity.getParentId();
        if (parentId.intValue() == 0) {
            Validate.isTrue(flag, "不支持修改根分类!");
        }
        if (!entity.getCategoryName().equals(dto.getCategoryName())) {
            boolean existsByCategoryName = categoryRepository.existsByCategoryName(dto.getCategoryName());
            Validate.isTrue(!existsByCategoryName, "该类目名称已被占用");
        }
        if (parentId.intValue() != 0) {
            CategoryEntity findOne = categoryRepository.getByCategoryId(parentId);
            Validate.notNull(findOne, "父级分类不存在，请确认参数");
            //
            boolean a = findOne.getMaxCommission().compareTo(dto.getMaxCommission()) >= 0;
            boolean b = findOne.getMinCommission().compareTo(dto.getMinCommission()) <= 0;
            Validate.isTrue(a && b, "分佣比例应该在父级分佣比例范围内");
        }
        entity.setCategoryName(dto.getCategoryName());
        entity.setWeight(dto.getWeight());
        entity.setUrl(dto.getUrl());
        entity.setMinCommission(dto.getMinCommission());
        entity.setMaxCommission(dto.getMaxCommission());
        categoryRepository.save(entity);
        //跟新所有子分类的分佣比例
        categoryDAO.updateCommission(dto);


        List<CategoryPropertyEntity> byCategoryId = categoryPropertyRepository.getByCategoryId(entity.getCategoryId());
        if (byCategoryId != null) {
            byCategoryId.forEach(ee -> {
                ee.setDeleteFlag(DeleteFlagEnum.DELETE.getCode());
                categoryPropertyRepository.save(ee);
            });
        }
        List<CategoryPropertyDTO> propertyList = dto.getPropertyList();
        if (propertyList != null && !propertyList.isEmpty()) {
            propertyList.forEach(e -> {
                if (e.getPropertyKey() != null && !e.getPropertyKey().isEmpty()) {
                    CategoryPropertyEntity categoryPropertyEntity = new CategoryPropertyEntity();
                    categoryPropertyEntity.setCategoryId(entity.getCategoryId());
                    categoryPropertyEntity.setCategoryName(entity.getCategoryName());
                    categoryPropertyEntity.setPropertyKey(e.getPropertyKey());
                    categoryPropertyEntity.setPropertyVal(e.getPropertyVal());
                    categoryPropertyRepository.save(categoryPropertyEntity);
                }
            });
        }
        waterRepository.save(entity, CategoryWaterEntity.class, "修改分类");
        //删除redis缓存
        redisUtil.delete(all_categorys_redis_key);
    }

    @Override
    public List<CategoryDTO> queryList(Long categoryId, String categoryName) {

        CategoryQueryDTO categoryQueryDTO = new CategoryQueryDTO();
        boolean a = categoryName == null || categoryName.length() == 0;
        boolean b = categoryId == null;
        if (a & b) {
            String all_category = redisUtil.get(all_categorys_redis_key);
            if (all_category == null || all_category.equals("")) {
                categoryQueryDTO.setParentId(0L);
                List<CategoryDTO> select = categoryDAO.queryList(categoryQueryDTO);
                if (select != null && select.size() > 0) {
                    final List<CategoryDTO> categoryDTOS = queryList(select);
                    redisUtil.set(all_categorys_redis_key, JSON.toJSONString(categoryDTOS));
                    return categoryDTOS;
                }
            }else {
                List<CategoryDTO> categoryDTO = JSON.parseArray(all_category, CategoryDTO.class);
                return categoryDTO;
            }

        } else {
            categoryQueryDTO.setCategoryName(categoryName);
            categoryQueryDTO.setCategoryId(categoryId);
            List<CategoryDTO> select = categoryDAO.queryList(categoryQueryDTO);
            if (select != null && select.size() == 1) {
                List<CategoryDTO> queryList = queryList(select);
                CategoryDTO queryListTop = queryListTop(queryList.get(0));
                return Collections.singletonList(queryListTop);
            }
        }
        return Collections.emptyList();
    }

    @Override
    public List<CategoryDTO> queryCategory3List(String categoryName) {
        List<CategoryDTO> result = new ArrayList<>();
        CategoryQueryDTO categoryQueryDTO = new CategoryQueryDTO();
        categoryQueryDTO.setCategoryName(categoryName);
        List<CategoryDTO> select = categoryDAO.getByCategoryName(categoryQueryDTO);
        if (select != null && select.size() > 0) {
            for (CategoryDTO categoryDTO : select) {
                CategoryDTO queryListTop = queryListTop(categoryDTO);
                result.add(queryListTop);
            }
            return result;
        }
        return Collections.emptyList();
    }

    public List<CategoryDTO> queryList(List<CategoryDTO> list) {
        for (CategoryDTO categoryDTO : list) {
            if (categoryDTO.getClevel() > 3) {
                break;
            }
            if (categoryDTO.getClevel() == 3) {
                //查出分类的商品属性

            }
            CategoryQueryDTO categoryQueryDTO = new CategoryQueryDTO();
            categoryQueryDTO.setParentId(categoryDTO.getCategoryId());
            List<CategoryDTO> select = categoryDAO.queryList(categoryQueryDTO);
            if (select != null && select.size() > 0) {
                categoryDTO.setChilds(select);
                queryList(select);
            }
        }
        return list;

    }

    /**
     * 根据一个分类查出父分类
     */
    private CategoryDTO queryListTop(CategoryDTO dto) {
        if (dto.getParentId() == 0) {
            return dto;
        }
        CategoryDTO parent = categoryDAO.getByCategoryId(dto.getParentId());
        parent.setChilds(Collections.singletonList(dto));
        return queryListTop(parent);
    }

    @Override
    public PageBean<CategoryCountReDTO> queryCountPage(CategoryCountDTO dto) {
        RowBounds bounds = RowBoundsBuilder.build(dto.getPageNo(), dto.getPageSize());
        Page<CategoryCountReDTO> page = null;
        if (dto.getClevel() == 1) {
            page = goodsDAO.countCategory1(dto, bounds);
        }
        if (dto.getClevel() == 2) {
            page = goodsDAO.countCategory2(dto, bounds);
        }
        if (dto.getClevel() == 3) {
            page = goodsDAO.countCategory3(dto, bounds);
        }
        return new PageBeanAssembler().toBean(page);
    }

    @Override
    public PageBean<CategoryCountReDTO> queryCountGroupPage(CategoryCountDTO dto) {
        RowBounds bounds = RowBoundsBuilder.build(dto.getPageNo(), dto.getPageSize());
        Page<CategoryCountReDTO> page = null;
        if (dto.getClevel() == 1) {
            page = productDAO.countCategory1(dto, bounds);
        }
        if (dto.getClevel() == 2) {
            page = productDAO.countCategory2(dto, bounds);
        }
        if (dto.getClevel() == 3) {
            page = productDAO.countCategory3(dto, bounds);
        }
        return new PageBeanAssembler().toBean(page);
    }

    @Override
    public CategoryDTO getByCode(Long categoryId) {
        CategoryEntity findOne = categoryRepository.getByCategoryId(categoryId);

        CategoryDTO dto = new CategoryDTO();
        BeanUtils.copyProperties(findOne, dto);
        return dto;
    }

    @Override
    public CategoryDTO getParent(Long categoryId) {
        return getParent(categoryId, null);
    }

    @Override
    public List<CategoryPropertyDTO> getProperty(Long categoryId) {
        List<CategoryPropertyEntity> byCategoryId = categoryPropertyRepository.getByCategoryId(categoryId);
        List<CategoryPropertyDTO> list = new ArrayList<>();
        if (byCategoryId != null) {
            byCategoryId.forEach(e -> {
                CategoryPropertyDTO dto = new CategoryPropertyDTO();
                BeanUtils.copyProperties(e, dto);
                list.add(dto);
            });
        }
        return list;
    }

    @Override
    public void statisticCategory(Long categoryId) {
        CategoryLogEntity entity = new CategoryLogEntity();
        entity.setCategoryName(getByCode(categoryId).getCategoryName());
        entity.setCategoryId(categoryId);
//        UserInfo info = UserUtils.currentUser();
//        entity.setStoreCode(info.getTag("storeCode"));
//        entity.setGroupCode(info.getTag("groupCode"));
        categoryLogRepository.save(entity);
    }

    @Override
    public CategoryEntity getByCategoryId(Long categoryId) {
        return categoryRepository.getByCategoryId(categoryId);
    }

    private CategoryDTO getParent(Long categoryId, CategoryDTO child) {
        CategoryEntity categoryEntity = categoryRepository.getByCategoryId(categoryId);
        CategoryDTO dto = new CategoryDTO();
        BeanUtils.copyProperties(categoryEntity, dto);

        if (child != null) {
            dto.setChilds(Collections.singletonList(child));
        }
        if (categoryEntity.getParentId() <= 0) {
            return dto;
        } else {
            return getParent(categoryEntity.getParentId(), dto);
        }
    }
}