package com.morning.star.retail.application.impl;

import com.github.pagehelper.Page;
import com.morning.star.retail.application.SupBusItemApplication;
import com.morning.star.retail.dao.SupplierDAO;
import com.morning.star.retail.dto.*;
import com.morning.star.retail.entity.SupplierBusItemEntity;
import com.morning.star.retail.entity.SupplierBusShipEntity;
import com.morning.star.retail.entity.repository.SupplierBusItemRespository;
import com.morning.star.retail.entity.repository.SupplierBusShipRespository;
import com.morning.star.retail.enums.SupBusItemStatusEnum;
import com.morning.star.retail.facade.dto.supply.GoodsSupplyDTO;
import com.morning.star.retail.facade.dto.supply.GoodsSupplySetDTO;
import com.morning.star.retail.helper.BusItemHelper;
import com.morning.star.retail.order.facade.dto.BusOrderDTO;
import com.morning.star.retail.utils.entity.BeanUtils;
import com.morning.star.retail.utils.page.PageBean;
import com.morning.star.retail.utils.page.PageBeanAssembler;
import com.morning.star.retail.utils.page.RowBoundsBuilder;
import com.morning.star.retail.utils.zk.zkUtils;
import org.apache.commons.lang.Validate;
import org.apache.ibatis.session.RowBounds;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Service
public class SupBusItemApplicationImpl implements SupBusItemApplication {
    @Autowired
    private BusItemHelper busItemHelper;
    @Autowired
    private SupplierBusItemRespository supplierBusItemRespository;
    @Autowired
    private SupplierBusShipRespository supplierBusShipRespository;
    @Autowired
    private SupplierDAO supplierDAO;

    private static final Logger log = LoggerFactory.getLogger(SupBusItemApplicationImpl.class);

    @Override
    public void insertSupBusItem() {

        BusOrderDTO byDealWith = busItemHelper.getByDealWith();
        List<BusOrderDTO.Detail> detailList = byDealWith.getDetailList();
        List<Long> list = new ArrayList<>();
        for (BusOrderDTO.Detail detail : detailList) {
            list.add(detail.getId());
            //避免被copy进去
            detail.setId(null);
            BigDecimal count = new BigDecimal(detail.getCount());

            GoodsSupplyDTO supInfo = busItemHelper.getSupInfo(detail.getpCode());
            if (supInfo == null) {
                throw new RuntimeException("数据异常,查不到供应商");
            }

            SupplierBusItemEntity byPCodeAndCity = supplierBusItemRespository.getByPCodeAndCityIdAndStatusAndSupplierCode(detail.getpCode(), detail.getCityId(), SupBusItemStatusEnum.NOTSHIPPED.getCode(), supInfo.getSupplierCode());
            if (byPCodeAndCity != null) {
                BigDecimal newCount = byPCodeAndCity.getCount().add(count);
                byPCodeAndCity.setCount(newCount);
                byPCodeAndCity.setSupplyAmount(newCount.multiply(byPCodeAndCity.getSupplyPrice()));
                supplierBusItemRespository.save(byPCodeAndCity);
            } else {
                String supplyCode = "";
                try {
                    supplyCode = "GH" + new zkUtils().zkIncr("supplyCode", 5);
                } catch (Exception e) {
                    supplyCode = "GH" + System.currentTimeMillis();
                }
                BigDecimal supplyPrice = BigDecimal.ZERO;
                List<GoodsSupplySetDTO> areaDetailList = supInfo.getAreaDetailList();
                for (GoodsSupplySetDTO goodsSupplySetDTO : areaDetailList) {
                    if (detail.getCityId().equals(goodsSupplySetDTO.getCityId())) {
                        supplyPrice = goodsSupplySetDTO.getPrice();
                    }
                }

                BigDecimal supplyAmount = supplyPrice.multiply(count);
                SupplierBusItemEntity saveEntity = new SupplierBusItemEntity();
                BeanUtils.copy(detail, saveEntity);
                saveEntity.setSupplyCode(supplyCode);
                saveEntity.setStatus(SupBusItemStatusEnum.NOTSHIPPED.getCode());
                saveEntity.setSupplierCode(supInfo.getSupplierCode());
                saveEntity.setSupplyPrice(supplyPrice);
                saveEntity.setSupplyAmount(supplyAmount);
                saveEntity.setCount(count);
                saveEntity.setSupplierName(supInfo.getSupplierName());
                supplierBusItemRespository.save(saveEntity);
            }
        }
        busItemHelper.updateStatus(list);
    }

