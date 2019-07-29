package com.morning.star.retail.stock.facade.impl;

import com.github.pagehelper.Page;
import com.morning.star.retail.facade.ReplenishFacade;
import com.morning.star.retail.facade.dto.replenish.*;
import com.morning.star.retail.stock.application.ReplenishApplication;
import com.morning.star.retail.stock.dao.ReplenishDao;
import com.morning.star.retail.stock.dao.ReplenishItemDao;
import com.morning.star.retail.stock.dto.ExportReplenishDTO;
import com.morning.star.retail.stock.entity.ReplenishEntity;
import com.morning.star.retail.stock.entity.ReplenishItemEntity;
import com.morning.star.retail.stock.entity.repository.ReplenishItemRepository;
import com.morning.star.retail.stock.entity.repository.ReplenishRepository;
import com.morning.star.retail.stock.enums.ReplenishStatus;
import com.morning.star.retail.stock.facade.assembler.ReplenishDTOAssembler;
import com.morning.star.retail.stock.facade.assembler.ReplenishItemDTOAssembler;
import com.morning.star.retail.utils.entity.BeanUtils;
import com.morning.star.retail.utils.page.PageBean;
import com.morning.star.retail.utils.page.PageBeanAssembler;
import com.morning.star.retail.utils.page.RowBoundsBuilder;
import org.apache.commons.lang.Validate;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReplenishFacadeImpl implements ReplenishFacade {
    @Autowired
    private ReplenishApplication replenishApplication;

    @Autowired
    private ReplenishDao replenishDao;
    @Autowired
    private ReplenishItemDao replenishItemDao;
    @Autowired
    private ReplenishRepository replenishRepository;
    @Autowired
    private ReplenishItemRepository replenishItemRepository;

    @Override
    public String submit(ReplenishSubmitDTO submitDTO) {
        return replenishApplication.submitReplenish(submitDTO);
    }

    @Override
    public PageBean<ReplenishDTO> list(ReplenishQueryDTO queryDTO) {
        RowBounds rowBounds = RowBoundsBuilder.build(queryDTO.getPageNo(), queryDTO.getPageSize());
        Page<ReplenishDTO> replenishDTOS = replenishDao.queryPage(queryDTO, rowBounds);

        replenishDTOS.getResult().forEach(e -> e.setStatusName(ReplenishStatus.from(e.getStatus()).getDesc()));
        return new PageBeanAssembler().toBean(replenishDTOS);
    }

    @Override
    public ReplenishDTO get(ReplenishQueryDTO queryDTO) {
        ReplenishDTOAssembler assembler = new ReplenishDTOAssembler();
        ReplenishItemDTOAssembler itemAssembler = new ReplenishItemDTOAssembler();
        ReplenishEntity replenishEntity = replenishRepository.getByReplenishCode(queryDTO.getReplenishCode());
        Validate.notNull(replenishEntity, "未找到该补货单信息");
        ReplenishDTO replenishDTO = assembler.toDTO(replenishEntity);
        replenishDTO.setItems(itemAssembler.toDTO(replenishEntity.getDetailEntityList()));
        return replenishDTO;
    }

    @Override
    public PageBean<ReplenishItemSimpleDTO> replenishDetail(ReplenishItemQueryDTO dto) {
        RowBounds rowBounds = RowBoundsBuilder.build(dto.getPage(), dto.getPageSize());
        Page<ReplenishItemSimpleDTO> list = replenishItemDao.getReplenishItemList(dto, rowBounds);
        return new PageBeanAssembler().toBean(list);
    }


    @Override
    public Integer modify(ReplenishUpdateDTO replenishDTO) {
        return this.replenishApplication.modify(replenishDTO);
    }

    @Override
    public Integer confirm(List<ReplenishAuditDTO> replenishAuditDTOS) {
        return this.replenishApplication.confirm(replenishAuditDTOS);
    }

    @Override
    public Integer reject(List<ReplenishAuditDTO> replenishAuditDTOS) {
        return this.replenishApplication.reject(replenishAuditDTOS);
    }

    @Override
    public Integer prepareReplenish(ReplenishAuditDTO replenishAuditDTO) {
        return replenishApplication.prepareReplenish(replenishAuditDTO);

    }

    @Override
    public Integer deliveryReplenish(ReplenishAuditDTO replenishAuditDTO) {
        return replenishApplication.deliveryReplenish(replenishAuditDTO);
    }

    @Override
    public List<ExportReplenishDTO> getExportData(ReplenishQueryDTO replenishQueryDTO) {
        replenishQueryDTO.setPageSize(Integer.MAX_VALUE);
        PageBean<ReplenishDTO> replenishDTOPageBean = list(replenishQueryDTO);
        List<ReplenishDTO> replenishDTOList = replenishDTOPageBean.getRecord();

        List<ExportReplenishDTO> exportReplenishDTOList = new ArrayList<>();
        for (ReplenishDTO replenishDTO : replenishDTOList) {
            List<ReplenishItemEntity> replenishItemEntityList = replenishItemRepository.queryByReplenishCode(replenishDTO.getReplenishCode());
            replenishItemEntityList.forEach(replenishItemEntity -> {
                ExportReplenishDTO exportReplenishDTO = new ExportReplenishDTO();
                BeanUtils.copy(replenishItemEntity, exportReplenishDTO);
                exportReplenishDTOList.add(exportReplenishDTO);
            });
        }
        return exportReplenishDTOList;
    }

}
