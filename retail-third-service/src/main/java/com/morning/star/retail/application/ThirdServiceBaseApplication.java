package com.morning.star.retail.application;

import com.alibaba.fastjson.JSON;
import com.morning.star.retail.entity.ThirdServiceEntity;
import com.morning.star.retail.entity.enums.RequestTagEnum;
import com.morning.star.retail.entity.repository.ThirdServiceFailRepository;
import com.morning.star.retail.entity.repository.ThirdServiceRepository;
import com.morning.star.retail.facade.dto.*;
import com.morning.star.retail.utils.entity.WmsUtils;
import com.wms.bean.ResultBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ethan
 * @create_time 2019/1/9 11:30
 * <p>
 * WMS基础资料接口
 */
@Service
public class ThirdServiceBaseApplication {
	private static Logger log = LoggerFactory.getLogger(ThirdServiceBaseApplication.class);

	@Autowired
	private ThirdServiceRepository thirdServiceRepository;
	@Autowired
	private ThirdServiceFailRepository thirdServiceFailRepository;

	@Autowired
	private WmsServiceApplication wmsServiceApplication;

	@Autowired
	private WmsUtils wmsUtils;

	/**
	 * 推送分类信息
	 */
	public void addCategory(CategoryWmsDTO dto) {
		Long id = null;
		ResultBean formatResult = null;
		boolean isException = false;
		try {
			ThirdServiceEntity entity = new ThirdServiceEntity("CategoryWmsFacadeImpl", JSON.toJSONString(dto), RequestTagEnum.WMS_CREATE_CATEGORY);
			ThirdServiceEntity save = thirdServiceRepository.save(entity);
			id = save.getId();

			formatResult = wmsServiceApplication.addCategory(dto);
		} catch (Exception e) {
			e.printStackTrace();
			formatResult = ResultBean.failBuilder(e.getMessage());
			wmsUtils.fail(id, thirdServiceRepository, thirdServiceFailRepository, formatResult);
			isException = true;
		} finally {
			wmsUtils.update(id, thirdServiceRepository, thirdServiceFailRepository, formatResult, isException);
		}
	}

	/**
	 * 推送人员信息（供应商，客户）
	 */
	public void addPersonnel(SupplierWmsDTO dto) {
		Long id = null;
		ResultBean formatResult = null;
		boolean isException = false;
		try {
			ThirdServiceEntity entity = new ThirdServiceEntity("CustomerWmsFacadeImpl", JSON.toJSONString(dto), RequestTagEnum.WMS_CREATE_SUPPLIER);
			ThirdServiceEntity save = thirdServiceRepository.save(entity);
			id = save.getId();

			formatResult = wmsServiceApplication.addPersonnel(dto);
		} catch (Exception e) {
			e.printStackTrace();
			formatResult = ResultBean.failBuilder(e.getMessage());
			wmsUtils.fail(id, thirdServiceRepository, thirdServiceFailRepository, formatResult);
			isException = true;
		} finally {
			wmsUtils.update(id, thirdServiceRepository, thirdServiceFailRepository, formatResult, isException);
		}
	}

	/**
	 * 推送商品信息
	 */
	public void addGoods(GoodsWmsDTO dto) {
		Long id = null;
		ResultBean formatResult = null;
		boolean isException = false;
		try {
			ThirdServiceEntity entity = new ThirdServiceEntity("ProductWmsFacadeImpl", JSON.toJSONString(dto), RequestTagEnum.WMS_CREATE_GOODS);
			ThirdServiceEntity save = thirdServiceRepository.save(entity);
			id = save.getId();

			formatResult = wmsServiceApplication.addGoods(dto);
		} catch (Exception e) {
			e.printStackTrace();
			formatResult = ResultBean.failBuilder(e.getMessage());
			wmsUtils.fail(id, thirdServiceRepository, thirdServiceFailRepository, formatResult);
			isException = true;
		} finally {
			wmsUtils.update(id, thirdServiceRepository, thirdServiceFailRepository, formatResult, isException);
		}
	}

	/**
	 * 推送仓库信息
	 */
	public void addStorage(StorageWmsDTO dto) {
		Long id = null;
		ResultBean formatResult = null;
		boolean isException = false;
		try {
			ThirdServiceEntity entity = new ThirdServiceEntity("StorageWmsFacadeImpl", JSON.toJSONString(dto), RequestTagEnum.WMS_CREATE_STORAGE);
			ThirdServiceEntity save = thirdServiceRepository.save(entity);
			id = save.getId();

			formatResult = wmsServiceApplication.addStorage(dto);
		} catch (Exception e) {
			e.printStackTrace();
			formatResult = ResultBean.failBuilder(e.getMessage());
			wmsUtils.fail(id, thirdServiceRepository, thirdServiceFailRepository, formatResult);
			isException = true;
		} finally {
			wmsUtils.update(id, thirdServiceRepository, thirdServiceFailRepository, formatResult, isException);
		}
	}

	/**
	 * 推送分公司信息
	 */
	public void addStore(StoreWmsDTO dto) {
		Long id = null;
		ResultBean formatResult = null;
		boolean isException = false;
		try {
			ThirdServiceEntity entity = new ThirdServiceEntity("StoreWmsFacadeImpl", JSON.toJSONString(dto), RequestTagEnum.WMS_CREATE_STORE);
			ThirdServiceEntity save = thirdServiceRepository.save(entity);
			id = save.getId();

			formatResult = wmsServiceApplication.addStore(dto);
		} catch (Exception e) {
			e.printStackTrace();
			formatResult = ResultBean.failBuilder(e.getMessage());
			wmsUtils.fail(id, thirdServiceRepository, thirdServiceFailRepository, formatResult);
			isException = true;
		} finally {
			wmsUtils.update(id, thirdServiceRepository, thirdServiceFailRepository, formatResult, isException);
		}
	}
}
