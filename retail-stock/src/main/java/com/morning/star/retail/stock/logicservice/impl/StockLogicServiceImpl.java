package com.morning.star.retail.stock.logicservice.impl;

import com.google.gson.Gson;
import com.morning.star.retail.stock.application.StockApplication;
import com.morning.star.retail.stock.dao.StockDAO;
import com.morning.star.retail.stock.dto.ItemDTO;
import com.morning.star.retail.stock.dto.StockOrderDTO;
import com.morning.star.retail.stock.dto.SupplierItemDTO;
import com.morning.star.retail.stock.entity.StockEntity;
import com.morning.star.retail.stock.entity.StockPreEntity;
import com.morning.star.retail.stock.entity.StockRecordEntity;
import com.morning.star.retail.stock.entity.repository.StockPreRepository;
import com.morning.star.retail.stock.entity.repository.StockRecordRepository;
import com.morning.star.retail.stock.entity.repository.StockRepository;
import com.morning.star.retail.stock.enums.StockPreStatusEnum;
import com.morning.star.retail.stock.enums.StockRecordTypeEnum;
import com.morning.star.retail.stock.exception.StockErrorCode;
import com.morning.star.retail.stock.helper.StockGoodsHelper;
import com.morning.star.retail.stock.helper.StoreService;
import com.morning.star.retail.stock.helper.WarehouseService;
import com.morning.star.retail.stock.helper.vo.GoodsInfo;
import com.morning.star.retail.stock.helper.vo.WarehouseInfo;
import com.morning.star.retail.stock.logicservice.StockLogicService;
import com.morning.star.retail.util.StringUtil;
import com.morning.star.retail.utils.entity.BeanUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.Validate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service("stockLogicService")
public class StockLogicServiceImpl implements StockLogicService {
    private static final Logger LOG = LoggerFactory.getLogger(StockLogicServiceImpl.class);
    private static final Gson GSON = new Gson();

    @Autowired
    private StockDAO stockDAO;
    @Autowired
    private StockGoodsHelper goodsService;
    @Autowired
    private StockApplication stockApplication;
    @Autowired
    private StockRepository stockRepository;
    @Autowired
    private StockRecordRepository stockRecordRepository;
    @Autowired
    private StockPreRepository stockPreRepository;
    @Autowired
    private StoreService storeService;
    @Autowired
    private WarehouseService warehouseService;

    @Override
    @Transactional
    public boolean onlinePreStock(StockOrderDTO dto) {
        LOG.info(" start ------------------------- onlinePreStock ---------------------- dto:{}", GSON.toJson(dto));
        checkNotDone(dto.getOrderCode(), StockRecordTypeEnum.ONLINE_PRE, dto.getStoreCode());
        checkRepeatData(dto.getItems());

        Integer status = stockDAO.queryLastPreStatus(dto.getOrderCode());
        // 检查是否重复操作
        if (status != null) {
            hasInitPreDone(status);
            hashCheckPreDone(status);
            hashFinishPreDone(status);
        }

        for (ItemDTO item : dto.getItems()) {
            StockEntity stockEntity = checkGetByGoodsCode(item.getGoodsCode(), dto.getWarehouseCode());

            stockApplication.preStock(item.getRealNum(), item.getGoodsCode(), dto.getStoreCode());

            // 初始化库存预占记录
            stockPreRepository.save(toStockPreEntity(dto, item, stockEntity, StockPreStatusEnum.INIT_PRE));

            addStockRecord(stockEntity, dto, item.getRealNum(), StockRecordTypeEnum.ONLINE_PRE);
        }
        LOG.info(" end ------------------------- onlinePreStock ---------------------- ");
        return true;
    }

    private StockPreEntity toStockPreEntity(StockOrderDTO dto, ItemDTO item, StockEntity stockEntity, StockPreStatusEnum status) {
        StockPreEntity entity = new StockPreEntity();
        BeanUtils.copy(stockEntity, entity);
        entity.setId(null);
        entity.setOrderCode(dto.getOrderCode());
        entity.setNum(item.getRealNum());
        entity.setStatus(status.getCode());
        return entity;
    }

