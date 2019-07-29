package com.morning.star.retail.stock.application.impl;

import com.morning.star.retail.facade.dto.receipt.ReceiptImeiDTO;
import com.morning.star.retail.facade.dto.receipt.SureReceiptDTO;
import com.morning.star.retail.stock.application.OutStockApplication;
import com.morning.star.retail.stock.application.ReceiptApplication;
import com.morning.star.retail.stock.dto.*;
import com.morning.star.retail.stock.entity.*;
import com.morning.star.retail.stock.entity.repository.*;
import com.morning.star.retail.stock.enums.ReceiptDiffStatusEnum;
import com.morning.star.retail.stock.enums.ReceiptTypeEnum;
import com.morning.star.retail.stock.helper.*;
import com.morning.star.retail.stock.helper.vo.GoodsInfo;
import com.morning.star.retail.stock.helper.vo.WarehouseInfo;
import com.morning.star.retail.stock.listener.event.ReceiptAddEvent;
import com.morning.star.retail.stock.logicservice.StockLogicService;
import com.morning.star.retail.user.UserPermission;
import com.morning.star.retail.user.UserUtils;
import com.morning.star.retail.util.Context;
import com.morning.star.retail.util.Json;
import com.morning.star.retail.util.UniqueNoUtils;
import com.morning.star.retail.utils.entity.BeanUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.Validate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by kimhuhg.
 */
@Service
public class ReceiptApplicationImpl implements ReceiptApplication {
	private Logger log = LoggerFactory.getLogger(ReceiptApplicationImpl.class);

	@Autowired
	private StockLogicService stockLogicService;
	@Autowired
	private OutStockApplication outstockService;
	@Autowired
	private ReceiptRepository receiptRepository;

	@Autowired
	private ReceiptItemRepository receiptItemRepository;

	@Autowired
	private ReceiptDiffRepository receiptDiffRepository;

	@Autowired
	private ReceiptDiffItemRepository receiptDiffItemRepository;

	@Autowired
	private WaterRepository waterRepository;

	@Autowired
	private StockGoodsHelper stockGoodsHelper;

	@Autowired
	private IemiHelper iemiHelper;

	@Autowired
	private SupplierService supplierService;

	@Autowired
	private StoreService storeService;
	@Autowired
	private WarehouseService warehouseService;

