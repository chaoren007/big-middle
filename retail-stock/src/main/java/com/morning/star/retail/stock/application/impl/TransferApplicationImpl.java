package com.morning.star.retail.stock.application.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.gson.Gson;
import com.morning.star.retail.base.poi.ExcelUtil;
import com.morning.star.retail.bean.AdminLoginContent;
import com.morning.star.retail.bean.ImportBaseModel;
import com.morning.star.retail.enums.OriginalType;
import com.morning.star.retail.objectcopier.ObjectCopier;
import com.morning.star.retail.stock.application.OutStockApplication;
import com.morning.star.retail.stock.application.TransferApplication;
import com.morning.star.retail.stock.dto.OutstockFormDTO;
import com.morning.star.retail.stock.dto.OutstockOrderDetailDTO;
import com.morning.star.retail.stock.dto.TransferFormDTO;
import com.morning.star.retail.stock.dto.TransferItemDTO;
import com.morning.star.retail.stock.entity.TransferEntity;
import com.morning.star.retail.stock.entity.TransferItemEntity;
import com.morning.star.retail.stock.entity.repository.TransferItemRepository;
import com.morning.star.retail.stock.entity.repository.TransferRepository;
import com.morning.star.retail.stock.enums.OutstockStatusEnum;
import com.morning.star.retail.stock.enums.OutstockTypeEnum;
import com.morning.star.retail.stock.enums.TransferStatus;
import com.morning.star.retail.stock.helper.StockGoodsHelper;
import com.morning.star.retail.stock.helper.StoreService;
import com.morning.star.retail.stock.helper.vo.GoodsInfo;
import com.morning.star.retail.stock.helper.vo.StoreInfo;
import com.morning.star.retail.util.Json;
import com.morning.star.retail.util.MultipartFileWrapper;
import com.morning.star.retail.util.StringUtil;
import com.morning.star.retail.util.UniqueNoUtils;
import com.morning.star.retail.utils.entity.BeanUtils;

@Service
public class TransferApplicationImpl implements TransferApplication {
    private static final Gson GSON = new Gson();
    private static final Logger LOGGER = LoggerFactory.getLogger(TransferApplicationImpl.class);

    @Autowired
    private StockGoodsHelper goodsService;
    @Autowired
    private StoreService storeService;
    @Autowired
    private OutStockApplication outstockLogicService;
    @Autowired
    private TransferRepository transferRepository;
    @Autowired
    private TransferItemRepository itemRepository;

    @Override
    @Transactional
    public boolean save(TransferFormDTO formDTO, TransferStatus status) {
        LOGGER.info(" start --------- TransferLogicService.save() --------- formDTO:{}", GSON.toJson(formDTO));
        checkTransferNum(formDTO.getItems(), status);
        checkRepeatData(formDTO.getItems());

        TransferEntity orderEntity = transferRepository.getByTransferCode(formDTO.getTransferCode());
        List<TransferItemEntity> items = formDTO.getItems().stream().map(dto -> toTransferDetail(formDTO, dto)).collect(Collectors.toList());
        if (orderEntity != null) { // 调拨单存在
            Validate.isTrue(TransferStatus.DRAFT.equals(orderEntity.getStatus()), "该调拨单当前处于非草稿状态，不能执行编辑操作"); // 检查当前状态是否可编辑
//            itemRepository.deleteByTransferCode(formDTO.getTransferCode()); // 删除调拨明细

            orderEntity.getItems().clear();
            orderEntity.getItems().addAll(items);
        } else { // 调拨单不存在
            orderEntity = new TransferEntity();
            BeanUtils.copy(formDTO, orderEntity);
            orderEntity.setItems(items);
        }

        orderEntity.setStatus(status);
        // 新增或修改调拨单，初始化调拨单明细数据
        transferRepository.save(orderEntity);

        // 初始化调拨单明细数据
//        saveItems(formDTO);

        LOGGER.info(" end --------- TransferLogicService.save() --------- ");
        return true;
    }

    private void saveItems(TransferFormDTO formDTO) {
        formDTO.getItems().forEach(itemDTO -> {
            TransferItemEntity detailEntity = itemRepository.getByTransferCodeAndGoodsCode(formDTO.getTransferCode(), itemDTO.getGoodsCode());
            Validate.isTrue(detailEntity == null, String.format("该调拨商品【编码：%s】已存在", itemDTO.getGoodsCode()));
            itemRepository.save(toTransferDetail(formDTO, itemDTO));
        });
    }