    @Override
    public PageBean<BusSupplyGoodsDTO> getSupplyGoods(BusSupplyGoodsQueryDTO dto) {
        RowBounds rowBounds = RowBoundsBuilder.build(dto.getPageNo(), dto.getPageSize());
        Page<BusSupplyGoodsDTO> list = supplierDAO.getSupplyGoods(dto, rowBounds);
        List<BusSupplyGoodsDTO> result = list.getResult();
        for (BusSupplyGoodsDTO supplyBusGoodsDTO : result) {
            supplyBusGoodsDTO.setStatusName(SupBusItemStatusEnum.getEnum(supplyBusGoodsDTO.getStatus()).getDesc());
            supplyBusGoodsDTO.setTypeFrom("销售");
        }

        return new PageBeanAssembler().toBean(list);
    }

    @Override
    public void comfire(BusSupplyConfireDTO dto) {
        log.info("======================================");
        log.info(dto.getStartTime() + "/" + dto.getEndTime());
        log.info("======================================");
        HashSet<String> set = new HashSet<>();
        String cityId = "";
        String cityName = "";
        String shipCode = "";
        String supplierName = "";
        try {
            shipCode = "FH" + new zkUtils().zkIncr("shipCode", 5);
        } catch (Exception e) {
            shipCode = "FH" + System.currentTimeMillis();
        }
        String[] split = dto.getSupplyCodes().split(",");
        for (String supplyCode : split) {
            SupplierBusItemEntity entity = supplierBusItemRespository.getBySupplyCode(supplyCode);
            Validate.isTrue(entity.getSupplierCode().equals(dto.getSupplierCode()), "供应商编码错误");
            set.add(entity.getCityId());
            cityId = entity.getCityId();
            cityName = entity.getCityName();
            entity.setShipCode(shipCode);
            entity.setStatus(SupBusItemStatusEnum.SHIPPED.getCode());
            supplierName = entity.getSupplierName();
            //Calendar calendar = Calendar.getInstance();
            //entity.setShipTime(calendar.getTime());
            //calendar.add(Calendar.DAY_OF_YEAR,7);
            //entity.setOrderTime(calendar.getTime());
            supplierBusItemRespository.save(entity);
        }
        Validate.isTrue(set.size() == 1, "列表中存在多个发货城市");

        SupplierBusShipEntity entity = new SupplierBusShipEntity();
        BeanUtils.copy(dto, entity);
        entity.setCityId(cityId);
        entity.setCityName(cityName);
        entity.setShipCode(shipCode);
        entity.setSupplierCode(dto.getSupplierCode());
        entity.setSupplierName(supplierName);
        supplierBusShipRespository.save(entity);

    }

    @Override
    public List<String> listDepots(List<String> dto) {
        HashSet<String> cityId = new HashSet<>();
        List<String> depotCodes = new ArrayList<>();
        for (String str : dto) {
            SupplierBusItemEntity entity = supplierBusItemRespository.getBySupplyCode(str);
            cityId.add(entity.getCityId());
            String cityName = entity.getCityName();
            String depotName = entity.getDepotName();
            if (!depotCodes.contains(cityName + depotName)) {
                depotCodes.add(cityName + depotName);
            }
        }
        Validate.isTrue(cityId.size() == 1, "列表中存在多个发货城市");
        return depotCodes;
    }

    @Override
    public PageBean<BusShipGoodsDTO> getShipGoods(BusShipGoodsQueryDTO dto) {
        RowBounds rowBounds = RowBoundsBuilder.build(dto.getPageNo(), dto.getPageSize());
        Page<BusShipGoodsDTO> list = supplierDAO.getShipGoods(dto, rowBounds);
        return new PageBeanAssembler().toBean(list);
    }