	@Override
	@Transactional
	public String saveReceipt(ReceiptAddDTO receiptAddDTO) {
		//主表非空校验
		Validate.isTrue(receiptAddDTO.getReceiptType() != null, "入库类型不能为空");
		Validate.isTrue(StringUtils.isNotBlank(receiptAddDTO.getSupplierCode()), "入库供应商（调拨门店编码）不能为空");
		WarehouseInfo warehouseInfo = warehouseService.checkGet(receiptAddDTO.getWarehouseCode());
		//如果是调拨入库，查询门店上级数据并保存
		if (receiptAddDTO.getReceiptType().equals(ReceiptTypeEnum.TRANSFER_IN.getCode())) {
//            receiptAddDTO.setBusinessCode(storeInfo.getBusinessCode());
//            receiptAddDTO.setBusinessName(storeInfo.getBusinessName());
//            receiptAddDTO.setVcontainerCode(storeInfo.getVcontainerCode());
//            receiptAddDTO.setVcontainerName(storeInfo.getVcontainerName());
//            receiptAddDTO.setGroupCode(storeInfo.getGroupCode());
//            receiptAddDTO.setGroupName(storeInfo.getGroupName());
		}

		List<ReceiptItemAddDTO> lists = receiptAddDTO.getItems();
		// 检查商品明细是否存在
		Validate.notEmpty(lists, "入库单商品明细不存在");
		//新增入库单
		String receiptCode = UniqueNoUtils.next(UniqueNoUtils.UniqueNoType.RS);
		List<ReceiptItemEntity> items = new ArrayList<>();
		for (ReceiptItemAddDTO list : lists) {
			//非空校验
			Validate.isTrue(list.getNum() != null, "入库数量不能为空");
			ReceiptItemEntity item = new ReceiptItemEntity();
			BeanUtils.copy(list, item);
			//收集并校验信息
			GoodsInfo goods = stockGoodsHelper.checkGetGoods(warehouseInfo.getStoreCode(), list.getProductCode());
			if (receiptAddDTO.getReceiptType().equals(ReceiptTypeEnum.PURCHASE_IN.getCode())) {
				//校验供应商
//                SupplierItemInfo supplier = supplierService.getSupplierItemInfo(goods.getProductCode(), receiptAddDTO.getSupplierCode(), receiptAddDTO.getGroupCode());
//                Validate.isTrue(supplier != null, String.format("商品编码为(%s)的商品不属于所填供应商", goods.getGoodsCode()));
			}

			Validate.isTrue(list.getNum().compareTo(BigDecimal.ZERO) >= 0, "入库数量不能小于0");
			//称重校验并转换
			if (goods.getStandardType() == 1) {
//                if (StringUtils.isNotBlank(list.getReceiptUnits())) {
//                    Validate.isTrue(WeightUtil.getWeightList().contains(list.getGoodsCode()), "该入库单位非法");
//                    list.setQty(WeightUtil.get(list.getNum(), list.getReceiptUnits()));
//                } else {
//                    list.setQty(WeightUtil.get(list.getNum(), goods.getUnitsName()));
//                }
			}

			item.setPackSpecNum(goods.getPackSpecNum());
			item.setPackSpecUnits(goods.getPackSpecUnits());
			item.setProductCode(goods.getProductCode());
			item.setProductName(goods.getProductName());
			item.setProductType(goods.getProductType());
			item.setStandardType(goods.getStandardType());
			item.setUnitsId(goods.getUnitsId());
			item.setUnitsName(goods.getUnitsName());
			item.setUpcCode(goods.getUpcCode());
			item.setReceiptCode(receiptCode);
//            item.setSapProductCode(goods.getSapProductCode());
			items.add(item);
		}
		ReceiptEntity receiptEntity = new ReceiptEntity();
		BeanUtils.copy(receiptAddDTO, receiptEntity);
		if (receiptAddDTO.getReceiptType() == ReceiptTypeEnum.PURCHASE_IN.getCode()) {
//            SupplierInfo supplierInfo = supplierService.getSupplierInfo(receiptAddDTO.getGroupCode(), receiptAddDTO.getSupplierCode());
//            receiptEntity.setSupplierName(supplierInfo.getSupplierName());
		}
//		receiptEntity.setReceiptType(ReceiptTypeEnum.from(receiptAddDTO.getReceiptType()));
		//默认待配送状态
//		receiptEntity.setTransStatus(ReceiptStatusEnum.NO_DISTRIBUTION);
		receiptEntity.setReceiptCode(receiptCode);

		receiptRepository.save(receiptEntity);
		waterRepository.save(receiptEntity, ReceiptWaterEntity.class, String.format("入库流水(入库类型%s)", String.valueOf(receiptAddDTO.getReceiptType())));
		for (ReceiptItemEntity item : items) {
			receiptItemRepository.save(item);
		}
		ReceiptAddEventDTO receiptAddEventDTO = new ReceiptAddEventDTO();
		BeanUtils.copy(receiptAddDTO, receiptAddEventDTO);
		receiptAddEventDTO.setReceiptCode(receiptCode);
		receiptAddEventDTO.setItem(receiptAddDTO.getItems());

		new ReceiptAddEvent(receiptAddEventDTO).publish();
		return receiptCode;
	}

	@Override
	@Transactional
	public void waitReceipt(String receiptCode) {
		ReceiptEntity receiptEntity = receiptRepository.findOne(receiptCode);
		Validate.notNull(receiptEntity, "入库单不存在");
//		receiptEntity.setTransStatus(ReceiptStatusEnum.NO_DISTRIBUTION);

		receiptRepository.save(receiptEntity);
		waterRepository.save(receiptEntity, ReceiptWaterEntity.class, "待入库流水");
	}