    private TransferItemEntity toTransferDetail(TransferFormDTO formDTO, TransferItemDTO itemDTO) {
        GoodsInfo goodsInfo = checkGetGoods(itemDTO.getSapProductCode(), formDTO.getReceiverCode());
        TransferItemEntity entity = new TransferItemEntity();
        BeanUtils.copy(goodsInfo, entity);
        entity.setTransferCode(formDTO.getTransferCode());
        entity.setNum(itemDTO.getNum());
        return entity;
    }

    @Override
    @Transactional
    public boolean audit(TransferFormDTO formDTO, TransferStatus status) {
        LOGGER.info(" start --------- TransferLogicService.audit() --------- formDTO:{}", GSON.toJson(formDTO));
        TransferEntity orderEntity = checkQueryOne(formDTO.getTransferCode());
        Validate.isTrue(TransferStatus.WAIT_AUDIT.equals(orderEntity.getStatus()), "该调拨单处于非待审核状态，不能执行审核操作"); // 检查调拨单状态

        orderEntity.setStatus(status);

        if (TransferStatus.AUDIT_SUCCESS.equals(status)) { // 审核通过
            Validate.isTrue(!orderEntity.getReceiverCode().equals(formDTO.getSenderCode()), "调入门店不能是调出门店");

            // 检查门店
            StoreInfo storeInfo = storeService.getStore(formDTO.getSenderCode());
            Validate.isTrue(storeInfo != null, String.format("该门店【编码：%s】不存在", formDTO.getSenderCode()));

            orderEntity.setSenderCode(storeInfo.getStoreCode());
            orderEntity.setSenderName(storeInfo.getStoreName());
            String outstockCode = UniqueNoUtils.next(UniqueNoUtils.UniqueNoType.OSC);
            orderEntity.setOutstockCode(outstockCode);

            transferRepository.save(orderEntity);
            // 生成出库单（已审核状态）
            List<TransferItemEntity> items = itemRepository.getByTransferCode(orderEntity.getTransferCode());
            LOGGER.info("outstockLogicService.save" + Json.toJson(toOutstockOrder(outstockCode, orderEntity, formDTO, items, storeInfo)));
//            outstockLogicService.save(toOutstockOrder(outstockCode, orderEntity, formDTO, items, storeInfo));
        } else { // 审核失败
            transferRepository.save(orderEntity);
        }

        LOGGER.info(" end --------- TransferLogicService.audit() --------- ");
        return true;
    }

    /**
     * 初始化出库单数据
     *
     * @param outstockCode
     * @param orderEntity
     * @param formDTO
     * @param items
     * @param storeInfo
     * @return
     */
    private OutstockFormDTO toOutstockOrder(String outstockCode, TransferEntity orderEntity, TransferFormDTO formDTO,
                                            List<TransferItemEntity> items, StoreInfo storeInfo) {
        OutstockFormDTO outstockFormDTO = new OutstockFormDTO();
        outstockFormDTO.setOutstockCode(outstockCode);
        outstockFormDTO.setGroupCode(orderEntity.getGroupCode());
        outstockFormDTO.setReceiverCode(orderEntity.getReceiverCode());
        outstockFormDTO.setReceiverName(orderEntity.getReceiverName());
        outstockFormDTO.setSenderCode(storeInfo.getStoreCode());
        outstockFormDTO.setSenderName(storeInfo.getStoreName());
        outstockFormDTO.setStatus(OutstockStatusEnum.AUDIT_SUCCESS.getCode());
        outstockFormDTO.setType(OutstockTypeEnum.TRANSFER.getCode());
        List<OutstockOrderDetailDTO> list = new ArrayList<>(items.size());
        items.forEach(entity -> {
            OutstockOrderDetailDTO dto = new OutstockOrderDetailDTO();
            BeanUtils.copy(entity, dto);
            dto.setGoodsName(entity.getProductName());
            dto.setUnits(entity.getUnitsName());
            dto.setInitialNum(entity.getNum());
            list.add(dto);
        });
        outstockFormDTO.setOutstockOrderDetailDTO(list);
        return outstockFormDTO;
    }