    /**
     * 是否已完成初始化预占库存
     *
     * @param status
     */
    private void hasInitPreDone(Integer status) {
        if (StockPreStatusEnum.INIT_PRE.getCode().equals(status)) {
            throw StockErrorCode.ONLINE_PRE_STOCK_DONE.build();
        }
    }

    /**
     * 是否已完成确认预占库存
     *
     * @param status
     */
    private void hashCheckPreDone(Integer status) {
        if (StockPreStatusEnum.CHECK_PRE.getCode().equals(status)) {
            throw StockErrorCode.ONLINE_CHECK_PRE_STOCK_DONE.build();
        }
    }

    /**
     * 是否已完成取消预占库存
     *
     * @param status
     */
    private void hashCanclePreDone(Integer status) {
        if (StockPreStatusEnum.CANCEL_PRE.getCode().equals(status)) {
            throw StockErrorCode.ONLINE_CANCEL_PRE_STOCK_DONE.build();
        }
    }

    /**
     * 是否已完成结束预占库存
     *
     * @param status
     */
    private void hashFinishPreDone(Integer status) {
        if (StockPreStatusEnum.FINISH_PRE.getCode().equals(status)) {
            throw StockErrorCode.ONLINE_FINISH_PRE_STOCK_DONE.build();
        }
    }


    @Override
    @Transactional
    public boolean checkOnlinePreStock(StockOrderDTO dto) {
        LOG.info(" start ------------------------- checkOnlinePreStock ---------------------- dto:{}", GSON.toJson(dto));
        checkNotDone(dto.getOrderCode(), StockRecordTypeEnum.ONLINE_WAIT_OUT, dto.getStoreCode());
        checkRepeatData(dto.getItems());

        Integer status = stockDAO.queryLastPreStatus(dto.getOrderCode());
        if (status == null || StockPreStatusEnum.CANCEL_PRE.getCode().equals(status)) { // 检查是否已经初始化预占库存
            boolean hasPre = onlinePreStock(dto);
            if (!hasPre) {
                return false;
            }
        } else { // 检查是否重复操作
            hashCheckPreDone(status);
            hashFinishPreDone(status);
        }

        // 更新库存预占记录状态
        stockApplication.modifyStockPreStatus(StockPreStatusEnum.CHECK_PRE, dto.getOrderCode());

        for (ItemDTO item : dto.getItems()) {
            StockEntity stockEntity = checkGetByGoodsCode(item.getGoodsCode(), dto.getWarehouseCode());

            stockApplication.waitOutStock(item.getRealNum(), item.getGoodsCode(), dto.getStoreCode());

            addStockRecord(stockEntity, dto, item.getRealNum(), StockRecordTypeEnum.ONLINE_WAIT_OUT);
        }
        LOG.info(" end ------------------------- checkOnlinePreStock ---------------------- ");
        return true;
    }

    @Override
    @Transactional
    public boolean onlineFreeStock(StockOrderDTO dto) {
        LOG.info(" start ------------------------- onlineFreeStock ---------------------- dto:{}", GSON.toJson(dto));
        // 检查是否重复操作
        Integer status = stockDAO.queryLastPreStatus(dto.getOrderCode());
        hashCanclePreDone(status);
        hashFinishPreDone(status);
        // 如果当前预占状态为初始化预占，释放预占库存
        if (StockPreStatusEnum.INIT_PRE.getCode().equals(status)) {
            onlineFreePreStock(dto);
        }
        // 如果当前预占状态为确认预占，释放待发库存
        if (StockPreStatusEnum.CHECK_PRE.getCode().equals(status)) {
            onlineFreeWaitOutStock(dto);
        }
        LOG.info(" end ------------------------- onlineFreeStock ---------------------- ");
        return true;
    }

    private void onlineFreePreStock(StockOrderDTO dto) {
        LOG.info(" start ------------------------- onlineFreePreStock ---------------------- dto:{}", GSON.toJson(dto));
        checkNotDone(dto.getOrderCode(), StockRecordTypeEnum.ONLINE_FREE_PRE, dto.getStoreCode());
        checkRepeatData(dto.getItems());

        // 更新库存预占记录状态
        stockApplication.modifyStockPreStatus(StockPreStatusEnum.CANCEL_PRE, dto.getOrderCode());

        for (ItemDTO item : dto.getItems()) {
            StockEntity stockEntity = checkGetByGoodsCode(item.getGoodsCode(), dto.getWarehouseCode());

            stockApplication.freePreStock(item.getRealNum(), item.getGoodsCode(), dto.getStoreCode());

            addStockRecord(stockEntity, dto, item.getRealNum(), StockRecordTypeEnum.ONLINE_FREE_PRE);
        }
        LOG.info(" end ------------------------- onlineFreePreStock ---------------------- ");
    }

