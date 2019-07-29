package com.morning.star.retail.facade.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.morning.star.retail.base.page.PageBeans;
import com.morning.star.retail.dao.SupplierDAO;
import com.morning.star.retail.dto.SupplierChangeDTO;
import com.morning.star.retail.dto.SupplierItemDTO;
import com.morning.star.retail.dto.SupplierQueryDTO;
import com.morning.star.retail.dto.SupplierStoreDTO;
import com.morning.star.retail.entity.*;
import com.morning.star.retail.entity.repository.*;
import com.morning.star.retail.enums.SupplierChangeStatusEnum;
import com.morning.star.retail.facade.SupplierChangeFacade;
import com.morning.star.retail.facade.dto.ProductDTO;
import com.morning.star.retail.helperservice.ProductHelpService;
import com.morning.star.retail.utils.entity.BeanUtils;
import com.morning.star.retail.utils.entity.DeleteFlagEnum;
import com.morning.star.retail.utils.page.PageBean;
import com.morning.star.retail.utils.page.PageBeanAssembler;
import com.morning.star.retail.utils.page.RowBoundsBuilder;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SupplierChangeFacadeImpl implements SupplierChangeFacade {

    @Autowired
    private SupplierChangeRespository changeRespository;
    @Autowired
    private SupplierChangeStoreRespository changeStoreRespository;
    @Autowired
    private SupplierChangeItemRespository changeItemRespository;
    @Autowired
    private SupplierRespository supplierRespository;
    @Autowired
    private SupplierStoreRespository supplierStoreRespository;
    @Autowired
    private SupplierItemRespository supplierItemRespository;
    @Autowired
    private SupplierDAO supplierDAO;
    @Autowired
    private ProductHelpService productHelpService;

    @Override
    @Transactional
    public void save(SupplierChangeDTO dto) {
        checkRepeat(dto); // 检查重复提交数据
        checkGetSupplier(dto.getSupplierCode()); // 检查供应商

        SupplierChangeEntity changeEntity = changeRespository.getByCodeAndGroupCode(dto.getCode(), dto.getGroupCode());
        if (changeEntity != null) {
            changeStoreRespository.deleteByChangeCodeAndSupplierCodeAndGroupCode(dto.getCode(), dto.getSupplierCode(),
                    dto.getGroupCode()); // 删除变更前门店
            changeItemRespository.deleteByChangeCodeAndSupplierCodeAndGroupCode(dto.getCode(), dto.getSupplierCode(),
                    dto.getGroupCode()); // 删除变更前供应货品
        }

        changeEntity = new SupplierChangeEntity();
        BeanUtils.copy(dto, changeEntity);
        changeRespository.save(changeEntity); // 保存变更单

        dto.getSupplierStores().forEach(storeDTO -> {
            SupplierChangeStoreEntity changeStoreEntity = new SupplierChangeStoreEntity();
            BeanUtils.copy(storeDTO, changeStoreEntity);
            changeStoreEntity.setChangeCode(dto.getCode());
            changeStoreEntity.setSupplierCode(dto.getSupplierCode());
            changeStoreEntity.setGroupCode(dto.getGroupCode());
            changeStoreRespository.save(changeStoreEntity); // 保存变更供货门店
        });

        dto.getSupplierItems().forEach(itemDTO -> {
            changeItemRespository.save(toSupplierChangeItemEntity(itemDTO, dto)); // 保存变更供应货品
        });
    }

    /**
     * 检查重复数据
     *
     * @param dto
     */
    private void checkRepeat(SupplierChangeDTO dto) {
        Map<String, String> map = new HashMap<>();
        StringBuilder repeatStoreCodes = new StringBuilder();
        StringBuilder repeatProductCodes = new StringBuilder();
        dto.getSupplierStores().forEach(storeDTO -> {
            if (map.get(storeDTO.getStoreCode()) != null) {
                repeatStoreCodes.append(storeDTO.getStoreCode()).append(",");
            } else {
                map.put(storeDTO.getStoreCode(), storeDTO.getStoreName());
            }
        });

        dto.getSupplierItems().forEach(itemDTO -> {
            if (map.get(itemDTO.getProductCode()) != null) {
                repeatProductCodes.append(itemDTO.getProductCode()).append(",");
            } else {
                map.put(itemDTO.getProductCode(), itemDTO.getProductName());
            }
        });

        String msg = "";
        if (StringUtils.isNotBlank(repeatStoreCodes)) {
            msg += "重复门店编码：" + repeatStoreCodes.toString();
        }
        if (StringUtils.isNotBlank(repeatProductCodes)) {
            msg += "重复商品编码：" + repeatProductCodes.toString();
        }

        Validate.isTrue(StringUtils.isNotBlank(msg), "提交表单中含有重复数据," + msg + "请重新检查后提交");
    }

    /**
     * 数据转换
     *
     * @param itemDTO
     * @param changeDTO
     * @return
     */
    private SupplierChangeItemEntity toSupplierChangeItemEntity(SupplierItemDTO itemDTO, SupplierChangeDTO changeDTO) {
        ProductDTO productDTO = productHelpService.checkGet(itemDTO.getProductCode(), changeDTO.getGroupCode());
        SupplierChangeItemEntity entity = new SupplierChangeItemEntity();
        BeanUtils.copy(productDTO, entity);

        entity.setChangeCode(changeDTO.getCode());
        entity.setSupplierCode(changeDTO.getSupplierCode());
        entity.setGroupCode(changeDTO.getGroupCode());
        entity.setTaxRate(itemDTO.getTaxRate());
        entity.setProductCode(productDTO.getProductCode());
        entity.setProductName(productDTO.getProductName());
        entity.setUnits(productDTO.getUnitsName());
        return entity;
    }

    /**
     * 检查供应商信息
     *
     * @param supplierCode
     * @return
     */
    private SupplierEntity checkGetSupplier(String supplierCode) {
        SupplierEntity entity = supplierRespository.getBySupplierCode(supplierCode);
        Validate.isTrue(entity != null, "未找到该供应商信息");
        return entity;
    }

    @Override
    public void delete(SupplierChangeDTO dto) {
        SupplierChangeEntity entity = checkGet(dto.getCode(), dto.getGroupCode());
        // TODO 是否要判断什么状态的不能删除？？？
        entity.setDeleteFlag(DeleteFlagEnum.DELETE.getCode());
        changeRespository.save(entity);
    }

    @Override
    @Transactional
    public void audit(SupplierChangeDTO dto) {
        SupplierChangeEntity changeEntity = checkGet(dto.getCode(), dto.getGroupCode());
        Validate.isTrue(SupplierChangeStatusEnum.WAIT_AUDIT.getCode().equals(changeEntity.getStatus()),
                "到该供应商变更单当前非待审核状态，不能执行审核操作");

        BeanUtils.copy(dto, changeEntity);
        changeRespository.save(changeEntity);

        if (SupplierChangeStatusEnum.AUDIT_SUCCESS.getCode().equals(dto.getStatus())) {
            List<SupplierChangeStoreEntity> stores = changeStoreRespository.getByChangeCodeAndSupplierCodeAndGroupCode(
                    dto.getCode(), changeEntity.getSupplierCode(), dto.getGroupCode());
            stores.forEach(changeStoreEntity -> {
                SupplierStoreEntity storeEntity = new SupplierStoreEntity();
                BeanUtils.copy(changeStoreEntity, storeEntity);
                supplierStoreRespository.save(storeEntity);
            });

            List<SupplierChangeItemEntity> items = changeItemRespository.getByChangeCodeAndSupplierCodeAndGroupCode(
                    dto.getCode(), changeEntity.getSupplierCode(), dto.getGroupCode());
            items.forEach(changeItemEntity -> {
                SupplierItemEntity itemEntity = new SupplierItemEntity();
                BeanUtils.copy(changeItemEntity, itemEntity);
                supplierItemRespository.save(itemEntity);
            });
        }
    }

    private SupplierChangeEntity checkGet(String code, String groupCode) {
        SupplierChangeEntity entity = changeRespository.getByCodeAndGroupCode(code, groupCode);
        Validate.isTrue(entity != null, "未找到该供应商变更单信息");
        return entity;
    }

    @Override
    public PageBean<SupplierChangeDTO> list(SupplierQueryDTO queryDTO) {
        RowBounds build = RowBoundsBuilder.build(queryDTO.getPageNo(), queryDTO.getPageSize());
        Page<SupplierChangeDTO> list = supplierDAO.querySupplierChangeByPage(queryDTO, build);
        return new PageBeanAssembler().toBean(list);
    }

    @Override
    public SupplierChangeDTO get(String code, String groupCode) {
        SupplierChangeEntity entity = checkGet(code, groupCode);
        SupplierChangeDTO changeDTO = new SupplierChangeDTO();
        BeanUtils.copy(entity, changeDTO);

        SupplierQueryDTO queryDTO = SupplierQueryDTO.bySupplierChangeCode(code, entity.getSupplierCode(), groupCode);
        changeDTO.setStores(listStore(queryDTO));
        changeDTO.setItems(listItem(queryDTO));

        return changeDTO;
    }

    @Override
    public PageBeans<SupplierStoreDTO> listStore(SupplierQueryDTO queryDTO) {
        PageHelper.startPage(queryDTO.getPageNo(), queryDTO.getPageSize());
        List<SupplierStoreDTO> list = supplierDAO.querySupplierChangeStoreByPage(queryDTO);
        return new PageBeans<>(list);
    }

    @Override
    public PageBeans<SupplierItemDTO> listItem(SupplierQueryDTO queryDTO) {
        PageHelper.startPage(queryDTO.getPageNo(), queryDTO.getPageSize());
        List<SupplierItemDTO> list = supplierDAO.querySupplierChangeItemByPage(queryDTO);
        return new PageBeans<>(list);
    }

}
