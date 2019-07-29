package com.morning.star.retail.stock.application.impl;

import com.morning.star.retail.stock.application.InventoryApplication;
import com.morning.star.retail.stock.dto.*;
import com.morning.star.retail.stock.entity.*;
import com.morning.star.retail.stock.entity.repository.*;
import com.morning.star.retail.stock.enums.*;
import com.morning.star.retail.stock.helper.StockGoodsHelper;
import com.morning.star.retail.stock.helper.StoreService;
import com.morning.star.retail.stock.helper.vo.GoodsInfo;
import com.morning.star.retail.stock.helper.vo.StoreInfo;
import com.morning.star.retail.stock.logicservice.StockLogicService;
import com.morning.star.retail.user.UserInfo;
import com.morning.star.retail.user.UserPermission;
import com.morning.star.retail.user.UserUtils;
import com.morning.star.retail.util.StringUtil;
import com.morning.star.retail.util.UniqueNoUtils;
import com.morning.star.retail.utils.entity.BeanUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class InventoryApplicationImpl implements InventoryApplication {

	@Autowired
	private InventoryRepository inventoryRepository;
	@Autowired
	private InventoryItemRepository itemRepository;
	@Autowired
	private InventoryAdjustRepository adjustRepository;
	@Autowired
	private InventoryStatementRepository statementRepository;
	@Autowired
	private InventoryStatementItemRepository statementItemRepository;
	@Autowired
	private StoreService storeOuterService;
	@Autowired
	private StockGoodsHelper goodsService;
	@Autowired
	private WaterRepository waterRepository;
	@Autowired
	private StockLogicService stockLogicService;

	@Override
	@Transactional
	public boolean create(InventoryFormDTO formDTO) {
		InventoryEntity entity = inventoryRepository.getByInventoryCode(formDTO.getInventoryCode());
		Validate.isTrue(entity == null, String.format("该盘点单【编码：%s】已存在", formDTO.getInventoryCode()));

		checkRepeatData(formDTO.getGoodsCodes());

		entity = toInventoryEntity(formDTO);
		inventoryRepository.save(entity);

		for (String goodsCode : formDTO.getGoodsCodes()) {
			itemRepository.save(toItemEntity(formDTO.getInventoryCode(), goodsCode));
		}

		waterRepository.save(entity, InventoryWaterEntity.class, "创建盘点单");
		return true;
	}

	private InventoryEntity toInventoryEntity(InventoryFormDTO formDTO) {
		InventoryEntity entity = new InventoryEntity();
		BeanUtils.copy(formDTO, entity);

		UserInfo userInfo = UserUtils.currentUser();
		StoreInfo storeInfo = storeOuterService.getStore(userInfo.getTag("storeCode"));
		entity.setGroupCode(storeInfo.getGroupCode());
		entity.setGroupName(storeInfo.getGroupName());
		entity.setStoreCode(storeInfo.getStoreCode());
		entity.setStoreName(storeInfo.getStoreName());

		entity.setEntryStatus(InventoryEntryStatus.N);
		entity.setStashStatus(InventoryStashStatus.N);
		entity.setStatementStatus(InventoryStatementStatus.NONE);
		entity.setReadStatus(InventoryReadStatus.N);
		entity.setAuditStatus(InventoryAuditStatus.WAIT_AUDIT);
		entity.setStatus(InventoryStatus.USED);

		return entity;
	}

	private InventoryItemEntity toItemEntity(String inventoryCode, String goodsCode) {
		GoodsInfo goodsInfo = goodsService.checkGetGoods(goodsCode);

		InventoryItemEntity item = new InventoryItemEntity();
		BeanUtils.copy(goodsInfo, item);

		item.setUnits(goodsInfo.getUnitsName());
		item.setInventoryCode(inventoryCode);

		item.setShelfNum(BigDecimal.ZERO);
		item.setShelfTotalNum(BigDecimal.ZERO);
		item.setShelfAdjustNum(BigDecimal.ZERO);
		item.setShelfStatus(InventoryTerminalStatus.N);

		item.setWarehouseNum(BigDecimal.ZERO);
		item.setWarehouseTotalNum(BigDecimal.ZERO);
		item.setWarehouseAdjustNum(BigDecimal.ZERO);
		item.setWarehouseStatus(InventoryTerminalStatus.N);

		item.setAdjustNum(BigDecimal.ZERO);
		item.setTotalNum(BigDecimal.ZERO);

		return item;
	}

	/**
	 * 检查重复提交数据
	 *
	 * @param list
	 */
	private void checkRepeatData(List<String> list) {
		Map<String, Long> map = list.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		StringBuilder goodsCodes = new StringBuilder();
		map.forEach((k, v) -> {
			if (v > 1) {
				goodsCodes.append(k).append("，");
			}
		});

		Validate.isTrue(StringUtils.isBlank(goodsCodes.toString()), String.format("提交商品【编码：%s】存在重复，请检查", StringUtil.removeLastSpliter(goodsCodes.toString(), "，")));
	}

	@Override
	@Transactional
	public boolean save(InventorySubmitDTO dto) {
		InventoryEntity entity = checkGet(dto.getInventoryCode());

		Validate.isTrue(InventoryStatementStatus.NONE.equals(entity.getStatementStatus()), String.format("该盘点单【编码：%s】已生成长短单，不能提交盘点数据", dto.getInventoryCode()));

		entity.setEntryStatus(InventoryEntryStatus.Y);
		if (StringUtils.isNotBlank(dto.getRemark())) {
			entity.setRemark(entity.getRemark() + "<br/>" + dto.getRemark());
		}
		inventoryRepository.save(entity);

		UserInfo userInfo = UserUtils.currentUser();

		for (InventoryItemSubmitDTO itemDTO : dto.getItems()) {
			InventoryItemEntity itemEntity = itemRepository.getByInventoryCodeAndGoodsCode(dto.getInventoryCode(), itemDTO.getGoodsCode());
			Validate.notNull(itemEntity, String.format("在盘点单【编码：%s】中未找到该商品【编码：%s】信息", dto.getInventoryCode(), itemDTO.getGoodsCode()));

			if (InventoryTypeEnum.SHELF.getCode().equals(dto.getType())) {
				itemEntity.setShelfNum(itemDTO.getNum());
				itemEntity.setShelfTotalNum(itemDTO.getNum());
				itemEntity.setShelfStatus(InventoryTerminalStatus.Y);
				itemEntity.setShelfAreaNo(itemDTO.getAreaNo());
				itemEntity.setShelfDate(new Date());
				itemEntity.setShelfOperatorId(userInfo.getId());
			} else {
				itemEntity.setWarehouseNum(itemDTO.getNum());
				itemEntity.setWarehouseTotalNum(itemDTO.getNum());
				itemEntity.setWarehouseStatus(InventoryTerminalStatus.Y);
				itemEntity.setWarehouseAreaNo(itemDTO.getAreaNo());
				itemEntity.setWarehouseDate(new Date());
				itemEntity.setWarehouseOperatorId(userInfo.getId());
			}

			itemEntity.setShelfAdjustNum(BigDecimal.ZERO);
			itemEntity.setWarehouseAdjustNum(BigDecimal.ZERO);
			itemEntity.setShelfTotalNum(itemEntity.getShelfNum());
			itemEntity.setWarehouseTotalNum(itemEntity.getWarehouseNum());
			itemEntity.setTotalNum(itemEntity.getShelfNum().add(itemEntity.getWarehouseNum().add(itemEntity.getAdjustNum())));

			itemRepository.save(itemEntity);

			waterRepository.save(itemEntity, InventoryItemWaterEntity.class, InventoryTypeEnum.SHELF.getCode().equals(dto.getType()) ? "盘货架" : "盘仓库");
		}

		waterRepository.save(entity, InventoryWaterEntity.class, "录入盘点数据");
		return true;
	}

	@Override
	@Transactional
	public void auditSucc(String inventoryCode, String storeCode) {
		InventoryEntity entity = inventoryRepository.getByInventoryCode(inventoryCode);
		entity.setAuditStatus(InventoryAuditStatus.AUDIT_SUCC);

		new UserPermission(UserUtils.currentUser())
			.tag("storeCode", entity.getStoreCode())
			.pass();

		inventoryRepository.save(entity);
		// 审核成功，同步库存
		if (InventoryAuditStatus.AUDIT_SUCC.equals(entity.getAuditStatus())) {

			List<InventoryItemEntity> list = itemRepository.getByInventoryCode(inventoryCode);
			for (InventoryItemEntity item : list) {

				// TODO 更新库存
			}
		}
	}

	@Override
	@Transactional
	public void auditFail(String inventoryCode, String storeCode) {
		InventoryEntity entity = inventoryRepository.getByInventoryCode(inventoryCode);
		entity.setAuditStatus(InventoryAuditStatus.AUDIT_FAIL);
		new UserPermission(UserUtils.currentUser())
			.tag("storeCode", entity.getStoreCode())
			.pass();
		inventoryRepository.save(entity);
	}

	@Override
	@Transactional
	public int batchRead(String[] inventoryCodes, String storeCode) {
		int count = 0;
		for (String inventoryCode : inventoryCodes) {
			InventoryEntity entity = inventoryRepository.getByInventoryCode(inventoryCode);
			entity.setReadStatus(InventoryReadStatus.Y);
			new UserPermission(UserUtils.currentUser())
				.tag("storeCode", entity.getStoreCode())
				.pass();
			inventoryRepository.save(entity);
			count++;
		}
		return count;
	}

	@Override
	public InventoryEntity checkGet(String inventoryCode) {
		InventoryEntity entity = inventoryRepository.getByInventoryCode(inventoryCode);
		Validate.notNull(entity, String.format("未找到该盘点单【编码：%s】信息", inventoryCode));
		return entity;
	}

	@Override
	@Transactional
	public void createAdjust(InventoryAdjustDTO dto) {
		InventoryEntity inventoryEntity = checkGet(dto.getInventoryCode());

		boolean canAdjust = InventoryStatementStatus.NONE.equals(inventoryEntity.getStatementStatus()) || InventoryStatementStatus.GENERATED.equals(inventoryEntity.getStatementStatus());
		Validate.isTrue(canAdjust, String.format("该盘点单【编码：%s】状态不符合当前操作条件，请检查", dto.getInventoryCode()));

		// 更新录入状态
		inventoryEntity.setEntryStatus(InventoryEntryStatus.Y);
		inventoryRepository.save(inventoryEntity);

		InventoryAdjustEntity adjustEntity = new InventoryAdjustEntity();
		BeanUtils.copy(dto, adjustEntity);
		adjustRepository.save(adjustEntity);

		InventoryItemEntity itemEntity = itemRepository.getByInventoryCodeAndGoodsCode(dto.getInventoryCode(), dto.getGoodsCode());
		if (itemEntity == null) {
			itemEntity = toItemEntity(dto.getInventoryCode(), dto.getGoodsCode());
		}

		itemEntity.setAdjustNum(itemEntity.getAdjustNum().add(dto.getAdjustNum()));
		itemEntity.setTotalNum(itemEntity.getShelfTotalNum().add(itemEntity.getWarehouseTotalNum().add(itemEntity.getAdjustNum())));
		itemRepository.save(itemEntity);

		waterRepository.save(itemEntity, InventoryItemWaterEntity.class, "手动调整盘点调整数量");

		waterRepository.save(inventoryEntity, InventoryWaterEntity.class, "手动调整盘点调整数量");
	}

	@Override
	@Transactional
	public void createStatement(String inventoryCode, boolean isFormal) {
		InventoryEntity inventoryEntity = checkGet(inventoryCode);

		boolean canCreate = InventoryStatementStatus.NONE.equals(inventoryEntity.getStatementStatus()) || InventoryStatementStatus.GENERATED.equals(inventoryEntity.getStatementStatus());
		Validate.isTrue(canCreate, String.format("该盘点单【编码：%s】状态不符合当前操作条件，请检查", inventoryCode));

		InventoryStatementStatus status = isFormal ? InventoryStatementStatus.CONFIRMED : InventoryStatementStatus.GENERATED;
		String operatorRemark = isFormal ? "长短单-正式生成" : "长短单-生成";

		saveStatement(inventoryEntity, status, operatorRemark);

		modifyInventoryStatementStatus(inventoryEntity, status, operatorRemark);
	}

	@Override
	@Transactional
	public void modifyStatementStatus(String inventoryCode, InventoryStatementStatus status) {
		InventoryEntity inventoryEntity = checkGet(inventoryCode);

		if (inventoryEntity.getStatementStatus().equals(status)) { // 是否重复执行
			return;
		}

		String operatorRemark = "";
		if (InventoryStatementStatus.GENERATED.equals(status)) {
			Validate.isTrue(InventoryStatementStatus.CONFIRMED.equals(inventoryEntity.getStatementStatus()), String.format("该盘点单【编码：%s】当前非“已确认”状态，不能执行“取消确认”操作", inventoryCode));
			operatorRemark = "长短单-取消确认";
		} else if (InventoryStatementStatus.CONFIRMED.equals(status)) {
			Validate.isTrue(InventoryStatementStatus.GENERATED.equals(inventoryEntity.getStatementStatus()), String.format("该盘点单【编码：%s】当前非“已生成”状态，不能执行“确认”操作", inventoryCode));
			operatorRemark = "长短单-确认";
		} else if (InventoryStatementStatus.ARCHIVED.equals(status)) {
			Validate.isTrue(InventoryStatementStatus.CONFIRMED.equals(inventoryEntity.getStatementStatus()), String.format("该盘点单【编码：%s】当前非“已确认”状态，不能执行“存档”操作", inventoryCode));
			operatorRemark = "长短单-存档";
		}

		// 更新长短单状态
		modifyInventoryStatementStatus(inventoryEntity, status, operatorRemark);

		List<InventoryStatementEntity> list = statementRepository.getByInventoryCode(inventoryCode);
		for (InventoryStatementEntity statementEntity : list) {
			statementEntity.setStatus(status);

			statementRepository.save(statementEntity);
			waterRepository.save(statementEntity, InventoryStatementWaterEntity.class, operatorRemark);

			// 归档更新库存
			if (InventoryStatementStatus.ARCHIVED.equals(status)) {
				updateStock(statementEntity);
			}
		}
	}

	/**
	 * 根据长短单更新库存
	 *
	 * @param statement
	 */
	private void updateStock(InventoryStatementEntity statement) {
		StockOrderDTO dto = new StockOrderDTO();
		dto.setGroupCode(statement.getGroupCode());
		dto.setStoreCode(statement.getStoreCode());
		dto.setOrderCode(statement.getStatementCode());
		dto.setStatus(String.valueOf(statement.getStatus()));

		List<InventoryStatementItemEntity> statementItems = statementItemRepository.getByStatementCode(statement.getStatementCode());
		List<ItemDTO> items = new ArrayList<>(statementItems.size());
		for (InventoryStatementItemEntity statementItem : statementItems) {
			ItemDTO item = new ItemDTO();
			item.setGoodsCode(statementItem.getGoodsCode());
			item.setRealNum(statementItem.getStatementNum());
			item.setOrderNum(statementItem.getStatementNum());

			items.add(item);
		}

		if (InventoryStatementType.PROFIT.equals(statement.getType())) { // 盘盈入库
			stockLogicService.inventoryProfitInStock(dto);
		} else if (InventoryStatementType.LOSS.equals(statement.getType())) {  // 盘盈出库
			stockLogicService.inventoryLossOutStock(dto);
		}
	}

	private void saveStatement(InventoryEntity inventoryEntity, InventoryStatementStatus status, String operatorRemark) {
		List<InventoryItemEntity> items = itemRepository.getByInventoryCode(inventoryEntity.getInventoryCode());

		List<InventoryItemEntity> profitItems = new ArrayList<>(); // 盘盈
		List<InventoryItemEntity> lossItems = new ArrayList<>(); // 盘亏

		for (InventoryItemEntity item : items) {
			int compare = item.getTotalNum().compareTo(item.getDoneInStockNum());
			if (compare > 0) { // 盘盈
				profitItems.add(item);
			}
			if (compare < 0) { // 盘亏
				lossItems.add(item);
			}
		}

		if (!profitItems.isEmpty()) { // 生成长货类型长短单
			saveStatement(inventoryEntity, profitItems, InventoryStatementType.PROFIT, status, operatorRemark);
		}

		if (!lossItems.isEmpty()) { // 生成短货类型长短单
			saveStatement(inventoryEntity, lossItems, InventoryStatementType.LOSS, status, operatorRemark);
		}
	}

	private void saveStatement(InventoryEntity inventoryEntity, List<InventoryItemEntity> items, InventoryStatementType type, InventoryStatementStatus status, String operatorRemark) {
		InventoryStatementEntity statement = statementRepository.getByInventoryCodeAndType(inventoryEntity.getInventoryCode(), type.getCode());
		if (statement == null) {
			String statementCode = UniqueNoUtils.next(UniqueNoUtils.UniqueNoType.CDD);

			statement = new InventoryStatementEntity();
			statement.setStatementCode(statementCode);

			statement.setInventoryCode(inventoryEntity.getInventoryCode());
			statement.setGroupCode(inventoryEntity.getGroupCode());
			statement.setGroupName(inventoryEntity.getGroupName());
			statement.setStoreCode(inventoryEntity.getStoreCode());
			statement.setStoreName(inventoryEntity.getStoreName());

			statement.setType(type);

			for (InventoryItemEntity item : items) {
				InventoryStatementItemEntity itemEntity = new InventoryStatementItemEntity();

				BeanUtils.copy(item, itemEntity);
				itemEntity.setStatementCode(statementCode);
				itemEntity.setStatementNum(item.getTotalNum().subtract(item.getDoneInStockNum()).abs()); // 长短数量

				statementItemRepository.save(itemEntity);
			}
		} else {
			for (InventoryItemEntity item : items) {
				InventoryStatementItemEntity statementItem = statementItemRepository.getByStatementCodeAndGoodsCode(statement.getStatementCode(), item.getGoodsCode());
				statementItem.setStatementNum(item.getTotalNum().subtract(item.getDoneInStockNum()).abs()); // 长短数量

				statementItemRepository.save(statementItem);
			}
		}

		statement.setStatus(status);

		statementRepository.save(statement);
		waterRepository.save(statement, InventoryStatementWaterEntity.class, operatorRemark);
	}

	/**
	 * 更新盘点单状态
	 *
	 * @param inventoryEntity
	 * @param status
	 * @param operatorRemark
	 */
	private void modifyInventoryStatementStatus(InventoryEntity inventoryEntity, InventoryStatementStatus status, String operatorRemark) {
		inventoryEntity.setStatementStatus(status);
		inventoryRepository.save(inventoryEntity);
		waterRepository.save(inventoryEntity, InventoryWaterEntity.class, operatorRemark);
	}

}
