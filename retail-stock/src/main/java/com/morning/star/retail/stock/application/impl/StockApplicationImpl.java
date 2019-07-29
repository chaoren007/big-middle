package com.morning.star.retail.stock.application.impl;

import com.google.gson.Gson;
import com.morning.star.retail.stock.application.StockApplication;
import com.morning.star.retail.stock.dto.StockDTO;
import com.morning.star.retail.stock.dto.StockFormDTO;
import com.morning.star.retail.stock.dto.StockQueryDTO;
import com.morning.star.retail.stock.entity.StockEntity;
import com.morning.star.retail.stock.entity.StockRecordEntity;
import com.morning.star.retail.stock.entity.repository.StockPreRepository;
import com.morning.star.retail.stock.entity.repository.StockRecordRepository;
import com.morning.star.retail.stock.entity.repository.StockRepository;
import com.morning.star.retail.stock.enums.StockPreStatusEnum;
import com.morning.star.retail.stock.helper.StockGoodsHelper;
import com.morning.star.retail.stock.helper.StoreService;
import com.morning.star.retail.stock.helper.vo.GoodsInfo;
import com.morning.star.retail.stock.helper.vo.StoreInfo;
import com.morning.star.retail.utils.entity.BeanUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.Validate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
public class StockApplicationImpl implements StockApplication {
    private static final Gson GSON = new Gson();
    private static final Logger LOGGER = LoggerFactory.getLogger(StockApplicationImpl.class);

    @Autowired
    private StockRepository stockRepository;
    @Autowired
    private StockRecordRepository stockRecordRepository;
    @Autowired
    private StockPreRepository stockPreRepository;
    @Autowired
    private StockGoodsHelper goodsService;
    @Autowired
    private StoreService storeService;

    @Override
    public StockDTO get(StockQueryDTO queryDTO) {
        StockEntity stockEntity = queryOne(queryDTO);
        if (stockEntity == null) {
            return null;
        }
        StockDTO stockDTO = new StockDTO();
        BeanUtils.copy(stockEntity, stockDTO);
        return stockDTO;
    }

    /**
     * 查询单个货品
     *
     * @param queryDTO
     * @return
     */
    private StockEntity queryOne(StockQueryDTO queryDTO) {
        if (StringUtils.isNotBlank(queryDTO.getProductCode())) {
            return stockRepository.getByProductCodeAndWarehouseCode(queryDTO.getProductCode(), queryDTO.getWarehouseCode());
        } else if (StringUtils.isNotBlank(queryDTO.getGoodsCode())) {
            return stockRepository.getByGoodsCodeAndWarehouseCode(queryDTO.getGoodsCode(), queryDTO.getWarehouseCode());
        } else if (StringUtils.isNotBlank(queryDTO.getUpcCode())) {
            return stockRepository.getByUpcCodeAndWarehouseCode(queryDTO.getUpcCode(), queryDTO.getWarehouseCode());
        } else {
            throw new RuntimeException("查询单个商品库存需传入货品编码，商品编码，upc中的一个参数");
        }
    }

    @Override
    public boolean save(StockEntity stockEntity) {
        if (stockEntity.getCostPrice() == null) {
            stockEntity.setCostPrice(BigDecimal.ZERO);
        }
        stockRepository.save(stockEntity);
        return true;
    }

    @Override
    @Transactional
    public boolean modify(StockFormDTO formDTO) {
        StockEntity stockEntity = stockRepository.getByGoodsCodeAndWarehouseCode(formDTO.getGoodsCode(), formDTO.getStoreCode());
        Validate.notNull(stockEntity, String.format("未找到该商品【编码:%s】库存信息", formDTO.getGoodsCode()));

        stockEntity.setDoneInStockNum(formDTO.getDoneInStockNum());
        stockRepository.save(stockEntity);

        saveRecord(formDTO, stockEntity);
        return true;
    }

    /**
     * 库存流水
     *
     * @param formDTO
     * @param stockEntity
     */
    private void saveRecord(StockFormDTO formDTO, StockEntity stockEntity) {
        StockRecordEntity recordEntity = new StockRecordEntity();
        BeanUtils.copy(stockEntity, recordEntity);
        recordEntity.setId(null);
        recordEntity.setOrderCode(formDTO.getOrderCode());
        recordEntity.setNum(formDTO.getDoneInStockNum());
        recordEntity.setType(formDTO.getStockRecordType().getCode());
        recordEntity.setStatus(formDTO.getOrderStatus());
        stockRecordRepository.save(recordEntity);
    }