    @Override
    public List<TransferItemDTO> getImportData(MultipartFileWrapper importFile, AdminLoginContent content) {
        LOGGER.info(" start --------- TransferLogicService.getImportData() --------- ");
        List<ImportBaseModel> modeList = new ArrayList<>();
        modeList.add(ImportBaseModel.gernateModel(0, "sapProductCode", "SAP编码"));
        modeList.add(ImportBaseModel.gernateModel(1, "num", "调拨数量"));
        List<Map<String, Object>> datas = ExcelUtil.readXLSData(importFile, OriginalType.XLSX, modeList);

        Map<String, BigDecimal> map = new HashMap<>();
        for (Map<String, Object> data : datas) {
            if (data.get("sapProductCode") == null || StringUtils.isBlank(data.get("sapProductCode").toString().trim())) {
                continue;
            }
            BigDecimal num = BigDecimal.ZERO;
            if (data.get("num") != null && StringUtils.isNotBlank(data.get("num").toString().trim())
                    && new BigDecimal(data.get("num").toString()).compareTo(BigDecimal.ZERO) == 1
                    ) {
                num = new BigDecimal(data.get("num").toString());
            }
            String sapProductCode = data.get("sapProductCode").toString();
            if (map.get(sapProductCode) != null) { // upc是否重复，若出现N条重复，则只导入一条，且需求调拨数量为0
                num = BigDecimal.ZERO;
            }
            map.put(sapProductCode, num);
        }

        List<TransferItemDTO> list = new ArrayList<>();
        List<String> sapProductCodes = new ArrayList<>();
        for (Map.Entry<String, BigDecimal> entry : map.entrySet()) {
            GoodsInfo goodsInfo = goodsService.getBySapProductCode(entry.getKey(), content.getStoreCode());
            if (goodsInfo == null) { // upc对应货品信息不存在
                sapProductCodes.add(entry.getKey());
                continue;
            }
            TransferItemDTO itemDTO = ObjectCopier.copyObject(TransferItemDTO.class, goodsInfo);
            itemDTO.setNum(entry.getValue());
            list.add(itemDTO);
        }
        StringBuffer remark = new StringBuffer();
        if (!sapProductCodes.isEmpty()) {
            remark.append("以下SAP编码").append(sapProductCodes.toString()).append("对应货品信息不存在，未导入，请确认！");
        }

        Validate.isTrue(StringUtils.isBlank(remark.toString()), remark.toString());

        LOGGER.info(" end --------- TransferLogicService.getImportData() --------- ");
        return list;
    }

    /**
     * 检查调拨数量
     *
     * @param list
     * @param status
     */
    private void checkTransferNum(List<TransferItemDTO> list, TransferStatus status) {
        if (TransferStatus.DRAFT.equals(status)) {
            return;
        }
        for (TransferItemDTO itemDTO : list) {
            Validate.isTrue(itemDTO.getNum() != null && itemDTO.getNum().compareTo(BigDecimal.ZERO) > 0, String.format("该调拨商品【编码：%s】调拨数量须大于0", itemDTO.getGoodsCode()));
        }
    }

    /**
     * 检查重复提交数据
     *
     * @param list
     */
    private void checkRepeatData(List<TransferItemDTO> list) {
        Map<String, Long> map = list.stream().collect(Collectors.groupingBy(TransferItemDTO::getSapProductCode, Collectors.counting()));
        StringBuilder goodsCodes = new StringBuilder();
        map.forEach((k, v) -> {
            if (v > 1) {
                goodsCodes.append(k).append("，");
            }
        });

        org.apache.commons.lang.Validate.isTrue(StringUtils.isBlank(goodsCodes.toString()), String.format("提交商品【编码：%s】存在重复，请检查", StringUtil.removeLastSpliter(goodsCodes.toString(), "，")));
    }

    /**
     * 查询并校验调拨单
     *
     * @param transferCode
     * @return
     */
    @Override
    public TransferEntity checkQueryOne(String transferCode) {
        TransferEntity entity = transferRepository.getByTransferCode(transferCode);
        Validate.isTrue(entity != null, String.format("该调拨单【编码：%s】不存在", transferCode));
        return entity;
    }

    @Override
    public TransferEntity getTran(String outstockCode) {
        return transferRepository.getByOutstockCode(outstockCode);
    }

    /**
     * 检查商品
     *
     * @param goodsCode
     * @return
     */
    private GoodsInfo checkGetGoods(String goodsCode) {
        GoodsInfo goodsInfo = goodsService.getGoods(goodsCode);
        Validate.isTrue(goodsInfo != null, String.format("该商品【编码：%s】不存在", goodsCode));
        return goodsInfo;
    }

    /**
     * 检查商品
     *
     * @param sapProductCode
     * @return
     */
    private GoodsInfo checkGetGoods(String sapProductCode, String storeCode) {
        GoodsInfo goodsInfo = goodsService.getBySapProductCode(sapProductCode, storeCode);
        Validate.isTrue(goodsInfo != null, String.format("该商品【SAP编码：%s】不存在", sapProductCode));
        return goodsInfo;
    }

}
