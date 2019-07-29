package com.morning.star.retail.application;

import com.alibaba.fastjson.JSON;
import com.morning.star.retail.entity.ThirdServiceEntity;
import com.morning.star.retail.entity.enums.RequestStatusEnum;
import com.morning.star.retail.entity.enums.RequestTagEnum;
import com.morning.star.retail.entity.repository.ThirdServiceFailRepository;
import com.morning.star.retail.entity.repository.ThirdServiceRepository;
import com.morning.star.retail.facade.dto.MoveStockWmsDTO;
import com.morning.star.retail.facade.dto.OutStockWmsDTO;
import com.morning.star.retail.facade.dto.PurchaseWmsDTO;
import com.morning.star.retail.utils.entity.WmsUtils;
import com.wms.bean.ResultBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ethan
 * @create_time 2019/1/9 11:18
 * <p>
 * WMS库存相关接口
 */
@Service
public class ThirdServiceStockApplication {
	private static Logger log = LoggerFactory.getLogger(ThirdServiceStockApplication.class);

	@Autowired
	private ThirdServiceRepository thirdServiceRepository;
	@Autowired
	private ThirdServiceFailRepository thirdServiceFailRepository;
	@Autowired
	private WmsServiceApplication wmsServiceApplication;

	@Autowired
	private WmsUtils wmsUtils;

	/**
	 * 采购相关：采购提交，采购关闭，采购退货
	 */
	public Integer addPurchase(PurchaseWmsDTO dto) {
		ThirdServiceEntity entity = new ThirdServiceEntity("PurchaseWmsFacadeImpl" + "---" + dto.getPushType(), JSON.toJSONString(dto), RequestTagEnum.WMS_CREATE_PURCHASE);
		ThirdServiceEntity save = thirdServiceRepository.save(entity);

		try {
			ResultBean formatResult = wmsServiceApplication.addPurchase(dto);
			return sendResult(save.getId(), formatResult);
		} catch (Exception e) {
			wmsUtils.fail(save.getId(), thirdServiceRepository, thirdServiceFailRepository, ResultBean.failBuilder(e.getMessage()));
			return 0;
		}
	}

	/**
	 * 出入库相关：S-销售出库单，P-调拨出库单，SR-销售入库单，PR-调拨入库单
	 */
	public Integer addOutStock(OutStockWmsDTO dto) {
		ThirdServiceEntity entity = new ThirdServiceEntity("OutStockWmsFacadeImpl" + "---" + dto.getPushType(), JSON.toJSONString(dto), RequestTagEnum.WMS_OUTSTOCK);
		ThirdServiceEntity save = thirdServiceRepository.save(entity);

		try {
			ResultBean formatResult = wmsServiceApplication.addOutStock(dto);
			return sendResult(save.getId(), formatResult);
		} catch (Exception e) {
			wmsUtils.fail(save.getId(), thirdServiceRepository, thirdServiceFailRepository, ResultBean.failBuilder(e.getMessage()));
			return 0;
		}
	}

	public Integer addMoveStock(MoveStockWmsDTO dto) {
		ThirdServiceEntity entity = new ThirdServiceEntity("MoveStockWmsFacadeImpl" + "---" + dto.getPushType(), JSON.toJSONString(dto), RequestTagEnum.WMS_MOVE);
		ThirdServiceEntity save = thirdServiceRepository.save(entity);

		try {
			ResultBean formatResult = wmsServiceApplication.addMoveStock(dto);
			return sendResult(save.getId(), formatResult);
		} catch (Exception e) {
			wmsUtils.fail(save.getId(), thirdServiceRepository, thirdServiceFailRepository, ResultBean.failBuilder(e.getMessage()));
			return 0;
		}
	}

	private Integer sendResult(Long thirdId, ResultBean formatResult) {

		if (formatResult.getStatus() == 1) {
			ThirdServiceEntity one = thirdServiceRepository.findOne(thirdId);
			one.setRequestStatus(RequestStatusEnum.SUCCESS);
			thirdServiceRepository.save(one);
			return 1;
		} else {
			wmsUtils.fail(thirdId, thirdServiceRepository, thirdServiceFailRepository, formatResult);
		}
		return 0;
	}
}