    private void onlineFreeWaitOutStock(StockOrderDTO dto) {
        LOG.info(" start ------------------------- onlineFreeWaitOutStock ---------------------- dto:{}", GSON.toJson(dto));
        checkNotDone(dto.getOrderCode(), StockRecordTypeEnum.ONLINE_FREE_WAIT_OUT, dto.getStoreCode());
        checkRepeatData(dto.getItems());

        // 更新库存预占记录状态
        stockApplication.modifyStockPreStatus(StockPreStatusEnum.CANCEL_PRE, dto.getOrderCode());

        for (ItemDTO item : dto.getItems()) {
            StockEntity stockEntity = checkGetByGoodsCode(item.getGoodsCode(), dto.getWarehouseCode());

            stockApplication.freeWaitOutStock(item.getRealNum(), item.getGoodsCode(), dto.getStoreCode());

            addStockRecord(stockEntity, dto, item.getRealNum(), StockRecordTypeEnum.ONLINE_FREE_WAIT_OUT);
        }
        LOG.info(" end ------------------------- onlineFreeWaitOutStock ---------------------- ");
    }

    @Override
    @Transactional
    public boolean onlineOutStock(StockOrderDTO dto) {
        LOG.info(" start ------------------------- onlineOutStock ---------------------- dto:{}", GSON.toJson(dto));
        checkNotDone(dto.getOrderCode(), StockRecordTypeEnum.ONLINE_OUT, dto.getStoreCode());
        checkRepeatData(dto.getItems());

        // TODO 检查是否进行确认预占库存？？？

        // 更新库存预占记录状态
        stockApplication.modifyStockPreStatus(StockPreStatusEnum.FINISH_PRE, dto.getOrderCode());

        for (ItemDTO item : dto.getItems()) {
            StockEntity stockEntity = checkGetByGoodsCode(item.getGoodsCode(), dto.getWarehouseCode());

            stockApplication.doneOutStock(item.getRealNum(), item.getGoodsCode(), dto.getStoreCode());

            addStockRecord(stockEntity, dto, item.getRealNum(), StockRecordTypeEnum.ONLINE_OUT);
        }
        LOG.info(" end ------------------------- onlineOutStock ---------------------- ");
        return true;
    }

    @Override
    @Transactional
    public boolean offlineOutStock(StockOrderDTO dto) {
        return directOutStock(dto, StockRecordTypeEnum.OFFLINE_OUT);
    }

    @Override
    @Transactional
    public boolean transferOutStock(StockOrderDTO dto) {
        return directOutStock(dto, StockRecordTypeEnum.TRANSFER_OUT);
    }

    @Override
    @Transactional
    public boolean returnOutStock(StockOrderDTO dto) {
        return directOutStock(dto, StockRecordTypeEnum.RETURN_OUT);
    }

    @Override
    @Transactional
    public boolean inventoryLossOutStock(StockOrderDTO dto) {
        return directOutStock(dto, StockRecordTypeEnum.INVENTORY_LOSS_OUT);
    }

    private boolean directOutStock(StockOrderDTO dto, StockRecordTypeEnum type) {
        LOG.info(" start ------------------------- directOutStock by {} ---------------------- dto:{}", type.getCode(), GSON.toJson(dto));
        checkNotDone(dto.getOrderCode(), type, dto.getStoreCode());
        checkRepeatData(dto.getItems());

        for (ItemDTO item : dto.getItems()) {
            GoodsInfo goods = goodsService.getGoods(item.getGoodsCode());
            // 判断是否称重商品
            if (goods.getStandardType() == 1 && StringUtils.isNotBlank(goods.getSapMotherCode())) {
                item.setGoodsCode(goods.getSapMotherCode());
            }
            StockEntity stockEntity = checkGetByGoodsCode(item.getGoodsCode(), dto.getWarehouseCode());

            stockApplication.directOutStock(item.getRealNum(), item.getGoodsCode(), dto.getStoreCode());

            addStockRecord(stockEntity, dto, item.getRealNum(), type);
        }
        LOG.info(" end ------------------------- directOutStock by {} ---------------------- ", type.getCode());
        return true;
    }

