package com.morning.star.retail.facade.impl;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.morning.star.retail.application.WmsServiceApplication;
import com.morning.star.retail.dao.ThirdServiceFailDAO;
import com.morning.star.retail.entity.ThirdServiceFailEntity;
import com.morning.star.retail.entity.enums.RequestStatusEnum;
import com.morning.star.retail.entity.repository.ThirdServiceFailRepository;
import com.morning.star.retail.facade.ThirdServiceFailFacade;
import com.morning.star.retail.facade.dto.*;
import com.morning.star.retail.utils.entity.DeleteFlagEnum;
import com.morning.star.retail.utils.page.PageBean;
import com.morning.star.retail.utils.page.PageBeanAssembler;
import com.morning.star.retail.utils.page.RowBoundsBuilder;
import com.wms.bean.ResultBean;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ThirdServiceFailFacadeImpl implements ThirdServiceFailFacade {

	@Autowired
	private ThirdServiceFailRepository thirdServiceFailRepository;
	@Autowired
	private ThirdServiceFailDAO thirdServiceFailDAO;

	@Autowired
	private WmsServiceApplication wmsServiceApplication;

	@Override
	public PageBean<ThirdServiceFailDTO> page(ThirdServiceQueryDTO queryDTO) {
		RowBounds rowBounds = RowBoundsBuilder.build(queryDTO.getPageNo(), queryDTO.getPageSize());
		Page<ThirdServiceFailDTO> page = thirdServiceFailDAO.queryByPage(queryDTO, rowBounds);
		return new PageBeanAssembler().toBean(page);
	}

	@Override
	@Transactional
	public ThirdServiceFailDTO reTry(Long id) {
		// 获取失败请求数据
		ThirdServiceFailEntity one = thirdServiceFailRepository.findOne(id);
		// 判断失败请求状态
		if (one != null && one.getRequestStatus() == RequestStatusEnum.FAIL) {
			ResultBean result = null;
			switch (one.getRequestTag()) {
				case WMS_CREATE_CATEGORY: {
					result = wmsServiceApplication.addCategory(
						JSON.parseObject(one.getRequestParam(), CategoryWmsDTO.class)
					);
					break;
				}
				case WMS_CREATE_GOODS: {
					result = wmsServiceApplication.addGoods(
						JSON.parseObject(one.getRequestParam(), GoodsWmsDTO.class)
					);
					break;
				}
				case WMS_CREATE_SUPPLIER: {
					result = wmsServiceApplication.addPersonnel(
						JSON.parseObject(one.getRequestParam(), SupplierWmsDTO.class)
					);
					break;
				}
				case WMS_CREATE_STORE: {
					result = wmsServiceApplication.addStore(
						JSON.parseObject(one.getRequestParam(), StoreWmsDTO.class)
					);
					break;
				}
				case WMS_CREATE_STORAGE: {
					result = wmsServiceApplication.addStorage(
						JSON.parseObject(one.getRequestParam(), StorageWmsDTO.class)
					);
					break;
				}
				case WMS_CREATE_PURCHASE: {
					/*result = wmsServiceApplication.addPurchase(
						JSON.parseObject(one.getRequestParam(), PurchaseWmsDTO.class)
					);*/
					break;
				}
				case WMS_OUTSTOCK: {
					/*result = wmsServiceApplication.addOutStock(
						JSON.parseObject(one.getRequestParam(), OutStockWmsDTO.class)
					);*/
					break;
				}
				case WMS_MOVE: {
					/*result = wmsServiceApplication.addMoveStock(
						JSON.parseObject(one.getRequestParam(), MoveStockWmsDTO.class)
					);*/
					break;
				}
				default: {
					break;
				}
			}
			// 重试成功修改失败记录
			if (result != null && result.getStatus() == 1) {
				one.setRequestStatus(RequestStatusEnum.SUCCESS);
				one.setDeleteFlag(DeleteFlagEnum.DELETE.getCode());
				thirdServiceFailRepository.save(one);
			}

		}
		return ThirdServiceFailEntity.toDTO(one);
	}
}
