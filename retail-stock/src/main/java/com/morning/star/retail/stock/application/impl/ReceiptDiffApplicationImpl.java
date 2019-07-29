package com.morning.star.retail.stock.application.impl;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.morning.star.retail.stock.application.ReceiptDiffApplication;
import com.morning.star.retail.stock.dto.ModifyReceiptDiffDTO;
import com.morning.star.retail.stock.dto.ModifyReceiptDiffItemDTO;
import com.morning.star.retail.stock.entity.ReceiptDiffEntity;
import com.morning.star.retail.stock.entity.ReceiptDiffItemEntity;
import com.morning.star.retail.stock.entity.ReceiptDiffWaterEntity;
import com.morning.star.retail.stock.entity.repository.ReceiptDiffItemRepository;
import com.morning.star.retail.stock.entity.repository.ReceiptDiffRepository;
import com.morning.star.retail.stock.entity.repository.WaterRepository;
import com.morning.star.retail.stock.enums.ReceiptDiffStatusEnum;
import com.morning.star.retail.stock.helper.StockGoodsHelper;
import com.morning.star.retail.stock.helper.vo.GoodsInfo;
import com.morning.star.retail.utils.entity.BeanUtils;

/**
 * Created by kimhuhg
 */
@Service
public class ReceiptDiffApplicationImpl implements ReceiptDiffApplication {
	@Autowired
	private ReceiptDiffRepository receiptDiffRepository;
	@Autowired
	private ReceiptDiffItemRepository receiptDiffItemRepository;
	@Autowired
	private WaterRepository waterRepository;
	@Autowired
	private StockGoodsHelper stockGoodsHelper;

	@Transactional
	@Override
	public void writeDiffItem(ModifyReceiptDiffDTO modifyReceiptDiffDTO) {
		ReceiptDiffEntity one = receiptDiffRepository.findOne(modifyReceiptDiffDTO.getReceiptDiffCode());
		Validate.isTrue(one != null, "差异单不存在,请检查差异单编码");
		List<ReceiptDiffItemEntity> lists = receiptDiffItemRepository.findAllByReceiptDiffCode(modifyReceiptDiffDTO.getReceiptDiffCode());
		//先预保存并收集数量
		HashMap<String, BigDecimal> map = new HashMap<>();
		for (ModifyReceiptDiffItemDTO item : modifyReceiptDiffDTO.getItem()) {
			if (map.containsKey(item.getGoodsCode())) {
				map.put(item.getGoodsCode(),map.get(item.getGoodsCode()).add(item.getDifferenceQty()));
			} else {
				map.put(item.getGoodsCode(),item.getDifferenceQty());
			}
			Validate.isTrue(!StringUtils.isBlank(item.getDiffReason())," 差异原因不能为空");
			Validate.isTrue(!StringUtils.isBlank(item.getGoodsCode())," 货品编码不能为空");
			Validate.isTrue(item.getDifferenceQty().compareTo(BigDecimal.ZERO) > 0,"差异数量不能小于0");
			//预保存
			ReceiptDiffItemEntity receiptDiffItemEntity = new ReceiptDiffItemEntity();
			BeanUtils.copy(item,receiptDiffItemEntity);
			GoodsInfo goods = stockGoodsHelper.getGoods(item.getGoodsCode());
			receiptDiffItemEntity.setReceiptDiffCode(modifyReceiptDiffDTO.getReceiptDiffCode());
			receiptDiffItemEntity.setPackSpecNum(goods.getPackSpecNum());
			receiptDiffItemEntity.setPackSpecUnits(goods.getPackSpecUnits());
			receiptDiffItemEntity.setProductCode(goods.getProductCode());
			receiptDiffItemEntity.setProductName(goods.getProductName());
			receiptDiffItemEntity.setUnitsId(String.valueOf(goods.getUnitsId()));
			receiptDiffItemEntity.setProductType(goods.getProductType());
			receiptDiffItemEntity.setUnitsName(goods.getUnitsName());
			receiptDiffItemEntity.setUpcCode(goods.getUpcCode());
			//遍历旧数据获取商品一些可用数据
			for (ReceiptDiffItemEntity list : lists) {
				if (list.getGoodsCode().equals(item.getGoodsCode()) && list.getPrice() != null) {
					receiptDiffItemEntity.setPrice(list.getPrice());
					receiptDiffItemEntity.setProductionDate(list.getProductionDate());
					receiptDiffItemEntity.setShelfLife(list.getShelfLife());
					receiptDiffItemEntity.setExpirationDate(list.getExpirationDate());
				}
			}
			receiptDiffItemRepository.save(receiptDiffItemEntity);
		}
		//再进行数量是否一致校验并删除旧数据
		for (ReceiptDiffItemEntity list : lists) {
			Validate.isTrue(list.getDifferenceQty().compareTo(map.get(list.getGoodsCode())) == 0, "差异单为("+list.getReceiptDiffCode()+")的差异单拆分后差异单与原单差异数量不一致");
			receiptDiffItemRepository.delete(list.getId());
		}
		//更新主表
		one.setDiffStatus(ReceiptDiffStatusEnum.WAIT_CHECK);
		receiptDiffRepository.save(one);
		waterRepository.save(one, ReceiptDiffWaterEntity.class,"填写差异单");
	}

	@Transactional
	@Override
	public void batchWriteDiffItem(List<ModifyReceiptDiffDTO> list) {
		for (ModifyReceiptDiffDTO modifyReceiptDiffDTO : list) {
			writeDiffItem(modifyReceiptDiffDTO);
		}
	}
}