    @Override
    @Transactional
    public boolean directInStock(StockOrderDTO dto, StockRecordTypeEnum type) {
        LOG.info(" start ------------------------- directInStock by {} ---------------------- dto:{}", type.getCode(), GSON.toJson(dto));
        checkNotDone(dto.getOrderCode(), type, dto.getStoreCode());
        checkRepeatData(dto.getItems());

        for (ItemDTO item : dto.getItems()) {
            StockEntity stockEntity = getByGoodsCode(item.getGoodsCode(), dto.getWarehouseCode());
            if (stockEntity == null) {
                stockEntity = toStockEntity(dto, item);
                stockRepository.save(stockEntity);
            } else {
                stockApplication.directInStock(item.getRealNum(), item.getGoodsCode(), dto.getWarehouseCode());
            }

            addStockRecord(stockEntity, dto, item.getRealNum(), type);
        }
        LOG.info(" end ------------------------- directInStock by {} ---------------------- ", type.getCode());
        return true;
    }

    @Override
    @Transactional
    public boolean purchaseWaitInStock(StockOrderDTO dto) {
        return waitInStock(dto, StockRecordTypeEnum.PURCHASE_WAIT_IN);
    }

    @Override
    @Transactional
    public boolean transferWaitInStock(StockOrderDTO dto) {
        return waitInStock(dto, StockRecordTypeEnum.TRANSFER_WAIT_IN);
    }

    public boolean waitInStock(StockOrderDTO dto, StockRecordTypeEnum type) {
        LOG.info(" start ------------------------- waitInStock by {} ---------------------- dto:{}", type.getCode(), GSON.toJson(dto));
        checkNotDone(dto.getOrderCode(), type, dto.getStoreCode());
        checkRepeatData(dto.getItems());

        for (ItemDTO item : dto.getItems()) {
            StockEntity stockEntity = getByGoodsCode(item.getGoodsCode(), dto.getWarehouseCode());

            if (stockEntity != null) { // 库存存在，增量修改待入库存
                stockApplication.waitInStock(item.getOrderNum(), stockEntity.getGoodsCode(), stockEntity.getStoreCode());
            } else { // 库存不存在，新增库存
                stockEntity = toWaitInStock(dto, item);
                stockApplication.save(stockEntity);
            }

            addStockRecord(stockEntity, dto, item.getRealNum(), type);
        }
        LOG.info(" end ------------------------- waitInStock by {} ---------------------- ", type.getCode());
        return true;
    }

    @Override
    @Transactional
    public boolean purchaseInStock(StockOrderDTO dto) {
        LOG.info(" start ------------------------- purchaseInStock ---------------------- dto:{}", GSON.toJson(dto));
        checkNotDone(dto.getOrderCode(), StockRecordTypeEnum.PURCHASE_IN, dto.getStoreCode());
        checkRepeatData(dto.getItems());

        // 更新库存成本价
//        calculateCostPrice(dto);

        for (ItemDTO item : dto.getItems()) {
            StockEntity stockEntity = checkGetByGoodsCode(item.getGoodsCode(), dto.getWarehouseCode());

            stockApplication.doneInStock(item.getRealNum(), item.getOrderNum(), item.getGoodsCode(), dto.getStoreCode());

            addStockRecord(stockEntity, dto, item.getRealNum(), StockRecordTypeEnum.PURCHASE_IN);
        }
        LOG.info(" end ------------------------- purchaseInStock ---------------------- ");
        return true;
    }