    @Override
    public BusSupplyGoodsDetailDTO getSupplyGoodsDetail(String supplyCode) {
        BusSupplyGoodsDetailDTO dto = new BusSupplyGoodsDetailDTO();
        BusShipGoodsDTO shipGoodsDTO = new BusShipGoodsDTO();
        SupplierBusItemEntity bySupplyCode = supplierBusItemRespository.getBySupplyCode(supplyCode);
        BeanUtils.copy(bySupplyCode, dto);
        if (bySupplyCode.getShipCode() != null) {
            SupplierBusShipEntity byShipCode = supplierBusShipRespository.getByShipCode(bySupplyCode.getShipCode());
            BeanUtils.copy(byShipCode, shipGoodsDTO);
        }
        dto.setBusShipGoodsDTO(shipGoodsDTO);

        return dto;
    }

    @Override
    public BusShipGoodsDetailDTO getShipGoodsDetail(String shipCode) {
        BusShipGoodsDetailDTO dto = new BusShipGoodsDetailDTO();
        List<BusSupplyGoodsDTO> list = new ArrayList<>();
        SupplierBusShipEntity entity = supplierBusShipRespository.getByShipCode(shipCode);
        if (entity != null) {
            BeanUtils.copy(entity, dto);
            List<SupplierBusItemEntity> byShipCode = supplierBusItemRespository.getByShipCode(shipCode);
            for (SupplierBusItemEntity supplierBusItemEntity : byShipCode) {
                BusSupplyGoodsDTO busSupplyGoodsDTO = new BusSupplyGoodsDTO();
                BeanUtils.copy(supplierBusItemEntity, busSupplyGoodsDTO);
                list.add(busSupplyGoodsDTO);
            }
            dto.setList(list);
        }
        return dto;
    }

    @Override
    public List<BusSupplyGoodsNumDTO> getsupplyStatistics(String supplierCode) {
        return supplierDAO.getsupplyStatistics(supplierCode);
    }

    @Transactional
    @Override
    public void taskBus() {
        supplierDAO.updateToDealing();
        BusSupplyGoodsDTO dto = supplierDAO.taskBus();
        supplierDAO.updateToDealed();
        GoodsSupplyDTO supInfo = busItemHelper.getSupInfo(dto.getpCode());
        List<GoodsSupplySetDTO> areaDetailList = supInfo.getAreaDetailList();
        GoodsSupplySetDTO detail = new GoodsSupplySetDTO();
        for (GoodsSupplySetDTO goodsSupplySetDTO : areaDetailList) {
            if (dto.getCityId().equals(goodsSupplySetDTO.getCityId())) {
                detail = goodsSupplySetDTO;
            }
        }
        SupplierBusItemEntity entity = supplierBusItemRespository.getByCityIdAndPCodeAndPriodAndStatusAndVersionCode(dto.getCityId(), dto.getpCode(), dto.getPriod(), 0, dto.getVersionCode());
        if (entity == null) {
            entity = new SupplierBusItemEntity();
            entity.setCityId(dto.getCityId());
            entity.setpCode(dto.getpCode());
            entity.setPriod(dto.getPriod());
            entity.setStatus(0);
            entity.setVersionCode(dto.getVersionCode());
            entity.setCount(dto.getCount());
            entity.setpName(dto.getpName());
            entity.setSupplierCode(supInfo.getSupplierCode());
            entity.setSupplierName(supInfo.getSupplierName());
            entity.setSupplyPrice(detail.getPrice());
            entity.setDepotCode(dto.getDepotCode());
            entity.setDepotName(dto.getDepotName());
            entity.setRate(busItemHelper.getCategoryRate(supInfo.getCategoryId3()));
        } else {
            entity.setCount(entity.getCount().add(dto.getCount()));
        }
        BigDecimal price = entity.getSupplyPrice();
        BigDecimal rate = entity.getRate();
        BigDecimal count = entity.getCount();
        log.info("===============price:" + price);
        log.info("===============rate:" + rate);
        log.info("===============count:" + count);

        BigDecimal supplyAmount = price.multiply(count);
        BigDecimal payAmount = rate.multiply(count);
        BigDecimal realAmount = supplyAmount.subtract(payAmount);

        entity.setSupplyAmount(supplyAmount);
        entity.setPayAmount(payAmount);
        entity.setRealAmount(realAmount);
        supplierBusItemRespository.save(entity);
    }

}