	@Override
	@Transactional
	public void sureReceipt(SureReceiptDTO sureReceiptDTO, Map<String, List<ReceiptImeiDTO>> iemis) {
		/*List<ReceiptItemEntity> receiptItemEntitys = receiptItemRepository.findAllByReceiptCode(sureReceiptDTO.getReceiptCode());
		Validate.isTrue(receiptItemEntitys != null && receiptItemEntitys.size() != 0, "入库单商品明细不存在");
		ReceiptEntity receiptEntity = receiptRepository.findOne(sureReceiptDTO.getReceiptCode());
		UserUtils.group(receiptEntity.getGroupCode()).store(receiptEntity.getStoreCode()).msg("该入库单不可操作:"+sureReceiptDTO.getReceiptCode()).pass();
		Validate.notNull(receiptEntity, "该入库单不存在");
//		Validate.isTrue(receiptEntity.getStatus() == ReceiptStatusEnum.ARRIVED,
//				"该单不是已到货状态，不能入库");
		//设置入库状态为已入库
		receiptEntity.setStatus(ReceiptStatusEnum.Y);
		//更新入库时间
		receiptEntity.setReceiptTime(new Date());
		//更新入库单
		receiptRepository.save(receiptEntity);
		waterRepository.save(receiptEntity, ReceiptWaterEntity.class,"确定入库流水");

		List<SureReceiptDTO> items = sureReceiptDTO.getItem();

		//计算差异单
		List<ReceiptDiffItemInfoDTO> orderDetailList = new ArrayList<>();
		for (ReceiptItemEntity one : receiptItemEntitys) {
			SureReceiptDTO sureReceiptDTO = null;
			for (int i = 0; i < items.size(); i++) {
				 if (one.getGoodsCode().equals(items.get(i).getGoodsCode())) {
				 	sureReceiptDTO = items.get(i);
				 }
			}
			//入库数量
			BigDecimal receiptNum = BigDecimal.ZERO;
			//未入库的商品数量数量记为0
			if (sureReceiptDTO != null) {
				receiptNum = sureReceiptDTO.getQty();
			}

			//判断是否为要串码iemi的商品
			GoodsInfo goods = stockGoodsHelper.getGoods(one.getGoodsCode());
			if (goods.getIsSerialCode() == 1) {
				if (iemis.containsKey(goods.getGoodsCode())) {
					BigDecimal count = new BigDecimal(String.valueOf(iemis.get(goods.getGoodsCode()).size()));
					if (receiptNum.compareTo(count) == 0) {
						ArrayList<ImeiAddDTO> imeiAddDTOS = new ArrayList<>();
						List<ReceiptImeiDTO> imeiDTOS = iemis.get(goods.getGoodsCode());
						for (ReceiptImeiDTO imeiDTO : imeiDTOS) {
							ImeiAddDTO imeiAddDTO = new ImeiAddDTO();
							imeiAddDTO.setSapCode(goods.getSapProductCode());
							imeiAddDTO.setGroupCode(goods.getGroupCode());
							imeiAddDTO.setImeiCode(imeiDTO.getImei());
							imeiAddDTO.setStoreCode(goods.getStoreCode());
							imeiAddDTOS.add(imeiAddDTO);
						}
						log.info("确认入库要保存的串码："+Json.toJson(imeiAddDTOS));
						iemiHelper.addList(imeiAddDTOS,goods.getStoreCode(),goods.getGroupCode());
					} else {
						throw new IllegalArgumentException(String.format("确认入库失败!原因:商品(商品编码为:%s)导入串码数量(%s)与实际入库数量(%s)不一致",goods.getGoodsCode(),String.valueOf(iemis.get(goods.getGoodsCode()).size()),String.valueOf(receiptNum)));
					}
				} else {
					throw new IllegalArgumentException("确认入库失败!原因:商品(商品编码为:"+goods.getGoodsCode()+")没导入串码");
				}
			}

			//计算差异
			BigDecimal qty = one.getQty().subtract(receiptNum);
			//判断订单单个商品不可超过采购(调拨)数量
			Validate.isTrue(qty.compareTo(BigDecimal.ZERO) >= 0, String.format("该入库单的编码为(%s)的商品的实际入库数量(%s)大于预定入库数量(%s)", sureReceiptDTO.getReceiptCode(),String.valueOf(receiptNum),String.valueOf(one.getQty())));
			if (qty.compareTo(BigDecimal.ZERO) > 0) {
				ReceiptDiffItemInfoDTO receiptDiffItemInfoDTO = new ReceiptDiffItemInfoDTO();
				BeanUtils.copy(one, receiptDiffItemInfoDTO);
				receiptDiffItemInfoDTO.setDifferenceQty(qty);
				receiptDiffItemInfoDTO.setId(null);
				if (sureReceiptDTO.getProductionDate() != null && sureReceiptDTO.getShelfLife() != null) {
					receiptDiffItemInfoDTO.setShelfLife(sureReceiptDTO.getShelfLife());
					receiptDiffItemInfoDTO.setProductionDate(sureReceiptDTO.getProductionDate());
					receiptDiffItemInfoDTO.setExpirationDate(DateUtil.addDay(sureReceiptDTO.getProductionDate(), sureReceiptDTO.getShelfLife()));
				}
				orderDetailList.add(receiptDiffItemInfoDTO);
			}

			one.setRealQty(receiptNum);
			if (sureReceiptDTO.getProductionDate() != null && sureReceiptDTO.getShelfLife() != null) {
				one.setShelfLife(sureReceiptDTO.getShelfLife());
				one.setProductionDate(sureReceiptDTO.getProductionDate());
				one.setExpirationDate(DateUtil.addDay(sureReceiptDTO.getProductionDate(), sureReceiptDTO.getShelfLife()));
			}
			one.setReturnableQty(receiptNum);
			receiptItemRepository.save(one);
		}
		//判断是否有差异
		if (orderDetailList != null && orderDetailList.size() > 0) {
			ReceiptDiffInfoDTO receiptDiffInfoDTO = new ReceiptDiffInfoDTO();
			receiptDiffInfoDTO.setItem(orderDetailList);
			BeanUtils.copy(receiptEntity, receiptDiffInfoDTO);
			receiptDiffInfoDTO.setDiffStatus(0);
			saveReceiptDifference(receiptDiffInfoDTO);
		}

		//入库单写库存
		boolean isSuccess = receiptInStock(receiptEntity, receiptItemEntitys);
		Validate.isTrue(isSuccess, "确认入库失败,原因:库存保存失败");
		//反写出库单信息
		modifyOutStockOrder(receiptEntity);*/
	}

