package com.morning.star.retail.facade.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.commons.lang.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.morning.star.retail.application.ImeiApplication;
import com.morning.star.retail.facade.ImeiFacade;
import com.morning.star.retail.facade.dto.ImeiAddDTO;
import com.morning.star.retail.facade.dto.ImeiQueryDTO;
import com.morning.star.retail.facade.dto.ImeiUpdateDTO;
import com.morning.star.retail.utils.page.PageBean;

@Service
public class ImeiFacadeImpl implements ImeiFacade {
    @Autowired
    private ImeiApplication imeiApplication;

    @Override
    public void create(ImeiAddDTO dto) {
        imeiApplication.create(dto);
    }

    @Override
    public void edit(ImeiUpdateDTO dto) {
        imeiApplication.edit(dto);
    }

    @Override
    public PageBean<ImeiAddDTO> queryPage(ImeiQueryDTO dto) {

        return imeiApplication.queryPage(dto);
    }

    @Transactional
    @Override
    public void createList(List<ImeiAddDTO> list, String storeCode, String groupCode) {
        List<String> lists = new ArrayList<>();
        for (ImeiAddDTO imeiAddDTO : list) {

            Validate.isTrue(!lists.contains(imeiAddDTO.getImeiCode()), "存在重复串码");
            lists.add(imeiAddDTO.getImeiCode());

            try {
                imeiAddDTO.setStoreCode(storeCode);
                imeiAddDTO.setGroupCode(groupCode);
                imeiApplication.create(imeiAddDTO);
            } catch (Exception e) {
                throw new RuntimeException(imeiAddDTO.getSapCode() + "串码错误", e);
            }
        }

    }

}
