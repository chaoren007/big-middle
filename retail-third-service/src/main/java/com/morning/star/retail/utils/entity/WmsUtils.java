package com.morning.star.retail.utils.entity;

import com.morning.star.retail.entity.ThirdServiceEntity;
import com.morning.star.retail.entity.ThirdServiceFailEntity;
import com.morning.star.retail.entity.enums.RequestStatusEnum;
import com.morning.star.retail.entity.repository.ThirdServiceFailRepository;
import com.morning.star.retail.entity.repository.ThirdServiceRepository;
import com.wms.bean.ResultBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class WmsUtils {
	private static Logger log = LoggerFactory.getLogger(WmsUtils.class);

	public void fail(Long id, ThirdServiceRepository thirdServiceRepository, ThirdServiceFailRepository thirdServiceFailRepository, ResultBean formatResult) {
		if (id != null) {
			ThirdServiceEntity one = thirdServiceRepository.findOne(id);
			one.setRequestStatus(RequestStatusEnum.FAIL);
			if (formatResult != null) {
				one.setResponse(formatResult.getMsg());
			}
			thirdServiceRepository.save(one);

			ThirdServiceFailEntity entity = new ThirdServiceFailEntity();
			entity.setRequestApi(one.getRequestApi());
			entity.setRequestParam(one.getRequestParam());
			entity.setRequestStatus(one.getRequestStatus());
			entity.setRequestTag(one.getRequestTag());
			entity.setRequestType(one.getRequestType());
			if (formatResult != null) {
				entity.setMsg(formatResult.getMsg());
			}
			thirdServiceFailRepository.save(entity);
		} else {
			log.info("关联中间表找不到id");
		}

	}

	/**
	 * 不管成功与否，必须执行
	 *
	 * @param id
	 * @param thirdServiceRepository
	 * @param thirdServiceFailRepository
	 * @param formatResult
	 */
	public void update(Long id, ThirdServiceRepository thirdServiceRepository, ThirdServiceFailRepository thirdServiceFailRepository, ResultBean formatResult, boolean isException) {
		if (formatResult != null && formatResult.getStatus() == 1) {
			ThirdServiceEntity one = thirdServiceRepository.findOne(id);
			one.setRequestStatus(RequestStatusEnum.SUCCESS);
			thirdServiceRepository.save(one);
		} else {
			ThirdServiceEntity one = thirdServiceRepository.findOne(id);
			one.setRequestStatus(RequestStatusEnum.FAIL);
			thirdServiceRepository.save(one);
			if (!isException) {
				fail(id, thirdServiceRepository, thirdServiceFailRepository, formatResult);
			}
		}
	}
}
