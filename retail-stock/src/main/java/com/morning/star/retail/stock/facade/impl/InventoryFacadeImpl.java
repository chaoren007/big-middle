package com.morning.star.retail.stock.facade.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.Validate;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.Page;
import com.morning.star.retail.facade.InventoryFacade;
import com.morning.star.retail.objectcopier.ObjectCopier;
import com.morning.star.retail.stock.application.InventoryApplication;
import com.morning.star.retail.stock.dao.InventoryDAO;
import com.morning.star.retail.stock.dto.ExportInventoryItemDTO;
import com.morning.star.retail.stock.dto.InventoryAdjustDTO;
import com.morning.star.retail.stock.dto.InventoryDTO;
import com.morning.star.retail.stock.dto.InventoryFormDTO;
import com.morning.star.retail.stock.dto.InventoryItemDTO;
import com.morning.star.retail.stock.dto.InventoryItemQueryDTO;
import com.morning.star.retail.stock.dto.InventoryItemSubmitDTO;
import com.morning.star.retail.stock.dto.InventoryItemWaterDTO;
import com.morning.star.retail.stock.dto.InventoryQueryDTO;
import com.morning.star.retail.stock.dto.InventoryStatDTO;
import com.morning.star.retail.stock.dto.InventoryStatementDTO;
import com.morning.star.retail.stock.dto.InventoryStatementItemDTO;
import com.morning.star.retail.stock.dto.InventoryStatementQueryDTO;
import com.morning.star.retail.stock.dto.InventorySubmitDTO;
import com.morning.star.retail.stock.dto.InventoryWaterDTO;
import com.morning.star.retail.stock.entity.InventoryAdjustEntity;
import com.morning.star.retail.stock.entity.InventoryEntity;
import com.morning.star.retail.stock.entity.InventoryItemEntity;
import com.morning.star.retail.stock.entity.InventoryStatementEntity;
import com.morning.star.retail.stock.entity.StockEntity;
import com.morning.star.retail.stock.entity.repository.InventoryAdjustRepository;
import com.morning.star.retail.stock.entity.repository.InventoryItemRepository;
import com.morning.star.retail.stock.entity.repository.InventoryRepository;
import com.morning.star.retail.stock.entity.repository.InventoryStatementRepository;
import com.morning.star.retail.stock.entity.repository.StockRepository;
import com.morning.star.retail.stock.enums.InventoryEntryStatus;
import com.morning.star.retail.stock.enums.InventoryStashStatus;
import com.morning.star.retail.stock.enums.InventoryStatementStatus;
import com.morning.star.retail.stock.listener.mq.SubmitInventoryQueue;
import com.morning.star.retail.util.StringUtil;
import com.morning.star.retail.utils.entity.BeanUtils;
import com.morning.star.retail.utils.page.PageBean;
import com.morning.star.retail.utils.page.PageBeanAssembler;
import com.morning.star.retail.utils.page.RowBoundsBuilder;

@Service
public class InventoryFacadeImpl implements InventoryFacade {

    @Autowired
    private InventoryRepository inventoryRepository;
    @Autowired
    private InventoryItemRepository itemRepository;
    @Autowired
    private InventoryAdjustRepository adjustRepository;
    @Autowired
    private InventoryStatementRepository statementRepository;
    @Autowired
    private StockRepository stockRepository;
    @Autowired
    private InventoryApplication inventoryApplication;
    @Autowired
    private InventoryDAO inventoryDAO;

    @Override
    public boolean create(InventoryFormDTO formDTO) {
        return inventoryApplication.create(formDTO);
    }

    @Override
    public boolean submit(InventorySubmitDTO dto) {
        checkRepeatData(dto.getItems());
        checkNum(dto.getItems());
        new SubmitInventoryQueue(dto).publish();
        return true;
    }

