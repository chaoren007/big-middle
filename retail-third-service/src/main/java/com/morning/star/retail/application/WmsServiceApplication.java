package com.morning.star.retail.application;

import com.alibaba.fastjson.JSON;
import com.morning.star.retail.dto.GoodsWmsInfoDTO;
import com.morning.star.retail.dto.MoveStockWmsInfoDTO;
import com.morning.star.retail.dto.OutStockWmsInfoDTO;
import com.morning.star.retail.dto.PurchaseWmsInfoDTO;
import com.morning.star.retail.facade.assembler.*;
import com.morning.star.retail.facade.dto.*;
import com.wms.*;
import com.wms.bean.ResultBean;
import com.wms.bean.ResultFormat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ethan
 */
@Service
@Retryable(value = {IllegalArgumentException.class, Exception.class}, backoff = @Backoff(delay = 5000, multiplier = 1))
public class WmsServiceApplication {
	private static Logger log = LoggerFactory.getLogger(WmsServiceApplication.class);

	/**
	 * 推送分类信息
	 */
	public ResultBean addCategory(CategoryWmsDTO dto) {
		WMSPortType wmsHttpEndpoint = new WMS().getWMSHttpSoap12Endpoint();
		List<GoodsType> list = new CategoryAssembler().transform(dto);
		log.info("wms添加分类信息：" + JSON.toJSONString(list));

		Remsg result = wmsHttpEndpoint.createGoodsType(list);
		return fixResult(result);
	}

	/**
	 * 推送人员信息（供应商，客户）
	 */
	public ResultBean addPersonnel(SupplierWmsDTO dto) {
		WMSPortType wmsHttpEndpoint = new WMS().getWMSHttpSoap12Endpoint();
		List<Partner> list = new CustomerAssembler().transform(dto);
		log.info("wms添加客户信息：" + JSON.toJSONString(list));

		Remsg result = wmsHttpEndpoint.createPartner(list);
		return fixResult(result);
	}

	/**
	 * 推送商品信息
	 */
	public ResultBean addGoods(GoodsWmsDTO dto) {
		WMSPortType wmsHttpEndpoint = new WMS().getWMSHttpSoap12Endpoint();
		GoodsWmsInfoDTO info = new GoodsAssembler().transform(dto);
		log.info("wms添加商品信息：" + JSON.toJSONString(info));

		Remsg result = wmsHttpEndpoint.createGoods(info.getGoods(), info.getCodes());
		return fixResult(result);
	}

	/**
	 * 推送仓库信息
	 */
	public ResultBean addStorage(StorageWmsDTO dto) {
		WMSPortType wmsHttpEndpoint = new WMS().getWMSHttpSoap12Endpoint();
		List<Store> list = new StorageAssembler().transform(dto);
		log.info("wms添加仓库信息：" + JSON.toJSONString(list));

		Remsg result = wmsHttpEndpoint.createStore(list);
		return fixResult(result);
	}

	/**
	 * 推送分公司信息
	 */
	public ResultBean addStore(StoreWmsDTO dto) {
		WMSPortType wmsHttpEndpoint = new WMS().getWMSHttpSoap12Endpoint();
		List<Customer> list = new StoreAssembler().transform(dto);
		log.info("wms添加分公司信息：" + JSON.toJSONString(list));

		Remsg result = wmsHttpEndpoint.createCustomer(list);
		return fixResult(result);
	}

	/**
	 * 采购相关：采购提交，采购关闭，采购退货
	 */
	public ResultBean addPurchase(PurchaseWmsDTO dto) {
		WMSPortType wmsHttpEndpoint = new WMS().getWMSHttpSoap12Endpoint();
		PurchaseWmsInfoDTO info = new PurchaseAssembler().transform(dto);
		log.info("wms添加采购订单信息：" + JSON.toJSONString(info));

		Remsg result = wmsHttpEndpoint.createGetorder(info.getGetorder(), info.getGetorderdets(), null);
		return fixResult(result);
	}

	/**
	 * 出入库相关：S-销售出库单，P-调拨出库单，SR-销售入库单，PR-调拨入库单
	 */
	public ResultBean addOutStock(OutStockWmsDTO dto) {
		WMSPortType wmsHttpEndpoint = new WMS().getWMSHttpSoap12Endpoint();
		OutStockWmsInfoDTO info = new OutStockAssembler().transform(dto);
		log.info("wms添加出库订单信息：" + JSON.toJSONString(info));

		Remsg result = wmsHttpEndpoint.createPutorder(info.getPutorders(), info.getPutorderdets());
		return fixResult(result);
	}

	public ResultBean addMoveStock(MoveStockWmsDTO dto) {
		WMSPortType wmsHttpEndpoint = new WMS().getWMSHttpSoap12Endpoint();
		MoveStockWmsInfoDTO info = new MoveStockAssembler().transform(dto);
		log.info("wms添加移库订单信息：" + JSON.toJSONString(info));

		Remsg result = wmsHttpEndpoint.createMove(info.getGetorder(), info.getGetorderdets());
		return fixResult(result);
	}

	private ResultBean fixResult(Remsg result) {
		ResultBean formatResult = new ResultFormat().getresult(result);
		log.info("wms返回(" + formatResult.getStatus() + ")：" + JSON.toJSONString(result));
		// 返回状态不成功
		if (formatResult == null || formatResult.getStatus() != 1) {
			throw new IllegalArgumentException(formatResult.getMsg());
		}
		return formatResult;
	}
}
