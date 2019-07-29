package com.morning.star.retail.facade.impl;

import com.alibaba.fastjson.JSON;
import com.morning.star.retail.BusinessRequestProperties;
import com.morning.star.retail.entity.ThirdServiceEntity;
import com.morning.star.retail.entity.enums.RequestStatusEnum;
import com.morning.star.retail.entity.enums.RequestTagEnum;
import com.morning.star.retail.entity.enums.RequestTypeEnum;
import com.morning.star.retail.entity.repository.ThirdServiceRepository;
import com.morning.star.retail.facade.BusTransferFacade;
import com.morning.star.retail.facade.dto.BusGoodsDTO;
import com.morning.star.retail.facade.dto.BusGoodsOnOffDTO;
import com.morning.star.retail.facade.dto.BusResultDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author ethan
 */
@Service
public class BusTransferFacadeImpl implements BusTransferFacade {
	private static Logger log = LoggerFactory.getLogger(BusTransferFacadeImpl.class);
	@Autowired
	private BusinessRequestProperties properties;

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private ThirdServiceRepository thirdServiceRepository;

	@Override
	public void addGoods(BusGoodsDTO dto) {
		String context = JSON.toJSONString(dto);
		ThirdServiceEntity entity = new ThirdServiceEntity(
			BusTransferFacadeImpl.class.getSimpleName() + "-addGoods",
			context,
			RequestTagEnum.BUISNESS_CREATE_PRODUCT,
			RequestTypeEnum.BUISNESS);
		// 保存请求信息
		ThirdServiceEntity saveEntity = thirdServiceRepository.save(entity);
		// 请求地址
		String requestUrl = properties.getUrl() + properties.getCreateGoodsUri();
		sendToBus(requestUrl, true, saveEntity, dto);
	}

	@Override
	public void onOffGoods(BusGoodsOnOffDTO dto) {
		String context = JSON.toJSONString(dto);
		ThirdServiceEntity entity = new ThirdServiceEntity(
			BusTransferFacadeImpl.class.getSimpleName() + "-onOffGoods",
			context,
			RequestTagEnum.BUISNESS_CREATE_PRODUCT,
			RequestTypeEnum.BUISNESS);
		// 保存请求信息
		ThirdServiceEntity saveEntity = thirdServiceRepository.save(entity);
		// 请求地址
		String requestUrl = properties.getUrl() + properties.getOnOffGoodsUri();
		sendToBus(requestUrl, true, saveEntity, dto);
	}

	/**
	 * 发送Http请求到运营端
	 * @param requestUrl    请求地址URL
	 * @param postRequest   请求方式，是否是POST请求
	 * @param saveEntity    请求记录
	 * @param params        请求参数
	 */
	private void sendToBus(String requestUrl, Boolean postRequest, ThirdServiceEntity saveEntity, Object params) {
		try {
			log.info("发送请求[" + requestUrl + "]:" + saveEntity.getRequestParam());
			BusResultDTO result = restTemplate.postForObject(requestUrl,
				params, BusResultDTO.class);
			judgeResult(result, saveEntity);
			log.info("请求返回[" + requestUrl + "]:" + saveEntity.getResponse());
		} catch (Exception e) {
			saveEntity.setRequestStatus(RequestStatusEnum.FAIL);
			e.printStackTrace();
		} finally {
			thirdServiceRepository.save(saveEntity);
		}
	}

	/**
	 * 判断返回结果并记录
	 * @param result        请求响应结果
	 * @param saveEntity    请求状态记录信息
	 */
	private void judgeResult(BusResultDTO result, ThirdServiceEntity saveEntity) {
		saveEntity.setResponse(JSON.toJSONString(result));
		if (result.getCode().equals(1000)) {
			saveEntity.setRequestStatus(RequestStatusEnum.SUCCESS);
		} else {
			saveEntity.setRequestStatus(RequestStatusEnum.FAIL);
		}
	}
}
