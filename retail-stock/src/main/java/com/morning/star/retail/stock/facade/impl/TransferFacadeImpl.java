package com.morning.star.retail.stock.facade.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.morning.star.retail.bean.AdminLoginContent;
import com.morning.star.retail.facade.TransferFacade;
import com.morning.star.retail.stock.application.TransferApplication;
import com.morning.star.retail.stock.dao.TransferDAO;
import com.morning.star.retail.stock.dto.TransferDTO;
import com.morning.star.retail.stock.dto.TransferExportDTO;
import com.morning.star.retail.stock.dto.TransferFormDTO;
import com.morning.star.retail.stock.dto.TransferItemDTO;
import com.morning.star.retail.stock.dto.TransferQueryDTO;
import com.morning.star.retail.stock.entity.TransferEntity;
import com.morning.star.retail.stock.entity.TransferItemEntity;
import com.morning.star.retail.stock.entity.repository.TransferItemRepository;
import com.morning.star.retail.stock.entity.repository.TransferRepository;
import com.morning.star.retail.stock.enums.TransferStatus;
import com.morning.star.retail.util.MultipartFileWrapper;
import com.morning.star.retail.utils.entity.BeanUtils;
import com.morning.star.retail.utils.entity.DeleteFlagEnum;
import com.morning.star.retail.utils.page.PageBean;
import com.morning.star.retail.utils.page.PageBeanAssembler;
import com.morning.star.retail.utils.page.RowBoundsBuilder;

@Service
public class TransferFacadeImpl implements TransferFacade {

    @Autowired
    private TransferDAO transferDAO;
    @Autowired
    private TransferApplication transferApplication;
    @Autowired
    private TransferRepository transferRepository;
    @Autowired
    private TransferItemRepository itemRepository;

    @Override
    public PageBean<TransferDTO> pageQuery(TransferQueryDTO queryDTO) {
        RowBounds build = RowBoundsBuilder.build(queryDTO.getPageNo(), queryDTO.getPageSize());
        Page<TransferDTO> list = transferDAO.selectByPage(queryDTO, build);
        return new PageBeanAssembler().toBean(list);
    }

    @Override
    public boolean saveDraft(TransferFormDTO formDTO) {
        return transferApplication.save(formDTO, TransferStatus.DRAFT);
    }

    @Override
    public boolean submit(TransferFormDTO formDTO) {
        return transferApplication.save(formDTO, TransferStatus.WAIT_AUDIT);
    }

    @Override
    public boolean delete(TransferFormDTO formDTO) {
        TransferEntity entity = transferApplication.checkQueryOne(formDTO.getTransferCode());
        entity.setDeleteFlag(DeleteFlagEnum.DELETE.getCode());
        transferRepository.save(entity);
        return true;
    }

    @Override
    public TransferDTO get(TransferQueryDTO queryDTO) {
        TransferEntity entity = transferApplication.checkQueryOne(queryDTO.getTransferCode());
        TransferDTO orderDTO = new TransferDTO();
        BeanUtils.copy(entity, orderDTO);

        RowBounds build = RowBoundsBuilder.build(queryDTO.getPageNo(), queryDTO.getPageSize());
        Page<TransferItemDTO> items = transferDAO.selectItemByPage(queryDTO, build);
        PageBean<TransferItemDTO> transferItems = new PageBeanAssembler().toBean(items);
        orderDTO.setTransferItems(transferItems);
        transferItems = orderDTO.getTransferItems();
        return orderDTO;
    }

    @Override
    public List<TransferExportDTO> queryExportData(TransferQueryDTO queryDTO) {
        List<TransferItemEntity> entities = itemRepository.getByTransferCode(queryDTO.getTransferCode());
        List<TransferExportDTO> list = new ArrayList<>(entities.size());
        entities.forEach(entity -> {
            TransferExportDTO dto = new TransferExportDTO();
            BeanUtils.copy(entity, dto);
            list.add(dto);
        });
        return list;
    }

    @Override
    public List<TransferItemDTO> getImportData(MultipartFileWrapper importFile, AdminLoginContent content) {
        return transferApplication.getImportData(importFile, content);
    }

    @Override
    public boolean auditSuccess(TransferFormDTO formDTO) {
        return transferApplication.audit(formDTO, TransferStatus.AUDIT_SUCCESS);
    }

    @Override
    public boolean auditReject(TransferFormDTO formDTO) {
        return transferApplication.audit(formDTO, TransferStatus.AUDIT_REJECT);
    }

}
