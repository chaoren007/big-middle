package com.morning.star.retail.facade.impl;

import com.morning.star.retail.RabbitConfig;
import com.morning.star.retail.entity.StoreEntity;
import com.morning.star.retail.entity.SupplierEntity;
import com.morning.star.retail.entity.WarehouseEntity;
import com.morning.star.retail.entity.repository.StoreRepository;
import com.morning.star.retail.entity.repository.SupplierRespository;
import com.morning.star.retail.entity.repository.WarehouseRepository;
import com.morning.star.retail.facade.BaseModelWmsFacade;
import com.morning.star.retail.facade.dto.StorageWmsDTO;
import com.morning.star.retail.facade.dto.StoreWmsDTO;
import com.morning.star.retail.facade.dto.SupplierWmsDTO;
import com.morning.star.retail.helper.MqHelperService;
import com.morning.star.retail.utils.mq.WmsStorePullQueue;
import org.apache.commons.lang3.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ethan
 * @create_time 2018/12/28 11:40
 */
@Service
public class BaseModelWmsFacadeImpl implements BaseModelWmsFacade {

	@Autowired
	private SupplierRespository supplierRespository;
	@Autowired
	private WarehouseRepository warehouseRepository;
	@Autowired
	private StoreRepository storeRepository;

	@Autowired
	private MqHelperService mqHelperService;
	@Autowired
	private RabbitConfig rabbitConfig;
	@Autowired
	private WmsStorePullQueue wmsStorePullQueue;

	@Override
	public void pushSupplier(String code) {
		SupplierEntity entity = supplierRespository.getBySupplierCode(code);
		Validate.notNull(entity, "供应商不存在：" + code);
		SupplierWmsDTO wms = SupplierEntity.toWmsDTO(entity);
		mqHelperService.send(rabbitConfig.getExchange(), rabbitConfig.getCreateSupplierQueue(), wms);
	}

	@Override
	public void pushWarehouse(String code) {
		WarehouseEntity entity = warehouseRepository.getByWarehouseCode(code);
		Validate.notNull(entity, "仓库不存在：" + code);
		StorageWmsDTO wms = WarehouseEntity.toWmsDTO(entity);
		mqHelperService.send(rabbitConfig.getExchange(), rabbitConfig.getCreateStorageQueue(), wms);
	}

	@Override
	public void pushStore(String code) {
		StoreEntity entity = storeRepository.findOne(code);
		Validate.notNull(entity, "门店不存在：" + code);
		StoreWmsDTO storeWmsDTO = StoreEntity.toWmsDTO(entity);
		wmsStorePullQueue.send(storeWmsDTO);
	}
}
