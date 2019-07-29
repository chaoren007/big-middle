package com.morning.star.retail.stock.facade.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.morning.star.retail.facade.ReceiptDiffFacade;
import com.morning.star.retail.stock.application.ReceiptDiffApplication;
import com.morning.star.retail.stock.dao.ReceiptDiffDAO;
import com.morning.star.retail.stock.dto.ModifyReceiptDiffDTO;
import com.morning.star.retail.stock.dto.QueryReceiptDiffDTO;
import com.morning.star.retail.stock.dto.ReceiptDiffInfoDTO;
import com.morning.star.retail.stock.dto.ReceiptDiffItemInfoDTO;
import com.morning.star.retail.stock.entity.ReceiptDiffEntity;
import com.morning.star.retail.stock.entity.ReceiptDiffItemEntity;
import com.morning.star.retail.stock.entity.repository.ReceiptDiffItemRepository;
import com.morning.star.retail.stock.entity.repository.ReceiptDiffRepository;
import com.morning.star.retail.utils.entity.BeanUtils;
import com.morning.star.retail.utils.page.PageBean;
import com.morning.star.retail.utils.page.PageBeanAssembler;
import com.morning.star.retail.utils.page.RowBoundsBuilder;

@Service
public class ReceiptDiffFacadeImpl implements ReceiptDiffFacade {
    @Autowired
    private ReceiptDiffDAO receiptDiffDAO;
    @Autowired
    private ReceiptDiffRepository receiptDiffRepository;
    @Autowired
    private ReceiptDiffItemRepository receiptDiffItemRepository;
    @Autowired
    private ReceiptDiffApplication receiptDiffApplication;
    @Override
    public PageBean<ReceiptDiffInfoDTO> query(QueryReceiptDiffDTO searchDTO) {
        RowBounds rowBounds = RowBoundsBuilder.build(searchDTO.getPageNo(), searchDTO.getPageSize());
        Page<ReceiptDiffInfoDTO> list = receiptDiffDAO.selectAll(searchDTO, rowBounds);
        return new PageBeanAssembler().toBean(list);
    }

    @Override
    public ReceiptDiffInfoDTO list(String code) {
        ReceiptDiffEntity one = receiptDiffRepository.findOne(code);
        ReceiptDiffInfoDTO receiptDiffInfoDTO = new ReceiptDiffInfoDTO();
        BeanUtils.copy(one, receiptDiffInfoDTO);
        List<ReceiptDiffItemEntity> items = receiptDiffItemRepository.findAllByReceiptDiffCode(code);
        List<ReceiptDiffItemInfoDTO> list = new ArrayList<>();
        for (ReceiptDiffItemEntity item : items) {
            ReceiptDiffItemInfoDTO receiptDiffItemInfoDTO = new ReceiptDiffItemInfoDTO();
            BeanUtils.copy(item, receiptDiffItemInfoDTO);
            list.add(receiptDiffItemInfoDTO);
        }
        receiptDiffInfoDTO.setItem(list);
        return receiptDiffInfoDTO;
    }

    @Override
    public void writeDiffItem(ModifyReceiptDiffDTO modifyReceiptDiffDTO) {
        receiptDiffApplication.writeDiffItem(modifyReceiptDiffDTO);
    }

    @Override
    public void batchWriteDiffItem(List<ModifyReceiptDiffDTO> list) {
        receiptDiffApplication.batchWriteDiffItem(list);
    }
}