    @Override
    @Transactional
    public boolean save(StockFormDTO formDTO) {
        LOGGER.info(" start ------------------------ stock:save ------------------------ formDTO:{}", GSON.toJson(formDTO));
        StockEntity stockEntity = queryOne(StockQueryDTO.byGoodsCode(formDTO.getGoodsCode(), formDTO.getStoreCode()));
        if (stockEntity == null) {
            GoodsInfo goodsInfo = goodsService.getGoods(formDTO.getGoodsCode());
            Validate.notNull(goodsInfo, String.format("未找到该商品信息【编码：%s】", formDTO.getGoodsCode()));

            stockEntity = new StockEntity();
            // 拷贝商品的货品，商品，柜组等信息
            BeanUtils.copy(goodsInfo, stockEntity);
            stockEntity.setUnits(goodsInfo.getUnitsName());
            if (StringUtils.isBlank(formDTO.getStoreName())) {
                stockEntity.setStoreName(getStoreName(formDTO.getStoreCode()));
            }
            stockEntity.setDoneInStockNum(formDTO.getDoneInStockNum());
            stockEntity.setWaitInStockNum(BigDecimal.ZERO);
            stockEntity.setPreStockNum(BigDecimal.ZERO);
            stockEntity.setWaitOutStockNum(BigDecimal.ZERO);
            stockEntity.setDoneOutStockNum(BigDecimal.ZERO);
        } else {
            stockEntity.setDoneInStockNum(formDTO.getDoneInStockNum());
        }

        save(stockEntity);
        saveRecord(formDTO, stockEntity);

        LOGGER.info(" end ------------------------ stock:save ------------------------ ");
        return false;
    }

    private String getStoreName(String storeCode) {
        StoreInfo storeInfo = storeService.getStore(storeCode);
        Validate.notNull(storeInfo, String.format("未找到该门店【编码：%s】信息", storeCode));
        return storeInfo.getStoreName();
    }

    @Override
    @Transactional
    public void directInStock(BigDecimal num, String goodsCode, String warehouseCode) {
        stockRepository.directInStock(num, goodsCode, warehouseCode);
    }

    @Override
    @Transactional
    public void waitInStock(BigDecimal num, String goodsCode, String warehouseCode) {
        stockRepository.waitInStock(num, goodsCode, warehouseCode);
    }

    @Override
    @Transactional
    public void doneInStock(BigDecimal doneInStockNum, BigDecimal waitInStockNum, String goodsCode, String warehouseCode) {
        stockRepository.doneInStock(doneInStockNum, waitInStockNum, goodsCode, warehouseCode);
    }

    @Override
    @Transactional
    public void directOutStock(BigDecimal num, String goodsCode, String warehouseCode) {
        stockRepository.directOutStock(num, goodsCode, warehouseCode);
    }

    @Override
    @Transactional
    public void preStock(BigDecimal num, String goodsCode, String warehouseCode) {
        stockRepository.preStock(num, goodsCode, warehouseCode);
    }

    @Override
    @Transactional
    public void freePreStock(BigDecimal num, String goodsCode, String warehouseCode) {
        stockRepository.freePreStock(num, goodsCode, warehouseCode);
    }

    @Override
    @Transactional
    public void waitOutStock(BigDecimal num, String goodsCode, String warehouseCode) {
        stockRepository.waitOutStock(num, goodsCode, warehouseCode);
    }

    @Override
    @Transactional
    public void freeWaitOutStock(BigDecimal num, String goodsCode, String warehouseCode) {
        stockRepository.freeWaitOutStock(num, goodsCode, warehouseCode);
    }

    @Override
    @Transactional
    public void doneOutStock(BigDecimal num, String goodsCode, String warehouseCode) {
        stockRepository.doneOutStock(num, goodsCode, warehouseCode);
    }

    @Override
    @Transactional
    public void modifyStockPreStatus(StockPreStatusEnum status, String orderCode) {
        stockPreRepository.modifyStatus(status.getCode(), orderCode);
    }

}