    @Override
    @Transactional
    public boolean transferInStock(StockOrderDTO dto) {
        LOG.info(" start ------------------------- transferInStock ---------------------- dto:{}", GSON.toJson(dto));
        checkNotDone(dto.getOrderCode(), StockRecordTypeEnum.TRANSFER_IN, dto.getStoreCode());
        checkRepeatData(dto.getItems());

        for (ItemDTO item : dto.getItems()) {
            StockEntity stockEntity = checkGetByGoodsCode(item.getGoodsCode(), dto.getWarehouseCode());

            stockApplication.doneInStock(item.getRealNum(), item.getOrderNum(), item.getGoodsCode(), dto.getStoreCode());

            addStockRecord(stockEntity, dto, item.getRealNum(), StockRecordTypeEnum.TRANSFER_IN);

            // 调入门店未收数量，需要重新入库调出门店
            returnSender(dto, item, StockRecordTypeEnum.TRANSFER_RETURN);
        }
        LOG.info(" end ------------------------- transferInStock ---------------------- ");
        return true;
    }

    @Override
    @Transactional
    public boolean inventoryProfitInStock(StockOrderDTO dto) {
        LOG.info(" start ------------------------- inventoryProfitInStock ---------------------- dto:{}", GSON.toJson(dto));
        checkNotDone(dto.getOrderCode(), StockRecordTypeEnum.INVENTORY_PROFIT_IN, dto.getStoreCode());
        checkRepeatData(dto.getItems());

        for (ItemDTO item : dto.getItems()) {
            StockEntity stockEntity = getByGoodsCode(item.getGoodsCode(), dto.getWarehouseCode());

            if (stockEntity != null) { // 库存存在，增量修改在库库存
                stockApplication.directInStock(item.getRealNum(), item.getGoodsCode(), dto.getStoreCode());
            } else { // 库存不存在，新增库存
                stockEntity = directToStock(dto, item);
                stockApplication.save(stockEntity);
            }

            addStockRecord(stockEntity, dto, item.getRealNum(), StockRecordTypeEnum.INVENTORY_PROFIT_IN);
        }
        LOG.info(" end ------------------------- inventoryProfitInStock ---------------------- ");
        return true;
    }

    @Override
    @Transactional
    public boolean otherIn(StockOrderDTO dto) {
        LOG.info(" start ------------------------- otherIn ---------------------- dto:{}", GSON.toJson(dto));
        checkNotDone(dto.getOrderCode(), StockRecordTypeEnum.OTHER_IN, dto.getStoreCode());
        checkRepeatData(dto.getItems());

        for (ItemDTO item : dto.getItems()) {
            StockEntity stockEntity = getByGoodsCode(item.getGoodsCode(), dto.getWarehouseCode());

            if (stockEntity != null) { // 库存存在，增量修改在库库存
                stockApplication.directInStock(item.getRealNum(), item.getGoodsCode(), dto.getStoreCode());
            } else { // 库存不存在，新增库存
                stockEntity = directToStock(dto, item);
                stockApplication.save(stockEntity);
            }

            addStockRecord(stockEntity, dto, item.getRealNum(), StockRecordTypeEnum.OTHER_IN);

        }
        LOG.info(" end ------------------------- otherIn ---------------------- ");
        return true;
    }

    /**
     * 调入门店未收数量，需要重新入库调出门店
     *
     * @param dto
     * @param item
     * @param type
     */
    private void returnSender(StockOrderDTO dto, ItemDTO item, StockRecordTypeEnum type) {
        for (SupplierItemDTO supplierItem : item.getSupplierItems()) {
            BigDecimal returnNum = supplierItem.getOrderNum().subtract(supplierItem.getRealNum());

            if (returnNum.compareTo(BigDecimal.ZERO) == 1) {
                StockEntity outStockEntity = getByGoodsCode(supplierItem.getGoodsCode(), supplierItem.getSupplierCode());
                Validate.notNull(outStockEntity, String.format("未找到调出门店的该商品【编码：%s】库存信息", supplierItem.getGoodsCode()));

                stockApplication.directInStock(returnNum, supplierItem.getGoodsCode(), supplierItem.getSupplierCode()); // 直接入库

                dto.setStoreCode(supplierItem.getSupplierCode());
                addStockRecord(outStockEntity, dto, returnNum, type); // 库存流水
            }
        }
    }

    /**
     * 待入库存
     *
     * @param dto
     * @param item
     * @return
     */
    private StockEntity toWaitInStock(StockOrderDTO dto, ItemDTO item) {
        StockEntity entity = toStockEntity(dto, item);
        entity.setDoneInStockNum(BigDecimal.ZERO);
        entity.setWaitInStockNum(item.getOrderNum());
        return entity;
    }