    /**
     * 检查盘点数量
     *
     * @param list
     */
    private void checkNum(List<InventoryItemSubmitDTO> list) {
        StringBuffer goodsCodes = new StringBuffer();
        for (InventoryItemSubmitDTO item : list) {
            if (item.getNum().compareTo(BigDecimal.ZERO) < 0) {
                goodsCodes.append(item.getGoodsCode()).append("，");
            }
        }

        Validate.isTrue(StringUtils.isBlank(goodsCodes.toString()), String.format("商品盘点【编码：%s】数量不能小于0，请检查", StringUtil.removeLastSpliter(goodsCodes.toString(), "，")));
    }

    /**
     * 检查重复提交数据
     *
     * @param list
     */
    private void checkRepeatData(List<InventoryItemSubmitDTO> list) {
        Map<String, Long> map = list.stream().collect(Collectors.groupingBy(InventoryItemSubmitDTO::getGoodsCode, Collectors.counting()));
        StringBuilder goodsCodes = new StringBuilder();
        map.forEach((k, v) -> {
            if (v > 1) {
                goodsCodes.append(k).append("，");
            }
        });

        Validate.isTrue(StringUtils.isBlank(goodsCodes.toString()), String.format("提交商品【编码：%s】存在重复，请检查", StringUtil.removeLastSpliter(goodsCodes.toString(), "，")));
    }

    @Override
    public boolean save(InventorySubmitDTO dto) {
        return inventoryApplication.save(dto);
    }

    @Override
    public PageBean<InventoryDTO> list(InventoryQueryDTO queryDTO) {
        RowBounds rowBounds = RowBoundsBuilder.build(queryDTO.getPageNo(), queryDTO.getPageSize());
        Page<InventoryDTO> page = inventoryDAO.queryByPage(queryDTO, rowBounds);
        return new PageBeanAssembler().toBean(page);
    }

    @Override
    public InventoryDTO get(InventoryItemQueryDTO queryDTO) {
        InventoryEntity entity = inventoryApplication.checkGet(queryDTO.getInventoryCode());
        InventoryDTO dto = ObjectCopier.copyObject(InventoryDTO.class, entity);

        InventoryStatDTO stat = inventoryDAO.queryStat(queryDTO.getInventoryCode());
        dto.setStat(stat);

        RowBounds rowBounds = RowBoundsBuilder.build(queryDTO.getPageNo(), queryDTO.getPageSize());
        Page<InventoryItemDTO> items = inventoryDAO.queryItemByPage(queryDTO, rowBounds);
        dto.setItems(new PageBeanAssembler().toBean(items));

        return dto;
    }

    @Override
    public int batchRead(String inventoryCodes, String storeCode) {
        return inventoryApplication.batchRead(inventoryCodes.split(","), storeCode);
    }

    @Override
    @Transactional
    public void stash(String inventoryCode) {
        InventoryEntity inventory = inventoryApplication.checkGet(inventoryCode);
        Validate.isTrue(InventoryEntryStatus.Y.equals(inventory.getEntryStatus()), "该盘点单未录入盘点数据，不能执行盘点扎帐操作");

        inventory.setStashStatus(InventoryStashStatus.Y);
        inventoryRepository.save(inventory);

        List<InventoryItemEntity> items = itemRepository.getByInventoryCode(inventoryCode);
        items.forEach(item -> {
            StockEntity stockEntity = stockRepository.getByGoodsCodeAndWarehouseCode(item.getGoodsCode(), inventory.getStoreCode());
            Validate.notNull(stockEntity, String.format("未找到该商品【编码：%s】库存信息", item.getGoodsCode()));
            item.setDoneInStockNum(stockEntity.getDoneInStockNum());
            itemRepository.save(item);
        });
    }

    @Override
    @Transactional
    public void auditSucc(String inventoryCodes, String storeCode) {
        for (String inventoryCode : inventoryCodes.split(",")) {
            inventoryApplication.auditSucc(inventoryCode, storeCode);
        }
    }

    @Override
    @Transactional
    public void auditFail(String inventoryCodes, String storeCode) {
        for (String inventoryCode : inventoryCodes.split(",")) {
            inventoryApplication.auditFail(inventoryCode, storeCode);
        }
    }

