package com.morning.star.retail.controller;

import com.alibaba.fastjson.JSON;
import com.morning.star.retail.dto.PurchaseWmsInfoDTO;
import com.morning.star.retail.facade.OutStockFacade;
import com.morning.star.retail.facade.ReceiptFacade;
import com.morning.star.retail.facade.ThirdServiceFacade;
import com.morning.star.retail.facade.dto.*;
import com.morning.star.retail.facade.dto.out.OutStockDTO;
import com.morning.star.retail.facade.dto.out.OutStockDetailDTO;
import com.morning.star.retail.stock.dto.ReceiptAddDTO;
import com.morning.star.retail.stock.dto.ReceiptItemAddDTO;
import com.morning.star.retail.utils.WebBean;
import com.morning.star.retail.validate.Validate;
import com.wms.*;
import com.wms.bean.ResultBean;
import com.wms.bean.ResultFormat;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * wms服务接口
 *
 * @author kimhuhg
 */
@Api(tags = "提供给WMS的接口")
@RestController
@RequestMapping("/api/wms")
public class WmsController {

	@Autowired
	private ThirdServiceFacade thirdServiceFacade;

	@Autowired
	private ReceiptFacade receiptFacade;
	@Autowired
	private OutStockFacade outStockFacade;

	private static Logger log = LoggerFactory.getLogger(WmsController.class);

	@ApiOperation(value = "wms出库信息回写")
	@RequestMapping(value = "/outStock/add", method = RequestMethod.POST)
	@Validate
	public WebBean outStock(@RequestBody OutStockWmsPullDTO dto) {
		log.info("出库信息回写调用参数：" + JSON.toJSONString(dto));
		ThirdServiceDTO thirdServiceDTO = new ThirdServiceDTO();
		thirdServiceDTO.setRequestApi("/api/wms/outStock/add" + "---" + dto.getType());
		thirdServiceDTO.setRequestParam(JSON.toJSONString(dto));

		OutStockDTO outStockDTO = new OutStockDTO();
		outStockDTO.setOutStockCode(dto.getOcode());
		outStockDTO.setOutWarehouseCode(dto.getWcode());

		List<OutStockDetailDTO> detailList = dto.getDetail().stream().map(e -> {
			OutStockDetailDTO detail = new OutStockDetailDTO();
			detail.setProductCode(e.getPcode());
			detail.setInitialOutNum(e.getCount());
			detail.setRealOutNum(e.getCount());
			detail.setProductCode(e.getPcode());
			return detail;
		}).collect(Collectors.toList());
		outStockDTO.setDetailList(detailList);
		if (dto.getType() != 1 && dto.getType() != 2) {
			outStockDTO.setType(2);
		} else {
			outStockDTO.setType(3);
		}
		outStockFacade.wmsOutStock(outStockDTO);
		thirdServiceFacade.save(thirdServiceDTO);
		return WebBean.ok();
	}

	@ApiOperation(value = "wms入库单回写")
	@RequestMapping(value = "/inStock/add", method = RequestMethod.POST)
	@Validate
	public WebBean<Boolean> inStock(@RequestBody WMSReceiptAddDTO dto) {
		log.info("入库信息回写调用参数：" + JSON.toJSONString(dto));
		ThirdServiceDTO thirdServiceDTO = new ThirdServiceDTO();
		thirdServiceDTO.setRequestApi("/api/wms/inStock/add" + "---" + dto.getType());
		thirdServiceDTO.setRequestParam(JSON.toJSONString(dto));
		thirdServiceFacade.save(thirdServiceDTO);

		if (dto.getType() == 1) {
			ReceiptAddDTO receipt = new ReceiptAddDTO();
			receipt.setReceiptCode(dto.getCode());
			receipt.setTrackCode(dto.getTcode());
			receipt.setSupplierCode(dto.getScode());
			receipt.setWarehouseCode(dto.getWcode());
			receipt.setRemark(dto.getDesc());

			List<ReceiptItemAddDTO> receiptItems = dto.getDetail().stream().map(e -> {
				ReceiptItemAddDTO receiptItem = new ReceiptItemAddDTO();
				receiptItem.setProductCode(e.getPcode());
				receiptItem.setNum(e.getCount());
				receiptItem.setProductionDate(e.getPdate());

				return receiptItem;
			}).collect(Collectors.toList());
			receipt.setItems(receiptItems);
			return WebBean.ok(receiptFacade.purchaseReceipt(receipt));
		}
		return WebBean.ok();
	}