	/**
	 * 订单入库
	 *
	 * @param receiptEntity
	 * @param receiptDetailList
	 * @return
	 */
	private boolean receiptInStock(ReceiptEntity receiptEntity, List<ReceiptItemEntity> receiptDetailList) {
		StockOrderDTO stockOrderDTO = new StockOrderDTO();
		stockOrderDTO.setGroupCode(receiptEntity.getGroupCode());
		stockOrderDTO.setStoreCode(receiptEntity.getStoreCode());
		stockOrderDTO.setOrderCode(receiptEntity.getReceiptCode());
		stockOrderDTO.setStatus(receiptEntity.getStatus().getDesc());

		List<ItemDTO> items = new ArrayList<>();

		for (ReceiptItemEntity vo : receiptDetailList) {
			BigDecimal receiveQty = vo.getRealNum();
			ItemDTO item = new ItemDTO();
			item.setGoodsCode(vo.getGoodsCode());
			item.setOrderNum(vo.getNeedNum());
			item.setRealNum(receiveQty);
//            item.setPurchasePrice(vo.getPrice());


			List<SupplierItemDTO> supplierItems = new ArrayList<>();
			SupplierItemDTO supplierItem = new SupplierItemDTO();
			supplierItem.setGoodsCode(vo.getGoodsCode());
			supplierItem.setSupplierCode(receiptEntity.getSupplierCode());
			supplierItem.setSupplierName(receiptEntity.getSupplierName());
			supplierItem.setSalesType(null);
//            supplierItem.setOrderNum(vo.getNeedNum());
			supplierItem.setRealNum(receiveQty);
			supplierItems.add(supplierItem);


			item.setSupplierItems(supplierItems);

			items.add(item);
		}
		stockOrderDTO.setItems(items);


		//采购单入库写库存
		if (ReceiptTypeEnum.PURCHASE_IN.equals(receiptEntity.getType())) {
			return stockLogicService.purchaseInStock(stockOrderDTO);
		} else if (ReceiptTypeEnum.TRANSFER_IN.equals(receiptEntity.getType())) {
			return stockLogicService.transferInStock(stockOrderDTO);
		} else {
			return stockLogicService.otherIn(stockOrderDTO);
		}
	}

	/**
	 * 反写出库单信息
	 *
	 * @param order
	 * @return
	 */
	private void modifyOutStockOrder(ReceiptEntity order) {
		if (order.getType() != null && order.getType() == ReceiptTypeEnum.TRANSFER_IN) {
			outstockService.updateReceiptCode(order.getType().getDesc(), order.getReceiptCode());
		}
	}

	/**
	 * 修改入库可退数量
	 *
	 * @param receiptItemInfoDTO
	 * @return
	 */
	@Override
	public void modifyReceiptDetail(ReceiptItemDTO receiptItemInfoDTO) {
		Validate.isTrue(receiptItemInfoDTO != null && receiptItemInfoDTO.getId() != null, "入库细表id不能为空");
		Validate.isTrue(receiptItemInfoDTO != null && receiptItemInfoDTO.getReceiptCode() != null, "入库细表的入库单号不能为空");
		ReceiptEntity receiptEntity = receiptRepository.findOne(receiptItemInfoDTO.getReceiptCode());
		new UserPermission(UserUtils.currentUser())
			.tag("storeCode", receiptEntity.getStoreCode())
			.tag("groupCode", receiptEntity.getGroupCode())
			.msg("该入库细表不可操作:" + receiptItemInfoDTO.getId())
			.pass();
		ReceiptItemEntity one = receiptItemRepository.findOne(receiptItemInfoDTO.getId());
//        if (receiptItemInfoDTO.getReturnableQty() != null && receiptItemInfoDTO.getReturnableQty().compareTo(BigDecimal.ZERO) != 0) {
//            one.setReturnableQty(receiptItemInfoDTO.getReturnableQty());
//        }
		receiptItemRepository.save(one);
	}