    private List<ExportInventoryItemDTO> queryExportItem(String inventoryCode, String storeCode, Integer status) {
        InventoryEntity entity = inventoryRepository.getByInventoryCode(inventoryCode);

        InventoryItemQueryDTO queryDTO = new InventoryItemQueryDTO();
        queryDTO.setInventoryCode(inventoryCode);
        queryDTO.setStatus(status);

        List<InventoryItemDTO> itemList = inventoryDAO.queryItem(queryDTO);
        List<ExportInventoryItemDTO> result = new ArrayList<>(itemList.size());
        for (InventoryItemDTO item : itemList) {
            ExportInventoryItemDTO itemDTO = new ExportInventoryItemDTO();
            result.add(itemDTO);
        }
        return result;
    }

    @Override
    public List<ExportInventoryItemDTO> queryExportAllItem(String inventoryCode, String storeCode) {

        return queryExportItem(inventoryCode, storeCode, null);
    }

    @Override
    public List<ExportInventoryItemDTO> queryExportWarnItem(String inventoryCode, String storeCode) {

        return queryExportItem(inventoryCode, storeCode, 12);
    }

    @Override
    public List<ExportInventoryItemDTO> queryExportLossItem(String inventoryCode, String storeCode) {
        return queryExportItem(inventoryCode, storeCode, 3);
    }

    @Override
    @Transactional
    public void createAdjust(InventoryAdjustDTO dto) {
        inventoryApplication.createAdjust(dto);
    }

    @Override
    public List<InventoryAdjustDTO> queryAdjust(String inventoryCode, String goodsCode) {
        List<InventoryAdjustEntity> list = adjustRepository.getByInventoryCodeAndGoodsCodeOrderByCreateTimeDesc(inventoryCode, goodsCode);
        return ObjectCopier.copyList(InventoryAdjustDTO.class, list);
    }

    @Override
    public void createStatement(String inventoryCode, boolean isFormal) {
        inventoryApplication.createStatement(inventoryCode, isFormal);
    }

    @Override
    public void confirmStatement(String inventoryCode) {
        inventoryApplication.modifyStatementStatus(inventoryCode, InventoryStatementStatus.CONFIRMED);
    }

    @Override
    public void cancelStatement(String inventoryCode) {
        inventoryApplication.modifyStatementStatus(inventoryCode, InventoryStatementStatus.GENERATED);
    }

    @Override
    public void archiveStatement(String inventoryCode) {
        inventoryApplication.modifyStatementStatus(inventoryCode, InventoryStatementStatus.ARCHIVED);
    }

    @Override
    public List<InventoryStatementDTO> queryStatement(String inventoryCode) {
        List<InventoryStatementEntity> list = statementRepository.getByInventoryCode(inventoryCode);
        List<InventoryStatementDTO> dtos = new ArrayList<>(list.size());
        for (InventoryStatementEntity entity : list) {
            InventoryStatementDTO dto = new InventoryStatementDTO();
            BeanUtils.copy(entity, dto);
            dtos.add(dto);
        }
        return dtos;
    }

    @Override
    public PageBean<InventoryStatementItemDTO> queryStatementItem(InventoryStatementQueryDTO queryDTO) {
        RowBounds rowBounds = RowBoundsBuilder.build(queryDTO.getPageNo(), queryDTO.getPageSize());
        Page<InventoryStatementItemDTO> page = inventoryDAO.queryStatementItemByPage(queryDTO, rowBounds);
        return new PageBeanAssembler().toBean(page);
    }

    @Override
    public List<InventoryWaterDTO> queryWater(String inventoryCode) {
        return inventoryDAO.queryWater(inventoryCode);
    }

    @Override
    public PageBean<InventoryItemWaterDTO> queryItemWater(InventoryItemQueryDTO queryDTO) {
        RowBounds rowBounds = RowBoundsBuilder.build(queryDTO.getPageNo(), queryDTO.getPageSize());
        Page<InventoryItemWaterDTO> page = inventoryDAO.queryItemWater(queryDTO, rowBounds);
        return new PageBeanAssembler().toBean(page);
    }

}
