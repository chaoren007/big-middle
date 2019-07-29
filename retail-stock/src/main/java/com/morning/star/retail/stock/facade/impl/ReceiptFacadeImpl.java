package com.morning.star.retail.stock.facade.impl;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.morning.star.retail.facade.ReceiptFacade;
import com.morning.star.retail.facade.dto.purchasein.PurchaseInDetailUpdateDTO;
import com.morning.star.retail.facade.dto.purchasein.PurchaseInUpdateDTO;
import com.morning.star.retail.facade.dto.receipt.ReceiptImeiDTO;
import com.morning.star.retail.facade.dto.receipt.SureReceiptDTO;
import com.morning.star.retail.objectcopier.ObjectCopier;
import com.morning.star.retail.stock.application.PurchaseInApplication;
import com.morning.star.retail.stock.application.ReceiptApplication;
import com.morning.star.retail.stock.dao.ReceiptDAO;
import com.morning.star.retail.stock.dto.*;
import com.morning.star.retail.stock.entity.PurchaseInOrderDetailEntity;
import com.morning.star.retail.stock.entity.ReceiptEntity;
import com.morning.star.retail.stock.entity.ReceiptItemEntity;
import com.morning.star.retail.stock.entity.repository.PurchaseInOrderDetailRepository;
import com.morning.star.retail.stock.entity.repository.ReceiptItemRepository;
import com.morning.star.retail.stock.entity.repository.ReceiptRepository;
import com.morning.star.retail.stock.enums.ReceiptStatusEnum;
import com.morning.star.retail.stock.enums.ReceiptTypeEnum;
import com.morning.star.retail.stock.enums.StockRecordTypeEnum;
import com.morning.star.retail.stock.helper.StockGoodsHelper;
import com.morning.star.retail.stock.helper.SupplierService;
import com.morning.star.retail.stock.helper.WarehouseService;
import com.morning.star.retail.stock.helper.vo.GoodsInfo;
import com.morning.star.retail.stock.helper.vo.SupplierInfo;
import com.morning.star.retail.stock.helper.vo.WarehouseInfo;
import com.morning.star.retail.stock.logicservice.StockLogicService;
import com.morning.star.retail.util.DateUtil;
import com.morning.star.retail.utils.entity.BeanUtils;
import com.morning.star.retail.utils.page.PageBean;
import com.morning.star.retail.utils.page.PageBeanAssembler;
import com.morning.star.retail.utils.page.RowBoundsBuilder;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.Validate;
import org.apache.ibatis.session.RowBounds;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class ReceiptFacadeImpl implements ReceiptFacade {
    private static final Logger LOGGER = LoggerFactory.getLogger(ReceiptFacadeImpl.class);

    @Autowired
    private ReceiptApplication receiptApplication;
    @Autowired
    ReceiptDAO receiptDAO;
    @Autowired
    private ReceiptRepository receiptRepository;
    @Autowired
    private ReceiptItemRepository receiptItemRepository;
    @Autowired
    private PurchaseInOrderDetailRepository purchaseInOrderDetailRepository;
    @Autowired
    private WarehouseService warehouseService;
    @Autowired
    private SupplierService supplierService;
    @Autowired
    private StockGoodsHelper goodsHelper;
    @Autowired
    private PurchaseInApplication purchaseInApplication;
    @Autowired
    private StockLogicService stockLogicService;

    @Override
    public String saveReceipt(ReceiptAddDTO receiptAddDTO) {
        return receiptApplication.saveReceipt(receiptAddDTO);
    }

    @Override
    public PageBean<ReceiptDTO> list(ReceiptQueryDTO searchDTO) {
        RowBounds rowBounds = RowBoundsBuilder.build(searchDTO.getPageNo(), searchDTO.getPageSize());
        Page<ReceiptDTO> list = receiptDAO.selectAll(searchDTO, rowBounds);
        return new PageBeanAssembler().toBean(list);
    }

    @Override
    public ReceiptDTO get(ReceiptQueryDTO queryDTO) {
        ReceiptEntity entity = receiptRepository.getReceiptEntityByReceiptCode(queryDTO.getReceiptCode());
        Validate.notNull(entity, "未找到该入库单信息");
        ReceiptDTO dto = new ReceiptDTO();
        BeanUtils.copy(entity, dto);

        List<ReceiptItemEntity> itemEntities = receiptItemRepository.findAllByReceiptCode(queryDTO.getReceiptCode());
        dto.setItems(ObjectCopier.copyList(ReceiptItemDTO.class, itemEntities));

        return dto;
    }

    @Override
    public void sureReceipt(SureReceiptDTO sureReceiptDTO, Map<String, List<ReceiptImeiDTO>> iemis) {
        receiptApplication.sureReceipt(sureReceiptDTO, iemis);
    }

    @Override
    public void modifyReceiptDetail(ReceiptItemDTO receiptItemInfoDTO) {
        receiptApplication.modifyReceiptDetail(receiptItemInfoDTO);
    }

    @Override
    public PageBean<ExpiredGoodsDTO> queryExpiredGoods(ExpiredGoodsQueryDTO queryDTO) {
        RowBounds rowBounds = RowBoundsBuilder.build(queryDTO.getPageNo(), queryDTO.getPageSize());
        return new PageBeanAssembler().toBean(receiptDAO.selectExpiredGoods(queryDTO, rowBounds));
    }

    @Override
    public List<ReceiptItemDTO> queryDetail(String receiptCode) {
        List<ReceiptItemEntity> lists = receiptItemRepository.findAllByReceiptCode(receiptCode);
        ArrayList<ReceiptItemDTO> dtos = new ArrayList<>();
        for (ReceiptItemEntity list : lists) {
            ReceiptItemDTO receiptItemInfoDTO = new ReceiptItemDTO();
            BeanUtils.copy(list, receiptItemInfoDTO);
            dtos.add(receiptItemInfoDTO);
        }
        return dtos;
    }

    @Override
    public PageBean<ReceiptDTO> list(QueryByRoleDTO search) {
        RowBounds rowBounds = RowBoundsBuilder.build(1, Integer.MAX_VALUE);
        search.setTransStatus(ReceiptStatusEnum.Y.getCode());
        Page<ReceiptDTO> list = receiptDAO.list(search, rowBounds);
        return new PageBeanAssembler().toBean(list);
    }

    @Override
    public void addOutStockCode(String receiptCode, String outstockCode) {
        receiptApplication.addOutStockCode(receiptCode, outstockCode);
    }

    @Override
    public void addExpectedReceiptTime(String receiptCode, Date expectedReceiptTime) {
        receiptApplication.addExpectedReceiptTime(receiptCode, expectedReceiptTime);
    }

    @Override
    public void modifyTransStatus(String receiptCode, Integer transStatus) {
        receiptApplication.modifyTransStatus(receiptCode, transStatus);
    }

    @Override
    public void batchSaveReceipt(List<ReceiptAddDTO> list) {
        receiptApplication.batchSaveReceipt(list);
    }

    @Override
    @Transactional
    public boolean purchaseReceipt(ReceiptAddDTO dto) {
        LOGGER.info("start ------------------ purchaseReceipt ------------------ dto:{}", JSON.toJSON(dto));
        int count = receiptRepository.countByTrackCodeAndStatus(dto.getTrackCode(), ReceiptStatusEnum.Y);
        Validate.isTrue(count == 0, "该采购单已经执行入库操作，不能重复操作");

        ReceiptEntity entity = toReceiptEntity(dto);

        // 保存入库单
        receiptRepository.save(entity);

        List<ItemDTO> items = new ArrayList<>();
        // 保存入库明细
        for (ReceiptItemAddDTO itemDTO : dto.getItems()) {
            ReceiptItemEntity itemEntity = toReceiptItemEntity(entity.getStoreCode(), dto, itemDTO);
            receiptItemRepository.save(itemEntity);

            ItemDTO item = new ItemDTO();
            item.setGoodsCode(itemEntity.getGoodsCode());
            item.setOrderNum(itemEntity.getNeedNum());
            item.setRealNum(itemEntity.getRealNum());
            item.setUnits(itemEntity.getUnitsName());
            items.add(item);
        }

        // 更新采购入库单
        updatePurchaseIn(dto, entity);

        // 更新库存数量
        StockOrderDTO stockOrderDTO = new StockOrderDTO();
        stockOrderDTO.setGroupCode(entity.getGroupCode());
        stockOrderDTO.setStoreCode(entity.getStoreCode());
        stockOrderDTO.setWarehouseCode(entity.getWarehouseCode());
        stockOrderDTO.setOrderCode(dto.getReceiptCode());
        stockOrderDTO.setStatus(ReceiptStatusEnum.Y.getDesc());
        stockOrderDTO.setItems(items);
        stockLogicService.directInStock(stockOrderDTO, StockRecordTypeEnum.PURCHASE_IN);

        LOGGER.info("end ------------------ purchaseReceipt ------------------ ");
        return true;
    }

    /**
     * 入库单
     *
     * @param dto
     * @return
     */
    private ReceiptEntity toReceiptEntity(ReceiptAddDTO dto) {
        WarehouseInfo warehouseInfo = warehouseService.checkGet(dto.getWarehouseCode());
        SupplierInfo supplierInfo = supplierService.getSupplierInfo(warehouseInfo.getGroupCode(), dto.getSupplierCode());
        Date nowDate = new Date();
        ReceiptEntity entity = new ReceiptEntity();
        entity.setReceiptCode(dto.getReceiptCode());
        entity.setTrackCode(dto.getTrackCode());
        entity.setSupplierCode(supplierInfo.getSupplierCode());
        entity.setSupplierName(supplierInfo.getSupplierName());
        entity.setWarehouseCode(warehouseInfo.getWarehouseCode());
        entity.setWarehouseName(warehouseInfo.getWarehouseName());
        entity.setCityId(warehouseInfo.getCityId());
        entity.setCityName(warehouseInfo.getCity());
        entity.setStoreCode(warehouseInfo.getStoreCode());
        entity.setGroupCode(warehouseInfo.getGroupCode());
        entity.setType(ReceiptTypeEnum.PURCHASE_IN);
        entity.setStatus(ReceiptStatusEnum.Y);
        entity.setReceiptTime(nowDate);
        entity.setCreateTime(nowDate);
        entity.setRemark(dto.getRemark());
        return entity;
    }

    /**
     * 入库明细
     *
     * @param storeCode
     * @param dto
     * @param itemDTO
     */
    private ReceiptItemEntity toReceiptItemEntity(String storeCode, ReceiptAddDTO dto, ReceiptItemAddDTO itemDTO) {
        GoodsInfo goodsInfo = goodsHelper.checkGetGoods(storeCode, itemDTO.getProductCode());
        ReceiptItemEntity itemEntity = new ReceiptItemEntity();
        BeanUtils.copy(goodsInfo, itemEntity);
        if (StringUtils.isBlank(itemEntity.getGoodsName())) {
            itemEntity.setGoodsName(goodsInfo.getProductName());
        }
        itemEntity.setReceiptCode(dto.getReceiptCode());
        itemEntity.setNeedNum(itemDTO.getNum());
        itemEntity.setRealNum(itemDTO.getNum());

        PurchaseInOrderDetailEntity detailEntity = purchaseInOrderDetailRepository.findByPurchaseInCodeAndGoodsCode(dto.getTrackCode(), goodsInfo.getGoodsCode());
        org.apache.commons.lang3.Validate.notNull(detailEntity, "采购入库详情不存在：" + dto.getTrackCode() + ":" + goodsInfo.getGoodsCode());

        itemEntity.setTotalCost(detailEntity.getOriginalPrice() == null ? BigDecimal.ZERO : itemDTO.getNum().multiply(detailEntity.getOriginalPrice()).setScale(2, RoundingMode.HALF_UP));
        itemEntity.setTotalTaxCost(detailEntity.getRatePrice() == null ? BigDecimal.ZERO : itemDTO.getNum().multiply(detailEntity.getRatePrice()).setScale(2, RoundingMode.HALF_UP));
        itemEntity.setProductionDate(itemDTO.getProductionDate());
        if (itemDTO.getProductionDate() != null && goodsInfo.getShelfLife() != null) {
            itemEntity.setExpirationDate(DateUtil.addDay(itemDTO.getProductionDate(), goodsInfo.getShelfLife()));
        }
        return itemEntity;
    }

    /**
     * 更新采购入库单
     *
     * @param dto
     * @param entity
     */
    private void updatePurchaseIn(ReceiptAddDTO dto, ReceiptEntity entity) {
        PurchaseInUpdateDTO purchaseInUpdateDTO = new PurchaseInUpdateDTO();
        purchaseInUpdateDTO.setPurchaseInCode(entity.getTrackCode());
        purchaseInUpdateDTO.setStoreCode(entity.getStoreCode());
        purchaseInUpdateDTO.setGroupCode(entity.getGroupCode());
        List<PurchaseInDetailUpdateDTO> detailList = new ArrayList<>();
        for (ReceiptItemAddDTO itemDTO : dto.getItems()) {
            PurchaseInDetailUpdateDTO detail = new PurchaseInDetailUpdateDTO();
            detail.setProductCode(itemDTO.getProductCode());
            detail.setReceiptCode(entity.getReceiptCode());
            detail.setReceiptQty(itemDTO.getNum());
            detailList.add(detail);
        }
        purchaseInUpdateDTO.setDetailList(detailList);
        purchaseInApplication.updateReceiptQty(purchaseInUpdateDTO);
    }
}