	@Override
	public void saveReceiptDifference(ReceiptDiffInfoDTO receiptDifferenceDTO) {
		log.info("<-----------进入差异单处理------------->" + Json.toJson(receiptDifferenceDTO));
		List<ReceiptDiffItemInfoDTO> orderDetailList = receiptDifferenceDTO.getItem();

		// 检查商品明细是否存在
		Validate.notEmpty(receiptDifferenceDTO.getItem(), "入库差异单商品明细不存在");
//		Validate.isTrue(StringUtils.isEmpty(receiptDifferenceDTO.getReceiptCode()), "入库单号已存在");

		//新增入库差异单
		String receiptDifferenceCode = UniqueNoUtils.next(UniqueNoUtils.UniqueNoType.RDS);
		Validate.isTrue(!receiptDiffRepository.exists(receiptDifferenceCode), "存在相同编码的差异订单");

		List<ReceiptDiffItemEntity> items = new ArrayList<>();
		for (ReceiptDiffItemInfoDTO orderDetail : orderDetailList) {
			ReceiptDiffItemEntity detail = new ReceiptDiffItemEntity();
			BeanUtils.copy(orderDetail, detail);
			detail.setReceiptDiffCode(receiptDifferenceCode);
			items.add(detail);
		}

		ReceiptDiffEntity receiptDiffEntity = new ReceiptDiffEntity();
		BeanUtils.copy(receiptDifferenceDTO, receiptDiffEntity);
		receiptDiffEntity.setReceiptDiffCode(receiptDifferenceCode);
		receiptDiffEntity.setDiffStatus(ReceiptDiffStatusEnum.WAIT_WRITE);
//        receiptEntity.setItems(items);
		log.info("差异单数据:" + Json.toJson(receiptDifferenceDTO));
		receiptDiffRepository.save(receiptDiffEntity);
		waterRepository.save(receiptDiffEntity, ReceiptDiffWaterEntity.class, "新增差异单");
		for (ReceiptDiffItemEntity item : items) {
			receiptDiffItemRepository.save(item);
		}
	}

	@Override
	public void addOutStockCode(String receiptCode, String outstockCode) {
		ReceiptEntity one = receiptRepository.findOne(receiptCode);
		Validate.isTrue(one != null, "修改入库单不存在");
		new UserPermission(UserUtils.currentUser())
			.tag("storeCode", one.getStoreCode())
			.tag("groupCode", one.getGroupCode())
			.msg("该入库单不可操作")
			.pass();
		one.setTrackCode(outstockCode);
		receiptRepository.save(one);
	}

	@Override
	public void addExpectedReceiptTime(String receiptCode, Date expectedReceiptTime) {
		ReceiptEntity one = receiptRepository.findOne(receiptCode);
		Validate.isTrue(one != null, "修改入库单不存在");
		new UserPermission(UserUtils.currentUser())
			.tag("storeCode", one.getStoreCode())
			.tag("groupCode", one.getGroupCode())
			.msg("该入库单不可操作")
			.pass();
//		one.setExpectedReceiptTime(expectedReceiptTime);
		receiptRepository.save(one);
	}

	@Override
	public void modifyTransStatus(String receiptCode, Integer transStatus) {
		ReceiptEntity one = receiptRepository.findOne(receiptCode);
		Validate.isTrue(one != null, "修改入库单不存在");
		new UserPermission(UserUtils.currentUser())
			.tag("storeCode", one.getStoreCode())
			.tag("groupCode", one.getGroupCode())
			.msg("该入库单不可操作")
			.pass();
//		if (transStatus == ReceiptStatusEnum.IN_DISTRIBUTION.getCode()) {
//			one.setTransStatus(ReceiptStatusEnum.IN_DISTRIBUTION);
//		} else {
//			one.setTransStatus(ReceiptStatusEnum.ARRIVED);
//		}
		receiptRepository.save(one);
	}

	@Transactional
	@Override
	public void batchSaveReceipt(List<ReceiptAddDTO> list) {
		for (ReceiptAddDTO receiptAddDTO : list) {
			saveReceipt(receiptAddDTO);
		}
	}
}