	@ApiOperation(value = "wms盘点库存回写")
	@RequestMapping(value = "/inventory", method = RequestMethod.POST)
	@Validate
	public WebBean<Boolean> inventory(@RequestBody InventoryWmsPullDTO dto) {
		log.info("盘点库存回写调用参数：" + JSON.toJSONString(dto));
		ThirdServiceDTO thirdServiceDTO = new ThirdServiceDTO();
		thirdServiceDTO.setRequestApi("/api/wms/inventory" + "---" + dto.getType());
		thirdServiceDTO.setRequestParam(JSON.toJSONString(dto));
		thirdServiceFacade.save(thirdServiceDTO);

		return WebBean.ok();
	}

	@ApiOperation(value = "wms物料加工回写")
	@RequestMapping(value = "/pack", method = RequestMethod.POST)
	@Validate
	public WebBean<Boolean> pack(@RequestBody PackWmsPullDTO dto) {
		log.info("物料加工回写调用参数：" + JSON.toJSONString(dto));
		ThirdServiceDTO thirdServiceDTO = new ThirdServiceDTO();
		thirdServiceDTO.setRequestApi("/api/wms/pack");
		thirdServiceDTO.setRequestParam(JSON.toJSONString(dto));
		thirdServiceFacade.save(thirdServiceDTO);

		return WebBean.ok();
	}

	@ApiOperation(value = "地推推送")
	@RequestMapping(value = "/groupPush", method = RequestMethod.GET)
	@Validate
	public WebBean<Boolean> groupPush() {
		Getorder getorder = new Getorder();
		getorder.setCustprd(new JAXBElement<>(new QName("custprd"), String.class, "1241145"));

		getorder.setApptype(new JAXBElement<>(new QName("apptype"), String.class, "4"));
		getorder.setCloseflag(new JAXBElement<>(new QName("closeflag"), String.class, "I"));

		getorder.setPurdate(new JAXBElement<>(new QName("purdate"), String.class, "2018-09-10"));
		getorder.setOperater(new JAXBElement<>(new QName("operater"), String.class, "小爱"));
		getorder.setYcstore(new JAXBElement<>(new QName("ycstore"), String.class, "CK100014"));
		getorder.setBilltype(new JAXBElement<>(new QName("billtype"), String.class, "N"));
		getorder.setCustno(new JAXBElement<>(new QName("custno"), String.class, "GS00000039"));
		getorder.setStoreno(new JAXBElement<>(new QName("storeno"), String.class, "01"));

		List<Getorder> list = new ArrayList<>();
		list.add(getorder);

		List<Getorderdet> getorderdets = new ArrayList<>();
		Getorderdet getorderdet = new Getorderdet();
		getorderdet.setCustprd(new JAXBElement<>(new QName("custprd"), String.class, "1241145"));
		getorderdet.setCrowno(1);
		getorderdet.setIncode(new JAXBElement<>(new QName("incode"), String.class, "11010020004"));
		getorderdet.setFname(new JAXBElement<>(new QName("fname"), String.class, "string"));
		getorderdet.setUnit(new JAXBElement<>(new QName("unit"), String.class, "个"));
		getorderdet.setPacks(Double.valueOf(String.valueOf("1")));
		getorderdet.setQty(Double.valueOf(String.valueOf("1")));
		getorderdet.setCustno(new JAXBElement<>(new QName("custno"), String.class, "GS00000039"));
		getorderdets.add(getorderdet);

		PurchaseWmsInfoDTO purchaseWmsInfoDTO = new PurchaseWmsInfoDTO();
		purchaseWmsInfoDTO.setGetorder(list);
		purchaseWmsInfoDTO.setGetorderdets(getorderdets);

		WMSPortType wmsHttpEndpoint = new WMS().getWMSHttpSoap12Endpoint();
		Remsg result = wmsHttpEndpoint.createGetorder(purchaseWmsInfoDTO.getGetorder(), purchaseWmsInfoDTO.getGetorderdets(), null);
		ResultBean formatResult = new ResultFormat().getresult(result);

		log.info("wms添加地推推送信息返回(" + formatResult.getStatus() + ")：" + JSON.toJSONString(result));
		return WebBean.ok();
	}
}