    /**
     * 直接入库
     *
     * @param dto
     * @param item
     * @return
     */
    private StockEntity directToStock(StockOrderDTO dto, ItemDTO item) {
        StockEntity entity = toStockEntity(dto, item);
        entity.setDoneInStockNum(item.getRealNum());
        entity.setWaitInStockNum(BigDecimal.ZERO);
        return entity;
    }

    private StockEntity toStockEntity(StockOrderDTO dto, ItemDTO item) {
        GoodsInfo goods = goodsService.getGoods(item.getGoodsCode());
        WarehouseInfo warehouseInfo = warehouseService.checkGet(dto.getWarehouseCode());
        StockEntity entity = new StockEntity();
        BeanUtils.copy(goods, entity);

        entity.setWarehouseCode(warehouseInfo.getWarehouseCode());
        entity.setWarehouseName(warehouseInfo.getWarehouseName());
        entity.setCityId(warehouseInfo.getCityId());
        entity.setCityName(warehouseInfo.getCity());
        entity.setStoreCode(dto.getStoreCode());
        entity.setGroupCode(dto.getGroupCode());

        entity.setWaitInStockNum(BigDecimal.ZERO);
        entity.setDoneInStockNum(item.getRealNum());
        entity.setPreStockNum(BigDecimal.ZERO);
        entity.setWaitOutStockNum(BigDecimal.ZERO);
        entity.setDoneOutStockNum(BigDecimal.ZERO);

        if (goods.getStandardType().intValue() == 0) { // 标准类型（0：非称重，1：称重）
            entity.setUnits(goods.getUnitsName());
        } else {
            entity.setUnits("克");
        }

        // TODO 计算库存成本价

        return entity;
    }

    /**
     * 是否未执过
     *
     * @param orderCode
     * @param type
     * @param warehouseCode
     * @return
     */
    private void checkNotDone(String orderCode, StockRecordTypeEnum type, String warehouseCode) {
        int count = stockRecordRepository.countByOrderCodeAndTypeAndWarehouseCode(orderCode, type.getCode(), warehouseCode);
        Validate.isTrue(count == 0, "该操作已完成，不能重复执行");
    }

    /**
     * 检查重复提交数据
     *
     * @param list
     */
    private void checkRepeatData(List<ItemDTO> list) {
        Map<String, Long> map = list.stream().collect(Collectors.groupingBy(ItemDTO::getGoodsCode, Collectors.counting()));
        StringBuilder goodsCodes = new StringBuilder();
        map.forEach((k, v) -> {
            if (v > 1) {
                goodsCodes.append(k).append("，");
            }
        });

        Validate.isTrue(StringUtils.isBlank(goodsCodes.toString()), String.format("提交商品【编码：%s】存在重复，请检查", StringUtil.removeLastSpliter(goodsCodes.toString(), "，")));
    }

    /**
     * 添加库存流水
     *
     * @param stockEntity
     * @param dto
     * @param num
     * @param type
     */
    private void addStockRecord(StockEntity stockEntity, StockOrderDTO dto, BigDecimal num, StockRecordTypeEnum type) {
        StockRecordEntity recordEntity = new StockRecordEntity();
        BeanUtils.copy(stockEntity, recordEntity);
        recordEntity.setId(null);
        recordEntity.setOrderCode(dto.getOrderCode());
        recordEntity.setNum(num);
        recordEntity.setType(type.getCode());
        recordEntity.setStatus(dto.getStatus());
        stockRecordRepository.save(recordEntity);
    }

    private StockEntity getByGoodsCode(String goodsCode, String warehouseCode) {
        return stockRepository.getByGoodsCodeAndWarehouseCode(goodsCode, warehouseCode);
    }

    private StockEntity checkGetByGoodsCode(String goodsCode, String warehouseCode) {
        StockEntity stockEntity = getByGoodsCode(goodsCode, warehouseCode);
        Validate.notNull(stockEntity, String.format("未找到该商品【编码：%s】库存信息", goodsCode));
        return stockEntity;
    }

}
